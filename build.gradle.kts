import org.spongepowered.gradle.task.TaskSortClassMembers

SpongeAPI.project = this
plugins {
    `java-library`
    `maven-publish`
    // The sponge buildscript will apply various plugins that are
    // defined in the buildscript classpath (including plugin versions)
    // that are not listed in Plugins or Versions in SpongeAPI.kt.
    // They are uniquely defined in buildSrc/build.gradle.kts
    id(Plugins.sponge)
    id(Plugins.`event-impl-gen`) version Versions.`event-impl-gen`
}

apply(plugin = Plugins.spongegradle)
apply(plugin = Plugins.spongemeta)
base {
    archivesBaseName = SpongeAPI.name.toLowerCase()
}
val ap by sourceSets.registering {
    compileClasspath += sourceSets.main.get().compileClasspath + sourceSets.main.get().output
}

version = SpongeAPI.version

// Project dependencies
dependencies {
    // Logging
    api(Libs.slf4j)

    // Dependency tied to Minecraft implementation
    api(Libs.guava)
    api(Libs.error_prone)
    api(Libs.gson)
    api(Libs.apache_commons)

    // Only in server
    api(Libs.jsr305)

    // Dependency injection
    api(Libs.guice)

    // High performing cache + guava
    api(Libs.caffeine)
    api(Libs.caffeine_guava) {
        exclude(group = Libs.Groups.guava, module = Libs.Modules.guava)
    }

    // Plugin meta
    api(Libs.plugin_meta)

    // Configurate
    api(Libs.configurate_hocon)
    api(Libs.configurate_gson)
    api(Libs.configurate_yaml)

    // Math + Noise for world gen
    api(Libs.flow_math)
    api(Libs.flow_noise)

    // Asm for class generation (mostly event generation, and dummy object providers
    api(Libs.asm)
}

tasks {

    genEventImpl {
        outputFactory = "org.spongepowered.api.event.SpongeEventFactory"
        include("org/spongepowered/api/event/*/**/*")
        exclude("org/spongepowered/api/event/cause/")
        exclude("org/spongepowered/api/event/filter/")
        exclude("org/spongepowered/api/event/impl/")
    }

    findByName("setupDecompWorkspace")?.apply {
        dependsOn(genEventImpl)
    }

    jar {
        from(ap.get().output)
        manifest {
            attributes("Main-Class" to "org.spongepowered.api.util.InformativeMain")
        }
    }
    val sourceJar by registering(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
        from(sourceSets["ap"].allSource)
    }
    shadowJar {
        archiveClassifier.set("shaded")
        from(ap.get().output)
    }
    val sortClassFields by existing(TaskSortClassMembers::class) {
        SpongeAPI.catalogClasses.forEach {
            add(sourceSets.main.get(), it)
        }
    }
    artifacts {
        archives(sourceJar)
        archives(shadowJar)
    }
}
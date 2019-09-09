import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar


plugins {
    id("org.spongepowered.gradle.sponge.dev")
    id("org.spongepowered.gradle.sponge.deploy")
    id("org.spongepowered.gradle.sort")

    id("org.spongepowered.event-impl-gen") version "5.7.0"
}

base {
    archivesBaseName = "spongeapi"
}
val ap by sourceSets.registering {
    compileClasspath += sourceSets.main.get().compileClasspath + sourceSets.main.get().output
}


version = properties["apiVersion"] as String

// Project dependencies
dependencies {
    api("org.slf4j:slf4j-api:1.7.25")

    // Directly tied to what's available from Minecraft
    api("com.google.guava:guava:25.1-jre")
    api("com.google.errorprone:error_prone_annotations:2.0.15")
    api("com.google.code.gson:gson:2.8.0")
    api("org.apache.commons:commons-lang3:3.5")

    // Only available on the server
    api("com.google.code.findbugs:jsr305:3.0.1")

    // Dependency injection
    api("com.google.inject:guice:4.1.0")

    // High performance cache + guava - shaded guava
    api("com.github.ben-manes.caffeine:caffeine:2.5.4")
    api("com.github.ben-manes.caffeine:guava:2.5.4") {
        exclude(group = "com.google.guava", module = "guava")
    }

    // Plugin meta
    api("org.spongepowered:plugin-meta:0.4.1")

    // Configurate
    api("org.spongepowered:configurate-hocon:3.6")
    api("org.spongepowered:configurate-gson:3.6")
    api("org.spongepowered:configurate-yaml:3.6")

    // Math and noise for world gen
    api("com.flowpowered:flow-math:1.0.3")
    api("com.flowpowered:flow-noise:1.0.1-SNAPSHOT")

    // Asm for dummy object generation
    api("org.ow2.asm:asm:5.2")
}

tasks {
    genEventImpl {
        outputFactory = "org.spongepowered.api.event.SpongeEventFactory"
        include("org/spongepowered/api/event/*/**/*")
        exclude("org/spongepowered/api/event/cause/")
        exclude("org/spongepowered/api/event/filter/")
        exclude("org/spongepowered/api/event/impl/")
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

    val shadowJar by registering(ShadowJar::class) {
        archiveClassifier.set("shaded")
        from(ap.get().output)

    }

    sortClassFields {
        catalogClasses.forEach {
            add(sourceSets.main.name, it)
        }
    }

    artifacts {
        archives(sourceJar)
        archives(shadowJar)
    }
}

val catalogClasses = listOf(    "org.spongepowered.api.CatalogTypes",
        "org.spongepowered.api.advancement.AdvancementTypes",
        "org.spongepowered.api.advancement.criteria.trigger.Triggers",
        "org.spongepowered.api.boss.BossBarColors",
        "org.spongepowered.api.boss.BossBarOverlays",
        "org.spongepowered.api.data.Keys") // TODO - repopulate
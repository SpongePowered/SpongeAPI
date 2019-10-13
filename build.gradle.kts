import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar


plugins {
    org.spongepowered.gradle.sponge.dev
    org.spongepowered.gradle.sponge.deploy
    org.spongepowered.gradle.sort

    id("org.spongepowered.event-impl-gen") version "5.7.0"
}

base {
    archivesBaseName = "spongeapi"
}
val ap by sourceSets.registering {
    compileClasspath += sourceSets.main.get().compileClasspath + sourceSets.main.get().output
}

deploySponge {
    properties["spongeRepoSnapshot"]?.let {
        if (it is String) {
            snapshotRepo = it
        }
    }
    properties["spongeRepoRelease"]?.let {
        if (it is String) {
            releaseRepo = it
        }
    }
}


// Project dependencies
dependencies {
    api("org.slf4j:slf4j-api:1.7.25")

    // Directly tied to what's available from Minecraft
    api("com.google.guava:guava:25.1-jre") {
        exclude(group ="com.google.code.findbugs", module = "jsr305") // We don't want to use jsr305, use checkerframework
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
        exclude(group = "com.google.j2objc", module = "j2objc-annotations")
        exclude(group = "org.codehaus.mojo", module = "animal-sniffer-annotations")

    }
    api("com.google.errorprone:error_prone_annotations:2.1.3")
    api("com.google.code.gson:gson:2.8.0")
    api("org.apache.commons:commons-lang3:3.5")

    // checkers
    api("org.checkerframework:checker-qual:2.8.1")

    // Dependency injection
    api("com.google.inject:guice:4.1.0") {
        exclude(group = "javax.inject", module = "javax.inject")
        exclude(group = "aopalliance", module = "aopalliance")
        exclude(group = "com.google.guava", module = "guava") // We bump the version compared to guice
    }

    // High performance cache + guava - shaded guava
    api("com.github.ben-manes.caffeine:caffeine:2.5.4")
    implementation("com.github.ben-manes.caffeine:guava:2.5.4") {
        exclude(group = "com.google.guava", module = "guava")
    }

    // Plugin meta
    api("org.spongepowered:plugin-meta:0.4.1")

    // Configurate
    api("org.spongepowered:configurate-core:3.6.1") {
        exclude(group = "com.google.guava", module = "guava")
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
    }
    api("org.spongepowered:configurate-hocon:3.6.1") {

    }
    api("org.spongepowered:configurate-gson:3.6.1") {
        exclude(group = "com.google.code.gson", module = "gson") // We have the same version technically, but use the gson we provide.
    }
    api("org.spongepowered:configurate-yaml:3.6.1")

    // Math and noise for world gen
    api("org.spongepowered:math:2.0.0-SNAPSHOT")
    api("org.spongepowered:noise:2.0.0-SNAPSHOT")

    // Asm for dummy object generation
    implementation("org.ow2.asm:asm:6.2")
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
        archives(shadowJar)
    }
}

// TODO - repopulate
val catalogClasses = listOf(    
        "org.spongepowered.api.CatalogTypes",
        "org.spongepowered.api.advancement.AdvancementTypes",
        "org.spongepowered.api.advancement.criteria.trigger.Triggers",
        "org.spongepowered.api.boss.BossBarColors",
        "org.spongepowered.api.boss.BossBarOverlays",
        "org.spongepowered.api.data.Keys",
        "org.spongepowered.api.data.type.PandaGenes"
)


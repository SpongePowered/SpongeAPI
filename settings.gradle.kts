rootProject.name = "SpongeAPI"

pluginManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public") {
            name = "sponge"
        }
    }
    plugins {
        val indraVersion = "3.0.1"
        id("org.spongepowered.gradle.event-impl-gen") version "7.0.0"
        id("org.spongepowered.gradle.sponge.dev") version "2.1.1"
        id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.7"
        id("net.ltgt.errorprone") version "3.0.1"
        id("net.kyori.indra.publishing") version indraVersion
        id("net.kyori.indra.publishing.sonatype") version indraVersion
        id("net.kyori.indra.checkstyle") version indraVersion
        id("net.kyori.indra.crossdoc") version indraVersion
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.3.0")
}

if (JavaVersion.current() < JavaVersion.VERSION_17) {
    throw GradleException("SpongeAPI requires at least Java 17 to build, but you have ${JavaVersion.current()}.")
}

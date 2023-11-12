rootProject.name = "SpongeAPI"

pluginManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public") {
            name = "sponge"
        }
    }
    plugins {
        val indraVersion = "3.1.3"
        id("org.spongepowered.gradle.event-impl-gen") version "7.0.0"
        id("org.spongepowered.gradle.sponge.dev") version "2.1.1"
        id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.7"
        id("net.ltgt.errorprone") version "3.1.0"
        id("net.kyori.indra.publishing") version indraVersion
        id("net.kyori.indra.publishing.sonatype") version indraVersion
        id("net.kyori.indra.checkstyle") version indraVersion
        id("net.kyori.indra.crossdoc") version indraVersion
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.7.0")
}

rootProject.name = "spongeapi"

pluginManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public") {
            name = "sponge"
        }
    }
    plugins {
        val indraVersion = "2.0.4"
        id("org.spongepowered.gradle.event-impl-gen") version "7.0.0"
        id("org.spongepowered.gradle.sponge.dev") version "1.1.0"
        id("org.cadixdev.licenser") version "0.6.0"
        id("org.jetbrains.gradle.plugin.idea-ext") version "1.0"
        id("net.ltgt.errorprone") version "2.0.1"
        id("net.kyori.indra.publishing") version indraVersion
        id("net.kyori.indra.checkstyle") version indraVersion
    }
}

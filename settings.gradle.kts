rootProject.name = "spongeapi"

pluginManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public") {
            name = "sponge"
        }
    }
    plugins {
        id("org.spongepowered.gradle.event-impl-gen") version "7.0.0"
        id("org.cadixdev.licenser") version "0.6.0"
        id("org.jetbrains.gradle.plugin.idea-ext") version "1.0"
        id("net.ltgt.errorprone") version "2.0.1"
    }
}

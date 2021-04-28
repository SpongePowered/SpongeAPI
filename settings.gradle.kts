rootProject.name = "spongeapi"

pluginManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public") {
            name = "sponge"
        }
    }
    plugins {
        id("org.cadixdev.licenser") version "0.6.0"
    }
}

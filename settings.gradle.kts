rootProject.name = "SpongeAPI"

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://repo-new.spongepowered.org/repository/maven-public")
        maven("https://repo.spongepowered.org/maven")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.spongepowered.gradle.")) {
                val version = requested.version ?: "0.11.7-SNAPSHOT"
                useModule("org.spongepowered:SpongeGradle:$version")
            }
            if (requested.id.id == "org.cadixdev.licenser") {
                val version = requested.version ?: "0.5.0"
                useModule("gradle.plugin.org.cadixdev.gradle:licenser:$version")
            }
        }
    }
}

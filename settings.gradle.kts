rootProject.name = "SpongeAPI"

pluginManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.cadixdev.licenser") {
                val version = requested.version ?: "0.5.1"
                useModule("gradle.plugin.org.cadixdev.gradle:licenser:$version")
            }
        }
    }
}

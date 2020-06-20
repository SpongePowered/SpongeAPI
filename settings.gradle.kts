rootProject.name = "SpongeAPI"

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://repo.spongepowered.org/maven")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.spongepowered.gradle.")) {
                val version = requested.version ?: "0.11.5"
                useModule("org.spongepowered:SpongeGradle:$version")
            }
        }
    }
}

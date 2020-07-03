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
            if (requested.id.id.startsWith("net.minecrell.licenser")) {
                val vresion = requested.version ?: "0.4.1"
                useModule("net.minecrell.licenser:licenser:$version")
            }
        }
    }
}

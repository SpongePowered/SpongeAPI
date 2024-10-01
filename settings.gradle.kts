rootProject.name = "SpongeAPI"

pluginManagement {
    repositories {
        maven("https://repo.spongepowered.org/repository/maven-public") {
            name = "sponge"
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.8.0")
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
    }
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    pluginManagement.repositories.forEach(repositories::add)
}

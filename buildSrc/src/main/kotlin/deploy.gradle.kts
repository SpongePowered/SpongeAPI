import org.gradle.api.publish.maven.internal.publication.DefaultMavenPom

plugins {
    `maven-publish`
    `java-library`
}

val base = project.convention.getPlugin(BasePluginConvention::class)

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("mavenJava") {

            val spongeRepo = project.findProperty("spongeRepo")
            spongeRepo?.let { it as String
                repositories {
                    (named(it) as MavenArtifactRepository).apply {
                        credentials {
                            username = project.findProperty("spongeUsername") as String?
                            password = project.findProperty("spongePassword") as String?
                        }
                    }
                }
            }
            artifactId = base.archivesBaseName
            pom {
                name.set(base.archivesBaseName)
                description.set(SpongeAPI.description)
                packaging = "jar"
                url.set(SpongeAPI.url)
                scm {
                    url.set(SpongeAPI.git)
                    connection.set(SpongeAPI.scm)
                    developerConnection.set(SpongeAPI.dev)
                }
                issueManagement {
                    system.set("GitHub Issues")
                    url.set("https://github.com/${SpongeAPI.organization}/${project.name}/issues")
                }
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("http://opensource.org/licenses/MIT")
                        distribution.set("repo")
                    }
                }
            }
        }
    }
}
plugins {
    `java-library`
    `maven-publish`
    id("org.spongepowered.event-impl-gen") version "5.7.0"
    idea
    eclipse
    id("net.minecrell.licenser")
}

repositories {
    maven {
        name = "New Sponge Maven Repo"
        setUrl("https://repo-new.spongepowered.org/repository/maven-public/")
    }
    maven {
        name = "Old Sponge Maven Repo"
        setUrl("https://repo.spongepowered.org/maven")
    }
    maven {
        name = "Sonatype Snapshots"
        setUrl("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

base {
    archivesBaseName = "spongeapi"
}
val ap by sourceSets.registering {
    compileClasspath += sourceSets.main.get().compileClasspath + sourceSets.main.get().output
}

// Project dependencies
dependencies {

    // Directly tied to what's available from Minecraft
    api("org.apache.logging.log4j:log4j-api:2.8.1")
    api("com.google.guava:guava:21.0") {
        exclude(group ="com.google.code.findbugs", module = "jsr305") // We don't want to use jsr305, use checkerframework
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
        exclude(group = "com.google.j2objc", module = "j2objc-annotations")
        exclude(group = "org.codehaus.mojo", module = "animal-sniffer-annotations")
    }
    api("com.google.code.gson:gson:2.8.0")

    api("net.kyori:adventure-api:4.0.0-SNAPSHOT")
    api("net.kyori:adventure-text-serializer-gson:4.0.0-SNAPSHOT")
    api("net.kyori:adventure-text-serializer-legacy:4.0.0-SNAPSHOT")
    api("net.kyori:adventure-text-serializer-plain:4.0.0-SNAPSHOT")

    // Dependency injection
    api("com.google.inject:guice:4.1.0") {
        exclude(group = "javax.inject", module = "javax.inject")
        exclude(group = "com.google.guava", module = "guava") // We bump the version compared to guice
    }

    // High performance cache + guava - shaded guava
    api("com.github.ben-manes.caffeine:caffeine:2.8.4")
    implementation("com.github.ben-manes.caffeine:guava:2.8.4") {
        exclude(group = "com.google.guava", module = "guava")
    }

    // Plugin spi, includes plugin-meta
    api("org.spongepowered:plugin-spi:0.1.1-SNAPSHOT")

    // Configurate
    api("org.spongepowered:configurate-core:3.6.1") {
        exclude(group = "com.google.guava", module = "guava")
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
    }
    api("org.spongepowered:configurate-hocon:3.6.1") {

    }
    api("org.spongepowered:configurate-gson:3.6.1") {
        exclude(group = "com.google.code.gson", module = "gson") // We have the same version technically, but use the gson we provide.
    }
    api("org.spongepowered:configurate-yaml:3.6.1")

    // Math and noise for world gen
    api("org.spongepowered:math:2.0.0-SNAPSHOT")
    api("org.spongepowered:noise:2.0.0-SNAPSHOT")

    testImplementation("junit:junit:4.12")
    testImplementation("org.hamcrest:hamcrest-library:1.3")
    testImplementation("org.mockito:mockito-core:2.8.47")
}
val spongeSnapshotRepo: String? by project
val spongeReleaseRepo: String? by project
tasks {
    genEventImpl {
        outputFactory = "org.spongepowered.api.event.SpongeEventFactory"
        include("org/spongepowered/api/event/*/**/*")
        exclude("org/spongepowered/api/event/cause/")
        exclude("org/spongepowered/api/event/filter/")
        exclude("org/spongepowered/api/event/impl/")
        exclude("org/spongepowered/api/event/lifecycle/EngineLifecycleEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/LifecycleEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/ProvideServiceEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterBuilderEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterCatalogEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterCatalogRegistryEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterCommandEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterFactoryEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterWorldEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/StartingEngineEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/StartedEngineEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/StoppingEngineEvent.java")
        inclusiveAnnotations = setOf("org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod")
    }

    jar {
        from(ap.get().output)
        manifest {
            attributes("Main-Class" to "org.spongepowered.api.util.InformativeMain")
        }
    }

    compileJava {
        options.apply {
            compilerArgs.addAll(listOf("-Xlint:all", "-Xlint:-path", "-parameters"))
            isDeprecation = false
            encoding = "UTF-8"
        }
    }

    javadoc {
        options {
            encoding = "UTF-8"
            charset("UTF-8")
            isFailOnError = false
            (this as? StandardJavadocDocletOptions)?.apply {
                links?.addAll(
                        mutableListOf(
                                "http://www.slf4j.org/apidocs/",
                                "https://google.github.io/guava/releases/21.0/api/docs/",
                                "https://google.github.io/guice/api-docs/4.1/javadoc/",
                                "https://zml2008.github.io/configurate/configurate-core/apidocs/",
                                "https://zml2008.github.io/configurate/configurate-hocon/apidocs/",
                                "https://docs.oracle.com/javase/8/docs/api/"
                        )
                )
                addStringOption("-quiet")
            }
        }
    }

//
//    val shadowJar by registering(ShadowJar::class) {
//        archiveClassifier.set("shaded")
//        from(ap.get().output)
//
//    }

//    sortClassFields {
//        sortClasses.forEach {
//            add(sourceSets.main.name, it)
//        }
//    }

//    artifacts {
//        archives(shadowJar)
//    }

    withType<PublishToMavenRepository>().configureEach {
        onlyIf {
            (repository == publishing.repositories["GitHubPackages"] &&
                    !publication.version.endsWith("-SNAPSHOT")) ||
                    (!spongeSnapshotRepo.isNullOrBlank()
                            && !spongeReleaseRepo.isNullOrBlank()
                            && repository == publishing.repositories["spongeRepo"]
                            && publication == publishing.publications["sponge"])

        }
    }
}
val javadocJar by tasks.registering(Jar::class) {
    group = "build"
    archiveClassifier.set("javadoc")
    from(tasks.javadoc)
}

val sourceJar by tasks.registering(Jar::class) {
    group = "build"
    archiveClassifier.set("sources")
    from(sourceSets["main"].allJava)
}
base {
    archivesBaseName = "spongeapi"
}
val organization: String by project
val projectUrl: String by project
val projectDescription: String by project
license {
    (this as ExtensionAware).extra.apply {
        this["name"] = "SpongeAPI"
        this["organization"] = organization
        this["url"] = projectUrl
    }
    header = file("HEADER.txt")

    include("**/*.java")
    newLine = false
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            this.setUrl(uri("https://maven.pkg.github.com/spongepowered/SpongeAPI"))
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
        // Set by the build server
        maven {
            name = "spongeRepo"
            val repoUrl = if ((version as String).endsWith("-SNAPSHOT")) spongeSnapshotRepo else spongeReleaseRepo
            repoUrl?.apply {
                setUrl(uri(this))
            }
            val spongeUsername: String? by project
            val spongePassword: String? by project
            credentials {
                username = spongeUsername ?: System.getenv("ORG_GRADLE_PROJECT_spongeUsername")
                password = spongePassword ?: System.getenv("ORG_GRADLE_PROJECT_spongePassword")
            }
        }
    }
    publications {
        register("sponge", MavenPublication::class) {
            from(components["java"])

            artifact(javadocJar.get())
            artifact(sourceJar.get())
            pom {
                artifactId = project.name.toLowerCase()
                this.name.set(project.name)
                this.description.set(projectDescription)
                this.url.set(projectUrl)

                licenses {
                    license {
                        this.name.set("MIT")
                        this.url.set("https://opensource.org/licenses/MIT")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/SpongePowered/SpongeAPI.git")
                    developerConnection.set("scm:git:ssh://github.com/SpongePowered/SpongeAPI.git")
                    this.url.set(projectUrl)
                }
            }
        }
    }

}

// TODO - repopulate
val sortClasses = listOf(
        "org.spongepowered.api.CatalogTypes",
        "org.spongepowered.api.advancement.AdvancementTypes",
        "org.spongepowered.api.advancement.criteria.trigger.Triggers",
        "org.spongepowered.api.block.BlockTypes",
        "org.spongepowered.api.block.entity.BlockEntityTypes",
        "org.spongepowered.api.boss.BossBarColors",
        "org.spongepowered.api.boss.BossBarOverlays",
        "org.spongepowered.api.command.parameter.CommonParameters",
        "org.spongepowered.api.command.parameter.managed.standard.CatalogedValueParameters",
        "org.spongepowered.api.data.Keys",
        "org.spongepowered.api.data.persistence.DataFormats",
        "org.spongepowered.api.data.persistence.DataTranslators",
        "org.spongepowered.api.data.type.ArmorMaterials",
        "org.spongepowered.api.data.type.ArtTypes",
        "org.spongepowered.api.data.type.BannerPatternShapes",
        "org.spongepowered.api.data.type.BodyParts",
        "org.spongepowered.api.data.type.CatTypes",
        "org.spongepowered.api.data.type.ChestAttachmentTypes",
        "org.spongepowered.api.data.type.DyeColors",
        "org.spongepowered.api.data.type.ComparatorModes",
        "org.spongepowered.api.data.type.FoxTypes",
        "org.spongepowered.api.data.type.HandTypes",
        "org.spongepowered.api.data.type.Hinges",
        "org.spongepowered.api.data.type.HorseColors",
        "org.spongepowered.api.data.type.HorseStyles",
        "org.spongepowered.api.data.type.InstrumentTypes",
        "org.spongepowered.api.data.type.LlamaTypes",
        "org.spongepowered.api.data.type.MooshroomTypes",
        "org.spongepowered.api.data.type.NotePitches",
        "org.spongepowered.api.data.type.PandaGenes",
        "org.spongepowered.api.data.type.ParrotTypes",
        "org.spongepowered.api.data.type.PhantomPhases",
        "org.spongepowered.api.data.type.PickupRules",
        "org.spongepowered.api.data.type.PortionTypes",
        "org.spongepowered.api.data.type.Professions",
        "org.spongepowered.api.data.type.RabbitTypes",
        "org.spongepowered.api.data.type.RaidStatuses",
        "org.spongepowered.api.data.type.RailDirections",
        "org.spongepowered.api.data.type.SkinParts",
        "org.spongepowered.api.data.type.SlabPortions",
        "org.spongepowered.api.data.type.SpellTypes",
        "org.spongepowered.api.data.type.StairShapes",
        "org.spongepowered.api.data.type.StructureModes",
        "org.spongepowered.api.data.type.Surfaces",
        "org.spongepowered.api.data.type.ToolTypes",
        "org.spongepowered.api.data.type.TropicalFishShapes",
        "org.spongepowered.api.data.type.VillagerTypes",
        "org.spongepowered.api.data.type.WireAttachmentTypes",
        "org.spongepowered.api.data.type.WoodTypes",
        "org.spongepowered.api.effect.particle.ParticleOptions",
        "org.spongepowered.api.effect.particle.ParticleTypes",
        "org.spongepowered.api.effect.potion.PotionEffectTypes",
        "org.spongepowered.api.effect.sound.SoundCategories",
        "org.spongepowered.api.effect.sound.SoundTypes",
        "org.spongepowered.api.effect.sound.music.MusicDiscs",
        "org.spongepowered.api.entity.EntityTypes",
        "org.spongepowered.api.entity.ai.goal.GoalExecutorTypes",
        "org.spongepowered.api.entity.ai.goal.GoalTypes",
        "org.spongepowered.api.entity.living.monster.boss.dragon.phase.DragonPhaseTypes",
        "org.spongepowered.api.entity.living.player.chat.ChatVisibilities",
        "org.spongepowered.api.entity.living.player.gamemode.GameModes",
        "org.spongepowered.api.entity.selector.SelectorTypes",
        "org.spongepowered.api.event.cause.EventContextKeys",
        "org.spongepowered.api.event.cause.entity.damage.DamageModifierTypes",
        "org.spongepowered.api.event.cause.entity.damage.DamageTypes",
        "org.spongepowered.api.event.cause.entity.damage.source.DamageSources",
        "org.spongepowered.api.event.cause.entity.dismount.DismountTypes",
        "org.spongepowered.api.event.cause.entity.teleport.TeleportTypes",
        "org.spongepowered.api.item.FireworkShapes",
        "org.spongepowered.api.item.ItemTypes",
        "org.spongepowered.api.item.enchantment.EnchantmentTypes",
        "org.spongepowered.api.item.inventory.ContainerTypes",
        "org.spongepowered.api.item.inventory.InventoryKeys",
        "org.spongepowered.api.item.inventory.menu.ClickTypes",
        "org.spongepowered.api.item.potion.PotionTypes",
        "org.spongepowered.api.scoreboard.CollisionRules",
        "org.spongepowered.api.scoreboard.Visibilities",
        "org.spongepowered.api.scoreboard.criteria.Criteria",
        "org.spongepowered.api.scoreboard.displayslot.DisplaySlots",
        "org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayModes",
        "org.spongepowered.api.service.economy.transaction.TransactionTypes",
        "org.spongepowered.api.state.BooleanStateProperties",
        "org.spongepowered.api.state.EnumStateProperties",
        "org.spongepowered.api.state.IntegerStateProperties",
        "org.spongepowered.api.statistic.StatisticCategories",
        "org.spongepowered.api.statistic.Statistics",
        "org.spongepowered.api.util.TypeTokens",
        "org.spongepowered.api.util.ban.BanTypes",
        "org.spongepowered.api.util.rotation.Rotations",
        "org.spongepowered.api.world.BlockChangeFlags",
        "org.spongepowered.api.world.ChunkRegenerateFlags",
        "org.spongepowered.api.world.HeightTypes",
        "org.spongepowered.api.world.LightTypes",
        "org.spongepowered.api.world.SerializationBehaviors",
        "org.spongepowered.api.world.WorldArchetypes",
        "org.spongepowered.api.world.biome.BiomeTypes",
        "org.spongepowered.api.world.chunk.ChunkStates",
        "org.spongepowered.api.world.difficulty.Difficulties",
        "org.spongepowered.api.world.dimension.DimensionTypes",
        "org.spongepowered.api.world.gamerule.GameRules",
        "org.spongepowered.api.world.gen.GeneratorTypes",
        "org.spongepowered.api.world.gen.feature.Features",
        "org.spongepowered.api.world.schematic.PaletteTypes",
        "org.spongepowered.api.world.teleport.TeleportHelperFilters",
        "org.spongepowered.api.world.weather.Weathers"
)


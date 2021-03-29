plugins {
    `java-library`
    `maven-publish`
    id("org.spongepowered.gradle.event-impl-gen") version "7.0.0"
    eclipse
    id("org.cadixdev.licenser")
    checkstyle
}

repositories {
    maven("https://repo.spongepowered.org/repository/maven-public/") {
        name = "sponge"
    }
}

base {
    archivesBaseName = "spongeapi"
}

checkstyle {
    toolVersion = "8.41"
    configDirectory.set(layout.projectDirectory)
    configProperties = mutableMapOf<String, Any>(
            "severity" to "error"
    )
}

tasks.withType(Checkstyle::class) {
    // checkstyle is source-only and does not cross files, we don't need compiled classes
    classpath = objects.fileCollection()
}

java {
    withSourcesJar()
    withJavadocJar()
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

    // Adventure
    api(platform("net.kyori:adventure-bom:4.7.0"))
    api("net.kyori:adventure-api") {
        exclude(group = "org.checkerframework", module = "checker-qual")
    }
    api("net.kyori:adventure-text-serializer-gson") {
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.code.gson", module = "gson")
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-serializer-legacy") {
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-serializer-plain") {
        exclude(group = "org.checkerframework", module = "checker-qual")
        exclude(group = "net.kyori", module = "adventure-api")
    }

    // Dependency injection
    api("com.google.inject:guice:5.0.1") {
        exclude(group ="com.google.code.findbugs", module = "jsr305") // We don't want to use jsr305, use checkerframework
        exclude(group = "javax.inject", module = "javax.inject")
        exclude(group = "com.google.guava", module = "guava") // We use an older version than Guice does
    }

    // High performance cache + guava - shaded guava
    api("com.github.ben-manes.caffeine:caffeine:2.9.0") {
        exclude(group= "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }
    implementation("com.github.ben-manes.caffeine:guava:2.9.0") {
        exclude(group = "com.google.guava", module = "guava")
        exclude(group= "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }

    // Plugin spi, includes plugin-meta
    api("org.spongepowered:plugin-spi:0.1.4-SNAPSHOT")

    // Configurate
    api(platform("org.spongepowered:configurate-bom:4.0.0"))
    api("org.spongepowered:configurate-core") {
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
    }
    api("org.spongepowered:configurate-hocon") {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group= "org.checkerframework", module = "checker-qual")

    }
    api("org.spongepowered:configurate-gson") {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "com.google.code.gson", module = "gson") // We have the same version technically, but use the gson we provide.
        exclude(group= "org.checkerframework", module = "checker-qual")
    }
    api("org.spongepowered:configurate-yaml") {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group= "org.checkerframework", module = "checker-qual")
    }
    api("org.spongepowered:configurate-extra-guice") {
        exclude(group = "com.google.inject", module = "guice")
    }

    // Math library
    api("org.spongepowered:math:2.0.0-SNAPSHOT")

    testImplementation(platform("org.junit:junit-bom:5.7.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.mockito:mockito-core:3.7.7")
}
val spongeSnapshotRepo: String? by project
val spongeReleaseRepo: String? by project
tasks {
    genEventImpl {
        sourceCompatibility = "1.8"

        outputFactory = "org.spongepowered.api.event.SpongeEventFactory"
        include("org/spongepowered/api/event/*/**/*")
        exclude("org/spongepowered/api/event/action/InteractEvent.java")
        exclude("org/spongepowered/api/event/cause/")
        exclude("org/spongepowered/api/event/entity/AffectEntityEvent.java")
        exclude("org/spongepowered/api/event/filter/")
        exclude("org/spongepowered/api/event/impl/")
        exclude("org/spongepowered/api/event/lifecycle/ProvideServiceEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterBuilderEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterRegistryEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterRegistryValueEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterCommandEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterFactoryEvent.java")
        exclude("org/spongepowered/api/event/lifecycle/RegisterWorldEvent.java")
        inclusiveAnnotations = setOf("org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod")
        exclusiveAnnotations = setOf("org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod")
    }

    jar {
        from(ap.get().output)
        manifest {
            attributes("Main-Class" to "org.spongepowered.api.util.InformativeMain")
            attributes("Specification-Vendor" to "SpongePowered")
            attributes("Specification-Title" to "SpongeAPI")
            attributes("Specification-Version" to project.version)
            System.getenv()["GIT_COMMIT"]?.apply { attributes("Git-Commit" to this) }
            System.getenv()["GIT_BRANCH"]?.apply { attributes("Git-Branch" to this) }
        }
    }

    withType(JavaCompile::class).configureEach {
        options.apply {
            compilerArgs.addAll(listOf("-Xlint:all", "-Xlint:-path", "-parameters"))
            isDeprecation = false
            encoding = "UTF-8"
        }
    }

    javadoc {
        options {
            encoding = "UTF-8"
            source = "1.8"
            charset("UTF-8")
            (this as? StandardJavadocDocletOptions)?.apply {
                links(
                    "https://logging.apache.org/log4j/log4j-2.8.1/log4j-api/apidocs/",
                    "https://google.github.io/guice/api-docs/5.0.1/javadoc/",
                    "https://guava.dev/releases/21.0/api/docs/",
                    "https://configurate.aoeu.xyz/4.0.0/apidocs/",
                    "https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.0/",
                    "https://docs.oracle.com/javase/8/docs/api/"
                )
                sequenceOf("api", "key", "text-serializer-gson", "text-serializer-legacy", "text-serializer-plain").forEach {
                    links("https://jd.adventure.kyori.net/$it/4.7.0/")
                }
                addStringOption("-quiet")
            }
        }
    }

    withType(JavaCompile::class).configureEach {
        // Use the --release option when available to ensure we only use Java 8 classes
        if (JavaVersion.current().isJava10Compatible) {
            options.release.set(8)
        }
    }

    test {
        useJUnitPlatform()
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

val sortClasses = listOf(
        "org.spongepowered.api.advancement.AdvancementTypes",
        "org.spongepowered.api.advancement.criteria.trigger.Triggers",
        "org.spongepowered.api.adventure.ResolveOperations",
        "org.spongepowered.api.block.BlockTypes",
        "org.spongepowered.api.block.entity.BlockEntityTypes",
        "org.spongepowered.api.block.transaction.Operations",
        "org.spongepowered.api.command.command.registrar.tree.ClientCompletionKeys",
        "org.spongepowered.api.command.command.selector.SelectorSortAlgorithms",
        "org.spongepowered.api.command.command.selector.SelectorTypes",
        "org.spongepowered.api.command.parameter.managed.clientcompletion.ClientCompletionTypes",
        "org.spongepowered.api.command.parameter.managed.standard.ResourceKeyedValueParameters",
        "org.spongepowered.api.data.Keys",
        "org.spongepowered.api.data.persistence.DataFormats",
        "org.spongepowered.api.data.type.ArmorMaterials",
        "org.spongepowered.api.data.type.ArtTypes",
        "org.spongepowered.api.data.type.AttachmentSurfaces",
        "org.spongepowered.api.data.type.BannerPatternShapes",
        "org.spongepowered.api.data.type.BoatTypes",
        "org.spongepowered.api.data.type.BodyParts",
        "org.spongepowered.api.data.type.CatTypes",
        "org.spongepowered.api.data.type.ChestAttachmentTypes",
        "org.spongepowered.api.data.type.ComparatorModes",
        "org.spongepowered.api.data.type.DoorHinges",
        "org.spongepowered.api.data.type.DyeColors",
        "org.spongepowered.api.data.type.FoxTypes",
        "org.spongepowered.api.data.type.HandPreferences",
        "org.spongepowered.api.data.type.HandTypes",
        "org.spongepowered.api.data.type.HorseColors",
        "org.spongepowered.api.data.type.HorseStyles",
        "org.spongepowered.api.data.type.InstrumentTypes",
        "org.spongepowered.api.data.type.ItemTiers",
        "org.spongepowered.api.data.type.LlamaTypes",
        "org.spongepowered.api.data.type.MatterTypes",
        "org.spongepowered.api.data.type.MooshroomTypes",
        "org.spongepowered.api.data.type.NotePitches",
        "org.spongepowered.api.data.type.PandaGenes",
        "org.spongepowered.api.data.type.ParrotTypes",
        "org.spongepowered.api.data.type.PhantomPhases",
        "org.spongepowered.api.data.type.PickupRules",
        "org.spongepowered.api.data.type.PistonTypes",
        "org.spongepowered.api.data.type.PortionTypes",
        "org.spongepowered.api.data.type.ProfessionTypes",
        "org.spongepowered.api.data.type.RabbitTypes",
        "org.spongepowered.api.data.type.RaidStatuses",
        "org.spongepowered.api.data.type.RailDirections",
        "org.spongepowered.api.data.type.SkinParts",
        "org.spongepowered.api.data.type.SlabPortions",
        "org.spongepowered.api.data.type.SpellTypes",
        "org.spongepowered.api.data.type.StairShapes",
        "org.spongepowered.api.data.type.StructureModes",
        "org.spongepowered.api.data.type.TropicalFishShapes",
        "org.spongepowered.api.data.type.VillagerTypes",
        "org.spongepowered.api.data.type.WireAttachmentTypes",
        "org.spongepowered.api.datapack.DataPackTypes",
        "org.spongepowered.api.effect.particle.ParticleOptions",
        "org.spongepowered.api.effect.particle.ParticleTypes",
        "org.spongepowered.api.effect.potion.PotionEffectTypes",
        "org.spongepowered.api.effect.sound.SoundTypes",
        "org.spongepowered.api.effect.sound.music.MusicDiscs",
        "org.spongepowered.api.entity.EntityTypes",
        "org.spongepowered.api.entity.ai.goal.GoalExecutorTypes",
        "org.spongepowered.api.entity.ai.goal.GoalTypes",
        "org.spongepowered.api.entity.attribute.AttributeOperations",
        "org.spongepowered.api.entity.attribute.type.AttributeTypes",
        "org.spongepowered.api.entity.living.monster.boss.dragon.phase.DragonPhaseTypes",
        "org.spongepowered.api.entity.living.player.chat.ChatVisibilities",
        "org.spongepowered.api.entity.living.player.gamemode.GameModes",
        "org.spongepowered.api.event.EventContextKeys",
        "org.spongepowered.api.event.cause.entity.DismountTypes",
        "org.spongepowered.api.event.cause.entity.MovementTypes",
        "org.spongepowered.api.event.cause.entity.SpawnTypes",
        "org.spongepowered.api.event.cause.entity.damage.DamageModifierTypes",
        "org.spongepowered.api.event.cause.entity.damage.DamageTypes",
        "org.spongepowered.api.event.cause.entity.damage.source.DamageSources",
        "org.spongepowered.api.fluid.FluidTypes",
        "org.spongepowered.api.item.FireworkShapes",
        "org.spongepowered.api.item.ItemTypes",
        "org.spongepowered.api.item.enchantment.EnchantmentTypes",
        "org.spongepowered.api.item.inventory.ContainerTypes",
        "org.spongepowered.api.item.inventory.equipment.EquipmentGroups",
        "org.spongepowered.api.item.inventory.equipment.EquipmentTypes",
        "org.spongepowered.api.item.inventory.menu.ClickTypes",
        "org.spongepowered.api.item.inventory.query.QueryTypes",
        "org.spongepowered.api.item.potion.PotionTypes",
        "org.spongepowered.api.map.color.MapColorTypes",
        "org.spongepowered.api.map.color.MapShades",
        "org.spongepowered.api.map.decoration.MapDecorationTypes",
        "org.spongepowered.api.map.decoration.orientation.MapDecorationOrientations",
        "org.spongepowered.api.network.EngineConnectionTypes",
        "org.spongepowered.api.placeholder.PlaceholderParsers",
        "org.spongepowered.api.registry.RegistryTypes",
        "org.spongepowered.api.scheduler.TaskPriorities",
        "org.spongepowered.api.scoreboard.CollisionRules",
        "org.spongepowered.api.scoreboard.Visibilities",
        "org.spongepowered.api.scoreboard.criteria.Criteria",
        "org.spongepowered.api.scoreboard.displayslot.DisplaySlots",
        "org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayModes",
        "org.spongepowered.api.service.ban.BanTypes",
        "org.spongepowered.api.service.economy.account.AccountDeletionResultTypes",
        "org.spongepowered.api.service.economy.transaction.TransactionTypes",
        "org.spongepowered.api.state.BooleanStateProperties",
        "org.spongepowered.api.state.EnumStateProperties",
        "org.spongepowered.api.state.IntegerStateProperties",
        "org.spongepowered.api.statistic.StatisticCategories",
        "org.spongepowered.api.statistic.Statistics",
        "org.spongepowered.api.util.TypeTokens",
        "org.spongepowered.api.util.mirror.Mirrors",
        "org.spongepowered.api.util.orientation.Orientations",
        "org.spongepowered.api.util.rotation.Rotations",
        "org.spongepowered.api.world.BlockChangeFlags",
        "org.spongepowered.api.world.ChunkRegenerateFlags",
        "org.spongepowered.api.world.HeightTypes",
        "org.spongepowered.api.world.LightTypes",
        "org.spongepowered.api.world.WorldTypeEffects",
        "org.spongepowered.api.world.WorldTypes",
        "org.spongepowered.api.world.biome.Biomes",
        "org.spongepowered.api.world.biome.BiomeSamplers",
        "org.spongepowered.api.world.chunk.ChunkStates",
        "org.spongepowered.api.world.difficulty.Difficulties",
        "org.spongepowered.api.world.gamerule.GameRules",
        "org.spongepowered.api.world.generation.structure.Structures",
        "org.spongepowered.api.world.portal.PortalTypes",
        "org.spongepowered.api.world.schematic.PaletteTypes",
        "org.spongepowered.api.world.teleport.TeleportHelperFilters",
        "org.spongepowered.api.world.weather.WeatherTypes"
)


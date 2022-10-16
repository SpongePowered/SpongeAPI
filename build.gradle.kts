import net.ltgt.gradle.errorprone.errorprone

plugins {
    eclipse
    id("org.spongepowered.gradle.sponge.dev")
    id("net.kyori.indra.checkstyle")
    id("net.kyori.indra.crossdoc")
    id("net.kyori.indra.publishing")
    id("net.kyori.indra.publishing.sonatype")
    id("org.spongepowered.gradle.event-impl-gen")
    id("org.jetbrains.gradle.plugin.idea-ext")
    id("net.ltgt.errorprone")
}

repositories {
    maven("https://repo.spongepowered.org/repository/maven-public/") {
        name = "sponge"
    }
}

val ap by sourceSets.registering {
    compileClasspath += sourceSets.main.get().compileClasspath + sourceSets.main.get().output
}

// Project dependencies
val adventureVersion: String by project
val configurateVersion: String by project
val log4jVersion: String by project
val mathVersion: String by project
dependencies {
    val caffeineVersion: String by project
    val errorproneVersion: String by project
    val junitVersion: String by project
    val mockitoVersion: String by project
    val pluginSpiVersion: String by project
    val slf4jVersion: String by project

    // Directly tied to what's available from Minecraft
    api("org.apache.logging.log4j:log4j-api:$log4jVersion")
    api("com.google.guava:guava:21.0") {
        exclude(group ="com.google.code.findbugs", module = "jsr305") // We don't want to use jsr305, use checkerframework
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
        exclude(group = "com.google.j2objc", module = "j2objc-annotations")
        exclude(group = "org.codehaus.mojo", module = "animal-sniffer-annotations")
    }
    api("com.google.code.gson:gson:2.8.0")
    api("org.slf4j:slf4j-api:$slf4jVersion") // technically only included starting in 1.17, but we'll backport the same version for consistency

    // Adventure
    api(platform("net.kyori:adventure-bom:$adventureVersion"))
    api("net.kyori:adventure-api")
    api("net.kyori:adventure-text-serializer-gson") {
        exclude(group = "com.google.code.gson", module = "gson")
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-serializer-legacy") {
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-serializer-plain") {
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-minimessage") {
        exclude(group = "net.kyori", module = "adventure-api")
    }
    api("net.kyori:adventure-text-logger-slf4j") {
        exclude(group = "net.kyori", module = "adventure-api")
        exclude(group = "org.slf4j", module = "slf4j-api")
    }

    // Dependency injection
    api("com.google.inject:guice:5.0.1") {
        exclude(group ="com.google.code.findbugs", module = "jsr305") // We don't want to use jsr305, use checkerframework
        exclude(group = "javax.inject", module = "javax.inject")
        exclude(group = "com.google.guava", module = "guava") // We use an older version than Guice does
    }

    // High performance cache + guava - shaded guava
    api("com.github.ben-manes.caffeine:caffeine:$caffeineVersion") {
        exclude(group= "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }
    implementation("com.github.ben-manes.caffeine:guava:$caffeineVersion") {
        exclude(group = "com.google.guava", module = "guava")
        exclude(group= "org.checkerframework", module = "checker-qual")
        exclude(group = "com.google.errorprone", module = "error_prone_annotations")
    }

    // Plugin spi, includes plugin-meta
    api("org.spongepowered:plugin-spi:$pluginSpiVersion")

    // Configurate
    api(platform("org.spongepowered:configurate-bom:$configurateVersion"))
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

    // Compile-time static analysis
    compileOnly("com.google.errorprone:error_prone_annotations:$errorproneVersion")
    errorprone("com.google.errorprone:error_prone_core:$errorproneVersion")

    // Math library
    api("org.spongepowered:math:$mathVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
}
tasks {
    genEventImpl {
        sourceCompatibility = "1.8"
        destinationDir = project.layout.buildDirectory.dir("generated/event-factory").get().asFile

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
            if (!indraGit.isPresent) {
              throw InvalidUserDataException("SpongeAPI must be built as a Git checkout, rather than through a zip/tar export")
            }
            indraGit.applyVcsInformationToManifest(this)
        }
    }

    withType(JavaCompile::class).configureEach {
        options.apply {
            compilerArgs.addAll(listOf("-Xlint:-path"))
            isDeprecation = false
        }
    }

    javadoc {
        options {
            (this as? StandardJavadocDocletOptions)?.apply {
                links(
                    "https://logging.apache.org/log4j/log4j-$log4jVersion/log4j-api/apidocs/",
                    "https://google.github.io/guice/api-docs/5.0.1/javadoc/",
                    "https://guava.dev/releases/21.0/api/docs/",
                    "https://configurate.aoeu.xyz/$configurateVersion/apidocs/",
                    "https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.0/",
                    "https://jd.spongepowered.org/math/$mathVersion"
                )
                sequenceOf("api", "key", "text-serializer-gson", "text-serializer-legacy", "text-serializer-plain").forEach {
                    links("https://jd.adventure.kyori.net/$it/$adventureVersion/")
                }
                addStringOption("-quiet")
            }
        }
    }

    withType(JavaCompile::class).configureEach {
        options.errorprone {
            disable("FutureReturnValueIgnored") // this check doesn't handle CompletableFuture properly
            disable("EqualsGetClass") // conflicts with IntelliJ defaults
            disable("MissingSummary") // TODO: Re-enable this check once Javadoc is in a better state
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
}

idea {
    if (project != null) {
        (project as ExtensionAware).extensions["settings"].run {
            require(this is ExtensionAware)

            this.extensions.getByType(org.jetbrains.gradle.ext.ActionDelegationConfig::class).run {
                delegateBuildRunToGradle = false
                testRunner = org.jetbrains.gradle.ext.ActionDelegationConfig.TestRunner.PLATFORM
            }
            this.extensions.getByType(org.jetbrains.gradle.ext.TaskTriggersConfig::class).run {
                beforeBuild(tasks.genEventImpl)
            }
        }
    }
}

eclipse {
    synchronizationTasks(tasks.genEventImpl)
}

val organization: String by project
val projectUrl: String by project
val projectDescription: String by project

spongeConvention {
    repository("SpongeAPI") {
        ci(true)
        publishing(true)
    }
    mitLicense()

    licenseParameters {
        this["name"] = "SpongeAPI"
        this["organization"] = organization
        this["url"] = projectUrl
    }
}

indra {
    val checkstyleVersion: String by project

    javaVersions {
        testWith(8, 11, 17)
    }
    checkstyle(checkstyleVersion)

    configurePublications {
        artifactId = project.name.toLowerCase()
        pom {
            this.url.set(projectUrl)
            this.description.set(projectDescription)
        }
    }
}

indraCrossdoc {
    baseUrl(providers.gradleProperty("javadocPublishRoot"))
    nameBasedDocumentationUrlProvider {
        lowercaseProjectName.set(true)
    }
}

spotless {
    java {
        endWithNewline()
        indentWithSpaces(4)
        trimTrailingWhitespace()
        toggleOffOn("@formatter:off", "@formatter:on")
        formatAnnotations()
        importOrderFile(rootProject.file("extra/eclipse/sponge_eclipse.importorder"))
    }
    kotlinGradle {
        endWithNewline()
        indentWithSpaces(4)
        trimTrailingWhitespace()
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

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar


plugins {
    id("org.spongepowered.gradle.sponge.dev")
    id("org.spongepowered.gradle.sponge.deploy")
    id("org.spongepowered.gradle.sort")

    id("org.spongepowered.event-impl-gen") version "5.7.0"
}

base {
    archivesBaseName = "spongeapi"
}
val ap by sourceSets.registering {
    compileClasspath += sourceSets.main.get().compileClasspath + sourceSets.main.get().output
}

// Project dependencies
dependencies {
    api("org.slf4j:slf4j-api:1.7.25")

    // Directly tied to what's available from Minecraft
    api("com.google.guava:guava:25.1-jre") {
        exclude(group ="com.google.code.findbugs", module = "jsr305") // We don't want to use jsr305, use checkerframework
        exclude(group = "org.checkerframework", module = "checker-qual") // We use our own version
        exclude(group = "com.google.j2objc", module = "j2objc-annotations")
        exclude(group = "org.codehaus.mojo", module = "animal-sniffer-annotations")

    }
    api("com.google.errorprone:error_prone_annotations:2.1.3")
    api("com.google.code.gson:gson:2.8.0")
    api("org.apache.commons:commons-lang3:3.5")

    // checkers
    api("org.checkerframework:checker-qual:2.8.1")

    // Dependency injection
    api("com.google.inject:guice:4.1.0") {
        exclude(group = "javax.inject", module = "javax.inject")
        exclude(group = "aopalliance", module = "aopalliance")
        exclude(group = "com.google.guava", module = "guava") // We bump the version compared to guice
    }

    // High performance cache + guava - shaded guava
    api("com.github.ben-manes.caffeine:caffeine:2.5.4")
    implementation("com.github.ben-manes.caffeine:guava:2.5.4") {
        exclude(group = "com.google.guava", module = "guava")
    }

    // Plugin meta
    api("org.spongepowered:plugin-meta:0.4.1")

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

    // Asm for dummy object generation
    implementation("org.ow2.asm:asm:6.2")
}

tasks {
    genEventImpl {
        outputFactory = "org.spongepowered.api.event.SpongeEventFactory"
        include("org/spongepowered/api/event/*/**/*")
        exclude("org/spongepowered/api/event/cause/")
        exclude("org/spongepowered/api/event/filter/")
        exclude("org/spongepowered/api/event/impl/")
        inclusiveAnnotations = setOf("org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod")
    }

    jar {
        from(ap.get().output)
        manifest {
            attributes("Main-Class" to "org.spongepowered.api.util.InformativeMain")
        }
    }

    val shadowJar by registering(ShadowJar::class) {
        archiveClassifier.set("shaded")
        from(ap.get().output)

    }

    sortClassFields {
        catalogClasses.forEach {
            add(sourceSets.main.name, it)
        }
    }

    artifacts {
        archives(shadowJar)
    }
}

// TODO - repopulate
val catalogClasses = listOf(
        "org.spongepowered.api.CatalogTypes",
        "org.spongepowered.api.advancement.AdvancementTypes",
        "org.spongepowered.api.advancement.criteria.trigger.Triggers",
        "org.spongepowered.api.block.BlockTypes",
        "org.spongepowered.api.block.entity.BlockEntityTypes",
        "org.spongepowered.api.boss.BossBarColors",
        "org.spongepowered.api.boss.BossBarOverlays",
        "org.spongepowered.api.command.parameter.managed.standard.CatalogedValueParameters",
        "org.spongepowered.api.data.Keys",
        "org.spongepowered.api.data.persistence.DataFormats",
        "org.spongepowered.api.data.persistence.DataTranslators",
        "org.spongepowered.api.data.type.ArmorTypes",
        "org.spongepowered.api.data.type.ArtTypes",
        "org.spongepowered.api.data.type.BannerPatternShapes",
        "org.spongepowered.api.data.type.BodyParts",
        "org.spongepowered.api.data.type.CatTypes",
        "org.spongepowered.api.data.type.ChestAttachmentTypes",
        "org.spongepowered.api.data.type.DyeColors",
        "org.spongepowered.api.data.type.ComparatorTypes",
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
        "org.spongepowered.api.entity.ai.GoalExecutorTypes",
        "org.spongepowered.api.entity.ai.goal.GoalTypes",
        "org.spongepowered.api.entity.living.monster.boss.dragon.phase.DragonPhaseTypes",
        "org.spongepowered.api.entity.living.player.gamemode.GameModes",
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
        "org.spongepowered.api.text.chat.ChatTypes",
        "org.spongepowered.api.text.chat.ChatVisibilities",
        "org.spongepowered.api.text.format.TextColors",
        "org.spongepowered.api.text.selector.SelectorTypes",
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


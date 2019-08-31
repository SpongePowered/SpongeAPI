import org.gradle.api.Project

/**
 * Root configuration file containing all dependency strings, version strings, etc. that will
 * be accessible throughout the buildscripts. All are constants and potentially shared
 * objects.
 */
object SpongeAPI {
    const val group = Libs.Groups.sponge
    const val organization = "SpongePowered"
    const val version = Versions.api
    const val name = "SpongeAPI"
    const val url = "https://www.spongepowered.org"
    const val description = "A Minecraft: Java Edition plugin API"
    const val git = "https://github.com/$organization/$name"
    const val scm = "scm:git:https://github.com/$organization/$name.git"
    const val dev = "scm:git:git@github.com:$organization/$name.git"
    val buildNumber = System.getenv()["BUILD_NUMBER"]
    val `ciSystem` = System.getenv()["CI_SYSTEM"]
    val `git-commit` = System.getenv()["GIT_COMMIT"]
    val `git-branch` = System.getenv()["GIT_BRANCH"]
    var project: Project? = null

    val catalogClasses = listOf(
            "org.spongepowered.api.CatalogTypes",
            "org.spongepowered.api.advancement.AdvancementTypes",
            "org.spongepowered.api.advancement.criteria.trigger.Triggers",
            "org.spongepowered.api.boss.BossBarColors",
            "org.spongepowered.api.boss.BossBarOverlays",
            "org.spongepowered.api.data.key.Keys",
            "org.spongepowered.api.data.type.ArmorTypes",
            "org.spongepowered.api.data.type.Arts",
            "org.spongepowered.api.data.type.BannerPatternShapes",
            "org.spongepowered.api.data.type.BigMushroomTypes",
            "org.spongepowered.api.data.type.BodyParts",
            "org.spongepowered.api.data.type.BrickTypes",
            "org.spongepowered.api.data.type.Careers",
            "org.spongepowered.api.data.type.CoalTypes",
            "org.spongepowered.api.data.type.ComparatorTypes",
            "org.spongepowered.api.data.type.CookedFishes",
            "org.spongepowered.api.data.type.DirtTypes",
            "org.spongepowered.api.data.type.DisguisedBlockTypes",
            "org.spongepowered.api.data.type.DoublePlantTypes",
            "org.spongepowered.api.data.type.DyeColors",
            "org.spongepowered.api.data.type.Fishes",
            "org.spongepowered.api.data.type.GoldenApples",
            "org.spongepowered.api.data.type.Hinges",
            "org.spongepowered.api.data.type.HorseColors",
            "org.spongepowered.api.data.type.HorseStyles",
            "org.spongepowered.api.data.type.InstrumentTypes",
            "org.spongepowered.api.data.type.LogAxes",
            "org.spongepowered.api.data.type.NotePitches",
            "org.spongepowered.api.data.type.OcelotTypes",
            "org.spongepowered.api.data.type.ParrotVariants",
            "org.spongepowered.api.data.type.PickupRules",
            "org.spongepowered.api.data.type.PistonTypes",
            "org.spongepowered.api.data.type.PlantTypes",
            "org.spongepowered.api.data.type.PortionTypes",
            "org.spongepowered.api.data.type.PrismarineTypes",
            "org.spongepowered.api.data.type.Professions",
            "org.spongepowered.api.data.type.QuartzTypes",
            "org.spongepowered.api.data.type.RabbitTypes",
            "org.spongepowered.api.data.type.RailDirections",
            "org.spongepowered.api.data.type.SandstoneTypes",
            "org.spongepowered.api.data.type.SandTypes",
            "org.spongepowered.api.data.type.ShrubTypes",
            "org.spongepowered.api.data.type.SkinParts",
            "org.spongepowered.api.data.type.SkullTypes",
            "org.spongepowered.api.data.type.SlabTypes",
            "org.spongepowered.api.data.type.StairShapes",
            "org.spongepowered.api.data.type.StoneTypes",
            "org.spongepowered.api.data.type.ToolTypes",
            "org.spongepowered.api.data.type.TreeTypes",
            "org.spongepowered.api.data.type.WallTypes",
            "org.spongepowered.api.data.type.WireAttachmentTypes",
            "org.spongepowered.api.block.BlockTypes",
            "org.spongepowered.api.block.tileentity.TileEntityTypes",
            "org.spongepowered.api.block.trait.BooleanTraits",
            "org.spongepowered.api.block.trait.EnumTraits",
            "org.spongepowered.api.block.trait.IntegerTraits",
            "org.spongepowered.api.block.trait.EnumTraits",
            "org.spongepowered.api.data.persistence.DataFormats",
            "org.spongepowered.api.effect.particle.ParticleOptions",
            "org.spongepowered.api.effect.particle.ParticleTypes",
            "org.spongepowered.api.effect.potion.PotionEffectTypes",
            "org.spongepowered.api.effect.sound.SoundTypes",
            "org.spongepowered.api.entity.EntityTypes",
            "org.spongepowered.api.entity.ai.task.AITaskTypes",
            "org.spongepowered.api.entity.ai.GoalTypes",
            "org.spongepowered.api.entity.living.complex.dragon.phase.EnderDragonPhaseTypes",
            "org.spongepowered.api.entity.living.player.gamemode.GameModes",
            "org.spongepowered.api.event.cause.EventContextKeys",
            "org.spongepowered.api.event.cause.entity.damage.DamageModifierTypes",
            "org.spongepowered.api.event.cause.entity.damage.DamageTypes",
            "org.spongepowered.api.event.cause.entity.damage.source.DamageSources",
            "org.spongepowered.api.event.cause.entity.dismount.DismountTypes",
            "org.spongepowered.api.event.cause.entity.health.HealingTypes",
            "org.spongepowered.api.event.cause.entity.health.HealthModifierTypes",
            "org.spongepowered.api.event.cause.entity.health.source.HealingSources",
            "org.spongepowered.api.event.cause.entity.spawn.SpawnTypes",
            "org.spongepowered.api.event.cause.entity.teleport.TeleportTypes",
            "org.spongepowered.api.extra.fluid.FluidTypes",
            "org.spongepowered.api.item.enchantment.EnchantmentTypes",
            "org.spongepowered.api.item.FireworkShapes",
            "org.spongepowered.api.item.ItemTypes",
            "org.spongepowered.api.item.inventory.equipment.EquipmentTypes",
            "org.spongepowered.api.item.inventory.query.QueryOperationTypes",
            "org.spongepowered.api.item.potion.PotionTypes",
            "org.spongepowered.api.scoreboard.CollisionRules",
            "org.spongepowered.api.scoreboard.Visibilities",
            "org.spongepowered.api.scoreboard.critieria.Criteria",
            "org.spongepowered.api.scoreboard.displayslot.DisplaySlots",
            "org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayModes",
            "org.spongepowered.api.service.economy.transaction.TransactionTypes",
            "org.spongepowered.api.statistic.Statistics",
            "org.spongepowered.api.statistic.StatisticTypes",
            "org.spongepowered.api.text.chat.ChatTypes",
            "org.spongepowered.api.text.chat.ChatVisibilities",
            "org.spongepowered.api.text.format.TextColors",
            "org.spongepowered.api.text.format.TextStyles",
            "org.spongepowered.api.text.selector.SelectorTypes",
            "org.spongepowered.api.util.TypeTokens",
            "org.spongepowered.api.util.ban.BanTypes",
            "org.spongepowered.api.util.rotation.Rotations",
            "org.spongepowered.api.world.biome.BiomeTypes",
            "org.spongepowered.api.world.BlockChangeFlags",
            "org.spongepowered.api.world.DimensionTypes",
            "org.spongepowered.api.world.GeneratorTypes",
            "org.spongepowered.api.world.difficulty.Difficulties",
            "org.spongepowered.api.world.gen.type.BiomeTreeTypes",
            "org.spongepowered.api.world.gen.type.MushroomTypes",
            "org.spongepowered.api.world.gen.PopulatorObjects",
            "org.spongepowered.api.world.gen.PopulatorTypes",
            "org.spongepowered.api.world.gen.WorldGeneratorModifiers",
            "org.spongepowered.api.world.teleport.TeleportHelperFilters",
            "org.spongepowered.api.world.weather.Weathers",
            "org.spongepowered.api.util.TypeTokens",
            "org.spongepowered.api.item.recipe.crafting.CraftingRecipes"
    )
}

object Repo {

    const val sponge = "https://repo.spongepowered.org/maven"
}

object Plugins {
    /**
     * The general SpongeGradle plugin that applies the default repos and such.
     */
    const val spongeGradleId = "${Libs.Groups.sponge}.plugin"
    const val licenser = "net.minecrell.licenser"
    const val shadow = "com.github.johnrengelman.shadow"
    /**
     * Basically the sponge.gradle.kts script that applies the defaults, such as
     * licensor, checkstyle, javadoc, etc.
     */
    const val sponge = "sponge"
    /**
     * The deploy.gradle.kts script that applies deploy related tasks.
     * It also sets up a few extra properties if they're available.
     */
    const val deploy = "deploy"
    /**
     * The special plugin to apply sortClassFields task
     */
    const val spongegradle = "org.spongepowered.gradle"
    /**
     * The special plugin that generates the sponge meta file
     */
    const val spongemeta = "org.spongepowered.meta"
    /**
     * Generates SpongeEventFactory
     */
    const val `event-impl-gen` = "org.spongepowered.event-impl-gen"
}


object Libs {

    const val slf4j = "${Groups.slf4j}:${Modules.slf4j}:${Versions.slf4j}"
    const val guava = "${Groups.guava}:${Modules.guava}:${Versions.guava}"
    const val error_prone = "${Groups.errorProne}:${Modules.errorProne}:${Versions.errorprone}"
    const val gson = "${Groups.gson}:${Modules.gson}:${Versions.gson}"
    const val apache_commons = "${Groups.apache_commons}:${Modules.apache_commons}:${Versions.apache_commons}"
    const val jsr305 = "${Groups.findBugs}:${Modules.jsr305}:${Versions.jsr305}"
    const val guice = "${Groups.guice}:${Modules.guice}:${Versions.guice}"
    const val caffeine = "${Groups.caffeine}:${Modules.caffeine}:${Versions.caffeine}"
    const val caffeine_guava = "${Groups.caffeine}:${Modules.guava}:${Versions.caffeine}"
    const val plugin_meta = "${Groups.sponge}:${Modules.plugin_meta}:${Versions.plugin_meta}"
    const val configurate_hocon = "${Groups.sponge}:${Modules.configurate_hocon}:${Versions.configurate}"
    const val configurate_gson = "${Groups.sponge}:${Modules.configurate_gson}:${Versions.configurate}"
    const val configurate_yaml = "${Groups.sponge}:${Modules.configurate_yaml}:${Versions.configurate}"
    const val flow_math = "${Groups.flowpowered}:${Modules.flow_math}:${Versions.`flow-math`}"
    const val flow_noise = "${Groups.flowpowered}:${Modules.flow_noise}:${Versions.`flow-noise`}"
    const val asm = "${Groups.asm}:${Modules.asm}:${Versions.asm}"

    object Test {
        const val junit = "${Groups.junit}:${Modules.junit}:${Versions.Test.junit}"
        const val hamcrest = "${Groups.hamcrest}:${Modules.hamcrest}:${Versions.Test.hamcrest}"
        const val mockito = "${Groups.mockito}:${Modules.mockito}:${Versions.Test.mockito}"
    }

    object Groups {
        const val google = "com.google"
        const val guava = "com.google.guava"
        const val gson = "com.google.code.gson"
        const val sponge = "org.spongepowered"
        const val junit = "junit"
        const val asm = "org.ow2.asm"
        const val hamcrest = "org.hamcrest"
        const val mockito = "org.mockito"
        const val slf4j = "org.slf4j"
        const val errorProne = "$google.errorprone"
        const val apache = "org.apache"
        const val `apache_commons` = "$apache.commons"
        const val findBugs = "$google.code.findbugs"
        const val guice = "$google.inject"
        const val caffeine = "com.github.ben-manes.caffeine"
        const val flowpowered = "com.flowpowered"

    }

    object Modules {
        const val slf4j = "slf4j-api"
        const val junit = "junit"
        const val hamcrest = "hamcrest-library"
        const val guava = "guava"
        const val errorProne = "error_prone_annotations"
        const val gson = "gson"
        const val spongeAPI = "spongeapi"
        const val spongecommon = "spongecommon"
        const val spongeforge = "spongeforge"
        const val spongevanilla = "spongevanilla"
        const val asm = "asm"
        const val mockito = "mockito-core"
        const val apache_commons = "commons-lang3"
        const val jsr305 = "jsr305"
        const val guice = "guice"
        const val caffeine = "caffeine"
        const val plugin_meta = "plugin-meta"
        const val configurate = "configurate"
        const val configurate_hocon = "$configurate-hocon"
        const val configurate_gson = "$configurate-gson"
        const val configurate_yaml = "$configurate-yaml"
        const val flow_math = "flow-math"
        const val flow_noise = "flow-noise"
    }
}

object Versions {
    const val api = "7.2.0-SNAPSHOT"
    const val guava = "21.0"
    const val gson = "2.8.0"
    const val errorprone = "2.0.15"
    const val slf4j = "1.7.25"
    const val caffeine = "2.5.4"
    const val configurate = "3.6"
    const val `flow-math` = "1.0.3"
    const val `flow-noise` = "1.0.1-SNAPSHOT"
    const val `event-impl-gen` = "5.7.0"
    const val spongegradle = "0.8.1"
    const val asm = "5.2"
    const val licenser = "0.4.1"
    const val shadow = "5.0.0"
    const val apache_commons = "3.5"
    const val jsr305 = "3.0.1"
    const val guice = "4.1.0"
    const val plugin_meta = "0.4.1"

    object Test {
        const val junit = "4.12"
        const val hamcrest = "1.3"
        const val mockito = "2.8.47"
    }
}
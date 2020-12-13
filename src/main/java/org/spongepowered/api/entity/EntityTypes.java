/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.entity;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.explosive.EndCrystal;
import org.spongepowered.api.entity.explosive.fused.PrimedTNT;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.LeashKnot;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.animal.Bee;
import org.spongepowered.api.entity.living.animal.Cat;
import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.animal.Fox;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Panda;
import org.spongepowered.api.entity.living.animal.Parrot;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.PolarBear;
import org.spongepowered.api.entity.living.animal.Rabbit;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.animal.Turtle;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.animal.cow.Cow;
import org.spongepowered.api.entity.living.animal.cow.Mooshroom;
import org.spongepowered.api.entity.living.animal.horse.Donkey;
import org.spongepowered.api.entity.living.animal.horse.Horse;
import org.spongepowered.api.entity.living.animal.horse.Mule;
import org.spongepowered.api.entity.living.animal.horse.SkeletonHorse;
import org.spongepowered.api.entity.living.animal.horse.ZombieHorse;
import org.spongepowered.api.entity.living.animal.horse.llama.Llama;
import org.spongepowered.api.entity.living.animal.horse.llama.TraderLlama;
import org.spongepowered.api.entity.living.aquatic.Dolphin;
import org.spongepowered.api.entity.living.aquatic.Squid;
import org.spongepowered.api.entity.living.aquatic.fish.Pufferfish;
import org.spongepowered.api.entity.living.aquatic.fish.school.Cod;
import org.spongepowered.api.entity.living.aquatic.fish.school.Salmon;
import org.spongepowered.api.entity.living.aquatic.fish.school.TropicalFish;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.golem.Shulker;
import org.spongepowered.api.entity.living.golem.SnowGolem;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Endermite;
import org.spongepowered.api.entity.living.monster.Ghast;
import org.spongepowered.api.entity.living.monster.Giant;
import org.spongepowered.api.entity.living.monster.Phantom;
import org.spongepowered.api.entity.living.monster.Silverfish;
import org.spongepowered.api.entity.living.monster.Strider;
import org.spongepowered.api.entity.living.monster.Vex;
import org.spongepowered.api.entity.living.monster.Zoglin;
import org.spongepowered.api.entity.living.monster.boss.Wither;
import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.monster.guardian.ElderGuardian;
import org.spongepowered.api.entity.living.monster.guardian.Guardian;
import org.spongepowered.api.entity.living.monster.hoglin.Hoglin;
import org.spongepowered.api.entity.living.monster.piglin.Piglin;
import org.spongepowered.api.entity.living.monster.piglin.PiglinBrute;
import org.spongepowered.api.entity.living.monster.raider.Ravager;
import org.spongepowered.api.entity.living.monster.raider.Witch;
import org.spongepowered.api.entity.living.monster.raider.illager.Pillager;
import org.spongepowered.api.entity.living.monster.raider.illager.Vindicator;
import org.spongepowered.api.entity.living.monster.raider.illager.spellcaster.Evoker;
import org.spongepowered.api.entity.living.monster.raider.illager.spellcaster.Illusioner;
import org.spongepowered.api.entity.living.monster.skeleton.Skeleton;
import org.spongepowered.api.entity.living.monster.skeleton.Stray;
import org.spongepowered.api.entity.living.monster.skeleton.WitherSkeleton;
import org.spongepowered.api.entity.living.monster.slime.MagmaCube;
import org.spongepowered.api.entity.living.monster.slime.Slime;
import org.spongepowered.api.entity.living.monster.spider.CaveSpider;
import org.spongepowered.api.entity.living.monster.spider.Spider;
import org.spongepowered.api.entity.living.monster.zombie.Drowned;
import org.spongepowered.api.entity.living.monster.zombie.Husk;
import org.spongepowered.api.entity.living.monster.zombie.Zombie;
import org.spongepowered.api.entity.living.monster.zombie.ZombieVillager;
import org.spongepowered.api.entity.living.monster.zombie.ZombifiedPiglin;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.trader.Villager;
import org.spongepowered.api.entity.living.trader.WanderingTrader;
import org.spongepowered.api.entity.projectile.Egg;
import org.spongepowered.api.entity.projectile.EnderPearl;
import org.spongepowered.api.entity.projectile.EvokerFangs;
import org.spongepowered.api.entity.projectile.ExperienceBottle;
import org.spongepowered.api.entity.projectile.EyeOfEnder;
import org.spongepowered.api.entity.projectile.FishingBobber;
import org.spongepowered.api.entity.projectile.LlamaSpit;
import org.spongepowered.api.entity.projectile.Potion;
import org.spongepowered.api.entity.projectile.ShulkerBullet;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.arrow.Arrow;
import org.spongepowered.api.entity.projectile.arrow.SpectralArrow;
import org.spongepowered.api.entity.projectile.arrow.Trident;
import org.spongepowered.api.entity.projectile.explosive.FireworkRocket;
import org.spongepowered.api.entity.projectile.explosive.WitherSkull;
import org.spongepowered.api.entity.projectile.explosive.fireball.DragonFireball;
import org.spongepowered.api.entity.projectile.explosive.fireball.ExplosiveFireball;
import org.spongepowered.api.entity.projectile.explosive.fireball.SmallFireball;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.CommandBlockMinecart;
import org.spongepowered.api.entity.vehicle.minecart.FurnaceMinecart;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.entity.vehicle.minecart.SpawnerMinecart;
import org.spongepowered.api.entity.vehicle.minecart.TNTMinecart;
import org.spongepowered.api.entity.vehicle.minecart.carrier.ChestMinecart;
import org.spongepowered.api.entity.vehicle.minecart.carrier.HopperMinecart;
import org.spongepowered.api.entity.weather.LightningBolt;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all possible {@link EntityType}s available in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class EntityTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<EntityType<AreaEffectCloud>> AREA_EFFECT_CLOUD = EntityTypes.key(ResourceKey.sponge("area_effect_cloud"));

    public static final DefaultedRegistryReference<EntityType<ArmorStand>> ARMOR_STAND = EntityTypes.key(ResourceKey.sponge("armor_stand"));

    public static final DefaultedRegistryReference<EntityType<Arrow>> ARROW = EntityTypes.key(ResourceKey.sponge("arrow"));

    public static final DefaultedRegistryReference<EntityType<Bat>> BAT = EntityTypes.key(ResourceKey.sponge("bat"));

    public static final DefaultedRegistryReference<EntityType<Bee>> BEE = EntityTypes.key(ResourceKey.sponge("bee"));

    public static final DefaultedRegistryReference<EntityType<Blaze>> BLAZE = EntityTypes.key(ResourceKey.sponge("blaze"));

    public static final DefaultedRegistryReference<EntityType<Boat>> BOAT = EntityTypes.key(ResourceKey.sponge("boat"));

    public static final DefaultedRegistryReference<EntityType<Cat>> CAT = EntityTypes.key(ResourceKey.sponge("cat"));

    public static final DefaultedRegistryReference<EntityType<CaveSpider>> CAVE_SPIDER = EntityTypes.key(ResourceKey.sponge("cave_spider"));

    public static final DefaultedRegistryReference<EntityType<ChestMinecart>> CHEST_MINECART = EntityTypes.key(ResourceKey.sponge("chest_minecart"));

    public static final DefaultedRegistryReference<EntityType<Chicken>> CHICKEN = EntityTypes.key(ResourceKey.sponge("chicken"));

    public static final DefaultedRegistryReference<EntityType<Cod>> COD = EntityTypes.key(ResourceKey.sponge("cod"));

    public static final DefaultedRegistryReference<EntityType<CommandBlockMinecart>> COMMAND_BLOCK_MINECART = EntityTypes.key(ResourceKey.sponge("command_block_minecart"));

    public static final DefaultedRegistryReference<EntityType<Cow>> COW = EntityTypes.key(ResourceKey.sponge("cow"));

    public static final DefaultedRegistryReference<EntityType<Creeper>> CREEPER = EntityTypes.key(ResourceKey.sponge("creeper"));

    public static final DefaultedRegistryReference<EntityType<Dolphin>> DOLPHIN = EntityTypes.key(ResourceKey.sponge("dolphin"));

    public static final DefaultedRegistryReference<EntityType<Donkey>> DONKEY = EntityTypes.key(ResourceKey.sponge("donkey"));

    public static final DefaultedRegistryReference<EntityType<DragonFireball>> DRAGON_FIREBALL = EntityTypes.key(ResourceKey.sponge("dragon_fireball"));

    public static final DefaultedRegistryReference<EntityType<Drowned>> DROWNED = EntityTypes.key(ResourceKey.sponge("drowned"));

    public static final DefaultedRegistryReference<EntityType<Egg>> EGG = EntityTypes.key(ResourceKey.sponge("egg"));

    public static final DefaultedRegistryReference<EntityType<ElderGuardian>> ELDER_GUARDIAN = EntityTypes.key(ResourceKey.sponge("elder_guardian"));

    public static final DefaultedRegistryReference<EntityType<EndCrystal>> END_CRYSTAL = EntityTypes.key(ResourceKey.sponge("end_crystal"));

    public static final DefaultedRegistryReference<EntityType<EnderDragon>> ENDER_DRAGON = EntityTypes.key(ResourceKey.sponge("ender_dragon"));

    public static final DefaultedRegistryReference<EntityType<EnderPearl>> ENDER_PEARL = EntityTypes.key(ResourceKey.sponge("ender_pearl"));

    public static final DefaultedRegistryReference<EntityType<Enderman>> ENDERMAN = EntityTypes.key(ResourceKey.sponge("enderman"));

    public static final DefaultedRegistryReference<EntityType<Endermite>> ENDERMITE = EntityTypes.key(ResourceKey.sponge("endermite"));

    public static final DefaultedRegistryReference<EntityType<Evoker>> EVOKER = EntityTypes.key(ResourceKey.sponge("evoker"));

    public static final DefaultedRegistryReference<EntityType<EvokerFangs>> EVOKER_FANGS = EntityTypes.key(ResourceKey.sponge("evoker_fangs"));

    public static final DefaultedRegistryReference<EntityType<ExperienceBottle>> EXPERIENCE_BOTTLE = EntityTypes.key(ResourceKey.sponge("experience_bottle"));

    public static final DefaultedRegistryReference<EntityType<ExperienceOrb>> EXPERIENCE_ORB = EntityTypes.key(ResourceKey.sponge("experience_orb"));

    public static final DefaultedRegistryReference<EntityType<EyeOfEnder>> EYE_OF_ENDER = EntityTypes.key(ResourceKey.sponge("eye_of_ender"));

    public static final DefaultedRegistryReference<EntityType<FallingBlock>> FALLING_BLOCK = EntityTypes.key(ResourceKey.sponge("falling_block"));

    public static final DefaultedRegistryReference<EntityType<ExplosiveFireball>> FIREBALL = EntityTypes.key(ResourceKey.sponge("fireball"));

    public static final DefaultedRegistryReference<EntityType<FireworkRocket>> FIREWORK_ROCKET = EntityTypes.key(ResourceKey.sponge("firework_rocket"));

    public static final DefaultedRegistryReference<EntityType<FishingBobber>> FISHING_BOBBER = EntityTypes.key(ResourceKey.sponge("fishing_bobber"));

    public static final DefaultedRegistryReference<EntityType<Fox>> FOX = EntityTypes.key(ResourceKey.sponge("fox"));

    public static final DefaultedRegistryReference<EntityType<FurnaceMinecart>> FURNACE_MINECART = EntityTypes.key(ResourceKey.sponge("furnace_minecart"));

    public static final DefaultedRegistryReference<EntityType<Ghast>> GHAST = EntityTypes.key(ResourceKey.sponge("ghast"));

    public static final DefaultedRegistryReference<EntityType<Giant>> GIANT = EntityTypes.key(ResourceKey.sponge("giant"));

    public static final DefaultedRegistryReference<EntityType<Guardian>> GUARDIAN = EntityTypes.key(ResourceKey.sponge("guardian"));

    public static final DefaultedRegistryReference<EntityType<Hoglin>> HOGLIN = EntityTypes.key(ResourceKey.sponge("hoglin"));

    public static final DefaultedRegistryReference<EntityType<HopperMinecart>> HOPPER_MINECART = EntityTypes.key(ResourceKey.sponge("hopper_minecart"));

    public static final DefaultedRegistryReference<EntityType<Horse>> HORSE = EntityTypes.key(ResourceKey.sponge("horse"));

    public static final DefaultedRegistryReference<EntityType<Husk>> HUSK = EntityTypes.key(ResourceKey.sponge("husk"));

    public static final DefaultedRegistryReference<EntityType<Illusioner>> ILLUSIONER = EntityTypes.key(ResourceKey.sponge("illusioner"));

    public static final DefaultedRegistryReference<EntityType<IronGolem>> IRON_GOLEM = EntityTypes.key(ResourceKey.sponge("iron_golem"));

    public static final DefaultedRegistryReference<EntityType<Item>> ITEM = EntityTypes.key(ResourceKey.sponge("item"));

    public static final DefaultedRegistryReference<EntityType<ItemFrame>> ITEM_FRAME = EntityTypes.key(ResourceKey.sponge("item_frame"));

    public static final DefaultedRegistryReference<EntityType<LeashKnot>> LEASH_KNOT = EntityTypes.key(ResourceKey.sponge("leash_knot"));

    public static final DefaultedRegistryReference<EntityType<LightningBolt>> LIGHTNING_BOLT = EntityTypes.key(ResourceKey.sponge("lightning_bolt"));

    public static final DefaultedRegistryReference<EntityType<Llama>> LLAMA = EntityTypes.key(ResourceKey.sponge("llama"));

    public static final DefaultedRegistryReference<EntityType<LlamaSpit>> LLAMA_SPIT = EntityTypes.key(ResourceKey.sponge("llama_spit"));

    public static final DefaultedRegistryReference<EntityType<MagmaCube>> MAGMA_CUBE = EntityTypes.key(ResourceKey.sponge("magma_cube"));

    public static final DefaultedRegistryReference<EntityType<Minecart>> MINECART = EntityTypes.key(ResourceKey.sponge("minecart"));

    public static final DefaultedRegistryReference<EntityType<Mooshroom>> MOOSHROOM = EntityTypes.key(ResourceKey.sponge("mooshroom"));

    public static final DefaultedRegistryReference<EntityType<Mule>> MULE = EntityTypes.key(ResourceKey.sponge("mule"));

    public static final DefaultedRegistryReference<EntityType<Ocelot>> OCELOT = EntityTypes.key(ResourceKey.sponge("ocelot"));

    public static final DefaultedRegistryReference<EntityType<Painting>> PAINTING = EntityTypes.key(ResourceKey.sponge("painting"));

    public static final DefaultedRegistryReference<EntityType<Panda>> PANDA = EntityTypes.key(ResourceKey.sponge("panda"));

    public static final DefaultedRegistryReference<EntityType<Parrot>> PARROT = EntityTypes.key(ResourceKey.sponge("parrot"));

    public static final DefaultedRegistryReference<EntityType<Phantom>> PHANTOM = EntityTypes.key(ResourceKey.sponge("phantom"));

    public static final DefaultedRegistryReference<EntityType<Pig>> PIG = EntityTypes.key(ResourceKey.sponge("pig"));

    public static final DefaultedRegistryReference<EntityType<Piglin>> PIGLIN = EntityTypes.key(ResourceKey.sponge("piglin"));

    public static final DefaultedRegistryReference<EntityType<PiglinBrute>> PIGLIN_BRUTE = EntityTypes.key(ResourceKey.sponge("piglin_brute"));

    public static final DefaultedRegistryReference<EntityType<Pillager>> PILLAGER = EntityTypes.key(ResourceKey.sponge("pillager"));

    public static final DefaultedRegistryReference<EntityType<Player>> PLAYER = EntityTypes.key(ResourceKey.sponge("player"));

    public static final DefaultedRegistryReference<EntityType<PolarBear>> POLAR_BEAR = EntityTypes.key(ResourceKey.sponge("polar_bear"));

    public static final DefaultedRegistryReference<EntityType<Potion>> POTION = EntityTypes.key(ResourceKey.sponge("potion"));

    public static final DefaultedRegistryReference<EntityType<Pufferfish>> PUFFERFISH = EntityTypes.key(ResourceKey.sponge("pufferfish"));

    public static final DefaultedRegistryReference<EntityType<Rabbit>> RABBIT = EntityTypes.key(ResourceKey.sponge("rabbit"));

    public static final DefaultedRegistryReference<EntityType<Ravager>> RAVAGER = EntityTypes.key(ResourceKey.sponge("ravager"));

    public static final DefaultedRegistryReference<EntityType<Salmon>> SALMON = EntityTypes.key(ResourceKey.sponge("salmon"));

    public static final DefaultedRegistryReference<EntityType<Sheep>> SHEEP = EntityTypes.key(ResourceKey.sponge("sheep"));

    public static final DefaultedRegistryReference<EntityType<Shulker>> SHULKER = EntityTypes.key(ResourceKey.sponge("shulker"));

    public static final DefaultedRegistryReference<EntityType<ShulkerBullet>> SHULKER_BULLET = EntityTypes.key(ResourceKey.sponge("shulker_bullet"));

    public static final DefaultedRegistryReference<EntityType<Silverfish>> SILVERFISH = EntityTypes.key(ResourceKey.sponge("silverfish"));

    public static final DefaultedRegistryReference<EntityType<Skeleton>> SKELETON = EntityTypes.key(ResourceKey.sponge("skeleton"));

    public static final DefaultedRegistryReference<EntityType<SkeletonHorse>> SKELETON_HORSE = EntityTypes.key(ResourceKey.sponge("skeleton_horse"));

    public static final DefaultedRegistryReference<EntityType<Slime>> SLIME = EntityTypes.key(ResourceKey.sponge("slime"));

    public static final DefaultedRegistryReference<EntityType<SmallFireball>> SMALL_FIREBALL = EntityTypes.key(ResourceKey.sponge("small_fireball"));

    public static final DefaultedRegistryReference<EntityType<SnowGolem>> SNOW_GOLEM = EntityTypes.key(ResourceKey.sponge("snow_golem"));

    public static final DefaultedRegistryReference<EntityType<Snowball>> SNOWBALL = EntityTypes.key(ResourceKey.sponge("snowball"));

    public static final DefaultedRegistryReference<EntityType<SpawnerMinecart>> SPAWNER_MINECART = EntityTypes.key(ResourceKey.sponge("spawner_minecart"));

    public static final DefaultedRegistryReference<EntityType<SpectralArrow>> SPECTRAL_ARROW = EntityTypes.key(ResourceKey.sponge("spectral_arrow"));

    public static final DefaultedRegistryReference<EntityType<Spider>> SPIDER = EntityTypes.key(ResourceKey.sponge("spider"));

    public static final DefaultedRegistryReference<EntityType<Squid>> SQUID = EntityTypes.key(ResourceKey.sponge("squid"));

    public static final DefaultedRegistryReference<EntityType<Stray>> STRAY = EntityTypes.key(ResourceKey.sponge("stray"));

    public static final DefaultedRegistryReference<EntityType<Strider>> STRIDER = EntityTypes.key(ResourceKey.sponge("strider"));

    public static final DefaultedRegistryReference<EntityType<PrimedTNT>> TNT = EntityTypes.key(ResourceKey.sponge("tnt"));

    public static final DefaultedRegistryReference<EntityType<TNTMinecart>> TNT_MINECART = EntityTypes.key(ResourceKey.sponge("tnt_minecart"));

    public static final DefaultedRegistryReference<EntityType<TraderLlama>> TRADER_LLAMA = EntityTypes.key(ResourceKey.sponge("trader_llama"));

    public static final DefaultedRegistryReference<EntityType<Trident>> TRIDENT = EntityTypes.key(ResourceKey.sponge("trident"));

    public static final DefaultedRegistryReference<EntityType<TropicalFish>> TROPICAL_FISH = EntityTypes.key(ResourceKey.sponge("tropical_fish"));

    public static final DefaultedRegistryReference<EntityType<Turtle>> TURTLE = EntityTypes.key(ResourceKey.sponge("turtle"));

    public static final DefaultedRegistryReference<EntityType<Vex>> VEX = EntityTypes.key(ResourceKey.sponge("vex"));

    public static final DefaultedRegistryReference<EntityType<Villager>> VILLAGER = EntityTypes.key(ResourceKey.sponge("villager"));

    public static final DefaultedRegistryReference<EntityType<Vindicator>> VINDICATOR = EntityTypes.key(ResourceKey.sponge("vindicator"));

    public static final DefaultedRegistryReference<EntityType<WanderingTrader>> WANDERING_TRADER = EntityTypes.key(ResourceKey.sponge("wandering_trader"));

    public static final DefaultedRegistryReference<EntityType<Witch>> WITCH = EntityTypes.key(ResourceKey.sponge("witch"));

    public static final DefaultedRegistryReference<EntityType<Wither>> WITHER = EntityTypes.key(ResourceKey.sponge("wither"));

    public static final DefaultedRegistryReference<EntityType<WitherSkeleton>> WITHER_SKELETON = EntityTypes.key(ResourceKey.sponge("wither_skeleton"));

    public static final DefaultedRegistryReference<EntityType<WitherSkull>> WITHER_SKULL = EntityTypes.key(ResourceKey.sponge("wither_skull"));

    public static final DefaultedRegistryReference<EntityType<Wolf>> WOLF = EntityTypes.key(ResourceKey.sponge("wolf"));

    public static final DefaultedRegistryReference<EntityType<Zoglin>> ZOGLIN = EntityTypes.key(ResourceKey.sponge("zoglin"));

    public static final DefaultedRegistryReference<EntityType<Zombie>> ZOMBIE = EntityTypes.key(ResourceKey.sponge("zombie"));

    public static final DefaultedRegistryReference<EntityType<ZombieHorse>> ZOMBIE_HORSE = EntityTypes.key(ResourceKey.sponge("zombie_horse"));

    public static final DefaultedRegistryReference<EntityType<ZombieVillager>> ZOMBIE_VILLAGER = EntityTypes.key(ResourceKey.sponge("zombie_villager"));

    public static final DefaultedRegistryReference<EntityType<ZombifiedPiglin>> ZOMBIFIED_PIGLIN = EntityTypes.key(ResourceKey.sponge("zombified_piglin"));

    public static final DefaultedRegistryReference<EntityType<Human>> HUMAN = EntityTypes.key(ResourceKey.sponge("human"));

    // SORTFIELDS:OFF

    // @formatter:on

    private EntityTypes() {
    }

    private static <T extends Entity> DefaultedRegistryReference<EntityType<T>> key(final ResourceKey location) {
        return RegistryKey.<EntityType<T>>of(Registries.ENTITY_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}

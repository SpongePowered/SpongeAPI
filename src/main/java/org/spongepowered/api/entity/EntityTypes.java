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
import org.spongepowered.api.entity.living.animal.Axolotl;
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
import org.spongepowered.api.entity.living.aquatic.GlowSquid;
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
import org.spongepowered.api.registry.RegistryTypes;
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

    public static final DefaultedRegistryReference<EntityType<AreaEffectCloud>> AREA_EFFECT_CLOUD = EntityTypes.key(ResourceKey.minecraft("area_effect_cloud"));

    public static final DefaultedRegistryReference<EntityType<ArmorStand>> ARMOR_STAND = EntityTypes.key(ResourceKey.minecraft("armor_stand"));

    public static final DefaultedRegistryReference<EntityType<Arrow>> ARROW = EntityTypes.key(ResourceKey.minecraft("arrow"));

    public static final DefaultedRegistryReference<EntityType<Axolotl>> AXOLOTL = EntityTypes.key(ResourceKey.minecraft("axolotl"));

    public static final DefaultedRegistryReference<EntityType<Bat>> BAT = EntityTypes.key(ResourceKey.minecraft("bat"));

    public static final DefaultedRegistryReference<EntityType<Bee>> BEE = EntityTypes.key(ResourceKey.minecraft("bee"));

    public static final DefaultedRegistryReference<EntityType<Blaze>> BLAZE = EntityTypes.key(ResourceKey.minecraft("blaze"));

    public static final DefaultedRegistryReference<EntityType<Boat>> BOAT = EntityTypes.key(ResourceKey.minecraft("boat"));

    public static final DefaultedRegistryReference<EntityType<Cat>> CAT = EntityTypes.key(ResourceKey.minecraft("cat"));

    public static final DefaultedRegistryReference<EntityType<CaveSpider>> CAVE_SPIDER = EntityTypes.key(ResourceKey.minecraft("cave_spider"));

    public static final DefaultedRegistryReference<EntityType<ChestMinecart>> CHEST_MINECART = EntityTypes.key(ResourceKey.minecraft("chest_minecart"));

    public static final DefaultedRegistryReference<EntityType<Chicken>> CHICKEN = EntityTypes.key(ResourceKey.minecraft("chicken"));

    public static final DefaultedRegistryReference<EntityType<Cod>> COD = EntityTypes.key(ResourceKey.minecraft("cod"));

    public static final DefaultedRegistryReference<EntityType<CommandBlockMinecart>> COMMAND_BLOCK_MINECART = EntityTypes.key(ResourceKey.minecraft("command_block_minecart"));

    public static final DefaultedRegistryReference<EntityType<Cow>> COW = EntityTypes.key(ResourceKey.minecraft("cow"));

    public static final DefaultedRegistryReference<EntityType<Creeper>> CREEPER = EntityTypes.key(ResourceKey.minecraft("creeper"));

    public static final DefaultedRegistryReference<EntityType<Dolphin>> DOLPHIN = EntityTypes.key(ResourceKey.minecraft("dolphin"));

    public static final DefaultedRegistryReference<EntityType<Donkey>> DONKEY = EntityTypes.key(ResourceKey.minecraft("donkey"));

    public static final DefaultedRegistryReference<EntityType<DragonFireball>> DRAGON_FIREBALL = EntityTypes.key(ResourceKey.minecraft("dragon_fireball"));

    public static final DefaultedRegistryReference<EntityType<Drowned>> DROWNED = EntityTypes.key(ResourceKey.minecraft("drowned"));

    public static final DefaultedRegistryReference<EntityType<Egg>> EGG = EntityTypes.key(ResourceKey.minecraft("egg"));

    public static final DefaultedRegistryReference<EntityType<ElderGuardian>> ELDER_GUARDIAN = EntityTypes.key(ResourceKey.minecraft("elder_guardian"));

    public static final DefaultedRegistryReference<EntityType<EndCrystal>> END_CRYSTAL = EntityTypes.key(ResourceKey.minecraft("end_crystal"));

    public static final DefaultedRegistryReference<EntityType<EnderDragon>> ENDER_DRAGON = EntityTypes.key(ResourceKey.minecraft("ender_dragon"));

    public static final DefaultedRegistryReference<EntityType<EnderPearl>> ENDER_PEARL = EntityTypes.key(ResourceKey.minecraft("ender_pearl"));

    public static final DefaultedRegistryReference<EntityType<Enderman>> ENDERMAN = EntityTypes.key(ResourceKey.minecraft("enderman"));

    public static final DefaultedRegistryReference<EntityType<Endermite>> ENDERMITE = EntityTypes.key(ResourceKey.minecraft("endermite"));

    public static final DefaultedRegistryReference<EntityType<Evoker>> EVOKER = EntityTypes.key(ResourceKey.minecraft("evoker"));

    public static final DefaultedRegistryReference<EntityType<EvokerFangs>> EVOKER_FANGS = EntityTypes.key(ResourceKey.minecraft("evoker_fangs"));

    public static final DefaultedRegistryReference<EntityType<ExperienceBottle>> EXPERIENCE_BOTTLE = EntityTypes.key(ResourceKey.minecraft("experience_bottle"));

    public static final DefaultedRegistryReference<EntityType<ExperienceOrb>> EXPERIENCE_ORB = EntityTypes.key(ResourceKey.minecraft("experience_orb"));

    public static final DefaultedRegistryReference<EntityType<EyeOfEnder>> EYE_OF_ENDER = EntityTypes.key(ResourceKey.minecraft("eye_of_ender"));

    public static final DefaultedRegistryReference<EntityType<FallingBlock>> FALLING_BLOCK = EntityTypes.key(ResourceKey.minecraft("falling_block"));

    public static final DefaultedRegistryReference<EntityType<ExplosiveFireball>> FIREBALL = EntityTypes.key(ResourceKey.minecraft("fireball"));

    public static final DefaultedRegistryReference<EntityType<FireworkRocket>> FIREWORK_ROCKET = EntityTypes.key(ResourceKey.minecraft("firework_rocket"));

    public static final DefaultedRegistryReference<EntityType<FishingBobber>> FISHING_BOBBER = EntityTypes.key(ResourceKey.minecraft("fishing_bobber"));

    public static final DefaultedRegistryReference<EntityType<Fox>> FOX = EntityTypes.key(ResourceKey.minecraft("fox"));

    public static final DefaultedRegistryReference<EntityType<FurnaceMinecart>> FURNACE_MINECART = EntityTypes.key(ResourceKey.minecraft("furnace_minecart"));

    public static final DefaultedRegistryReference<EntityType<Ghast>> GHAST = EntityTypes.key(ResourceKey.minecraft("ghast"));

    public static final DefaultedRegistryReference<EntityType<Giant>> GIANT = EntityTypes.key(ResourceKey.minecraft("giant"));

    public static final DefaultedRegistryReference<EntityType<ItemFrame>> GLOW_ITEM_FRAME = EntityTypes.key(ResourceKey.minecraft("glow_item_frame"));

    public static final DefaultedRegistryReference<EntityType<GlowSquid>> GLOW_SQUID = EntityTypes.key(ResourceKey.minecraft("glow_squid"));

    public static final DefaultedRegistryReference<EntityType<Guardian>> GUARDIAN = EntityTypes.key(ResourceKey.minecraft("guardian"));

    public static final DefaultedRegistryReference<EntityType<Hoglin>> HOGLIN = EntityTypes.key(ResourceKey.minecraft("hoglin"));

    public static final DefaultedRegistryReference<EntityType<HopperMinecart>> HOPPER_MINECART = EntityTypes.key(ResourceKey.minecraft("hopper_minecart"));

    public static final DefaultedRegistryReference<EntityType<Horse>> HORSE = EntityTypes.key(ResourceKey.minecraft("horse"));

    public static final DefaultedRegistryReference<EntityType<Husk>> HUSK = EntityTypes.key(ResourceKey.minecraft("husk"));

    public static final DefaultedRegistryReference<EntityType<Illusioner>> ILLUSIONER = EntityTypes.key(ResourceKey.minecraft("illusioner"));

    public static final DefaultedRegistryReference<EntityType<IronGolem>> IRON_GOLEM = EntityTypes.key(ResourceKey.minecraft("iron_golem"));

    public static final DefaultedRegistryReference<EntityType<Item>> ITEM = EntityTypes.key(ResourceKey.minecraft("item"));

    public static final DefaultedRegistryReference<EntityType<ItemFrame>> ITEM_FRAME = EntityTypes.key(ResourceKey.minecraft("item_frame"));

    public static final DefaultedRegistryReference<EntityType<LeashKnot>> LEASH_KNOT = EntityTypes.key(ResourceKey.minecraft("leash_knot"));

    public static final DefaultedRegistryReference<EntityType<LightningBolt>> LIGHTNING_BOLT = EntityTypes.key(ResourceKey.minecraft("lightning_bolt"));

    public static final DefaultedRegistryReference<EntityType<Llama>> LLAMA = EntityTypes.key(ResourceKey.minecraft("llama"));

    public static final DefaultedRegistryReference<EntityType<LlamaSpit>> LLAMA_SPIT = EntityTypes.key(ResourceKey.minecraft("llama_spit"));

    public static final DefaultedRegistryReference<EntityType<MagmaCube>> MAGMA_CUBE = EntityTypes.key(ResourceKey.minecraft("magma_cube"));

    public static final DefaultedRegistryReference<EntityType<Minecart>> MINECART = EntityTypes.key(ResourceKey.minecraft("minecart"));

    public static final DefaultedRegistryReference<EntityType<Mooshroom>> MOOSHROOM = EntityTypes.key(ResourceKey.minecraft("mooshroom"));

    public static final DefaultedRegistryReference<EntityType<Mule>> MULE = EntityTypes.key(ResourceKey.minecraft("mule"));

    public static final DefaultedRegistryReference<EntityType<Ocelot>> OCELOT = EntityTypes.key(ResourceKey.minecraft("ocelot"));

    public static final DefaultedRegistryReference<EntityType<Painting>> PAINTING = EntityTypes.key(ResourceKey.minecraft("painting"));

    public static final DefaultedRegistryReference<EntityType<Panda>> PANDA = EntityTypes.key(ResourceKey.minecraft("panda"));

    public static final DefaultedRegistryReference<EntityType<Parrot>> PARROT = EntityTypes.key(ResourceKey.minecraft("parrot"));

    public static final DefaultedRegistryReference<EntityType<Phantom>> PHANTOM = EntityTypes.key(ResourceKey.minecraft("phantom"));

    public static final DefaultedRegistryReference<EntityType<Pig>> PIG = EntityTypes.key(ResourceKey.minecraft("pig"));

    public static final DefaultedRegistryReference<EntityType<Piglin>> PIGLIN = EntityTypes.key(ResourceKey.minecraft("piglin"));

    public static final DefaultedRegistryReference<EntityType<PiglinBrute>> PIGLIN_BRUTE = EntityTypes.key(ResourceKey.minecraft("piglin_brute"));

    public static final DefaultedRegistryReference<EntityType<Pillager>> PILLAGER = EntityTypes.key(ResourceKey.minecraft("pillager"));

    public static final DefaultedRegistryReference<EntityType<Player>> PLAYER = EntityTypes.key(ResourceKey.minecraft("player"));

    public static final DefaultedRegistryReference<EntityType<PolarBear>> POLAR_BEAR = EntityTypes.key(ResourceKey.minecraft("polar_bear"));

    public static final DefaultedRegistryReference<EntityType<Potion>> POTION = EntityTypes.key(ResourceKey.minecraft("potion"));

    public static final DefaultedRegistryReference<EntityType<Pufferfish>> PUFFERFISH = EntityTypes.key(ResourceKey.minecraft("pufferfish"));

    public static final DefaultedRegistryReference<EntityType<Rabbit>> RABBIT = EntityTypes.key(ResourceKey.minecraft("rabbit"));

    public static final DefaultedRegistryReference<EntityType<Ravager>> RAVAGER = EntityTypes.key(ResourceKey.minecraft("ravager"));

    public static final DefaultedRegistryReference<EntityType<Salmon>> SALMON = EntityTypes.key(ResourceKey.minecraft("salmon"));

    public static final DefaultedRegistryReference<EntityType<Sheep>> SHEEP = EntityTypes.key(ResourceKey.minecraft("sheep"));

    public static final DefaultedRegistryReference<EntityType<Shulker>> SHULKER = EntityTypes.key(ResourceKey.minecraft("shulker"));

    public static final DefaultedRegistryReference<EntityType<ShulkerBullet>> SHULKER_BULLET = EntityTypes.key(ResourceKey.minecraft("shulker_bullet"));

    public static final DefaultedRegistryReference<EntityType<Silverfish>> SILVERFISH = EntityTypes.key(ResourceKey.minecraft("silverfish"));

    public static final DefaultedRegistryReference<EntityType<Skeleton>> SKELETON = EntityTypes.key(ResourceKey.minecraft("skeleton"));

    public static final DefaultedRegistryReference<EntityType<SkeletonHorse>> SKELETON_HORSE = EntityTypes.key(ResourceKey.minecraft("skeleton_horse"));

    public static final DefaultedRegistryReference<EntityType<Slime>> SLIME = EntityTypes.key(ResourceKey.minecraft("slime"));

    public static final DefaultedRegistryReference<EntityType<SmallFireball>> SMALL_FIREBALL = EntityTypes.key(ResourceKey.minecraft("small_fireball"));

    public static final DefaultedRegistryReference<EntityType<SnowGolem>> SNOW_GOLEM = EntityTypes.key(ResourceKey.minecraft("snow_golem"));

    public static final DefaultedRegistryReference<EntityType<Snowball>> SNOWBALL = EntityTypes.key(ResourceKey.minecraft("snowball"));

    public static final DefaultedRegistryReference<EntityType<SpawnerMinecart>> SPAWNER_MINECART = EntityTypes.key(ResourceKey.minecraft("spawner_minecart"));

    public static final DefaultedRegistryReference<EntityType<SpectralArrow>> SPECTRAL_ARROW = EntityTypes.key(ResourceKey.minecraft("spectral_arrow"));

    public static final DefaultedRegistryReference<EntityType<Spider>> SPIDER = EntityTypes.key(ResourceKey.minecraft("spider"));

    public static final DefaultedRegistryReference<EntityType<Squid>> SQUID = EntityTypes.key(ResourceKey.minecraft("squid"));

    public static final DefaultedRegistryReference<EntityType<Stray>> STRAY = EntityTypes.key(ResourceKey.minecraft("stray"));

    public static final DefaultedRegistryReference<EntityType<Strider>> STRIDER = EntityTypes.key(ResourceKey.minecraft("strider"));

    public static final DefaultedRegistryReference<EntityType<PrimedTNT>> TNT = EntityTypes.key(ResourceKey.minecraft("tnt"));

    public static final DefaultedRegistryReference<EntityType<TNTMinecart>> TNT_MINECART = EntityTypes.key(ResourceKey.minecraft("tnt_minecart"));

    public static final DefaultedRegistryReference<EntityType<TraderLlama>> TRADER_LLAMA = EntityTypes.key(ResourceKey.minecraft("trader_llama"));

    public static final DefaultedRegistryReference<EntityType<Trident>> TRIDENT = EntityTypes.key(ResourceKey.minecraft("trident"));

    public static final DefaultedRegistryReference<EntityType<TropicalFish>> TROPICAL_FISH = EntityTypes.key(ResourceKey.minecraft("tropical_fish"));

    public static final DefaultedRegistryReference<EntityType<Turtle>> TURTLE = EntityTypes.key(ResourceKey.minecraft("turtle"));

    public static final DefaultedRegistryReference<EntityType<Vex>> VEX = EntityTypes.key(ResourceKey.minecraft("vex"));

    public static final DefaultedRegistryReference<EntityType<Villager>> VILLAGER = EntityTypes.key(ResourceKey.minecraft("villager"));

    public static final DefaultedRegistryReference<EntityType<Vindicator>> VINDICATOR = EntityTypes.key(ResourceKey.minecraft("vindicator"));

    public static final DefaultedRegistryReference<EntityType<WanderingTrader>> WANDERING_TRADER = EntityTypes.key(ResourceKey.minecraft("wandering_trader"));

    public static final DefaultedRegistryReference<EntityType<Witch>> WITCH = EntityTypes.key(ResourceKey.minecraft("witch"));

    public static final DefaultedRegistryReference<EntityType<Wither>> WITHER = EntityTypes.key(ResourceKey.minecraft("wither"));

    public static final DefaultedRegistryReference<EntityType<WitherSkeleton>> WITHER_SKELETON = EntityTypes.key(ResourceKey.minecraft("wither_skeleton"));

    public static final DefaultedRegistryReference<EntityType<WitherSkull>> WITHER_SKULL = EntityTypes.key(ResourceKey.minecraft("wither_skull"));

    public static final DefaultedRegistryReference<EntityType<Wolf>> WOLF = EntityTypes.key(ResourceKey.minecraft("wolf"));

    public static final DefaultedRegistryReference<EntityType<Zoglin>> ZOGLIN = EntityTypes.key(ResourceKey.minecraft("zoglin"));

    public static final DefaultedRegistryReference<EntityType<Zombie>> ZOMBIE = EntityTypes.key(ResourceKey.minecraft("zombie"));

    public static final DefaultedRegistryReference<EntityType<ZombieHorse>> ZOMBIE_HORSE = EntityTypes.key(ResourceKey.minecraft("zombie_horse"));

    public static final DefaultedRegistryReference<EntityType<ZombieVillager>> ZOMBIE_VILLAGER = EntityTypes.key(ResourceKey.minecraft("zombie_villager"));

    public static final DefaultedRegistryReference<EntityType<ZombifiedPiglin>> ZOMBIFIED_PIGLIN = EntityTypes.key(ResourceKey.minecraft("zombified_piglin"));

    // SORTFIELDS:OFF

    // @formatter:on

    public static final DefaultedRegistryReference<EntityType<Human>> HUMAN = EntityTypes.key(ResourceKey.sponge("human"));

    private EntityTypes() {
    }

    private static <T extends Entity> DefaultedRegistryReference<EntityType<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.ENTITY_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}

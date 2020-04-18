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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.explosive.EnderCrystal;
import org.spongepowered.api.entity.explosive.fused.PrimedTNT;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.LeashKnot;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.Human;
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
import org.spongepowered.api.entity.living.monster.Vex;
import org.spongepowered.api.entity.living.monster.boss.Wither;
import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.monster.guardian.ElderGuardian;
import org.spongepowered.api.entity.living.monster.guardian.Guardian;
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
import org.spongepowered.api.entity.living.monster.zombie.ZombiePigman;
import org.spongepowered.api.entity.living.monster.zombie.ZombieVillager;
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

import java.util.function.Supplier;

/**
 * An enumeration of all possible {@link EntityType}s available in vanilla minecraft.
 */
public final class EntityTypes {

    // SORTFIELDS:ON

    public static final Supplier<EntityType<AreaEffectCloud>> AREA_EFFECT_CLOUD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "AREA_EFFECT_CLOUD");

    public static final Supplier<EntityType<ArmorStand>> ARMOR_STAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ARMOR_STAND");

    public static final Supplier<EntityType<Arrow>> ARROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ARROW");

    public static final Supplier<EntityType<Bat>> BAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "BAT");

    public static final Supplier<EntityType<Blaze>> BLAZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "BLAZE");

    public static final Supplier<EntityType<Boat>> BOAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "BOAT");

    public static final Supplier<EntityType<Cat>> CAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "CAT");

    public static final Supplier<EntityType<CaveSpider>> CAVE_SPIDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "CAVE_SPIDER");

    public static final Supplier<EntityType<ChestMinecart>> CHEST_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "CHEST_MINECART");

    public static final Supplier<EntityType<Chicken>> CHICKEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "CHICKEN");

    public static final Supplier<EntityType<Cod>> COD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "COD");

    public static final Supplier<EntityType<CommandBlockMinecart>> COMMAND_BLOCK_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "COMMAND_BLOCK_MINECART");

    public static final Supplier<EntityType<Cow>> COW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "COW");

    public static final Supplier<EntityType<Creeper>> CREEPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "CREEPER");

    public static final Supplier<EntityType<Dolphin>> DOLPHIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "DOLPHIN");

    public static final Supplier<EntityType<Donkey>> DONKEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "DONKEY");

    public static final Supplier<EntityType<DragonFireball>> DRAGON_FIREBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "DRAGON_FIREBALL");

    public static final Supplier<EntityType<Drowned>> DROWNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "DROWNED");

    public static final Supplier<EntityType<Egg>> EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "EGG");

    public static final Supplier<EntityType<ElderGuardian>> ELDER_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ELDER_GUARDIAN");

    public static final Supplier<EntityType<Enderman>> ENDERMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ENDERMAN");

    public static final Supplier<EntityType<Endermite>> ENDERMITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ENDERMITE");

    public static final Supplier<EntityType<EnderDragon>> ENDER_DRAGON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ENDER_DRAGON");

    public static final Supplier<EntityType<EnderPearl>> ENDER_PEARL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ENDER_PEARL");

    public static final Supplier<EntityType<EnderCrystal>> END_CRYSTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "END_CRYSTAL");

    public static final Supplier<EntityType<Evoker>> EVOKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "EVOKER");

    public static final Supplier<EntityType<EvokerFangs>> EVOKER_FANGS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "EVOKER_FANGS");

    public static final Supplier<EntityType<ExperienceBottle>> EXPERIENCE_BOTTLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "EXPERIENCE_BOTTLE");

    public static final Supplier<EntityType<ExperienceOrb>> EXPERIENCE_ORB = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "EXPERIENCE_ORB");

    public static final Supplier<EntityType<EyeOfEnder>> EYE_OF_ENDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "EYE_OF_ENDER");

    public static final Supplier<EntityType<FallingBlock>> FALLING_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "FALLING_BLOCK");

    public static final Supplier<EntityType<ExplosiveFireball>> FIREBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "FIREBALL");

    public static final Supplier<EntityType<FireworkRocket>> FIREWORK_ROCKET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "FIREWORK_ROCKET");

    public static final Supplier<EntityType<FishingBobber>> FISHING_BOBBER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "FISHING_BOBBER");

    public static final Supplier<EntityType<Fox>> FOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "FOX");

    public static final Supplier<EntityType<FurnaceMinecart>> FURNACE_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "FURNACE_MINECART");

    public static final Supplier<EntityType<Ghast>> GHAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "GHAST");

    public static final Supplier<EntityType<Giant>> GIANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "GIANT");

    public static final Supplier<EntityType<Guardian>> GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "GUARDIAN");

    public static final Supplier<EntityType<HopperMinecart>> HOPPER_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "HOPPER_MINECART");

    public static final Supplier<EntityType<Horse>> HORSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "HORSE");

    public static final Supplier<EntityType<Husk>> HUSK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "HUSK");

    public static final Supplier<EntityType<Illusioner>> ILLUSIONER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ILLUSIONER");

    public static final Supplier<EntityType<IronGolem>> IRON_GOLEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "IRON_GOLEM");

    public static final Supplier<EntityType<Item>> ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ITEM");

    public static final Supplier<EntityType<ItemFrame>> ITEM_FRAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ITEM_FRAME");

    public static final Supplier<EntityType<LeashKnot>> LEASH_KNOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "LEASH_KNOT");

    public static final Supplier<EntityType<LightningBolt>> LIGHTNING_BOLT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "LIGHTNING_BOLT");

    public static final Supplier<EntityType<Llama>> LLAMA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "LLAMA");

    public static final Supplier<EntityType<LlamaSpit>> LLAMA_SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "LLAMA_SPIT");

    public static final Supplier<EntityType<MagmaCube>> MAGMA_CUBE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "MAGMA_CUBE");

    public static final Supplier<EntityType<Minecart>> MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "MINECART");

    public static final Supplier<EntityType<Mooshroom>> MOOSHROOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "MOOSHROOM");

    public static final Supplier<EntityType<Mule>> MULE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "MULE");

    public static final Supplier<EntityType<Ocelot>> OCELOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "OCELOT");

    public static final Supplier<EntityType<Painting>> PAINTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "PAINTING");

    public static final Supplier<EntityType<Panda>> PANDA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "PANDA");

    public static final Supplier<EntityType<Parrot>> PARROT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "PARROT");

    public static final Supplier<EntityType<Phantom>> PHANTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "PHANTOM");

    public static final Supplier<EntityType<Pig>> PIG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "PIG");

    public static final Supplier<EntityType<Pillager>> PILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "PILLAGER");

    public static final Supplier<EntityType<Player>> PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "PLAYER");

    public static final Supplier<EntityType<PolarBear>> POLAR_BEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "POLAR_BEAR");

    public static final Supplier<EntityType<Potion>> POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "POTION");

    public static final Supplier<EntityType<Pufferfish>> PUFFERFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "PUFFERFISH");

    public static final Supplier<EntityType<Rabbit>> RABBIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "RABBIT");

    public static final Supplier<EntityType<Ravager>> RAVAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "RAVAGER");

    public static final Supplier<EntityType<Salmon>> SALMON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SALMON");

    public static final Supplier<EntityType<Sheep>> SHEEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SHEEP");

    public static final Supplier<EntityType<Shulker>> SHULKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SHULKER");

    public static final Supplier<EntityType<ShulkerBullet>> SHULKER_BULLET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SHULKER_BULLET");

    public static final Supplier<EntityType<Silverfish>> SILVERFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SILVERFISH");

    public static final Supplier<EntityType<Skeleton>> SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SKELETON");

    public static final Supplier<EntityType<SkeletonHorse>> SKELETON_HORSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SKELETON_HORSE");

    public static final Supplier<EntityType<Slime>> SLIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SLIME");

    public static final Supplier<EntityType<SmallFireball>> SMALL_FIREBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SMALL_FIREBALL");

    public static final Supplier<EntityType<Snowball>> SNOWBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SNOWBALL");

    public static final Supplier<EntityType<SnowGolem>> SNOW_GOLEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SNOW_GOLEM");

    public static final Supplier<EntityType<SpawnerMinecart>> SPAWNER_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SPAWNER_MINECART");

    public static final Supplier<EntityType<SpectralArrow>> SPECTRAL_ARROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SPECTRAL_ARROW");

    public static final Supplier<EntityType<Spider>> SPIDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SPIDER");

    public static final Supplier<EntityType<Squid>> SQUID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "SQUID");

    public static final Supplier<EntityType<Stray>> STRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "STRAY");

    public static final Supplier<EntityType<PrimedTNT>> TNT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "TNT");

    public static final Supplier<EntityType<TNTMinecart>> TNT_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "TNT_MINECART");

    public static final Supplier<EntityType<TraderLlama>> TRADER_LLAMA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "TRADER_LLAMA");

    public static final Supplier<EntityType<Trident>> TRIDENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "TRIDENT");

    public static final Supplier<EntityType<TropicalFish>> TROPICAL_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "TROPICAL_FISH");

    public static final Supplier<EntityType<Turtle>> TURTLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "TURTLE");

    public static final Supplier<EntityType<Vex>> VEX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "VEX");

    public static final Supplier<EntityType<Villager>> VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "VILLAGER");

    public static final Supplier<EntityType<Vindicator>> VINDICATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "VINDICATOR");

    public static final Supplier<EntityType<WanderingTrader>> WANDERING_TRADER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "WANDERING_TRADER");

    public static final Supplier<EntityType<Witch>> WITCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "WITCH");

    public static final Supplier<EntityType<Wither>> WITHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "WITHER");

    public static final Supplier<EntityType<WitherSkeleton>> WITHER_SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "WITHER_SKELETON");

    public static final Supplier<EntityType<WitherSkull>> WITHER_SKULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "WITHER_SKULL");

    public static final Supplier<EntityType<Wolf>> WOLF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "WOLF");

    public static final Supplier<EntityType<Zombie>> ZOMBIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ZOMBIE");

    public static final Supplier<EntityType<ZombieHorse>> ZOMBIE_HORSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ZOMBIE_HORSE");

    public static final Supplier<EntityType<ZombiePigman>> ZOMBIE_PIGMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ZOMBIE_PIGMAN");

    public static final Supplier<EntityType<ZombieVillager>> ZOMBIE_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ZOMBIE_VILLAGER");

    // SORTFIELDS:OFF

    public static final Supplier<EntityType<Human>> HUMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "HUMAN");

    // Suppress default constructor to ensure non-instantiability.
    private EntityTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}

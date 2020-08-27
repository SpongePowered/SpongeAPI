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

    public static final Supplier<EntityType<AreaEffectCloud>> AREA_EFFECT_CLOUD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "area_effect_cloud");

    public static final Supplier<EntityType<ArmorStand>> ARMOR_STAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "armor_stand");

    public static final Supplier<EntityType<Arrow>> ARROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "arrow");

    public static final Supplier<EntityType<Bat>> BAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "bat");

    public static final Supplier<EntityType<Bee>> BEE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "bee");

    public static final Supplier<EntityType<Blaze>> BLAZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "blaze");

    public static final Supplier<EntityType<Boat>> BOAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "boat");

    public static final Supplier<EntityType<Cat>> CAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "cat");

    public static final Supplier<EntityType<CaveSpider>> CAVE_SPIDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "cave_spider");

    public static final Supplier<EntityType<ChestMinecart>> CHEST_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "chest_minecart");

    public static final Supplier<EntityType<Chicken>> CHICKEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "chicken");

    public static final Supplier<EntityType<Cod>> COD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "cod");

    public static final Supplier<EntityType<CommandBlockMinecart>> COMMAND_BLOCK_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "command_block_minecart");

    public static final Supplier<EntityType<Cow>> COW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "cow");

    public static final Supplier<EntityType<Creeper>> CREEPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "creeper");

    public static final Supplier<EntityType<Dolphin>> DOLPHIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "dolphin");

    public static final Supplier<EntityType<Donkey>> DONKEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "donkey");

    public static final Supplier<EntityType<DragonFireball>> DRAGON_FIREBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "dragon_fireball");

    public static final Supplier<EntityType<Drowned>> DROWNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "drowned");

    public static final Supplier<EntityType<Egg>> EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "egg");

    public static final Supplier<EntityType<ElderGuardian>> ELDER_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "elder_guardian");

    public static final Supplier<EntityType<Enderman>> ENDERMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "enderman");

    public static final Supplier<EntityType<Endermite>> ENDERMITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "endermite");

    public static final Supplier<EntityType<EnderDragon>> ENDER_DRAGON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ender_dragon");

    public static final Supplier<EntityType<EnderPearl>> ENDER_PEARL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ender_pearl");

    public static final Supplier<EntityType<EnderCrystal>> END_CRYSTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "end_crystal");

    public static final Supplier<EntityType<Evoker>> EVOKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "evoker");

    public static final Supplier<EntityType<EvokerFangs>> EVOKER_FANGS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "evoker_fangs");

    public static final Supplier<EntityType<ExperienceBottle>> EXPERIENCE_BOTTLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "experience_bottle");

    public static final Supplier<EntityType<ExperienceOrb>> EXPERIENCE_ORB = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "experience_orb");

    public static final Supplier<EntityType<EyeOfEnder>> EYE_OF_ENDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "eye_of_ender");

    public static final Supplier<EntityType<FallingBlock>> FALLING_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "falling_block");

    public static final Supplier<EntityType<ExplosiveFireball>> FIREBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "fireball");

    public static final Supplier<EntityType<FireworkRocket>> FIREWORK_ROCKET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "firework_rocket");

    public static final Supplier<EntityType<FishingBobber>> FISHING_BOBBER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "fishing_bobber");

    public static final Supplier<EntityType<Fox>> FOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "fox");

    public static final Supplier<EntityType<FurnaceMinecart>> FURNACE_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "furnace_minecart");

    public static final Supplier<EntityType<Ghast>> GHAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ghast");

    public static final Supplier<EntityType<Giant>> GIANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "giant");

    public static final Supplier<EntityType<Guardian>> GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "guardian");

    public static final Supplier<EntityType<HopperMinecart>> HOPPER_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "hopper_minecart");

    public static final Supplier<EntityType<Horse>> HORSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "horse");

    public static final Supplier<EntityType<Husk>> HUSK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "husk");

    public static final Supplier<EntityType<Illusioner>> ILLUSIONER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "illusioner");

    public static final Supplier<EntityType<IronGolem>> IRON_GOLEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "iron_golem");

    public static final Supplier<EntityType<Item>> ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "item");

    public static final Supplier<EntityType<ItemFrame>> ITEM_FRAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "item_frame");

    public static final Supplier<EntityType<LeashKnot>> LEASH_KNOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "leash_knot");

    public static final Supplier<EntityType<LightningBolt>> LIGHTNING_BOLT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "lightning_bolt");

    public static final Supplier<EntityType<Llama>> LLAMA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "llama");

    public static final Supplier<EntityType<LlamaSpit>> LLAMA_SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "llama_spit");

    public static final Supplier<EntityType<MagmaCube>> MAGMA_CUBE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "magma_cube");

    public static final Supplier<EntityType<Minecart>> MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "minecart");

    public static final Supplier<EntityType<Mooshroom>> MOOSHROOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "mooshroom");

    public static final Supplier<EntityType<Mule>> MULE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "mule");

    public static final Supplier<EntityType<Ocelot>> OCELOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ocelot");

    public static final Supplier<EntityType<Painting>> PAINTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "painting");

    public static final Supplier<EntityType<Panda>> PANDA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "panda");

    public static final Supplier<EntityType<Parrot>> PARROT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "parrot");

    public static final Supplier<EntityType<Phantom>> PHANTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "phantom");

    public static final Supplier<EntityType<Pig>> PIG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "pig");

    public static final Supplier<EntityType<Pillager>> PILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "pillager");

    public static final Supplier<EntityType<Player>> PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "player");

    public static final Supplier<EntityType<PolarBear>> POLAR_BEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "polar_bear");

    public static final Supplier<EntityType<Potion>> POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "potion");

    public static final Supplier<EntityType<Pufferfish>> PUFFERFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "pufferfish");

    public static final Supplier<EntityType<Rabbit>> RABBIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "rabbit");

    public static final Supplier<EntityType<Ravager>> RAVAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "ravager");

    public static final Supplier<EntityType<Salmon>> SALMON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "salmon");

    public static final Supplier<EntityType<Sheep>> SHEEP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "sheep");

    public static final Supplier<EntityType<Shulker>> SHULKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "shulker");

    public static final Supplier<EntityType<ShulkerBullet>> SHULKER_BULLET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "shulker_bullet");

    public static final Supplier<EntityType<Silverfish>> SILVERFISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "silverfish");

    public static final Supplier<EntityType<Skeleton>> SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "skeleton");

    public static final Supplier<EntityType<SkeletonHorse>> SKELETON_HORSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "skeleton_horse");

    public static final Supplier<EntityType<Slime>> SLIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "slime");

    public static final Supplier<EntityType<SmallFireball>> SMALL_FIREBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "small_fireball");

    public static final Supplier<EntityType<Snowball>> SNOWBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "snowball");

    public static final Supplier<EntityType<SnowGolem>> SNOW_GOLEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "snow_golem");

    public static final Supplier<EntityType<SpawnerMinecart>> SPAWNER_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "spawner_minecart");

    public static final Supplier<EntityType<SpectralArrow>> SPECTRAL_ARROW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "spectral_arrow");

    public static final Supplier<EntityType<Spider>> SPIDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "spider");

    public static final Supplier<EntityType<Squid>> SQUID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "squid");

    public static final Supplier<EntityType<Stray>> STRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "stray");

    public static final Supplier<EntityType<PrimedTNT>> TNT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "tnt");

    public static final Supplier<EntityType<TNTMinecart>> TNT_MINECART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "tnt_minecart");

    public static final Supplier<EntityType<TraderLlama>> TRADER_LLAMA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "trader_llama");

    public static final Supplier<EntityType<Trident>> TRIDENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "trident");

    public static final Supplier<EntityType<TropicalFish>> TROPICAL_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "tropical_fish");

    public static final Supplier<EntityType<Turtle>> TURTLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "turtle");

    public static final Supplier<EntityType<Vex>> VEX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "vex");

    public static final Supplier<EntityType<Villager>> VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "villager");

    public static final Supplier<EntityType<Vindicator>> VINDICATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "vindicator");

    public static final Supplier<EntityType<WanderingTrader>> WANDERING_TRADER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "wandering_trader");

    public static final Supplier<EntityType<Witch>> WITCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "witch");

    public static final Supplier<EntityType<Wither>> WITHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "wither");

    public static final Supplier<EntityType<WitherSkeleton>> WITHER_SKELETON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "wither_skeleton");

    public static final Supplier<EntityType<WitherSkull>> WITHER_SKULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "wither_skull");

    public static final Supplier<EntityType<Wolf>> WOLF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "wolf");

    public static final Supplier<EntityType<Zombie>> ZOMBIE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "zombie");

    public static final Supplier<EntityType<ZombieHorse>> ZOMBIE_HORSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "zombie_horse");

    public static final Supplier<EntityType<ZombiePigman>> ZOMBIE_PIGMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "zombie_pigman");

    public static final Supplier<EntityType<ZombieVillager>> ZOMBIE_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "zombie_villager");

    // SORTFIELDS:OFF

    public static final Supplier<EntityType<Human>> HUMAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EntityType.class, "human");

    // Suppress default constructor to ensure non-instantiability.
    private EntityTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}

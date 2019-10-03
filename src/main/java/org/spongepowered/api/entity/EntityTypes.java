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

import org.spongepowered.api.entity.explosive.EndCrystal;
import org.spongepowered.api.entity.explosive.fused.PrimedTNT;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.LeashKnot;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.aquatic.Squid;
import org.spongepowered.api.entity.living.animal.horse.llama.TraderLlama;
import org.spongepowered.api.entity.living.animal.Cat;
import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.animal.cow.Cow;
import org.spongepowered.api.entity.living.aquatic.Dolphin;
import org.spongepowered.api.entity.living.animal.horse.Donkey;
import org.spongepowered.api.entity.living.animal.Fox;
import org.spongepowered.api.entity.living.animal.horse.llama.Llama;
import org.spongepowered.api.entity.living.animal.cow.Mooshroom;
import org.spongepowered.api.entity.living.animal.horse.Mule;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Panda;
import org.spongepowered.api.entity.living.animal.Parrot;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.PolarBear;
import org.spongepowered.api.entity.living.animal.Rabbit;
import org.spongepowered.api.entity.living.animal.horse.Horse;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.animal.horse.SkeletonHorse;
import org.spongepowered.api.entity.living.animal.Turtle;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.animal.horse.ZombieHorse;
import org.spongepowered.api.entity.living.aquatic.fish.school.Cod;
import org.spongepowered.api.entity.living.aquatic.fish.Pufferfish;
import org.spongepowered.api.entity.living.aquatic.fish.school.Salmon;
import org.spongepowered.api.entity.living.aquatic.fish.school.TropicalFish;
import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.golem.Shulker;
import org.spongepowered.api.entity.living.golem.SnowGolem;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.living.monster.spider.CaveSpider;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.zombie.Drowned;
import org.spongepowered.api.entity.living.monster.guardian.ElderGuardian;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Endermite;
import org.spongepowered.api.entity.living.monster.raider.illager.spellcaster.Evoker;
import org.spongepowered.api.entity.living.monster.Ghast;
import org.spongepowered.api.entity.living.monster.Giant;
import org.spongepowered.api.entity.living.monster.guardian.Guardian;
import org.spongepowered.api.entity.living.monster.zombie.Husk;
import org.spongepowered.api.entity.living.monster.raider.illager.spellcaster.Illusioner;
import org.spongepowered.api.entity.living.monster.slime.MagmaCube;
import org.spongepowered.api.entity.living.monster.Phantom;
import org.spongepowered.api.entity.living.monster.Silverfish;
import org.spongepowered.api.entity.living.monster.slime.Slime;
import org.spongepowered.api.entity.living.monster.spider.Spider;
import org.spongepowered.api.entity.living.monster.skeleton.Skeleton;
import org.spongepowered.api.entity.living.monster.skeleton.Stray;
import org.spongepowered.api.entity.living.monster.Vex;
import org.spongepowered.api.entity.living.monster.raider.illager.Pillager;
import org.spongepowered.api.entity.living.monster.raider.illager.Vindicator;
import org.spongepowered.api.entity.living.monster.raider.Ravager;
import org.spongepowered.api.entity.living.monster.raider.Witch;
import org.spongepowered.api.entity.living.monster.boss.Wither;
import org.spongepowered.api.entity.living.monster.skeleton.WitherSkeleton;
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
import org.spongepowered.api.entity.projectile.explosive.FireworkRocket;
import org.spongepowered.api.entity.projectile.FishingBobber;
import org.spongepowered.api.entity.projectile.LlamaSpit;
import org.spongepowered.api.entity.projectile.Potion;
import org.spongepowered.api.entity.projectile.ShulkerBullet;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.arrow.SpectralArrow;
import org.spongepowered.api.entity.projectile.arrow.Arrow;
import org.spongepowered.api.entity.projectile.arrow.Trident;
import org.spongepowered.api.entity.projectile.explosive.fireball.DragonFireball;
import org.spongepowered.api.entity.projectile.explosive.WitherSkull;
import org.spongepowered.api.entity.projectile.explosive.fireball.LargeFireball;
import org.spongepowered.api.entity.projectile.explosive.fireball.SmallFireball;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.carrier.ChestMinecart;
import org.spongepowered.api.entity.vehicle.minecart.CommandBlockMinecart;
import org.spongepowered.api.entity.vehicle.minecart.FurnaceMinecart;
import org.spongepowered.api.entity.vehicle.minecart.carrier.HopperMinecart;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.entity.vehicle.minecart.SpawnerMinecart;
import org.spongepowered.api.entity.vehicle.minecart.TNTMinecart;
import org.spongepowered.api.entity.weather.LightningBolt;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link EntityType}s available in vanilla minecraft.
 */
public final class EntityTypes {

    // SORTFIELDS:ON

    public static final EntityType<AreaEffectCloud> AREA_EFFECT_CLOUD = dummy("AREA_EFFECT_CLOUD");

    public static final EntityType<ArmorStand> ARMOR_STAND = dummy("ARMOR_STAND");

    public static final EntityType<Arrow> ARROW = dummy("ARROW");

    public static final EntityType<Bat> BAT = dummy("BAT");

    public static final EntityType<Blaze> BLAZE = dummy("BLAZE");

    public static final EntityType<Boat> BOAT = dummy("BOAT");

    public static final EntityType<Cat> CAT = dummy("CAT");

    public static final EntityType<CaveSpider> CAVE_SPIDER = dummy("CAVE_SPIDER");

    public static final EntityType<ChestMinecart> CHEST_MINECART = dummy("CHEST_MINECART");

    public static final EntityType<Chicken> CHICKEN = dummy("CHICKEN");

    public static final EntityType<Cod> COD = dummy("COD");

    public static final EntityType<CommandBlockMinecart> COMMAND_BLOCK_MINECART = dummy("COMMAND_BLOCK_MINECART");

    public static final EntityType<Cow> COW = dummy("COW");

    public static final EntityType<Creeper> CREEPER = dummy("CREEPER");

    public static final EntityType<Dolphin> DOLPHIN = dummy("DOLPHIN");

    public static final EntityType<Donkey> DONKEY = dummy("DONKEY");

    public static final EntityType<DragonFireball> DRAGON_FIREBALL = dummy("DRAGON_FIREBALL");

    public static final EntityType<Drowned> DROWNED = dummy("DROWNED");

    public static final EntityType<Egg> EGG = dummy("EGG");

    public static final EntityType<ElderGuardian> ELDER_GUARDIAN = dummy("ELDER_GUARDIAN");

    public static final EntityType<Enderman> ENDERMAN = dummy("ENDERMAN");

    public static final EntityType<Endermite> ENDERMITE = dummy("ENDERMITE");

    public static final EntityType<EnderDragon> ENDER_DRAGON = dummy("ENDER_DRAGON");

    public static final EntityType<EnderPearl> ENDER_PEARL = dummy("ENDER_PEARL");

    public static final EntityType<EndCrystal> END_CRYSTAL = dummy("END_CRYSTAL");

    public static final EntityType<Evoker> EVOKER = dummy("EVOKER");

    public static final EntityType<EvokerFangs> EVOKER_FANGS = dummy("EVOKER_FANGS");

    public static final EntityType<ExperienceBottle> EXPERIENCE_BOTTLE = dummy("EXPERIENCE_BOTTLE");

    public static final EntityType<ExperienceOrb> EXPERIENCE_ORB = dummy("EXPERIENCE_ORB");

    public static final EntityType<EyeOfEnder> EYE_OF_ENDER = dummy("EYE_OF_ENDER");

    public static final EntityType<FallingBlock> FALLING_BLOCK = dummy("FALLING_BLOCK");

    public static final EntityType<LargeFireball> FIREBALL = dummy("FIREBALL");

    public static final EntityType<FireworkRocket> FIREWORK_ROCKET = dummy("FIREWORK_ROCKET");

    public static final EntityType<FishingBobber> FISHING_BOBBER = dummy("FISHING_BOBBER");

    public static final EntityType<Fox> FOX = dummy("FOX");

    public static final EntityType<FurnaceMinecart> FURNACE_MINECART = dummy("FURNACE_MINECART");

    public static final EntityType<Ghast> GHAST = dummy("GHAST");

    public static final EntityType<Giant> GIANT = dummy("GIANT");

    public static final EntityType<Guardian> GUARDIAN = dummy("GUARDIAN");

    public static final EntityType<HopperMinecart> HOPPER_MINECART = dummy("HOPPER_MINECART");

    public static final EntityType<Horse> HORSE = dummy("HORSE");

    public static final EntityType<Husk> HUSK = dummy("HUSK");

    public static final EntityType<Illusioner> ILLUSIONER = dummy("ILLUSIONER");

    public static final EntityType<IronGolem> IRON_GOLEM = dummy("IRON_GOLEM");

    public static final EntityType<Item> ITEM = dummy("ITEM");

    public static final EntityType<ItemFrame> ITEM_FRAME = dummy("ITEM_FRAME");

    public static final EntityType<LeashKnot> LEASH_KNOT = dummy("LEASH_KNOT");

    public static final EntityType<LightningBolt> LIGHTNING_BOLT = dummy("LIGHTNING_BOLT");

    public static final EntityType<Llama> LLAMA = dummy("LLAMA");

    public static final EntityType<LlamaSpit> LLAMA_SPIT = dummy("LLAMA_SPIT");

    public static final EntityType<MagmaCube> MAGMA_CUBE = dummy("MAGMA_CUBE");

    public static final EntityType<Minecart> MINECART = dummy("MINECART");

    public static final EntityType<Mooshroom> MOOSHROOM = dummy("MOOSHROOM");

    public static final EntityType<Mule> MULE = dummy("MULE");

    public static final EntityType<Ocelot> OCELOT = dummy("OCELOT");

    public static final EntityType<Painting> PAINTING = dummy("PAINTING");

    public static final EntityType<Panda> PANDA = dummy("PANDA");

    public static final EntityType<Parrot> PARROT = dummy("PARROT");

    public static final EntityType<Phantom> PHANTOM = dummy("PHANTOM");

    public static final EntityType<Pig> PIG = dummy("PIG");

    public static final EntityType<Pillager> PILLAGER = dummy("PILLAGER");

    public static final EntityType<Player> PLAYER = dummy("PLAYER");

    public static final EntityType<PolarBear> POLAR_BEAR = dummy("POLAR_BEAR");

    public static final EntityType<Potion> POTION = dummy("POTION");

    public static final EntityType<Pufferfish> PUFFERFISH = dummy("PUFFERFISH");

    public static final EntityType<Rabbit> RABBIT = dummy("RABBIT");

    public static final EntityType<Ravager> RAVAGER = dummy("RAVAGER");

    public static final EntityType<Salmon> SALMON = dummy("SALMON");

    public static final EntityType<Sheep> SHEEP = dummy("SHEEP");

    public static final EntityType<Shulker> SHULKER = dummy("SHULKER");

    public static final EntityType<ShulkerBullet> SHULKER_BULLET = dummy("SHULKER_BULLET");

    public static final EntityType<Silverfish> SILVERFISH = dummy("SILVERFISH");

    public static final EntityType<Skeleton> SKELETON = dummy("SKELETON");

    public static final EntityType<SkeletonHorse> SKELETON_HORSE = dummy("SKELETON_HORSE");

    public static final EntityType<Slime> SLIME = dummy("SLIME");

    public static final EntityType<SmallFireball> SMALL_FIREBALL = dummy("SMALL_FIREBALL");

    public static final EntityType<Snowball> SNOWBALL = dummy("SNOWBALL");

    public static final EntityType<SnowGolem> SNOW_GOLEM = dummy("SNOW_GOLEM");

    public static final EntityType<SpawnerMinecart> SPAWNER_MINECART = dummy("SPAWNER_MINECART");

    public static final EntityType<SpectralArrow> SPECTRAL_ARROW = dummy("SPECTRAL_ARROW");

    public static final EntityType<Spider> SPIDER = dummy("SPIDER");

    public static final EntityType<Squid> SQUID = dummy("SQUID");

    public static final EntityType<Stray> STRAY = dummy("STRAY");

    public static final EntityType<PrimedTNT> TNT = dummy("TNT");

    public static final EntityType<TNTMinecart> TNT_MINECART = dummy("TNT_MINECART");

    public static final EntityType<TraderLlama> TRADER_LLAMA = dummy("TRADER_LLAMA");

    public static final EntityType<Trident> TRIDENT = dummy("TRIDENT");

    public static final EntityType<TropicalFish> TROPICAL_FISH = dummy("TROPICAL_FISH");

    public static final EntityType<Turtle> TURTLE = dummy("TURTLE");

    public static final EntityType<Vex> VEX = dummy("VEX");

    public static final EntityType<Villager> VILLAGER = dummy("VILLAGER");

    public static final EntityType<Vindicator> VINDICATOR = dummy("VINDICATOR");

    public static final EntityType<WanderingTrader> WANDERING_TRADER = dummy("WANDERING_TRADER");

    public static final EntityType<Witch> WITCH = dummy("WITCH");

    public static final EntityType<Wither> WITHER = dummy("WITHER");

    public static final EntityType<WitherSkeleton> WITHER_SKELETON = dummy("WITHER_SKELETON");

    public static final EntityType<WitherSkull> WITHER_SKULL = dummy("WITHER_SKULL");

    public static final EntityType<Wolf> WOLF = dummy("WOLF");

    public static final EntityType<Zombie> ZOMBIE = dummy("ZOMBIE");

    public static final EntityType<ZombieHorse> ZOMBIE_HORSE = dummy("ZOMBIE_HORSE");

    public static final EntityType<ZombiePigman> ZOMBIE_PIGMAN = dummy("ZOMBIE_PIGMAN");

    public static final EntityType<ZombieVillager> ZOMBIE_VILLAGER = dummy("ZOMBIE_VILLAGER");

    // SORTFIELDS:OFF

    public static final EntityType<Human> HUMAN = dummy("HUMAN");

    public static final EntityType<?> UNKNOWN = dummy("UNKNOWN");

    // Suppress default constructor to ensure non-instantiability.
    private EntityTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

    @SuppressWarnings("unchecked")
    private static <A extends Entity> EntityType<A> dummy(final String fieldName) {
        return DummyObjectProvider.createFor(EntityType.class, fieldName);
    }

}

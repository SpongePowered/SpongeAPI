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
package org.spongepowered.api.data.manipulator.catalog;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.mutable.*;
import org.spongepowered.api.data.manipulator.mutable.entity.*;
import org.spongepowered.api.data.type.*;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Aquatic;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.Villager;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.Rabbit;
import org.spongepowered.api.entity.living.animal.RideableHorse;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Endermite;
import org.spongepowered.api.entity.living.monster.Guardian;
import org.spongepowered.api.entity.living.monster.MagmaCube;
import org.spongepowered.api.entity.living.monster.Skeleton;
import org.spongepowered.api.entity.living.monster.Slime;
import org.spongepowered.api.entity.living.monster.Zombie;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.projectile.EyeOfEnder;
import org.spongepowered.api.entity.projectile.Firework;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.arrow.Arrow;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.world.weather.Weather;

/**
 * An enumeration of all known vanilla {@link DataManipulator}s that may be
 * applicable to any {@link Entity}.
 */
public final class CatalogEntityData {

    /**
     * The {@link AgeableData} that represents age determining whether an
     * {@link Entity} is a child or an adult. Always exists for
     * {@link Ageable} entities.
     */
    public static final Class<AgeableData> AGEABLE_DATA = AgeableData.class;
    /**
     * The {@link AgentData} that signifies that an {@link Agent}'s AI is
     * enabled.
     */
    public static final Class<AgentData> AGENT_DATA = AgentData.class;
    /**
     * The {@link AggressiveData} that signifies whether an {@link Agent} is
     * considered aggressive, may attack other entities.
     */
    public static final Class<AggressiveData> AGGRESSIVE_DATA = AggressiveData.class;
    /**
     * The {@link AngerableData} that signifies an {@link Agent} is angry but
     * will calm down after a certain amount of time has passed.
     */
    public static final Class<AngerableData> ANGERABLE_DATA = AngerableData.class;
    /**
     * The {@link ArtData} that signifies what piece of {@link Art} is being
     * displayed. It is applicable for {@link Painting} entities.
     */
    public static final Class<ArtData> ART_DATA = ArtData.class;

    /**
     * Represents the mapped rotational data for all known body parts. Usually
     * applicable to {@link Humanoid}s and {@link ArmorStand}s.
     */
    public static final Class<BodyPartRotationalData> BODY_PART_ROTATIONAL_DATA = BodyPartRotationalData.class;
    /**
     * Entities that have {@link BreathingData} when under water. Usually
     * applies to {@link Living} entities but not {@link Aquatic} entities.
     */
    public static final Class<BreathingData> BREATHING_DATA = BreathingData.class;
    /**
     * Signifies an entity is ready to breed. Usually applies to
     * {@link Animal}s, or sometimes for {@link Zombie}s to call
     * reinforcements.
     */
    public static final Class<BreedableData> BREEDABLE_DATA = BreedableData.class;
    /**
     * Mainly for {@link Villager}s to determine their applicable
     * {@link TradeOffer}s.
     */
    public static final Class<CareerData> CAREER_DATA = CareerData.class;
    /**
     * Represents whether an entity is considered "charged". Usually applies
     * to {@link Creeper}s.
     */
    public static final Class<ChargedData> CHARGED_DATA = ChargedData.class;
    /**
     * Signifies that an entity will perform a "critical hit" the next attack.
     * Usually applies to {@link Arrow}s.
     */
    public static final Class<CriticalHitData> CRITICAL_HIT_DATA = CriticalHitData.class;
    /**
     * Signifies that an entity can take damage and tracks it's last damage
     * source. Usually applies to {@link Living} entities.
     */
    public static final Class<DamageableData> DAMAGEABLE_DATA = DamageableData.class;
    /**
     * Signifies that an owner is going to deal a certain amount of damage
     * on the next "attack". Usually applicable to {@link Arrow}s and other
     * {@link Projectile}s.
     */
    public static final Class<DamagingData> DAMAGING_DATA = DamagingData.class;
    /**
     * Represents the custom name of an entity. Usually applies to
     * {@link Player}s and {@link Living} entities.
     */
    public static final Class<DisplayNameData> DISPLAY_NAME_DATA = DisplayNameData.class;
    /**
     * Represents the dominant {@link HandPreference} used by an entity for for "main"
     * interactions such as such as tool use or block breaking. Usually
     * applicable to {@link Living} entities.
     */
    public static final Class<DominantHandData> DOMINANT_HAND_DATA = DominantHandData.class;
    /**
     * Signifies that the entity can be dyed a specific {@link DyeColor}.
     * Usually applies to {@link Sheep}.
     */
    public static final Class<DyeableData> DYEABLE_DATA = DyeableData.class;
    /**
     * Signifies that an entity can hold "experience". Usually applies to
     * {@link Player}s.
     */
    public static final Class<ExperienceHolderData> EXPERIENCE_HOLDER_DATA = ExperienceHolderData.class;
    /**
     * Signifies that an entity can expire after a certain amount of time.
     * Usually applies to {@link Weather}, {@link Endermite}s, and
     * {@link Item}s.
     */
    public static final Class<ExpirableData> EXPIRABLE_DATA_CLASS = ExpirableData.class;
    /**
     * Represents the "explosion radius" that an entity will have upon
     * detonation. Usually applies to all {@link Explosive}s.
     */
    public static final Class<ExplosionRadiusData> EXPLOSIVE_RADIUS_DATA = ExplosionRadiusData.class;
    /**
     * Represents a falling block that can deal damage upon landing.
     * Applies to {@link FallingBlock}s.
     */
    public static final Class<FallingBlockData> FALLING_BLOCK_DATA = FallingBlockData.class;
    /**
     * Represents the {@link FireworkEffect}s that a {@link Firework} will have
     * upon detonation.
     */
    public static final Class<FireworkEffectData> FIREWORK_EFFECT_DATA = FireworkEffectData.class;
    /**
     * Represents the flight time of a {@link Firework}.
     */
    public static final Class<FireworkRocketData> FIREWORK_ROCKET_DATA = FireworkRocketData.class;
    /**
     * Represents when an entity is considering to be "flying". Applicable for
     * almost all types of {@link Entity}.
     */
    public static final Class<FlyingData> FLYING_DATA = FlyingData.class;
    /**
     * Represents the saturation, exhaustion, and food level for an entity.
     * Usually applicable to {@link Player}s.
     */
    public static final Class<FoodData> FOOD_DATA = FoodData.class;
    /**
     * Represents the expiring "fuse" duration on an explosive entity before
     * the {@link Explosive} detonates.
     */
    public static final Class<FuseData> FUSE_DATA = FuseData.class;
    /**
     * Signifies that an entity has a {@link GameMode}. Usually applies to
     * {@link Player}s.
     */
    public static final Class<GameModeData> GAME_MODE_DATA = GameModeData.class;
    /**
     * Represents that an entity has a glowing outline. Few entities, such
     * as {@link Snowball}, do not show this glow.
     * <!-- TODO: Find all non-effected entities -->
     */
    public static final Class<GlowingData> GLOWING_DATA = GlowingData.class;
    /**
     * Signifies that an entity will ignore gravity. Usually applies to all
     * known types of entities.
     */
    public static final Class<GravityData> GRAVITY_DATA = GravityData.class;
    /**
     * Signifies that an entity can modify blocks in the world. Usually applies
     * to {@link Enderman} and {@link Humanoid}s.
     */
    public static final Class<GriefingData> GRIEFING_DATA = GriefingData.class;
    /**
     * Signifies that an entity can have health and dies upon the depletion
     * of health. Usually applies to all {@link Living} entities.
     */
    public static final Class<HealthData> HEALTH_DATA = HealthData.class;
    /**
     * Represents a {@link RideableHorse}s specific data, such as {@link HorseStyle},
     * and {@link HorseColor}.
     */
    public static final Class<HorseData> HORSE_DATA = HorseData.class;
    /**
     * Represents that an entity is self igniting. Usually applies to
     * {@link Blaze}.
     */
    public static final Class<IgniteableData> IGNITEABLE_DATA = IgniteableData.class;
    /**
     * Signifies that an entity is rendered vanish. Usually applies to all
     * known types of {@link Living} entities.
     */
    public static final Class<InvisibilityData> INVISIBILITY_DATA = InvisibilityData.class;
    /**
     * Represents the specific information of an initial joined time on the
     * server. Usually applicable to {@link Player}s and {@link User}s.
     */
    public static final Class<JoinData> JOIN_DATA = JoinData.class;
    /**
     * Represents the "level" of knockback an entity will perform in the
     * next attack. Usually applicable to {@link Arrow}s.
     */
    public static final Class<KnockbackData> KNOCKBACK_DATA = KnockbackData.class;
    /**
     * Represents the information for the {@link Entity} leashing another
     * {@link Entity}. Usually applicable to {@link Living} entities.
     */
    public static final Class<LeashData> LEASH_DATA = LeashData.class;
    /**
     * Represents the target location an entity is either guided or aiming
     * towards. Usually applicable for {@link EyeOfEnder}s.
     */
    public static final Class<TargetedLocationData> LOCATION_DATA = TargetedLocationData.class;
    /**
     * Represents a {@link Minecart} with a {@link BlockState} shown inside.
     */
    public static final Class<MinecartBlockData> MINECART_BLOCK_DATA = MinecartBlockData.class;
    /**
     * Represents the {@link OcelotType} of an {@link Ocelot}.
     */
    public static final Class<OcelotData> OCELOT_DATA = OcelotData.class;
    /**
     * Represents the amount of "experience" an {@link ExperienceOrb}
     * contains.
     */
    public static final Class<ExpOrbData> ORB_DATA = ExpOrbData.class;
    /**
     * Signifies that an entity is a "passenger" riding another {@link Entity}.
     * Usually applicable for all {@link Entity}.
     */
    public static final Class<PassengerData> PASSENGER_DATA = PassengerData.class;
    /**
     * Signifies that an entity will "persist" in the world data. Usually
     * applicable to all {@link Entity}.
     */
    public static final Class<PersistingData> PERSISTING_DATA = PersistingData.class;
    /**
     * Signifies that an entity was created by a {@link Player}. Usually
     * applicable to {@link IronGolem}s.
     */
    public static final Class<PlayerCreatedData> PLAYER_CREATED_DATA = PlayerCreatedData.class;
    /**
     * Signifies that an entity is "playing". Usually applicable to
     * {@link Villager}s.
     */
    public static final Class<PlayingData> PLAYING_DATA = PlayingData.class;
    /**
     * Signifies that an entity is currently affected by some variety of
     * {@link PotionEffect}s. Applicable to all {@link Entity}.
     */
    public static final Class<PotionEffectData> POTION_EFFECT_DATA = PotionEffectData.class;
    /**
     * Represents the {@link RabbitType} of a {@link Rabbit}.
     */
    public static final Class<RabbitData> RABBIT_DATA = RabbitData.class;
    /**
     * Signifies that an entity is representing an {@link ItemStack}.
     * Usually applicable to {@link Item}s and {@link ItemFrame}s.
     */
    public static final Class<RepresentedItemData> REPRESENTED_ITEM_DATA = RepresentedItemData.class;
    /**
     * Signifies that an entity will respawn after death and has a respawn
     * location. Usually applicable to {@link Player}s.
     */
    public static final Class<RespawnLocationData> RESPAWN_LOCATION_DATA = RespawnLocationData.class;
    /**
     * Signifies that an entity has a "saddle". Usually applicable to
     * {@link Pig}s.
     */
    public static final Class<PigSaddleData> PIG_SADDLE_DATA = PigSaddleData.class;
    /**
     * Signifies that an entity is currently "screaming". Usually applicable
     * to {@link Enderman}.
     */
    public static final Class<ScreamingData> SCREAMING_DATA = ScreamingData.class;
    /**
     * Signifies that an entity is currently "silent", and will play no sounds.
     * Usually applicable to all {@link Entity Entities}.
     */
    public static final Class<SilentData> SILENT_DATA = SilentData.class;
    /**
     * Signifies that an entity will "shatter" upon expiration. Usually
     * applicable to {@link EyeOfEnder}.
     */
    public static final Class<ShatteringData> SHATTERING_DATA = ShatteringData.class;
    /**
     * Signifies that an entity is currently "sheared" and will regrow at some
     * point. Usually applicable to {@link Sheep}.
     */
    public static final Class<ShearedData> SHEARED_DATA = ShearedData.class;
    /**
     * Signifies that an entity is currently sitting. Usually applicable to
     * {@link Wolf} and {@link Ocelot}s.
     */
    public static final Class<SittingData> SITTING_DATA = SittingData.class;
    /**
     * Represents the base and height sizes of an entity if it has physical
     * form. Usually applies to all types of {@link Entity}.
     */
    public static final Class<SizeData> SIZE_DATA = SizeData.class;
    /**
     * Signifies that the owner is currently "sleeping". This will usually
     * apply to {@link Humanoid}s and {@link Bat}s.
     */
    public static final Class<SleepingData> SLEEPING_DATA = SleepingData.class;
    /**
     * Represents the size of a {@link Slime}. Usually applicable to all
     * {@link Slime}s and {@link MagmaCube}s.
     */
    public static final Class<SlimeData> SLIME_DATA = SlimeData.class;
    /**
     * Signifies that an entity is currently "sneaking". Usually applicable to
     * {@link Player}s.
     */
    public static final Class<SneakingData> SNEAKING_DATA = SneakingData.class;
    /**
     * Represents the container of all known applied {@link Statistic}s. Usually
     * applicable to {@link Player}s and {@link User}s.
     */
    public static final Class<StatisticData> STATISTIC_DATA = StatisticData.class;
    /**
     * Signifies that an entity is "tamed" and has an owner. Usually applicable
     * to {@link RideableHorse}s, {@link Ocelot}s, and {@link Wolf} entities.
     */
    public static final Class<TameableData> TAMEABLE_DATA = TameableData.class;
    /**
     * Signifies that an entity is currently being ridden by another
     * {@link Entity}.
     */
    public static final Class<VehicleData> VEHICLE_DATA = VehicleData.class;
    /**
     * Represents the current velocity of an entity. Applicable to all
     * {@link Entity}.
     */
    public static final Class<VelocityData> VELOCITY_DATA = VelocityData.class;
    /**
     * Signifies that an entity is currently "wet". Usually applicable to
     * {@link Wolf} entities.
     */
    public static final Class<WetData> WET_DATA = WetData.class;

    private CatalogEntityData() {
    }

}

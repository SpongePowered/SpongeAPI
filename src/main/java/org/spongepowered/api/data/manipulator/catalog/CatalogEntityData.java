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

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.attribute.Attribute;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.manipulator.AttributeData;
import org.spongepowered.api.data.manipulator.DisplayNameData;
import org.spongepowered.api.data.manipulator.DyeableData;
import org.spongepowered.api.data.manipulator.FireworkData;
import org.spongepowered.api.data.manipulator.OwnableData;
import org.spongepowered.api.data.manipulator.PotionEffectData;
import org.spongepowered.api.data.manipulator.RepresentedItemData;
import org.spongepowered.api.data.manipulator.TargetedLocationData;
import org.spongepowered.api.data.manipulator.WetData;
import org.spongepowered.api.data.manipulator.entity.AchievementData;
import org.spongepowered.api.data.manipulator.entity.AgeableData;
import org.spongepowered.api.data.manipulator.entity.AgentData;
import org.spongepowered.api.data.manipulator.entity.AggressiveData;
import org.spongepowered.api.data.manipulator.entity.AngerableData;
import org.spongepowered.api.data.manipulator.entity.ArtData;
import org.spongepowered.api.data.manipulator.entity.BanData;
import org.spongepowered.api.data.manipulator.entity.BodyPartRotationalData;
import org.spongepowered.api.data.manipulator.entity.BreathingData;
import org.spongepowered.api.data.manipulator.entity.BreedableData;
import org.spongepowered.api.data.manipulator.entity.CareerData;
import org.spongepowered.api.data.manipulator.entity.ChargedData;
import org.spongepowered.api.data.manipulator.entity.CriticalHitData;
import org.spongepowered.api.data.manipulator.entity.DamageableData;
import org.spongepowered.api.data.manipulator.entity.DamagingData;
import org.spongepowered.api.data.manipulator.entity.ElderData;
import org.spongepowered.api.data.manipulator.entity.ExperienceHolderData;
import org.spongepowered.api.data.manipulator.entity.ExpirableData;
import org.spongepowered.api.data.manipulator.entity.ExplosiveRadiusData;
import org.spongepowered.api.data.manipulator.entity.EyeLocationData;
import org.spongepowered.api.data.manipulator.entity.FallingBlockData;
import org.spongepowered.api.data.manipulator.entity.FlyingData;
import org.spongepowered.api.data.manipulator.entity.FoodData;
import org.spongepowered.api.data.manipulator.entity.FuseData;
import org.spongepowered.api.data.manipulator.entity.GameModeData;
import org.spongepowered.api.data.manipulator.entity.GriefingData;
import org.spongepowered.api.data.manipulator.entity.HealingSourceData;
import org.spongepowered.api.data.manipulator.entity.HealthData;
import org.spongepowered.api.data.manipulator.entity.HorseData;
import org.spongepowered.api.data.manipulator.entity.IgniteableData;
import org.spongepowered.api.data.manipulator.entity.InvisibilityData;
import org.spongepowered.api.data.manipulator.entity.JoinData;
import org.spongepowered.api.data.manipulator.entity.KnockbackData;
import org.spongepowered.api.data.manipulator.entity.LeashData;
import org.spongepowered.api.data.manipulator.entity.OcelotData;
import org.spongepowered.api.data.manipulator.entity.OrbData;
import org.spongepowered.api.data.manipulator.entity.PassengerData;
import org.spongepowered.api.data.manipulator.entity.PersistingData;
import org.spongepowered.api.data.manipulator.entity.PlayerCreatedData;
import org.spongepowered.api.data.manipulator.entity.PlayingData;
import org.spongepowered.api.data.manipulator.entity.RabbitData;
import org.spongepowered.api.data.manipulator.entity.RespawnLocationData;
import org.spongepowered.api.data.manipulator.entity.SaddleData;
import org.spongepowered.api.data.manipulator.entity.ScreamingData;
import org.spongepowered.api.data.manipulator.entity.ShatteringData;
import org.spongepowered.api.data.manipulator.entity.ShearedData;
import org.spongepowered.api.data.manipulator.entity.SittingData;
import org.spongepowered.api.data.manipulator.entity.SizeData;
import org.spongepowered.api.data.manipulator.entity.SkeletonData;
import org.spongepowered.api.data.manipulator.entity.SleepingData;
import org.spongepowered.api.data.manipulator.entity.SlimeData;
import org.spongepowered.api.data.manipulator.entity.SneakingData;
import org.spongepowered.api.data.manipulator.entity.StatisticData;
import org.spongepowered.api.data.manipulator.entity.TameableData;
import org.spongepowered.api.data.manipulator.entity.TargetLivingData;
import org.spongepowered.api.data.manipulator.entity.VehicleData;
import org.spongepowered.api.data.manipulator.entity.VelocityData;
import org.spongepowered.api.data.manipulator.entity.VillagerZombieData;
import org.spongepowered.api.data.manipulator.entity.WhitelistData;
import org.spongepowered.api.data.type.Art;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.HorseVariant;
import org.spongepowered.api.data.type.OcelotType;
import org.spongepowered.api.data.type.RabbitType;
import org.spongepowered.api.data.type.SkeletonType;
import org.spongepowered.api.entity.EnderCrystal;
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
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.Villager;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Horse;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.Rabbit;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.complex.EnderDragon;
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
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.entity.projectile.Arrow;
import org.spongepowered.api.entity.projectile.EyeOfEnder;
import org.spongepowered.api.entity.projectile.Firework;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.achievement.Achievement;
import org.spongepowered.api.util.ban.Ban;
import org.spongepowered.api.world.weather.Weather;

/**
 * An enumeration of all known vanilla {@link DataManipulator}s that may be
 * applicable to any {@link Entity}.
 */
public final class CatalogEntityData {

    /**
     * The {@link AchievementData} class that can be applied to
     * {@link Player}s.
     */
    public static final Class<AchievementData> ACHIEVEMENT_DATA = AchievementData.class;
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
     * The {@link AttributeData} for many entities signifying various
     * {@link Attribute}s applied and manipulated.
     */
    public static final Class<AttributeData> ATTRIBUTE_DATA = AttributeData.class;
    /**
     * The {@link BanData} mainly for {@link User}s and their {@link Ban}s.
     */
    public static final Class<BanData> BAN_DATA = BanData.class;
    /**
     * Represents the mapped rotational data for all known body parts. Usually
     * applicable to {@link Human}s and {@link ArmorStand}s.
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
     * Signifies that the entity can be dyed a specific {@link DyeColor}.
     * Usually applies to {@link Sheep}.
     */
    public static final Class<DyeableData> DYEABLE_DATA = DyeableData.class;
    /**
     * Signifies that an entity is considered an "elder". Usually applies to
     * {@link Guardian}s.
     */
    public static final Class<ElderData> ELDER_DATA = ElderData.class;
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
    public static final Class<ExplosiveRadiusData> EXPLOSIVE_RADIUS_DATA = ExplosiveRadiusData.class;
    /**
     * Represents an entity having the notion of a "head" and "eye location".
     * Usually applies to all {@link Living} entities.
     */
    public static final Class<EyeLocationData> EYE_LOCATION_DATA = EyeLocationData.class;
    /**
     * Represents a falling block that can deal damage upon landing.
     * Applies to {@link FallingBlock}s.
     */
    public static final Class<FallingBlockData> FALLING_BLOCK_DATA = FallingBlockData.class;
    /**
     * Represents the {@link FireworkEffect}s that a {@link Firework} will have
     * upon detonation.
     */
    public static final Class<FireworkData> FIREWORK_DATA = FireworkData.class;
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
     * Signifies that an entity can modify blocks in the world. Usually applies
     * to {@link Enderman} and {@link Human}s.
     */
    public static final Class<GriefingData> GRIEFING_DATA = GriefingData.class;
    /**
     * Signifies that an {@link Entity} is "healing" the owning
     * {@link DataHolder}. Usually applicable to {@link EnderDragon}s being healed
     * by {@link EnderCrystal}s.
     */
    public static final Class<HealingSourceData> HEALING_SOURCE_DATA = HealingSourceData.class;
    /**
     * Signifies that an entity can have health and dies upon the depletion
     * of health. Usually applies to all {@link Living} entities.
     */
    public static final Class<HealthData> HEALTH_DATA = HealthData.class;
    /**
     * Represents a {@link Horse}s specific data, such as {@link HorseVariant},
     * {@link HorseStyle}, and {@link HorseColor}.
     */
    public static final Class<HorseData> HORSE_DATA = HorseData.class;
    /**
     * Represents that an entity is self igniting. Usually applies to
     * {@link Blaze}.
     */
    public static final Class<IgniteableData> IGNITEABLE_DATA = IgniteableData.class;
    /**
     * Signifies that an entity is rendered invisible. Usually applies to all
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
     * Represents the {@link OcelotType} of an {@link Ocelot}.
     */
    public static final Class<OcelotData> OCELOT_DATA = OcelotData.class;
    /**
     * Represents the amount of "experience" an {@link ExperienceOrb}
     * contains.
     */
    public static final Class<OrbData> ORB_DATA = OrbData.class;
    /**
     * Signifies that an entity is owned by a {@link GameProfile}. Usually
     * applicable to {@link Living} entities.
     */
    public static final Class<OwnableData> OWNABLE_DATA = OwnableData.class;
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
     * {@link Pig}. and {@link Horse}s.
     */
    public static final Class<SaddleData> SADDLE_DATA = SaddleData.class;
    /**
     * Signifies that an entity is currently "screaming". Usually applicable
     * to {@link Enderman}.
     */
    public static final Class<ScreamingData> SCREAMING_DATA = ScreamingData.class;
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
     * Represents the {@link SkeletonType} of a {@link Skeleton}.
     */
    public static final Class<SkeletonData> SKELETON_DATA = SkeletonData.class;
    /**
     * Signifies that the owner is currently "sleeping". This will usually
     * apply to {@link Human}s and {@link Bat}s.
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
     * Represents the container of all known applied {@link Statistic}s and
     * {@link Achievement}s. Usually applicable to {@link Player}s and
     * {@link User}s.
     */
    public static final Class<StatisticData> STATISTIC_DATA = StatisticData.class;
    /**
     * Signifies that an entity is "tamed" and has an owner. Usually applicable
     * to {@link Horse}s, {@link Ocelot}s, and {@link Wolf} entities.
     */
    public static final Class<TameableData> TAMEABLE_DATA = TameableData.class;
    /**
     * Represents the current targets of an owner that is "targeting" some
     * {@link Living} entities. Usually applicable to almost all {@link Agent}s.
     */
    public static final Class<TargetLivingData> TARGET_LIVING_DATA = TargetLivingData.class;
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
     * Signifies that a {@link Zombie} is a "villager" zombie. Usually
     * applicable to all {@link Zombie}s.
     */
    public static final Class<VillagerZombieData> VILLAGER_ZOMBIE_DATA = VillagerZombieData.class;
    /**
     * Signifies that an entity is currently "wet". Usually applicable to
     * {@link Wolf} entities.
     */
    public static final Class<WetData> WET_DATA = WetData.class;
    /**
     * Signifies that a {@link Player} or {@link User} is "whitelisted" on the
     * server.
     */
    public static final Class<WhitelistData> WHITELIST_DATA = WhitelistData.class;

    private CatalogEntityData() {
    }

}

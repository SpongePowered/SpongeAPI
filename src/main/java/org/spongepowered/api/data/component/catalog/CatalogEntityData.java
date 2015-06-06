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
package org.spongepowered.api.data.component.catalog;

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.attribute.Attribute;
import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.component.base.AttributeComponent;
import org.spongepowered.api.data.component.base.DisplayNameComponent;
import org.spongepowered.api.data.component.base.DyeableComponent;
import org.spongepowered.api.data.component.base.FireworkComponent;
import org.spongepowered.api.data.component.base.OwnableComponent;
import org.spongepowered.api.data.component.base.PotionEffectComponent;
import org.spongepowered.api.data.component.base.RepresentedItemComponent;
import org.spongepowered.api.data.component.base.TargetedLocationComponent;
import org.spongepowered.api.data.component.base.WetComponent;
import org.spongepowered.api.data.component.entity.AchievementComponent;
import org.spongepowered.api.data.component.entity.AgeableComponent;
import org.spongepowered.api.data.component.entity.AgentComponent;
import org.spongepowered.api.data.component.entity.AggressiveComponent;
import org.spongepowered.api.data.component.entity.AngerableComponent;
import org.spongepowered.api.data.component.entity.ArtComponent;
import org.spongepowered.api.data.component.entity.BanComponent;
import org.spongepowered.api.data.component.entity.BodyPartRotationalComponent;
import org.spongepowered.api.data.component.entity.BreathingComponent;
import org.spongepowered.api.data.component.entity.BreedableComponent;
import org.spongepowered.api.data.component.entity.CareerComponent;
import org.spongepowered.api.data.component.entity.ChargedComponent;
import org.spongepowered.api.data.component.entity.CriticalHitComponent;
import org.spongepowered.api.data.component.entity.DamageableComponent;
import org.spongepowered.api.data.component.entity.DamagingComponent;
import org.spongepowered.api.data.component.entity.ElderComponent;
import org.spongepowered.api.data.component.entity.ExperienceHolderComponent;
import org.spongepowered.api.data.component.entity.ExpirableComponent;
import org.spongepowered.api.data.component.entity.ExplosiveRadiusComponent;
import org.spongepowered.api.data.component.entity.EyeLocationComponent;
import org.spongepowered.api.data.component.entity.FallingBlockComponent;
import org.spongepowered.api.data.component.entity.FlyingComponent;
import org.spongepowered.api.data.component.entity.FoodComponent;
import org.spongepowered.api.data.component.entity.FuseComponent;
import org.spongepowered.api.data.component.entity.GameModeComponent;
import org.spongepowered.api.data.component.entity.GriefingComponent;
import org.spongepowered.api.data.component.entity.HealingSourceComponent;
import org.spongepowered.api.data.component.entity.HealthComponent;
import org.spongepowered.api.data.component.entity.HorseComponent;
import org.spongepowered.api.data.component.entity.IgniteableComponent;
import org.spongepowered.api.data.component.entity.InvisibilityComponent;
import org.spongepowered.api.data.component.entity.JoinComponent;
import org.spongepowered.api.data.component.entity.KnockbackComponent;
import org.spongepowered.api.data.component.entity.LeashComponent;
import org.spongepowered.api.data.component.entity.OcelotComponent;
import org.spongepowered.api.data.component.entity.OrbComponent;
import org.spongepowered.api.data.component.entity.PassengerComponent;
import org.spongepowered.api.data.component.entity.PersistingComponent;
import org.spongepowered.api.data.component.entity.PlayerCreatedComponent;
import org.spongepowered.api.data.component.entity.PlayingComponent;
import org.spongepowered.api.data.component.entity.RabbitComponent;
import org.spongepowered.api.data.component.entity.RespawnLocationComponent;
import org.spongepowered.api.data.component.entity.SaddleComponent;
import org.spongepowered.api.data.component.entity.ScreamingComponent;
import org.spongepowered.api.data.component.entity.ShatteringComponent;
import org.spongepowered.api.data.component.entity.ShearedComponent;
import org.spongepowered.api.data.component.entity.SittingComponent;
import org.spongepowered.api.data.component.entity.SizeComponent;
import org.spongepowered.api.data.component.entity.SkeletonComponent;
import org.spongepowered.api.data.component.entity.SleepingComponent;
import org.spongepowered.api.data.component.entity.SlimeComponent;
import org.spongepowered.api.data.component.entity.SneakingComponent;
import org.spongepowered.api.data.component.entity.StatisticComponent;
import org.spongepowered.api.data.component.entity.TameableComponent;
import org.spongepowered.api.data.component.entity.TargetLivingComponent;
import org.spongepowered.api.data.component.entity.VehicleComponent;
import org.spongepowered.api.data.component.entity.VelocityComponent;
import org.spongepowered.api.data.component.entity.VillagerZombieComponent;
import org.spongepowered.api.data.component.entity.WhitelistComponent;
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
 * An enumeration of all known vanilla {@link Component}s that may be
 * applicable to any {@link Entity}.
 */
public final class CatalogEntityData {

    /**
     * The {@link AchievementComponent} class that can be applied to
     * {@link Player}s.
     */
    public static final Class<AchievementComponent> ACHIEVEMENT_COMPONENT = AchievementComponent.class;
    /**
     * The {@link AgeableComponent} that represents age determining whether an
     * {@link Entity} is a child or an adult. Always exists for
     * {@link Ageable} entities.
     */
    public static final Class<AgeableComponent> AGEABLE_COMPONENT = AgeableComponent.class;
    /**
     * The {@link AgentComponent} that signifies that an {@link Agent}'s AI is
     * enabled.
     */
    public static final Class<AgentComponent> AGENT_COMPONENT = AgentComponent.class;
    /**
     * The {@link AggressiveComponent} that signifies whether an {@link Agent} is
     * considered aggressive, may attack other entities.
     */
    public static final Class<AggressiveComponent> AGGRESSIVE_COMPONENT = AggressiveComponent.class;
    /**
     * The {@link AngerableComponent} that signifies an {@link Agent} is angry but
     * will calm down after a certain amount of time has passed.
     */
    public static final Class<AngerableComponent> ANGERABLE_COMPONENT = AngerableComponent.class;
    /**
     * The {@link ArtComponent} that signifies what piece of {@link Art} is being
     * displayed. It is applicable for {@link Painting} entities.
     */
    public static final Class<ArtComponent> ART_COMPONENT = ArtComponent.class;
    /**
     * The {@link AttributeComponent} for many entities signifying various
     * {@link Attribute}s applied and manipulated.
     */
    public static final Class<AttributeComponent> ATTRIBUTE_COMPONENT = AttributeComponent.class;
    /**
     * The {@link BanComponent} mainly for {@link User}s and their {@link Ban}s.
     */
    public static final Class<BanComponent> BAN_COMPONENT = BanComponent.class;
    /**
     * Represents the mapped rotational data for all known body parts. Usually
     * applicable to {@link Human}s and {@link ArmorStand}s.
     */
    public static final Class<BodyPartRotationalComponent> BODY_PART_ROTATIONAL_COMPONENT = BodyPartRotationalComponent.class;
    /**
     * Entities that have {@link BreathingComponent} when under water. Usually
     * applies to {@link Living} entities but not {@link Aquatic} entities.
     */
    public static final Class<BreathingComponent> BREATHING_COMPONENT = BreathingComponent.class;
    /**
     * Signifies an entity is ready to breed. Usually applies to
     * {@link Animal}s, or sometimes for {@link Zombie}s to call
     * reinforcements.
     */
    public static final Class<BreedableComponent> BREEDABLE_COMPONENT = BreedableComponent.class;
    /**
     * Mainly for {@link Villager}s to determine their applicable
     * {@link TradeOffer}s.
     */
    public static final Class<CareerComponent> CAREER_COMPONENT = CareerComponent.class;
    /**
     * Represents whether an entity is considered "charged". Usually applies
     * to {@link Creeper}s.
     */
    public static final Class<ChargedComponent> CHARGED_COMPONENT = ChargedComponent.class;
    /**
     * Signifies that an entity will perform a "critical hit" the next attack.
     * Usually applies to {@link Arrow}s.
     */
    public static final Class<CriticalHitComponent> CRITICAL_HIT_COMPONENT = CriticalHitComponent.class;
    /**
     * Signifies that an entity can take damage and tracks it's last damage
     * source. Usually applies to {@link Living} entities.
     */
    public static final Class<DamageableComponent> DAMAGEABLE_COMPONENT = DamageableComponent.class;
    /**
     * Signifies that an owner is going to deal a certain amount of damage
     * on the next "attack". Usually applicable to {@link Arrow}s and other
     * {@link Projectile}s.
     */
    public static final Class<DamagingComponent> DAMAGING_COMPONENT = DamagingComponent.class;
    /**
     * Represents the custom name of an entity. Usually applies to
     * {@link Player}s and {@link Living} entities.
     */
    public static final Class<DisplayNameComponent> DISPLAY_NAME_COMPONENT = DisplayNameComponent.class;
    /**
     * Signifies that the entity can be dyed a specific {@link DyeColor}.
     * Usually applies to {@link Sheep}.
     */
    public static final Class<DyeableComponent> DYEABLE_COMPONENT = DyeableComponent.class;
    /**
     * Signifies that an entity is considered an "elder". Usually applies to
     * {@link Guardian}s.
     */
    public static final Class<ElderComponent> ELDER_COMPONENT = ElderComponent.class;
    /**
     * Signifies that an entity can hold "experience". Usually applies to
     * {@link Player}s.
     */
    public static final Class<ExperienceHolderComponent> EXPERIENCE_HOLDER_COMPONENT = ExperienceHolderComponent.class;
    /**
     * Signifies that an entity can expire after a certain amount of time.
     * Usually applies to {@link Weather}, {@link Endermite}s, and
     * {@link Item}s.
     */
    public static final Class<ExpirableComponent> EXPIRABLE_COMPONENT_CLASS = ExpirableComponent.class;
    /**
     * Represents the "explosion radius" that an entity will have upon
     * detonation. Usually applies to all {@link Explosive}s.
     */
    public static final Class<ExplosiveRadiusComponent> EXPLOSIVE_RADIUS_COMPONENT = ExplosiveRadiusComponent.class;
    /**
     * Represents an entity having the notion of a "head" and "eye location".
     * Usually applies to all {@link Living} entities.
     */
    public static final Class<EyeLocationComponent> EYE_LOCATION_COMPONENT = EyeLocationComponent.class;
    /**
     * Represents a falling block that can deal damage upon landing.
     * Applies to {@link FallingBlock}s.
     */
    public static final Class<FallingBlockComponent> FALLING_BLOCK_COMPONENT = FallingBlockComponent.class;
    /**
     * Represents the {@link FireworkEffect}s that a {@link Firework} will have
     * upon detonation.
     */
    public static final Class<FireworkComponent> FIREWORK_COMPONENT = FireworkComponent.class;
    /**
     * Represents when an entity is considering to be "flying". Applicable for
     * almost all types of {@link Entity}.
     */
    public static final Class<FlyingComponent> FLYING_COMPONENT = FlyingComponent.class;
    /**
     * Represents the saturation, exhaustion, and food level for an entity.
     * Usually applicable to {@link Player}s.
     */
    public static final Class<FoodComponent> FOOD_COMPONENT = FoodComponent.class;
    /**
     * Represents the expiring "fuse" duration on an explosive entity before
     * the {@link Explosive} detonates.
     */
    public static final Class<FuseComponent> FUSE_COMPONENT = FuseComponent.class;
    /**
     * Signifies that an entity has a {@link GameMode}. Usually applies to
     * {@link Player}s.
     */
    public static final Class<GameModeComponent> GAME_MODE_COMPONENT = GameModeComponent.class;
    /**
     * Signifies that an entity can modify blocks in the world. Usually applies
     * to {@link Enderman} and {@link Human}s.
     */
    public static final Class<GriefingComponent> GRIEFING_COMPONENT = GriefingComponent.class;
    /**
     * Signifies that an {@link Entity} is "healing" the owning
     * {@link DataHolder}. Usually applicable to {@link EnderDragon}s being healed
     * by {@link EnderCrystal}s.
     */
    public static final Class<HealingSourceComponent> HEALING_SOURCE_COMPONENT = HealingSourceComponent.class;
    /**
     * Signifies that an entity can have health and dies upon the depletion
     * of health. Usually applies to all {@link Living} entities.
     */
    public static final Class<HealthComponent> HEALTH_COMPONENT = HealthComponent.class;
    /**
     * Represents a {@link Horse}s specific data, such as {@link HorseVariant},
     * {@link HorseStyle}, and {@link HorseColor}.
     */
    public static final Class<HorseComponent> HORSE_COMPONENT = HorseComponent.class;
    /**
     * Represents that an entity is self igniting. Usually applies to
     * {@link Blaze}.
     */
    public static final Class<IgniteableComponent> IGNITEABLE_COMPONENT = IgniteableComponent.class;
    /**
     * Signifies that an entity is rendered invisible. Usually applies to all
     * known types of {@link Living} entities.
     */
    public static final Class<InvisibilityComponent> INVISIBILITY_COMPONENT = InvisibilityComponent.class;
    /**
     * Represents the specific information of an initial joined time on the
     * server. Usually applicable to {@link Player}s and {@link User}s.
     */
    public static final Class<JoinComponent> JOIN_COMPONENT = JoinComponent.class;
    /**
     * Represents the "level" of knockback an entity will perform in the
     * next attack. Usually applicable to {@link Arrow}s.
     */
    public static final Class<KnockbackComponent> KNOCKBACK_COMPONENT = KnockbackComponent.class;
    /**
     * Represents the information for the {@link Entity} leashing another
     * {@link Entity}. Usually applicable to {@link Living} entities.
     */
    public static final Class<LeashComponent> LEASH_COMPONENT = LeashComponent.class;
    /**
     * Represents the target location an entity is either guided or aiming
     * towards. Usually applicable for {@link EyeOfEnder}s.
     */
    public static final Class<TargetedLocationComponent> LOCATION_COMPONENT = TargetedLocationComponent.class;
    /**
     * Represents the {@link OcelotType} of an {@link Ocelot}.
     */
    public static final Class<OcelotComponent> OCELOT_COMPONENT = OcelotComponent.class;
    /**
     * Represents the amount of "experience" an {@link ExperienceOrb}
     * contains.
     */
    public static final Class<OrbComponent> ORB_COMPONENT = OrbComponent.class;
    /**
     * Signifies that an entity is owned by a {@link GameProfile}. Usually
     * applicable to {@link Living} entities.
     */
    public static final Class<OwnableComponent> OWNABLE_COMPONENT = OwnableComponent.class;
    /**
     * Signifies that an entity is a "passenger" riding another {@link Entity}.
     * Usually applicable for all {@link Entity}.
     */
    public static final Class<PassengerComponent> PASSENGER_COMPONENT = PassengerComponent.class;
    /**
     * Signifies that an entity will "persist" in the world data. Usually
     * applicable to all {@link Entity}.
     */
    public static final Class<PersistingComponent> PERSISTING_COMPONENT = PersistingComponent.class;
    /**
     * Signifies that an entity was created by a {@link Player}. Usually
     * applicable to {@link IronGolem}s.
     */
    public static final Class<PlayerCreatedComponent> PLAYER_CREATED_COMPONENT = PlayerCreatedComponent.class;
    /**
     * Signifies that an entity is "playing". Usually applicable to
     * {@link Villager}s.
     */
    public static final Class<PlayingComponent> PLAYING_COMPONENT = PlayingComponent.class;
    /**
     * Signifies that an entity is currently affected by some variety of
     * {@link PotionEffect}s. Applicable to all {@link Entity}.
     */
    public static final Class<PotionEffectComponent> POTION_EFFECT_COMPONENT = PotionEffectComponent.class;
    /**
     * Represents the {@link RabbitType} of a {@link Rabbit}.
     */
    public static final Class<RabbitComponent> RABBIT_COMPONENT = RabbitComponent.class;
    /**
     * Signifies that an entity is representing an {@link ItemStack}.
     * Usually applicable to {@link Item}s and {@link ItemFrame}s.
     */
    public static final Class<RepresentedItemComponent> REPRESENTED_ITEM_COMPONENT = RepresentedItemComponent.class;
    /**
     * Signifies that an entity will respawn after death and has a respawn
     * location. Usually applicable to {@link Player}s.
     */
    public static final Class<RespawnLocationComponent> RESPAWN_LOCATION_COMPONENT = RespawnLocationComponent.class;
    /**
     * Signifies that an entity has a "saddle". Usually applicable to
     * {@link Pig}. and {@link Horse}s.
     */
    public static final Class<SaddleComponent> SADDLE_COMPONENT = SaddleComponent.class;
    /**
     * Signifies that an entity is currently "screaming". Usually applicable
     * to {@link Enderman}.
     */
    public static final Class<ScreamingComponent> SCREAMING_COMPONENT = ScreamingComponent.class;
    /**
     * Signifies that an entity will "shatter" upon expiration. Usually
     * applicable to {@link EyeOfEnder}.
     */
    public static final Class<ShatteringComponent> SHATTERING_COMPONENT = ShatteringComponent.class;
    /**
     * Signifies that an entity is currently "sheared" and will regrow at some
     * point. Usually applicable to {@link Sheep}.
     */
    public static final Class<ShearedComponent> SHEARED_COMPONENT = ShearedComponent.class;
    /**
     * Signifies that an entity is currently sitting. Usually applicable to
     * {@link Wolf} and {@link Ocelot}s.
     */
    public static final Class<SittingComponent> SITTING_COMPONENT = SittingComponent.class;
    /**
     * Represents the base and height sizes of an entity if it has physical
     * form. Usually applies to all types of {@link Entity}.
     */
    public static final Class<SizeComponent> SIZE_COMPONENT = SizeComponent.class;
    /**
     * Represents the {@link SkeletonType} of a {@link Skeleton}.
     */
    public static final Class<SkeletonComponent> SKELETON_COMPONENT = SkeletonComponent.class;
    /**
     * Signifies that the owner is currently "sleeping". This will usually
     * apply to {@link Human}s and {@link Bat}s.
     */
    public static final Class<SleepingComponent> SLEEPING_COMPONENT = SleepingComponent.class;
    /**
     * Represents the size of a {@link Slime}. Usually applicable to all
     * {@link Slime}s and {@link MagmaCube}s.
     */
    public static final Class<SlimeComponent> SLIME_COMPONENT = SlimeComponent.class;
    /**
     * Signifies that an entity is currently "sneaking". Usually applicable to
     * {@link Player}s.
     */
    public static final Class<SneakingComponent> SNEAKING_COMPONENT = SneakingComponent.class;
    /**
     * Represents the container of all known applied {@link Statistic}s and
     * {@link Achievement}s. Usually applicable to {@link Player}s and
     * {@link User}s.
     */
    public static final Class<StatisticComponent> STATISTIC_COMPONENT = StatisticComponent.class;
    /**
     * Signifies that an entity is "tamed" and has an owner. Usually applicable
     * to {@link Horse}s, {@link Ocelot}s, and {@link Wolf} entities.
     */
    public static final Class<TameableComponent> TAMEABLE_COMPONENT = TameableComponent.class;
    /**
     * Represents the current targets of an owner that is "targeting" some
     * {@link Living} entities. Usually applicable to almost all {@link Agent}s.
     */
    public static final Class<TargetLivingComponent> TARGET_LIVING_COMPONENT = TargetLivingComponent.class;
    /**
     * Signifies that an entity is currently being ridden by another
     * {@link Entity}.
     */
    public static final Class<VehicleComponent> VEHICLE_COMPONENT = VehicleComponent.class;
    /**
     * Represents the current velocity of an entity. Applicable to all
     * {@link Entity}.
     */
    public static final Class<VelocityComponent> VELOCITY_COMPONENT = VelocityComponent.class;
    /**
     * Signifies that a {@link Zombie} is a "villager" zombie. Usually
     * applicable to all {@link Zombie}s.
     */
    public static final Class<VillagerZombieComponent> VILLAGER_ZOMBIE_COMPONENT = VillagerZombieComponent.class;
    /**
     * Signifies that an entity is currently "wet". Usually applicable to
     * {@link Wolf} entities.
     */
    public static final Class<WetComponent> WET_COMPONENT = WetComponent.class;
    /**
     * Signifies that a {@link Player} or {@link User} is "whitelisted" on the
     * server.
     */
    public static final Class<WhitelistComponent> WHITELIST_COMPONENT = WhitelistComponent.class;

    private CatalogEntityData() {
    }

}

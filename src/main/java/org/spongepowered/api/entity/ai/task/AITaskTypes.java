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
package org.spongepowered.api.entity.ai.task;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.RangedAttackingAgent;
import org.spongepowered.api.entity.living.Villager;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Horse;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Tameable;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Monster;
import org.spongepowered.api.entity.living.monster.ZombiePigman;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.function.Predicate;

public final class AITaskTypes {

    // SORTFIELDS:ON

    /**
     * {@link AITask} where {@link Tameable}s attack a {@link Living} which its
     * {@link Tamer} attacks.
     */
    public static final AITaskType ATTACK_AFTER_OWNER = DummyObjectProvider.createFor(AITaskType.class, "ATTACK_AFTER_OWNER");

    /**
     * {@link AITask} where {@link Creature}s attack its target or a type of
     * {@link Living}.
     */
    public static final AITaskType ATTACK_LIVING = DummyObjectProvider.createFor(AITaskType.class, "ATTACK_LIVING");

    /**
     * {@link AITask} where {@link IronGolem}s attack {@link Monster}s that are
     * not {@link Creeper}s.
     */
    public static final AITaskType ATTACK_NEAREST_NON_CREEPER_TARGET = DummyObjectProvider.createFor(AITaskType.class,

            "ATTACK_NEAREST_NON_CREEPER_TARGET");
    /**
     * {@link AITask} where {@link Creature}s avoid other {@link Agent}s based
     * on a {@link Predicate}.
     */
    public static final AITaskType AVOID_ENTITY = DummyObjectProvider.createFor(AITaskType.class, "AVOID_ENTITY");

    /**
     * {@link AITask} where {@link Creature}s avoid a path that walks through a
     * door.
     */
    public static final AITaskType AVOID_OPEN_DOOR = DummyObjectProvider.createFor(AITaskType.class, "AVOID_OPEN_DOOR");

    /**
     * {@link AITask} where {@link Creature}s avoid a path that exposes under
     * the sky at daytime.
     */
    public static final AITaskType AVOID_SUN = DummyObjectProvider.createFor(AITaskType.class, "AVOID_SUN");

    /**
     * {@link AITask} where {@link Wolf}s beg for bones or meat from
     * {@link Humanoid}s.
     */
    public static final AITaskType BEG = DummyObjectProvider.createFor(AITaskType.class, "BEG");

    /**
     * {@link AITask} where {@link Creature}s, such as {@link Horse}s, are
     * ridden by a player and follow the order of a player.
     */
    public static final AITaskType CONTROLLED_BY_PLAYER = DummyObjectProvider.createFor(AITaskType.class, "CONTROLLED_BY_PLAYER");

    /**
     * {@link AITask} where {@link IronGolem}s in the villages find
     * {@link Monster}s that aren't {@link Creeper}s to attack.
     */
    public static final AITaskType DEFEND_VILLAGE = DummyObjectProvider.createFor(AITaskType.class, "DEFEND_VILLAGE");

    /**
     * {@link AITask} where {@link Agent}s interact with a door.
     */
    public static final AITaskType DOOR_INTERACT = DummyObjectProvider.createFor(AITaskType.class, "DOOR_INTERACT");

    /**
     * {@link AITask} where {@link Agent}s eat grass for a fixed amount of time.
     */
    public static final AITaskType EAT_GRASS = DummyObjectProvider.createFor(AITaskType.class, "EAT_GRASS");

    /**
     * {@link AITask} where {@link Creature}s search for its target and
     * attack other {@link Living}s based on a {@link Predicate}.
     */
    public static final AITaskType FIND_NEAREST_ATTACKABLE_TARGET = DummyObjectProvider.createFor(AITaskType.class, "FIND_NEAREST_ATTACKABLE_TARGET");

    /**
     * {@link AITask} where {@link Agent}s find the closest {@link Living} of a
     * specific type.
     */
    public static final AITaskType FIND_NEAREST_ENTITY = DummyObjectProvider.createFor(AITaskType.class, "FIND_NEAREST_ENTITY");

    /**
     * {@link AITask} where {@link Agent}s find the closest {@link Humanoid} and
     * set the attack target to the humanoid.
     */
    public static final AITaskType FIND_NEAREST_PLAYER = DummyObjectProvider.createFor(AITaskType.class, "FIND_NEAREST_PLAYER");

    /**
     * {@link AITask} where {@link Villager}s walk after an {@link IronGolem}.
     */
    public static final AITaskType FOLLOW_GOLEM = DummyObjectProvider.createFor(AITaskType.class, "FOLLOW_GOLEM");

    /**
     * {@link AITask} where {@link Tameable}s follow their {@link Tamer}s.
     */
    public static final AITaskType FOLLOW_OWNER = DummyObjectProvider.createFor(AITaskType.class, "FOLLOW_OWNER");

    /**
     * {@link AITask} where baby {@link Animal}s would follow an adult of the
     * same type.
     */
    public static final AITaskType FOLLOW_PARENT = DummyObjectProvider.createFor(AITaskType.class, "FOLLOW_PARENT");

    /**
     * {@link AITask} where {@link Villager}s harvest farmland.
     */
    public static final AITaskType HARVEST_FARMLAND = DummyObjectProvider.createFor(AITaskType.class, "HARVEST_FARMLAND");

    /**
     * {@link AITask} where {@link Agent}s jump at their attacking target.
     */
    public static final AITaskType LEAP_AT_TARGET = DummyObjectProvider.createFor(AITaskType.class, "LEAP_AT_TARGET");

    /**
     * {@link AITask} where {@link Villager}s look at the {@link Humanoid} it
     * is trading with.
     */
    public static final AITaskType LOOK_AT_TRADER = DummyObjectProvider.createFor(AITaskType.class, "LOOK_AT_TRADER");

    /**
     * {@link AITask} where {@link IronGolem}s look at {@link Villager}s and
     * sometimes present poppies.
     */
    public static final AITaskType LOOK_AT_VILLAGER = DummyObjectProvider.createFor(AITaskType.class, "LOOK_AT_VILLAGER");

    /**
     * {@link AITask} where {@link Agent}s look around, being idle.
     */
    public static final AITaskType LOOK_IDLE = DummyObjectProvider.createFor(AITaskType.class, "LOOK_IDLE");

    /**
     * {@link AITask} where adult {@link Animal}s mate and one of them may spawn a baby.
     */
    public static final AITaskType MATE = DummyObjectProvider.createFor(AITaskType.class, "MATE");

    /**
     * {@link AITask} where {@link Creature}s move in doors in a village at
     * night.
     */
    public static final AITaskType MOVE_IN_DOORS = DummyObjectProvider.createFor(AITaskType.class, "MOVE_IN_DOORS");

    /**
     * {@link AITask} where {@link Creature}s move through the village.
     */
    public static final AITaskType MOVE_THROUGH_VILLAGE = DummyObjectProvider.createFor(AITaskType.class, "MOVE_THROUGH_VILLAGE");

    /**
     * {@link AITask} where {@link Creature}s search for a closest valid
     * position and navigate to above that block.
     */
    public static final AITaskType MOVE_TO_BLOCK = DummyObjectProvider.createFor(AITaskType.class, "MOVE_TO_BLOCK");

    /**
     * {@link AITask} where {@link Creature}s move to its attack target.
     */
    public static final AITaskType MOVE_TO_LIVING = DummyObjectProvider.createFor(AITaskType.class, "MOVE_TO_LIVING");

    /**
     * {@link AITask} where {@link Creature}s move to a position but without
     * automatic lookup.
     */
    public static final AITaskType MOVE_TO_LOCATION = DummyObjectProvider.createFor(AITaskType.class, "MOVE_TO_LOCATION");

    /**
     * {@link AITask} where {@link Ocelot}s move to a position and sit down.
     */
    public static final AITaskType OCELOT_SIT = DummyObjectProvider.createFor(AITaskType.class, "OCELOT_SIT");

    /**
     * {@link AITask} where {@link Agent}s attack in a way that {@link Ocelot}s
     * do.
     */
    public static final AITaskType OCELOT_STYLE_ATTACK = DummyObjectProvider.createFor(AITaskType.class, "OCELOT_STYLE_ATTACK");

    /**
     * {@link AITask} where {@link Agent}s open doors when interacting with
     * doors. See {@link AITaskTypes#DOOR_INTERACT}.
     */
    public static final AITaskType OPEN_DOOR = DummyObjectProvider.createFor(AITaskType.class, "OPEN_DOOR");

    /**
     * {@link AITask} where {@link Creature}s run around randomly, as trying to
     * escape.
     */
    public static final AITaskType PANIC = DummyObjectProvider.createFor(AITaskType.class, "PANIC");

    /**
     * {@link AITask} where {@link Villager}s play with other villagers.
     */
    public static final AITaskType PLAY_WITH_OTHER_VILLAGER = DummyObjectProvider.createFor(AITaskType.class, "PLAY_WITH_OTHER_VILLAGER");

    /**
     * {@link AITask} where {@link Tameable}s attack the {@link Living} after
     * the {@link Tamer} gets attacked.
     */
    public static final AITaskType PROTECT_OWNER = DummyObjectProvider.createFor(AITaskType.class, "PROTECT_OWNER");

    /**
     * {@link AITask} where {@link RangedAttackingAgent}s attack their targets
     * with projectiles.
     */
    public static final AITaskType RANGED_ATTACK = DummyObjectProvider.createFor(AITaskType.class, "RANGED_ATTACK");

    /**
     * {@link AITask} where {@link Creature}s, sometimes including the same
     * types around, attack the type of {@link Living} of the attacker. Example:
     * {@link ZombiePigman}s' "Group Anger".
     */
    public static final AITaskType REVENGE = DummyObjectProvider.createFor(AITaskType.class, "REVENGE");

    /**
     * {@link AITask} where {@link Horse}s run around while {@link Humanoid}s
     * attempt to tame them.
     */
    public static final AITaskType RUN_AROUND_LIKE_CRAZY = DummyObjectProvider.createFor(AITaskType.class, "RUN_AROUND_LIKE_CRAZY");

    /**
     * {@link AITask} where {@link Tameable}s sit when {@link Tamer}s order.
     */
    public static final AITaskType SIT = DummyObjectProvider.createFor(AITaskType.class, "SIT");

    /**
     * {@link AITask} where {@link Creeper}s swell to their attack target and
     * explode.
     */
    public static final AITaskType SWELL = DummyObjectProvider.createFor(AITaskType.class, "SWELL");

    /**
     * {@link AITask} where {@link Agent}s with ground navigators swim in
     * liquids.
     */
    public static final AITaskType SWIMMING = DummyObjectProvider.createFor(AITaskType.class, "SWIMMING");

    /**
     * {@link AITask} where {@link Creature}s search for its attack target.
     */
    public static final AITaskType TARGET = DummyObjectProvider.createFor(AITaskType.class, "TARGET");

    /**
     * {@link AITask} where {@link Creature}s are attracted by the
     * {@link ItemType} in the {@link ItemStack} in the {@link Humanoid}'s hand.
     */
    public static final AITaskType TEMPT = DummyObjectProvider.createFor(AITaskType.class, "TEMPT");

    /**
     * {@link AITask} where {@link Villager}s stay around {@link Humanoid}s they
     * trade with while trading.
     */
    public static final AITaskType TRADE_PLAYER = DummyObjectProvider.createFor(AITaskType.class, "TRADE_PLAYER");

    /**
     * {@link AITask} where {@link Tameable}s attack a target until getting
     * tamed.
     */
    public static final AITaskType UNTAMED_FIND_NEAREST_ATTACKABLE = DummyObjectProvider.createFor(AITaskType.class,

            "UNTAMED_FIND_NEAREST_ATTACKABLE");
    /**
     * {@link AITask} where {@link Villager}s throw {@link Item}s to each other
     * and "craft" breads.
     */
    public static final AITaskType VILLAGER_EXCHANGE_ITEM = DummyObjectProvider.createFor(AITaskType.class, "VILLAGER_EXCHANGE_ITEM");

    /**
     * {@link AITask} where {@link Villager}s mate and sometimes spawn baby
     * villagers.
     */
    public static final AITaskType VILLAGER_MATE = DummyObjectProvider.createFor(AITaskType.class, "VILLAGER_MATE");

    /**
     * {@link AITask} where {@link Creature}s walk around.
     */
    public static final AITaskType WANDER = DummyObjectProvider.createFor(AITaskType.class, "WANDER");

    /**
     * {@link AITask} where {@link Agent}s will "watch" other {@link Entity}s.
     * It has different mutex bits from
     * {@link AITaskTypes#WATCH_CLOSEST_AS_INTERACTING}.
     */
    public static final AITaskType WATCH_CLOSEST = DummyObjectProvider.createFor(AITaskType.class, "WATCH_CLOSEST");

    /**
     * {@link AITask} where {@link Agent}s will "watch" other {@link Entity}s.
     * It has different mutex bits from {@link AITaskTypes#WATCH_CLOSEST}.
     */
    public static final AITaskType WATCH_CLOSEST_AS_INTERACTING = DummyObjectProvider.createFor(AITaskType.class, "WATCH_CLOSEST_AS_INTERACTING");

    // SORTFIELDS:OFF

    private AITaskTypes() {
    }

}

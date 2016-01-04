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
import org.spongepowered.api.entity.living.*;
import org.spongepowered.api.entity.living.animal.*;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Monster;
import org.spongepowered.api.entity.living.monster.ZombiePigman;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.function.Predicate;

public final class AITaskTypes {

    // SORTFIELDS:ON

    /**
     * {@link AITask} where {@link Tameable}s attack a {@link Living} which its
     * {@link Tamer} attacks.
     */
    public static final AITaskType ATTACK_AFTER_OWNER = null;

    /**
     * {@link AITask} where {@link Creature}s attack its target or a type of
     * {@link Living}.
     */
    public static final AITaskType ATTACK_LIVING = null;

    /**
     * {@link AITask} where {@link IronGolem}s attack {@link Monster}s that are
     * not {@link Creeper}s.
     */
    public static final AITaskType ATTACK_NEAREST_NON_CREEPER_TARGET = null;

    /**
     * {@link AITask} where {@link Creature}s avoid other {@link Agent}s based
     * on a {@link Predicate}.
     */
    public static final AITaskType AVOID_ENTITY = null;

    /**
     * {@link AITask} where {@link Creature}s avoid a path that walks through a
     * door.
     */
    public static final AITaskType AVOID_OPEN_DOOR = null;

    /**
     * {@link AITask} where {@link Creature}s avoid a path that exposes under
     * the sky at daytime.
     */
    public static final AITaskType AVOID_SUN = null;

    /**
     * {@link AITask} where {@link Wolf}s beg for bones or meat from
     * {@link Humanoid}s.
     */
    public static final AITaskType BEG = null;

    /**
     * {@link AITask} where {@link Creature}s, such as {@link Horse}s, are
     * ridden by a player and follow the order of a player.
     */
    public static final AITaskType CONTROLLED_BY_PLAYER = null;

    /**
     * {@link AITask} where {@link IronGolem}s in the villages find
     * {@link Monster}s that aren't {@link Creeper}s to attack.
     */
    public static final AITaskType DEFEND_VILLAGE = null;

    /**
     * {@link AITask} where {@link Agent}s interact with a door.
     */
    public static final AITaskType DOOR_INTERACT = null;

    /**
     * {@link AITask} where {@link Agent}s eat grass for a fixed amount of time.
     */
    public static final AITaskType EAT_GRASS = null;

    /**
     * {@link AITask} where {@link Creature}s search for its target and
     * attack other {@link Living}s based on a {@link Predicate}.
     */
    public static final AITaskType FIND_NEAREST_ATTACABLE_TARGET = null;

    /**
     * {@link AITask} where {@link Agent}s find the closest {@link Living} of a
     * specific type.
     */
    public static final AITaskType FIND_NEAREST_ENTITY = null;

    /**
     * {@link AITask} where {@link Agent}s find the closest {@link Humanoid} and
     * set the attack target to the humanoid.
     */
    public static final AITaskType FIND_NEAREST_PLAYER = null;

    /**
     * {@link AITask} where {@link Villager}s walk after an {@link IronGolem}.
     */
    public static final AITaskType FOLLOW_GOLEM = null;

    /**
     * {@link AITask} where {@link Tameable}s follow their {@link Tamer}s.
     */
    public static final AITaskType FOLLOW_OWNER = null;

    /**
     * {@link AITask} where baby {@link Animal}s would follow an adult of the
     * same type.
     */
    public static final AITaskType FOLLOW_PARENT = null;

    /**
     * {@link AITask} where {@link Villager}s harvest farmland.
     */
    public static final AITaskType HARVEST_FARMLAND = null;

    /**
     * {@link AITask} where {@link Agent}s jump at their attacking target.
     */
    public static final AITaskType LEAP_AT_TARGET = null;

    /**
     * {@link AITask} where {@link Villager}s look at the {@link Humanoid} it
     * is trading with.
     */
    public static final AITaskType LOOK_AT_TRADER = null;

    /**
     * {@link AITask} where {@link IronGolem}s look at {@link Villager}s and
     * sometimes present poppies.
     */
    public static final AITaskType LOOK_AT_VILLAGER = null;

    /**
     * {@link AITask} where {@link Agent}s look around, being idle.
     */
    public static final AITaskType LOOK_IDLE = null;

    /**
     * {@link AITask} where adult {@link Animal}s mate and one of them may spawn a baby.
     */
    public static final AITaskType MATE = null;

    /**
     * {@link AITask} where {@link Creature}s move in doors in a village at
     * night.
     */
    public static final AITaskType MOVE_IN_DOORS = null;

    /**
     * {@link AITask} where {@link Creature}s move through the village.
     */
    public static final AITaskType MOVE_THROUGH_VILLAGE = null;

    /**
     * {@link AITask} where {@link Creature}s search for a closest valid
     * position and navigate to above that block.
     */
    public static final AITaskType MOVE_TO_BLOCK = null;

    /**
     * {@link AITask} where {@link Creature}s move to its attack target.
     */
    public static final AITaskType MOVE_TO_LIVING = null;

    /**
     * {@link AITask} where {@link Creature}s move to a position but without
     * automatic lookup.
     */
    public static final AITaskType MOVE_TO_LOCATION = null;

    /**
     * {@link AITask} where {@link Ocelot}s move to a position and sit down.
     */
    public static final AITaskType OCELOT_SIT = null;

    /**
     * {@link AITask} where {@link Agent}s attack in a way that {@link Ocelot}s
     * do.
     */
    public static final AITaskType OCELOT_STYLE_ATTACK = null;

    /**
     * {@link AITask} where {@link Agent}s open doors when interacting with
     * doors. See {@link AITaskTypes#DOOR_INTERACT}.
     */
    public static final AITaskType OPEN_DOOR = null;

    /**
     * {@link AITask} where {@link Creature}s run around randomly, as trying to
     * escape.
     */
    public static final AITaskType PANIC = null;

    /**
     * {@link AITask} where {@link Villager}s play with other villagers.
     */
    public static final AITaskType PLAY_WITH_OTHER_VILLAGER = null;

    /**
     * {@link AITask} where {@link Tameable}s attack the {@link Living} after
     * the {@link Tamer} gets attacked.
     */
    public static final AITaskType PROTECT_OWNER = null;

    /**
     * {@link AITask} where {@link RangedAttackingAgent}s attack their targets
     * with projectiles.
     */
    public static final AITaskType RANGED_ATTACK = null;

    /**
     * {@link AITask} where {@link Creature}s, sometimes including the same
     * types around, attack the type of {@link Living} of the attacker. Example:
     * {@link ZombiePigman}s' "Group Anger".
     */
    public static final AITaskType REVENGE = null;

    /**
     * {@link AITask} where {@link Horse}s run around while {@link Humanoid}s
     * attempt to tame them.
     */
    public static final AITaskType RUN_AROUND_LIKE_CRAZY = null;

    /**
     * {@link AITask} where {@link Tameable}s sit when {@link Tamer}s order.
     */
    public static final AITaskType SIT = null;

    /**
     * {@link AITask} where {@link Creeper}s swell to their attack target and
     * explode.
     */
    public static final AITaskType SWELL = null;

    /**
     * {@link AITask} where {@link Agent}s with ground navigators swim in
     * liquids.
     */
    public static final AITaskType SWIMMING = null;

    /**
     * {@link AITask} where {@link Creature}s search for its attack target.
     */
    public static final AITaskType TARGET = null;

    /**
     * {@link AITask} where {@link Creature}s are attracted by the
     * {@link ItemType} in the {@link ItemStack} in the {@link Humanoid}'s hand.
     */
    public static final AITaskType TEMPT = null;

    /**
     * {@link AITask} where {@link Villager}s stay around {@link Humanoid}s they
     * trade with while trading.
     */
    public static final AITaskType TRADE_PLAYER = null;

    /**
     * {@link AITask} where {@link Tameable}s attack a target until getting
     * tamed.
     */
    public static final AITaskType UNTAMED_FIND_NEAREST_ATTACKABLE = null;

    /**
     * {@link AITask} where {@link Villager}s throw {@link Item}s to each other
     * and "craft" breads.
     */
    public static final AITaskType VILLAGER_EXCHANGE_ITEM = null;

    /**
     * {@link AITask} where {@link Villager}s mate and sometimes spawn baby
     * villagers.
     */
    public static final AITaskType VILLAGER_MATE = null;

    /**
     * {@link AITask} where {@link Creature}s walk around.
     */
    public static final AITaskType WANDER = null;

    /**
     * {@link AITask} where {@link Agent}s will "watch" other {@link Entity}s.
     * It has different mutex bits from
     * {@link AITaskTypes#WATCH_CLOSEST_AS_INTERACTING}.
     */
    public static final AITaskType WATCH_CLOSEST = null;

    /**
     * {@link AITask} where {@link Agent}s will "watch" other {@link Entity}s.
     * It has different mutex bits from {@link AITaskTypes#WATCH_CLOSEST}.
     */
    public static final AITaskType WATCH_CLOSEST_AS_INTERACTING = null;

    // SORTFIELDS:OFF

    private AITaskTypes() {

    }
}

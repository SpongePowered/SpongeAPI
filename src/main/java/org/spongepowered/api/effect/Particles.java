/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.effect;

import com.google.common.base.Optional;

import java.util.List;

import javax.annotation.Nullable;

/**
 * The particles that can be sent on a vanilla Minecraft client.
 */
public final class Particles {

    private Particles() {
    }

    public static final Particle EXPLOSION_NORMAL = null;
    public static final Particle EXPLOSION_LARGE = null;
    public static final Particle EXPLOSION_HUGE = null;
    public static final Particle FIREWORKS_SPARK = null;
    public static final Particle WATER_BUBBLE = null;
    public static final Particle WATER_SPLASH = null;
    public static final Particle WATER_WAKE = null;
    public static final Particle SUSPENDED = null;
    public static final Particle SUSPENDED_DEPTH = null;
    public static final Particle CRIT = null;
    public static final Particle CRIT_MAGIC = null;
    public static final Particle SMOKE_NORMAL = null;
    public static final Particle SMOKE_LARGE = null;
    public static final Particle SPELL = null;
    public static final Particle SPELL_INSTANT = null;
    public static final Particle SPELL_MOB = null;
    public static final Particle SPELL_MOB_AMBIENT = null;
    public static final Particle SPELL_WITCH = null;
    public static final Particle DRIP_WATER = null;
    public static final Particle DRIP_LAVA = null;
    public static final Particle VILLAGER_ANGRY = null;
    public static final Particle VILLAGER_HAPPY = null;
    public static final Particle TOWN_AURA = null;
    public static final Particle NOTE = null;
    public static final Particle PORTAL = null;
    public static final Particle ENCHANTMENT_TABLE = null;
    public static final Particle FLAME = null;
    public static final Particle LAVA = null;
    public static final Particle FOOTSTEP = null;
    public static final Particle CLOUD = null;
    public static final Particle REDSTONE = null;
    public static final Particle SNOWBALL = null;
    public static final Particle SNOW_SHOVEL = null;
    public static final Particle SLIME = null;
    public static final Particle HEART = null;
    public static final Particle BARRIER = null;
    public static final Particle ITEM_CRACK = null;
    public static final Particle BLOCK_CRACK = null;
    public static final Particle BLOCK_DUST = null;
    public static final Particle WATER_DROP = null;
    public static final Particle ITEM_TAKE = null;
    public static final Particle MOB_APPEARANCE = null;


    /**
     * Gets a {@link Particle} by name.
     *
     * @param name The particle name
     * @return The corresponding particle, if available
     */
    @Nullable
    public static Optional<Particle> getByName(String name) {
        return null;
    }

    public static List<Particle> getValues() {
        return null;
    }

}

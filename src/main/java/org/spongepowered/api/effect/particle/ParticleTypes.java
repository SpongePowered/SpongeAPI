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
package org.spongepowered.api.effect.particle;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * The particles that can be sent on a vanilla Minecraft client.
 */
public final class ParticleTypes {

    // SORTFIELDS:ON

    public static final ParticleType BARRIER = DummyObjectProvider.createFor(ParticleType.class, "BARRIER");

    public static final ParticleType.Block BLOCK_CRACK = DummyObjectProvider.createFor(ParticleType.Block.class, "BLOCK_CRACK");

    public static final ParticleType.Block BLOCK_DUST = DummyObjectProvider.createFor(ParticleType.Block.class, "BLOCK_DUST");

    public static final ParticleType CLOUD = DummyObjectProvider.createFor(ParticleType.class, "CLOUD");

    public static final ParticleType CRIT = DummyObjectProvider.createFor(ParticleType.class, "CRIT");

    public static final ParticleType CRIT_MAGIC = DummyObjectProvider.createFor(ParticleType.class, "CRIT_MAGIC");

    public static final ParticleType DRIP_LAVA = DummyObjectProvider.createFor(ParticleType.class, "DRIP_LAVA");

    public static final ParticleType DRIP_WATER = DummyObjectProvider.createFor(ParticleType.class, "DRIP_WATER");

    public static final ParticleType ENCHANTMENT_TABLE = DummyObjectProvider.createFor(ParticleType.class, "ENCHANTMENT_TABLE");

    public static final ParticleType EXPLOSION_HUGE = DummyObjectProvider.createFor(ParticleType.class, "EXPLOSION_HUGE");

    public static final ParticleType.Resizable EXPLOSION_LARGE = DummyObjectProvider.createFor(ParticleType.Resizable.class, "EXPLOSION_LARGE");

    public static final ParticleType EXPLOSION_NORMAL = DummyObjectProvider.createFor(ParticleType.class, "EXPLOSION_NORMAL");

    public static final ParticleType FIREWORKS_SPARK = DummyObjectProvider.createFor(ParticleType.class, "FIREWORKS_SPARK");

    public static final ParticleType FLAME = DummyObjectProvider.createFor(ParticleType.class, "FLAME");

    public static final ParticleType FOOTSTEP = DummyObjectProvider.createFor(ParticleType.class, "FOOTSTEP");

    public static final ParticleType HEART = DummyObjectProvider.createFor(ParticleType.class, "HEART");

    public static final ParticleType.Item ITEM_CRACK = DummyObjectProvider.createFor(ParticleType.Item.class, "ITEM_CRACK");

    public static final ParticleType ITEM_TAKE = DummyObjectProvider.createFor(ParticleType.class, "ITEM_TAKE");

    public static final ParticleType LAVA = DummyObjectProvider.createFor(ParticleType.class, "LAVA");

    public static final ParticleType MOB_APPEARANCE = DummyObjectProvider.createFor(ParticleType.class, "MOB_APPEARANCE");

    public static final ParticleType.Note NOTE = DummyObjectProvider.createFor(ParticleType.Note.class, "NOTE");

    public static final ParticleType PORTAL = DummyObjectProvider.createFor(ParticleType.class, "PORTAL");

    public static final ParticleType.Colorable REDSTONE = DummyObjectProvider.createFor(ParticleType.Colorable.class, "REDSTONE");

    public static final ParticleType SLIME = DummyObjectProvider.createFor(ParticleType.class, "SLIME");

    public static final ParticleType SMOKE_LARGE = DummyObjectProvider.createFor(ParticleType.class, "SMOKE_LARGE");

    public static final ParticleType SMOKE_NORMAL = DummyObjectProvider.createFor(ParticleType.class, "SMOKE_NORMAL");

    public static final ParticleType SNOWBALL = DummyObjectProvider.createFor(ParticleType.class, "SNOWBALL");

    public static final ParticleType SNOW_SHOVEL = DummyObjectProvider.createFor(ParticleType.class, "SNOW_SHOVEL");

    public static final ParticleType SPELL = DummyObjectProvider.createFor(ParticleType.class, "SPELL");

    public static final ParticleType SPELL_INSTANT = DummyObjectProvider.createFor(ParticleType.class, "SPELL_INSTANT");

    public static final ParticleType.Colorable SPELL_MOB = DummyObjectProvider.createFor(ParticleType.Colorable.class, "SPELL_MOB");

    public static final ParticleType.Colorable SPELL_MOB_AMBIENT = DummyObjectProvider.createFor(ParticleType.Colorable.class, "SPELL_MOB_AMBIENT");

    public static final ParticleType SPELL_WITCH = DummyObjectProvider.createFor(ParticleType.class, "SPELL_WITCH");

    public static final ParticleType SUSPENDED = DummyObjectProvider.createFor(ParticleType.class, "SUSPENDED");

    public static final ParticleType SUSPENDED_DEPTH = DummyObjectProvider.createFor(ParticleType.class, "SUSPENDED_DEPTH");

    public static final ParticleType TOWN_AURA = DummyObjectProvider.createFor(ParticleType.class, "TOWN_AURA");

    public static final ParticleType VILLAGER_ANGRY = DummyObjectProvider.createFor(ParticleType.class, "VILLAGER_ANGRY");

    public static final ParticleType VILLAGER_HAPPY = DummyObjectProvider.createFor(ParticleType.class, "VILLAGER_HAPPY");

    public static final ParticleType WATER_BUBBLE = DummyObjectProvider.createFor(ParticleType.class, "WATER_BUBBLE");

    public static final ParticleType WATER_DROP = DummyObjectProvider.createFor(ParticleType.class, "WATER_DROP");

    public static final ParticleType WATER_SPLASH = DummyObjectProvider.createFor(ParticleType.class, "WATER_SPLASH");

    public static final ParticleType WATER_WAKE = DummyObjectProvider.createFor(ParticleType.class, "WATER_WAKE");

    // SORTFIELDS:OFF

    private ParticleTypes() {
    }
}

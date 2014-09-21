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
package org.spongepowered.api.particle;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * The particles that can be sent on a vanilla Minecraft client.
 */
public enum Particles implements Particle {

    EXPLOSION_NORMAL("explode"),
    EXPLOSION_LARGE("largeexplode"),
    EXPLOSION_HUGE("hugeexplosion"),
    FIREWORKS_SPARK("fireworksSpark"),
    WATER_BUBBLE("bubble"),
    WATER_SPLASH("splash"),
    WATER_WAKE("wake"),
    SUSPENDED("suspended"),
    SUSPENDED_DEPTH("depthsuspend"),
    CRIT("crit"),
    CRIT_MAGIC("magicCrit"),
    SMOKE_NORMAL("smoke"),
    SMOKE_LARGE("largesmoke"),
    SPELL("spell"),
    SPELL_INSTANT("instantSpell"),
    SPELL_MOB("mobSpell"),
    SPELL_MOB_AMBIENT("mobSpellAmbient"),
    SPELL_WITCH("witchMagic"),
    DRIP_WATER("dripWater"),
    DRIP_LAVA("dripLava"),
    VILLAGER_ANGRY("angryVillager"),
    VILLAGER_HAPPY("happyVillager"),
    TOWN_AURA("townaura"),
    NOTE("note"),
    PORTAL("portal"),
    ENCHANTMENT_TABLE("enchantmenttable"),
    FLAME("flame"),
    LAVA("lava"),
    FOOTSTEP("footstep"),
    CLOUD("cloud"),
    REDSTONE("reddust"),
    SNOWBALL("snowballpoof"),
    SNOW_SHOVEL("snowshovel"),
    SLIME("slime"),
    HEART("heart"),
    BARRIER("barrier"),
    /**
     * Requires an array of int containing the id of an item and his data value.
     */
    ITEM_CRACK("iconcrack_", 2),
    /**
     * Requires an array of int containing the id of a block.
     */
    BLOCK_CRACK("blockcrack_", 1),
    /**
     * Requires an array of int containing the id of a block.
     */
    BLOCK_DUST("blockdust_", 1),
    WATER_DROP("droplet"),
    ITEM_TAKE("take"),
    MOB_APPEARANCE("mobappearance");

    @Override
    public String getName() {

        return name;
    }

    @Override
    public int getParamCount() {

        return paramCount;
    }

    /**
     * Returns a particle with its name.
     *
     * @param name The particle name
     * @return The corresponding {@link Particle}
     */
    @Nullable
    public static Particle getByName(String name) {

        return map.get(name);
    }

    /**
     * Adds a custom particle.
     *
     * @param particle The {@link Particle} to add
     */
    public static void addCustomParticle(Particle particle) {

        if (!map.containsKey(particle.getName())) {
            map.put(particle.getName(), particle);
        }
    }

    private String name;
    private int paramCount;
    private static final Map<String, Particle> map;

    private Particles(String name) {

        this(name, 0);
    }

    private Particles(String name, int paramCount) {

        this.name = name;
        this.paramCount = paramCount;
    }

    static {

        map = new HashMap<String, Particle>();
        for (Particle particle : values()) {
            map.put(particle.getName(), particle);
        }
    }
}

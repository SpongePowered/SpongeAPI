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
package org.spongepowered.api.component.attribute;

import org.spongepowered.api.component.Component;

/**
 * Gives the "model" attribute, used in rendering.
 */
public interface Model extends Component {

    /**
     * Returns the identifier of the model.
     * 
     * @return The model identifier
     */
    String getModel();

    /**
     * Enum representing all Vanilla models.
     */
    public static enum VanillaModels implements Model {
        //All ID's before 50 are not mobs
        CREEPER(50, "minecraft:creeper"),
        SKELETON(51, "minecraft:skeleton"),
        SPIDER(52, "minecraft:spider"),
        GIANT(53, "minecraft:giant"),
        ZOMBIE(54, "minecraft:zombie"),
        SLIME(55, "minecraft:slime"),
        GHAST(56, "minecraft:ghast"),
        PIG_ZOMBIE(57, "minecraft:pigzombie"),
        ENDERMAN(58, "minecraft:enderman"),
        CAVE_SPIDER(59, "minecraft:cavespider"),
        SILVERFISH(60, "minecraft:silverfish"),
        BLAZE(61, "minecraft:blaze"),
        MAGMA_CUBE(62, "minecraft:magmacube"),
        ENDER_DRAGON(63, "minecraft:enderdragon"),
        WITHER(64, "minecraft:wither"),
        BAT(65, "minecraft:bat"),
        WITCH(66, "minecraft:witch"),
        //TODO: Uncomment when ready ENDERMITE(67, "minecraft:endermite"),
        //TODO: Uncomment when ready GUARDIAN(68, "minecraft:guardian"),
        PIG(90, "minecraft:pig"),
        SHEEP(91, "minecraft:sheep"),
        COW(92, "minecraft:cow"),
        CHICKEN(93, "minecraft:chicken"),
        SQUID(94, "minecraft:squid"),
        WOLF(95, "minecraft:wolf"),
        MOOSHROOM(96, "minecraft:mushroomcow"),
        SNOW_GOLEM(97, "minecraft:snowgolem"),
        OCELOT(98, "minecraft:ocelot"),
        IRON_GOLEM(99, "minecraft:irongolem"),
        HORSE(100, "minecraft:horse"),
        //TODO: Uncomment when ready RABBIT(101, "minecraft:rabbit"),
        VILLAGER(120, "minecraft:villager")
        ;

        private final int id;
        private final String model;

        VanillaModels(int id, String model) {
            this.id = id;
            this.model = model;
        }

        public final int getID() {
            return id;
        }

        @Override
        public String getModel() {
            return model;
        }
    }
}

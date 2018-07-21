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
package org.spongepowered.api.data.property;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.manipulator.mutable.entity.DominantHandData;
import org.spongepowered.api.data.type.ArmorType;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.Matter;
import org.spongepowered.api.data.type.ToolType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.sound.record.RecordType;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.Collection;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class Properties {

    public static final class Block {

        // SORTFIELDS:ON

        /**
         * A property to represent the blast resistance of a block.
         */
        public static final Property<Double> BLAST_RESISTANCE =
                DummyObjectProvider.createFor(Property.class, "BLAST_RESISTANCE");

        /**
         * A property to represent whether a block is flammable.
         */
        public static final Property<Boolean> IS_FLAMMABLE =
                DummyObjectProvider.createFor(Property.class, "IS_FLAMMABLE");

        /**
         * A property to represent whether a block is affected by gravity. E.g. falling sand.
         */
        public static final Property<Boolean> IS_GRAVITY_AFFECTED =
                DummyObjectProvider.createFor(Property.class, "IS_GRAVITY_AFFECTED");

        /**
         * A property to represent whether a block is indirectly powered.
         */
        public static final Property<Boolean> IS_INDIRECTLY_POWERED =
                DummyObjectProvider.createFor(Property.class, "IS_INDIRECTLY_POWERED");

        /**
         * A property to represent whether a block is passable (can be walked through).
         */
        public static final Property<Boolean> IS_PASSABLE =
                DummyObjectProvider.createFor(Property.class, "IS_PASSABLE");

        /**
         * A property to represent the amount of light at a block location.
         */
        public static final Property<Double> GROUND_LUMINANCE =
                DummyObjectProvider.createFor(Property.class, "GROUND_LUMINANCE");

        /**
         * A property to represent whether a block is powered.
         */
        public static final Property<Boolean> IS_POWERED =
                DummyObjectProvider.createFor(Property.class, "IS_POWERED");

        /**
         * A property to represent whether a block can be replaced
         * by other blocks when they are being placed.
         */
        public static final Property<Boolean> IS_REPLACEABLE =
                DummyObjectProvider.createFor(Property.class, "IS_REPLACEABLE");

        /**
         * A property to represent whether a {@link BlockType} is a "solid cube"
         * and therefor can be considered to place a {@link BlockTypes#TORCH} on
         * its side.
         */
        public static final Property<Boolean> IS_SOLID_CUBE =
                DummyObjectProvider.createFor(Property.class, "IS_SOLID_CUBE");

        /**
         * A property to signify that the block this property originated from is
         * a surrogate block for a block that was provided in an environment
         * (almost always modded), that the block type provider no longer exists.
         * This property serves to indicate that the surrogate block may function
         * differently than the original intended block.
         */
        public static final Property<Boolean> IS_SURROGATE_BLOCK =
                DummyObjectProvider.createFor(Property.class, "IS_SURROGATE_BLOCK");

        /**
         * A property to represent whether a block is unbreakable.
         */
        public static final Property<Boolean> IS_UNBREAKABLE =
                DummyObjectProvider.createFor(Property.class, "IS_UNBREAKABLE");

        /**
         * A property to represent the hardness of a block.
         */
        public static final Property<Double> HARDNESS =
                DummyObjectProvider.createFor(Property.class, "HARDNESS");

        /**
         * A property to represent whether a {@link BlockType} has a full selection
         * box. That is, the block has a selection box and it occupies the exact volume
         * of a voxel (the size is (1, 1, 1)). The selection box is the one used to
         * interact with blocks, which shows up as a black outline on a vanilla client.
         */
        public static final Property<Boolean> HAS_FULL_BLOCK_SELECTION_BOX =
                DummyObjectProvider.createFor(Property.class, "HAS_FULL_BLOCK_SELECTION_BOX");

        /**
         * A property to represent whether a block type is being statistically tracked.
         */
        public static final Property<Boolean> HAS_STATISTICS_TRACKING =
                DummyObjectProvider.createFor(Property.class, "HAS_STATISTICS_TRACKING");

        /**
         * A property that provides the {@link ItemType} representation of what a
         * {@link BlockState} or {@link BlockType} may present itself if it was
         * represented as an {@link ItemStack}.
         */
        public static final Property<ItemType> HELD_ITEM =
                DummyObjectProvider.createFor(Property.class, "HELD_ITEM");

        /**
         * A property to represent the {@link InstrumentType} that is used by a block to play notes/music.
         */
        public static final Property<InstrumentType> INSTRUMENT =
                DummyObjectProvider.createFor(Property.class, "INSTRUMENT");

        /**
         * A property to represent the amount of light emitted from the owning block.
         */
        public static final Property<Double> LIGHT_EMISSION =
                DummyObjectProvider.createFor(Property.class, "LIGHT_EMISSION");

        /**
         * A property to represent the matter of a block.
         */
        public static final Property<Matter> MATTER =
                DummyObjectProvider.createFor(Property.class, "MATTER");

        /**
         * A property to represent the amount of sky light at a block location.
         */
        public static final Property<Double> SKY_LUMINANCE =
                DummyObjectProvider.createFor(Property.class, "GROUND_LUMINANCE");

        /**
         * A property to represent the temperature of a block.
         */
        public static final Property<Double> TEMPERATURE =
                DummyObjectProvider.createFor(Property.class, "TEMPERATURE");

        // SORTFIELDS:OFF

        // Suppress default constructor to ensure non-instantiability.
        private Block() {
            throw new AssertionError("You should not be attempting to instantiate this class.");
        }

    }

    public static final class Fluid {

        // SORTFIELDS:ON

        /**
         * Viscosity ("thickness") of the fluid - completely arbitrary; negative values
         * are not valid. The default viscosity is closely approximated to that
         * of what exists in real life water: <code>meter/second^2 * (x10^-3)</code>.
         *
         * <p>Higher viscosity means that a fluid flows more slowly, like molasses.
         * Lower viscosity means that a fluid flows more quickly, like alcohol.</p>
         */
        public static final Property<Integer> VISCOSITY =
                DummyObjectProvider.createFor(Property.class, "VISCOSITY");

        /**
         * Temperature of the fluid - completely arbitrary; higher temperature indicates
         * that the fluid is hotter than air. Usually, depending on the implementation,
         * the "hotter" the fluid, the more likely it is to make flammable blocks and
         * entities catch on fire.
         *
         * <p>Default value is approximately the real-life room temperature of water in
         * degrees Kelvin, otherwise known as 300K.</p>
         */
        public static final Property<Integer> TEMPERATURE =
                DummyObjectProvider.createFor(Property.class, "TEMPERATURE");

        // SORTFIELDS:OFF

        // Suppress default constructor to ensure non-instantiability.
        private Fluid() {
            throw new AssertionError("You should not be attempting to instantiate this class.");
        }

    }

    public static final class Entity {

        // SORTFIELDS:ON

        /**
         * Represents a {@link Property} for the dominant {@link HandPreference} of a
         * {@link Player}.
         *
         * <p>Handedness usually determines which hand is used for "main" interactions,
         * such as tool use or block breaking.</p>
         *
         * <p><i>NOTE: </i>This only applies to {@link Player}s, for {@link Living}
         * entities see {@link DominantHandData}.</p>
         */
        public static final Property<HandPreference> DOMINANT_HAND =
                DummyObjectProvider.createFor(Property.class, "DOMINANT_HAND");

        /**
         * A property to represent the eye height of a entity.
         */
        public static final Property<Double> EYE_HEIGHT =
                DummyObjectProvider.createFor(Property.class, "EYE_HEIGHT");

        /**
         * A property to represent the eye position of a entity.
         */
        public static final Property<Vector3d> EYE_POSITION =
                DummyObjectProvider.createFor(Property.class, "EYE_POSITION");

        // SORTFIELDS:OFF

        // Suppress default constructor to ensure non-instantiability.
        private Entity() {
            throw new AssertionError("You should not be attempting to instantiate this class.");
        }

    }

    public static final class Item {

        // SORTFIELDS:ON

        /**
         * Represents a {@link Property} that applies a set of
         * {@link PotionEffect}s on use, consumption, or on equip. The properties
         * are not mutable, but can be compared against.
         *
         * <p>Examples of these properties include: hunger from eating zombie flesh,
         * regeneration from a golden apple, etc.</p>
         */
        public static final Property<Collection<PotionEffect>> APPLICABLE_POTION_EFFECTS =
                DummyObjectProvider.createFor(Property.class, "APPLICABLE_POTION_EFFECTS");

        /**
         * A property to represent the {@link ArmorType} of a item type.
         */
        public static final Property<ArmorType> ARMOR_TYPE =
                DummyObjectProvider.createFor(Property.class, "ARMOR_TYPE");

        /**
         * Represents a item property that is used for defining the amount of fuel
         * ticks an item will grant to a furnace.
         */
        public static final Property<Integer> FUEL_BURN_TIME =
                DummyObjectProvider.createFor(Property.class, "FUEL_BURN_TIME");

        /**
         * A property to represent the amount of damage the item will absorb when equipped. The
         * damage absorbed can be dependent on the type of damage, equipment type, and item type.
         */
        public static final Property<Double> DAMAGE_ABSORPTION =
                DummyObjectProvider.createFor(Property.class, "DAMAGE_ABSORPTION");

        /**
         * Represents a property on an item that has an efficiency qualifier applied
         * when mining harvestable blocks. For determining whether a block can be
         * harvested, use {@link #HARVESTABLE_TYPES}.
         */
        public static final Property<Double> EFFICIENCY =
                DummyObjectProvider.createFor(Property.class, "EFFICIENCY");

        /**
         * Represents the {@link EquipmentType} that the item can be used in an
         * equipment inventory.
         */
        public static final Property<EquipmentType> EQUIPMENT_TYPE =
                DummyObjectProvider.createFor(Property.class, "EQUIPMENT_TYPE");

        /**
         * Represents a property that increases the food level of an entity
         * based on consumption.
         */
        public static final Property<Double> FOOD_RESTORATION =
                DummyObjectProvider.createFor(Property.class, "FOOD_RESTORATION");

        /**
         * Represents a property defining the types of blocks the item can harvest.
         *
         * <p>Harvestable blocks vary, but if an item can not harvest based on
         * this property, the mined block will not be harvested (dropped as an item).
         * This behavior may be changed by events.</p>
         */
        public static final Property<Collection<BlockType>> HARVESTABLE_TYPES =
                DummyObjectProvider.createFor(Property.class, "HARVESTABLE_TYPES");

        /**
         * A property to represent whether a item is smeltable.
         */
        public static final Property<Boolean> IS_SMELTABLE =
                DummyObjectProvider.createFor(Property.class, "IS_SMELTABLE");

        /**
         * A property to represent the {@link RecordType} of a item.
         */
        public static final Property<RecordType> RECORD_TYPE =
                DummyObjectProvider.createFor(Property.class, "RECORD_TYPE");

        /**
         * Represents an item property that replenishes saturation upon use or
         * consumption. Examples of items that have these properties: any food item.
         */
        public static final Property<Double> SATURATION =
                DummyObjectProvider.createFor(Property.class, "SATURATION");

        /**
         * A property to represent the {@link ToolType} of a item.
         */
        public static final Property<ToolType> TOOL_TYPE =
                DummyObjectProvider.createFor(Property.class, "TOOL_TYPE");

        /**
         * A property to represent a limit on the number of uses on an item. Whether the
         * uses are defined as durability or another item data value, usually, when the
         * uses exceed this use limit, the item is removed or consumed.
         */
        public static final Property<Integer> USE_LIMIT =
                DummyObjectProvider.createFor(Property.class, "USE_LIMIT");

        // SORTFIELDS:OFF

        // Suppress default constructor to ensure non-instantiability.
        private Item() {
            throw new AssertionError("You should not be attempting to instantiate this class.");
        }

    }

    // Suppress default constructor to ensure non-instantiability.
    private Properties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}

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
import org.spongepowered.api.data.manipulator.mutable.DominantHandData;
import org.spongepowered.api.data.type.ArmorType;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.Matter;
import org.spongepowered.api.data.type.ToolType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.Collection;

@SuppressWarnings("unchecked")
public final class Properties {

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
     * A property to represent the temperature of a biome at a block location.
     */
    public static final Property<Double> BIOME_TEMPERATURE =
            DummyObjectProvider.createFor(Property.class, "BIOME_TEMPERATURE");

    /**
     * A property to represent the blast resistance of something, usually a block.
     */
    public static final Property<Double> BLAST_RESISTANCE =
            DummyObjectProvider.createFor(Property.class, "BLAST_RESISTANCE");

    /**
     * A property to represent the amount of light that is emitted by the
     * surrounding blocks at a block location.
     */
    public static final Property<Double> BLOCK_LUMINANCE =
            DummyObjectProvider.createFor(Property.class, "BLOCK_LUMINANCE");

    /**
     * A property to represent the temperature of a block or liquid that
     * is produced by itself.
     */
    public static final Property<Double> BLOCK_TEMPERATURE =
            DummyObjectProvider.createFor(Property.class, "BLOCK_TEMPERATURE");

    /**
     * A property to represent the amount of damage the item will absorb when equipped. The
     * damage absorbed can be dependent on the type of damage, equipment type, and item type.
     */
    public static final Property<Double> DAMAGE_ABSORPTION =
            DummyObjectProvider.createFor(Property.class, "DAMAGE_ABSORPTION");

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

    /**
     * Represents the {@link EquipmentType} that the item can be used in an
     * equipment inventory.
     */
    public static final Property<EquipmentType> EQUIPMENT_TYPE =
            DummyObjectProvider.createFor(Property.class, "EQUIPMENT_TYPE");

    /**
     * A property to represent the temperature of the fluid - completely arbitrary;
     * higher temperature indicates that the fluid is hotter than air. Usually,
     * depending on the implementation, the "hotter" the fluid, the more likely
     * it is to make flammable blocks and entities catch on fire.
     *
     * <p>Default value is approximately the real-life room temperature of water in
     * degrees Kelvin, otherwise known as 300K.</p>
     */
    public static final Property<Double> FLUID_TEMPERATURE =
            DummyObjectProvider.createFor(Property.class, "FLUID_TEMPERATURE");

    /**
     * Represents a item property that is used for defining the amount of fuel
     * ticks an item will grant to a furnace.
     */
    public static final Property<Integer> FUEL_BURN_TIME =
            DummyObjectProvider.createFor(Property.class, "FUEL_BURN_TIME");

    /**
     * A property to represent the hardness of something, usually a block.
     */
    public static final Property<Double> HARDNESS =
            DummyObjectProvider.createFor(Property.class, "HARDNESS");

    /**
     * Represents a property on an item that has an efficiency qualifier applied
     * when mining harvestable blocks. For determining whether a block can be
     * harvested, use {@link #HARVESTABLE_TYPES}.
     */
    public static final Property<Double> HARVESTING_EFFICIENCY =
            DummyObjectProvider.createFor(Property.class, "EFFICIENCY");

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
     * A property to represent whether a {@link BlockType} has a full selection
     * box. That is, the block has a selection box and it occupies the exact volume
     * of a voxel (the size is (1, 1, 1)). The selection box is the one used to
     * interact with blocks, which shows up as a black outline on a vanilla client.
     */
    public static final Property<Boolean> HAS_FULL_BLOCK_SELECTION_BOX =
            DummyObjectProvider.createFor(Property.class, "HAS_FULL_BLOCK_SELECTION_BOX");

    /**
     * A property to represent whether something is being statistically tracked,
     * usually applies to block and item types.
     */
    public static final Property<Boolean> HAS_STATISTICS_TRACKING =
            DummyObjectProvider.createFor(Property.class, "HAS_STATISTICS_TRACKING");

    /**
     * A property to represent whether something is flammable.
     */
    public static final Property<Boolean> IS_FLAMMABLE =
            DummyObjectProvider.createFor(Property.class, "IS_FLAMMABLE");

    /**
     * A property to represent whether something is affected by gravity. Usually
     * applies to falling blocks and entities.
     */
    public static final Property<Boolean> IS_GRAVITY_AFFECTED =
            DummyObjectProvider.createFor(Property.class, "IS_GRAVITY_AFFECTED");

    /**
     * A property to represent whether something is indirectly powered. Usually
     * applies to blocks that are affected by redstone.
     */
    public static final Property<Boolean> IS_INDIRECTLY_POWERED =
            DummyObjectProvider.createFor(Property.class, "IS_INDIRECTLY_POWERED");

    /**
     * A property to represent whether something is passable (can be walked through).
     */
    public static final Property<Boolean> IS_PASSABLE =
            DummyObjectProvider.createFor(Property.class, "IS_PASSABLE");

    /**
     * A property to represent whether something is powered. Usually
     * applies to blocks that are affected by redstone.
     */
    public static final Property<Boolean> IS_POWERED =
            DummyObjectProvider.createFor(Property.class, "IS_POWERED");

    /**
     * A property to represent whether a block can be replaced by
     * other blocks when they are being placed.
     */
    public static final Property<Boolean> IS_REPLACEABLE_BLOCK =
            DummyObjectProvider.createFor(Property.class, "IS_REPLACEABLE_BLOCK");

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
     * A property to represent whether something is unbreakable, usually blocks.
     */
    public static final Property<Boolean> IS_UNBREAKABLE =
            DummyObjectProvider.createFor(Property.class, "IS_UNBREAKABLE");

    /**
     * A property to represent the amount of light that emitted by a light source,
     * usually blocks.
     */
    public static final Property<Double> LIGHT_EMISSION =
            DummyObjectProvider.createFor(Property.class, "LIGHT_EMISSION");

    /**
     * A property to represent the amount of light that is emitted at a block
     * location. The luminance is affected by {@link #BLOCK_LUMINANCE},
     * {@link #SKY_LUMINANCE} and possible other light sources.
     */
    public static final Property<Double> LUMINANCE =
            DummyObjectProvider.createFor(Property.class, "LUMINANCE");

    /**
     * A property to represent the matter of a block.
     */
    public static final Property<Matter> MATTER =
            DummyObjectProvider.createFor(Property.class, "MATTER");

    /**
     * A property to represent the {@link MusicDisc} of a item.
     */
    public static final Property<MusicDisc> MUSIC_DISC =
            DummyObjectProvider.createFor(Property.class, "MUSIC_DISC");

    /**
     * A property to represent the {@link InstrumentType} that is used
     * by a block to play notes/music.
     */
    public static final Property<InstrumentType> REPRESENTED_INSTRUMENT =
            DummyObjectProvider.createFor(Property.class, "REPRESENTED_INSTRUMENT");

    /**
     * A property that provides the {@link ItemType} representation of what a
     * {@link BlockState} or {@link BlockType} may present itself if it was
     * represented as an {@link ItemStack}.
     */
    public static final Property<ItemType> REPRESENTED_ITEM =
            DummyObjectProvider.createFor(Property.class, "REPRESENTED_ITEM");

    /**
     * Represents a property of the amount of food that gets replenished upon
     * consumption.
     */
    public static final Property<Double> REPLENISHED_FOOD =
            DummyObjectProvider.createFor(Property.class, "REPLENISHED_FOOD");

    /**
     * Represents an property of the amount of saturation that gets replenished upon use or
     * consumption. Examples of items that have these properties: any food item.
     */
    public static final Property<Double> REPLENISHED_SATURATION =
            DummyObjectProvider.createFor(Property.class, "REPLENISHED_SATURATION");

    /**
     * A property to represent the amount of light that is emitted by the sky
     * at a block location.
     */
    public static final Property<Double> SKY_LUMINANCE =
            DummyObjectProvider.createFor(Property.class, "GROUND_LUMINANCE");

    /**
     * A property to represent the temperature at a block location. This temperature
     * is affected by the {@link #BLOCK_TEMPERATURE}, {@link #BIOME_TEMPERATURE},
     * {@link #FLUID_TEMPERATURE} and possible other sources that affect the temperature.
     */
    public static final Property<Double> TEMPERATURE =
            DummyObjectProvider.createFor(Property.class, "TEMPERATURE");

    /**
     * A property to represent the {@link ToolType} of a item.
     */
    public static final Property<ToolType> TOOL_TYPE =
            DummyObjectProvider.createFor(Property.class, "TOOL_TYPE");

    /**
     * A property to represent a limit on the number of uses on an item or block. Whether the
     * uses are defined as durability or another item data value, usually, when the
     * uses exceed this use limit, the item is removed or consumed.
     */
    public static final Property<Integer> USE_LIMIT =
            DummyObjectProvider.createFor(Property.class, "USE_LIMIT");

    /**
     * A property to represent the viscosity ("thickness") of a fluid - completely
     * arbitrary; negative values  are not valid. The default viscosity is closely
     * approximated to that of what exists in real life water:
     * <code>meter/second^2 * (x10^-3)</code>.
     *
     * <p>Higher viscosity means that a fluid flows more slowly, like molasses.
     * Lower viscosity means that a fluid flows more quickly, like alcohol.</p>
     */
    public static final Property<Double> VISCOSITY =
            DummyObjectProvider.createFor(Property.class, "VISCOSITY");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Properties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}

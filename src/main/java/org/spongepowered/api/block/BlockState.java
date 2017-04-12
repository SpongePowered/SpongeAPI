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
package org.spongepowered.api.block;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.block.trait.BlockTrait;
import org.spongepowered.api.data.ImmutableDataBuilder;
import org.spongepowered.api.data.ImmutableDataHolder;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.property.DirectionRelativePropertyHolder;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.Cycleable;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.Nullable;

/**
 * Represents a particular "state" that can exist at a {@link Location} with
 * a particular {@link BlockType} and various {@link ImmutableValue}s defining
 * the information for the "block". Note that normally, there may exist only
 * a single instance of a particular {@link BlockState} as they are immutable,
 * a particular instance may be cached for various uses.
 */
public interface BlockState extends ImmutableDataHolder<BlockState>, DirectionRelativePropertyHolder, CatalogType {

    /**
     * Creates a new {@link Builder} for building {@link BlockState}s.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Constructs a new {@link MatcherBuilder} to construct a {@link StateMatcher}.
     *
     * @param type The block type
     * @return The builder
     */
    static MatcherBuilder matcher(BlockType type) {
        return new MatcherBuilder().type(type);
    }

    /**
     * Gets the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @return The type of block
     */
    BlockType getType();

    /**
     * Applies extended properties for the current @{link BlockType} if any to
     * the current {@link BlockState}. This usually is gathered from surrounding
     * {@link BlockState}'s.
     *
     * <p>Note: This should only be called for live {@link BlockState}'s at
     * a specific {@link Location} for accurate results.</p>
     *
     * <p>
     * Examples of some extended properties are:
     * </p>
     *
     * <ul>
     *     <li>snow on podzul dirt block</li>
     *     <li>occupied status for beds</li>
     *     <li>fence connections</li>
     * </ul>
     *
     * @param location The location used to search for extended properties
     * @return The blockstate with extended properties included if any
     */
    BlockState withExtendedProperties(Location<World> location);

    /**
     * Gets the associated {@link BlockState} with the cycled
     * {@link BaseValue}. Note that only {@link Cycleable} values can be
     * cycled. To change a particular {@link Key}'ed {@link Value}, usage
     * of the {@link BlockState#with(Key, Object)} is recommended.
     *
     * @param key The key to cycle
     * @return The blockstate instance with the cycled value
     */
    BlockState cycleValue(Key<? extends BaseValue<? extends Cycleable<?>>> key);

    /**
     * Creates a new {@link BlockSnapshot} with this current {@link BlockState}
     * at the desired {@link Location}. If the {@link Location} has the same
     * {@link BlockState}, and the {@link BlockType} can house a
     * {@link TileEntity}, the data from the tile entity may be included in the
     * returned  {@link BlockSnapshot}.
     *
     * @param location The location for the snapshot
     * @return The newly created snapshot
     */
    BlockSnapshot snapshotFor(Location<World> location);

    /**
     * Gets the {@link Comparable} value for the specific {@link BlockTrait}
     * such that if the {@link BlockState} does not support the
     * {@link BlockTrait}, {@link Optional#empty()} is returned.
     *
     * @param blockTrait The block trait instance
     * @param <T> The generic type of block trait
     * @return The comparable value, if available and compatible
     */
    <T extends Comparable<T>> Optional<T> getTraitValue(BlockTrait<T> blockTrait);

    /**
     * Attempts to retrieve the {@link BlockTrait} instance associated with
     * this {@link BlockState}s {@link BlockType} by string id. If there is no
     * {@link BlockTrait} available, {@link Optional#empty()} is returned.
     *
     * @param blockTrait The block trait id
     * @return The block trait, if available
     */
    Optional<BlockTrait<?>> getTrait(String blockTrait);

    /**
     * Gets the {@link BlockState} with the appropriate value for the given
     * {@link BlockTrait}. If the {@link BlockTrait} is not supported,
     * {@link Optional#empty()} is returned. If the object is not either
     * an instance contained in {@link BlockTrait#getPossibleValues()} or
     * an instance {@link Object#toString()}, {@link Optional#empty()} may be
     * returned.
     *
     * @param trait The trait
     * @param value The value
     * @return The blockstate, if supported
     */
    Optional<BlockState> withTrait(BlockTrait<?> trait, Object value);

    /**
     * Gets an immutable {@link Collection} of all applicable
     * {@link BlockTrait}s for this {@link BlockState}.
     *
     * @return An immutable collection of all applicable block traits
     */
    Collection<BlockTrait<?>> getTraits();

    /**
     * Gets an immutable {@link Collection} of all the values for all
     * {@link BlockTrait}s for this {@link BlockState}.
     *
     * @return An immutable collection of all the values for all applicable
     *     traits
     */
    Collection<?> getTraitValues();

    /**
     * Gets an immutable or unmodifiable {@link Map} of the known {@link BlockTrait}s
     * to their current values for this {@link BlockState}.
     *
     * @return The immutable map of block traits to their values representing
     *     this block state
     */
    Map<BlockTrait<?>, ?> getTraitMap();

    /**
     * An {@link ImmutableDataBuilder} for a {@link BlockState}. Just like the
     * {@link ImmutableDataBuilder}, the {@link DataManipulator}s passed in to
     * create a {@link BlockState} are copied on creation.
     *
     * <p>Note that upon creation, the {@link BlockType} must be set for validation
     * of {@link DataManipulator}s, otherwise exceptions may be thrown.</p>
     */
    interface Builder extends ImmutableDataBuilder<BlockState, Builder> {

        /**
         * Sets the {@link BlockType} for the {@link BlockState} to build.
         *
         * <p>The {@link BlockType} is used for some pre-validation on addition of
         * {@link DataManipulator}s through {@link #add(DataManipulator)}. It is
         * important to understand that not all manipulators are compatible with
         * all {@link BlockType}s.</p>
         *
         * @param blockType The block type
         * @return This builder, for chaining
         */
        Builder blockType(BlockType blockType);

    }

    /**
     * A builder for building {@link StateMatcher}s.
     */
    final class MatcherBuilder implements ResettableBuilder<StateMatcher, MatcherBuilder> {

        @Nullable private BlockType type;
        private ArrayList<BlockTrait<?>> traits = new ArrayList<>();
        private ArrayList<Object> values = new ArrayList<>();

        private MatcherBuilder() {
        }

        /**
         * Sets the root {@link BlockType} for the {@link StateMatcher}.
         * <p>Note that the {@link BlockType type} <b>must be set prior</b>
         * to setting various {@link BlockTrait traits} and their values.</p>
         *
         * @param type The block type to use
         * @return This builder, for chaining
         */
        public MatcherBuilder type(BlockType type) {
            this.type = checkNotNull(type, "BlockType cannot be null!");
            return this;
        }

        /**
         * Adds the desired {@link BlockTrait} and {code value} to this
         * builder, if the desired {@link BlockTrait} does not belong to the
         * original {@link BlockType} as provided by {@link #type(BlockType)},
         * an exception is thrown. Likewise, if a {@code value} is not within
         * the possible values for the desired trait of the desired type, an
         * exception is thrown.
         *
         * @param trait The desired block trait
         * @param value the desired value
         * @param <T> The type of comparable
         * @return This builder
         * @throws IllegalArgumentException If the block trait does not match
         *     the block type, or if the value does not belong to the trait
         *     with the desired block type
         */
        public <T extends Comparable<T>> MatcherBuilder trait(BlockTrait<T> trait, T value) throws IllegalArgumentException {
            checkState(this.type != null, "BlockType cannot be null! Must be set before using any traits!");
            checkArgument(this.type.getTraits().contains(trait), "BlockType does not contain the specified trait: %s", trait);
            checkArgument(trait.getPossibleValues().contains(value), "BlockTrait %s does not contain value %s", trait, value);
            checkArgument(!this.traits.contains(trait), "Already contains the trait %s! Cannot add multiple values!", trait);
            this.traits.add(trait);
            this.values.add(value);
            return this;
        }

        /**
         * Creates a new {@link StateMatcher}.
         *
         * @return The new state matcher
         * @throws IllegalStateException If there is no block type
         */
        public StateMatcher build() throws IllegalStateException {
            checkState(this.type != null, "BlockType cannot be null!");
            return new StateMatcher(this.type, this.traits.toArray(new BlockTrait<?>[this.traits.size() - 1]), this.values.toArray());

        }

        @SuppressWarnings("unchecked")
        @Override
        public MatcherBuilder from(StateMatcher value) {
            reset();
            type(value.type);
            for (int i = 0; i < value.traits.length; i++) {
                trait((BlockTrait) value.traits[i], (Comparable) value.values[i]);
            }
            return this;
        }

        @Override
        public MatcherBuilder reset() {
            this.type = null;
            this.traits.clear();
            this.values.clear();
            return this;
        }
    }

    /**
     * A {@link BlockState} matcher that will match various block states
     * according to a pre-built list of {@link BlockTrait}s and their
     * values, such that not all {@link BlockTrait}s contained in a
     * {@link BlockState} must be matched. (Such as if a block state
     * that contains 4 traits, and only 2 are wanting to be matched,
     * then the other two traits may be variable).
     */
    final class StateMatcher implements Predicate<BlockState> {
        private final BlockType type;
        private final BlockTrait<?>[] traits;
        private final Object[] values;
        @Nullable private ImmutableList<BlockState> compatibleStates; // Lazily constructed

        private StateMatcher(BlockType type, BlockTrait<?>[] traits, Object[] values) {
            this.type = type;
            this.traits = new BlockTrait<?>[traits.length];
            System.arraycopy(traits, 0, this.traits, 0, traits.length);
            this.values = new Object[values.length];
            System.arraycopy(values, 0, this.values, 0, values.length);
        }

        private ImmutableList<BlockState> computeCompatibleStates() {
            return this.type.getAllBlockStates()
                    .stream()
                    .filter(this::matches)
                    .collect(ImmutableList.toImmutableList());
        }

        /**
         * Gets a {@code true} return value if the provided {@link BlockState}
         * sufficiently matches this matcher, such that the {@link BlockType}
         * matches, and the pre-defined {@link BlockTrait} values match.
         *
         * @param state The block state in question
         * @return True if the state sufficiently matches
         */
        public boolean matches(BlockState state) {
            if (this.type != state.getType()) {
                return false;
            }
            for (int i = 0; i < this.traits.length; i++) {
                final BlockTrait<?> trait = this.traits[i];
                final Object value = this.values[i];
                final Optional<?> traitValue = state.getTraitValue(trait);
                if (!traitValue.isPresent()) { // If for any reason this fails, that means there's another problem, but alas, just in case
                    return false;
                }
                final Object o = traitValue.get();
                if (!value.equals(o)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean test(BlockState blockState) {
            return matches(blockState);
        }

        /**
         * Gets a {@link List} of compatible {@link BlockState}s.
         * Since all {@link BlockState}s are known in the initialization
         * of a {@link BlockType}, the states are already deterministic
         * and cannot change themselves.
         *
         * @return The list of compatible block states
         */
        public List<BlockState> getCompatibleStates() {
            if (this.compatibleStates == null) {
                this.compatibleStates = computeCompatibleStates();
            }
            return this.compatibleStates;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("type", this.type)
                    .add("traits", this.traits)
                    .add("values", this.values)
                    .toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            StateMatcher that = (StateMatcher) o;
            return Objects.equal(this.type, that.type)
                   && Objects.equal(this.traits, that.traits)
                   && Objects.equal(this.values, that.values);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.type, this.traits, this.values);
        }
    }
}

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
package org.spongepowered.api.text.selector;

import static org.spongepowered.api.text.selector.ArgumentTypes.getFactory;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Represents an immutable selector of targets, as used in commands.
 *
 * <p>
 * In Vanilla, selectors are mostly represented as plain text, starting with an
 * {@code @} symbol and followed by a single character signifying the type, and
 * finally the (optional) arguments in brackets.
 * </p>
 * <p>
 * As an example, the all player selector is {@code @a}, and with a radius of
 * 20 it would be {@code @a[r=20]}.
 * </p>
 * </p>
 *
 * @see <a href="http://minecraft.gamepedia.com/Selector#Target_selectors">
 *      Target selectors on the Minecraft Wiki</a>
 */
public interface Selector {

    /**
     * Creates a {@link Selector.Builder}.
     *
     * @return A new selector builder with the specified type
     */
    static Builder builder() {
        return getFactory().createBuilder();
    }

    /**
     * Parses a {@link Selector} from the given selector string.
     *
     * @param selector The raw selector string
     * @return A new selector containing the given selector data
     */
    static Selector parse(String selector) {
        return getFactory().parseRawSelector(selector);
    }

    /**
     * Fetch completions for a selector command argument.
     * 
     * @param selector The partial selector
     * @return Tab completions for the next part of the selector
     */
    static List<String> complete(String selector) {
        return getFactory().complete(selector);
    }

    /**
     * Returns the type of this {@link Selector}.
     *
     * @return The type of this selector
     */
    SelectorType getType();

    /**
     * Returns the argument value for the specified {@link ArgumentType} in this
     * {@link Selector}. May be used for {@link ArgumentType.Invertible}, but
     * the inverted state must be checked with
     * {@link #isInverted(ArgumentType.Invertible)}.
     *
     * @param type The argument type
     * @param <T> The type of the value
     * @return The value of the argument, if available
     */
    <T> Optional<T> get(ArgumentType<T> type);

    /**
     * Returns the {@link Argument} for the specified {@link ArgumentType} in
     * this {@link Selector}.
     *
     * @param type The argument type
     * @param <T> The type of the argument value
     * @return The argument, if available
     */
    <T> Optional<Argument<T>> getArgument(ArgumentType<T> type);

    /**
     * Returns the {@link Argument.Invertible} for the specified
     * {@link ArgumentType.Invertible} in this {@link Selector}.
     *
     * @param type The argument type
     * @param <T> The type of the argument value
     * @return The argument, if available
     */
    <T> Optional<Argument.Invertible<T>> getArgument(ArgumentType.Invertible<T> type);

    /**
     * Returns the arguments for this {@link Selector}.
     *
     * @return The arguments for this {@link Selector}
     */
    List<Argument<?>> getArguments();

    /**
     * Checks for the presence of {@code type} in this {@link Selector}.
     *
     * @param type - The {@link ArgumentType} to check for
     * @return {@code true} if the given type is present in this
     *         {@link Selector}, otherwise {@code false}
     */
    boolean has(ArgumentType<?> type);

    /**
     * Checks for the inversion state of {@code type} in this {@link Selector}.
     *
     * @param type - The invertible {@link ArgumentType} to check inversion
     *        status on
     * @return {@code true} if the given type is inverted in this
     *         {@link Selector}, otherwise {@code false}
     */
    boolean isInverted(ArgumentType.Invertible<?> type);

    /**
     * Resolves this {@link Selector} to a list of entities around the origin.
     *
     * <p>The returned set may be ordered based on distance from the origin
     * (with the nearest first).</p>
     *
     * @param origin The source that should be considered the origin of this
     *        selector
     * @return The matched entities
     */
    Set<Entity> resolve(CommandSource origin);

    /**
     * Resolves this {@link Selector} to a list of entities around (0|0|0) in
     * the given {@link Extent Extent(s)}.
     *
     * <p>The returned set may be ordered based on distance from the origin
     * (with the nearest first).</p>
     *
     * @param extent The extents to search for targets
     * @return The matched entities
     */
    Set<Entity> resolve(Extent... extent);

    /**
     * Resolves this {@link Selector} to a list of entities around (0|0|0) in
     * the given {@link Extent Extent(s)}.
     *
     * <p>The returned set may be ordered based on distance from the origin
     * (with the nearest first).</p>
     *
     * @param extent The extents to search for targets
     * @return The matched entities
     */
    Set<Entity> resolve(Collection<? extends Extent> extent);

    /**
     * Resolves this {@link Selector} to a list of entities around the given
     * {@link Location}.
     *
     * <p>The returned set may be ordered based on distance from the origin
     * (with the nearest first).</p>
     *
     * @param location The location to resolve the selector around
     * @return The matched entities
     */
    Set<Entity> resolve(Location<World> location);

    /**
     * Resolves this {@link Selector} to a list of entities around the origin.
     *
     * @param origin The source that should be considered the origin of this
     *        selector
     * @return The matched entities
     * @deprecated Use {@link #resolve(CommandSource)}
     */
    @Deprecated
    default Set<Entity> resolveForce(CommandSource origin) {
        return resolve(origin);
    }

    /**
     * Resolves this {@link Selector} to a list of entities around (0|0|0) in
     * the given {@link Extent Extent(s)}.
     *
     * @param extent The extents to search for targets
     * @return The matched entities
     * @deprecated Use {@link #resolve(Extent[])}
     */
    @Deprecated
    default Set<Entity> resolveForce(Extent... extent) {
        return resolve(extent);
    }

    /**
     * Resolves this {@link Selector} to a list of entities around (0|0|0) in
     * the given {@link Extent Extent(s)}.
     *
     * @param extent The extents to search for targets
     * @return The matched entities
     * @deprecated Use {@link #resolve(Collection)}
     */
    @Deprecated
    default Set<Entity> resolveForce(Collection<? extends Extent> extent) {
        return resolve(extent);
    }

    /**
     * Resolves this {@link Selector} to a list of entities around the given
     * {@link Location}.
     *
     * @param location The location to resolve the selector around
     * @return The matched entities
     * @deprecated Use {@link #resolve(Location)}
     */
    @Deprecated
    default Set<Entity> resolveForce(Location<World> location) {
        return resolve(location);
    }

    /**
     * Converts this {@link Selector} to a valid selector string.
     *
     * @return A valid {@link Selector} string that can be inserted into a
     *         command
     */
    String toPlain();

    /**
     * Returns a new {@link org.spongepowered.api.text.selector.Selector.Builder}
     * with the content of this selector. This can be used to edit an immutable
     * {@link Selector} instance.
     *
     * @return A new selector builder with the content of this selector
     */
    Builder toBuilder();

    interface Builder extends ResettableBuilder<Selector, Builder> {

        /**
         * Sets the type of this selector.
         *
         * @param type The type to set
         * @return This selector builder
         */
        Builder type(SelectorType type);

        /**
         * Adds some arguments to this selector.
         *
         * @param arguments The arguments to add
         * @return This selector builder
         */
        Builder add(Argument<?>... arguments);

        /**
         * Adds some arguments to this selector.
         *
         * @param arguments The arguments to add
         * @return This selector builder
         */
        Builder add(Iterable<Argument<?>> arguments);

        /**
         * Adds a new {@link Argument} with the specified {@link ArgumentType} and
         * value to this selector.
         *
         * @param type The type of the argument
         * @param value The value of the argument
         * @param <T> The type of the argument value
         * @return This selector builder
         */
        <T> Builder add(ArgumentType<T> type, T value);

        /**
         * Removes the specified arguments, if they exist.
         *
         * @param arguments The arguments to remove
         * @return This selector builder
         */
        Builder remove(Argument<?>... arguments);

        /**
         * Removes the specified arguments, if they exist.
         *
         * @param arguments The arguments to remove
         * @return This selector builder
         */
        Builder remove(Iterable<Argument<?>> arguments);

        /**
         * Removes the arguments with the specified {@link ArgumentType}, if they
         * exist.
         *
         * @param types The argument types
         * @return This selector builder
         */
        Builder remove(ArgumentType<?>... types);

        /**
         * Builds an immutable instance of the current state of this selector
         * builder.
         *
         * @return An immutable {@link Selector} with the current properties of this
         *         builder
         */
        Selector build();

    }

}

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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.Location;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Represents an immutable selector of targets, as used in commands.
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
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Parses a {@link Selector} from the given selector string.
     *
     * @param selector The raw selector string
     * @return A new selector containing the given selector data
     */
    static Selector parse(String selector) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).parseRawSelector(selector);
    }

    /**
     * Fetch completions for a selector command argument.
     *
     * @param selector The partial selector
     * @return Tab completions for the next part of the selector
     */
    static List<String> complete(String selector) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).complete(selector);
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
     * Resolves this {@link Selector} to a list of entities based on the
     * given {@link Cause}.
     *
     * <p>The returned set may be ordered based on distance from the chosen
     * origin (with the nearest first).</p>
     *
     * @param cause The cause to base the resolution around
     * @return The matched entities
     */
    Set<Entity> resolve(Cause cause);

    /**
     * Resolves this {@link Selector} to a list of entities around the given
     * {@link Locatable}.
     *
     * <p>The returned set may be ordered based on distance from the origin
     * (with the nearest first).</p>
     *
     * @param locatable The locatable to resolve the selector around
     * @return The matched entities
     */
    default Set<Entity> resolve(Locatable locatable) {
        return resolve(locatable.getLocation());
    }

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
    Set<Entity> resolve(Location location);

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

    interface Builder extends CopyableBuilder<Selector, Builder> {

        /**
         * Sets the type of this selector.
         *
         * @param type The type to set
         * @return This selector builder
         */
        default Builder type(Supplier<? extends SelectorType> type) {
            return this.type(type.get());
        }

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

    interface Factory {

        Selector parseRawSelector(String selector);

        List<String> complete(String selector);
    }
}

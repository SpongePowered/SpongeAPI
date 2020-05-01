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
package org.spongepowered.api.text.placeholder;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Contains the context that a {@link PlaceholderParser} can use to determine
 * what to display.
 */
public interface PlaceholderContext {

    /**
     * Creates a {@link PlaceholderContext} for a {@link PlaceholderParser} to
     * consume.
     *
     * @return The builder.
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * If provided, the {@link Object} which to pull information from
     * when building the placeholder text.
     *
     * <p>Examples of how this might affect a placeholder are:</p>
     *
     * <ul>
     *     <li>
     *         For a "name" placeholder that prints out the source's name,
     *         the name would be selected from this source.
     *     </li>
     *     <li>
     *         For a "current world" placeholder that returns a player's current
     *         world, this would pull the name of that current world from the
     *         player.
     *     </li>
     * </ul>
     *
     * <p>It is important to note that the associated context does not
     * necessarily have to be the sender/invoker of a message, nor does it
     * have to be the recipient. The source is selected by the context of
     * builder. It is up to plugins that use such placeholders to be aware
     * of the context of which the placeholder is used.
     * {@link PlaceholderParser}s should make no assumption about the origin of
     * the context.</p>
     *
     * <p>If an invalid {@link Object} is provided for the context
     * of the placeholder, then the associated {@link PlaceholderParser} must
     * return a {@link Text#EMPTY}.</p>
     *
     * @return The associated {@link Object}, if any.
     */
    Optional<Object> getAssociatedObject();

    /**
     * The variable string passed to this token to provide contextual
     * information.
     *
     * @return The argument, if any
     */
    Optional<String> getArgumentString();

    /**
     * A builder for {@link PlaceholderText} objects.
     */
    interface Builder extends ResettableBuilder<PlaceholderContext, Builder> {

        /**
         * Sets the {@link Object} to use as a source of information
         * for this {@link PlaceholderText} to the supplied {@link Player}.
         *
         * @param player The player to associate this text with.
         * @return This, for chaining
         *
         * @see #getAssociatedObject()
         */
        default Builder setAssociatedObject(Player player) {
            final UUID uuid = player.getUniqueId();
            return setAssociatedObject(() -> Sponge.getServer().getPlayer(uuid).orElse(null));
        }

        /**
         * Sets the {@link Object} to use as a source of information
         * for this {@link PlaceholderText}. If {@code null}, removes this
         * source.
         *
         * <p>If you are intending to keep the associated
         * {@link PlaceholderText} for any period of time and that you wish to
         * associate a game object with the placeholder, use
         * {@link #setAssociatedObject(Supplier)} instead, supplying a function
         * that can recreate the object if necessary.</p>
         *
         * <p>If supplying a {@link Player}, use
         * {@link #setAssociatedObject(Player)}, which will handle creating the
         * correct supplier for you.</p>
         *
         * @param object The {@link Object} to associate this text with.
         * @return This, for chaining
         *
         * @see #getAssociatedObject()
         */
        Builder setAssociatedObject(@Nullable Object object);

        /**
         * Sets the {@link Object} to use as a source of information
         * for this {@link PlaceholderText}. If {@code null}, removes this source.
         *
         * @param supplier A {@link Supplier} that provides the {@link Object}
         * @return This, for chaining
         *
         * @see #getAssociatedObject()
         */
        Builder setAssociatedObject(@Nullable Supplier<Object> supplier);

        /**
         * Sets a string that represents variables for the supplied token.
         * The format of this argument string is dependent on the parser
         * that consumes this string and thus is not prescribed here.
         *
         * @param string The argument string, may be null to reset to
         *      the default argument string
         * @return This, for chaining
         *
         * @see #getArgumentString()
         */
        Builder setArgumentString(@Nullable String string);

        /**
         * Builds and returns the placeholder.
         *
         * @return The appropriate {@link PlaceholderText}
         * @throws IllegalStateException if the builder has not been completed,
         *  or the associated {@link PlaceholderParser} could not validate the
         *  built {@link PlaceholderText}, if applicable.
         */
        PlaceholderContext build() throws IllegalStateException;

    }

}

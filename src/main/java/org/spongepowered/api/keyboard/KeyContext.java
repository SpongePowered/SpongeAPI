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
package org.spongepowered.api.keyboard;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.function.Predicate;

/**
 * Represents a context in which is a {@link KeyBinding} is usable.
 *
 * <p>A client can assign a key to multiple bindings, when that happens
 * will the {@link KeyContext} notify the user whether there may occur
 * any conflicts.<p/>
 */
@CatalogedBy(KeyContexts.class)
public interface KeyContext extends CatalogType {

    /**
     * Creates a new {@link Builder}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets whether this context is currently active
     * for the given {@link Player}.
     *
     * @param player The player
     * @return Whether the context is active
     */
    boolean isActive(Player player);

    /**
     * Gets whether this context conflicts with the
     * other key context.
     *
     * @param keyContext The other key context
     * @return Whether the contexts conflict
     */
    boolean conflictsWith(KeyContext keyContext);

    interface Builder extends ResettableBuilder<KeyContext, Builder> {

        /**
         * Sets the {@link Predicate} that should be used to check if
         * the context is active for a {@link Player}. Defaults to
         * {@code player -> true}.
         *
         * @param activePredicate The predicate
         * @return This builder for chaining
         */
        Builder active(Predicate<Player> activePredicate);

        /**
         * Sets the {@link Predicate} that should be used to check if
         * the context is in conflict with a other {@link KeyContext}.
         * Defaults to {@code context -> true}.
         *
         * @param conflictPredicate The conflict predicate
         * @return This builder for chaining
         */
        Builder conflicts(Predicate<KeyContext> conflictPredicate);

        /**
         * Builds a new instanceof of a {@link KeyContext}.
         *
         * @param plugin The plugin instance that owns the key context
         * @param identifier The identifier
         * @return The key context
         * @throws IllegalStateException If the key context is not complete
         */
        KeyContext build(Object plugin, String identifier);
    }
}

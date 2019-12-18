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
package org.spongepowered.api.world.server;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameState;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CatalogBuilder;

/**
 * Represents a registration of a world.
 *
 * <p>
 *     It is left up to the implementation on how it handles the registrations.
 *
 *     In vanilla Minecraft, the server will load all worlds that have registrations during {@link GameState#SERVER_STARTING}.
 * </p>
 */
public interface WorldRegistration extends CatalogType {

    /**
     * Gets a new Builder instance for world registration.
     *
     * @return A new builder instance
     */
    static WorldRegistration.Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the directory name to be used for this world registration.
     *
     * <p>
     *     In vanilla Minecraft, examples include DIM-1 and DIM1 (The Nether and The End respectively). The default,
     *     "overworld", world will change it's name based on what is set in the server.properties.
     * </p>
     *
     * @return The directory name
     */
    String getDirectoryName();

    interface Builder extends CatalogBuilder<WorldRegistration, Builder> {

        /**
         * Sets the directory name
         *
         * @param name The directory name
         * @return The builder, for chaining
         */
        Builder directoryName(String name);
    }
}

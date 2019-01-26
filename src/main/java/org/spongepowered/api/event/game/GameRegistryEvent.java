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
package org.spongepowered.api.event.game;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.GenericEvent;
import org.spongepowered.api.event.impl.AbstractGameRegistryRegisterEvent;
import org.spongepowered.api.registry.AdditionalCatalogRegistryModule;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.CatalogTypeAlreadyRegisteredException;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;

/**
 * A base event for registry related events.
 */
public interface GameRegistryEvent extends Event {

    /**
     * This event is called to allow additional registrations for
     * specific {@link CatalogType}s.
     *
     * <p>When creating custom {@link CatalogRegistryModule}s, implementing the
     * {@link AdditionalCatalogRegistryModule} allows this event to be called
     * for the target {@link CatalogType}. All the {@link CatalogType}s will
     * be registered through the {@link AdditionalCatalogRegistryModule#registerAdditionalCatalog(CatalogType)}
     * method.</p>
     *
     * @param <T> The type of the catalog type
     */
    @ImplementedBy(AbstractGameRegistryRegisterEvent.class)
    interface Register<T extends CatalogType> extends GameRegistryEvent, GenericEvent<T> {

        /**
         * Gets the {@link CatalogType} that
         * is allowing registrations.
         *
         * @return The catalog type
         */
        Class<T> getCatalogType();

        /**
         * Gets the registry module.
         *
         * @return The registry module
         */
        CatalogRegistryModule<T> getRegistryModule();

        /**
         * Registers the {@link CatalogType}.
         *
         * @param catalogType The catalog type
         * @throws IllegalArgumentException If there is an id conflict with the
         *     given type and an existing type
         * @throws UnsupportedOperationException If registration for the given
         *     type is not supported
         * @throws CatalogTypeAlreadyRegisteredException If the type cannot be
         *     registered because a matching type was already registered
         */
        void register(T catalogType);
    }
}

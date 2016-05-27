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
package org.spongepowered.api.item.inventory;

import org.spongepowered.api.Archetype;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.item.inventory.InteractInventoryEvent;
import org.spongepowered.api.item.inventory.property.TitleProperty;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CatalogedBy(InventoryArchetypes.class)
public interface InventoryArchetype extends Archetype {

    /**
     * Gets all child InventoryArchetypes
     *
     * @return The child Archetypes
     */
    List<InventoryArchetype> getChildArchetypes();

    /**
     * Returns all properties defined on this Archetype
     *
     * @return The properties
     */
    Map<String, InventoryProperty<String, ?>> getProperties();

    /**
     * Returns the Property with given key.
     *
     * @param key The key
     * @return The matching Property or Optional.empty() if not found
     */
    Optional<InventoryProperty<String, ?>> getProperty(String key);

    /**
     * Returns the property with the Properties default key
     *
     * @param type The type of Property to query for
     * @param <T> Expected Type of InventoryProperty
     * @return The matching Property or Optional.empty() if not found
     */
    default <T extends InventoryProperty<String, ?>> Optional<T> getProperty(Class<T> type) {
        return getProperty(type, type.getSimpleName());
    }

    /**
     * Returns the property
     *
     * @param type The type of Property to query for
     * @param key The Property key to search for
     * @param <T> Expected Type of InventoryProperty
     * @return The matching Property or Optional.empty() if not found
     */
    <T extends InventoryProperty<String, ?>> Optional<T> getProperty(Class<T> type, String key);

    /**
     * Creates a new {@link Builder} based of this InventoryArchetype.
     *
     * @return The builder
     */
    default Builder toBuilder() {
        return builder().from(this);
    }

    /**
     * Builds a new {@link Inventory} based of this InventoryArchetype alone.
     *
     * @return The new Inventory
     */
    default Inventory newInventory() {
        return Inventory.builder().of(this).build();
    }

    /**
     * Creates a new {@link Builder} to build an {@link InventoryArchetype}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }


    /**
     * A Builder for InventoryArchetypes.
     * Compositions of multiple base InventoryArchetypes are possible
     *
     * TODO include example
     */
    interface Builder extends ResettableBuilder<InventoryArchetype, Builder> {

        /**
         * Adds a {@link TitleProperty} to this Archetype
         *
         * @param title The default title
         * @return Fluent pattern
         */
        default Builder title(Translation title) {
            return this.title(Text.of(title));
        }

        /**
         * Adds a {@link TitleProperty} to this Archetype
         *
         * @param title The default title
         * @return Fluent patternI
         */
        // TODO decide if Translation should be forced / Colors seem to be possible using the old colorcodes
        default Builder title(Text title) {
            property(new TitleProperty(title));
            return this;
        }

        /**
         * Adds an {@link InventoryProperty} to this Archetype
         *
         * @param property The Property to add
         * @return Fluent pattern
         */
        Builder property(InventoryProperty<String, ?> property);

        /**
         * Adds an {@link InventoryArchetype} to this Archetype
         *
         * @param archetype The Archetype to add
         * @return Fluent pattern
         */
        Builder with(InventoryArchetype archetype);

        /**
         * Adds multiple {@link InventoryArchetype} to this Archetype
         *
         * @param archetypes The Archetypes to add
         * @return Fluent pattern
         */
        Builder with(InventoryArchetype... archetypes);

        /**
         * TODO maybe remove this? Why not always allow all events on any Inventory?
         * Adds an event to this Archetype
         *
         * @param type The type
         * @return Fluent interface
         */
        Builder withEvent(Class<? extends InteractInventoryEvent> type);

        /**
         * Registers the InventoryArchetype
         *
         * @return The registered InventoryArchetype
         */
        InventoryArchetype build(String id, String name);
    }

}

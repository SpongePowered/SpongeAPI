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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.List;

@CatalogedBy(InventoryArchetypes.class)
public interface InventoryArchetype extends CatalogType, PropertyHolder {

    /**
     * Creates a new {@link Builder} to build an {@link InventoryArchetype}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets all child InventoryArchetypes.
     *
     * @return The child Archetypes
     */
    List<InventoryArchetype> getChildArchetypes();

    /**
     * A Builder for InventoryArchetypes.
     *
     * <p>Compositions of multiple base {@link InventoryArchetypes} are
     * possible.</p>
     */
    interface Builder extends CatalogBuilder<InventoryArchetype, Builder> {

        /**
         * Adds a {@link InventoryProperties#TITLE} to this Archetype.
         *
         * @param title The default title
         * @return Fluent pattern
         */
        default Builder title(Translation title) {
            return this.title(Text.of(title));
        }

        /**
         * Adds a {@link InventoryProperties#TITLE} to this Archetype.
         *
         * @param title The default title
         * @return Fluent pattern
         */
        // TODO Decide if Translation should be forced / Colors seem to be possible using the old colorcodes
        default Builder title(Text title) {
            return property(InventoryProperties.TITLE, title);
        }

        /**
         * Adds a {@link Property} with a specific value.
         *
         * @param property The property
         * @param value The property value
         * @return Fluent pattern
         */
        <V> Builder property(Property<V> property, V value);

        /**
         * Adds an {@link InventoryArchetype} to this Archetype.
         *
         * @param archetype The Archetype to add
         * @return Fluent pattern
         */
        Builder with(InventoryArchetype archetype);

        /**
         * Adds multiple {@link InventoryArchetype} to this Archetype.
         *
         * @param archetypes The Archetypes to add
         * @return Fluent pattern
         */
        Builder with(InventoryArchetype... archetypes);
    }

}

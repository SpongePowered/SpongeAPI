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
package org.spongepowered.api.advancement;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.NamedCatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.NamedCatalogBuilder;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * An advancement.
 */
public interface Advancement extends ComponentLike, CatalogType {

    /**
     * Creates a new {@link Builder} to create {@link Advancement}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link AdvancementTree} this advancement is located in,
     * will only be present if the root advancement was used to create
     * a {@link AdvancementTree}.
     *
     * @return The advancement tree
     */
    Optional<AdvancementTree> getTree();

    /**
     * Gets all the children {@link Advancement}s.
     *
     * @return The children advancements
     */
    Collection<Advancement> getChildren();

    /**
     * Gets all the {@link AdvancementCriterion} that should be achieved
     * before this advancement is unlocked. {@link AdvancementCriterion#empty()}
     * will be returned if no criterion was assigned.
     *
     * <p>This {@link AdvancementCriterion} can be a AND or OR operation that
     * contains multiple possible {@link AdvancementCriterion}s.</p>
     *
     * @return The criterion
     */
    AdvancementCriterion getCriterion();

    /**
     * Gets the parent {@link Advancement}, if present.
     *
     * @return The parent advancement, if present
     */
    Optional<Advancement> getParent();

    /**
     * Gets the {@link DisplayInfo} of this advancement, if present.
     *
     * @return The display info, if present
     */
    Optional<DisplayInfo> getDisplayInfo();

    /**
     * Gets the {@link Component} lines that would be used to
     * display a toast notification.
     *
     * @return The text lines
     */
    List<Component> toToastText();

    /**
     * A builder to create {@link Advancement}s.
     */
    interface Builder extends CatalogBuilder<Advancement, Builder> {

        /**
         * Sets the parent {@link Advancement}.
         * <p>For the root advancement use {@link #root}</p>
         *
         * @param parent The parent advancement
         * @return This builder, for chaining
         */
        Builder parent(Advancement parent);

        /**
         * Sets this advancement as root.
         *
         * @return This builder, for chaining
         */
        Builder.RootStep root();

        /**
         * Define root advancement only parameters.
         */
        interface RootStep extends Builder {

            /**
             * Sets the background path..
             *
             * @param backgroundPath The {@link AdvancementTree}s background.
             *
             * @return This builder, for chaining
             */
            // TODO: Deprecate when ResourcePath is available
            Builder background(String backgroundPath);
        }

        /**
         * Sets the {@link AdvancementCriterion} that should be used
         * for the advancement. Defaults to {@link AdvancementCriterion#empty()}.
         *
         * @param criterion The criterion
         * @return This builder, for chaining
         */
        Builder criterion(AdvancementCriterion criterion);

        /**
         * Sets the {@link DisplayInfo}. Defaults to {code null}.
         *
         * @param displayInfo The display info
         * @return This builder, for chaining
         */
        Builder displayInfo(@Nullable DisplayInfo displayInfo);

    }
}

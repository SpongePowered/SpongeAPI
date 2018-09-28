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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.CatalogBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * An advancement.
 */
public interface Advancement extends CatalogType, TextRepresentable {

    /**
     * Creates a new {@link Builder} to create {@link Advancement}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
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
     * before this advancement is unlocked. {@link AdvancementCriterion#EMPTY}
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
     * Gets the {@link Text} lines that would be used to
     * display a toast notification.
     *
     * @return The text lines
     */
    List<Text> toToastText();

    /**
     * A builder to create {@link Advancement}s.
     */
    interface Builder extends CatalogBuilder<Advancement, Builder> {

        /**
         * Sets the parent {@link Advancement}. Defaults to {code null}.
         *
         * @param parent The parent advancement
         * @return This builder, for chaining
         */
        Builder parent(@Nullable Advancement parent);

        /**
         * Sets the {@link AdvancementCriterion} that should be used
         * for the advancement. Defaults to {@link AdvancementCriterion#EMPTY}.
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

        @Override
        Builder id(String id);

        /**
         * Sets the name of the {@link Advancement}. Defaults to
         * the plain {@link DisplayInfo#getTitle()} if the
         * {@link DisplayInfo} is present. Otherwise will it default
         * to the identifier ({@link #id(String)}).
         *
         * @param name The name
         * @return This builder, for chaining
         */
        @Override
        Builder name(String name);

        @Override
        Advancement build();

        @Override
        @Deprecated
        default Builder from(Advancement value) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Cannot create duplicate advancements!");
        }

    }

}

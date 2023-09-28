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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.util.Optional;

/**
 * A template for an {@link Advancement}.
 */
public interface AdvancementTemplate extends DataPackEntry<AdvancementTemplate> {

    /**
     * Creates a new {@link Builder} to create {@link Advancement}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Return the advancement
     *
     * @return The advancement
     */
    Advancement advancement();

    /**
     * Gets the {@link AdvancementTree} of this advancement
     * will only be present if it is a root advancement.
     *
     * @return The advancement tree
     */
    Optional<AdvancementTree> tree();

    /**
     * A builder to create {@link Advancement}s.
     */
    interface Builder extends ResourceKeyedBuilder<AdvancementTemplate, Builder> {

        /**
         * Sets the parent {@link Advancement} template.
         * <p>For the root advancement use {@link #root}</p>
         *
         * @param parent The parent advancement
         * @return This builder, for chaining
         */
        Builder parent(AdvancementTemplate parent);

        /**
         * Sets the parent {@link Advancement} key.
         * <p>For the root advancement use {@link #root}</p>
         *
         * @param parent The parent advancement
         * @return This builder, for chaining
         */
        Builder parent(ResourceKey parent);

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
            Builder background(ResourceKey backgroundPath);
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

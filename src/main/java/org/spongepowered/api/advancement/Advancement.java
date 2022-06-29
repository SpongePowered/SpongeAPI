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
import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.data.persistence.DataSerializable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * An advancement.
 */
public interface Advancement extends ComponentLike, ResourceKeyed, DataSerializable {

    /**
     * Gets the {@link AdvancementTree} this advancement is located in,
     * will only be present if the root advancement was used to create
     * a {@link AdvancementTree}.
     *
     * @return The advancement tree
     */
    Optional<AdvancementTree> tree();

    /**
     * Gets all the children {@link Advancement}s.
     *
     * @return The children advancements
     */
    Collection<Advancement> children();

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
    AdvancementCriterion criterion();

    /**
     * Gets the parent {@link Advancement}, if present.
     *
     * @return The parent advancement, if present
     */
    Optional<Advancement> parent();

    /**
     * Gets the {@link DisplayInfo} of this advancement, if present.
     *
     * @return The display info, if present
     */
    Optional<DisplayInfo> displayInfo();

    /**
     * Gets the {@link Component} lines that would be used to
     * display a toast notification.
     *
     * @return The text lines
     */
    List<Component> toToastText();

}

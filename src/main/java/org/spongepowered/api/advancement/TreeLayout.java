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

import java.util.Collection;
import java.util.Optional;

/**
 * Represents the tree (tab) layout of a {@link AdvancementTree}.
 */
public interface TreeLayout {

    /**
     * Gets the {@link AdvancementTree} this layout is assigned to.
     *
     * @return The tree
     */
    AdvancementTree getTree();

    /**
     * Gets all the {@link TreeLayoutElement}s that are
     * present in this layout.
     *
     * @return The tree layout elements
     */
    Collection<TreeLayoutElement> getElements();

    /**
     * Gets the {@link TreeLayoutElement} for the specified {@link Advancement},
     * {@link Optional#empty()} will be returned if the advancement is not present
     * in the tree or if there is no {@link DisplayInfo} present.
     *
     * @param advancement The advancement
     * @return The tree layout element
     */
    Optional<TreeLayoutElement> getElement(Advancement advancement);

}

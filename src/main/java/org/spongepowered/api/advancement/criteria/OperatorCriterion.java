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
package org.spongepowered.api.advancement.criteria;

import java.util.Collection;
import java.util.Optional;

public interface OperatorCriterion extends AdvancementCriterion {

    /**
     * Attempts to find all the children {@link AdvancementCriterion}s
     * with the specified name. The children will be checked recursively.
     *
     * @param name The name
     * @return The criteria
     */
    Collection<AdvancementCriterion> find(String name);

    /**
     * Attempts to find the first child {@link AdvancementCriterion} with
     * the specified name. The children will be checked recursively, but
     * direct children are prioritized.
     *
     * @param name The name
     * @return The criterion
     */
    Optional<AdvancementCriterion> findFirst(String name);

    /**
     * Gets the children {@link AdvancementCriterion}s of this
     * {@link OperatorCriterion}. May contain {@link OperatorCriterion}s.
     *
     * @return The criteria
     */
    Collection<AdvancementCriterion> criteria();

    /**
     * Gets the leaf {@link AdvancementCriterion}s. This means that there will
     * never be any {@link OperatorCriterion}s in this list.
     *
     * @return The leaf criteria
     */
    Collection<AdvancementCriterion> leafCriteria();

}

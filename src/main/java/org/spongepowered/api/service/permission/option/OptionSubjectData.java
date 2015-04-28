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
package org.spongepowered.api.service.permission.option;

import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.service.permission.context.Context;

import java.util.Map;
import java.util.Set;

public interface OptionSubjectData extends SubjectData {

    /**
     * Return all options for all context combinations currently registered.
     *
     * @return An immutable snapshot of all options data
     */
    Map<Set<Context>, Map<String, String>> getAllOptions();

    /**
     * Get options for a specific context combination.
     *
     * @param contexts The context combination to get options for
     * @return All available options, returning an empty map if none are present
     */
    Map<String, String> getOptions(Set<Context> contexts);

    /**
     * Set a specific option to a value.
     *
     * @param contexts The context combination to set the given option in
     * @param key The key to set. Case-insensitive.
     * @param value The value to set.
     * @return Whether the operation was successful
     */
    boolean setOption(Set<Context> contexts, String key, String value);

    /**
     * Clear all options in the given context combination.
     *
     * @param contexts The context combination
     * @return Whether the operation was successful (any options were remowed)
     */
    boolean clearOptions(Set<Context> contexts);

    /**
     * Clear all options.
     *
     * @return Whether the operation was successful
     */
    boolean clearOptions();
}

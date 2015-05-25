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

import com.google.common.base.Optional;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.context.Context;

import java.util.Set;

public interface OptionSubject extends Subject {
    @Override
    OptionSubjectData getSubjectData();

    @Override
    OptionSubjectData getTransientSubjectData();

    /**
     * Get the value of a given option in the given context.
     *
     * @param key The key to get an option by. Case-insensitive.
     * @return The value of the option, if any is present
     */
    Optional<String> getOption(Set<Context> contexts, String key);

    /**
     * Get the value of a given option in the subject's current context
     *
     * @param key The key to get an option by. Case-insensitive.
     * @return The value of the option, if any is present
     */
    Optional<String> getOption(String key);
}

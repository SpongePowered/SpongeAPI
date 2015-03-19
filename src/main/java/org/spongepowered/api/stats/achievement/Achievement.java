/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.stats.achievement;

import com.google.common.base.Optional;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;

import java.util.Collection;

/**
 * Represents an in-game achievement which may be earned by or given to players.
 */
public interface Achievement extends Translatable {

    /**
     * Gets an internal identifier for this achievement. For proper name of the
     * achievement see {@link Achievement#getTranslation()}.
     * 
     * @return The id
     */
    String getId();
    
    /**
     * Returns the description that describes this achievement.
     *
     * @return The description of this achievement
     */
    Translation getDescription();

    /**
     * Returns the parent of this achievement, if there is one.
     *
     * @return The parent of this achievement
     */
    Optional<Achievement> getParent();

    /**
     * Returns the children of this achievement.
     *
     * @return An immutable collection of all children this achievement has
     */
    Collection<Achievement> getChildren();

}

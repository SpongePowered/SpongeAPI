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

package org.spongepowered.api.entity.ai;

import org.spongepowered.api.entity.Entity;

/**
 * Represents an {@link Entity} that is controlled by an AI.
 */
public interface AIControlled extends Entity {

    /**
     * Sets the {@link AIHandler} for this {@link Entity}.
     * <p>
     * <b>Note:</b>An {@link AIHandler} is bound to an {@link Entity} and cannot
     * be transferred to another {@link Entity}.
     * </p>
     *
     * @param aiHandler The new AI handler.
     */
    void setAIHandler(AIHandler aiHandler);

    /**
     * Gets the {@link AIHandler} for this {@link Entity}.
     * <p>
     * <b>Note:</b>An {@link AIHandler} is bound to an {@link Entity} and cannot
     * be transferred to another {@link Entity}.
     * </p>
     *
     * @return The AI handler for this entity
     */
    AIHandler getAIHandler();

    /**
     * Gets the {@link BodyController} for this {@link Entity}.
     *
     * @return The body controller for this entity
     */
    BodyController getBodyController();

}

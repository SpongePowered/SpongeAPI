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
package org.spongepowered.api.data.component.entity;

import org.spongepowered.api.data.component.IntComponent;

/**
 * Represents data that defines the owner as having a growing
 * age process.
 *
 * <p>Negative ages tend to equate to the entity being a baby and
 * therefor can not breed more of this entity. Setting a positive age
 * tends to equate to the entity being an adult and able to breed children.
 * </p>
 */
public interface AgeableComponent extends IntComponent<AgeableComponent> {

    /**
     * Sets the age of this entity to the minimum required to be considered a
     * baby. Babies tend to be unable to breed.
     *
     * @return This instance, for chaining
     */
    AgeableComponent setBaby();

    /**
     * Sets the age of this entity to the minimum required to be considered a
     * full grown adult and able to breed.
     *
     * @return This instance, for chaining
     */
    AgeableComponent setAdult();

    /**
     * Returns true if this entity is considered an adult.
     *
     * @return True if this entity is an adult
     */
    boolean isBaby();

}

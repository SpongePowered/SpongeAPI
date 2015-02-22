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

package org.spongepowered.api.event.cause.reason;

/**
 * Represents a builder for creating custom or complex damage reasons.
 */
public interface DamageReasonBuilder {

    /**
     * Sets whether this damage reason should affect users in creative mode,
     * defaults to false.
     * 
     * @return This builder
     */
    DamageReasonBuilder affectCreativeMode();

    /**
     * Sets whether this damage reason should scale with difficulty, defaults to
     * false.
     * 
     * @return This builder
     */
    DamageReasonBuilder scaleWithDifficulty();

    /**
     * Sets whether this damage reason bypasses armor protection, defaults to
     * false.
     * 
     * @return This builder
     */
    DamageReasonBuilder bypassArmor();

    /**
     * Sets whether this damage reason is blockable, defaults to false.
     * 
     * @return This builder
     */
    DamageReasonBuilder blockable();

    /**
     * Sets the type, or types, of this damage reason, defaults to having no
     * type.
     * 
     * @param types The types of this reason
     * @return This builder
     */
    DamageReasonBuilder type(DamageType... types);

    /**
     * Builds an instance of {@link DamageReason}.
     * 
     * @return A new instance
     * @throws IllegalStateException If the damage reason is not complete
     */
    DamageReason build() throws IllegalStateException;

}

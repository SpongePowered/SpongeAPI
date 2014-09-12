/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.component.entity.attribute;

import org.spongepowered.api.component.entity.EntityComponent;

/**
 * Gives the attribute "health" to an {@link org.spongepowered.api.entity.Entity Entity}.
 */
public interface Health extends EntityComponent {
    /**
     * Gets the value of the current health
     * @return The health value
     */
    double getHealth();
    
    /**
     * Checks if {@link org.spongepowered.api.entity.Entity Entity} is invulnerable.
     * @return true If {@link org.spongepowered.api.entity.Entity Entity} is invulnerable
     */
    boolean isInvulnerable();
    
    /**
     * Sets {@link org.spongepowered.api.entity.Entity Entity} invulnerable if true
     * @param invulnerable true to make invulnerable
     */
    void setInvulnerable(boolean invulnerable);

    /**
     * Sets the value for the health
     * @param value The health value
     */
    void setHealth(double value);
}

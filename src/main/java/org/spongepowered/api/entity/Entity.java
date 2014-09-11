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

package org.spongepowered.api.entity;

import com.google.common.base.Optional;
import org.spongepowered.api.component.Component;
import org.spongepowered.api.component.ComponentManager;

import java.util.UUID;

public interface Entity {

    /**
     * Gets the unique ID for this entity
     *
     * @return The entity's {@link UUID}
     */
    UUID getUniqueID();

    /**
     * Gets the {@link org.spongepowered.api.component.ComponentManager} that will track {@link org.spongepowered.api.component.Component}s for this entity.
     * @return The manager
     */
    ComponentManager<Entity> getComponentManager();

    /**
     * Adds a {@link org.spongepowered.api.component.Component}. The component's class will be used for registration.
     * <p>
     * If the instance's class is already registered, this will override it.
     *
     * @param instance The component
     */
    <C extends Component> C addComponent(C instance);

    /**
     * Adds a {@link org.spongepowered.api.component.Component} keyed to the class.
     * <p>
     * If the instance's class is already registered, this will override it.
     *
     * @param instance The component
     * @param clazz The class the instance will be registered to
     * @return The component
     */
    <C extends Component> C addComponent(C instance, Class<C> clazz);

    /**
     * Gets a {@link org.spongepowered.api.component.Component} registered to the class.
     *
     * @param clazz The class to look for an instance registration
     * @return An optional containing the result
     */
    <C extends Component> Optional<C> getComponent(Class<C> clazz);

    /**
     * Returns if there is a {@link org.spongepowered.api.component.Component} registration for the class.
     *
     * @param clazz The class to lookup
     * @return True if there is a registration found, false if not
     */
    boolean hasComponent(Class<? extends Component> clazz);

    /**
     * Removes a {@link org.spongepowered.api.component.Component} registered to the class.
     *
     * @param clazz The class to look for an instance registration
     * @return An optional containing the result
     */
    <C extends Component> Optional<C> removeComponent(Class<C> clazz);
}

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
package org.spongepowered.api.component;

/**
 * Represents an object that manages {@link org.spongepowered.api.component.Component} relationships with {@link org.spongepowered.api.component.ComponentHolder}s.
 *
 * It also executes {@link org.spongepowered.api.component.ComponentSystem}s which tract holders with certain components for processing
 */
public interface ComponentManager<H extends ComponentHolder> {
    /**
     * Adds a {@link ComponentSystem} to the manager to be processed.
     *
     * @param system System to add
     */
    void addSystem(Class<? extends ComponentSystem<H>> system);

    /**
     * Removes a {@link ComponentSystem} from this manager.
     *
     * @param system The system's class
     * @return The system removed
     */
    ComponentSystem<H> removeSystem(Class<? extends ComponentSystem<H>> system);

    /**
     * Attaches a {@link org.spongepowered.api.component.Component} based on a {@link org.spongepowered.api.component.ComponentKey}.
     *
     * @param holder The holder
     * @param key The key
     */
    <C extends Component<H>> C addComponent(H holder, ComponentKey<C> key);

    /**
     * Detaches a {@link org.spongepowered.api.component.Component} based on a {@link org.spongepowered.api.component.ComponentKey}.
     *
     * @param holder The holder
     * @param key The key
     * @return The removed component
     */
    <C extends Component<H>> C removeComponent(H holder, ComponentKey<C> key);
}

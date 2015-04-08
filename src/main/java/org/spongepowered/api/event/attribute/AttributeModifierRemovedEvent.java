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

package org.spongepowered.api.event.attribute;

import com.google.common.base.Optional;
import org.spongepowered.api.attribute.AttributeModifier;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.util.event.Cancellable;

/**
 * An event fired when an {@link AttributeModifier} is removed from an
 * {@link org.spongepowered.api.data.DataHolder}.
 */
public interface AttributeModifierRemovedEvent extends AttributeEvent, Cancellable {

    /**
     * Gets the {@link AttributeModifier} that was removed in this event.
     *
     * @return The AttributeModifier that was removed in this event
     */
    AttributeModifier getModifier();

    /**
     * Gets the {@link DataHolder} that caused this event, if there was
     * one.
     *
     * @return The {@link DataHolder} that caused this event, if there was one
     */
    Optional<DataHolder> getSource();

}

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
package org.spongepowered.api.item.data;

import com.google.common.base.Optional;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;

/**
 * Represents the display name of an item stack. If a display name is not
 * provided, the item will default to using the traditional item type
 * name.
 *
 * <p>Exceptions are made with written books as the title and display name
 * are one and the same.</p>
 */
public interface DisplayNameData extends ItemData<DisplayNameData> {

    /**
     * Gets the display name as a {@link Text}. The display name may be
     * player set, or it may be undefined.
     *
     * @return The display name, if available
     */
    Optional<Text> getDisplayName();

    /**
     * Sets the display name as a {@link Text}. If set to null,
     * the display name is erased.
     *
     * @param displayName The display name
     */
    void setDisplayName(@Nullable Text displayName);

}

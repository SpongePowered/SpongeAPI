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
package org.spongepowered.api.block.tileentity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.tileentity.NoteData;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Represents a note block.
 *
 * <p>A {@link Note} will always have a valid {@link NoteData} to play.</p>
 */
public interface Note extends TileEntity {

    /**
     * Attempts to play the currently stored {@link NotePitch} from this
     * {@link Note} tile entity.
     */
    void playNote();

    default NoteData getNoteData() {
        return get(NoteData.class).get();
    }

    /**
     * Gets the {@link Value} for the {@link NotePitch}.
     *
     * @return The value for the note pitch
     */
    default Value<NotePitch> note() {
        return getValue(Keys.NOTE_PITCH).get();
    }

}

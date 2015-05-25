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
package org.spongepowered.api.event.block.tileentity;

import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.util.annotation.TransformResult;

/**
 * Represents events where the {@link DataManipulator} of the {@link TileEntity} may change from the
 * resolution of the event.
 * <p>
 * An example of this would be {@link SignChangeEvent} where the data of the sign is set after the event
 */
public interface TileEntityChangeEvent extends TileEntityEvent, CauseTracked, Cancellable {
    /**
     * Gets a copy of the new {@link DataManipulator} that will be offered to the
     * {@link TileEntity} after event resolution.
     * <p>
     * If desiring to change any data of this {@link TileEntity}, do so in
     * this manipulator. Be sure to set this back with {@link TileEntityChangeEvent#setNewData(DataManipulator)}.
     * @return The data
     */
    @TransformResult
    DataManipulator<?> getNewData();

    /**
     * Sets the {@link DataManipulator} that will be offered to the {@link TileEntity} after
     * event resolution.
     * @param newData The new manipulator to apply to the tile entity
     * @throws InvalidDataException Depending on the event, this will be thrown if the manipulator being set isn't
     * assignable from {@link TileEntityChangeEvent#getNewData()}
     */
    void setNewData(DataManipulator<?> newData);
}

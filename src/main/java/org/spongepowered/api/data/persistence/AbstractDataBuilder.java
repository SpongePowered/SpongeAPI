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
package org.spongepowered.api.data.persistence;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;

import java.util.Optional;

/**
 * An abstract implementation of {@link DataBuilder} that pre-defines all of
 * the necessary "content update" implementation required for content
 * versioning. Note that the builder itself is versioned to ensure that
 * content versioning is appropriately handled. It is highly recommended to
 * extend this class to implement {@link DataManipulatorBuilder} and implement
 * {@link DataContentUpdater}s as necessary for future upgradeability of
 * custom content.
 *
 * @param <T> The type of DataSerializable
 */
public abstract class AbstractDataBuilder<T extends DataSerializable> implements DataBuilder<T> {

    private final int supportedVersion;
    private final Class<T> requiredClass;

    protected AbstractDataBuilder(Class<T> requiredClass, int supportedVersion) {
        this.requiredClass = checkNotNull(requiredClass, "Required class");
        this.supportedVersion = supportedVersion;
    }

    /**
     * Builds the currently {@link #supportedVersion} variant of the intended
     * {@link DataSerializable}, such that all content upgrades have already
     * been handled by {@link #build(DataView)}. This otherwise follows the
     * same contract as {@link DataBuilder#build(DataView)}.
     *
     * @param container The container with data to build from
     * @return The deserialized data serializable, if possible
     * @throws InvalidDataException If there's issues of invalid data formats
     *     or invalid data
     */
    protected abstract Optional<T> buildContent(DataView container) throws InvalidDataException;

    @Override
    public final Optional<T> build(DataView container) throws InvalidDataException {
        if (container.contains(Queries.CONTENT_VERSION)) {
            final int contentVersion = container.getInt(Queries.CONTENT_VERSION).get();
            if (contentVersion < this.supportedVersion) {
                Optional<DataContentUpdater> updater = Sponge.getDataManager().getWrappedContentUpdater(this.requiredClass, contentVersion,
                        this.supportedVersion);
                if (!updater.isPresent()) {
                    throw new InvalidDataException("Could not get an updater for ItemEnchantment data from the version: " + contentVersion
                                                   + " to " + this.supportedVersion + ". Please notify the SpongePowered developers of this issue!");
                }
                container = updater.get().update(container);
            }
        }
        try {
            return buildContent(container);
        } catch (Exception e) {
            throw new InvalidDataException("Could not translate something correctly, likely due to bad type data.", e);
        }
    }
}

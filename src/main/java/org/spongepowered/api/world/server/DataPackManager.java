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
package org.spongepowered.api.world.server;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.datapack.DataPackType;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface DataPackManager {

    /**
     * Reloads all reloadable datapacks.
     * Also causes {@link org.spongepowered.api.event.lifecycle.RegisterDataPackValueEvent} to fire
     *
     * @return The future when reloading is complete
     */
    CompletableFuture<Void> reload();

    /**
     * Saves given data pack entry. If the datapack is reloadable the type is available after {@link #reload()}
     * otherwise the server will load the persisted datapack at startup.
     * <p>To load a world from a {@link WorldTemplate} use {@link WorldManager#loadWorld(WorldTemplate)}</p>
     *
     * @param entry the data pack entry to save
     *
     * @return True when the type represented by the datapack entry will be available after reloading
     */
    <T extends DataPackEntry<T>> CompletableFuture<Boolean> save(T entry);

    <T extends DataPackEntry<T>> CompletableFuture<Optional<T>> load(DataPackType<T> type, ResourceKey key);

    boolean delete(DataPackType<?> type, ResourceKey key) throws IOException;

    void copy(final DataPackType<?> type, final ResourceKey from, final ResourceKey to) throws IOException;
    void move(final DataPackType<?> type, final ResourceKey from, final ResourceKey to) throws IOException;

    List<ResourceKey> list(DataPackType<?> type);

    boolean exists(DataPackType<?> type, ResourceKey key);
}

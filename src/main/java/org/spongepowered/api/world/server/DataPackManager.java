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
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.datapack.DataPackType;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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

    /**
     * Loads a {@link DataPackEntry} from given data pack.
     * Returned object may not be able to interact well with the active server.
     *
     * @param pack The data pack
     * @param key The data pack entry key
     *
     * @return The loaded DataPackEntry
     */
    <T extends DataPackEntry<T>> CompletableFuture<Optional<T>> load(DataPack<T> pack, ResourceKey key);

    /**
     * Deletes the data pack entry in given data pack.
     *
     * @param pack The data pack
     * @param key The data pack entry key
     *
     * @return True when deleted
     */
    boolean delete(DataPack<?> pack, ResourceKey key) throws IOException;

    /**
     * Copies a data pack entry in given data pack
     *
     * @param pack The data pack
     * @param from The data pack entry key to copy from
     * @param to  The data pack entry key to copy to
     */
    void copy(final DataPack<?> pack, final ResourceKey from, final ResourceKey to) throws IOException;

    /**
     * Copies a data pack entry into another data pack
     *
     * @param fromPack The data pack to copy from
     * @param from The data pack entry key to copy from
     * @param toPack The data pack to copy to
     * @param to The data pack entry key to copy to
     */
    void copy(final DataPack<?> fromPack, final ResourceKey from, final DataPack<?> toPack, final ResourceKey to) throws IOException;

    /**
     * Moves a data pack entry in the given data pack
     * @param pack The data pack
     * @param from The data pack entry key to move from
     * @param to The data pack entry key to move to
     */
    void move(final DataPack<?> pack, final ResourceKey from, final ResourceKey to) throws IOException;

    /**
     * Moves a data pack entry into another data pack
     *
     * @param fromPack The data pack to move from
     * @param from The data pack entry key to move from
     * @param toPack The data pack to move to
     * @param to The data pack entry key to move to
     */
    void move(final DataPack<?> fromPack, final ResourceKey from, final DataPack<?> toPack, final ResourceKey to) throws IOException;

    /**
     * Lists the data pack entries of the given data pack.
     *
     * @param pack The data pack
     *
     * @return The data pack entries
     */
    List<ResourceKey> list(DataPack<?> pack);

    /**
     * Returns a map of all data pack to data pack entry keys matching the given type.
     *
     * @param packType The data pack type
     *
     * @return The data pack entries found by data pack
     */
    <T extends DataPackEntry<T>> Map<DataPack<T>, Collection<ResourceKey>> find(DataPackType<T> packType);

    /**
     * Returns the data pack containing a data pack entry with given key and pack type
     *
     * @param packType The data pack type
     * @param key The data pack entry key
     *
     * @return The data pack containing the data pack entry
     */
    <T extends DataPackEntry<T>> Optional<DataPack<T>> findPack(DataPackType<T> packType, ResourceKey key);

    /**
     * Returns whether a data pack entry exists in given data pack.
     *
     * @param pack The data pack
     * @param key The data pack entry key
     *
     * @return True when the data pack entry exists
     */
    boolean exists(DataPack<?> pack, ResourceKey key);
}

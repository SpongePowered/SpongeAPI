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
package org.spongepowered.api.resource;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataView;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * A low level async reload listener.
 *
 * <p>There are two stages when reloading resources. The first is done asynchronously, so keep
 * that in mind when interacting with game objects. The second is done synchronously on the game thread. This stage will
 * not execute until all listeners have completed their first stage.</p>
 *
 * <p>In most circumstances, you should prefer to create a more specific use-case instance using the factory instead of
 * implementing this interface directly.</p>
 *
 * <p>Example usage:</p>
 *
 * <pre>
 *     public class MyAsyncReloadListener implements ReloadListener {
 *         public CompletableFuture&lt;Void&gt; onReload(ReloadStage stage, ResourceManager manager, Executor workExecutor, Executor gameExecutor) {
 *             return CompletableFuture
 *                 // create a future in the work stage
 *                 .supplyAsync(() -> {
 *                     // load things async in work executor
 *                     return things;
 *                 }, workExecutor)
 *                 // wait for other listeners to complete the work stage.
 *                 .thenCompose(stage::markComplete)
 *                 // create a future in the game stage
 *                 .thenAcceptAsync(thing -> {
 *                      // apply things sync in game executor
 *                 }, gameExecutor);
 *         }
 *     }
 * </pre>
 */
public interface ResourceReloadListener {

    static Factory factory() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class);
    }

    /**
     * Reloads the resource manager asynchronously.
     *
     * @param stage        The reload stage, use when done with async
     * @param manager      The resource manager
     * @param workExecutor The async work executor
     * @param gameExecutor The sync game executor
     * @return A completable future of the work being done
     */
    CompletableFuture<Void> onReload(AsyncStage stage, ResourceManager manager, Executor workExecutor, Executor gameExecutor);

    /**
     * The stage object used to notify that the listener's async stage is complete.
     */
    interface AsyncStage {

        /**
         * Marks this async stage as complete and waits for the other listeners to complete.
         *
         * @param result The result object
         * @param <T>    The type of the result
         * @return The future
         */
        <T> CompletableFuture<T> markComplete(T result);
    }

    interface Factory {
        /**
         * Creates a simple reload listener that reloads resources on the main thread.
         *
         * @param listener The listener implementation
         * @return The listener
         */
        ResourceReloadListener simple(SimpleReloadListener listener);

        /**
         * Creates a prepared reload listener that loads resources in the work thread and apply them in the main
         * thread.
         *
         * @param listener The listener implementation
         * @param <T>      The type of resource to be prepared
         * @return The listener
         */
        <T> ResourceReloadListener prepared(PreparedReloadListener<T> listener);

        /**
         * Creates a data tree reload listener that loads every json file in a folder from each namespace.
         *
         * @param path     The path of the folder to load
         * @param listener The listener implementation
         * @return The listener
         */
        ResourceReloadListener dataTree(String path, DataTreeReloadListener listener);
    }

    /**
     * Reload listener for resources that need to be loaded and applied on the
     * main thread.
     *
     * <p>This listener may cause longer reload times.</p>
     */
    interface SimpleReloadListener {
        /**
         * Called in the game executor to reload resources.
         *
         * @param manager The resource manager
         */
        void onReload(ResourceManager manager);
    }

    /**
     * Reload listener for resources that take time to create, but need to be
     * applied on the main thread.
     *
     * @param <T> The type of the processed resource
     */
    interface PreparedReloadListener<T> {
        /**
         * Prepares the resources on the work thread.
         *
         * @param manager The resource manager
         * @return The prepared object
         */
        T prepare(ResourceManager manager);

        /**
         * Applies the resources on the main thread.
         *
         * @param object  The prepared object
         * @param manager The resource manager
         */
        void apply(T object, ResourceManager manager);
    }

    /**
     * Reload listener for a tree of json files. Resources from all namespaces
     * are loaded.
     *
     * <p>Json files are loaded on the work thread and applied in the main
     * thread.</p>
     */
    interface DataTreeReloadListener {
        /**
         * Applies the data in the game executor.
         *
         * @param dataTree The mapping of paths to json objects
         * @param manager  The resource manager
         */
        void apply(Map<ResourcePath, DataView> dataTree, ResourceManager manager);
    }
}

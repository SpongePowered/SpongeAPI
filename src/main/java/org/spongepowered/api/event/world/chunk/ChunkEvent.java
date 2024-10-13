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
package org.spongepowered.api.event.world.chunk;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.eventgen.annotations.NoFactoryMethod;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.chunk.BlockChunk;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.chunk.EntityChunk;
import org.spongepowered.api.world.chunk.WorldChunk;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

public interface ChunkEvent extends Event {

    /**
     * Gets the position of the {@link Chunk chunk}, in chunk co-ordinates.
     *
     * @return the position
     */
    Vector3i chunkPosition();

    /**
     * Represents an event that has knowledge about the {@link ServerWorld world} that
     * is being operated upon.
     */
    @NoFactoryMethod
    interface WorldScoped extends ChunkEvent {

        /**
         * Gets the {@link ResourceKey key} of the {@link WorldScoped} that the
         * {@link WorldChunk chunk} resides in.
         *
         * <p>Be careful when retrieving the {@link ServerWorld world} within this
         * event as some events may not fire on the main thread and such world
         * access is not thread safe.</p>
         *
         * @return The world's {@link ResourceKey key}
         */
        ResourceKey worldKey();
    }

    /**
     * Called when a {@link WorldChunk chunk} is performing a block related operation.
     */
    interface Blocks extends WorldScoped {

        /**
         * Called when a block data of {@link WorldChunk chunk} is loaded.
         * This can be called outside the {@link World#engine() main} {@link Thread}.
         * It is NOT safe to perform modifications to the {@link World} or via
         * {@link org.spongepowered.api.world.server.ServerLocation} as this could
         * result in a deadlock.
         */
        interface Load extends Blocks {

            /**
             * Gets the {@link WorldChunk chunk} block volume.
             *
             * @return The block chunk
             */
            BlockChunk chunk();
        }

        /**
         * Called when a {@link WorldChunk chunk} is performing a block related save.
         */
        interface Save extends Blocks {

            /**
             * Called before the {@link WorldChunk chunk} block data is saved. Cancelling this
             * will prevent any of the chunk's block data being written to it's storage container.
             */
            interface Pre extends Blocks.Save, Cancellable {

                /**
                 * Gets the {@link WorldChunk chunk} block volume.
                 *
                 * @return The block chunk
                 */
                BlockChunk chunk();
            }

            /**
             * Called after the {@link WorldChunk chunk} block data is saved.
             * Guaranteed to exist in the chunk's block storage container.
             * <p>
             * Depending on the implementation, this event may be called off-thread.
             */
            interface Post extends Blocks.Save {}
        }
    }

    /**
     * Called when a {@link WorldChunk chunk} is performing a entity related operation.
     */
    interface Entities extends WorldScoped {

        /**
         * Called when an entity data of {@link WorldChunk chunk} is loaded.
         * This can be called outside the {@link World#engine() main} {@link Thread}.
         * It is NOT safe to perform modifications to the {@link World} or via
         * {@link org.spongepowered.api.world.server.ServerLocation} as this could
         * result in a deadlock.
         */
        interface Load extends Entities {

            /**
             * Gets the {@link WorldChunk chunk} entity volume.
             *
             * @return The entity chunk
             */
            EntityChunk chunk();
        }

        /**
         * Called when a {@link WorldChunk chunk} is performing a entity related save.
         */
        interface Save extends Entities {

            /**
             * Called before the {@link WorldChunk chunk} entity data is saved. Cancelling this
             * will prevent any of the chunk's entity data being written to it's storage container.
             */
            interface Pre extends Entities.Save, Cancellable {

                /**
                 * Gets the {@link WorldChunk chunk} entity volume.
                 *
                 * @return The entity chunk
                 */
                EntityChunk chunk();
            }

            /**
             * Called after the {@link WorldChunk chunk} entity data is saved.
             * Guaranteed to exist in the chunk's entity storage container.
             * <p>
             * Depending on the implementation, this event may be called off-thread.
             */
            interface Post extends Entities.Save {}
        }
    }

    /**
     * Called when a {@link WorldChunk chunk} was unloaded.
     */
    interface Unload extends WorldScoped {

        /**
         * Called before the {@link WorldChunk chunk} is unloaded.
         */
        interface Pre extends Unload {

            /**
             * Gets the {@link WorldChunk chunk} being changed.
             *
             * @return The chunk
             */
            WorldChunk chunk();
        }

        /**
         * Called after the {@link WorldChunk chunk} is unloaded.
         */
        interface Post extends Unload {

        }
    }

    /**
     * Called when a new {@link WorldChunk chunk} was generated.
     */
    interface Generated extends WorldScoped {

    }

    /**
     * Called when a {@link WorldChunk chunk} is loaded. This is called
     * from the main thread when the chunk is fully loaded and ready to tick.
     */
    interface Load extends WorldScoped {

        /**
         * Gets the {@link WorldChunk chunk} being changed.
         *
         * @return The chunk
         */
        WorldChunk chunk();
    }
}

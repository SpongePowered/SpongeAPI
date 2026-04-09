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
package org.spongepowered.api.world.generation.structure.jigsaw;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.registry.RegistryHolder;

import java.io.IOException;

/**
 * A structure processor affecting blocks in a structure.
 *
 * <p>Minecraft 26.2-snapshot-1 collapsed the previous split between a
 * processor instance and a standalone "processor type" object. A processor now
 * carries its own codec, and the vanilla {@code
 * minecraft:worldgen/structure_processor} registry stores those codecs keyed
 * by {@link ResourceKey resource keys}. See {@link Processors} for the set of
 * vanilla-provided processor IDs.</p>
 */
public interface Processor {

    /**
     * Parses a {@link Processor} of the given registry ID from a serialized
     * {@link DataView configuration}.
     *
     * <p>The {@link RegistryHolder} is required because processor codecs may
     * reference holder entries from other registries (tags, block states,
     * etc.) during deserialization.</p>
     *
     * @param registries the registry holder used to resolve holder references
     * @param id the registry ID of the processor, as registered in {@code
     *     minecraft:worldgen/structure_processor} (see {@link Processors})
     * @param config the serialized processor configuration
     * @return the parsed processor
     * @throws IOException if the configuration is malformed or the ID is
     *     unknown
     */
    static Processor parse(final RegistryHolder registries, final ResourceKey id, final DataView config) throws IOException {
        return Sponge.game().factoryProvider().provide(Factory.class).parse(registries, id, config);
    }

    /**
     * Returns the registry ID of this processor.
     *
     * <p>This is the key under which this processor's codec is registered in
     * the {@code minecraft:worldgen/structure_processor} registry.</p>
     *
     * @return the processor registry ID
     */
    ResourceKey type();

    /**
     * Returns the processor configuration.
     *
     * @return the processor configuration
     */
    DataContainer toContainer();

    /**
     * Implementation-provided factory for {@link Processor}.
     */
    interface Factory {

        /**
         * @see Processor#parse(RegistryHolder, ResourceKey, DataView)
         */
        Processor parse(RegistryHolder registries, ResourceKey id, DataView config) throws IOException;
    }
}

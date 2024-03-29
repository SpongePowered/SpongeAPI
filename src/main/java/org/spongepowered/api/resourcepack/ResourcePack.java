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
package org.spongepowered.api.resourcepack;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.Sponge;

import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Optional;

/**
 * Represents a resource pack that can be sent to the client.
 */
public interface ResourcePack {

    /**
     * Creates a {@link ResourcePack} from a URI and tries to download and hash
     * it.
     *
     * @param uri The URI to look in
     * @return A ResourcePack with the specified URI
     * @throws FileNotFoundException If a valid resource pack could not be
     *         downloaded from the URI
     */
    static ResourcePack fromUri(URI uri) throws FileNotFoundException {
        return Sponge.game().factoryProvider().provide(Factory.class).fromUri(uri);
    }

    /**
     * Creates a {@link ResourcePack} from a URI, without checking ("unchecked")
     * if there is a valid pack at the URI.
     *
     * @param uri The URI to look in
     * @return A ResourcePack with the specified URI
     */
    static ResourcePack fromUriUnchecked(URI uri) {
        return Sponge.game().factoryProvider().provide(Factory.class).fromUriUnchecked(uri);
    }

    /**
     * Gets the URI associated with this resource pack.
     *
     * @return The URI associated with this resource pack.
     */
    URI uri();

    /**
     * Gets the name of this resource pack. This is the filename of the pack
     * zip file, with all non-word characters removed. Note to implementers: The
     * name <strong>MUST</strong> be calculated like above, or this API will not
     * work.
     *
     * @return The name of this resource pack. This is the filename of the pack
     *         .zip, with all non-word characters removed
     */
    String name();

    /**
     * Gets the ID of this resource pack.
     *
     * @return the ID of this resource pack
     */
    String id();

    /**
     * Gets the prompt of this resource pack.
     *
     * @return the prompt of this resource pack
     */
    Component prompt();

    /**
     * Gets the hash of this resource pack.
     *
     * @return The hash of this pack, if present
     */
    Optional<String> hash();

    interface Factory {

        ResourcePack fromUri(URI uri) throws FileNotFoundException;

        ResourcePack fromUriUnchecked(URI uri);
    }
}

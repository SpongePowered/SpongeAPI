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
package org.spongepowered.api.resourcepack;

import com.google.common.base.Optional;

import java.net.URL;

/**
 * Represents a resource pack that can be sent to the client.
 */
public interface ResourcePack {

    /**
     * Gets the URL associated with this ResourcePack.
     *
     * @return The URL associated with this ResourcePack
     */
    URL getUrl();

    /**
     * Gets the name of this resource pack. This is the filename of the pack
     * zipfile, with all non-word characters removed. Note to implementers: The
     * name <strong>MUST</strong> be calculated like above, or this API will not
     * work.
     *
     * @return The name of this resource pack. This is the filename of the pack
     *         .zip, with all non-word characters removed
     */
    String getName();

    /**
     * Gets the ID of this resource pack.
     *
     * @return the ID of this resource pack
     */
    String getId();

    /**
     * If this resource pack was initialized through
     * {@link ResourcePackFactory#fromUrl(URL)}, the hash, as calculated with
     * <code>com.google.common.hash.Hashing.sha1().hashBytes(com.google.common.io.Files.toByteArray(resourcepackfile)).toString();</code>
     *
     * @return The hash of this pack, if present
     */
    Optional<String> getHash();

}

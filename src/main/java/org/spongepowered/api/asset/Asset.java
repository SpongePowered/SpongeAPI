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
package org.spongepowered.api.asset;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.io.ByteStreams;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents an {@link Asset} within Sponge that belongs to a {@link Plugin}.
 */
public interface Asset {

    /**
     * Returns the original {@link Plugin} owner of this Asset.
     *
     * @return Original owner of asset
     */
    PluginContainer getOwner();

    /**
     * Returns the {@link URL} to this Asset.
     *
     * @return URL to asset
     */
    URL getUrl();

    /**
     * Copies this Asset to the specified 'output' {@link Path}.
     *
     * @param output Path to copy to
     * @throws IOException
     */
    default void copyToFile(Path output) throws IOException {
        checkNotNull(output, "output");
        InputStream in = getUrl().openStream();
        Files.copy(in, output);
        in.close();
    }

    /**
     * Reads this Asset in it's entirety as a {@link String} and returns the
     * result.
     *
     * @return String representation of Asset
     * @throws IOException
     */
    default String readString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getUrl().openStream()));
        StringBuilder result = new StringBuilder();
        String ln;
        while ((ln = reader.readLine()) != null) {
            result.append(ln).append('\n');
        }
        reader.close();
        return result.toString();
    }

    /**
     * Reads this Asset in it's entirety as a byte array and returns the
     * result.
     *
     * @return Byte array representation of Asset
     * @throws IOException
     */
    default byte[] readBytes() throws IOException {
        InputStream in = getUrl().openStream();
        byte[] bytes = ByteStreams.toByteArray(in);
        in.close();
        return bytes;
    }

}

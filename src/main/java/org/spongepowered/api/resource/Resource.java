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

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import com.google.common.io.MoreFiles;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.persistence.DataFormat;
import org.spongepowered.api.data.persistence.InvalidDataFormatException;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;
import javax.annotation.WillNotClose;

/**
 * A resource can represent any kind of loaded data. It can be a file on the
 * filesystem, a network location, or even generated at runtime. Use
 * {@link #getInputStream()} to load the data held by a resource.
 *
 * <p>Resource extends Closeable, so don't forget to close your streams either
 * with a try-with-resources or a close() inside a try-finally block. e.g.</p>
 * <pre>
 *     try (Resource res = resourceManager.getResource(path)) {
 *         logger.info(res.readString(DefaultCharsets.UTF_8));
 *     } catch (IOException e) {
 *         logger.warn("Failed to load resource: {}", path, e);
 *     }
 * </pre>
 */
public interface Resource extends Closeable {

    /**
     * Returns a new {@link InputStream} of this resource. A new input stream
     * should be created each time this method is called.
     *
     * @return A new input stream
     */
    InputStream getInputStream();

    /**
     * Gets the metadata for this resource.
     *
     * <p>The metadata file has the same name as this resource, but has
     * {@code .mcmeta} appended to the end.</p>
     *
     * <p>For example: the metadata for the resource
     * {@code minecraft:textures/blocks/water_flow.png} would be located at
     * {@code minecraft:textures/blocks/water_flow.png.mcmeta}</p>
     *
     * @return The metadata or {@link Optional#empty() empty} if it doesn't exist.
     * @see <a href=http://minecraft.gamepedia.com/Resource_pack#Contents> Minecraft Wiki/Resource Packs
     */
    Optional<DataView> getMetadata();

    /**
     * Gets the path of this resource.
     *
     * @return The path
     */
    ResourcePath getPath();

    /**
     * Gets the pack name which owns this resource.
     *
     * @return The parent pack.
     */
    String getPackName();

    /**
     * Gets a reader for this resource using the given {@link Charset}.
     *
     * @param charset The charset
     * @return A new reader
     */
    default BufferedReader getReader(Charset charset) {
        return new BufferedReader(new InputStreamReader(getInputStream(), charset));
    }

    /**
     * Reads this resource into a string using the given charset.
     *
     * @param charset The charset
     * @return The string contents
     * @throws IOException if an error occurs
     */
    default String readString(Charset charset) throws IOException {
        return CharStreams.toString(getReader(charset));
    }

    /**
     * Reads a list of string lines from this resource using the given charset.
     *
     * @param charset The charset
     * @return The list of strings
     */
    default Stream<String> readLines(Charset charset) {
        return getReader(charset).lines();
    }

    /**
     * Reads the bytes from this resource and returns them in an array.
     *
     * @return The bytes
     * @throws IOException if an error occurs
     */
    default byte[] readBytes() throws IOException {
        return ByteStreams.toByteArray(getInputStream());
    }

    /**
     * Reads this resource into a {@link DataView}.
     *
     * @param format The data format to use
     * @return The dataview
     * @throws IOException if an error occurs
     */
    default DataView readDataView(DataFormat format) throws IOException {
        try {
            return format.readFrom(getInputStream());
        } catch (InvalidDataFormatException e) {
            throw new IOException(e);
        }
    }

    /**
     * Copies this resource to a given {@link Path}.
     *
     * @param path The file to write to
     * @param options The options to use
     * @throws IOException if an error occurs
     */
    default void copyTo(Path path, OpenOption... options) throws IOException {
        MoreFiles.asByteSink(path, options).writeFrom(getInputStream());
    }

    /**
     * Copies this resource to a given {@link OutputStream}.
     *
     * @param out The output stream to write
     * @throws IOException if an error occurs
     */
    default void copyTo(@WillNotClose OutputStream out) throws IOException {
        ByteStreams.copy(getInputStream(), out);
    }

}

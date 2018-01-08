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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.stream.Stream;
import javax.annotation.WillNotClose;

/**
 * A resource can represent any kind of loaded data. It can be a file on the
 * filesystem, a network location, or even generated at runtime. Use
 * {@link #openStream()} to load the data held by a resource.
 */
public interface Resource extends ResourceData {

    /**
     * Gets the path of this resource.
     *
     * @return The path
     */
    ResourcePath getResourcePath();

    /**
     * Gets the {@link Pack} which owns this resource. The pack is set
     * automatically when the resource is added to a pack.
     *
     * @return The parent pack.
     */
    Pack getPack();
    
    ResourceType getType();

    /**
     * Gets a reader for this resource using the given {@link Charset}.
     *
     * @param charset The charset
     * @return A new reader
     * @throws IOException if an error occurs
     */
    default BufferedReader getReader(Charset charset) throws IOException {
        return new BufferedReader(new InputStreamReader(openStream(), charset));
    }

    /**
     * Reads this resource into a string using the given charset.
     *
     * @param charset The charset
     * @return The string contents
     * @throws IOException if an error occurs
     */
    default String readString(Charset charset) throws IOException {
        try (Reader r = getReader(charset)) {
            return CharStreams.toString(r);
        }
    }

    /**
     * Reads a list of string lines from this resource using the given charset.
     *
     * @param charset The charset
     * @return The list of strings
     * @throws IOException if an error occurs
     */
    default Stream<String> readLines(Charset charset) throws IOException {
        try (BufferedReader r = getReader(charset)) {
            return r.lines();
        }
    }

    /**
     * Reads the bytes from this resource and returns them in an array.
     *
     * @return The bytes
     * @throws IOException if an error occurs
     */
    default byte[] readBytes() throws IOException {
        try (InputStream in = openStream()) {
            return ByteStreams.toByteArray(in);
        }
    }

    /**
     * Reads this resource into a {@link DataView}.
     *
     * @param format The data format to use
     * @return The dataview
     * @throws IOException if an error occurs
     */
    default DataView readDataView(DataFormat format) throws IOException {
        try (InputStream in = openStream()) {
            return format.readFrom(in);
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
        try (InputStream in = openStream()) {
            MoreFiles.asByteSink(path, options).writeFrom(in);
        }
    }

    /**
     * Copies this resource to a given {@link OutputStream}.
     *
     * @param out The output stream to write
     * @throws IOException if an error occurs
     */
    default void copyTo(@WillNotClose OutputStream out) throws IOException {
        try (InputStream in = openStream()) {
            ByteStreams.copy(in, out);
        }
    }
}

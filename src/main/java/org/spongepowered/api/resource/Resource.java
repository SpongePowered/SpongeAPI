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

import org.spongepowered.api.data.persistence.DataFormat;
import org.spongepowered.api.data.persistence.DataFormats;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.resource.meta.MetaSection;
import org.spongepowered.api.resource.meta.NamedMetaSections;
import org.spongepowered.api.resource.pack.PackInfo;
import org.spongepowered.api.resource.pack.PackList;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A resource can represent any kind of loaded data. It can be a file on the
 * filesystem, a network location, or even generated at runtime. Use
 * {@link #getInputStream()} to load the data held by a resource.
 */
public interface Resource extends Closeable {

    /**
     * Gets the path of this resource.
     *
     * @return The path
     */
    ResourcePath getPath();

    /**
     * Gets the name of the {@link PackInfo pack} which owns this resource. To
     * get the instance, feed the returned value to
     * {@link PackList#get(String)}.
     *
     * @return The parent pack.
     * @see PackList#get(String)
     */
    String getPack();

    /**
     * Returns the {@link InputStream} of this resource. Multiple calls to this
     * method will not return a new object. To get a new object, get a new
     * resource.
     *
     * @return The input stream
     */
    InputStream getInputStream();

    /**
     * Checks whether this resource has metadata or not.
     *
     * @return True if this resource has metadata, false otherwise
     */
    boolean hasMetadata();

    /**
     * Gets the specified metadata section for this resource or
     * {@link Optional#empty()} if it has no metadata.
     *
     * @param section The section serializer
     * @return The metadata or empty if it doesn't exist
     * @see NamedMetaSections
     */
    <T> Optional<T> getMetadata(MetaSection<T> section);

    /**
     * Creates a new {@link BufferedReader} from this resource's
     * {@link InputStream}.
     *
     * @param charset The charset to use, usually utf-8
     * @return The BufferedReader
     */
    BufferedReader newBufferedReader(Charset charset);

    /**
     * Reads the resource as text.
     *
     * @param charset The charset of the text, usually utf-8
     * @return The text of the resource
     * @throws IOException If an I/O error occurs
     * @see StandardCharsets
     */
    String readString(Charset charset) throws IOException;

    /**
     * Reads all the toBytes from this resource and returns them in a byte array.
     *
     * @return The toBytes of the resource
     * @throws IOException If an I/O error occurs
     */
    byte[] readBytes() throws IOException;

    /**
     * Reads the resource and returns a {@link DataView} which corresponds to
     * the appropriate {@link DataFormat}.
     *
     * @param format The data format to use
     * @return The data view
     * @throws IOException If an I/O error occurs
     * @see DataFormats
     */
    DataView readDataView(DataFormat format) throws IOException;

    /**
     * Reads the resource as text and returns a stream of lines.
     *
     * <p>Just like {@link BufferedReader#lines()}, the stream will wrap any
     * {@link IOException} thrown in an {@link java.io.UncheckedIOException}.
     * </p>
     *
     * @param charset The charset of the text, usually utf-8
     * @return A stream of readLines of the resource
     * @see StandardCharsets
     * @see BufferedReader#lines()
     */
    Stream<String> lines(Charset charset);

}

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
package org.spongepowered.api.data.persistence;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Represents a parser for a particular file format allowing reading and writing
 * a DataContainer to/from a stream of the specific format.
 */
@CatalogedBy(DataFormats.class)
public interface DataFormat extends CatalogType {

    /**
     * Creates a new {@link DataContainer} from the contents of the given
     * {@link InputStream}.
     * 
     * @param input The input stream
     * @return A data container representing the contents of the input stream
     * @throws InvalidDataFormatException If the data in the stream was not a
     *         supported format
     * @throws IOException If there was an error reading from the stream
     */
    DataContainer readFrom(InputStream input) throws InvalidDataFormatException, IOException;

    /**
     * Writes the given {@link DataView} to the given {@link OutputStream} using
     * the format specified by this {@link DataFormat}.
     * 
     * @param output The output stream to write the data to
     * @param data The DataView to write to the stream
     * @throws IOException If there was an error writing to the stream
     */
    void writeTo(OutputStream output, DataView data) throws IOException;

}

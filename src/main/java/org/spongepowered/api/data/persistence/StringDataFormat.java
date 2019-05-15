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

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Represents a {@link DataFormat} that reads and writes data from/to a string.
 */
public interface StringDataFormat extends DataFormat {

    /**
     * Creates a new {@link DataContainer} from the contents of the given
     * {@link String}.
     *
     * @param input The string to parse
     * @return A data container representing the parsed contents of the string
     * @throws InvalidDataException If the data in the string was not a
     *         supported format
     * @throws IOException If there was an error reading from the string
     */
    DataContainer read(String input) throws InvalidDataException, IOException;

    /**
     * Creates a new {@link DataContainer} from the contents of the given
     * {@link Reader}.
     *
     * @param input The reader
     * @return A data container representing the parsed contents of the reader
     * @throws InvalidDataException If the data in the reader was not a
     *         supported format
     * @throws IOException If there was an error reading from the reader
     */
    DataContainer readFrom(Reader input) throws InvalidDataException, IOException;

    /**
     * Serializes the given {@link DataView} to a {@link String} using
     * the format specified by this {@link DataFormat}.
     *
     * @param data The DataView to write
     * @return The serialized data view
     * @throws IOException If there was an error serializing the data
     */
    String write(DataView data) throws IOException;

    /**
     * Writes the given {@link DataView} to the given {@link Writer} using
     * the format specified by this {@link DataFormat}.
     *
     * @param output The writer to write the data to
     * @param data The DataView to write to the writer
     * @throws IOException If there was an error writing to the writer
     */
    void writeTo(Writer output, DataView data) throws IOException;

}

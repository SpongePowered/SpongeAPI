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
package org.spongepowered.api.net;

import org.spongepowered.api.service.persistence.data.DataView;

import java.nio.ByteOrder;
import java.util.UUID;

/**
 * A ChannelStream allows for plugins and the server to read and write Java primitive
 * data and some higher level data to {@link DataView} if necessary.
 */
public interface ChannelBuf {

    /**
     * Gets the number of bytes this buffer can contain.
     *
     * @return The number of bytes this buffer can contain
     */
    int getCapacity();

    /**
     * Gets the number of bytes available between the reader and the writer.
     *
     * @return The number of available bytes
     */
    int available();

    /**
     * Returns a buffer with the specified endianness which shares the whole
     * region, indexes, and marks of this buffer. Modifying the content, the
     * indexes, or the marks of the returned buffer or this buffer affects
     * each other's content, indexes, and marks.
     * <p>If the specified endianness is identical to this buffer's byte
     * order, this method can return this.</p>
     * <p>This method does not modify readerIndex or writerIndex of this
     * buffer.</p>
     *
     *
     * @param order The order
     * @return The ChannelStream with the desired byte order
     */
    ChannelBuf order(ByteOrder order);

    /**
     * Returns the endianness ({@link ByteOrder}) of this buffer.
     *
     * @return The current byte order of this buffer
     */
    ByteOrder getByteOrder();

    /**
     * Gets the readerIndex of this buffer.
     *
     * @return The current read index
     */
    int readerIndex();

    /**
     * Sets the readerIndex of this buffer.
     *
     * @param index The new index
     * @return This stream for chaining
     */
    ChannelBuf setReadIndex(int index);

    /**
     * Gets the writerIndex of this buffer.
     *
     * @return The current write index
     */
    int writerIndex();

    /**
     * Sets the writerIndex of this buffer.
     *
     * @param index The new index
     * @return This stream for chaining
     */
    ChannelBuf setWriteIndex(int index);

    /**
     * Sets both the reader and writer indices.
     *
     * @param readIndex The reader index
     * @param writeIndex The writer index
     * @return This stream for chaining
     */
    ChannelBuf setIndex(int readIndex, int writeIndex);

    /**
     * Sets the readerIndex and writerIndex of this buffer to 0.
     * This method is identical to {@link #setIndex(int, int)}.
     *
     * @return This stream for chaining
     */
    ChannelBuf clear();

    /**
     * Marks the current readerIndex in this buffer. You can reposition
     * the current readerIndex to the marked readerIndex by calling
     * resetRead(). The initial value of the marked readerIndex is 0.
     *
     * @return This stream for chaining
     */
    ChannelBuf markRead();

    /**
     * Marks the current writerIndex in this buffer. You can reposition
     * the current writerIndex to the marked writerIndex by calling
     * resetWrite(). The initial value of the marked writerIndex is 0.
     *
     * @return This stream for chaining
     */
    ChannelBuf markWrite();

    /**
     * Resets the current readerIndex in this buffer to the marked reader
     * index.
     *
     * @return This stream for chaining
     */
    ChannelBuf resetRead();

    /**
     * Resets the current writerIndex in this buffer to the marked writer
     * index.
     *
     * @return This stream for chaining
     */
    ChannelBuf resetWrite();

    /**
     * Returns a slice of this buffer's readable bytes. Modifying the content
     * of the returned buffer or this buffer affects each other's content
     * while they maintain separate indexes and marks. This method is
     * identical to buf.slice(buf.readerIndex(), buf.readableBytes()).
     * This method does not modify readerIndex or writerIndex of this buffer.
     *
     * @return The sliced stream
     */
    ChannelBuf slice();

    /**
     * Returns a slice of this buffer's sub-region. Modifying the content of
     * the returned buffer or this buffer affects each other's content while
     * they maintain separate indexes and marks. This method does not modify
     * readerIndex or writerIndex of this buffer.
     *
     * @param index The starter index
     * @param length The ending index
     * @return The sliced stream
     */
    ChannelBuf slice(int index, int length);

    /**
     * Gets the backing byte array of this stream.
     *
     * @return A copy of the backing byte array
     */
    byte[] array();

    /**
     * Sets the specified boolean at the current writerIndex and increases
     * the writerIndex by 1 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeBoolean(boolean data);

    /**
     * Sets the boolean at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setBoolean(int index, boolean data);

    /**
     * Gets a boolean at the current readerIndex and increases the
     * readerIndex by 1 in this buffer.
     *
     * @return The boolean
     */
    boolean readBoolean();

    /**
     * Gets a boolean at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The boolean
     */
    boolean getBoolean(int index);


    /**
     * Sets the specified byte at the current writerIndex and increases
     * the writerIndex by 1 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeByte(byte data);

    /**
     * Sets the byte at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setByte(int index, byte data);

    /**
     * Gets a byte at the current readerIndex and increases the
     * readerIndex by 1 in this buffer.
     *
     * @return The byte
     */
    byte readByte();

    /**
     * Gets a byte at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The byte
     */
    byte getByte(int index);

    /**
     * Sets the specified short integer at the current writerIndex and
     * increases the writerIndex by 2 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeShort(short data);

    /**
     * Sets the short at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setShort(int index, short data);

    /**
     * Gets a short integer at the current readerIndex and increases the
     * readerIndex by 2 in this buffer.
     *
     * @return The short integer
     */
    short readShort();

    /**
     * Gets a short integer at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The short integer
     */
    short getShort(int index);

    /**
     * Sets the specified character at the current writerIndex and
     * increases the writerIndex by 2 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeChar(char data);

    /**
     * Sets the char at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setChar(int index, char data);

    /**
     * Gets a character at the current readerIndex and increases the
     * readerIndex by 2 in this buffer.
     *
     * @return The character
     */
    char readChar();

    /**
     * Gets a character at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The character
     */
    char getChar(int index);

    /**
     * Sets the specified integer at the current writerIndex and increases
     * the writerIndex by 4 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeInteger(int data);

    /**
     * Sets the integer at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setInteger(int index, int data);

    /**
     * Gets an integer at the current readerIndex and increases the
     * readerIndex by 4 in this buffer.
     *
     * @return The integer
     */
    int readInteger();

    /**
     * Gets an integer at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The integer
     */
    int getInteger(int index);

    /**
     * Sets the specified long integer at the current writerIndex and
     * increases the writerIndex by 8 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeLong(long data);

    /**
     * Sets the long integer at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setLong(int index, long data);

    /**
     * Gets a long integer at the current readerIndex and increases the
     * readerIndex by 8 in this buffer.
     *
     * @return The long integer
     */
    long readLong();

    /**
     * Gets a long integer at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The long integer
     */
    long getLong(int index);

    /**
     * Sets the specified float at the current writerIndex and increases
     * the writerIndex by 4 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeFloat(float data);

    /**
     * Sets the float at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setFloat(int index, float data);

    /**
     * Gets a float at the current readerIndex and increases the
     * readerIndex by 4 in this buffer.
     *
     * @return The float
     */
    float readFloat();

    /**
     * Gets a float at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The string
     */
    float getFloat(int index);

    /**
     * Sets the specified double at the current writerIndex and increases
     * the writerIndex by 8 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeDouble(double data);

    /**
     * Sets the double at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setDouble(int index, double data);

    /**
     * Gets a double at the current readerIndex and increases the
     * readerIndex by 8 in this buffer.
     *
     * @return The double
     */
    double readDouble();

    /**
     * Gets a double at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The double
     */
    double getDouble(int index);

    /**
     * Sets the specified string at the current writerIndex and increases
     * the writerIndex by the length of the string.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeString(String data);

    /**
     * Sets the string at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setString(int index, String data);

    /**
     * Gets a string at the current readerIndex and increases the
     * readerIndex by 1 in this buffer.
     *
     * @return The string
     */
    String readString();

    /**
     * Gets a string at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The string
     */
    String getString(int index);

    /**
     * Sets the specified {@link UUID} at the current writerIndex and
     * increases the writerIndex by 16 in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeUuid(UUID data);

    /**
     * Sets the {@link UUID} at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setUuid(int index, UUID data);

    /**
     * Gets a UUID at the current readerIndex and increases the
     * readerIndex by 16 in this buffer.
     *
     * @return This stream for chaining
     */
    UUID readUuid();

    /**
     * Gets a {@link UUID} at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The uuid
     */
    UUID getUuid(int index);

    /**
     * Sets the specified {@link DataView} at the current writerIndex and
     * increases the writerIndex according to the lenght of the data view
     * in this buffer.
     *
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf writeDataView(DataView data);

    /**
     * Sets the {@link DataView} at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The boolean data
     * @return This stream for chaining
     */
    ChannelBuf setDataView(int index, DataView data);

    /**
     * Gets a {@link DataView} at the current readerIndex and increases the
     * readerIndex according to the length of the data view in this buffer.
     *
     * @return The data view
     */
    DataView readDataView();

    /**
     * Gets a {@link DataView} at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The data view
     */
    DataView getDataView(int index);

}

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
package org.spongepowered.api.network.channel;

import org.spongepowered.api.data.persistence.DataView;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * A ChannelStream allows for plugins and the server to read and write Java
 * primitive data and some higher level data to {@link DataView} if necessary.
 */
public interface ChannelBuf {

    /**
     * Gets the number of bytes this buffer can contain.
     *
     * @return The number of bytes this buffer can contain
     */
    int capacity();

    /**
     * Makes sure the number of the writable bytes is equal to
     * or greater than the specified value.
     *
     * @param minWritableBytes The minimum writable bytes
     * @return This stream for chaining
     */
    ChannelBuf ensureWritable(int minWritableBytes);

    /**
     * Gets the number of bytes available between the reader and the writer.
     *
     * @return The number of available bytes
     */
    int available();

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
    ChannelBuf readerIndex(int index);

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
    ChannelBuf writerIndex(int index);

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
     * Returns a slice of this buffer's sub-region at the current readerIndex. The
     * readerIndex is increased by the given length.
     *
     * <p>Modifying the content of the returned buffer or this buffer affects each
     * other's content while they maintain separate indexes and marks.</p>
     *
     * @param length The amount of bytes in the slice
     * @return The sliced stream
     */
    ChannelBuf readSlice(int length);

    /**
     * Returns {@code true} if and only if this buffer has a backing byte array.
     *
     * <p>If this method returns true, you can safely call {@link #array()}.</p>
     *
     * @return {@code true} if this buffer has a backing byte array
     */
    boolean hasArray();

    /**
     * Gets the backing byte array of this stream.
     *
     * @return A copy of the backing byte array
     * @throws UnsupportedOperationException if there is no backing byte array
     */
    byte[] array() throws UnsupportedOperationException;

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
     * @param data The byte data
     * @return This stream for chaining
     */
    ChannelBuf writeByte(byte data);

    /**
     * Sets the byte at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The byte data
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
     * Sets the specified byte array at the current writerIndex and increases
     * the writerIndex by the number of bytes and the size of the length as a
     * varint.
     *
     * <p>The length of the array is written preceding the data as a varint.</p>
     *
     * @param data The byte array data
     * @return This stream for chaining
     */
    ChannelBuf writeByteArray(byte[] data);

    /**
     * Sets the specified byte array at the current writerIndex and increases
     * the writerIndex by the length specified and the size of the length as a
     * varint.
     *
     * <p>The length of the array is written preceding the data as a varint.</p>
     *
     * @param data The byte array data
     * @param start The starting index of the source array to start reading from
     * @param length The length of bytes to read from the source array
     * @return This stream for chaining
     */
    ChannelBuf writeByteArray(byte[] data, int start, int length);

    /**
     * Sets the specified byte array at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * <p>The length of the array is written preceding the data as a varint.</p>
     *
     * @param index The index
     * @param data The byte array data
     * @return This stream for chaining
     */
    ChannelBuf setByteArray(int index, byte[] data);

    /**
     * Sets the specified byte array at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * <p>The length of the array is written preceding the data as a varint.</p>
     *
     * @param index The index
     * @param data The byte array data
     * @param start The starting index of the source array to start reading from
     * @param length The length of bytes to read from the source array
     * @return This stream for chaining
     */
    ChannelBuf setByteArray(int index, byte[] data, int start, int length);

    /**
     * Gets a byte array at the current readerIndex and increases the
     * readerIndex by the length of the array and the length of the array size.
     *
     * <p>The length of the array is expected to be preceding the array as a
     * varint.</p>
     *
     * @return The byte array
     */
    byte[] readByteArray();

    /**
     * Gets a byte array at the current readerIndex and increases the
     * readerIndex by the length of the array and the length of the array size.
     *
     * <p>The length of the array is expected to be preceding the array as a
     * varint.</p>
     *
     * @param limit The limit of the length of the array
     * @return The byte array
     */
    byte[] readByteArray(int limit);

    /**
     * Gets a byte array at the specified absolute index in this buffer.
     *
     * <p>The length of the array is expected to be preceding the array as a
     * varint.</p>
     *
     * @param index The index to read the byte array at
     * @return The byte array
     */
    byte[] getByteArray(int index);

    /**
     * Gets a byte array at the specified absolute index in this buffer.
     *
     * <p>The length of the array is expected to be preceding the array as a
     * varint.</p>
     *
     * @param index The index to read the byte array at
     * @param limit The limit of the length of the array
     * @return The byte array
     */
    byte[] getByteArray(int index, int limit);

    /**
     * Sets the specified byte array at the current writerIndex and increases
     * the writerIndex by the number of bytes.
     *
     * @param data The byte array data
     * @return This stream for chaining
     */
    ChannelBuf writeBytes(byte[] data);

    /**
     * Sets the specified byte array at the current writerIndex and increases
     * the writerIndex by the length specified.
     *
     * @param data The byte array data
     * @param start The starting index of the source array to start reading from
     * @param length The length of bytes to read from the source array
     * @return This stream for chaining
     */
    ChannelBuf writeBytes(byte[] data, int start, int length);

    /**
     * Sets the specified byte array at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The byte array data
     * @return This stream for chaining
     */
    ChannelBuf setBytes(int index, byte[] data);

    /**
     * Sets the specified byte array at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The byte array data
     * @param start The starting index of the source array to start reading from
     * @param length The length of bytes to read from the source array
     * @return This stream for chaining
     */
    ChannelBuf setBytes(int index, byte[] data, int start, int length);

    /**
     * Gets a byte array at the current readerIndex and increases the
     * readerIndex by the length of the array.
     *
     * @param length The length of the byte array to read from
     * @return The byte array
     */
    byte[] readBytes(int length);

    /**
     * Gets a byte array at the specified absolute index in this buffer.
     *
     * @param index The index of this channel buff to read from
     * @param length The length of the byte array
     * @return The byte array
     */
    byte[] readBytes(int index, int length);

    /**
     * Sets the specified short integer at the current writerIndex of this
     * buffer and increases the writerIndex by 2.
     *
     * @param data The short data
     * @return This stream for chaining
     */
    ChannelBuf writeShort(short data);

    /**
     * Sets the specified short integer at the current writerIndex in
     * little endian byte order and increases the writerIndex by 2 in
     * this buffer.
     *
     * @param data The short data
     * @return This stream for chaining
     */
    ChannelBuf writeShortLE(short data);

    /**
     * Sets the short at the specified absolute index of this
     * buffer. This method does not modify readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The short data
     * @return This stream for chaining
     */
    ChannelBuf setShort(int index, short data);

    /**
     * Sets the short at the specified absolute index of this
     * buffer in little endian byte order. This method does
     * not modify readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The short data
     * @return This stream for chaining
     */
    ChannelBuf setShortLE(int index, short data);

    /**
     * Gets a short integer at the current readerIndex from this buffer
     * and increases the readerIndex by 2.
     *
     * @return The short integer
     */
    short readShort();

    /**
     * Gets a short integer at the current readerIndex from this buffer
     * in little endian byte order and increases the readerIndex by 2.
     *
     * @return The short integer
     */
    short readShortLE();

    /**
     * Gets a short integer at the specified absolute index from this buffer.
     *
     * @param index The index
     * @return The short integer
     */
    short getShort(int index);

    /**
     * Gets a short integer at the specified absolute index from this buffer
     * in little endian byte order.
     *
     * @param index The index
     * @return The short integer
     */
    short getShortLE(int index);

    /**
     * Sets the specified character at the current writerIndex of this
     * buffer and increases the writerIndex by 2.
     *
     * @param data The char data
     * @return This stream for chaining
     */
    ChannelBuf writeChar(char data);

    /**
     * Sets the char at the specified absolute index of this
     * buffer. This method does not modify readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The char data
     * @return This stream for chaining
     */
    ChannelBuf setChar(int index, char data);

    /**
     * Gets a character at the current readerIndex from this buffer and
     * increases the readerIndex by 2.
     *
     * @return The character
     */
    char readChar();

    /**
     * Gets a character at the specified absolute index from this buffer.
     *
     * @param index The index
     * @return The character
     */
    char getChar(int index);

    /**
     * Sets the specified integer at the current writerIndex of this
     * buffer and increases the writerIndex by 4.
     *
     * @param data The integer data
     * @return This stream for chaining
     */
    ChannelBuf writeInt(int data);

    /**
     * Sets the specified integer at the current writerIndex of this
     * buffer in little endian byte order and increases the writerIndex by 4.
     *
     * @param data The integer data
     * @return This stream for chaining
     */
    ChannelBuf writeIntLE(int data);

    /**
     * Sets the integer at the specified absolute index of this
     * buffer. This method does not modify readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The integer data
     * @return This stream for chaining
     */
    ChannelBuf setInt(int index, int data);

    /**
     * Sets the integer at the specified absolute index of this
     * buffer in little endian byte order. This method does not
     * modify readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The integer data
     * @return This stream for chaining
     */
    ChannelBuf setIntLE(int index, int data);

    /**
     * Gets an integer at the current readerIndex from this buffer
     * and increases the readerIndex by 4.
     *
     * @return The integer
     */
    int readInt();

    /**
     * Gets an integer at the current readerIndex in little endian byte order
     * from this buffer and increases the readerIndex by 4.
     *
     * @return The integer
     */
    int readIntLE();

    /**
     * Gets an integer at the specified absolute index from this buffer.
     *
     * @param index The index
     * @return The integer
     */
    int getInt(int index);

    /**
     * Gets an integer at the specified absolute index from this buffer
     * in little endian byte order.
     *
     * @param index The index
     * @return The integer
     */
    int getIntLE(int index);

    /**
     * Sets the specified long integer at the current writerIndex of
     * this buffer and increases the writerIndex by 8.
     *
     * @param data The long data
     * @return This stream for chaining
     */
    ChannelBuf writeLong(long data);

    /**
     * Sets the specified long integer at the current writerIndex of
     * this buffer in little endian byte order and increases the
     * writerIndex by 8.
     *
     * @param data The long data
     * @return This stream for chaining
     */
    ChannelBuf writeLongLE(long data);

    /**
     * Sets the long integer at the specified absolute index of this
     * buffer. This method does not modify readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The long data
     * @return This stream for chaining
     */
    ChannelBuf setLong(int index, long data);

    /**
     * Sets the long integer at the specified absolute index of this
     * buffer in little endian byte order. This method does not modify
     * readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The long data
     * @return This stream for chaining
     */
    ChannelBuf setLongLE(int index, long data);

    /**
     * Gets a long integer at the current readerIndex from this buffer
     * and increases the readerIndex by 8.
     *
     * @return The long integer
     */
    long readLong();

    /**
     * Gets a long integer at the current readerIndex from this buffer
     * in little endian byte order and increases the readerIndex by 8.
     *
     * @return The long integer
     */
    long readLongLE();

    /**
     * Gets a long integer at the specified absolute index from this
     * buffer. This method does not modify readerIndex.
     *
     * @param index The index
     * @return The long integer
     */
    long getLong(int index);

    /**
     * Gets a long integer at the specified absolute index from this
     * buffer in little endian byte order. This method does not modify
     * readerIndex.
     *
     * @param index The index
     * @return The long integer
     */
    long getLongLE(int index);

    /**
     * Sets the specified float at the current writerIndex of this buffer
     * and increases the writerIndex by 4.
     *
     * @param data The float data
     * @return This stream for chaining
     */
    ChannelBuf writeFloat(float data);

    /**
     * Sets the specified float at the current writerIndex of this buffer
     * in little endian byte order and increases the writerIndex by 4.
     *
     * @param data The float data
     * @return This stream for chaining
     */
    ChannelBuf writeFloatLE(float data);

    /**
     * Sets the float at the specified absolute index of this
     * buffer. This method does not modify readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The float data
     * @return This stream for chaining
     */
    ChannelBuf setFloat(int index, float data);

    /**
     * Sets the float at the specified absolute index of this
     * buffer in little endian byte order. This method does not modify
     * readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The float data
     * @return This stream for chaining
     */
    ChannelBuf setFloatLE(int index, float data);

    /**
     * Gets a float at the current readerIndex of this buffer and
     * increases the readerIndex by 4.
     *
     * @return The float
     */
    float readFloat();

    /**
     * Gets a float at the current readerIndex of this buffer in
     * little endian byte order and increases the readerIndex by 4.
     *
     * @return The float
     */
    float readFloatLE();

    /**
     * Gets a float at the specified absolute index from this buffer.
     * This method does not modify readerIndex.
     *
     * @param index The index
     * @return The string
     */
    float getFloat(int index);

    /**
     * Gets a float at the specified absolute index from this buffer in
     * little endian byte order. This method does not modify readerIndex.
     *
     * @param index The index
     * @return The string
     */
    float getFloatLE(int index);

    /**
     * Sets the specified double at the current writerIndex of this buffer
     * and increases the writerIndex by 8.
     *
     * @param data The double data
     * @return This stream for chaining
     */
    ChannelBuf writeDouble(double data);

    /**
     * Sets the specified double at the current writerIndex of this buffer
     * in little endian byte order and increases the writerIndex by 8.
     *
     * @param data The double data
     * @return This stream for chaining
     */
    ChannelBuf writeDoubleLE(double data);

    /**
     * Sets the double at the specified absolute index of this
     * buffer. This method does not modify readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The double data
     * @return This stream for chaining
     */
    ChannelBuf setDouble(int index, double data);

    /**
     * Sets the double at the specified absolute index of this
     * buffer in little endian byte order. This method does not modify
     * readerIndex or writerIndex.
     *
     * @param index The index
     * @param data The double data
     * @return This stream for chaining
     */
    ChannelBuf setDoubleLE(int index, double data);

    /**
     * Gets a double at the current readerIndex and increases the
     * readerIndex by 8 in this buffer.
     *
     * @return The double
     */
    double readDouble();

    /**
     * Gets a double at the current readerIndex from this buffer
     * in little endian byte order and increases the readerIndex by 8.
     *
     * @return The double
     */
    double readDoubleLE();

    /**
     * Gets a double at the specified absolute index in this buffer.
     * This method does not modify readerIndex.
     *
     * @param index The index
     * @return The double
     */
    double getDouble(int index);

    /**
     * Gets a double at the specified absolute index from this buffer
     * in little endian byte order. This method does not modify readerIndex.
     *
     * @param index The index
     * @return The double
     */
    double getDoubleLE(int index);

    /**
     * Sets the specified varint at the current writerIndex and increases the
     * writerIndex by the number of bytes written.
     * 
     * <p>The number of bytes written depends on the size of the value, see <a
     * href=
     * "https://developers.google.com/protocol-buffers/docs/encoding#varints">
     * https://developers.google.com/protocol-buffers/docs/encoding#varints</a>
     * for a full description.</p>
     *
     * @param data The varint data
     * @return This stream for chaining
     */
    ChannelBuf writeVarInt(int data);

    /**
     * Sets the specified varint at the specified absolute index in this buffer.
     * This method does not modify readerIndex or writerIndex of this buffer.
     * 
     * <p>The number of bytes written depends on the size of the value, see <a
     * href=
     * "https://developers.google.com/protocol-buffers/docs/encoding#varints">
     * https://developers.google.com/protocol-buffers/docs/encoding#varints</a>
     * for a full description.</p>
     *
     * @param index The index
     * @param data The varint data
     * @return This stream for chaining
     */
    ChannelBuf setVarInt(int index, int data);

    /**
     * Gets a varint at the current readerIndex and increases the readerIndex by
     * the number of bytes read.
     * 
     * <p>The number of bytes read depends on the size of the value, see <a
     * href=
     * "https://developers.google.com/protocol-buffers/docs/encoding#varints">
     * https://developers.google.com/protocol-buffers/docs/encoding#varints</a>
     * for a full description.</p>
     *
     * @return The varint
     */
    int readVarInt();

    /**
     * Gets a varint at the specified absolute index in this buffer.
     * 
     * <p>The number of bytes read depends on the size of the value, see <a
     * href=
     * "https://developers.google.com/protocol-buffers/docs/encoding#varints">
     * https://developers.google.com/protocol-buffers/docs/encoding#varints</a>
     * for a full description.</p>
     *
     * @param index The index
     * @return The double
     */
    int getVarInt(int index);

    /**
     * Sets the specified varlong at the current writerIndex and increases the
     * writerIndex by the number of bytes written.
     *
     * <p>The number of bytes written depends on the size of the value.</p>
     *
     * @param value The varlong value
     * @return This stream for chaining
     */
    ChannelBuf writeVarLong(long value);

    /**
     * Sets the specified varlong at the specified absolute index in this buffer.
     * This method does not modify readerIndex or writerIndex of this buffer.
     *
     * <p>The number of bytes written depends on the size of the value.</p>
     *
     * @param index The index
     * @param value The varlong value
     * @return This stream for chaining
     */
    ChannelBuf setVarLong(int index, long value);

    /**
     * Gets a varlong at the current readerIndex and increases the readerIndex by
     * the number of bytes read.
     *
     * <p>The number of bytes read depends on the size of the value.</p>
     *
     * @return The varlong value
     */
    long readVarLong();

    /**
     * Gets a varlong at the specified absolute index in this buffer.
     *
     * <p>The number of bytes read depends on the size of the value.</p>
     *
     * @param index The index
     * @return The varlong value
     */
    long getVarLong(int index);

    /**
     * Sets the specified string at the current writerIndex and increases the
     * writerIndex by the length of the string.
     * 
     * <p>The string will be encoded as the utf length as a varint followed by
     * the UTF-8 bytes of the string.</p>
     *
     * @param data The string data
     * @return This stream for chaining
     */
    ChannelBuf writeString(String data);

    /**
     * Sets the string at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     * 
     * <p>The string will be encoded as the utf length as a varint followed by
     * the UTF-8 bytes of the string.</p>
     *
     * @param index The index
     * @param data The string data
     * @return This stream for chaining
     */
    ChannelBuf setString(int index, String data);

    /**
     * Gets a string at the current readerIndex and increases the readerIndex by
     * the length of a varint followed by the utf-8 bytes of the string.
     * 
     * <p>The string will be encoded as the utf length as a varint followed by
     * the UTF-8 bytes of the string.</p>
     *
     * @return The string
     */
    String readString();

    /**
     * Gets a string at the specified absolute index in this buffer.
     * 
     * <p>The string will be encoded as the utf length as a varint followed by
     * the UTF-8 bytes of the string.</p>
     *
     * @param index The index
     * @return The string
     */
    String getString(int index);

    /**
     * Sets the specified string at the current writerIndex and increases the
     * writerIndex by the length of the string.
     * 
     * <p>The string will be encoded as the utf length as a short followed by
     * the UTF-8 bytes of the string.</p>
     *
     * @param data The string data
     * @return This stream for chaining
     */
    ChannelBuf writeUTF(String data);

    /**
     * Sets the string at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     * 
     * <p>The string will be encoded as the utf length as a short followed by
     * the UTF-8 bytes of the string.</p>
     *
     * @param index The index
     * @param data The string data
     * @return This stream for chaining
     */
    ChannelBuf setUTF(int index, String data);

    /**
     * Gets a string at the current readerIndex and increases the readerIndex by
     * the length of a varint followed by the utf-8 bytes of the string.
     * 
     * <p>The string will be encoded as the utf length as a short followed by
     * the UTF-8 bytes of the string.</p>
     *
     * @return The string
     */
    String readUTF();

    /**
     * Gets a string at the specified absolute index in this buffer.
     * 
     * <p>The string will be encoded as the utf length as a short followed by
     * the UTF-8 bytes of the string.</p>
     *
     * @param index The index
     * @return The string
     */
    String getUTF(int index);

    /**
     * Sets the specified {@link UUID} at the current writerIndex and
     * increases the writerIndex by 16 in this buffer.
     *
     * @param data The unique id data
     * @return This stream for chaining
     */
    ChannelBuf writeUniqueId(UUID data);

    /**
     * Sets the {@link UUID} at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The unique id data
     * @return This stream for chaining
     */
    ChannelBuf setUniqueId(int index, UUID data);

    /**
     * Gets a UUID at the current readerIndex and increases the
     * readerIndex by 16 in this buffer.
     *
     * @return This stream for chaining
     */
    UUID readUniqueId();

    /**
     * Gets a {@link UUID} at the specified absolute index in this buffer.
     *
     * @param index The index
     * @return The uuid
     */
    UUID getUniqueId(int index);

    /**
     * Sets the specified {@link DataView} at the current writerIndex and
     * increases the writerIndex according to the length of the data view
     * in this buffer.
     *
     * @param data The data view data
     * @return This stream for chaining
     */
    ChannelBuf writeDataView(DataView data);

    /**
     * Sets the {@link DataView} at the specified absolute index in this
     * buffer. This method does not modify readerIndex or writerIndex
     * of this buffer.
     *
     * @param index The index
     * @param data The data view data
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

    /**
     * Gets this {@link ChannelBuf} as a {@link OutputStream}.
     *
     * @return The output stream
     */
    OutputStream asOutputStream();

    /**
     * Gets this {@link ChannelBuf} as a {@link InputStream}.
     *
     * @return The input stream
     */
    InputStream asInputStream();
}

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
package org.spongepowered.api.util.nbt;

/**
 * Base for every NBT tag.
 */
public interface Tag extends Cloneable {
    
    /**
     * Gets the {@link TagType} of {@link Tag}.
     * 
     * @return The {@link TagType} of {@link Tag}
     */
    TagType getType();

    public static interface Primitive extends Tag {
        
        /**
         * Returns the value of {@link Tag} as byte.
         * 
         * @return The value of {@link Tag} as byte
         */
        byte asByte();

        /**
         * Returns the value of {@link Tag} as short.
         * 
         * @return The value of {@link Tag} as short
         */
        short asShort();

        /**
         * Returns the value of {@link Tag} as int.
         * 
         * @return The value of {@link Tag} as int
         */
        int asInteger();

        /**
         * Returns the value of {@link Tag} as long.
         * 
         * @return The value of {@link Tag} as long
         */
        long asLong();

        /**
         * Returns the value of {@link Tag} as float.
         * 
         * @return The value of {@link Tag} as float
         */
        float asFloat();

        /**
         * Returns the value of {@link Tag} as double.
         * 
         * @return The value of {@link Tag} as double
         */
        double asDouble();
    }
}

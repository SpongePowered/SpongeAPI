/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.plugin.config;

/**
 * A Config Element provides a name, type, and value.<br/>
 * Should be implemented as Abstract.
 */
public interface ConfigElement<T> {
    
    /**
     * Gets the name of this element.
     * 
     * @return The name
     */
    String getName();
    
    /**
     * Gets the comment of this element.
     * 
     * @return The comment
     */
    String getComment();
    
    /**
     * Sets the comment of this element.
     * 
     * @param comment The comment
     */
    void setComment(String comment);
    
    /**
     * Deletes this element from the config.
     */
    void delete();
    
    /**
     * Gets the type value that is stored in this element
     * 
     * @return The value type
     */
    ConfigElementType getType(); // abstract
    
    /**
     * Gets this element as a {@link ConfigArray}.
     * 
     * @return
     */
    ConfigArray<T> getAsArray();
    
    /**
     * Gets this element as a {@link ConfigObject}.
     * 
     * @return
     */
    ConfigObject getAsObject();
    
    /**
     * Gets this element as a {@link ConfigPrimitive}.
     * 
     * @return
     */
    ConfigPrimitive<T> getAsPrimitive();

    /**
     * Gets this element as a {@link ConfigNull}
     */
    ConfigNull getAsNull();
    
}

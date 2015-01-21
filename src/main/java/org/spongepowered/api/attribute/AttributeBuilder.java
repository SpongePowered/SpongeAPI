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

package org.spongepowered.api.attribute;

import com.google.common.base.Predicate;
import org.spongepowered.api.text.Text;

/**
 * A builder for plugins to create custom {@link Attribute}s.
 */
public interface AttributeBuilder {

    /**
     * Sets the id of the {@link Attribute} to be built.
     * 
     * @param id The id to use
     * @return This builder, for chaining
     */
    AttributeBuilder id(String id);

    /**
     * Sets the minimum value of the {@link Attribute} to be built.
     * 
     * @param minimum The value to use
     * @return This builder, for chaining
     */
    AttributeBuilder minimum(double minimum);

    /**
     * Sets the maximum value of the {@link Attribute} to be built.
     * 
     * @param maximum The value to use
     * @return This builder, for chaining
     */
    AttributeBuilder maximum(double maximum);

    /**
     * Sets the default value of the {@link Attribute} to be built.
     * 
     * @param defaultValue The value to use
     * @return This builder, for chaining
     */
    AttributeBuilder defaultValue(double defaultValue);

    /**
     * Sets the targets of the {@link Attribute} to be built.
     * 
     * @param targets A predicate to validate targets
     * @return This builder, for chaining
     */
    AttributeBuilder targets(Predicate<AttributeHolder> targets);
    
    /**
     * Sets the name of the {@link Attribute} to be built.
     * 
     * @param name The name to use
     * @return This builder, for chaining
     */
    AttributeBuilder name(Text name);
    
    /**
     * Builds the {@link Attribute} with the set parameters.
     *
     * @return The Attribute with the set parameters
     */
    Attribute build();

    /**
     * Resets this builder, to be used again.
     * 
     * @return This builder, for chaining
     */
    AttributeBuilder reset();

}

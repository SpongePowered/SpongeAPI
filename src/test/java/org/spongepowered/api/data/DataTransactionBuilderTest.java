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
package org.spongepowered.api.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.spongepowered.api.data.DataTransactionResult.Type;

public class DataTransactionBuilderTest {

    @Test
    public void testCorrectTypeWhenAbsorbingResult() {
        assertEquals(Type.UNDEFINED, absorbedType(Type.UNDEFINED, Type.UNDEFINED));
        assertEquals(Type.SUCCESS, absorbedType(Type.SUCCESS, Type.UNDEFINED));
        assertEquals(Type.FAILURE, absorbedType(Type.FAILURE, Type.SUCCESS));
        assertEquals(Type.ERROR, absorbedType(Type.FAILURE, Type.ERROR));
        assertEquals(Type.CANCELLED, absorbedType(Type.FAILURE, Type.CANCELLED));
    }
    
    private Type absorbedType(Type builderType, Type resultType) {
        DataTransactionResult result = DataTransactionResult.builder().result(resultType).build();
        DataTransactionResult absorbed = DataTransactionResult.builder().result(builderType).absorbResult(result).build();
        return absorbed.getType();
    }

}

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
package org.spongepowered.api.util;


import static org.junit.Assert.assertTrue;

import com.google.common.base.Optional;
import org.junit.Test;


public class CoerceTest {

    @Test
    public void testAsCharacter() {
        String character = "myChar";
        Optional<Character> optional = Coerce.asChar(character);
        assertTrue(optional.isPresent());
        assertTrue(optional.get() == 'm');

        char myChar = 'm';
        Optional<Character> optional1 = Coerce.asChar(myChar);
        assertTrue(optional1.isPresent());
        assertTrue(optional1.get() == 'm');

        int myInt = 1;
        Optional<Character> optional2 = Coerce.asChar(myInt);
        assertTrue(optional2.isPresent());
        assertTrue(optional2.get() == '1');

        Optional<Character> nullOptional = Coerce.asChar(null);
        assertTrue(!nullOptional.isPresent());
    }

    @Test
    public void testAsBoolean() throws Exception {
        Object myBool = Boolean.TRUE;
        Optional<Boolean> optional = Coerce.asBoolean(myBool);
        assertTrue(optional.isPresent());
        assertTrue(optional.get());

        Optional<Boolean> nullBoolean = Coerce.asBoolean(null);
        assertTrue(!nullBoolean.isPresent());

        Optional<Boolean> invalidBoolean = Coerce.asBoolean("foo");
        assertTrue(!nullBoolean.isPresent());
    }

    @Test
    public void testAsByte() {
        String character = "1";
        Optional<Byte> optional = Coerce.asByte(character);
        assertTrue(optional.isPresent());
        assertTrue(optional.get() == 1);

        char myChar = '1';
        Optional<Byte> optional1 = Coerce.asByte(myChar);
        assertTrue(optional1.isPresent());
        assertTrue(optional1.get() == 1);

        String invalidString = "foo";
        Optional<Byte> invalidOptional = Coerce.asByte(invalidString);
        assertTrue(!invalidOptional.isPresent());

        int myInt = 1;
        Optional<Byte> optional2 = Coerce.asByte(myInt);
        assertTrue(optional2.isPresent());
        assertTrue(optional2.get() == 1);



        Optional<Byte> nullOptional = Coerce.asByte(null);
        assertTrue(!nullOptional.isPresent());
    }

    @Test
    public void testAsShort() {
        String character = "1";
        Optional<Short> optional = Coerce.asShort(character);
        assertTrue(optional.isPresent());
        assertTrue(optional.get() == 1);

        char myChar = '1';
        Optional<Short> optional1 = Coerce.asShort(myChar);
        assertTrue(optional1.isPresent());
        assertTrue(optional1.get() == 1);

        String invalidString = "foo";
        Optional<Short> invalidOptional = Coerce.asShort(invalidString);
        assertTrue(!invalidOptional.isPresent());

        int myInt = 1;
        Optional<Short> optional2 = Coerce.asShort(myInt);
        assertTrue(optional2.isPresent());
        assertTrue(optional2.get() == 1);



        Optional<Short> nullOptional = Coerce.asShort(null);
        assertTrue(!nullOptional.isPresent());
    }

    @Test
    public void testAsLong() {
        String character = "1";
        Optional<Long> optional = Coerce.asLong(character);
        assertTrue(optional.isPresent());
        assertTrue(optional.get() == 1);

        char myChar = '1';
        Optional<Long> optional1 = Coerce.asLong(myChar);
        assertTrue(optional1.isPresent());
        assertTrue(optional1.get() == 1);

        String invalidString = "foo";
        Optional<Long> invalidOptional = Coerce.asLong(invalidString);
        assertTrue(!invalidOptional.isPresent());

        int myInt = 1;
        Optional<Long> optional2 = Coerce.asLong(myInt);
        assertTrue(optional2.isPresent());
        assertTrue(optional2.get() == 1);



        Optional<Long> nullOptional = Coerce.asLong(null);
        assertTrue(!nullOptional.isPresent());
    }

    @Test
    public void testAsFloat() {
        String character = "1";
        Optional<Float> optional = Coerce.asFloat(character);
        assertTrue(optional.isPresent());
        assertTrue(optional.get() == 1);

        char myChar = '1';
        Optional<Float> optional1 = Coerce.asFloat(myChar);
        assertTrue(optional1.isPresent());
        assertTrue(optional1.get() == 1);

        String invalidString = "foo";
        Optional<Float> invalidOptional = Coerce.asFloat(invalidString);
        assertTrue(!invalidOptional.isPresent());

        int myInt = 1;
        Optional<Float> optional2 = Coerce.asFloat(myInt);
        assertTrue(optional2.isPresent());
        assertTrue(optional2.get() == 1);



        Optional<Float> nullOptional = Coerce.asFloat(null);
        assertTrue(!nullOptional.isPresent());
    }

    @Test
    public void testAsDouble() {
        String character = "1";
        Optional<Double> optional = Coerce.asDouble(character);
        assertTrue(optional.isPresent());
        assertTrue(optional.get() == 1);

        char myChar = '1';
        Optional<Double> optional1 = Coerce.asDouble(myChar);
        assertTrue(optional1.isPresent());
        assertTrue(optional1.get() == 1);

        String invalidString = "foo";
        Optional<Double> invalidOptional = Coerce.asDouble(invalidString);
        assertTrue(!invalidOptional.isPresent());

        int myInt = 1;
        Optional<Double> optional2 = Coerce.asDouble(myInt);
        assertTrue(optional2.isPresent());
        assertTrue(optional2.get() == 1);



        Optional<Double> nullOptional = Coerce.asDouble(null);
        assertTrue(!nullOptional.isPresent());
    }

    @Test
    public void testAsInteger() {
        String character = "1";
        Optional<Integer> optional = Coerce.asInteger(character);
        assertTrue(optional.isPresent());
        assertTrue(optional.get() == 1);

        char myChar = '1';
        Optional<Integer> optional1 = Coerce.asInteger(myChar);
        assertTrue(optional1.isPresent());
        assertTrue(optional1.get() == 1);

        String invalidString = "foo";
        Optional<Integer> invalidOptional = Coerce.asInteger(invalidString);
        assertTrue(!invalidOptional.isPresent());

        int myInt = 1;
        Optional<Integer> optional2 = Coerce.asInteger(myInt);
        assertTrue(optional2.isPresent());
        assertTrue(optional2.get() == 1);



        Optional<Integer> nullOptional = Coerce.asInteger(null);
        assertTrue(!nullOptional.isPresent());
    }

    @Test
    public void testAsString() {
        String character = "1";
        Optional<String> optional = Coerce.asString(character);
        assertTrue(optional.isPresent());
        assertTrue(optional.get().equals("1"));

        char myChar = '1';
        Optional<String> optional1 = Coerce.asString(myChar);
        assertTrue(optional1.isPresent());
        assertTrue(optional1.get().equals("1"));

        String invalidString = "foo";
        Optional<String> message = Coerce.asString(invalidString);
        assertTrue(message.isPresent());
        assertTrue(message.get().equals("foo"));

        int myInt = 1;
        Optional<String> optional2 = Coerce.asString(myInt);
        assertTrue(optional2.isPresent());
        assertTrue(optional2.get().equals("1"));


        Optional<String> nullOptional = Coerce.asString(null);
        assertTrue(!nullOptional.isPresent());
    }
}

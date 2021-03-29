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
package org.spongepowered.api.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class CoerceTest {

    @Test
    void testAsCharacter() {
        final String character = "myChar";
        final Optional<Character> optional = Coerce.asChar(character);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals('m', (char) optional.get());

        final char myChar = 'm';
        final Optional<Character> optional1 = Coerce.asChar(myChar);
        Assertions.assertTrue(optional1.isPresent());
        Assertions.assertEquals('m', (char) optional1.get());

        final int myInt = 1;
        final Optional<Character> optional2 = Coerce.asChar(myInt);
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals('1', (char) optional2.get());

        final Optional<Character> nullOptional = Coerce.asChar(null);
        Assertions.assertFalse(nullOptional.isPresent());
    }

    @Test
    void testAsBoolean() {
        final Object myBool = Boolean.TRUE;
        final Optional<Boolean> optional = Coerce.asBoolean(myBool);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertTrue(optional.get());

        final Optional<Boolean> nullBoolean = Coerce.asBoolean(null);
        Assertions.assertFalse(nullBoolean.isPresent());

        final Optional<Boolean> invalidBoolean = Coerce.asBoolean("foo");
        Assertions.assertFalse(invalidBoolean.isPresent());
    }

    @Test
    void testAsByte() {
        final String character = "1";
        final Optional<Byte> optional = Coerce.asByte(character);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1, (byte) optional.get());

        final char myChar = '1';
        final Optional<Byte> optional1 = Coerce.asByte(myChar);
        Assertions.assertTrue(optional1.isPresent());
        Assertions.assertEquals(1, (byte) optional1.get());

        final String invalidString = "foo";
        final Optional<Byte> invalidOptional = Coerce.asByte(invalidString);
        Assertions.assertFalse(invalidOptional.isPresent());

        final int myInt = 1;
        final Optional<Byte> optional2 = Coerce.asByte(myInt);
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals(1, (byte) optional2.get());



        final Optional<Byte> nullOptional = Coerce.asByte(null);
        Assertions.assertFalse(nullOptional.isPresent());
    }

    @Test
    void testAsShort() {
        final String character = "1";
        final Optional<Short> optional = Coerce.asShort(character);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1, (short) optional.get());

        final char myChar = '1';
        final Optional<Short> optional1 = Coerce.asShort(myChar);
        Assertions.assertTrue(optional1.isPresent());
        Assertions.assertEquals(1, (short) optional1.get());

        final String invalidString = "foo";
        final Optional<Short> invalidOptional = Coerce.asShort(invalidString);
        Assertions.assertFalse(invalidOptional.isPresent());

        final int myInt = 1;
        final Optional<Short> optional2 = Coerce.asShort(myInt);
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals(1, (short) optional2.get());

        final Optional<Short> nullOptional = Coerce.asShort(null);
        Assertions.assertFalse(nullOptional.isPresent());
    }

    @Test
    void testAsLong() {
        final String character = "1";
        final Optional<Long> optional = Coerce.asLong(character);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1, (long) optional.get());

        final char myChar = '1';
        final Optional<Long> optional1 = Coerce.asLong(myChar);
        Assertions.assertTrue(optional1.isPresent());
        Assertions.assertEquals(1, (long) optional1.get());

        final String invalidString = "foo";
        final Optional<Long> invalidOptional = Coerce.asLong(invalidString);
        Assertions.assertFalse(invalidOptional.isPresent());

        final int myInt = 1;
        final Optional<Long> optional2 = Coerce.asLong(myInt);
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals(1, (long) optional2.get());



        final Optional<Long> nullOptional = Coerce.asLong(null);
        Assertions.assertFalse(nullOptional.isPresent());
    }

    @Test
    void testAsFloat() {
        final String character = "1";
        final Optional<Float> optional = Coerce.asFloat(character);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1, optional.get(), 0.0);

        final char myChar = '1';
        final Optional<Float> optional1 = Coerce.asFloat(myChar);
        Assertions.assertTrue(optional1.isPresent());
        Assertions.assertEquals(1, optional1.get(), 0.0);

        final String invalidString = "foo";
        final Optional<Float> invalidOptional = Coerce.asFloat(invalidString);
        Assertions.assertFalse(invalidOptional.isPresent());

        final int myInt = 1;
        final Optional<Float> optional2 = Coerce.asFloat(myInt);
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals(1, optional2.get(), 0.0);

        final Optional<Float> nullOptional = Coerce.asFloat(null);
        Assertions.assertFalse(nullOptional.isPresent());
    }

    @Test
    void testAsDouble() {
        final String character = "1";
        final Optional<Double> optional = Coerce.asDouble(character);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1, optional.get(), 0.0);

        final char myChar = '1';
        final Optional<Double> optional1 = Coerce.asDouble(myChar);
        Assertions.assertTrue(optional1.isPresent());
        Assertions.assertEquals(1, optional1.get(), 0.0);

        final String invalidString = "foo";
        final Optional<Double> invalidOptional = Coerce.asDouble(invalidString);
        Assertions.assertFalse(invalidOptional.isPresent());

        final int myInt = 1;
        final Optional<Double> optional2 = Coerce.asDouble(myInt);
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals(1, optional2.get(), 0.0);



        final Optional<Double> nullOptional = Coerce.asDouble(null);
        Assertions.assertFalse(nullOptional.isPresent());
    }

    @Test
    void testAsInteger() {
        final String character = "1";
        final Optional<Integer> optional = Coerce.asInteger(character);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals(1, (int) optional.get());

        final char myChar = '1';
        final Optional<Integer> optional1 = Coerce.asInteger(myChar);
        Assertions.assertTrue(optional1.isPresent());
        Assertions.assertEquals(1, (int) optional1.get());

        final String invalidString = "foo";
        final Optional<Integer> invalidOptional = Coerce.asInteger(invalidString);
        Assertions.assertFalse(invalidOptional.isPresent());

        final int myInt = 1;
        final Optional<Integer> optional2 = Coerce.asInteger(myInt);
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals(1, (int) optional2.get());



        final Optional<Integer> nullOptional = Coerce.asInteger(null);
        Assertions.assertFalse(nullOptional.isPresent());
    }

    @Test
    void testAsString() {
        final String character = "1";
        final Optional<String> optional = Coerce.asString(character);
        Assertions.assertTrue(optional.isPresent());
        Assertions.assertEquals("1", optional.get());

        final char myChar = '1';
        final Optional<String> optional1 = Coerce.asString(myChar);
        Assertions.assertTrue(optional1.isPresent());
        Assertions.assertEquals("1", optional1.get());

        final String invalidString = "foo";
        final Optional<String> message = Coerce.asString(invalidString);
        Assertions.assertTrue(message.isPresent());
        Assertions.assertEquals("foo", message.get());

        final int myInt = 1;
        final Optional<String> optional2 = Coerce.asString(myInt);
        Assertions.assertTrue(optional2.isPresent());
        Assertions.assertEquals("1", optional2.get());


        final Optional<String> nullOptional = Coerce.asString(null);
        Assertions.assertFalse(nullOptional.isPresent());
    }
}

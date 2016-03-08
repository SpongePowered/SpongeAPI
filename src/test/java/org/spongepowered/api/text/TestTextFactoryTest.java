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
package org.spongepowered.api.text;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.text.translation.FixedTranslation;

public class TestTextFactoryTest {

    @Before
    public void initialize() throws Exception {
        TestPlainTextSerializer.inject();
    }

    @Test
    public void testToPlainLiterals() {
        Text testText = Text.builder("Hello ").append(Text.of("world"), Text.of(", this is here")).build();
        assertEquals("Hello world, this is here", testText.toPlain());
    }

    @Test
    public void testToPlainTranslatables() {
        Text testText = Text.of(new FixedTranslation("This is a translated %s"), Text.of("string"));
        assertEquals("This is a translated string", testText.toPlain());
    }

}

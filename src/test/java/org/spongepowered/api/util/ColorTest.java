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


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3f;
import org.spongepowered.math.vector.Vector3i;

public class ColorTest {

    @Test
    public void testOfRgbHex() {
        final Color colorGray = Color.ofRgb(0x808080);
        assertEquals(Color.GRAY, colorGray);
    }

    @Test
    public void testOfRgbForRedGreenBlue() {
        final Color colorGray = Color.ofRgb(128, 128, 128);
        assertEquals(Color.GRAY, colorGray);
    }

    @Test
    public void testOfColor() {
        final Color blueColor = Color.of(java.awt.Color.BLUE);
        assertEquals(blueColor, Color.BLUE);
    }

    @Test
    public void testOfVector3i() {
        final Vector3i vecGray = new Vector3i(128, 128, 384);
        final Color colorGray = Color.of(vecGray);
        assertEquals(Color.GRAY, colorGray);
    }

    @Test
    public void testOfVector3f() {
        final Vector3f vecGray = new Vector3f(128.0, 128.459, 127.5);
        final Color colorGray = Color.of(vecGray);
        assertEquals(Color.GRAY, colorGray);
    }

    @Test
    public void testOfVector3d() {
        final Vector3d vecGray = new Vector3d(128.0, 128.459, 127.5);
        final Color colorGray = Color.of(vecGray);
        assertEquals(Color.GRAY, colorGray);
    }

    @Test
    public void testMixColors() {
        final Color grey = Color.GRAY;
        final Color test = Color.WHITE.mixWithColors(Color.BLACK);
        assertEquals(grey, test);
    }

    @Test
    public void testGetRed() {
        assertEquals(0xFF, Color.RED.red());
    }

    @Test
    public void testWithRed() {
        final Color cyan = Color.CYAN;
        final Color merged = cyan.withRed(0xFF);
        final int rgb = merged.rgb();
        assertEquals(0xFFFFFF, rgb);
    }

    @Test
    public void testGetGreen() {
        assertEquals(0x80, Color.GREEN.green());
    }

    @Test
    public void testWithGreen() {
        final Color magenta = Color.MAGENTA;
        final Color merged = magenta.withGreen(0xFF);
        final int rgb = merged.rgb();
        assertEquals(0xFFFFFF, rgb);
    }

    @Test
    public void testGetBlue() {
        assertEquals(0x0000FF, Color.BLUE.blue());
    }

    @Test
    public void testWithBlue() {
        final Color yellow = Color.YELLOW;
        final Color merged = yellow.withBlue(0xFF);
        final int rgb = merged.rgb();
        assertEquals(0xFFFFFF, rgb);
    }

    @Test
    public void testAsJavaColor() {
        final int color = 0xFF00FF;
        final Color apiColor = Color.ofRgb(color);
        final java.awt.Color javaColor = apiColor.asJavaColor();
        final java.awt.Color testColor = new java.awt.Color(color);
        assertEquals(javaColor, testColor);
    }

    @Test
    public void testGetRgb() {
        final int color = 0x808080;
        final Color color1 = Color.ofRgb(color);
        final int rgb = color1.rgb();
        assertEquals(color, rgb);
    }

    @Test
    public void testEquals() {
        assertEquals(Color.GREEN, Color.ofRgb(0x008000));
        assertNotEquals(Color.GREEN, Color.GRAY);
    }

}

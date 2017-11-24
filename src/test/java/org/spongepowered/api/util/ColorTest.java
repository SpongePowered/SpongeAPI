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

import static org.junit.Assert.assertTrue;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector3i;
import org.junit.Test;
import org.spongepowered.api.data.DataContainer;

public class ColorTest {

    @Test
    public void testOfHex() {
        final Color gray = Color.ofHex(0xAAAAAA);
        assertTrue(Color.GRAY.equals(gray));
    }

    @Test
    public void testOfRgb() {
        final Color gold = Color.ofRgb(255, 170, 0);
        assertTrue(Color.GOLD.equals(gold));
    }

    @Test
    public void testOfVector3i() {
        final Vector3i vecDarkAqua = new Vector3i(0, 170, 170);
        final Color darkAqua = Color.of(vecDarkAqua);
        assertTrue(Color.DARK_AQUA.equals(darkAqua));
    }

    @Test
    @Deprecated
    public void testOfVector3f() {
        final Vector3f vecDarkBlue = new Vector3f(0, 0.01, 170 + 0.25);
        final Color DarkBlue = Color.of(vecDarkBlue);
        assertTrue(Color.DARK_BLUE.equals(DarkBlue));
    }

    @Test
    @Deprecated
    public void testOfVector3d() {
        final Vector3d vecDarkRed = new Vector3d(170.4, -0.392, 0.117);
        final Color darkRed = Color.of(vecDarkRed);
        assertTrue(Color.DARK_RED.equals(darkRed));
    }

    @Test
    public void testOfJavaColor() {
        final Color blue = Color.of(java.awt.Color.WHITE);
        assertTrue(blue.equals(Color.WHITE));
    }

    @Test
    public void testMixColors() {
        final Color blackAndYellow = Color.ofRgb(128, 128, 43);
        final Color mix = Color.YELLOW.mixWithColors(Color.BLACK);
        assertTrue(blackAndYellow.equals(mix));
    }

    @Test
    public void testGetHex() {
        final int hex = 0x123456;
        final Color color = Color.ofHex(hex);
        assertTrue(hex == color.getHex());
    }

    @Test
    public void testGetRed() {
        assertTrue(0xFF == Color.RED.getRed());
    }

    @Test
    public void testGetGreen() {
        assertTrue(0xFF == Color.GREEN.getGreen());
    }

    @Test
    public void testGetBlue() {
        assertTrue(0xFF == Color.BLUE.getBlue());
    }

    @Test
    public void testWithRed() {
        final Color purple = Color.LIGHT_PURPLE;
        final Color merged = purple.withRed(0xFF);
        assertTrue(purple.equals(merged));
    }

    @Test
    public void testWithGreen() {
        final Color purple = Color.AQUA;
        final Color merged = purple.withGreen(0x00);
        assertTrue(merged.getHex() == 0x5500FF);
    }

    @Test
    public void testWithBlue() {
        final Color darkPurple= Color.DARK_PURPLE;
        final Color merged = darkPurple.withBlue(0x55);
        assertTrue(merged.getHex() == 0xAA0055);
    }

    @Test
    public void testAsVector3i() {
        final Vector3i vec = new Vector3i(7, 42, 101);
        final Color color = Color.of(vec);
        assertTrue(vec.equals(color.asVector3i()));
    }

    @Test
    public void testAsJavaColor() {
        final int color = 0xFF00FF;
        final Color apiColor = Color.ofHex(color);
        final java.awt.Color javaColor = apiColor.asJavaColor();
        final java.awt.Color testColor = new java.awt.Color(color);
        assertTrue(javaColor.equals(testColor));
    }

    @Test
    public void testEquals() {
        assertTrue(Color.DARK_GREEN.equals(Color.ofHex(0x00AA00)));
        assertTrue(!Color.GRAY.equals(Color.YELLOW));
        assertTrue(Color.YELLOW.hashCode() == Color.ofRgb(255, 255, 85).hashCode());
    }

    @Test
    public void testToContainer() {
        final Color darkGray = Color.DARK_GRAY;
        final Color.Builder builder = new Color.Builder();
        final DataContainer container = darkGray.toContainer();
        final Color deserialized = builder.build(container).get();
        assertTrue(darkGray.equals(deserialized));
    }

}
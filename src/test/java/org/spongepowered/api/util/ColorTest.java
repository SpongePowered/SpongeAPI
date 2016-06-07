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
    public void testOfRgbHex() {
        final Color colorGray = Color.ofRgb(0x808080);
        assertTrue(Color.GRAY.equals(colorGray));
    }

    @Test
    public void testOfRgbForRedGreenBlue() {
        final Color colorGray = Color.ofRgb(128, 128, 128);
        assertTrue(Color.GRAY.equals(colorGray));
    }

    @Test
    public void testOfColor() {
        final Color blueColor = Color.of(java.awt.Color.BLUE);
        assertTrue(blueColor.equals(Color.BLUE));
    }

    @Test
    public void testOfVector3i() {
        final Vector3i vecGray = new Vector3i(128, 128, 384);
        final Color colorGray = Color.of(vecGray);
        assertTrue(Color.GRAY.equals(colorGray));
    }

    @Test
    public void testOfVector3f() {
        final Vector3f vecGray = new Vector3f(128.0, 128.459, 127.5);
        final Color colorGray = Color.of(vecGray);
        assertTrue(Color.GRAY.equals(colorGray));
    }

    @Test
    public void testOfVector3d() {
        final Vector3d vecGray = new Vector3d(128.0, 128.459, 127.5);
        final Color colorGray = Color.of(vecGray);
        assertTrue(Color.GRAY.equals(colorGray));
    }

    @Test
    public void testMixColors() {
        final Color grey = Color.GRAY;
        final Color test = Color.WHITE.mixWithColors(Color.BLACK);
        assertTrue(grey.equals(test));
    }

    @Test
    public void testGetRed() {
        assertTrue(0xFF == Color.RED.getRed());
    }

    @Test
    public void testWithRed() {
        final Color cyan = Color.CYAN;
        final Color merged = cyan.withRed(0xFF);
        final int rgb = merged.getRgb();
        assertTrue(0xFFFFFF == rgb);
    }

    @Test
    public void testGetGreen() {
        assertTrue(0x80 == Color.GREEN.getGreen());
    }

    @Test
    public void testWithGreen() {
        final Color magenta = Color.MAGENTA;
        final Color merged = magenta.withGreen(0xFF);
        final int rgb = merged.getRgb();
        assertTrue(0xFFFFFF == rgb);
    }

    @Test
    public void testGetBlue() {
        assertTrue(0xFF == Color.BLUE.getBlue());
    }

    @Test
    public void testWithBlue() {
        final Color yellow = Color.YELLOW;
        final Color merged = yellow.withBlue(0xFF);
        final int rgb = merged.getRgb();
        assertTrue(0xFFFFFF == rgb);
    }

    @Test
    public void testAsJavaColor() {
        final int color = 0xFF00FF;
        final Color apiColor = Color.ofRgb(color);
        final java.awt.Color javaColor = apiColor.asJavaColor();
        final java.awt.Color testColor = new java.awt.Color(color);
        assertTrue(javaColor.equals(testColor));
    }

    @Test
    public void testGetRgb() {
        final int color = 0x808080;
        final Color color1 = Color.ofRgb(color);
        final int rgb = color1.getRgb();
        assertTrue(color == rgb);
    }

    @Test
    public void testToContainer() {
        final Color colorGray = Color.GRAY;
        final Color.Builder builder = new Color.Builder();
        final DataContainer container = colorGray.toContainer();
        final Color deserialized = builder.build(container).get();
        assertTrue(colorGray.equals(deserialized));
    }

    @Test
    public void testEquals() {
        assertTrue(Color.GREEN.equals(Color.ofRgb(0x008000)));
        assertTrue(!Color.GREEN.equals(Color.GRAY));
    }

}

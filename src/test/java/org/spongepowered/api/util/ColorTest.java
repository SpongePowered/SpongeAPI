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
        final Color orange = Color.ofHex(0xFFA500);
        assertTrue(Color.ORANGE.equals(orange));
    }

    @Test
    public void testOfRgb() {
        final Color silver = Color.ofRgb(192, 192, 192);
        assertTrue(Color.SILVER.equals(silver));
    }

    @Test
    public void testOfVector3i() {
        final Vector3i vecTeal = new Vector3i(0, 128, 128);
        final Color teal = Color.of(vecTeal);
        assertTrue(Color.TEAL.equals(teal));
    }

    @Test
    @Deprecated
    public void testOfVector3f() {
        final Vector3f vecGreen = new Vector3f(0.0, 128.4, -0.1);
        final Color green = Color.of(vecGreen);
        assertTrue(Color.GREEN.equals(green));
    }

    @Test
    @Deprecated
    public void testOfVector3d() {
        final Vector3d vecPurple = new Vector3d(127 + 4/7D, 0.414, 128.08);
        final Color purple = Color.of(vecPurple);
        System.out.println(purple.toString());
        assertTrue(Color.PURPLE.equals(purple));
    }

    @Test
    public void testOfJavaColor() {
        final Color white = Color.of(java.awt.Color.WHITE);
        assertTrue(Color.WHITE.equals(white));
    }

    @Test
    public void testMixColors() {
        final Color blackAndYellow = Color.ofRgb(128, 128, 0);
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
        assertTrue(0x00 == Color.FUCHSIA.getGreen());
    }

    @Test
    public void testGetBlue() {
        assertTrue(0x80 == Color.NAVY.getBlue());
    }

    @Test
    public void testWithRed() {
        final int red = 0xFF;
        final Color withRed = Color.GRAY.withRed(red);
        assertTrue(red == withRed.getRed());
    }

    @Test
    public void testWithGreen() {
        final int green = 0x00;
        final Color withGreen = Color.OLIVE.withGreen(green);
        assertTrue(green == withGreen.getGreen());
    }

    @Test
    public void testWithBlue() {
        final int blue = 0x80;
        final Color withBlue = Color.MAROON.withBlue(blue);
        assertTrue(blue == withBlue.getBlue());
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
        final java.awt.Color javaColor = new java.awt.Color(color);
        final Color apiColor = Color.ofHex(color);
        assertTrue(javaColor.equals(apiColor.asJavaColor()));
    }

    @Test
    public void testEquals() {
        assertTrue(Color.LIME.equals(Color.ofHex(0x00FF00)));
        assertTrue(Color.BLUE.hashCode() == Color.ofRgb(0, 0, 255).hashCode());
    }

    @Test
    public void testToContainer() {
        final Color aqua = Color.AQUA;
        final DataContainer container = aqua.toContainer();
        final Color deserialized = new Color.Builder().build(container).get();
        assertTrue(aqua.equals(deserialized));
    }

}

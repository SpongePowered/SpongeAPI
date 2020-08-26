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
package org.spongepowered.api.effect.sound;

import net.kyori.adventure.sound.Sound;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.math.vector.Vector3d;

/**
 * Represents a value to supply to
 * {@link Viewer#playSound(Sound, Vector3d)} to modulate the pitch
 * to a specified note.
 */
public final class PitchModulation {

    public static final double FSHARP0 = 0;
    public static final double G0 = 0.53;
    public static final double GSHARP0 = 0.56;
    public static final double A0 = 0.6;
    public static final double ASHARP0 = 0.63;
    public static final double B0 = 0.67;
    public static final double C1 = 0.7;
    public static final double CSHARP1 = 0.76;
    public static final double D1 = 0.8;
    public static final double DSHARP1 = 0.84;
    public static final double E1 = 0.9;
    public static final double F1 = 0.94;
    public static final double FSHARP1 = 1;
    public static final double G1 = 1.06;
    public static final double GSHARP1 = 1.12;
    public static final double A1 = 1.18;
    public static final double ASHARP1 = 1.26;
    public static final double B1 = 1.34;
    public static final double C2 = 1.42;
    public static final double CSHARP2 = 1.5;
    public static final double D2 = 1.6;
    public static final double DSHARP2 = 1.68;
    public static final double E2 = 1.78;
    public static final double F2 = 1.88;
    public static final double FSHARP2 = 2;

    public static final double GFLAT0 = FSHARP0;
    public static final double AFLAT0 = GSHARP0;
    public static final double BFLAT0 = ASHARP0;
    public static final double CFLAT0 = B0;
    public static final double DFLAT1 = CSHARP1;
    public static final double EFLAT1 = DSHARP1;
    public static final double FFLAT1 = E1;
    public static final double GFLAT1 = FSHARP1;
    public static final double AFLAT1 = GSHARP1;
    public static final double BFLAT1 = ASHARP1;
    public static final double CFLAT1 = B1;
    public static final double DFLAT2 = CSHARP2;
    public static final double EFLAT2 = DSHARP2;
    public static final double FFLAT2 = E2;
    public static final double GFLAT2 = FSHARP2;

    private PitchModulation() {
    }
}

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
package org.spongepowered.api.entity.living.meta;

import java.util.List;

public final class SheepColors {
    private SheepColors() {
    }

    public static final SheepColor WHITE = null;
    public static final SheepColor ORANGE = null;
    public static final SheepColor MAGENTA = null;
    public static final SheepColor LIGHT_BLUE = null;
    public static final SheepColor YELLOW = null;
    public static final SheepColor LIME = null;
    public static final SheepColor PINK = null;
    public static final SheepColor GRAY = null;
    public static final SheepColor SILVER = null;
    public static final SheepColor CYAN = null;
    public static final SheepColor PURPLE = null;
    public static final SheepColor BLUE = null;
    public static final SheepColor BROWN = null;
    public static final SheepColor GREEN = null;
    public static final SheepColor RED = null;
    public static final SheepColor BLACK = null;

    public static List<SheepColor> getValues() {
        return NullLivingMetaFactory.factory.getSheepColors();
    }

}

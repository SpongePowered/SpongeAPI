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
package org.spongepowered.api.data.type;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of vanilla {@link BannerPatternShape}s.
 */
public final class BannerPatternShapes {

    // SORTFIELDS:ON

    public static final Supplier<BannerPatternShape> BASE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "base");

    public static final Supplier<BannerPatternShape> BORDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "border");

    public static final Supplier<BannerPatternShape> BRICKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "bricks");

    public static final Supplier<BannerPatternShape> CIRCLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "circle");

    public static final Supplier<BannerPatternShape> CREEPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "creeper");

    public static final Supplier<BannerPatternShape> CROSS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "cross");

    public static final Supplier<BannerPatternShape> CURLY_BORDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "curly_border");

    public static final Supplier<BannerPatternShape> DIAGONAL_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "diagonal_left");

    public static final Supplier<BannerPatternShape> DIAGONAL_UP_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "diagonal_up_left");

    public static final Supplier<BannerPatternShape> DIAGONAL_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "diagonal_right");

    public static final Supplier<BannerPatternShape> DIAGONAL_UP_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "diagonal_up_right");

    public static final Supplier<BannerPatternShape> FLOWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "flower");

    public static final Supplier<BannerPatternShape> GLOBE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "globe");

    public static final Supplier<BannerPatternShape> GRADIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "gradient");

    public static final Supplier<BannerPatternShape> GRADIENT_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "gradient_up");

    public static final Supplier<BannerPatternShape> HALF_HORIZONTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "half_horizontal");

    public static final Supplier<BannerPatternShape> HALF_HORIZONTAL_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "half_horizontal_bottom");

    public static final Supplier<BannerPatternShape> HALF_VERTICAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "half_vertical");

    public static final Supplier<BannerPatternShape> HALF_VERTICAL_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "half_vertical_right");

    public static final Supplier<BannerPatternShape> MOJANG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "mojang");

    public static final Supplier<BannerPatternShape> RHOMBUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "rhombus");

    public static final Supplier<BannerPatternShape> SKULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "skull");

    public static final Supplier<BannerPatternShape> SQUARE_BOTTOM_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "square_bottom_left");

    public static final Supplier<BannerPatternShape> SQUARE_BOTTOM_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "square_bottom_right");

    public static final Supplier<BannerPatternShape> SQUARE_TOP_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "square_top_left");

    public static final Supplier<BannerPatternShape> SQUARE_TOP_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "square_top_right");

    public static final Supplier<BannerPatternShape> STRAIGHT_CROSS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "straight_cross");

    public static final Supplier<BannerPatternShape> STRIPE_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "stripe_bottom");

    public static final Supplier<BannerPatternShape> STRIPE_CENTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "stripe_center");

    public static final Supplier<BannerPatternShape> STRIPE_DOWNLEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "stripe_downleft");

    public static final Supplier<BannerPatternShape> STRIPE_DOWNRIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "stripe_downright");

    public static final Supplier<BannerPatternShape> STRIPE_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "stripe_left");

    public static final Supplier<BannerPatternShape> STRIPE_MIDDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "stripe_middle");

    public static final Supplier<BannerPatternShape> STRIPE_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "stripe_right");

    public static final Supplier<BannerPatternShape> SMALL_STRIPES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "small_stripes");

    public static final Supplier<BannerPatternShape> STRIPE_TOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "stripe_top");

    public static final Supplier<BannerPatternShape> TRIANGLES_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "triangles_bottom");

    public static final Supplier<BannerPatternShape> TRIANGLES_TOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "triangles_top");

    public static final Supplier<BannerPatternShape> TRIANGLE_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "triangle_bottom");

    public static final Supplier<BannerPatternShape> TRIANGLE_TOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "triangle_top");

    // SORTFIELDS:OFF

    private BannerPatternShapes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}

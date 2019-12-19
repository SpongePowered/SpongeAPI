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

    public static final Supplier<BannerPatternShape> BASE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "BASE");

    public static final Supplier<BannerPatternShape> BORDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "BORDER");

    public static final Supplier<BannerPatternShape> BRICKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "BRICKS");

    public static final Supplier<BannerPatternShape> CIRCLE_MIDDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "CIRCLE_MIDDLE");

    public static final Supplier<BannerPatternShape> CREEPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "CREEPER");

    public static final Supplier<BannerPatternShape> CROSS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "CROSS");

    public static final Supplier<BannerPatternShape> CURLY_BORDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "CURLY_BORDER");

    public static final Supplier<BannerPatternShape> DIAGONAL_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "DIAGONAL_LEFT");

    public static final Supplier<BannerPatternShape> DIAGONAL_LEFT_MIRROR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "DIAGONAL_LEFT_MIRROR");

    public static final Supplier<BannerPatternShape> DIAGONAL_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "DIAGONAL_RIGHT");

    public static final Supplier<BannerPatternShape> DIAGONAL_RIGHT_MIRROR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "DIAGONAL_RIGHT_MIRROR");

    public static final Supplier<BannerPatternShape> FLOWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "FLOWER");

    public static final Supplier<BannerPatternShape> GRADIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "GRADIENT");

    public static final Supplier<BannerPatternShape> GRADIENT_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "GRADIENT_UP");

    public static final Supplier<BannerPatternShape> HALF_HORIZONTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "HALF_HORIZONTAL");

    public static final Supplier<BannerPatternShape> HALF_HORIZONTAL_MIRROR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "HALF_HORIZONTAL_MIRROR");

    public static final Supplier<BannerPatternShape> HALF_VERTICAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "HALF_VERTICAL");

    public static final Supplier<BannerPatternShape> HALF_VERTICAL_MIRROR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "HALF_VERTICAL_MIRROR");

    public static final Supplier<BannerPatternShape> MOJANG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "MOJANG");

    public static final Supplier<BannerPatternShape> RHOMBUS_MIDDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "RHOMBUS_MIDDLE");

    public static final Supplier<BannerPatternShape> SKULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "SKULL");

    public static final Supplier<BannerPatternShape> SQUARE_BOTTOM_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "SQUARE_BOTTOM_LEFT");

    public static final Supplier<BannerPatternShape> SQUARE_BOTTOM_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "SQUARE_BOTTOM_RIGHT");

    public static final Supplier<BannerPatternShape> SQUARE_TOP_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "SQUARE_TOP_LEFT");

    public static final Supplier<BannerPatternShape> SQUARE_TOP_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "SQUARE_TOP_RIGHT");

    public static final Supplier<BannerPatternShape> STRAIGHT_CROSS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRAIGHT_CROSS");

    public static final Supplier<BannerPatternShape> STRIPE_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_BOTTOM");

    public static final Supplier<BannerPatternShape> STRIPE_CENTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_CENTER");

    public static final Supplier<BannerPatternShape> STRIPE_DOWNLEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_DOWNLEFT");

    public static final Supplier<BannerPatternShape> STRIPE_DOWNRIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_DOWNRIGHT");

    public static final Supplier<BannerPatternShape> STRIPE_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_LEFT");

    public static final Supplier<BannerPatternShape> STRIPE_MIDDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_MIDDLE");

    public static final Supplier<BannerPatternShape> STRIPE_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_RIGHT");

    public static final Supplier<BannerPatternShape> STRIPE_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_SMALL");

    public static final Supplier<BannerPatternShape> STRIPE_TOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "STRIPE_TOP");

    public static final Supplier<BannerPatternShape> TRIANGLES_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "TRIANGLES_BOTTOM");

    public static final Supplier<BannerPatternShape> TRIANGLES_TOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "TRIANGLES_TOP");

    public static final Supplier<BannerPatternShape> TRIANGLE_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "TRIANGLE_BOTTOM");

    public static final Supplier<BannerPatternShape> TRIANGLE_TOP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BannerPatternShape.class, "TRIANGLE_TOP");

    // SORTFIELDS:OFF

    private BannerPatternShapes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}

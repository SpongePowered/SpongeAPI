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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of vanilla {@link BannerPatternShape}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class BannerPatternShapes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<BannerPatternShape> BASE = BannerPatternShapes.key(ResourceKey.sponge("base"));

    public static final DefaultedRegistryReference<BannerPatternShape> BORDER = BannerPatternShapes.key(ResourceKey.sponge("border"));

    public static final DefaultedRegistryReference<BannerPatternShape> BRICKS = BannerPatternShapes.key(ResourceKey.sponge("bricks"));

    public static final DefaultedRegistryReference<BannerPatternShape> CIRCLE = BannerPatternShapes.key(ResourceKey.sponge("circle"));

    public static final DefaultedRegistryReference<BannerPatternShape> CREEPER = BannerPatternShapes.key(ResourceKey.sponge("creeper"));

    public static final DefaultedRegistryReference<BannerPatternShape> CROSS = BannerPatternShapes.key(ResourceKey.sponge("cross"));

    public static final DefaultedRegistryReference<BannerPatternShape> CURLY_BORDER = BannerPatternShapes.key(ResourceKey.sponge("curly_border"));

    public static final DefaultedRegistryReference<BannerPatternShape> DIAGONAL_LEFT = BannerPatternShapes.key(ResourceKey.sponge("diagonal_left"));

    public static final DefaultedRegistryReference<BannerPatternShape> DIAGONAL_UP_LEFT = BannerPatternShapes.key(ResourceKey.sponge("diagonal_up_left"));

    public static final DefaultedRegistryReference<BannerPatternShape> DIAGONAL_RIGHT = BannerPatternShapes.key(ResourceKey.sponge("diagonal_right"));

    public static final DefaultedRegistryReference<BannerPatternShape> DIAGONAL_UP_RIGHT = BannerPatternShapes.key(ResourceKey.sponge("diagonal_up_right"));

    public static final DefaultedRegistryReference<BannerPatternShape> FLOWER = BannerPatternShapes.key(ResourceKey.sponge("flower"));

    public static final DefaultedRegistryReference<BannerPatternShape> GLOBE = BannerPatternShapes.key(ResourceKey.sponge("globe"));

    public static final DefaultedRegistryReference<BannerPatternShape> GRADIENT = BannerPatternShapes.key(ResourceKey.sponge("gradient"));

    public static final DefaultedRegistryReference<BannerPatternShape> GRADIENT_UP = BannerPatternShapes.key(ResourceKey.sponge("gradient_up"));

    public static final DefaultedRegistryReference<BannerPatternShape> HALF_HORIZONTAL = BannerPatternShapes.key(ResourceKey.sponge("half_horizontal"));

    public static final DefaultedRegistryReference<BannerPatternShape> HALF_HORIZONTAL_BOTTOM = BannerPatternShapes.key(ResourceKey.sponge("half_horizontal_bottom"));

    public static final DefaultedRegistryReference<BannerPatternShape> HALF_VERTICAL = BannerPatternShapes.key(ResourceKey.sponge("half_vertical"));

    public static final DefaultedRegistryReference<BannerPatternShape> HALF_VERTICAL_RIGHT = BannerPatternShapes.key(ResourceKey.sponge("half_vertical_right"));

    public static final DefaultedRegistryReference<BannerPatternShape> MOJANG = BannerPatternShapes.key(ResourceKey.sponge("mojang"));

    public static final DefaultedRegistryReference<BannerPatternShape> RHOMBUS = BannerPatternShapes.key(ResourceKey.sponge("rhombus"));

    public static final DefaultedRegistryReference<BannerPatternShape> SKULL = BannerPatternShapes.key(ResourceKey.sponge("skull"));

    public static final DefaultedRegistryReference<BannerPatternShape> SQUARE_BOTTOM_LEFT = BannerPatternShapes.key(ResourceKey.sponge("square_bottom_left"));

    public static final DefaultedRegistryReference<BannerPatternShape> SQUARE_BOTTOM_RIGHT = BannerPatternShapes.key(ResourceKey.sponge("square_bottom_right"));

    public static final DefaultedRegistryReference<BannerPatternShape> SQUARE_TOP_LEFT = BannerPatternShapes.key(ResourceKey.sponge("square_top_left"));

    public static final DefaultedRegistryReference<BannerPatternShape> SQUARE_TOP_RIGHT = BannerPatternShapes.key(ResourceKey.sponge("square_top_right"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRAIGHT_CROSS = BannerPatternShapes.key(ResourceKey.sponge("straight_cross"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRIPE_BOTTOM = BannerPatternShapes.key(ResourceKey.sponge("stripe_bottom"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRIPE_CENTER = BannerPatternShapes.key(ResourceKey.sponge("stripe_center"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRIPE_DOWNLEFT = BannerPatternShapes.key(ResourceKey.sponge("stripe_downleft"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRIPE_DOWNRIGHT = BannerPatternShapes.key(ResourceKey.sponge("stripe_downright"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRIPE_LEFT = BannerPatternShapes.key(ResourceKey.sponge("stripe_left"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRIPE_MIDDLE = BannerPatternShapes.key(ResourceKey.sponge("stripe_middle"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRIPE_RIGHT = BannerPatternShapes.key(ResourceKey.sponge("stripe_right"));

    public static final DefaultedRegistryReference<BannerPatternShape> SMALL_STRIPES = BannerPatternShapes.key(ResourceKey.sponge("small_stripes"));

    public static final DefaultedRegistryReference<BannerPatternShape> STRIPE_TOP = BannerPatternShapes.key(ResourceKey.sponge("stripe_top"));

    public static final DefaultedRegistryReference<BannerPatternShape> TRIANGLES_BOTTOM = BannerPatternShapes.key(ResourceKey.sponge("triangles_bottom"));

    public static final DefaultedRegistryReference<BannerPatternShape> TRIANGLES_TOP = BannerPatternShapes.key(ResourceKey.sponge("triangles_top"));

    public static final DefaultedRegistryReference<BannerPatternShape> TRIANGLE_BOTTOM = BannerPatternShapes.key(ResourceKey.sponge("triangle_bottom"));

    public static final DefaultedRegistryReference<BannerPatternShape> TRIANGLE_TOP = BannerPatternShapes.key(ResourceKey.sponge("triangle_top"));

    // SORTFIELDS:OFF

    // @formatter:on

    private BannerPatternShapes() {
    }

    private static DefaultedRegistryReference<BannerPatternShape> key(final ResourceKey location) {
        return RegistryKey.<BannerPatternShape>of(Registries.BANNER_PATTERN_SHAPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}

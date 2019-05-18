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
/**
 * The base Fluid API that attempts to bridge the Data API and Forges Fluid API.
 * While {@link org.spongepowered.api.item.inventory.ItemStack}s are literal
 * stacks of an {@link org.spongepowered.api.item.ItemType} with extra data on
 * it, {@link org.spongepowered.api.fluid.FluidStack} are literal stacks
 * of a {@link org.spongepowered.api.fluid.FluidType} with some extra data
 * on it. There is no real detail of what constitutes a {@code FluidStack} as a
 * tangible item, but more so that there are items in the world that are
 * "containers" of either one or several {@code FluidStack}s.
 *
 * <p>In vanilla, there are very few items that contain a {@code FluidStack}.
 * The first item that comes to mind is a
 * {@link org.spongepowered.api.item.ItemTypes#WATER_BUCKET} will always contain
 * a {@code FluidStack} of
 * {@link org.spongepowered.api.fluid.FluidTypes#WATER} with the quantity
 * of exactly {@code 1000mB}. The {@code FluidStack} itself on the bucket cannot
 * be changed, but the {@code ItemStack} would be changed from being a water
 * bucket to just a normal empty bucket. This is also the case for lava buckets.
 * </p>
 */
@org.checkerframework.framework.qual.DefaultQualifier(org.checkerframework.checker.nullness.qual.NonNull.class)
package org.spongepowered.api.fluid;

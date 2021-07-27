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
package org.spongepowered.api.util.rotation;

import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.Angle;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.math.matrix.Matrix4d;

@CatalogedBy(Rotations.class)
public interface Rotation extends DefaultedRegistryValue {

    Rotation and(final Rotation rotation);

    /**
     * Gets the the rotation in degrees always in clockwise order.
     *
     * @return The rotation
     */
    Angle angle();

    /**
     * Gets the {@link Matrix4d 4D rotation matrix} of this rotation.
     *
     * <p>Minecraft's coordinate system is different than traditional systems
     * applying the semantic meaning behind the {@code x} and {@code z} axis.
     * These natures are described as below:
     * </p>
     * <ul>
     *     <li>The x-axis indicates the <b>east</b> (when positive) or <b>west</b>
     *     (when negative) of the origin point {@code (0, 0, 0)}</li>
     *     <li>The z-axis indicates the <b>south</b> (when positive) or <b>north</b>
     *     (when negative) of the origin point {@code (0, 0, 0)}</li>
     * </ul>
     * <p>
     * These rules differ from traditional coordinate interpretations and
     * therefore may be unintuitive when a rotation of {@code 90} degrees will
     * instead rotate the coordinates {@code (1, 1, 1)} across the pivot
     * {@code (0, 0, 0)}
     * </p>
     *
     * @return The euler matrix that represents this rotation in the X-Z plane.
     */
    default Matrix4d toRotationMatrix() {
        final int cos = (int) Math.round(Math.cos(Math.toRadians(-this.angle().degrees())));
        final int sin = (int) Math.round(Math.sin(Math.toRadians(-this.angle().degrees())));
        return Matrix4d.from(
            cos, 0, sin, 0,
            0, 1, 0, 0,
            -sin, 0, cos, 0,
            0, 0, 0, 1
        );
    }

}

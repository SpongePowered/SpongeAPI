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
package org.spongepowered.api.entity;

import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.matrix.Matrix4d;
import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

/**
 * Represents the immutable world attributes of an {@link Entity}. Comprised of
 * a {@link Location} and two {@link Vector3d} representing the rotation and the
 * scale. The implementation may internally use a location or a separate world
 * and position. Be wary that calling {@link #getLocation()} could result in
 * object creation.
 *
 * <p>A transform might not have a world if it is invalid. In this case all
 * methods which return a reference to it will throw
 * {@link IllegalStateException}.</p>
 *
 * <p>This is an entity transform, not a model one. These values are subject to
 * interpretation by the implementation and may trigger animations depending on
 * the target model.</p>
 *
 * <p>Even though Minecraft doesn't currently support entity scales it is part
 * of the transform in case it gets added later. For now this return
 * {@link Vector3d#ONE}.</p>
 */
public interface Transform {

    static Transform of(World world) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(Location.of(world, Vector3d.ZERO), Vector3d.ZERO, Vector3d.ONE);
    }

    static Transform of(Location location) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(location, Vector3d.ZERO, Vector3d.ONE);
    }

    static Transform of(World world, Vector3d position) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(Location.of(world, position), Vector3d.ZERO, Vector3d.ONE);
    }

    static Transform of(World world, Vector3d position, Vector3d rotation) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(Location.of(world, position), rotation, Vector3d.ONE);
    }

    static Transform of(Location location, Vector3d rotation, Vector3d scale) {
        return Sponge.getRegistry().requireFactory(Factory.class).create(location, rotation, scale);
    }

    /**
     * Returns if this {@link Transform} is still valid.
     *
     * <p>Examples of invalid Transforms are:</p>
     *
     * <ul>
     *     <li>A Transform without an {@link World}</li>
     *     <li>A Transform whose {@link World} object is no longer present</li>
     *     <li>A Transform whose coordinates are illegal (defined by the
     *     implementation)</li>
     * </ul>
     *
     * @return True if valid, false if not
     */
    boolean isValid();

    /**
     * Gets the {@link Location} this transform contains. This is the position
     * and the world.
     *
     * @return The location
     * @throws IllegalStateException If the transform doesn't have a world
     */
    Location getLocation();

    /**
     * Creates a copy of this transform and sets the {@link Location}.
     *
     * @param location The new location
     * @return A new transform
     */
    Transform withLocation(Location location);

    /**
     * Gets the {@link World}.
     *
     * @return The world
     * @throws IllegalStateException If the transform doesn't have a world
     */
    World getWorld();

    /**
     * Creates a copy of this transform and sets the {@link World}.
     *
     * @param world The new world
     * @return A new transform
     */
    Transform withWorld(World world);

    /**
     * Gets the coordinates of this transform.
     *
     * @return The coordinates
     */
    Vector3d getPosition();

    /**
     * Creates a copy of this transform while setting the position of the new
     * one.
     *
     * @param position The position
     * @return A new transform
     */
    Transform withPosition(Vector3d position);

    /**
     * Gets the rotation of this transform, as a {@link Vector3d}.
     *
     * <p>The format of the rotation is represented by:</p>
     * <ul>
     *     <li><code>x -> pitch</code></li>
     *     <li><code>y -> yaw</code></li>
     *     <li><code>z -> roll</code></li>
     * </ul>
     *
     * @return The rotation vector
     */
    Vector3d getRotation();

    /**
     * Creates a copy of this transform and sets the rotation as a quaternion.
     *
     * <p>Quaternions are objectively better than the Euler angles preferred by
     * Minecraft. This is for compatibility with the flow-math library.</p>
     *
     * @param rotation The new rotation
     * @return A new transform
     */
    Transform withRotation(Vector3d rotation);

    /**
     * Creates a copy of this transform and sets the rotation.
     *
     * <p>The format of the rotation is represented by:</p>
     * <ul>
     *     <li><code>x -> pitch</code></li>
     *     <li><code>y -> yaw</code></li>
     *     <li><code>z -> roll</code></li>
     * </ul>
     *
     * @param rotation The new rotation
     * @return A new transform
     */
    Transform withRotation(Quaterniond rotation);

    /**
     * Returns the rotation as a quaternion.
     *
     * <p>Quaternions are objectively better than the Euler angles preferred by
     * Minecraft. This is for compatibility with the flow-math library.</p>
     *
     * @return The rotation
     */
    Quaterniond getRotationAsQuaternion();

    /**
     * Gets the pitch component of this transform rotation.
     *
     * @return The pitch
     */
    double getPitch();

    /**
     * Gets the yaw component of this transform rotation.
     *
     * @return The yaw
     */
    double getYaw();

    /**
     * Gets the roll component of this transform rotation.
     *
     * @return The roll
     */
    double getRoll();

    /**
     * Gets the scale of the transform for each axis.
     *
     * @return The scale
     */
    Vector3d getScale();

    /**
     * Creates a copy of this transform and sets the scale for each axis.
     *
     * @param scale The scale
     * @return A new transform
     */
    Transform withScale(Vector3d scale);

    /**
     * "Adds" another transform to this one. This is equivalent to adding the
     * translation, rotation and scale individually.
     *
     * <p>Returns the results as a new copy.</p>
     *
     * @param other The transform to add
     * @return A new transform
     */
    Transform add(Transform other);

    /**
     * Adds a translation to this transform.
     *
     * <p>Returns the results as a new copy.</p>
     *
     * @param translation The translation to add
     * @return A new transform
     */
    Transform translate(Vector3d translation);

    /**
     * Adds a rotation to this transform. Returns the results as a new copy.
     *
     * @param rotation The rotation to add
     * @return A new transform
     */
    Transform rotate(Vector3d rotation);

    /**
     * Adds a rotation to this transform.
     *
     * <p>Quaternions are objectively better than the Euler angles preferred by
     * Minecraft. This is the preferred method when dealing with rotation
     * additions. This is for compatibility with the flow-math library.</p>
     *
     * <p>Returns the results as a new copy.</p>
     *
     * @param rotation The rotation to add
     * @return A new transform
     */
    Transform rotate(Quaterniond rotation);

    /**
     * "Adds" a scale to this transform. Scales are multiplicative, so this
     * actually multiplies the current scale.
     *
     * <p>Returns the results as a new copy.</p>
     *
     * @param scale The scale to add
     * @return A new transform
     */
    Transform scale(Vector3d scale);

    /**
     * Returns a matrix representation of this transform.
     *
     * <p>This includes the position, rotation and scale. To apply the transform
     * to a vector, use the following:</p>
     *
     * <blockquote><code>Vector3d original = ...;<br />
     * Transform transform = ...;<br /><br />
     * Vector3d transformed =
     * transform.toMatrix().transform(original.toVector4(1)).toVector3();<br />
     * }</code></blockquote>
     *
     * <p>This converts the original 3D vector to 4D by appending 1 as the w
     * coordinate, applies the transformation, then converts it back to 3D by
     * dropping the w coordinate.</p>
     *
     * <p>Using a 4D matrix and a w coordinate with value 1 is what allows for
     * the position to be included in the transformation applied by the matrix.
     * </p>
     *
     * @return The transform as a matrix
     */
    Matrix4d toMatrix();

    interface Factory {
        Transform create(Location location, Vector3d rotation, Vector3d scale);
    }
}

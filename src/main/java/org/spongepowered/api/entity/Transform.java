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

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.matrix.Matrix4d;
import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.MoreObjects;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import javax.annotation.Nullable;

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
public final class Transform {

    private final World world;
    private final Vector3d position;
    private final Vector3d rotation;
    private final Vector3d scale;
    @Nullable private Location location = null;
    @Nullable private Quaterniond rotationQuaternion = null;

    /**
     * Creates a new {@link Transform} based on the provided {@link Location}.
     *
     * @param location The provided location that provides the
     *     world, and position
     */
    public Transform(Location location) {
        this(location.getWorld(), location.getPosition());
    }

    /**
     * Creates a new {@link Transform} with the provided {@link World world}.
     * The default position is {@link Vector3d#ZERO}.
     *
     * @param world The world to use
     */
    public Transform(World world) {
        this(world, Vector3d.ZERO);
    }

    /**
     * Creates a new {@link Transform} with the provided {@link World world}
     * and {@link Vector3d position}.
     *
     * @param world The world to use
     * @param position The position to use
     */
    public Transform(World world, Vector3d position) {
        this(world, position, Vector3d.ZERO);
    }

    /**
     * Creates a new {@link Transform} with the provided {@link World world},
     * {@link Vector3d position}, and {@link Vector3d rotation}.
     *
     * @param world The world to use
     * @param position The position to use
     * @param rotation The rotation to use
     */
    public Transform(World world, Vector3d position, Vector3d rotation) {
        this(world, position, rotation, Vector3d.ONE);
    }

    /**
     * Creates a new {@link Transform} with the provided {@link Location},
     * {@link Vector3d rotation}, and {@link Vector3d scale}.
     *
     * @param location The location to use, providing the world and position
     * @param rotation The rotation to use
     * @param scale The scale to use
     */
    public Transform(Location location, Vector3d rotation, Vector3d scale) {
        this(location.getWorld(), location.getPosition(), rotation, scale);
    }

    /**
     * Creates a new {@link Transform}.
     *
     * @param world The world to use
     * @param position The position to use
     * @param rotation The rotation to use
     * @param scale The scale to use
     */
    public Transform(World world, Vector3d position, Vector3d rotation, Vector3d scale) {
        this.world = checkNotNull(world, "world");
        this.position = checkNotNull(position, "position");
        this.rotation = checkNotNull(rotation, "rotation");
        this.scale = checkNotNull(scale, "scale");
    }

    /**
     * Gets the {@link Location} this transform contains. This is the position
     * and the world.
     *
     * @return The location
     * @throws IllegalStateException If the transform doesn't have a world
     */
    public Location getLocation() {
        if (this.location == null) {
            this.location = new Location(this.world, this.position);
        }
        return this.location;
    }

    /**
     * Creates a copy of this transform and sets the {@link Location}. This sets
     * both the position and the world.
     *
     * @param location The new location
     * @return A new transform
     */
    public Transform setLocation(Location location) {
        checkNotNull(location, "location");
        return new Transform(location, getRotation(), getScale());
    }

    /**
     * Gets the {@link World} this transform contains.
     *
     * <p>Note: This can be null if the {@link World} is unloaded and garbage
     * collected.</p>
     *
     * @return The world
     * @throws IllegalStateException If the transform doesn't have a world
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * Creates a copy of this transform and sets the {@link World}.
     *
     * @param world The new world
     * @return A new transform
     */
    public Transform setWorld(World world) {
        checkNotNull(world, "world");
        return new Transform(world, getPosition(), getRotation(), getScale());
    }

    /**
     * Gets the coordinates of this transform.
     *
     * @return The coordinates
     */
    public Vector3d getPosition() {
        return this.position;
    }

    /**
     * Creates a copy of this transform while setting the position of the new
     * one.
     *
     * @param position The position
     * @return A new transform
     */
    public Transform setPosition(Vector3d position) {
        checkNotNull(position, "position");
        return new Transform(getWorld(), position, getRotation(), getScale());
    }

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
    public Vector3d getRotation() {
        return this.rotation;
    }

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
    public Transform setRotation(Quaterniond rotation) {
        checkNotNull(rotation, "rotation");
        return setRotation(toAxesAngles(rotation));
    }

    /**
     * Creates a copy of this transform and sets the rotation as a quaternion.
     *
     * <p>Quaternions are objectively better than the Euler angles preferred by
     * Minecraft. This is for compatibility with the flow-math library.</p>
     *
     * @param rotation The new rotation
     * @return A new transform
     */
    public Transform setRotation(Vector3d rotation) {
        checkNotNull(rotation, "rotation");
        return new Transform(getWorld(), getPosition(), rotation, getScale());
    }

    /**
     * Returns the rotation as a quaternion.
     *
     * <p>Quaternions are objectively better than the Euler angles preferred by
     * Minecraft. This is for compatibility with the flow-math library.</p>
     *
     * @return The rotation
     */
    public Quaterniond getRotationAsQuaternion() {
        if (this.rotationQuaternion == null) {
            this.rotationQuaternion = fromAxesAngles(this.rotation);
        }
        return this.rotationQuaternion;
    }

    /**
     * Gets the pitch component of this transform rotation.
     *
     * @return The pitch
     */
    public double getPitch() {
        return this.rotation.getX();
    }

    /**
     * Gets the yaw component of this transform rotation.
     *
     * @return The yaw
     */
    public double getYaw() {
        return this.rotation.getY();
    }

    /**
     * Gets the roll component of this transform rotation.
     *
     * @return The roll
     */
    public double getRoll() {
        return this.rotation.getZ();
    }

    /**
     * Gets the scale of the transform for each axis.
     *
     * @return The scale
     */
    public Vector3d getScale() {
        return this.scale;
    }

    /**
     * Creates a copy of this transform and sets the scale for each axis.
     *
     * @param scale The scale
     * @return A new transform
     */
    public Transform setScale(Vector3d scale) {
        checkNotNull(scale, "scale");
        return new Transform(getWorld(), getPosition(), getRotation(), scale);
    }

    /**
     * "Adds" another transform to this one. This is equivalent to adding the
     * translation, rotation and scale individually.
     *
     * <p>Returns the results as a new copy.</p>
     *
     * @param other The transform to add
     * @return A new transform
     */
    public Transform add(Transform other) {
        checkNotNull(other, "other");
        return new Transform(
            getWorld(),
            getPosition().add(other.getPosition()),
            toAxesAngles(other.getRotationAsQuaternion().mul(getRotationAsQuaternion())),
            getScale().mul(other.getScale())
        );
    }

    /**
     * Adds a translation to this transform.
     *
     * <p>Returns the results as a new copy.</p>
     *
     * @param translation The translation to add
     * @return A new transform
     */
    public Transform addTranslation(Vector3d translation) {
        checkNotNull(translation, "translation");
        return new Transform(getWorld(), getPosition().add(translation), getRotation(), getScale());
    }

    /**
     * Adds a rotation to this transform. Returns the results as a new copy.
     *
     * @param rotation The rotation to add
     * @return A new transform
     */
    public Transform addRotation(Vector3d rotation) {
        checkNotNull(rotation, "rotation");
        return addRotation(fromAxesAngles(rotation));
    }

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
    public Transform addRotation(Quaterniond rotation) {
        checkNotNull(rotation, "rotation");
        return new Transform(getWorld(), getPosition(), toAxesAngles(rotation.mul(getRotationAsQuaternion())), getScale());
    }

    /**
     * "Adds" a scale to this transform. Scales are multiplicative, so this
     * actually multiplies the current scale.
     *
     * <p>Returns the results as a new copy.</p>
     *
     * @param scale The scale to add
     * @return A new transform
     */
    public Transform addScale(Vector3d scale) {
        checkNotNull(scale, "scale");
        return new Transform(getWorld(), getPosition(), getRotation(), getScale().mul(scale));
    }

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
    public Matrix4d toMatrix() {
        return Matrix4d.createScaling(getScale().toVector4(1)).rotate(getRotationAsQuaternion()).translate(getPosition());
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
    public boolean isValid() {
        return this.world.isLoaded();
    }

    @Override
    public int hashCode() {
        int result = this.world.hashCode();
        result = 31 * result + this.position.hashCode();
        result = 31 * result + this.rotation.hashCode();
        result = 31 * result + this.scale.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transform)) {
            return false;
        }
        final Transform otherTransform = (Transform) other;
        return otherTransform.world.equals(this.world) && otherTransform.getPosition().equals(getPosition())
            && otherTransform.getRotation().equals(getRotation()) && otherTransform.getScale().equals(getScale());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("location", getLocation())
            .add("rotation", this.rotation)
            .add("scale", this.scale)
            .toString();
    }

    private static Vector3d toAxesAngles(Quaterniond quaternion) {
        final Vector3d axesAngles = quaternion.getAxesAnglesDeg();
        return new Vector3d(axesAngles.getX(), -axesAngles.getY(), axesAngles.getZ());
    }

    private static Quaterniond fromAxesAngles(Vector3d angles) {
        return Quaterniond.fromAxesAnglesDeg(angles.getX(), -angles.getY(), angles.getZ());
    }

}

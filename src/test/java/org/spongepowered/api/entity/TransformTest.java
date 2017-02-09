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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

public class TransformTest {

    private static final double EPSILON = 4e-3;
    private Extent mockExtent1;
    private Extent mockExtent2;

    @Before
    public void generateMockExtent() {
        this.mockExtent1 = Mockito.when(Mockito.mock(Extent.class).isLoaded()).thenReturn(false).getMock();
        this.mockExtent2 = Mockito.when(Mockito.mock(Extent.class).isLoaded()).thenReturn(true).getMock();
    }

    @Test
    public void testLocation() {
        final Vector3d position1 = new Vector3d(1, 2, 3);
        final Vector3d position2 = new Vector3d(4, 5, 6);

        Transform<Extent> transform = new Transform<>(this.mockExtent1, position1);
        Assert.assertEquals(this.mockExtent1, transform.getExtent());
        assertEquals(position1, transform.getPosition());

        transform = transform.setLocation(new Location<>(this.mockExtent2, position2));
        Assert.assertEquals(this.mockExtent2, transform.getExtent());
        assertEquals(position2, transform.getPosition());

        transform = transform.setExtent(this.mockExtent1);
        Assert.assertEquals(this.mockExtent1, transform.getExtent());

        transform = transform.setPosition(position1);
        assertEquals(position1, transform.getPosition());

        transform = transform.addTranslation(position2);
        assertEquals(position1.add(position2), transform.getPosition());
    }

    @Test
    public void testRotation() {
        final Vector3d rotation1 = new Vector3d(20, 40, 60);
        final Quaterniond rotationQuat1 = Quaterniond.fromAxesAnglesDeg(rotation1.getX(), -rotation1.getY(), rotation1.getZ());
        final Vector3d rotation2 = new Vector3d(45, 135, 225);
        final Quaterniond rotationQuat2 = Quaterniond.fromAxesAnglesDeg(rotation2.getX(), -rotation2.getY(), rotation2.getZ());
        final Quaterniond rotationQuat1Plus2 = rotationQuat2.mul(rotationQuat1);
        final Vector3d axesAnglesDeg = rotationQuat1Plus2.getAxesAnglesDeg();
        final Vector3d rotation1Plus2 = new Vector3d(axesAnglesDeg.getX(), -axesAnglesDeg.getY(), axesAnglesDeg.getZ());

        Transform<Extent> transform = new Transform<>(this.mockExtent1, Vector3d.ZERO, rotation1);
        assertEquals(rotation1, transform.getRotation());
        assertEquals(rotationQuat1, transform.getRotationAsQuaternion());
        Assert.assertEquals(rotation1.getX(), transform.getPitch(), EPSILON);
        Assert.assertEquals(rotation1.getY(), transform.getYaw(), EPSILON);
        Assert.assertEquals(rotation1.getZ(), transform.getRoll(), EPSILON);

        transform = transform.addRotation(rotation2);
        assertEquals(rotationQuat1Plus2, transform.getRotationAsQuaternion());
        assertEquals(rotation1Plus2, transform.getRotation());
    }

    @Test
    public void testScale() {
        final Vector3d scale1 = new Vector3d(1, 2, 3);
        final Vector3d scale2 = new Vector3d(4, 5, 6);

        Transform<Extent> transform = new Transform<>(this.mockExtent1, Vector3d.ZERO, Vector3d.ZERO, scale1);
        assertEquals(scale1, transform.getScale());

        transform = transform.addScale(scale2);
        assertEquals(scale2.mul(scale1), transform.getScale());
    }

    @Test
    public void testValid() {
        Transform<Extent> transform = new Transform<>(this.mockExtent1);
        Assert.assertFalse(transform.isValid());
        transform = transform.setExtent(this.mockExtent2);
        Assert.assertTrue(transform.isValid());

        Assert.assertFalse(new Transform<>(this.mockExtent1).isValid());
        Assert.assertTrue(new Transform<>(this.mockExtent2).isValid());
    }

    @Test
    public void testMatrix() {
        final Vector3d position = new Vector3d(1, 2, 3);
        final Vector3d scale = new Vector3d(4, 5, 6);

        assertEquals(Matrix4d.createTranslation(position), new Transform<>(this.mockExtent1, position).toMatrix());
        assertEquals(
            new Matrix4d(
                4, 0, 0, 1,
                0, 5, 0, 2,
                0, 0, 6, 3,
                0, 0, 0, 1
            ), new Transform<>(this.mockExtent1, position, Vector3d.ZERO, scale).toMatrix());
    }

    @Test
    public void testTransformation() {
        final Vector3d position = new Vector3d(1, 2, 3);
        final Quaterniond rotation = Quaterniond.fromAngleDegAxis(90, Vector3d.UNIT_Y);
        final Vector3d scale = new Vector3d(4, 5, 6);

        Transform<Extent> transform = new Transform<>(this.mockExtent1, position);
        assertTransforms(new Vector3d(11, 12, 13), transform, new Vector3d(10, 10, 10));

        transform = transform.addScale(scale);
        assertTransforms(new Vector3d(41, 52, 63), transform, new Vector3d(10, 10, 10));

        transform = transform.addRotation(rotation);
        assertTransforms(new Vector3d(61, 52, -37), transform, new Vector3d(10, 10, 10));

        transform = transform.add(transform);
        assertTransforms(new Vector3d(-158, 254, -354), transform, new Vector3d(10, 10, 10));
    }

    private void assertTransforms(Vector3d expected, Transform<Extent> with, Vector3d original) {
        assertEquals(expected, with.toMatrix().transform(original.toVector4(1)).toVector3());
    }

    private void assertEquals(Vector3d expected, Vector3d actual) {
        Assert.assertEquals(expected.getX(), actual.getX(), EPSILON);
        Assert.assertEquals(expected.getY(), actual.getY(), EPSILON);
        Assert.assertEquals(expected.getZ(), actual.getZ(), EPSILON);
    }

    private void assertEquals(Quaterniond expected, Quaterniond actual) {
        // This works because we're only dealing with unit quaternions
        // See: https://gamedev.stackexchange.com/questions/75072/how-can-i-compare-two-quaternions-for-logical-equality
        Assert.assertEquals(1, Math.abs(expected.dot(actual)), EPSILON);
    }

    private void assertEquals(Matrix4d expected, Matrix4d actual) {
        Assert.assertEquals(expected.get(0, 0), actual.get(0, 0), EPSILON);
        Assert.assertEquals(expected.get(0, 1), actual.get(0, 1), EPSILON);
        Assert.assertEquals(expected.get(0, 2), actual.get(0, 2), EPSILON);
        Assert.assertEquals(expected.get(0, 3), actual.get(0, 3), EPSILON);
        Assert.assertEquals(expected.get(1, 0), actual.get(1, 0), EPSILON);
        Assert.assertEquals(expected.get(1, 1), actual.get(1, 1), EPSILON);
        Assert.assertEquals(expected.get(1, 2), actual.get(1, 2), EPSILON);
        Assert.assertEquals(expected.get(1, 3), actual.get(1, 3), EPSILON);
        Assert.assertEquals(expected.get(2, 0), actual.get(2, 0), EPSILON);
        Assert.assertEquals(expected.get(2, 1), actual.get(2, 1), EPSILON);
        Assert.assertEquals(expected.get(2, 2), actual.get(2, 2), EPSILON);
        Assert.assertEquals(expected.get(2, 3), actual.get(2, 3), EPSILON);
        Assert.assertEquals(expected.get(3, 0), actual.get(3, 0), EPSILON);
        Assert.assertEquals(expected.get(3, 1), actual.get(3, 1), EPSILON);
        Assert.assertEquals(expected.get(3, 2), actual.get(3, 2), EPSILON);
        Assert.assertEquals(expected.get(3, 3), actual.get(3, 3), EPSILON);
    }

}

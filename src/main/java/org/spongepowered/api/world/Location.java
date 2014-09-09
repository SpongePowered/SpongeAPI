/** This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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

package org.spongepowered.api.world;

/**
 * Represents a three-coordinate point on the {@link World}.
 *
 */
public final class Location implements Cloneable {

    private static final float DEFAULT_PITCH = 0; //TODO
    private static final float DEFAULT_YAW = 0; //TODO
    
    private World world;
    
    private double x;
    private double y;
    private double z;
    
    private float pitch;
    private float yaw;
    
    public Location(final World world, final double x, final double y, final double z) {
        this(world, x, y, z, DEFAULT_PITCH, DEFAULT_YAW);
    }
    
    public Location(final World world, final double x, final double y, final double z, final float pitch, final float yaw) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }
    
    /**
     * Gets the x-coordinate of this location.
     *
     * @return The x-coordinate
     */
    public double getX() {
        return x;
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(final double y) {
        this.y = y;
    }
    
    public double getZ() {
        return z;
    }
    
    public void setZ(final double z) {
        this.z = z;
    }
    
    public float getPitch() {
        return pitch;
    }
    
    public void setPitch(final float pitch) {
        this.pitch = pitch;
    }
    
    public float getYaw() {
        return yaw;
    }
    
    public void setYaw(final float yaw) {
        this.yaw = yaw;
    }
    
    @Override
    public Object clone() {
        return new Location(world, x, y, z, pitch, yaw);
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Location)) {
            return false;
        }
        
        final Location location = (Location) object;
        
        return location.toString().equals(toString());
    }

    @Override
    public String toString() {
        return "location={"
          + world.getName() 
          + ","
          + x
          + ","
          + y 
          + ","
          + z 
          + ","
          + pitch 
          + ","
          + yaw
          + "}";
    }
  
}

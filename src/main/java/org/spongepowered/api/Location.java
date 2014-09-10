/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
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
package org.spongepowered.api;

import org.spongepowered.api.block.Block;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.World;

/**
 * Stores a location in the world
 */
public class Location {

    //World location is in
    private World world;
    //x value
    private double x;
    //y value
    private double y;
    //z value
    private double z;

    public Location(World world, double x, double y, double z){
        this.world=world;
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public World getWorld(){
        return world;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public void setWorld(World world){
        this.world=world;
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }

    public void setZ(int z){
        this.z=z;
    }

    public int getBlockX(){
        return (int)Math.round(x);
    }

    public int getBlockY(){
        return (int)Math.round(y);
    }

    public int getBlockZ(){
        return (int)Math.round(z);
    }

    public Chunk getChunk(){
        return world.getChunk(getBlockX(), getBlockZ());
    }

    public Block getBlock(){
        return world.getBlock(getBlockX(), getBlockY(), getBlockZ());
    }
}

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

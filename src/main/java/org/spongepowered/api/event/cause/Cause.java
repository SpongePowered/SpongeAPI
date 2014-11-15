/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.event.cause;

import org.spongepowered.api.block.Block;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.reason.Reason;
import org.spongepowered.api.world.World;

import com.google.common.base.Optional;

/**
 * A cause represents the reason or initiator of an event.
 *
 * <p>For example, if a block of sand is placed where it drops, the block
 * of sand would create a falling sand entity, which then would place another
 * block of sand. The block place event for the final block of sand would have
 * the cause chain of the block of sand -&gt; falling sand entity.</p>
 *
 * <p>It is not possible to accurately the describe the chain of causes in
 * all scenarios so a best effort approach is generally acceptable. For
 * example, a player might press a lever, activating a complex Redstone
 * circuit, which would then launch TNT and cause the destruction of
 * some blocks, but tracing this event would be too complicated and thus
 * may not be attempted.</p>
 */
public class Cause {
    
    private Cause parent;
    private Reason reason; //Never, ever null!
    private Block block;
    private Entity entity;
    private World world;

    public Cause(Block block, Reason reason, Cause parent) {
        this.block = block;
        this.reason = reason;
        this.parent = parent;
    }
    
    public Cause(Block block, Reason reason) {
        this(block, reason, null);
    }
    
    public Cause(Block block) {
        this(block, Reason.UNKNOWN);
    }
    
    public Cause(Entity entity, Reason reason, Cause parent) {
        this.entity = entity;
        this.reason = reason;
        this.parent = parent;
    }
    
    public Cause(Entity entity, Reason reason) {
        this(entity, reason, null);
    }
    
    public Cause(Entity entity) {
        this(entity, Reason.UNKNOWN);
    }
    
    public Cause(World world, Reason reason, Cause parent) {
        this.world = world;
        this.reason = reason;
        this.parent = parent;
    }
    
    public Cause(World world, Reason reason) {
        this(world, reason, null);
    }
    
    public Cause(World world) {
        this(world, Reason.UNKNOWN);
    }
    
    /**
     * Get the parent cause.
     *
     * @return The parent cause, if available
     */
    Optional<Cause> getParent() {
        return Optional.of(parent);
    }
    
    /**
     * Gets reason for cause.
     */
    Reason getReason() {
        return this.reason;
    }
    
    /**
     * Gets block associated with this cause.
     * @return Block, if available
     */
    Optional<Block> getBlock() {
        return Optional.of(block);
    }
    
    /**
     * Gets entity associated with this cause.
     * @return Entity, if available
     */
    Optional<Entity> getEntity() {
        return Optional.of(entity);
    }
    
    /**
     * Gets world associated with this cause. If world isn't directly
     * specified, world of entity or block will returned.
     * @return World, if available
     */
    Optional<World> getWorld() {
        if (world != null) {
            return Optional.of(this.world);
        } else {
            if (entity != null) {
                return entity.getWorld();
            } else if (block != null) {
                //Cast Extendt to World, should work always.
                return Optional.of((World) block.getLocation().getExtent());
            }
        }
        return Optional.of(world);
    }
}

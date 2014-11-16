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
package org.spongepowered.api.event.reason;

/**
 * Reason for certain event. There is static finals for vanilla reasons, but 
 * plugins can easily create their own ones.
 */
public class Reason {
    
    /**
     * We can't know what players are thinking, but that one did something.
     */
    public static final Reason PLAYER = new Reason("player").setVanilla(true);
    
    /**
     * Reason was explosion in a world.
     */
    public static final Reason EXPLOSION = new ExplosionReason().setVanilla(true);
    
    /**
     * Reason was natural decay.
     */
    public static final Reason DECAY = new Reason("decay").setVanilla(true);
    
    /**
     * Someone executed command.
     */
    public static final Reason COMMAND = new Reason("command").setVanilla(true);
    
    /**
     * Something grew and it caused something...
     */
    public static final Reason GROW = new Reason("grow").setVanilla(true);
    
    /**
     * Something or someone attacked something. Punching minecarts or boats
     * is attacking.
     */
    public static final Reason ATTACK = new Reason("attack").setVanilla(true);
    
    /**
     * Entity's AI caused it to do something.
     */
    public static final Reason ENTITY_AI = new Reason("ai").setVanilla(true);
    
    /**
     * Something unknown happened.
     */
    public static final Reason UNKNOWN = new Reason("unknown");
    
    /**
     * Fire was the reason. Usually this applies when something burns...
     */
    public static final Reason FIRE = new Reason("fire").setVanilla(true);
    
    private String name;
    private boolean isVanilla;
    
    /**
     * 
     * @param name Name of reason
     */
    public Reason(String name) {
        this.name = name;
        this.isVanilla = false; //Reasons created by plugins ARE NOT vanilla
    }
    
    /**
     * Gets name of this reason.
     * @return Name of this reason
     */
    public String getName() {
        return name;
    }
    
    /**
     * Checks is this reason used by vanilla Minecraft.
     * @return True if reason is used by vanilla Minecraft 
     */
    public boolean isVanilla() {
        return this.isVanilla;
    }
    
    protected Reason setVanilla(boolean isVanilla) {
        this.isVanilla = isVanilla;
        return this;
    }
    
    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Reason)) {
            return false;
        }
        
        if (((Reason) another).getName().equals(this.getName())) {
            return true;
        }
        
        return false;
    }
}

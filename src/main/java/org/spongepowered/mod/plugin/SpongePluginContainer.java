/**
 * This file is part of Sponge, licensed under the MIT License (MIT).
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
package org.spongepowered.mod.plugin;

import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.discovery.ModCandidate;
import cpw.mods.fml.common.event.FMLConstructionEvent;

import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.mod.SpongeMod;

import com.google.common.eventbus.Subscribe;

import java.util.Map;

public class SpongePluginContainer extends FMLModContainer implements PluginContainer {
    // DUMMY proxy class for FML to track
    public static class ProxyMod {
        
    }

    private final Map<String, Object> fmlDescriptor;

    public SpongePluginContainer(String className, ModCandidate container, Map<String, Object> modDescriptor) {
        // I suggest that you should be instantiating a proxy object, not the real plugin here.
        super("org.spongepowered.mod.plugin.SpongePluginContainer$ProxyMod", container, modDescriptor);
        this.fmlDescriptor = modDescriptor;
    }

    @Override
    public String getModId() {
        return (String) fmlDescriptor.get("id");
    }

    @Override
    public void bindMetadata(MetadataCollection mc) {
        super.bindMetadata(mc);
    }

    @Override
    public String getID() {
        return getModId();
    }

    @Override
    @Subscribe
    public void constructMod(FMLConstructionEvent event) {
        super.constructMod(event);
        SpongeMod.instance.registerPluginContainer(this, getID(), getInstance());
    }
    
    @Override
    public Object getInstance() {
        return getMod();
    }
}

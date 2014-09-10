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
package org.spongepowered.mod;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import cpw.mods.fml.common.event.*;
import org.objectweb.asm.Type;
import org.spongepowered.api.event.state.*;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.mod.plugin.SpongePluginContainer;

import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainerFactory;
import cpw.mods.fml.common.ModMetadata;

public class SpongeMod extends DummyModContainer {
    public static SpongeMod instance;
    private final SpongeGame game;

    private Map<Object, PluginContainer> plugins = Maps.newHashMap();
    private EventBus eventBus;
    private LoadController controller;
    // This is a special Mod, provided by the IFMLLoadingPlugin. It will be instantiated before FML scans the system
    // For mods (or plugins)
    public SpongeMod() {
        super(new ModMetadata());
        // Register our special instance creator with FML
        ModContainerFactory.instance().registerContainerType(Type.getType(Plugin.class), SpongePluginContainer.class);
        
        this.getMetadata().name = "SpongeAPIMod";
        this.getMetadata().modId = "SpongeAPIMod";
        SpongeMod.instance = this;
        game = new SpongeGame();
    }

    public void registerPluginContainer(SpongePluginContainer spongePluginContainer, String pluginId, Object proxyInstance) {
        plugins.put(proxyInstance, spongePluginContainer);
        game.getEventManager().register(spongePluginContainer);
    }

    public Collection<PluginContainer> getPlugins() {
        return Collections.unmodifiableCollection(plugins.values());
    }

    public PluginContainer getPlugin(String s) {
        Object proxy = Loader.instance().getIndexedModList().get(s);
        return plugins.get(proxy);
    }
    
    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        this.eventBus = bus;
        this.controller = controller;
        return true;
    }

    // We're not an FML mod, so we need to directly subscribe to the bus
    @Subscribe
    public void onEvent(FMLStateEvent event) {
        if (event instanceof FMLConstructionEvent) {
            game.getEventManager().call(new SpongeConstructionEvent(game));
        } else if (event instanceof FMLLoadCompleteEvent) {
            game.getEventManager().call(new SpongeLoadCompleteEvent(game));
        } else if (event instanceof FMLPreInitializationEvent) {
            game.getEventManager().call(new SpongePreInitializationEvent(game));
        } else if (event instanceof FMLInitializationEvent) {
            game.getEventManager().call(new SpongeInitializationEvent(game));
        } else if (event instanceof FMLPostInitializationEvent) {
            game.getEventManager().call(new SpongePostInitializationEvent(game));
        } else if (event instanceof FMLServerAboutToStartEvent) {
            game.getEventManager().call(new SpongeServerAboutToStartEvent(game));
        } else if (event instanceof FMLServerStartingEvent) {
            game.getEventManager().call(new SpongeServerStartingEvent(game));
        } else if (event instanceof FMLServerStartedEvent) {
            game.getEventManager().call(new SpongeServerStartedEvent(game));
        } else if (event instanceof FMLServerStoppingEvent) {
            game.getEventManager().call(new SpongeServerStoppingEvent(game));
        } else if (event instanceof FMLServerStoppedEvent) {
            game.getEventManager().call(new SpongeServerStoppedEvent(game));
        }
    }
}

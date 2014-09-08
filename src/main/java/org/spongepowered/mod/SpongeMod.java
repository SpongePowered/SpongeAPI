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

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import org.objectweb.asm.Type;
import org.spongepowered.api.event.state.SpongeServerAboutToStartEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.mod.plugin.SpongePluginContainer;

import com.google.common.collect.Maps;

public class SpongeMod extends DummyModContainer {
    public static SpongeMod instance;
    private final SpongeGame game;

    private Map<Object, PluginContainer> plugins = Maps.newHashMap();
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

    @Mod.EventHandler
    public void onServerStarting(FMLServerAboutToStartEvent event) {
        game.getEventManager().fire(new SpongeServerAboutToStartEvent(game));
    }
}

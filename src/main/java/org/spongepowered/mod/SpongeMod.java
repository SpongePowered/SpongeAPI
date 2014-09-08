package org.spongepowered.mod;

import java.util.Collection;
import java.util.Map;

import org.objectweb.asm.Type;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.mod.plugin.SpongePluginContainer;

import com.google.common.collect.Maps;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainerFactory;
import cpw.mods.fml.common.ModMetadata;

public class SpongeMod extends DummyModContainer {
    public static SpongeMod instance;

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
    }

    public void registerPluginContainer(SpongePluginContainer spongePluginContainer, String pluginId, Object proxyInstance) {
        plugins.put(proxyInstance, spongePluginContainer);
    }

    public Collection<PluginContainer> getPlugins() {
        return plugins.values();
    }

    public PluginContainer getPlugin(String s) {
        Object proxy = Loader.instance().getIndexedModList().get(s);
        return plugins.get(proxy);
    }
}

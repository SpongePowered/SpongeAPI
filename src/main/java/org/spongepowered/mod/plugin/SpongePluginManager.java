package org.spongepowered.mod.plugin;

import cpw.mods.fml.common.ModClassLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.mod.SpongeMod;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SpongePluginManager implements PluginManager {
    private final Game game;
    private final ModClassLoader classLoader;
    private final Set<PluginContainer> plugins = new HashSet<PluginContainer>();

    public SpongePluginManager(Game game) {
        this.game = game;
        classLoader = new ModClassLoader(getClass().getClassLoader());
    }

    @Override
    public PluginContainer getPlugin(String s) {
        return SpongeMod.instance.getPlugin(s);
    }

    @Override
    public Logger getLogger(PluginContainer pluginContainer) {
        return LogManager.getLogger(pluginContainer.getName());
    }

    @Override
    public Collection<PluginContainer> getPlugins() {
        return SpongeMod.instance.getPlugins();
    }
}

package org.spongepowered.mod.plugin;

import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.discovery.ModCandidate;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Map;

public class SpongePluginContainer extends FMLModContainer implements PluginContainer {
    public SpongePluginContainer(String className, ModCandidate container, Map<String, Object> modDescriptor) {
        super(className, container, modDescriptor);
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public Object getInstance() {
        return null;
    }
}

package org.spongepowered.mod.plugin;

import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.discovery.ModCandidate;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Map;

public class SpongePluginContainer extends FMLModContainer implements PluginContainer {
    private Map<String, Object> fmlDescriptor;

    public SpongePluginContainer(String className, ModCandidate container, Map<String, Object> modDescriptor) {
        // I suggest that you should be instantiating a proxy object, not the real plugin here.
        super(className, container, modDescriptor);
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
    public Object getInstance() {
        return null;
    }
}

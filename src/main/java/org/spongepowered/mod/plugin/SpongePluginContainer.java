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
    private Map<String, Object> fmlDescriptor;

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

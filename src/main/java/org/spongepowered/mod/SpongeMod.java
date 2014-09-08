package org.spongepowered.mod;

import org.objectweb.asm.Type;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.mod.plugin.SpongePluginContainer;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.ModContainerFactory;
import cpw.mods.fml.common.ModMetadata;

public class SpongeMod extends DummyModContainer {
    // This is a special Mod, provided by the IFMLLoadingPlugin. It will be instantiated before FML scans the system
    // For mods (or plugins)
    public SpongeMod() {
        super(new ModMetadata());
        // Register our special instance creator with FML
        ModContainerFactory.instance().registerContainerType(Type.getType(Plugin.class), SpongePluginContainer.class);
        
        this.getMetadata().name = "SpongeAPIMod";
        this.getMetadata().modId = "SpongeAPIMod";
    }
}

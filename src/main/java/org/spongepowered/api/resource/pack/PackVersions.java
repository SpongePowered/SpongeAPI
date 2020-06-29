package org.spongepowered.api.resource.pack;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

public class PackVersions {

    // SORTFIELDS:ON

    public static final Supplier<PackVersion> COMPATIBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PackVersion.class, "COMPATIBLE");

    public static final Supplier<PackVersion> TOO_NEW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PackVersion.class, "TOO_NEW");

    public static final Supplier<PackVersion> TOO_OLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PackVersion.class, "TOO_OLD");

    // SORTFIELDS:OFF

    private PackVersions() {
    }

}

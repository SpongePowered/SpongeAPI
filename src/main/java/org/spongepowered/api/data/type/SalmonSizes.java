package org.spongepowered.api.data.type;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryTypes;

public final class SalmonSizes {

    public static final DefaultedRegistryReference<SalmonSize> LARGE = SalmonSizes.key(ResourceKey.sponge("large"));

    public static final DefaultedRegistryReference<SalmonSize> MEDIUM = SalmonSizes.key(ResourceKey.sponge("medium"));

    public static final DefaultedRegistryReference<SalmonSize> SMALL = SalmonSizes.key(ResourceKey.sponge("small"));

    private static DefaultedRegistryReference<SalmonSize> key(ResourceKey key) {
        return RegistryKey.of(RegistryTypes.SALMON_SIZE, key).asDefaultedReference(Sponge::game);
    }
}

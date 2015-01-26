package org.spongepowered.api.resourcepack;

import com.google.common.base.Optional;

import java.io.FileNotFoundException;
import java.net.URL;

public final class ResourcePacks {

    public static final ResourcePackFactory factory = null;

    /**
     * Creates a {@link ResourcePack} from a URL and tries to download and hash
     * it.
     * 
     * @param url The URL to look in.
     * @return A ResourcePack with the specified URL.
     * @throws FileNotFoundException If a valid resourcepack could not be
     *             downloaded from the URL.
     */
    public static ResourcePack fromURL(URL url) throws FileNotFoundException {
        return factory.fromURL(url);
    }

    /**
     * Creates a {@link ResourcePack} from a URL.
     * 
     * @param url The URL to look in.
     * @return A ResourcePack with the specified URL.
     */
    public static ResourcePack fromURLUnchecked(URL url) {
        return factory.fromURLUnchecked(url);
    }

    /**
     * Gets a {@link ResourcePack} that's already been created by it's ID.
     * 
     * @param id The ID of the pack.
     * @return The ResourcePack with the specified ID, or Optional.absent() if
     *         none could be found.
     */
    public static Optional<ResourcePack> getByID(String id) {
        return factory.getByID(id);
    }

}

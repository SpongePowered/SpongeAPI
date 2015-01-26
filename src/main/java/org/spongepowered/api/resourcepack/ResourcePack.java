package org.spongepowered.api.resourcepack;

import com.google.common.base.Optional;

import java.net.URL;

public interface ResourcePack {

    /**
     * Gets the URL associated with this ResourcePack.
     * 
     * @return The URL associated with this ResourcePack
     */
    URL getURL();

    /**
     * Gets the name of this resource pack. This is the filename of the pack
     * zipfile, with all non-word characters removed. Note to implementers: The
     * name <strong>MUST</strong> be calculated like above, or this API will not
     * work.
     * 
     * @return The name of this resource pack. This is the filename of the pack
     *         .zip, with all non-word characters removed
     */
    String getName();

    /**
     * Gets the ID of this resource pack.
     * 
     * @return the ID of this resource pack
     */
    String getId();

    /**
     * If this resource pack was initialized through
     * {@link ResourcePackFactory#fromURL(URL)}, the hash, as calculated with
     * <code>com.google.common.hash.Hashing.sha1().hashBytes(com.google.common.io.Files.toByteArray(resourcepackfile)).toString();</code>
     * 
     * @return The hash of this pack, if present.
     */
    Optional<String> getHash();

}

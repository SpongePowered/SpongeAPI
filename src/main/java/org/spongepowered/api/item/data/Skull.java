package org.spongepowered.api.item.data;

import com.google.common.base.Optional;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Nullable;

public interface Skull extends ItemBlockData {

    Optional<UUID> getOwnerId();

    void setOwnerId(@Nullable UUID id);

    boolean isSigned();

    Optional<Date> getTimestamp();

    void setTimestamp(@Nullable Date timestamp);

    String getOwnerName();

    void setOwnerName(String name);

    boolean isPublic();

    void setPublic(boolean isPublic);

    URL getSkinTexture();

    void setSkinTexture(URL location);

    Optional<URL> getCapeTexture();

    void setCapeTexture(URL location);

}

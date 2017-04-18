package org.spongepowered.api.entity.living.player;

import org.spongepowered.api.entity.living.player.tab.TabListEntry;

import java.util.Optional;

/**
 * Created by Matthew on 4/18/2017.
 */
public interface ClientPlayer extends BasePlayer {

    Optional<TabListEntry> getPlayerInfo();

}

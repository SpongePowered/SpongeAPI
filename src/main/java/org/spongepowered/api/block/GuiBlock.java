package org.spongepowered.api.block;

import org.spongepowered.api.entity.Player;

/**
 * A block that may contain a GUI when interacted with it.
 */
public interface GuiBlock extends Block {

    /**
     * An array of all players watching the command block interface
     * @return an array off all players viewing the command interface
     */
    Player[] getViewers();
}

package org.spongepowered.api;

/**
 * Actions a player can do
 */
public enum  Action {

    /**
     * Right clicking a block
     */
    RIGHT_CLICK_BLOCK,

    /**
     * Right clicking the air
     */
    RIGHT_CLICK_AIR,

    /**
     * Left clicking a block
     */
    LEFT_CLICK_BLOCK,

    /**
     * Left clicking the air
     */
    LEFT_CLICK_AIR,
    /**
     * Interacting with a block in a way not listed above:
     * Examples:
     * -Jumping on farmland
     * -Triggering tripwire
     * -Standing on pressure plate
     * -Causing redstone ore to light up
     */
    INTERACT;
}

package org.spongepowered.api.item;

public interface Item {
    /**
     * Gets the id of this item.
     *
     * Ex. Minecraft registers a golden carrot as "minecraft:golden_carrot"
     * @return The id
     */
    String getID();
}

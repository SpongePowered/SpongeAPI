package org.spongepowered.api.data.property.item;

import org.spongepowered.api.data.property.BooleanProperty;

/**
 * Represents an item that can be smelted in a furnace
 */
public class SmeltableProperty extends BooleanProperty {

    /**
     * Creates a new {@link SmeltableProperty}
     *
     * @param value Whether the item is smeltable, or not.
     */
    public SmeltableProperty(boolean value) {
        super(value);
    }

    /**
     * Creates a new {@link SmeltableProperty}
     *
     * @param value Whether the item is smeltable, or not.
     * @param operator The operator to use to compare against other properties.
     */
    public SmeltableProperty(boolean value, Operator operator) {
        super(value, operator);
    }

    /**
     * Creates a new {@link SmeltableProperty}
     *
     * @param value Whether the item is smeltable, or not.
     * @param operator The operator to use to compare against other properties.
     */
    public SmeltableProperty(Object value, Operator operator) {
        super(value, operator);
    }
}

package org.spongepowered.api.attributes;

public interface Operation {

    /**
     * Returns the value of an Attribute after it has been operated upon.
     * 
     * @param base The base value of the Attribute.
     * @param modifier The modifier to modify the Attribute with.
     * @param currentValue The current value of the Attribute.
     * @return The value of an Attribute after it has been operated upon.
     */
    double modify(double base, double modifier, double currentValue);

}

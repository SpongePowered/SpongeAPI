package org.spongepowered.api.attributes;

public interface AttributeModifierBuilder {

    /**
     * Sets the {@link Attribute} of the {@link AttributeModifier} to be built.
     * 
     * @param attribute The Attribute to use.
     * @return This builder, for chaining.
     */
    AttributeModifierBuilder attribute(Attribute attribute);

    /**
     * Sets the value of the {@link AttributeModifier} to be built.
     * 
     * @param value The value to use.
     * @return This builder, for chaining.
     * @throws IllegalArgumentException If the value is under the minimum or
     *         above the maximum of the attribute.
     */
    AttributeModifierBuilder value(double value) throws IllegalArgumentException;

    /**
     * Sets the {@link Operation} of the {@link AttributeModifier} to be built.
     * 
     * @param operation The Operation to use.
     * @return This builder, for chaining.
     */
    AttributeModifierBuilder operation(Operation operation);

    /**
     * Builds the {@link AttributeModifier} with the set parameters.
     * 
     * @return The AttributeModifier with the set parameters.
     */
    AttributeModifier build();

}

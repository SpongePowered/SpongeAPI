package org.spongepowered.api.attribute;

import com.google.common.base.Predicate;
import org.spongepowered.api.text.message.Message;

/**
 * A builder for plugins to create custom {@link Attribute}s.
 */
public interface AttributeBuilder {

    /**
     * Sets the id of the {@link Attribute} to be built.
     * 
     * @param id The id to use
     * @return This builder, for chaining
     */
    AttributeBuilder id(String id);

    /**
     * Sets the minimum value of the {@link Attribute} to be built.
     * 
     * @param minimum The value to use
     * @return This builder, for chaining
     */
    AttributeBuilder minimum(double minimum);

    /**
     * Sets the maximum value of the {@link Attribute} to be built.
     * 
     * @param maximum The value to use
     * @return This builder, for chaining
     */
    AttributeBuilder maximum(double maximum);

    /**
     * Sets the default value of the {@link Attribute} to be built.
     * 
     * @param defaultValue The value to use
     * @return This builder, for chaining
     */
    AttributeBuilder defaultValue(double defaultValue);

    /**
     * Sets the targets of the {@link Attribute} to be built.
     * 
     * @param targets A predicate to validate targets
     * @return This builder, for chaining
     */
    AttributeBuilder targets(Predicate<AttributeHolder> targets);
    
    /**
     * Sets the name of the {@link Attribute} to be built.
     * 
     * @param name The name to use
     * @return This builder, for chaining
     */
    AttributeBuilder name(Message name);
    
    /**
     * Builds the {@link Attribute} with the set parameters.
     *
     * @return The Attribute with the set parameters
     */
    Attribute build();

    /**
     * Resets this builder, to be used again.
     * 
     * @return This builder, for chaining
     */
    AttributeBuilder reset();

}

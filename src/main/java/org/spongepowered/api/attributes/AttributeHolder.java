package org.spongepowered.api.attributes;

import com.google.common.base.Optional;

import java.util.Collection;
import java.util.List;

public interface AttributeHolder {

    /**
     * Calculates the value of a certain {@link Attribute} on this holder.
     * 
     * @param attribute The Attribute to find the value of.
     * @return The value of a certain Attribute on this holder, or
     *         Optional.absent() if the attribute is not applicable.
     */
    Optional<Double> getAttributeValue(Attribute attribute);

    /**
     * Sets the base value of a certain {@link Attribute} on this holder.
     * 
     * @param attribute The Attribute to set the base value of.
     * @param base The new base value.
     * @throws IllegalArgumentException If the base value exceeds the maximum or
     *         is below the minimum of the {@link Attribute}.
     */
    void setBase(Attribute attribute, double base) throws IllegalArgumentException;

    /**
     * Gets the base value of a certain {@link Attribute} on this holder.
     * 
     * @param attribute The attribute to get the base value of.
     * @return The base value of a certain Attribute on this holder.
     */
    double getBase(Attribute attribute);

    /**
     * Gets a list of all applied modifiers.
     * 
     * @return A list of all applied modifiers.
     */
    List<AttributeModifier> getAllModifiers();

    /**
     * Adds a {@link AttributeModifier} to this holder.
     * 
     * @param modifier The AttributeModifier to add.
     * @throws IllegalArgumentException If the AttributeModifier's
     *         {@link Attribute}'s {@link AttributeTarget} cannot apply to this
     *         holder.
     */
    void addModifier(AttributeModifier modifier) throws IllegalArgumentException;

    /**
     * Adds multiple {@link AttributeModifier} to this holder.
     * 
     * @param modifiers The AttributeModifiers to add.
     * @throws IllegalArgumentException If any of the AttributeModifiers'
     *         {@link Attribute}s' {@link AttributeTarget}s' cannot apply to
     *         this holder.
     */
    void addModifiers(Collection<AttributeModifier> modifiers) throws IllegalArgumentException;

    /**
     * Gets all {@link AttributeModifiers} that apply to a certain
     * {@link Attribute}.
     * 
     * @param attribute The attribute to find modifiers of.
     * @return All AttributeModifiers that apply to a certain Attribute.
     */
    List<AttributeModifier> getModifiersFor(Attribute attribute);

    /**
     * Removes a {@link AttributeModifiers} from this holder.
     * 
     * @param modifier The AttributeModifier to remove.
     */
    void removeModifier(AttributeModifier modifier);

}

package org.spongepowered.api.attribute;


public interface MutableAttributeSource extends AttributeSource {

    /**
     * Adds a {@link AttributeModifier} to this ItemStack.
     *
     * @param modifier The AttributeModifier to add to this ItemStack
     */
    void addAttributeModifier(AttributeModifier modifier);

    /**
     * Removes a {@link AttributeModifier} from this ItemStack.
     *
     * @param modifier The AttributeModifier to remove from this ItemStack
     */
    void removeAttributeModifier(AttributeModifier modifier);

}

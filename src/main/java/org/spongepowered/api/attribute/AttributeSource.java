package org.spongepowered.api.attribute;

import java.util.Collection;


public interface AttributeSource {

    /**
     * Gets all {@link AttributeModifier}s on this ItemStack.
     *
     * @return All AttributeModifiers on this ItemStack
     */
    Collection<AttributeModifier> getAttributeModifiers();


}

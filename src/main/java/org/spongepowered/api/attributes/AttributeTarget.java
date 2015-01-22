package org.spongepowered.api.attributes;

public interface AttributeTarget {

    /**
     * If this attribute target can apply to the specified
     * {@link AttributeHolder}.
     * 
     * @param holder The AttributeHolder to check with.
     * @return If this attribute target can apply to the specified
     *         AttributeHolder.
     */
    boolean canApply(AttributeHolder holder);

}

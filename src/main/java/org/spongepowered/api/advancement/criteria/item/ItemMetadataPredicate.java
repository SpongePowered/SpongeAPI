package org.spongepowered.api.advancement.criteria.item;

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

public interface ItemMetadataPredicate {

    boolean matches(ItemStack stack);

    boolean matches(ItemStackSnapshot snapshot);

}

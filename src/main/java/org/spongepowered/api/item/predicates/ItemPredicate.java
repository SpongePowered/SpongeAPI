package org.spongepowered.api.item.predicates;

import org.spongepowered.api.advancement.criteria.numerical.NumericalBounds;
import org.spongepowered.api.data.value.WeightedCollectionValue;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.weighted.VariableAmount;

import java.util.function.Predicate;

public interface ItemPredicate extends Predicate<ItemStack> {

    boolean matches(ItemStack stack);

    interface Builder {

        Builder items(Iterable<RegistryReference<ItemType>> items);

        Builder counts(NumericalBounds.Ints count);

        ItemPredicate build();
    }

}

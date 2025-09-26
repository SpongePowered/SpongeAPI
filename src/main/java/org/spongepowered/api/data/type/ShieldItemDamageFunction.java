package org.spongepowered.api.data.type;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Defines the amount of {@link org.spongepowered.api.data.Keys#ITEM_DURABILITY} damage a shield-like
 * {@link org.spongepowered.api.item.inventory.ItemStack} takes, when blocking an attack.
 * The final amount of damage will be {@code constantDamage + fractionalDamage * attackDamage}
 */
public interface ShieldItemDamageFunction {

    /**
     * Returns the minimum amount of damage blocked attack must have had, for the item to take damage at all.
     *
     * @return minimum attack damage required for any durability loss
     */
    double minAttackDamage();

    /**
     * Returns the constant amount of damage taken.
     *
     * @return a constant amount of damage to take
     */
    double constantDamage();

    /**
     * Returns fractional amount of damage to take, where a factor of 1 means that the amount of durability lost is equal to attack damage,
     * and a factor of 0 that no durability is lost.
     *
     * @return fractional amount of damage to take
     */
    double fractionalDamage();

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    interface Builder extends ResettableBuilder<ShieldItemDamageFunction, Builder> {

        Builder minAttackDamage(double minDamage);

        Builder constantDamage(double constantDamage);

        Builder fractionalDamage(double fractionalDamage);

        ShieldItemDamageFunction build();

    }

}

package org.spongepowered.api.data.type;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.tag.Tag;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;
import java.util.Set;

/**
 * Defines the amount of damage reduced when blocking with a shield-like {@link org.spongepowered.api.item.inventory.ItemStack}.
 * The final amount of blocked damage will be {@code constantReduction + fractionalReduction * damage}
 */
public interface ShieldDamageReduction {

    /**
     * Returns the {@link DamageType damage types} this reduction applies to.
     * {@link Optional#empty()} means this reduction is not restricted to any given damage type.
     *
     * @return the affected damage types
     */
    Optional<Set<DamageType>> damageTypes();

    /**
     * Returns the maximum angle between the users facing direction and the direction of the incoming attack.
     *
     * @return the maximum angle
     */
    double horizontalBlockingAngle();

    /**
     * Returns the constant amount of damage to be blocked.
     *
     * @return a constant amount of damage to block
     */
    double constantReduction();

    /**
     * Returns fractional amount of damage to block, where a factor of 1 means that all damage is blocked,
     * and a factor of 0 that no damage is blocked.
     *
     * @return fractional amount of damage to block
     */
    double fractionalReduction();

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    interface Builder extends ResettableBuilder<ShieldDamageReduction, Builder> {

        Builder damageTypes(Set<DamageType> damageTypes);

        Builder damageTypes(Tag<DamageType> tag);

        Builder horizontalBlockingAngle(double angle);

        Builder constantReduction(double constant);

        Builder fractionalReduction(double fraction);

        ShieldDamageReduction build();

    }

}

package org.spongepowered.api.service.economy.account;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.economy.EconomyService;

import java.util.function.Supplier;

/**
 * A catalog of various {@link AccountType account types}.
 *
 * <p>An implementor of the {@link EconomyService} may provide other types,
 * but must at least register the {@link #DEFAULT} account type.</p>
 * @see AccountType
 */
public final class AccountTypes {

    // SORTFIELDS:ON

    /**
     * The default account type which will be used when none is specified.
     *
     * <p>Implementors of the {@link EconomyService} must register at least
     * this type, even if it is simply a duplicate/reference to another type.</p>
     */
    public static final Supplier<AccountType> DEFAULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountType.class, "ACCOUNT");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private AccountTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}

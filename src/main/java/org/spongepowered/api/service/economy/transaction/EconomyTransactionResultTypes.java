package org.spongepowered.api.service.economy.transaction;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

public final class EconomyTransactionResultTypes {

    // SORTFIELDS:ON

    public static final Supplier<EconomyTransactionResultType> ACCOUNT_NO_FUNDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "ACCOUNT_NO_FUNDS");

    public static final Supplier<EconomyTransactionResultType> ACCOUNT_NO_SPACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "ACCOUNT_NO_SPACE");

    public static final Supplier<EconomyTransactionResultType> CONTEXT_MISMATCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "CONTEXT_MISMATCH");

    public static final Supplier<EconomyTransactionResultType> FAILED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "FAILED");

    public static final Supplier<EconomyTransactionResultType> SUCCESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EconomyTransactionResultType.class, "SUCCESS");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private EconomyTransactionResultTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}

package org.spongepowered.api.service.economy.account;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * A catalog of different {@link AccountDeletionResult deletion results} that
 * could occur when deleting an {@link Account}.
 *
 * <p>The following must be registered by Sponge implementations, but
 * economy service implementors can implement their own as well.</p>
 *
 * @see AccountDeletionResult
 */
public final class AccountDeletionResults {

    // SORTFIELDS:ON

    /**
     * Specifies that the account did not exist when attempting deletion.
     */
    public static final Supplier<AccountDeletionResult> ABSENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "ABSENT");

    /**
     * Specifies that the account could not be deleted.
     */
    public static final Supplier<AccountDeletionResult> FAILED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "FAILED");

    /**
     * Specifies that the account was successfully deleted.
     */
    public static final Supplier<AccountDeletionResult> SUCCESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "SUCCESS");

    /**
     * Specifies that account is indelible, possibly due to being
     * a server account or necessary for plugin functionality.
     */
    public static final Supplier<AccountDeletionResult> UNDELETABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "UNDELETABLE");

    /**
     * If deletion is not supported by the economy service in general
     * or for this specific account.
     *
     * <p>This is better used only if your economy service does not support
     * deleting any type of economy accounts. More specific result types
     * would fit other cases better.</p>
     */
    public static final Supplier<AccountDeletionResult> UNSUPPORTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(AccountDeletionResult.class, "UNSUPPORTED");

    // SORTFIELDS:OFF

    private AccountDeletionResults() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}

package org.spongepowered.api.event.economy;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.service.economy.account.Account;

/**
 * Represents when an economy account is being deleted through the
 * {@link org.spongepowered.api.service.economy.EconomyService}.
 */
public interface DeleteAccountEvent extends Event, Cancellable {

    /**
     * The account that is set to be deleted.
     *
     * @return The account to be deleted
     */
    Account getAccount();

}

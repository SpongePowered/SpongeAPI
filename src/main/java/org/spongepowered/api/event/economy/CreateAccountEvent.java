package org.spongepowered.api.event.economy;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.service.economy.account.AccountType;
import org.spongepowered.api.text.Text;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents the creation of a new economy account
 * by the {@link EconomyService}.
 */
public interface CreateAccountEvent extends Event {

    /**
     * Fires before the new {@link Account} is created.
     */
    interface Pre extends CreateAccountEvent, Cancellable {

        /**
         * Gets the {@link UUID} that will be used by the account.
         *
         * @return The unique ID that will be used
         */
        UUID getUniqueId();

        /**
         * Gets the display name for this account.
         *
         * <p>This should be used by plugins to get a human-readable name for an
         * account.</p>
         *
         * <p>Its contents are dependent on the provider of the
         * {@link EconomyService}. For example, an economy plugin could allow
         * players to configure the display name of their account.</p>.
         *
         * @return The display name for this account
         */
        Text getDisplayName();

        /**
         * Gets the original account type being used when the event was
         * thrown.
         *
         * @return The original account type
         */
        AccountType getOriginalAccountType();

        /**
         * Gets the account type going to be used to create the account.
         *
         * @return The account type
         */
        AccountType getAccountType();

        /**
         * Sets the account type to be used by the account
         *
         * @param accountType The account type to be used
         */
        void setAccountType(AccountType accountType);

        /**
         * Gets the starting balance of the account for the specified currency.
         *
         * <p>If not previously set, will use the default balance of the
         * current {@link #getAccountType()}.</p>
         *
         * @param currency The currency to get the starting balance for
         * @return The starting balance
         */
        BigDecimal getStartingBalance(Currency currency);

        /**
         * Overrides the starting balance the account will have for the
         * specified {@link Currency}.
         *
         * @param currency The currency to set the starting balance for
         * @param balance The new starting balance
         */
        void setStartingBalance(Currency currency, BigDecimal balance);

    }

    /**
     * Fires after the new {@link Account} is created.
     */
    interface Post extends CreateAccountEvent {

        /**
         * The {@link Account} created by the {@link EconomyService}.
         *
         * @return The created account
         */
        Account getAccount();

    }

}

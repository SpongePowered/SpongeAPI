package org.spongepowered.api.service.economy.account;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * A type of economy account with some default settings as well as related
 * functionality.
 */
@CatalogedBy(AccountTypes.class)
public interface AccountType extends CatalogType {

    /**
     * Gets whether this account type is meant for a single individual.
     *
     * @return If the account type is meant for a sole user
     */
    boolean isIndividual();

    /**
     * Gets the default balance of this account type for the specified
     * {@link Currency}.
     *
     * <p>The default balance is used when the balance is retrieved for the
     * first time for a given {@link Currency} on an account with this type,
     * if no balance is available for the {@link Context}s used when retrieving
     * a balance, or if the account's balance is reset.</p>
     *
     * @param currency The currency to get the default balance for
     * @return The default balance for the specified currency
     */
    BigDecimal getDefaultBalance(Currency currency);

    /**
     * Gets the minimum balance of this account type for the
     * specified currency if one exists.
     *
     * @param currency The currency to get the minimum for
     * @return The maximum balance, if it exists
     */
    Optional<BigDecimal> minimumBalance(Currency currency);

    /**
     * Gets the maximum balance of this account type for the
     * specified currency if one exists.
     *
     * @param currency The currency to get the maximum for
     * @return The maximum balance, if it exists
     */
    Optional<BigDecimal> maximumBalance(Currency currency);

}

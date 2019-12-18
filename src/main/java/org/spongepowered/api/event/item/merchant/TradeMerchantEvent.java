package org.spongepowered.api.event.item.merchant;

import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.merchant.Merchant;
import org.spongepowered.api.item.merchant.TradeOffer;

/**
 * An event when a {@link Humanoid} trades with a {@link Merchant}.
 */
public interface TradeMerchantEvent extends Event, Cancellable {

	/**
	 * Gets the {@link Merchant} which is trading.
	 *
	 * @return The trading merchant.
	 */
	Merchant getMerchant();

	/**
	 * Gets the selected {@link TradeOffer} a {@link Humanoid} could buy.
	 *
	 * @return The trade offer.
	 */
	TradeOffer getSelectedOffer();

	/**
	 * Gets the {@link Humanoid} who is the customer of this transaction.
	 *
	 * @return The customer.
	 */
	Humanoid getCustomer();

}

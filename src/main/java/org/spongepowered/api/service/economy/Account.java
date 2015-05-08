/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.service.economy;

import org.spongepowered.api.entity.player.Player;

import java.util.UUID;

public interface Account {
    /**
     * The string that prefixes all custom account names.
     */
    public static final String CUSTOM_DATA_PREFIX = "_ESC-";

    /**
     * The name of the account belonging to the server.
     */
    public static final String SERVER_ACCOUNT_NAME = "_ESCSV";

    /**
     * Retrieves the string representative of the owner of
     * this {@link Account}.
     * 
     * <p>The String returned can represent 3 types of
     * accounts; namely a Player's, the Server's, or a
     * customly-registered account.</p>
     * 
     * <p>If the String returned matches the value denoted
     * by {@link Account#SERVER_ACCOUNT_NAME}, then the
     * owner of this Account is the server itself.</p>
     * 
     * <p>If the String returned begins with the value
     * denoted by {@link Account#CUSTOM_DATA_PREFIX},
     * then the owner of this Account is a custom owner,
     * as set by a plugin.</p>
     * 
     * <p>If the String returned does not match either of
     * the above, then it is expected to be the {@link UUID}
     * of a {@link Player}, in the form given by
     * {@link UUID#toString()}.</p>
     * 
     * <p>Convenience methods should exist within
     * implementation of the service; it is not necessary to
     * check the String on your own.</p>
     * 
     * @return a String representative of the owner of this
     *         Account
     * 
     * @see UUID
     * @see Player
     * @see Account#isPlayer()
     * @see Account#isServer()
     * @see Account#isCustom()
     */
    public String getOwner();

    /**
     * Returns whether or not the owner of this
     * {@link Account} is a {@link Player}.
     * 
     * <p>If this returns true, then
     * {@link Account#getOwner()} can safely be expected
     * to return the {@link UUID} of a Player, in the form
     * given by {@link UUID#toString()}.</p>
     * 
     * @return true if Account.getOwner() returns a
     *         Player UUID
     * 
     * @see Account#getOwner()
     */
    public boolean isPlayer();

    /**
     * Returns whether or not the owner of this
     * {@link Account} is the server itself.
     * 
     * <p>If this returns true, then
     * {@link Account#getOwner()} can safely be expected
     * to return the value denoted by
     * {@link Account#SERVER_ACCOUNT_NAME}.</p>
     * 
     * @return true if Account.getOwner() returns the
     *         value of Account.SERVER_ACCOUNT_NAME
     * 
     * @see Account#getOwner()
     */
    public boolean isServer();

    /**
     * Returns whether or not the owner of this
     * {@link Account} is a custom account, as set by
     * the implementing service.
     * 
     * <p>If this returns true, then
     * {@link Account#getOwner()} can safely be expected
     * to return a custom account, of which begins with the
     * value denoted by
     * {@link Account#CUSTOM_DATA_PREFIX}.</p>
     * 
     * @return true if Account.getOwner() returns a
     *         value beginning with the String stored in
     *         Account.CUSTOM_DATA_PREFIX
     * 
     * @see Account#getOwner()
     */
    public boolean isCustom();

    /**
     * Returns a double representative of the balance stored
     * within this {@link Account}.
     * 
     * <p>The double returned is not to exceed two decimal
     * places. An example would be <pre>129.54</pre>.</p>
     * 
     * @return a double value, with two or less decimal
     *         places
     */
    public double getBalance();

    /**
     * Sets the balance stored by this {@link Account}
     * as the given value.
     * 
     * <p>The amount set cannot exceed two decimal places
     * (e.g. <pre>129.54</pre>); as such, the double passed
     * as the amount will be rounded up or down if it
     * violates the former.</p>
     * 
     * <p>The amount is allowed to be negative.</p>
     * 
     * @param amount a double value
     */
    public void setBalance(double amount);

    /**
     * Pays the target {@link Account} the given amount
     * of currency by taking the amount from this
     * Account.
     * 
     * <p>If this Account results in holding a negative
     * balance due to this operation, this will return
     * true.</p>
     * 
     * <p>A negative amount parameter will result in an
     * IllegalArgumentException.</p>
     * 
     * @param target the Account to send the amount of
     *        money to
     * @param amount a double representative of the amount
     *        to give to the target Account
     * 
     * @return true if this Account's balance turned
     *         negative
     * 
     * @throws IllegalArgumentException if the amount to pay
     *         is negative
     */
    public boolean pay(Account target, double amount);

    /**
     * Removes the given sum of currency from this
     * {@link Account}.
     * 
     * <p>If this Account results in holding a negative
     * balance due to this operation, this will return
     * true.</p>
     * 
     * <p>A negative amount parameter will result in an
     * IllegalArgumentException.</p>
     * 
     * @param amount a double representing the amount to
     *        remove from the account
     * 
     * @return true if this Account's balance turned
     *         negative
     * 
     * @throws IllegalArgumentException if the amount to
     *         remove is negative
     */
    public boolean elicit(double amount);

    /**
     * Removes the given sum of currency from this
     * {@link Account} and sends it to the destination
     * Account.
     * 
     * <p>If this Account results in holding a negative
     * balance due to this operation, this will return
     * true.</p>
     * 
     * <p>A negative amount parameter will result in an
     * IllegalArgumentException.</p>
     * 
     * @param destination the Account to send the
     *        withdrawn currency to
     * @param amount a double representing the amount to
     *        withdraw
     * 
     * @return true if this Account's balance turned
     *         negative
     * 
     * @throws IllegalArgumentException if the amount to
     *         remove is negative
     */
    public boolean withdraw(Account destination, double amount);
}

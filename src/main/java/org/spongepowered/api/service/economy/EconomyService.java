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

import com.google.common.base.Optional;
import org.spongepowered.api.entity.player.Player;

import java.util.List;
import java.util.UUID;

public interface EconomyService {
    /**
     * Retrieves the {@link Account} denoted by the
     * given owner string.
     * 
     * <p>If the Account does not exist, this method will
     * return Optional.absent().</p>
     * 
     * <p>Owner strings are not representative of players
     * only. See {@link Account#getOwner()} for
     * reference.</p>
     * 
     * @param owner the owner string to search with
     * 
     * @return the Account owned by the given owner, or
     *         Optional.absent() otherwise
     * 
     * @see Account#getOwner()
     * @see EconomyService#createNewAccount(String)
     */
    Optional<Account> getAccount(String owner);
    
    /**
     * Creates a new {@link Account} and assigns it to the
     * given owner string.
     * 
     * <p>This method cannot override existing Accounts. If
     * the Account already exists, this method will return
     * Optional.absent() to indicate that creation has
     * failed. Existing Accounts should be reset before
     * they are replaced.</p>
     * 
     * <p>Owner strings are not representative of players
     * only. See {@link Account#getOwner()} for
     * reference.</p>
     * 
     * @param owner the owner string to assign the new
     *        Account to
     * 
     * @return whether or not the Account was created
     *         successfully
     * 
     * @see Account
     * @see Account#getOwner()
     * @see EconomyService#resetAccount(String)
     */
    Optional<Account> createNewAccount(String owner);
    
    /**
     * Retrieves the {@link Account} denoted by
     * the given {@link UUID}, belonging to a {@link Player}
     * , in the form given by {@link UUID#toString()}.
     * Shortcut method for {@link #getAccount(String)}.
     * 
     * @param uuid the UUID of the Player owning the Account
     * 
     * @return the Player Account found with the given name,
     *         or Optional.absent() otherwise
     * 
     * @see Account
     * @see EconomyService#getAccount(String);
     */
    Optional<Account> getPlayerAccount(UUID uuid);
    
    /**
     * Retrieves the {@link Account} denoted by
     * {@link Account#CUSTOM_DATA_PREFIX} + the given
     * account name string. Shortcut method for
     * {@link #getAccount(String)}.
     * 
     * @param accountName the name of the custom account
     * 
     * @return the custom Account found with the given name,
     *         or Optional.absent() otherwise
     * 
     * @see Account
     * @see EconomyService#getAccount(String);
     */
    Optional<Account> getCustomAccount(String accountName);
    
    /**
     * Retrieves the {@link Account} assigned to the
     * server. Shortcut method for
     * {@link #getAccount(String)}.
     * 
     * @return the Account belonging to the server
     * 
     * @see Account
     * @see EconomyService#getAccount(String);
     */
    Account getServerAccount();
    
    /**
     * Returns an immutable list of all {@link Account}s
     * belonging to a {@link Player}.
     * 
     * <p>This method should try to return all Accounts
     * registered belonging to Players; including offline
     * Players.</p>
     * 
     * @return an immutable List of Accounts
     * 
     * @see Account
     */
    List<Account> getAllPlayerAccounts();
    
    /**
     * Returns an immutable list of all custom
     * {@link Account}s made by plugins.
     * 
     * @return an immutable List of Accounts
     * 
     * @see Account
     */
    List<Account> getAllCustomAccounts();
    
    /**
     * Resets the data of the {@link Account} denoted by the
     * given owner string, essentially deleting it.
     * 
     * <p>If the Account was reset successfully, this method
     * will return true. It will return false if the Account
     * did not exist.</p>
     * 
     * <p>Owner strings are not representative of players
     * only. See {@link Account#getOwner()} for
     * reference.</p>
     * 
     * @param owner the owner string to search with
     * 
     * @return true if the Account was found and reset
     * 
     * @see Account#getOwner()
     */
    boolean resetAccount(String owner);
}

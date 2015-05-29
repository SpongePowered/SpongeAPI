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

package org.spongepowered.api.item.merchant;

import org.spongepowered.api.data.type.Career;
import org.spongepowered.api.entity.living.Villager;
import org.spongepowered.api.item.merchant.generator.TradeOfferGenerator;

import java.util.List;
import java.util.Map;

/**
 * The villager registry handles the default {@link TradeOffer} generation of
 * {@link Villager}s. Based on their {@link Career} and level.
 */
public interface VillagerRegistry {

    /**
     * Gets an immutable map with the career level as keys and an immutable list
     * of {@link TradeOfferGenerator}s that belong to that level. Assuming level
     * 0 is the first one. If this career does not have any trade offer
     * generators this returns an empty map. Only keys with attached generators
     * are returned.
     *
     * @param career The career to get the trade offers from
     * @return The map of trade offer generators for each level
     */
    Map<Integer, List<TradeOfferGenerator>> getTradeOffers(Career career);

    /**
     * Gets an immutable list of the generators for the given Merchant level.
     * Assuming level 0 is the first one. Returns an empty list if no generators
     * belong to the requested level.
     *
     * @param career The career to get the trade offers from
     * @param level The level to return the {@link TradeOfferGenerator}s for
     * @return The generators for the given Merchant level
     * @throws IllegalArgumentException If level is negative
     */
    List<TradeOfferGenerator> getTradeOffers(Career career, int level) throws IllegalArgumentException;

    /**
     * Adds new {@link TradeOfferGenerator}s to the given career level. Existing
     * {@link Villager}s with this or a higher level aren't updated.
     *
     * @param career The career to add the trade offers to
     * @param level The level to add the generators to
     * @param generators The generators to append to that level
     * @throws IllegalArgumentException If level is negative or the generators
     *         are null
     */
    void addTradeOffers(Career career, int level, TradeOfferGenerator... generators) throws IllegalArgumentException;

    /**
     * Sets the {@link TradeOfferGenerator}s to the given career level. Existing
     * {@link Villager}s with this or a higher level aren't updated. All
     * existing generators for that level will be replaced.
     *
     * @param career The career to set the trade offers for
     * @param level The level to add the generators to
     * @param generators The generators to use for that level
     * @throws IllegalArgumentException If level is negative or the generators
     *         are null or contain null values
     */
    void setTradeOffers(Career career, int level, List<TradeOfferGenerator> generators) throws IllegalArgumentException;

    /**
     * Sets the {@link TradeOfferGenerator}s for this career. Any existing
     * generators will be replaced by the new ones. Existing {@link Villager}s
     * with this or a higher level aren't updated.
     *
     * @param career The career to set the trade offers for
     * @param generators The generators to use for this career
     * @throws IllegalArgumentException If level is negative or the generators
     *         are null or contain null values
     */
    void setTradeOffers(Career career, Map<Integer, List<TradeOfferGenerator>> generators) throws IllegalArgumentException;

    /**
     * Generates a list of {@link TradeOffer}s for the specified level of that
     * career. This method does not include any previous level's trade offers.
     * This method returns an empty list if the given level does not have any
     * generators attached to it. Without providing a context of previous
     * {@link TradeOffer}s.
     *
     * @param career The career to get the trade offers from
     * @param level The level to generate the trade offers for
     * @return The generated trade offers
     * @throws IllegalArgumentException If level is negative
     */
    List<TradeOffer> generateTradeOffers(Career career, int level) throws IllegalArgumentException;

    /**
     * Updates the given list of {@link TradeOffer}s with new entries, updates
     * existing {@link TradeOffer}s and may remove old ones.
     *
     * @param career The career to generate the trade offers for
     * @param level The level to generate the trade offers for
     * @param currentOffers The current trade offers
     * @throws IllegalArgumentException If level is negative
     */
    void generateTradeOffers(Career career, int level, List<TradeOffer> currentOffers) throws IllegalArgumentException;

}

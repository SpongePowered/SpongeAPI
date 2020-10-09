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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import org.spongepowered.api.data.type.ProfessionType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public interface VillagerRegistry {

    /**
     * Gets an immutable {@link Multimap} of the {@link ProfessionType}'s registered
     * {code level} to {@link TradeOfferListMutator}s. Note that the map is
     * immutable and cannot be modified directly.
     *
     * @param profession The profession
     * @return The immutable multimap
     */
    Multimap<Integer, TradeOfferListMutator> getTradeOfferLevelMap(ProfessionType profession);

    /**
     * Gets the available {@link TradeOfferListMutator}s for the desired
     * {@link ProfessionType} and {@code level}.
     *
     * @param profession The profession
     * @param level The level
     * @return The collection of trade offer mutators, if available
     */
    default Collection<TradeOfferListMutator> getMutatorsForProfession(ProfessionType profession, int level) {
        final Multimap<Integer, TradeOfferListMutator> map = getTradeOfferLevelMap(Objects.requireNonNull(
            profession,
            "Profession cannot be null!"
        ));
        final Collection<TradeOfferListMutator> mutators = map.get(level);
        return ImmutableList.copyOf(mutators);
    }

    /**
     * Adds the provided {@link TradeOfferListMutator} for the given
     * {@link ProfessionType} and {@code level}. Note that the level
     * must be at least 1. There can be multiple {@link TradeOfferListMutator}s
     * per level.
     *
     * @param profession The profession
     * @param level The level
     * @param mutator The mutator to register
     * @return This registry, for chaining
     */
    VillagerRegistry addMutator(ProfessionType profession, int level, TradeOfferListMutator mutator);

    /**
     * Adds the provided {@link TradeOfferListMutator}s for the given
     * {@link ProfessionType} and {@code level}. Note that the level
     * must be at least 1. There can be multiple {@link TradeOfferListMutator}s
     * per level.
     *
     * @param profession The profession
     * @param level The level
     * @param mutator The mutator to register
     * @param mutators The additional mutators
     * @return This registry, for chaining
     */
    VillagerRegistry addMutators(ProfessionType profession, int level, TradeOfferListMutator mutator, TradeOfferListMutator... mutators);

    /**
     * Sets the provided {@link TradeOfferListMutator} for the given
     * {@link ProfessionType} and {@code level}. Note that the level
     * must be at least 1. There can be multiple {@link TradeOfferListMutator}s
     * per level. Any previously provided {@link TradeOfferListMutator}s will
     * be erased.
     *
     * @param profession The profession
     * @param level The level
     * @param mutators The mutators to register
     * @return This registry, for chaining
     */
    VillagerRegistry setMutators(ProfessionType profession, int level, List<TradeOfferListMutator> mutators);

    /**
     * Sets the provided {@link TradeOfferListMutator} for the given
     * {@link ProfessionType} and {@code level}. Note that the level
     * must be at least 1. There can be multiple {@link TradeOfferListMutator}s
     * per level. Any previously provided {@link TradeOfferListMutator}s will
     * be erased.
     *
     * @param profession The profession
     * @param mutatorMap The mutator map
     * @return This registry, for chaining
     */
    VillagerRegistry setMutators(ProfessionType profession, Multimap<Integer, TradeOfferListMutator> mutatorMap);

    /**
     * Generates a new {@link List} of {@link TradeOffer}s based on the
     * provided {@link ProfessionType}, {@code level}, and {@link Random}.
     *
     * @param merchant The merchant
     * @param profession The profession
     * @param level The level
     * @param random The random
     * @return The generated list of trade offers
     */
    default Collection<TradeOffer> generateTradeOffers(Merchant merchant, ProfessionType profession, int level, Random random) {
        Objects.requireNonNull(random, "Random cannot be null!");
        List<TradeOffer> generatedList = new ArrayList<>();
        this.getMutatorsForProfession(profession, level)
                .forEach(mutator -> mutator.accept(merchant, generatedList, random));
        return generatedList;
    }

    /**
     * Populates the provided {@link List} of {@link TradeOffer}s with
     * potentially new {@link TradeOffer}s based on the
     * {@link TradeOfferListMutator}s and {@code level}. If there are no
     * {@link TradeOfferListMutator}s registered for the desired level
     * and {@link ProfessionType}, the list remains unmodified.
     *
     * @param merchant The merchant
     * @param currentOffers The current offers
     * @param profession The profession
     * @param level The level
     * @param random The random to use
     * @return The list of offers modified
     */
    default List<TradeOffer> populateOffers(Merchant merchant, List<TradeOffer> currentOffers, ProfessionType profession, int level, Random random) {
        this.getMutatorsForProfession(profession, level)
                .forEach(mutator -> mutator.accept(merchant, currentOffers, random));
        return currentOffers;
    }

}

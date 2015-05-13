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
package org.spongepowered.api.data.types;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.item.merchant.generator.TradeOfferGenerator;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.List;
import java.util.Map;

/**
 * Represents a Villager Career. A career can define a more specified list of
 * trade offers the villager can give to a player.
 */
@CatalogedBy(Careers.class)
public interface Career extends CatalogType, Translatable {

    /**
     * Gets the parent profession of this career. The profession is permanent
     * and can not be changed.
     *
     * @return The profession this career belongs to
     */
    Profession getProfession();

    Map<Integer, List<TradeOfferGenerator>> getTradeOffers();

    /**
     * Gets an immutable list of the generators for the given Merchant level.
     * Assuming level 0 is the first one.
     *
     * @param level The level to return the {@link TradeOfferGenerator}s for
     * @return The generators for the given Merchant level
     */
    List<TradeOfferGenerator> getTradeOffers(int level);

    void addTradeOffers(int level, TradeOfferGenerator... generators);

    void setTradeOffers(Map<Integer, List<TradeOfferGenerator>> generators);

    List<TradeOffer> generateTradeOffers(int level);

}

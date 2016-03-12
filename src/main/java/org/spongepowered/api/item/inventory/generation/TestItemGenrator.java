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
package org.spongepowered.api.item.inventory.generation;

import static org.spongepowered.api.item.inventory.ItemStackBuilderPopulators.enchantmentsWithVanillaLevelVariance;
import static org.spongepowered.api.item.inventory.ItemStackBuilderPopulators.keyValue;
import static org.spongepowered.api.item.inventory.ItemStackBuilderPopulators.keyValues;
import static org.spongepowered.api.item.inventory.ItemStackBuilderPopulators.listValues;
import static org.spongepowered.api.item.inventory.ItemStackBuilderPopulators.quantity;
import static org.spongepowered.api.item.inventory.ItemStackBuilderPopulators.items;
import static org.spongepowered.api.util.weighted.VariableAmount.baseWithRandomAddition;
import static org.spongepowered.api.util.weighted.VariableAmount.fixed;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.BannerPatternShapes;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.item.Enchantments;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStackGenerator;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class TestItemGenrator {


    public static ItemStackGenerator provide() {
        return ItemStackGenerator.builder()
                .add(items(ItemTypes.IRON_SWORD, ItemTypes.IRON_AXE, ItemTypes.IRON_HOE))
                .add(quantity(fixed(1)))
                .add(listValues(Keys.BANNER_PATTERNS, ImmutableList.of(PatternLayer.of(BannerPatternShapes.BASE, DyeColors.BLACK))))
                .add(enchantmentsWithVanillaLevelVariance(baseWithRandomAddition(1, 2), Enchantments.SHARPNESS, Enchantments.FIRE_ASPECT, Enchantments.KNOCKBACK, Enchantments.LOOTING))
                .add(keyValue(Keys.DISPLAY_NAME, Text.of(TextColors.DARK_AQUA, TextStyles.BOLD, "LEGENDARY")))
                .add(keyValue(Keys.UNBREAKABLE, true))
                .build();

    }

}

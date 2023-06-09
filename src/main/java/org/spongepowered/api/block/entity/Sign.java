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
package org.spongepowered.api.block.entity;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.Nameable;

/**
 * Represents a sign.
 */
public interface Sign extends BlockEntity, Nameable {

    /**
     * Gets the {@link org.spongepowered.api.data.value.ListValue.Mutable} of {@link Component} for the {@link Sign}
     * to show.
     *
     * @return The list of text lines
     */
    default ListValue.Mutable<Component> lines() {
        return this.requireValue(Keys.SIGN_LINES).asMutable();
    }

    /**
     * Gets whether the front side {@link SignText} has {@link SignText#glowingText() glowing text}
     *
     * @return Whether this sign has glowing text
     */
    default Value.Mutable<Boolean> glowingText() {
        return this.requireValue(Keys.GLOWING_TEXT).asMutable();
    }

    /**
     * Gets whether this sign is waxed.
     *
     * @return true when this sign is waxed.
     */
    default Value.Mutable<Boolean> waxed() {
        return this.requireValue(Keys.SIGN_WAXED).asMutable();
    }

    /**
     * Gets the back side {@link SignText}
     *
     * @return the back side sign-text
     */
    default SignText backText() {
        return this.require(Keys.SIGN_BACK_TEXT);
    }

    /**
     * Gets the front side {@link SignText}
     *
     * @return the back side sign-text
     */
    default SignText frontText() {
        return this.require(Keys.SIGN_FRONT_TEXT);
    }

    interface SignText extends DataHolder.Mutable {

        /**
         * Gets the {@link org.spongepowered.api.data.value.ListValue.Mutable} of {@link Component} for the {@link Sign}
         * to show.
         *
         * @return The list of text lines
         */
        default ListValue.Mutable<Component> lines() {
            return this.requireValue(Keys.SIGN_LINES).asMutable();
        }

        /**
         * Gets whether this sign has glowing text.
         *
         * @return Whether this sign has glowing text.
         */
        default Value.Mutable<Boolean> glowingText() {
            return this.requireValue(Keys.GLOWING_TEXT).asMutable();
        }

        /**
         * Gets the {@link DyeColor} of this sign text.
         *
         * @return the dye-color of this sign text
         */
        default Value.Mutable<DyeColor> dyeColor() {
            return this.requireValue(Keys.DYE_COLOR).asMutable();
        }
    }
}

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
package org.spongepowered.api.scoreboard;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.Style;
import org.spongepowered.api.Sponge;

/**
 * A Score Number Format
 */
public interface ScoreFormat {

    static ScoreFormat blank() {
        return Sponge.game().factoryProvider().provide(Factory.class).blank();
    }

    static ScoreFormat fixed(Component component) {
        return Sponge.game().factoryProvider().provide(Factory.class).fixed(component);
    }

    static ScoreFormat styled(Style style) {
        return Sponge.game().factoryProvider().provide(Factory.class).styled(style);
    }

    interface Factory {

        /**
         * Blank score formatting.
         *
         * @return the format
         */
        ScoreFormat blank();

        /**
         * Fixed score formatting
         *
         * @param component the fixed component
         *
         * @return the format
         */
        ScoreFormat fixed(Component component);

        /**
         * Styled number formatting
         *
         * @param style the style
         *
         * @return the format
         */
        ScoreFormat styled(Style style);
    }

}

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
package org.spongepowered.api.text.template;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.CompositeValueStore;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextBuilder;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.translation.Translatable;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

public final class TextElements {

    public static Text DEFAULT_SEPARATOR = Texts.of(", ");

    static TextElement<Text> IDENTITY = value -> value;

    public static TextElement<Text> identity() {
        return IDENTITY;
    }

    public static <T> TextElement<T> always(final Text text) {
        return value -> text;
    }

    public static <T> TextElement<T> function(final Function<T, Text> function) {
        return function::apply;
    }

    public static <E> TextElement<Optional<E>> optional(final TextElement<E> singleArg) {
        return value -> {
            if (value.isPresent()) {
                return singleArg.create(value.get());
            } else {
                return Texts.of();
            }
        };
    }

    public static <E> TextElement<Iterator<E>> iterator(final TextElement<E> singleArg, final Text separator) {
        return iterator -> {
            TextBuilder builder = Texts.builder();
            boolean first = true;
            while (iterator.hasNext()) {
                Text next = singleArg.create(iterator.next());
                if (!next.isEmpty()) {
                    if (!first) {
                        builder.append(separator);
                    }
                    first = false;
                    builder.append(next);
                }
            }
            return builder.build();
        };
    }

    public static <E> TextElement<Iterator<E>> iterator(final TextElement<E> singleArg) {
        return iterator(singleArg, DEFAULT_SEPARATOR);
    }

    public static <E> TextElement<Iterable<E>> iterable(final TextElement<E> singleArg, final Text separator) {
        return iterator(singleArg, separator).contramap(Iterable::iterator);
    }

    public static <E> TextElement<Iterable<E>> iterable(final TextElement<E> singleArg) {
        return iterable(singleArg, DEFAULT_SEPARATOR);
    }

    public static <T> TextElement<T> fallback(final TextElement<T> thatArg, final TextElement<T> fallbackArg) {
        return value -> {
            Text result = thatArg.create(value);
            if (result.isEmpty()) {
                return fallbackArg.create(value);
            } else {
                return result;
            }
        };
    }

    public static <T> TextElement<T> fallback(final TextElement<T> thatArg, final Text fallback) {
        return fallback(thatArg, always(fallback));
    }

    public static <T extends Translatable> TextElement<T> translatable() {
        return Texts::of;
    }

    public static TextElement<Player> playerDisplayName() {
        return key(Keys.DISPLAY_NAME);
    }

    public static <C extends CompositeValueStore<?, ?>> TextElement<C> key(
        final Key<? extends BaseValue<Text>> key) {
        return value -> value.get(key).orElse(Texts.of());
    }

    /**
     *
     * Example:
     *
     * <code>
     *     TextElements.collectionKey(Keys.SIGN_LINES, iterable(identity()));
     * </code>
     *
     * @param key
     * @param join
     * @param <C>
     * @param <L>
     * @return
     */
    public static <C extends CompositeValueStore<?, ?>, L extends Collection<Text>> TextElement<C> collectionKey(
        final Key<? extends BaseValue<L>> key, final TextElement<? super L> join) {
        return value -> {
            Optional<L> possibleColl = value.get(key);
            if (possibleColl.isPresent()) {
                return join.create(possibleColl.get());
            } else {
                return Texts.of();
            }
        };
    }

    /**
     *
     * Example:
     *
     * <code>
     *     TextElements.optionalKey(Keys.LAST_COMMAND_OUTPUT);
     * </code>
     *
     * @param key
     * @param <C>
     * @return
     */
    public static <C extends CompositeValueStore<?, ?>> TextElement<C> optionalKey(
        final Key<? extends BaseValue<Optional<Text>>> key) {
        return value -> {
            Optional<Text> possibleColl = value.getOrElse(key, Optional.empty());
            if (possibleColl.isPresent()) {
                return possibleColl.get();
            } else {
                return Texts.of();
            }
        };
    }

}

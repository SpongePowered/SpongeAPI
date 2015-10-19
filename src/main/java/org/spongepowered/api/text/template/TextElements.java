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

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;

/**
 * Container of methods that create text elements.
 */
public final class TextElements {
    private TextElements() {}

    /**
     * The default separator for iterator-based text elements.
     */
    public static Text DEFAULT_SEPARATOR = Texts.of(", ");

    /**
     * The identity text element, one that returns whatever was passed in.
     */
    private static TextElement<Text> IDENTITY = value -> value;

    /**
     * Returns an identity text element, one that returns whatever was
     * passed in.
     *
     * @return The text element
     */
    public static TextElement<Text> identity() {
        return IDENTITY;
    }

    /**
     * Returns a text element that builds a literal text object out of the given string.
     *
     * @return The text element
     */
    public static TextElement<String> string() {
        return Texts::of;
    }

    /**
     * Returns a text element that always returns a certain text value.
     *
     * @param text The text value to constantly return
     * @param <T> The type of value the text element accepts
     * @return The text element
     */
    public static <T> TextElement<T> always(final Text text) {
        return value -> text;
    }

    /**
     * Returns a text element, given a function that performs the same task.
     *
     * @param function The function that returns a text object
     * @param <T> The type of value the function/text element accepts
     * @return The text element
     */
    public static <T> TextElement<T> function(final Function<T, Text> function) {
        return function::apply;
    }

    /**
     * Returns a text element that takes in optional values of a certain type, given a text
     * element that takes in present values of a certain type.
     *
     * The returned text element returns an empty text object when given an absent optional.
     *
     * @param element A text element that takes in values of type {@link E}
     * @param <E> The type of values that the text element accepts
     * @return The text element
     */
    public static <E> TextElement<Optional<E>> optional(final TextElement<E> element) {
        return value -> {
            if (value.isPresent()) {
                return element.create(value.get());
            } else {
                return Texts.of();
            }
        };
    }

    /**
     * Returns a text element that takes in an iterator of objects, given a text element that takes
     * in those individual objects and a separator.
     *
     * The returned text object consists of objects created by the given text element, separated
     * by the given separator.
     *
     * @param element A text element that takes in values of type {@link E}
     * @param separator The separator between objects in the returned text element
     * @param <E> The type of values of the iterator that the text element accepts
     * @return The text element
     */
    public static <E> TextElement<Iterator<E>> iterator(final TextElement<E> element, final Text separator) {
        return iterator -> {
            TextBuilder builder = Texts.builder();
            boolean first = true;
            while (iterator.hasNext()) {
                Text next = element.create(iterator.next());
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

    /**
     * Returns a text element that takes an iterator of objects, given a text element that takes in
     * those individual objects.
     *
     * This is a default for {@link #iterator(TextElement, Text)}
     *
     * @param element A text element that takes in values of type {@link E}
     * @param <E> The type of values of the iterator that the text element accepts
     * @return The text element
     * @see #iterator(TextElement, Text)
     */
    public static <E> TextElement<Iterator<E>> iterator(final TextElement<E> element) {
        return iterator(element, DEFAULT_SEPARATOR);
    }

    /**
     * Returns a text element that takes in an iterable of objects, given a text element that takes
     * in those individual objects and a separator.
     *
     * The returned text object consists of objects created by the given text element, separated
     * by the given separator.
     *
     * @param element A text element that takes in values of type {@link E}
     * @param separator The separator between objects in the returned text element
     * @param <E> The type of values of the iterable that the text element accepts
     * @return The text element
     */
    public static <E> TextElement<Iterable<E>> iterable(final TextElement<E> element, final Text separator) {
        return iterator(element, separator).contramap(Iterable::iterator);
    }

    /**
     * Returns a text element that takes an iterable of objects, given a text element that takes in
     * those individual objects.
     *
     * This is a default for {@link #iterable(TextElement, Text)}
     *
     * @param element A text element that takes in values of type {@link E}
     * @param <E> The type of values of the iterable that the text element accepts
     * @return The text element
     * @see #iterable(TextElement, Text)
     */
    public static <E> TextElement<Iterable<E>> iterable(final TextElement<E> element) {
        return iterable(element, DEFAULT_SEPARATOR);
    }

    /**
     * Returns a text element that tries the first text element first, then the second one if the
     * first one is empty.
     *
     * @param element The first text element to try
     * @param fallback The fallback text element, only used if the first one returns an empty text
     * @param <T> The type of values the text element accepts
     * @return The text element
     */
    public static <T> TextElement<T> fallback(final TextElement<T> element, final TextElement<T> fallback) {
        return value -> {
            Text result = element.create(value);
            if (result.isEmpty()) {
                return fallback.create(value);
            } else {
                return result;
            }
        };
    }

    /**
     * Returns a text element that tries the given text element, then falls back to the given value
     * if the text element returns an empty text.
     *
     * @param element The text element to try
     * @param fallback The fallback text object
     * @param <T> The type of values the text element accepts
     * @return The text element
     */
    public static <T> TextElement<T> fallback(final TextElement<T> element, final Text fallback) {
        return fallback(element, always(fallback));
    }

    /**
     * Returns a text element that takes in translatable objects and turns them into text.
     *
     * @param <T> The type of {@link Translatable}s to take
     * @return The text element
     */
    public static <T extends Translatable> TextElement<T> translatable() {
        return Texts::of;
    }

    /**
     * Returns a text element that tries to access the given key on a value store, and apply it to
     * the given text element, returning the empty text if that key does not exist.
     *
     * @param key The key to lookup on a value store
     * @param element The text element to
     * @param <C> The type of value store
     * @return The text element
     * @see #key(Key)
     */
    public static <C extends CompositeValueStore<?, ?>, T> TextElement<C> key(
        Key<? extends BaseValue<T>> key, TextElement<? super T> element) {
        return value -> {
            Optional<T> possible = value.get(key);
            if (possible.isPresent()) {
                return element.create(possible.get());
            } else {
                return Texts.of();
            }
        };
    }

    /**
     * Returns a text element that tries to access the given key on a value store, returning the
     * empty text if that key does not exist.
     *
     * @param key The key to lookup on a value store
     * @param <C> The type of value store
     * @return The text element
     * @see #key(Key)
     */
    public static <C extends CompositeValueStore<?, ?>> TextElement<C> key(
        Key<? extends BaseValue<Text>> key) {
        return key(key, identity());
    }

    /**
     * Returns a text element that tries to access the given key on a value store, joining the
     * result into a text object with the given joiner, and returning the empty text if that
     * key does not exist.
     *
     * Example:
     *
     * <pre>
     *     TextElements.iterableKey(Keys.SIGN_LINES, iterable(identity()));
     * </pre>
     *
     * @param key The key to lookup on a value store
     * @param joiner A text element that takes a {@code L}
     * @param <C> The type of value store
     * @param <T> The type of value that joiner takes
     * @param <L> The type of collection of text
     * @return The text element
     */
    public static <C extends CompositeValueStore<?, ?>, T, L extends Iterable<? extends T>> TextElement<C> iterableKey(
        Key<? extends BaseValue<L>> key, final TextElement<? super L> joiner) {
        return key(key, joiner);
    }

    /**
     * Returns a text element that tries to access the given key on a value store, applying the
     * given element to that object if it exists, and returning the empty text if that
     * key does not exist.
     *
     * @param key The key to use
     * @param element The text element
     * @param <C> The type of value store
     * @param <T> The type of value that element takes
     * @return The text element
     */
    public static <C extends CompositeValueStore<?, ?>, T> TextElement<C> optionalKey(
        Key<? extends BaseValue<Optional<T>>> key, TextElement<T> element) {
        return optional(element).contramap(value -> value.get(key).orElse(Optional.empty()));
    }

    /**
     * Returns a text element that tries to access the given key on a value store, returning the
     * empty text if that key does not exist.
     *
     * Example:
     *
     * <pre>
     *     TextElements.optionalKey(Keys.LAST_COMMAND_OUTPUT);
     * </pre>
     *
     * @param key The key to use
     * @param <C> The
     * @return The text element
     * @see #optionalKey(Key, TextElement)
     */
    public static <C extends CompositeValueStore<?, ?>> TextElement<C> optionalKey(
        Key<? extends BaseValue<Optional<Text>>> key) {
        return optionalKey(key, identity());
    }

    /**
     * Returns a text element that gets the display name of a player, since this is often used.
     *
     * @return The text element
     */
    public static TextElement<Player> playerDisplayName() {
        return key(Keys.DISPLAY_NAME);
    }

}

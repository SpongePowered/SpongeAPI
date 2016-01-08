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

package org.spongepowered.api.text.transformer;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Functions;

import java.util.Locale;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A utility class to generate useful {@link Transformer}s that can be passed to
 * {@link org.spongepowered.api.text.Text.Placeholder placeholders}.
 */
public final class Transformers {

    /**
     * Creates a new {@link Transformer} that will always return the given
     * constant.
     *
     * @param value The constant to return
     * @param <T> The type returned by the newly created transformer
     * @return The newly created {@link Transformer}
     */
    public static <T> Transformer<T> constant(final T value) {
        checkNotNull(value, "value");
        final Optional<T> optValue = Optional.of(value);
        return context -> optValue;
    }

    /**
     * Creates a new {@link Transformer} that will always return the result of
     * the given supplier.
     *
     * @param supplier The supplier to get the result from
     * @param <T> The type returned by the newly created transformer
     * @return The newly created {@link Transformer}
     */
    public static <T> Transformer<T> supplied(final Supplier<T> supplier) {
        checkNotNull(supplier, "supplier");
        return context -> Optional.ofNullable(supplier.get());
    }

    /**
     * Creates a new {@link Transformer} that will return the value for the
     * given key if it is present and {@link Optional#empty()} otherwise.
     *
     * @param key The context key used to get the data
     * @param <T> The type returned by the newly created transformer
     * @return The newly created {@link Transformer}
     */
    public static <T> Transformer<T> key(final String key) {
        return new ValueForKeyTransformer<>(key);
    }

    /**
     * Creates a new {@link Transformer} that will return the value calculated
     * using the value for the given key if it is present and return
     * {@link Optional#empty()} otherwise.
     *
     * <p>Note: This is a helper method to avoid having to specify the generic
     * type in {@link #key(String)} explicitly.</p>
     *
     * @param key The context key used to get the data
     * @param function The transform function used to transform the present data
     * @return The newly created {@link Transformer}
     * @param <T> The type of data returned by the context using the given key
     * @param <R> The type returned by the newly created transformer
     * @see #key(String)
     * @see Transformer#map(Function)
     */
    public static <T, R> Transformer<R> mappedKey(String key, Function<T, R> function) {
        return Transformers.<T>key(key).map(function);
    }

    /**
     * Creates a new {@link Transformer} that will return the value calculated
     * using the value for the given key if it is present and return
     * {@link Optional#empty()} otherwise.
     *
     * <p>Note: This is a helper method to avoid having to specify the generic
     * type in {@link #key(String)} explicitly.</p>
     *
     * @param key The context key used to get the data
     * @param function The transform function used to transform the present data
     * @return The newly created {@link Transformer}
     * @param <T> The type of data returned by the context using the given key
     * @param <R> The type returned by the newly created transformer
     * @see #key(String)
     * @see Transformer#flatMap(Function)
     */
    public static <T, R> Transformer<R> flatMappedKey(String key, Function<T, Optional<R>> function) {
        return Transformers.<T>key(key).flatMap(function);
    }

    /**
     * Creates a new {@link Transformer} that will return the joined result of
     * the to values for the given keys if both are present and
     * {@link Optional#empty()} otherwise. The transformer will use the given
     * join function to merge the values obtained from both keys into one value.
     *
     * <p>Note: This is a helper method to avoid having to specify the generic
     * type in {@link #key(String)} explicitly.</p>
     *
     * @param mainKey The context main key used to get the main data
     * @param joinKey The context join key used to get the data that should be
     *        joined
     * @param joinFunction The function used to join the values returned for the
     *        two keys.
     * @param <T> The type of data returned by the context using the main key
     * @param <U> The type of data returned by the context using the join key
     * @param <R> The type returned by the newly created transformer
     * @return The newly created {@link Transformer}
     * @see Transformers#key(String)
     * @see Transformer#join(String, BiFunction)
     */
    public static <T, U, R> Transformer<R> joinedKeys(final String mainKey, final String joinKey, final BiFunction<T, U, R> joinFunction) {
        return Transformers.<T>key(mainKey).join(joinKey, joinFunction);
    }

    /**
     * Creates a new {@link Transformer} that will return the joined result of
     * the to values for the given keys. The transformer will use the given join
     * function to merge the values obtained from both keys into one value.
     *
     * <p>Note: This is a helper method to avoid having to specify the generic
     * type in {@link #key(String)} explicitly.</p>
     *
     * @param mainKey The context main key used to get the main data
     * @param joinKey The context join key used to get the data that should be
     *        joined
     * @param joinFunction The function used to join the values returned for the
     *        two keys.
     * @param <T> The type of data returned by the context using the main key
     * @param <U> The type of data returned by the context using the join key
     * @param <R> The type returned by the newly created transformer
     * @return The newly created {@link Transformer}
     * @see Transformers#key(String)
     * @see Transformer#join(String, BiFunction)
     */
    public static <T, U, R> Transformer<R> joinedNullableKeys(final String mainKey, final String joinKey,
            final BiFunction<T, U, R> joinFunction) {
        return Transformers.<T>key(mainKey).joinNullable(joinKey, joinFunction);
    }

    /**
     * Creates a new utility {@link Transformer} that can be used to resolve the
     * language based on a context parameter with the given name. The parameter
     * associated with the given localeKey must be a {@link Locale}.
     *
     * @param localeKey The context key used to get the locale
     * @param function The function used to get the translation {@link Text} for
     *        the requested locale
     * @return The newly created multi language support {@link Transformer}
     */
    public static Transformer<Text> multiLanguageSupportWithLocale(String localeKey, Function<Locale, Text> function) {
        checkNotNull(localeKey, "localeKey");
        return multiLanguageSupport(key(localeKey), function);
    }

    /**
     * Creates a new utility {@link Transformer} that can be used to resolve the
     * language based on a context parameter with the given name. The parameter
     * associated with the given targetKey must be a {@link CommandSource}.
     *
     * @param targetKey The context key used to get the target
     *        {@link CommandSource}
     * @param function The function used to get the translation {@link Text} for
     *        the target's locale
     * @return The newly created multi language support {@link Transformer}
     * @see #deepFormater(Transformer)
     */
    public static Transformer<Text> multiLanguageSupportWithTarget(String targetKey, Function<Locale, Text> function) {
        checkNotNull(targetKey, "targetKey");
        return multiLanguageSupport(mappedKey(targetKey, CommandSource::getLocale), function);
    }

    /**
     * Creates a new utility {@link Transformer} that can be used to obtain the
     * translation using the given locale transformer and the given translation
     * function.
     *
     * @param localeTransformer The transformer used to get the {@link Locale}
     *        that should be used to get the translation for it
     * @param function The function used to get the translation {@link Text} for
     *        the target's locale
     * @return The newly created multi language support {@link Transformer}
     * @see #deepFormater(Transformer)
     */
    public static Transformer<Text> multiLanguageSupport(Transformer<Locale> localeTransformer, Function<Locale, Text> function) {
        checkNotNull(localeTransformer, "localeTransformer");
        checkNotNull(function, "function");
        return deepFormater(localeTransformer.map(Functions.nonNullResult(function, "missing translation text")));
    }

    /**
     * Creates a new {@link Transformer} that will execute
     * {@link Text#format(Text, Function)} on the result of the given
     * transformer.
     *
     * @param transformer The transformer which results should be formated. The
     *        transformer must return a none absent/empty value
     * @return The newly created {@link Transformer}
     */
    public static Transformer<Text> deepFormater(Transformer<Text> transformer) {
        checkNotNull(transformer, "transformer");
        return context -> Optional.of(Text.format(
                transformer.transform(context)
                        .orElseThrow(() -> new IllegalArgumentException(transformer + " returned absent result!")),
                context));
    }

    /**
     * Creates a new {@link Transformer} that will try to get the
     * {@link BaseValue} from the {@link DataHolder} provided for the given
     * context {@link Key}.
     *
     * @param contextKey The key used to get the {@link DataHolder} from the
     *        context
     * @param valueKey The key used to get the data from the {@link DataHolder}
     * @param <T> The type returned by the newly created transformer
     * @return The newly created {@link Transformer}
     * @see #key(String)
     * @see #dataValueMappedKey(Transformer, Key)
     */
    public static <T> Transformer<T> dataValueMappedKey(String contextKey, Key<? extends BaseValue<T>> valueKey) {
        return dataValueMappedKey(key(contextKey), valueKey);
    }

    /**
     * Creates a new {@link Transformer} that will try to get the
     * {@link BaseValue} from the {@link DataHolder} returned by the given
     * {@link Transformer}.
     *
     * @param transformer The {@link Transformer} used to get the
     *        {@link DataHolder} from the context
     * @param valueKey The key used to get the data from the {@link DataHolder}
     * @param <T> The type returned by the newly created transformer
     * @return The newly created {@link Transformer}
     * @see Transformer#flatMap(Function)
     * @see DataHolder#get(Key)
     */
    public static <T> Transformer<T> dataValueMappedKey(Transformer<? extends DataHolder> transformer,
            final Key<? extends BaseValue<T>> valueKey) {
        checkNotNull(transformer, "transformer");
        checkNotNull(valueKey, "valueKey");
        return transformer.flatMap(input -> input.get(valueKey));
    }

    private Transformers() {
    }

}

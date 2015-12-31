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

package org.spongepowered.api.text.dictionary;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Text.FormatBuilder;
import org.spongepowered.api.text.transformer.Transformer;
import org.spongepowered.api.text.transformer.Transformers;
import org.spongepowered.api.text.translation.locale.Locales;
import org.spongepowered.api.util.BiFunctions;
import org.spongepowered.api.util.Functions;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

/**
 * Utility class to allow plugin developers to easily add multi language support
 * to their plugins.
 */
public class Dictionary implements Function<String, Function<Locale, Text>> {

    /**
     * Translation fallback that will return any language's translation in case
     * none has been found before.
     */
    private static final BiFunction<Locale, Map<Locale, Text>, Text> TRANSLATION_FALLBACK = (locale, map) -> map.values().iterator().next();
    /**
     * Helper function that creates a new {@link Map} on each invocation.
     */
    private static final Function<String, Map<Locale, Text>> NEW_TRANSLATION_MAP = Functions.supplied(HashMap::new);

    private final Map<String, Map<Locale, Text>> messages = new HashMap<>();
    private final BiFunction<Locale, Map<Locale, Text>, Text> translationFallback;

    /**
     * Creates a new dictionary which uses any locale's translation as fallback
     * in case the requested language's one could not be found.
     */
    public Dictionary() {
        this.translationFallback = TRANSLATION_FALLBACK;
    }

    /**
     * Creates a new dictionary with the given translation fallback.
     *
     * @param translationFallback The translation fallback to use if the
     *        requested there is no translation for the given language, but
     *        translations for other languages
     */
    public Dictionary(BiFunction<Locale, Map<Locale, Text>, Text> translationFallback) {
        this.translationFallback = BiFunctions.nonNullResultOrElse(
                checkNotNull(translationFallback, "translationFallback"), TRANSLATION_FALLBACK);
    }

    /**
     * Adds the given translation to this dictionary's storage.
     *
     * @param translationId The translation id to register the translation for
     * @param locale The locale to register the translation for
     * @param translation The translation to register
     */
    public void addTranslation(String translationId, Locale locale, Text translation) {
        checkNotNull(translationId, "translationId");
        checkNotNull(locale, "locale");
        checkNotNull(translation, "translation");
        this.messages.computeIfAbsent(translationId, NEW_TRANSLATION_MAP).put(locale, translation);
    }

    /**
     * Helper method to get the map containing the translations for the given
     * translation id or a fallback in case there is no translation specified
     * yet.
     *
     * @param translationId The translation id to search
     * @return A map containing the translations for the given translation id
     */
    protected Map<Locale, Text> getTranslations(final String translationId) {
        Map<Locale, Text> translations = this.messages.get(translationId);
        if (translations == null) {
            translations = new HashMap<>();
            translations.put(Locales.DEFAULT, Text.of(translationId));
        }
        return translations;
    }

    /**
     * Gets the best fitting translation for the given translation id and
     * locale.
     *
     * @param translationId The translation id to look for
     * @param locale The requested language
     * @return The best fitting translation for the given translation id and
     *         locale
     */
    public Text getTranslation(String translationId, Locale locale) {
        final Map<Locale, Text> translations = getTranslations(translationId);
        final Text result = translations.get(locale);
        if (result == null) {
            return this.translationFallback.apply(locale, translations);
        } else {
            return result;
        }
    }

    /**
     * Gets a function that will return the best translation for the a given
     * locale for the given translation id.
     *
     * @param translationId The translation id the function should return the
     *        translations for
     * @return A function that will return the best translation for the a given
     *         locale for the given translation id
     */
    @Override
    public Function<Locale, Text> apply(String translationId) {
        checkNotNull(translationId, "translationId");
        return locale -> getTranslation(translationId, locale);
    }

    /**
     * Gets a caching function that will return the best translation for a given
     * locale for the given translation id.
     *
     * @param translationId The translation id the function should return the
     *        translations for
     * @return A function that will return the best matching translation for a
     *         given locale for the given translation id
     */
    public Function<Locale, Text> get(String translationId) {
        return cache(apply(translationId));
    }

    /**
     * Gets a {@link Transformer} containing a caching function that will return
     * the best translation for a given target (using the target key) for the
     * given translation id.
     *
     * @param translationId The translation id the function should return the
     *        translations for
     * @param targetKey The key to get the target from the context later on
     * @return A transformer containing a function that will return the best
     *         matching translation for a given locale for the given translation
     *         id
     * @see #get(String)
     * @see Transformers#multiLanguageSupportWithTarget(String, Function)
     */
    public Transformer<Text> getWithTarget(String translationId, String targetKey) {
        return Transformers.multiLanguageSupportWithTarget(targetKey, get(translationId));
    }

    /**
     * Gets a {@link Transformer} containing a caching function that will return
     * the best translation for a given locale (using the locale key) for the
     * given translation id.
     *
     * @param translationId The translation id the function should return the
     *        translations for
     * @param localeKey The key to get the locale from the context later on
     * @return A transformer containing a function that will return the best
     *         matching translation for a given locale for the given translation
     *         id
     * @see #get(String)
     * @see Transformers#multiLanguageSupportWithLocale(String, Function)
     */
    public Transformer<Text> getWithLocale(String translationId, String localeKey) {
        return Transformers.multiLanguageSupportWithLocale(localeKey, get(translationId));
    }

    /**
     * Gets a function that will cache the results of the given function.
     *
     * @param resolverFunction The function which results should be cached
     * @return A function that will cache the results of the given function
     */
    protected Function<Locale, Text> cache(Function<Locale, Text> resolverFunction) {
        checkNotNull(resolverFunction, "resolverFunction");
        final Map<Locale, Text> map = new HashMap<>();
        return locale -> map.computeIfAbsent(locale, resolverFunction);
    }

    /**
     * Creates a new {@link TranslationPreparator} that can be used to create a
     * function that will format the {@link Text}s obtained from this dictionary
     * and apply the configured formating to it and cache the {@link Text} after
     * that.
     *
     * @param translationId The translation id that should be used to get the
     *        raw translation.
     * @return Gets a caching function that will return the best matching
     *         formated translation for a given locale for the given translation
     *         id
     */
    public TranslationPreparator prepare(String translationId) {
        return new TranslationPreparator(apply(translationId));
    }

    /**
     * Helper class to setup the necessary formating steps that must be executed
     * before the templates can be used.
     */
    public class TranslationPreparator {

        private final FormatBuilder formatBuilder = Text.formatBuilder();
        private final Function<Locale, Text> resolverFunction;

        /**
         * Creates a new TranslationPreparator that uses the given raw resolver
         * {@link Function} to create a function that will apply the configured
         * formating to the returned result.
         *
         * @param rawResolverFunction The raw resolver function to use
         */
        protected TranslationPreparator(Function<Locale, Text> rawResolverFunction) {
            checkNotNull(rawResolverFunction, "rawResolverFunction");
            this.resolverFunction = rawResolverFunction.andThen(this.formatBuilder);
        }

        /**
         * Set the given replacement for the given key. Replacements set with
         * this method will always take precedence over values set by the other
         * methods. Values set using this method can be set/replaced after the
         * format execution. This way you can create lots of similar
         * {@link Text}s by just replacing a single or a few arguments.
         *
         * @param key The key used to set the value
         * @param replacement The replacement to use. Null will unset it
         * @return This instance for chaining
         * @see FormatBuilder#with(String, Object)
         */
        public TranslationPreparator with(String key, @Nullable Object replacement) {
            this.formatBuilder.with(key, replacement);
            return this;
        }

        /**
         * Set the given transformer wrapped in a {@link Placeholder} for the
         * given key. Replacements set with this method will always take
         * precedence over values set by the other methods. Values set using
         * this method can be set/replaced after the format execution. This way
         * you can create lots of similar {@link Text}s by just replacing a
         * single or a few arguments.
         *
         * @param key The key used to set the value
         * @param transformer {@link Transformer} to use in the placeholder
         * @return This instance for chaining
         * @see #with(String, Object)
         */
        public TranslationPreparator with(String key, Transformer<?> transformer) {
            return with(key, Text.placeholder(transformer));
        }

        /**
         * Set the given replacement {@link Supplier} for the given key. This
         * method could be used for counters, indexes and stuff alike. If the
         * supplier returns null the next provider can try to resolve it.
         *
         * <p><b>Note:</b>The given {@link Supplier} is only used if no other
         * previous call provided a replacement for this key.</p>
         *
         * @param key The key used to set the supplier
         * @param supplier The supplier used to get the replacement
         * @return This instance for chaining
         * @see FormatBuilder#with(String,Supplier)
         */
        public TranslationPreparator with(String key, Supplier<?> supplier) {
            this.formatBuilder.with(key, supplier);
            return this;
        }

        /**
         * Set the given replacement {@link Function} for the given key. This
         * method should be used if only some keys should be resolved the given
         * function. If the function returns null the next provider can try to
         * resolve it.
         *
         * <p><b>Note:</b>The given {@link Function} is only used if no other
         * previous call provided a replacement for this key.</p>
         *
         * @param filter The filter used to decide whether the given function
         *        should be used. It will be used if the
         *        {@link Predicate#test(Object) test} returns true
         * @param function The function used to calculate the replacement
         * @return This instance for chaining
         * @see FormatBuilder#with(Predicate, Function)
         */
        public TranslationPreparator with(Predicate<? super String> filter, Function<? super String, ? extends Object> function) {
            this.formatBuilder.with(filter, function);
            return this;
        }

        /**
         * Set the given replacement {@link Function} for all keys. Can be used
         * for both fetching/calculating/returning specific replacements or
         * parsing the input to key to return a generated replacement based on
         * the input specifications. If the function returns null the next
         * provider can try to resolve the key.
         *
         * <p><b>Note:</b>This given {@link Function} is only used if no other
         * previous call provided a replacement for the key.</p>
         *
         * @param function The function used to calculate the replacement
         * @return This instance for chaining
         * @see FormatBuilder#with(Function)
         */
        public TranslationPreparator with(Function<? super String, ? extends Object> function) {
            this.formatBuilder.with(function);
            return this;
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The no fallback strategy will omit the placeholder to allow setting
         * it in a later run.
         *
         * @return This instance for chaining
         * @see FormatBuilder#noFallback()
         */
        public TranslationPreparator noFallback() {
            this.formatBuilder.noFallback();
            return this;
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The constant fallback strategy will always return the given constant.
         * That way you could replace all unresolved {@link Placeholder}s with
         * the empty text.
         *
         * @return This instance for chaining
         * @see FormatBuilder#fallback(Object)
         */
        public TranslationPreparator fallback(Object fallback) {
            this.formatBuilder.fallback(fallback);
            return this;
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The supplier fallback strategy will get the replacement from the
         * given {@link Supplier}.
         *
         * @return This instance for chaining
         * @see FormatBuilder#fallback(Supplier)
         */
        public TranslationPreparator fallback(Supplier<?> supplier) {
            this.formatBuilder.fallback(supplier);
            return this;
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The throwing fallback strategy will throw an
         * {@link IllegalStateException} if no replacement for the given key
         * could be found.
         *
         * @return This instance for chaining
         * @see FormatBuilder#throwingfallback()
         */
        public TranslationPreparator throwingfallback() {
            this.formatBuilder.throwingfallback();
            return this;
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The supplier fallback strategy will get the replacement from the
         * given {@link Function}.
         *
         * @return This instance for chaining
         * @see FormatBuilder#fallback(java.util.function.Function)
         */
        public TranslationPreparator fallback(Function<String, ?> function) {
            this.formatBuilder.fallback(function);
            return this;
        }

        /**
         * Completes the preparation setup and returns a caching function that
         * will return the best matching translation for a given locale.
         *
         * @return A caching function that will return the best matching
         *         translation for a given locale
         */
        public Function<Locale, Text> done() {
            return cache(this.resolverFunction);
        }

        /**
         * Completes the preparation setup and returns a {@link Transformer}
         * that will return the best matching translation for a given target
         * specified via the given target key.
         *
         * @param targetKey The key to get the target from the context later on
         * @return A transformer that will return the best matching translation
         *         for a given target
         * @see #done()
         * @see Transformers#multiLanguageSupportWithTarget(String, Function)
         */
        public Transformer<Text> doneWithTarget(String targetKey) {
            return Transformers.multiLanguageSupportWithTarget(targetKey, done());
        }

        /**
         * Completes the preparation setup and returns a {@link Transformer}
         * that will return the best matching translation for a given locale
         * specified via the given locale key.
         *
         * @param localeKey The key to get the locale from the context later on
         * @return A transformer that will return the best matching translation
         *         for a given target
         * @see #done()
         * @see Transformers#multiLanguageSupportWithLocale(String, Function)
         */
        public Transformer<Text> doneWithLocale(String localeKey) {
            return Transformers.multiLanguageSupportWithLocale(localeKey, done());
        }

    }

}

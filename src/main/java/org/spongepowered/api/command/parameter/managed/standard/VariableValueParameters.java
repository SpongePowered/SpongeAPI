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
package org.spongepowered.api.command.parameter.managed.standard;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.parameter.managed.ValueParameter;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializer;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

// TODO: Better name - or see if we can merge it with "CatalogedValueParameters" which
// may require registry changes.
public class VariableValueParameters {

    private VariableValueParameters() {}

    /**
     * Creates a builder that can build a {@link ValueParameter} that returns
     * an appropriate {@link CatalogType} from an argument.
     *
     * @return The builder
     */
    // TODO: Better solution?
    @SuppressWarnings("unchecked")
    public static CatalogedTypeBuilder<? extends CatalogType> catalogedElementParameterBuilder() {
        return (CatalogedTypeBuilder<? extends CatalogType>) Sponge.getRegistry().createBuilder(CatalogedTypeBuilder.class);
    }

    /**
     * Creates a builder that can build a {@link ValueParameter} that tries to
     * match an argument against a fixed list of choices.
     *
     * <p>If the list of choices changes during the lifetime of the server,
     * use {@link #dynamicChoicesBuilder()} instead.</p>
     *
     * @return The builder
     */
    public static StaticChoicesBuilder<?> staticChoicesBuilder() {
        return (StaticChoicesBuilder<?>) Sponge.getRegistry().createBuilder(StaticChoicesBuilder.class);
    }

    /**
     * Creates a builder that can build a {@link ValueParameter} that tries to
     * match an argument against a dynamic list of choices.
     *
     * <p>If the list of choices does not change during the lifetime of the
     * server, use {@link #staticChoicesBuilder()} instead.</p>
     *
     * @return The builder
     */
    public static DynamicChoicesBuilder<?> dynamicChoicesBuilder() {
        return (DynamicChoicesBuilder<?>) Sponge.getRegistry().createBuilder(DynamicChoicesBuilder.class);
    }

    /**
     * Creates a builder that builds a {@link ValueParameter} that tries to
     * match an argument with a value from a specified enum case-insensitively.
     */
    public static EnumBuilder<? extends Enum<?>> enumBuilder() {
        return (EnumBuilder<? extends Enum<?>>) Sponge.getRegistry().createBuilder(EnumBuilder.class);
    }

    /**
     * Creates a builder that builds a {@link ValueParameter} that tries to
     * match an a series of arguments with a supplied literal.
     */
    public static LiteralBuilder<?> literalBuilder() {
        return (LiteralBuilder<?>) Sponge.getRegistry().createBuilder(LiteralBuilder.class);
    }

    /**
     * Creates a builder that builds a {@link ValueParameter} that tries to
     * construct a {@link Text} from an argument.
     */
    public static TextBuilder textBuilder() {
        return Sponge.getRegistry().createBuilder(TextBuilder.class);
    }

    /**
     * A builder that creates a {@link ValueParameter} that attempts to get a
     * specific {@link CatalogType} by the supplied ID.
     */
    public interface CatalogedTypeBuilder<T extends CatalogType> extends ResettableBuilder<ValueParameter, CatalogedTypeBuilder<T>> {

        /**
         * Sets the {@link CatalogType} that this parameter will search through.
         *
         * @param catalogedType The {@link Class} of the {@link CatalogType} to
         *                      test for
         * @return This builder, for chaining
         */
        <S extends CatalogType> CatalogedTypeBuilder<S> setCatalogedType(Class<S> catalogedType);

        /**
         * Adds a prefix that could be prepended to the input argument if it
         * initially does not match any of the chosen {@link CatalogType}. Any
         * prefixes that are prepended will include the ":" identifier, this
         * should not be part of the supplied prefix in this method.
         *
         * <p>Consider the following example. Assume that we have a catalog
         * type that this element targets with the following IDs currently
         * registered:</p>
         *
         * <ul>
         *     <li>sponge:test</li>
         *     <li>minecraft:test</li>
         *     <li>test:test</li>
         * </ul>
         *
         * <p>Now consider that the argument "test:test" is passed (with any
         * capitalization thereof). It's an exact match, so there is no bother,
         * it's returned by the parameter.</p>
         *
         * <p>Then consider that the argument "test" is passed - this is NOT an
         * exact match. Without specifying any prefixes - this parameter will
         * fail to parse the argument. Sometimes, this isn't desired, and
         * plugins will want to allow players to not have to specify a prefix.
         * So, if the prefix "sponge" is specified here, then "test" will match
         * "sponge:test".</p>
         *
         * <p>Multiple prefixes can be specified. They will be tested in order -
         * in the example above, if the following is specified:</p>
         *
         * <blockquote>
         *     prefix("sponge").prefix("minecraft").prefix("test")
         * </blockquote>
         *
         * <p>then if the argument "test" is passed to the parameter, it will
         * check "test", "sponge:test", "minecraft:test" then "test:test".
         * In the above example, this would match "sponge:test" and return that
         * element.</p>
         *
         *  @param prefix The prefix, without the ":" suffix, to add to the
         *               argument if the parameter fails to find a catalog type
         *               without such a prefix
         * @return This builder, for chaining.
         */
        CatalogedTypeBuilder<T> prefix(String prefix);

        /**
         * Tests for validity and creates this {@link ValueParameter}
         *
         * @return The {@link ValueParameter}
         * @throws IllegalStateException if {@link #setCatalogedType(Class)}
         *         hasn't been called with a valid {@link CatalogType}
         */
        ValueParameter<T> build();

    }

    /**
     * A builder that creates a {@link ValueParameter} that tries to match an
     * argument against a fixed set of choices and returns an appropriate object
     * based on the supplied argument.
     *
     * <p>Note that the choices from such a parameter cannot be changed once
     * this parameter has been built. Should a set of choices that change during
     * the lifetime of the server be required, use the
     * {@link DynamicChoicesBuilder} instead.</p>
     */
    public interface StaticChoicesBuilder<T> extends ResettableBuilder<ValueParameter<T>, StaticChoicesBuilder<T>> {

        /**
         * Sets the type of value that will be returned by this object.
         *
         * @param returnType The {@link Class} of the return type
         * @param <S> The return type
         * @return A builder of the given type.
         */
        <S> StaticChoicesBuilder<S> setReturnType(Class<S> returnType);

        /**
         * Adds a choice to the parameter, along with the object that would be
         * returned if the choice is selected.
         *
         * @param choice The string to be matched
         * @param returnedObject The {@link Object to return}
         * @return This builder, for chaining
         */
        default StaticChoicesBuilder<T> choice(String choice, T returnedObject) {
            return choices(Collections.singleton(choice), () -> returnedObject);
        }

        /**
         * Adds a collection of choices to the parameter, along with the objects
         * that would be returned if the associated choice is selected.
         *
         * @param choices A {@link Map} containing the choices and associated
         *                objects.
         * @return This builder, for chaining
         */
        default StaticChoicesBuilder<T> choices(Map<String, ? extends T> choices) {
            for (Map.Entry<String, ? extends T> entry : choices.entrySet()) {
                choice(entry.getKey(), entry.getValue());
            }

            return this;
        }

        /**
         * Adds a collection of choices to the parameter, along with a
         * {@link Supplier} that will return an object if one of the choices is
         * selected.
         *
         * @param choices The valid choices
         * @param returnedObjectSupplier Supplies the object to return
         * @return This builder, for chaining
         */
        StaticChoicesBuilder<T> choices(Iterable<String> choices, Supplier<? extends T> returnedObjectSupplier);

        /**
         * Sets what should happen if the usage of this parameter is requested.
         *
         * <p>If there are 5 or fewer choices available, and "showInUsage" is
         * true, the choices will be shown in the command usage. Otherwise, the
         * usage will only display only the key.</p>
         *
         * @param showInUsage true if the choices should be shown
         * @return This builder, for chaining
         */
        StaticChoicesBuilder<T> setShowInUsage(boolean showInUsage);

        /**
         * Tests for validity and creates this {@link ValueParameter}
         *
         * @return The {@link ValueParameter}
         * @throws IllegalStateException if no choices have been specified
         */
        ValueParameter<T> build();

    }

    /**
     * A builder that creates a {@link ValueParameter} that tries to match an
     * argument against a dynamic set of choices and returns an appropriate object
     * based on the supplied argument.
     */
    public interface DynamicChoicesBuilder<T> extends ResettableBuilder<ValueParameter<T>, DynamicChoicesBuilder<T>> {

        /**
         * Sets the type of value that will be returned by this object.
         *
         * @param returnType The {@link Class} of the return type
         * @param <S> The return type
         * @return A builder of the given type.
         */
        <S> DynamicChoicesBuilder<S> setReturnType(Class<S> returnType);

        /**
         * Sets the parameter to get its choices from the supplied {@link Map},
         * where each choice is associated with its own object.
         *
         * @param choices A supplier that returns an appropriate map.
         * @return This builder, for chaining
         */
        DynamicChoicesBuilder<T> setChoicesAndResults(Supplier<Map<String, ? extends T>> choices);

        /**
         * Sets the parameter to get its choices from the supplied
         * {@link Iterable}.
         *
         * @param choices A supplier that returns the appropriate choices.
         * @return This builder, for chaining
         */
        DynamicChoicesBuilder<T> setChoices(Supplier<Iterable<String>> choices);

        /**
         * Sets the function which defines what result is returned for
         * a specified choice.
         *
         * @param results A function that returns the appropriate object for
         *                the provided choice
         * @return This builder, for chaining
         */
        DynamicChoicesBuilder<T> setResults(Function<String, ? extends T> results);

        /**
         * Sets what should happen if the usage of this parameter is requested.
         *
         * <p>If there are 5 or fewer choices available, and "showInUsage" is
         * true, the choices will be shown in the command usage. Otherwise, the
         * usage will only display only the key.</p>
         *
         * @param showInUsage true if the choices should be shown
         * @return This builder, for chaining
         */
        DynamicChoicesBuilder<T> setShowInUsage(boolean showInUsage);

        /**
         * Tests for validity and creates this {@link ValueParameter}.
         *
         * @return The {@link ValueParameter}
         * @throws IllegalStateException if no choices have been specified
         */
        ValueParameter<T> build();

    }

    /**
     * A builder that creates {@link ValueParameter}s that allow arguments to be
     * matched to {@link Enum}s
     */
    public interface EnumBuilder<T extends Enum<T>> extends ResettableBuilder<ValueParameter, EnumBuilder<T>> {

        /**
         * Sets the {@link Enum} to test against.
         */
        <S extends Enum<S>> EnumBuilder<S> setEnumClass(Class<S> enumClass);

        /**
         * Tests for validity and creates this {@link ValueParameter}.
         *
         * @return The {@link ValueParameter}
         * @throws IllegalStateException if {@link #setEnumClass(Class)} has not
         *             been called with a valid enum class
         */
        ValueParameter<T> build();

    }

    /**
     * A builder that creates {@link ValueParameter}s that requires a specific
     * sequence of arguments.
     */
    public interface LiteralBuilder<T> extends ResettableBuilder<ValueParameter<T>, LiteralBuilder<T>> {

        /**
         * Sets a {@link Supplier} that provides the sequence of strings that
         * need to be matched at runtime.
         *
         * <p>Consumers of the API should supply an ordered collection.</p>
         *
         * @param literalSupplier The {@link Supplier}
         * @return This builder, for chaining
         */
        LiteralBuilder<T> setLiteral(Supplier<Iterable<String>> literalSupplier);

        /**
         * Sets the sequence of strings that need to be matched at runtime.
         *
         * <p>Consumers of the API should supply an ordered collection.</p>
         *
         * @param literal The sequence of elements
         * @return This builder, for chaining
         */
        default LiteralBuilder<T> setLiteral(Iterable<String> literal) {
            return setLiteral(() -> literal);
        }

        /**
         * Sets a {@link Supplier} that provides the object to return
         * if this parameter parses correctly.
         *
         * @param returnValueSupplier The {@link Supplier}
         * @return This builder, for chaining
         */
        <S> LiteralBuilder<S> setReturnValue(Supplier<S> returnValueSupplier);

        /**
         * Sets the object to return if this parameter parses correctly.
         *
         * @param returnValue The {@link Object}
         * @return This builder, for chaining
         */
        default <S> LiteralBuilder<S> setReturnValue(S returnValue) {
            return setReturnValue(() -> returnValue);
        }

        /**
         * Tests for validity and creates this {@link ValueParameter}.
         *
         * @return The {@link ValueParameter}
         * @throws IllegalStateException if the literal and the return object
         *             have not been specified
         */
        ValueParameter<T> build();

    }

    public interface TextBuilder extends ResettableBuilder<ValueParameter<Text>, TextBuilder> {

        /**
         * Sets the {@link TextSerializer} for use by the element.
         *
         * <p>Setting this will replace any {@link TextSerializer}s or
         * {@link Supplier}s that has already been set on this builder.</p>
         *
         * @param serializer A {@link TextSerializer}
         * @return This builder, for chaining
         */
        TextBuilder setSerializer(TextSerializer serializer);

        /**
         * Sets the {@link TextSerializer} for use by the element, though the
         * use of a {@link Supplier}.
         *
         * <p>Setting this will replace any {@link TextSerializer}s or
         * {@link Supplier}s that has already been set on this builder.</p>
         *
         * @param serializerSupplier A {@link Supplier} that will supply a
         *      {@link TextSerializer}
         * @return This builder, for chaining
         */
        TextBuilder setSerializerSupplier(Supplier<TextSerializer> serializerSupplier);

        /**
         * Sets whether the parameter will use all the arguments left in the
         * chain, or whether it will just consume one.
         *
         * @param allArguments Whether all arguments will be consumed
         * @return This builder, for chaining
         */
        TextBuilder setConsumeAllArguments(boolean allArguments);

        /**
         * Tests for validity and creates this {@link ValueParameter}.
         *
         * @return The {@link ValueParameter}
         * @throws IllegalStateException if the {@link TextSerializer} has not
         *             been specified
         */
        ValueParameter<Text> build() throws IllegalStateException;

    }

}

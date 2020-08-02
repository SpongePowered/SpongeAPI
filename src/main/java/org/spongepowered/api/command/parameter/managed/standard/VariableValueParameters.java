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

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.ComponentSerializer;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.parameter.managed.ValueParameter;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

/**
 * Builders and factory for parameters that require configuration.
 */
public class VariableValueParameters {

    private VariableValueParameters() {}

    /**
     * Creates a builder that can build a {@link ValueParameter} that returns
     * an appropriate {@link CatalogType} from an argument.
     *
     * @param <T> The type of catalog
     * @param returnType The return type
     * @return The builder
     */
    public static <T extends CatalogType> CatalogedTypeBuilder<T> catalogedElementParameterBuilder(final Class<T> returnType) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createCatalogedTypesBuilder(returnType);
    }

    /**
     * Creates a builder that can build a {@link ValueParameter} that tries to
     * match an argument against a fixed list of choices.
     *
     * <p>If the list of choices changes during the lifetime of the server,
     * use {@link #dynamicChoicesBuilder(Class)} instead.</p>
     *
     * @param returnType The type of object that the resulting
     *                   {@link ValueParameter} will return.
     * @param <T> The type that will be returned
     * @return The builder
     */
    public static <T> StaticChoicesBuilder<T> staticChoicesBuilder(final Class<T> returnType) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createStaticChoicesBuilder(returnType);
    }

    /**
     * Creates a builder that can build a {@link ValueParameter} that tries to
     * match an argument against a dynamic list of choices.
     *
     * <p>If the list of choices does not change during the lifetime of the
     * server, use {@link #staticChoicesBuilder(Class)} instead.</p>
     *
     * @param returnType The type of object that the resulting
     *                   {@link ValueParameter} will return.
     * @param <T> The type that will be returned
     * @return The builder
     */
    public static <T> DynamicChoicesBuilder<T> dynamicChoicesBuilder(final Class<T> returnType) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createDynamicChoicesBuilder(returnType);
    }

    /**
     * Creates a builder that builds a {@link ValueParameter} that tries to
     * match an a series of arguments with a supplied literal.
     *
     * @param returnType The type of object that the resulting
     *                   {@link ValueParameter} will return.
     * @param <T> The type that will be returned
     * @return The builder
     */
    public static <T> LiteralBuilder<T> literalBuilder(final Class<T> returnType) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createLiteralBuilder(returnType);
    }

    /**
     * Creates a builder that builds a {@link ValueParameter} that tries to
     * construct a {@link Component} from an argument.
     * @return The new builder
     */
    public static TextBuilder textBuilder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(TextBuilder.class);
    }

    /**
     * Creates a {@link ValueParameter} that tries to match an argument with a
     * value from a specified enum case-insensitively.
     *
     * @param enumClass The {@link Enum} class type that this will represent
     * @param <T> The {@link Enum} class type
     * @return The appropriate {@link ValueParameter}
     */
    public static <T extends Enum<T>> ValueParameter<T> enumChoices(final Class<T> enumClass) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createEnumParameter(enumClass);
    }

    /**
     * Creates a {@link NumberRangeBuilder} that creates a bounded double
     * {@link ValueParameter}.
     *
     * @return The {@link NumberRangeBuilder}
     */
    public static NumberRangeBuilder<Double> doubleRange() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createDoubleNumberRangeBuilder();
    }

    /**
     * Creates a {@link NumberRangeBuilder} that creates a bounded float
     * {@link ValueParameter}.
     *
     * @return The {@link NumberRangeBuilder}
     */
    public static NumberRangeBuilder<Float> floatRange() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createFloatNumberRangeBuilder();
    }

    /**
     * Creates a {@link NumberRangeBuilder} that creates a bounded integer
     * {@link ValueParameter}.
     *
     * @return The {@link NumberRangeBuilder}
     */
    public static NumberRangeBuilder<Integer> integerRange() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createIntegerNumberRangeBuilder();
    }

    /**
     * Creates a {@link NumberRangeBuilder} that creates a bounded long
     * {@link ValueParameter}.
     *
     * @return The {@link NumberRangeBuilder}
     */
    public static NumberRangeBuilder<Long> longRange() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).createLongNumberRangeBuilder();
    }

    /**
     * Creates a {@link ValueParameter} that validates the input.
     *
     * @param pattern The {@link Pattern} used to validate the string
     * @return The {@link ValueParameter}
     */
    public static ValueParameter<String> validatedString(final Pattern pattern) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class)
                .createValidatedStringParameter(pattern);
    }

    /**
     * A builder that creates a {@link ValueParameter} that attempts to get a
     * specific {@link CatalogType} by the supplied ID.
     */
    public interface CatalogedTypeBuilder<T extends CatalogType> extends ResettableBuilder<ValueParameter<T>, CatalogedTypeBuilder<T>> {

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
        CatalogedTypeBuilder<T> defaultNamespace(String prefix);

        /**
         * Tests for validity and creates this {@link ValueParameter}
         *
         * @return The {@link ValueParameter}
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
         * Adds a choice to the parameter, along with the object that would be
         * returned if the choice is selected.
         *
         * @param choice The string to be matched
         * @param returnedObject The {@link Object to return}
         * @return This builder, for chaining
         */
        default StaticChoicesBuilder<T> choice(final String choice, final T returnedObject) {
            return this.choices(Collections.singleton(choice), () -> returnedObject);
        }

        /**
         * Adds a collection of choices to the parameter, along with the objects
         * that would be returned if the associated choice is selected.
         *
         * @param choices A {@link Map} containing the choices and associated
         *                objects.
         * @return This builder, for chaining
         */
        default StaticChoicesBuilder<T> choices(final Map<String, ? extends T> choices) {
            for (final Map.Entry<String, ? extends T> entry : choices.entrySet()) {
                this.choice(entry.getKey(), entry.getValue());
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
         * Sets the parameter to get its choices from the supplied {@link Map},
         * where each choice is associated with its own object.
         *
         * @param choices A supplier that returns an appropriate map.
         * @return This builder, for chaining
         */
        DynamicChoicesBuilder<T> setChoicesAndResults(Supplier<Map<String, ? extends T>> choices);

        /**
         * Sets the parameter to get its choices from the supplied
         * {@link Collection}.
         *
         * @param choices A supplier that returns the appropriate choices.
         * @return This builder, for chaining
         */
        DynamicChoicesBuilder<T> setChoices(Supplier<? extends Collection<String>> choices);

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
        LiteralBuilder<T> setLiteral(Supplier<? extends Collection<String>> literalSupplier);

        /**
         * Sets the sequence of strings that need to be matched at runtime.
         *
         * <p>Consumers of the API should supply an ordered collection.</p>
         *
         * @param literal The sequence of elements
         * @return This builder, for chaining
         */
        default LiteralBuilder<T> setLiteral(final Collection<String> literal) {
            return this.setLiteral(() -> literal);
        }

        /**
         * Sets a {@link Supplier} that provides the object to return
         * if this parameter parses correctly.
         *
         * @param returnValueSupplier The {@link Supplier}
         * @return This builder, for chaining
         */
        LiteralBuilder<T> setReturnValue(Supplier<T> returnValueSupplier);

        /**
         * Sets the object to return if this parameter parses correctly.
         *
         * @param returnValue The {@link Object}
         * @return This builder, for chaining
         */
        default LiteralBuilder<T> setReturnValue(final T returnValue) {
            return this.setReturnValue(() -> returnValue);
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

    /**
     * A builder that creates a parameter that serializes strings into
     * {@link Component}.
     */
    public interface TextBuilder extends ResettableBuilder<ValueParameter<Component>, TextBuilder> {

        /**
         * Sets the {@link ComponentSerializer} for use by the element.
         *
         * <p>Setting this will replace any {@link ComponentSerializer}s or
         * {@link Supplier}s that has already been set on this builder.</p>
         *
         * @param serializer A {@link ComponentSerializer}
         * @return This builder, for chaining
         */
        TextBuilder setSerializer(ComponentSerializer<Component, ? extends Component, String> serializer);

        /**
         * Sets the {@link ComponentSerializer} for use by the element, though the
         * use of a {@link Supplier}.
         *
         * <p>Setting this will replace any {@link ComponentSerializer}s or
         * {@link Supplier}s that has already been set on this builder.</p>
         *
         * @param serializerSupplier A {@link Supplier} that will supply a
         *      {@link ComponentSerializer}
         * @return This builder, for chaining
         */
        TextBuilder setSerializerSupplier(Supplier<ComponentSerializer<Component, ? extends Component, String>> serializerSupplier);

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
         * @throws IllegalStateException if the {@link ComponentSerializer} has not
         *             been specified
         */
        ValueParameter<Component> build() throws IllegalStateException;

    }

    /**
     * A builder that creates a parameter that can parse a bounded
     * {@link Number}.
     *
     * @param <T> The {@link Number} type
     */
    public interface NumberRangeBuilder<T extends Number> extends ResettableBuilder<ValueParameter<T>, NumberRangeBuilder<T>> {

        /**
         * Sets the minimum value that the parser will parse.
         *
         * <p>Defaults to the minimum allowable value for {@link T}</p>
         *
         * @param min The minimum value
         * @return This builder, for chaining
         */
        NumberRangeBuilder<T> setMin(T min);

        /**
         * Sets the maximum value that the parser will parse.
         *
         * <p>Defaults to the maximum allowable value for {@link T}</p>
         *
         * @param max The maximum value
         * @return This builder, for chaining
         */
        NumberRangeBuilder<T> setMax(T max);

        /**
         * Tests for validity and creates this {@link ValueParameter}.
         *
         * @return The {@link ValueParameter}
         * @throws IllegalStateException if the minimum is greater than the
         *              maximum
         */
        ValueParameter<T> build();

    }

    /**
     * A factory that creates {@link ValueParameter}s or their builders.
     */
    public interface Factory {

        /**
         * Creates the {@link ValueParameter} for the specified {@link Enum}
         *
         * @param enumClass The {@link Enum} type to base the choices on
         * @param <T> The type of {@link Enum}
         * @return The {@link ValueParameter}
         */
        <T extends Enum<T>> ValueParameter<T> createEnumParameter(Class<T> enumClass);

        /**
         * Creates the {@link StaticChoicesBuilder} that will create objects
         * that parse objects and return results of type {@code T}.
         *
         * @param returnType The {@link Class} of {@code T}
         * @param <T> The parser return type
         * @return The builder
         */
        <T> StaticChoicesBuilder<T> createStaticChoicesBuilder(Class<T> returnType);

        /**
         * Creates the {@link DynamicChoicesBuilder} that will create objects
         * that parse objects and return results of type {@code T}.
         *
         * @param returnType The {@link Class} of {@code T}
         * @param <T> The parser return type
         * @return The builder
         */
        <T> DynamicChoicesBuilder<T> createDynamicChoicesBuilder(Class<T> returnType);

        /**
         * Creates the {@link CatalogedTypeBuilder} that will create objects
         * that parse objects and return results of type {@code T}.
         *
         * @param returnType The {@link Class} of {@code T}
         * @param <T> The parser return type
         * @return The builder
         */
        <T extends CatalogType> CatalogedTypeBuilder<T> createCatalogedTypesBuilder(Class<T> returnType);

        /**
         * Creates the {@link LiteralBuilder} that will create objects
         * that parse objects and return results of type {@code T}.
         *
         * @param returnType The {@link Class} of {@code T}
         * @param <T> The parser return type
         * @return The builder
         */
        <T> LiteralBuilder<T> createLiteralBuilder(Class<T> returnType);

        /**
         * Creates a {@link NumberRangeBuilder} for integer values.
         *
         * @return The {@link NumberRangeBuilder}
         */
        NumberRangeBuilder<Integer> createIntegerNumberRangeBuilder();

        /**
         * Creates a {@link NumberRangeBuilder} for float values.
         *
         * @return The {@link NumberRangeBuilder}
         */
        NumberRangeBuilder<Float> createFloatNumberRangeBuilder();

        /**
         * Creates a {@link NumberRangeBuilder} for double values.
         *
         * @return The {@link NumberRangeBuilder}
         */
        NumberRangeBuilder<Double> createDoubleNumberRangeBuilder();

        /**
         * Creates a {@link NumberRangeBuilder} for long values.
         *
         * @return The {@link NumberRangeBuilder}
         */
        NumberRangeBuilder<Long> createLongNumberRangeBuilder();

        /**
         * Creates a {@link ValueParameter} that validates its input against
         * a {@link Pattern}.
         *
         * @param pattern The {@link Pattern}
         * @return The {@link ValueParameter}
         */
        ValueParameter<String> createValidatedStringParameter(Pattern pattern);

    }

}

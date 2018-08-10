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
package org.spongepowered.api.text;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Represents a re-usable template that produces a formatted
 * {@link Text.Builder}. Elements will be appended to the result builder in the
 * order that they are specified in {@link #of(Object...)}.
 */
public interface TextTemplate extends Iterable<Object>, TextRepresentable {

    /**
     * Default "open" String for how arguments are contained within the
     * template.
     */
    String DEFAULT_OPEN_ARG = "{";
    /**
     * Default "close" String for how arguments are contained within the
     * template.
     */
    String DEFAULT_CLOSE_ARG = "}";

    /**
     * Returns the elements contained in this TextTemplate.
     *
     * @return The elements within the template
     */
    List<Object> getElements();

    /**
     * Returns the arguments contained within the TextTemplate.
     *
     * @return The arguments within this TextTemplate
     */
    Map<String, Arg> getArguments();

    /**
     * Returns the string used for containing Args within the template.
     *
     * @return String containing args
     */
    String getOpenArgString();

    /**
     * Returns the string used for containing Args within the template.
     *
     * @return String containing args
     */
    String getCloseArgString();

    /**
     * Concatenates the specified {@link TextTemplate} to this template and
     * returns the result. In the event that the two templates' open/close
     * argument containers vary, this template's argument containers will be
     * used.
     *
     * @param other To concatenate
     * @return Concatenated template
     */
    TextTemplate concat(TextTemplate other);

    /**
     * Applies an empty map of parameters to this TextTemplate and returns the
     * result in a {@link Text.Builder}.
     *
     * @return Text builder containing result
     * @throws TextTemplateArgumentException if required parameters are missing
     */
    Text.Builder apply();

    /**
     * Applies the specified parameters to this TextTemplate and returns the
     * result in a {@link Text.Builder}.
     *
     * @param params Parameters to apply
     * @return Text builder containing result
     * @throws TextTemplateArgumentException if required parameters are missing
     */
    Text.Builder apply(Map<String, ?> params);

    /**
     * Constructs a new TextTemplate for the given elements. The order of the
     * elements is the order in which they will be appended to the result
     * builder via {@link #apply(Map)}.
     *
     * <p>The provided elements may be of any type.</p>
     *
     * <p>In the case that an element is a {@link TextElement},
     * {@link TextElement#applyTo(Text.Builder)} will be used to append the
     * element to the builder.</p>
     *
     * <p>In the case that an element is an {@link Arg} the argument will be
     * replaced with the {@link TextElement} provided by the corresponding
     * parameter supplied by {@link #apply(Map)}</p>
     *
     * <p>In the case that an element is any other type, the parameter value's
     * {@link Object#toString()} method will be used to create a {@link Text}
     * object.</p>
     *
     * @param elements Elements to append to builder
     * @param openArg String to use for beginning of Arg containers
     * @param closeArg String to use for end of Arg containers
     * @return Newly constructed TextTemplate
     */
    @SuppressWarnings("deprecation")
    static TextTemplate of(String openArg, String closeArg, Object[] elements) {
        return Sponge.getRegistry().getTextFactory().template(openArg, closeArg, elements);
    }

    /**
     * Constructs a new TextTemplate for the given elements. The order of the
     * elements is the order in which they will be appended to the result
     * builder via {@link #apply(Map)}.
     *
     * <p>The provided elements may be of any type.</p>
     *
     * <p>In the case that an element is a {@link TextElement},
     * {@link TextElement#applyTo(Text.Builder)} will be used to append the
     * element to the builder.</p>
     *
     * <p>In the case that an element is an {@link Arg} the argument will be
     * replaced with the {@link TextElement} provided by the corresponding
     * parameter supplied by {@link #apply(Map)}</p>
     *
     * <p>In the case that an element is any other type, the parameter value's
     * {@link Object#toString()} method will be used to create a {@link Text}
     * object.</p>
     *
     * @param elements Elements to append to builder
     * @return Newly constructed TextTemplate
     */
    static TextTemplate of(Object... elements) {
        return of(DEFAULT_OPEN_ARG, DEFAULT_CLOSE_ARG, elements);
    }

    /**
     * Returns the empty representation of a TextTemplate.
     *
     * @return Empty TextTemplate
     */
    @SuppressWarnings("deprecation")
    static TextTemplate of() {
        return Sponge.getRegistry().getTextFactory().emptyTemplate();
    }

    /**
     * Constructs a new {@link Arg} to be supplied to {@link #of(Object...)}.
     * This argument expects a {@link TextElement} parameter.
     *
     * @param name name of argument
     * @return argument builder
     */
    static Arg.Builder arg(String name) {
        return Sponge.getRegistry().createBuilder(Arg.Builder.class).name(name);
    }

    /**
     * Represents a variable element within a TextTemplate. Arguments are
     * replaced by parameters in {@link #apply(Map)}.
     */
    interface Arg extends TextRepresentable {

        /**
         * Returns the name of this argument to be matched with incoming
         * parameters.
         *
         * @return Argument name
         */
        String getName();

        /**
         * Returns true if this Arg is optional. If a parameter is missing for
         * a non-optional Arg, a {@link TextTemplateArgumentException} will be
         * thrown.
         *
         * @return True if optional
         */
        boolean isOptional();

        /**
         * Returns the default value to use if the Arg {@link #isOptional()}
         * and no parameter is supplied.
         *
         * @return Default value
         */
        Optional<Text> getDefaultValue();

        /**
         * Returns the base format to be applied to this Arg.
         *
         * @return Base format
         */
        TextFormat getFormat();

        /**
         * Returns the beginning string of the Arg's container.
         *
         * @return Open string
         */
        String getOpenArgString();

        /**
         * Returns the end string of the Arg's container.
         *
         * @return Close string
         */
        String getCloseArgString();

        /**
         * Represents a builder for {@link Arg}s.
         */
        interface Builder extends ResettableBuilder<Arg, Builder> {

            /**
             * Sets the name of this arg.
             *
             * @param name The name
             * @return This builder
             */
            Builder name(String name);

            /**
             * Makes the Arg optional.
             *
             * @return This builder
             */
            default Builder optional() {
                return this.optional(true);
            }

            /**
             * Sets whether the Arg should be optional (false by default).
             *
             * @param optional True if should be optional
             * @return This builder
             */
            Builder optional(boolean optional);

            /**
             * Sets the default value for the Argument. The argument must by
             * optional in order for this value to be used.
             *
             * @param defaultValue Default value
             * @return This builder
             */
            Builder defaultValue(Text defaultValue);

            /**
             * Sets the "base" format of the Arg. This acts as a default format
             * when no formatting data is provided by the parameter.
             *
             * @param format Base format of Arg
             * @return This builder
             */
            Builder format(TextFormat format);

            /**
             * Sets the "base" color of the Arg. This acts as a default color
             * when no color data is provided by the parameter.
             *
             * @param color Base color of Arg
             * @return This builder
             */
            Builder color(TextColor color);

            /**
             * Sets the "base" style of the Arg. This acts as a default style
             * when no style data is provided by the parameter.
             *
             * @param style Base style of Arg
             * @return This builder
             */
            Builder style(TextStyle style);

            /**
             * Builds a new {@link Arg}. Note that it is not necessary to call
             * this method when supplying an argument to a template. You may
             * pass the builder to {@link TextTemplate#of(Object...)} directly.
             *
             * @return Newly created Arg
             */
            Arg build();
        }
    }
}

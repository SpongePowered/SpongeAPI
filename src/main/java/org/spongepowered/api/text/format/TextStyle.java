/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.text.format;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.text.message.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * A TextStyle represents an immutable text style of a {@link Message}.
 * It is a utility that is not normally present in Minecraft.
 *
 * <p>
 * Combined styles can be created using {@link TextStyles#of(TextStyle...)} or
 * using one of the {@link #and(TextStyle...)}, {@link #andNot (TextStyle...)}
 * or {@link #negate()} method.
 * </p>
 *
 * <p>
 * One can consider any given text style as a N-d vector where each dimension
 * corresponds to one of the base text styles(this is why they are called base,
 * for "basis vector"). Each dimension's value can be 1, 0, or -1, standing
 * for applied, unapplied, and negated, represented by the
 * {@link org.spongepowered.api.text.format.TextStyle.TextStyleComponent} enum.
 * A TextStyle is like a vector with each component
 * corresponding to the value of the corresponding dimension, a Base TextStyle.
 * </p>
 *
 * <p>
 * The adding of these vectors results in a
 * TextStyle that is a composition of its basis text styles, and this is
 * represented by the {@link #and(TextStyle...)} operation. Negating
 * a text style is like taking the negative of a vector, or multiplying all of its
 * components by -1, and is represented by the {@link #negate()} operation.
 * </p>
 *
 * <p>
 * Implementation note: the way TextStyles are serialized to the raw JSON
 * format should be a component-wise serialization of the various bases
 * into booleans.
 * </p>
 *
 * @see TextStyles
 */
public class TextStyle {

    /**
     * This map stores the text style's components.
     */
    protected Map<Base, TextStyleComponent> components;

    /**
     * Constructs a new TextStyle from the given components.
     *
     * @param components The components to build this TextStyle from as a basis
     */
    public TextStyle(Map<Base, TextStyleComponent> components) {
        this.components = ImmutableMap.copyOf(components);
    }

    /**
     * Constructs an empty TextStyle.
     */
    public TextStyle() {
        this(new ImmutableMap.Builder<Base, TextStyleComponent>().build());
    }

    /**
     * Returns whether this text style is a composite of multiple text styles.
     *
     * @return True if this text style is a composite
     */
    public boolean isComposite() {
        // Return true by default as the TextStyle class is composite by default
        return true;
    }

    /**
     * Returns whether the given {@link TextStyle} is contained in this
     * {@link TextStyle}.
     *
     * <p>
     * For example, a {@link TextStyle} with {@code [Bold, Italic]} would return
     * true for <code>is({@link TextStyles#BOLD})</code> and
     * <code>is({@link TextStyles#ITALIC}).</code>
     * </p>
     *
     * <p>
     * If the specified {@link TextStyle} is a composite of multiple styles it
     * returns true if this style has at least all of the properties set in the
     * specified style.
     * </p>
     *
     * @param style The text style to check
     * @return True if the given text style is contained in this text style
     */
    public boolean is(TextStyle style) {
        for (Map.Entry<Base, TextStyleComponent> entry: style.components.entrySet()) {
            if (applied(entry.getKey()).compareTo(TextStyleComponent.APPLIED) < 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks for how the given Base TextStyle is applied in this composite.
     * Any Base TextStyle that is not defined in the component map is
     * automatically {@link TextStyleComponent#UNAPPLIED}.
     *
     * <p>
     * As examples, <code>TextStyles.BOLD.applied(TextStyles.BOLD)</code>
     * results in <code>TextStyleComponent.APPLIED</code>,
     * <code>TextStyles.ITALICS.applied(TextStyles.BOLD)</code> results in
     * <code>TextStyleComponent.UNAPPLIED</code>, and
     * <code>TextStyles.BOLD.negate().applied(TextStyles.BOLD)</code> results
     * in <code>TextStyleComponent.NEGATE</code>
     * </p>
     *
     * @param style The given Base TextStyle
     * @return The TextStyleComponent which represents the application of the given
     *          base text style
     * @see org.spongepowered.api.text.format.TextStyle.TextStyleComponent
     */
    public TextStyleComponent applied(Base style) {
        if (components.containsKey(style)) {
            return components.get(style);
        } else {
            return TextStyleComponent.UNAPPLIED;
        }
    }

    /**
     * Negates this {@link TextStyle}. This is useful for undoing text styles
     * that are inherited from parent messages.
     *
     * @return The inverse of this text style
     */
    public TextStyle negate() {
        // Do a negation of each component
        ImmutableMap.Builder<Base, TextStyleComponent> newComponents =
                new ImmutableMap.Builder<Base, TextStyleComponent>();
        for (Map.Entry<Base, TextStyleComponent> entry: components.entrySet()) {
            newComponents.put(entry.getKey(), entry.getValue().negate());
        }
        return new TextStyle(newComponents.build());
    }

    /**
     * Composes this {@link TextStyle} with the specified text styles.
     *
     * @param styles The text styles to compose this one with
     * @return A new text style composed out of the given text styles
     */
    public TextStyle and(TextStyle... styles) {
        // We can't use a builder here because we have to remove values
        Map<Base, TextStyleComponent> newComponents =
                new HashMap<Base, TextStyleComponent>();
        newComponents.putAll(components);
        for (TextStyle style: styles) {
            for (Map.Entry<Base, TextStyleComponent> entry: style.components.entrySet()) {
                Base base = entry.getKey();
                TextStyleComponent component = applied(base).add(entry.getValue());
                if (component.equals(TextStyleComponent.UNAPPLIED)) {
                    if (newComponents.containsKey(base)) {
                        newComponents.remove(base);
                    }
                } else {
                    newComponents.put(base, component);
                }
            }
        }
        return new TextStyle(newComponents);
    }

    /**
     * Composes this {@link TextStyle} with the passed in TextStyles, but
     * negates them before composition. This is the same as negating all the
     * passed in {@link TextStyle} and then using the {@link #and(TextStyle...)}
     * method.
     *
     * @param styles The text styles to compose this one with
     * @return A new text style composed out of the given text styles
     */
    public TextStyle andNot(TextStyle... styles) {
        TextStyle[] negated = new TextStyle[styles.length];
        for (int i = 0; i < negated.length; i++) {
            negated[i] = styles[i].negate();
        }
        return and(negated);
    }

    /**
     * A Base text style is a text style that is represented in Minecraft.
     * There  are several Base styles specified in
     * {@link TextStyles} which are the
     * Minecraft base types. Base extends FormattingCode because it does have a
     * corresponding formatting code; it is a single, pure text style.
     */
    public static class Base extends TextStyle implements BaseFormatting {

        /**
         * The name of this Base TextStyle.
         */
        private final String name;

        /**
         * The char code behind this Base TextStyle.
         */
        private final char code;

        /**
         * Constructs a new Base text style.
         *
         * @param name The name of the TextStyle
         * @param code The char code behind this TextStyle
         */
        public Base(String name, char code) {
            ImmutableMap.Builder<Base, TextStyleComponent> builder =
                    new ImmutableMap.Builder<Base, TextStyleComponent>();
            builder.put(this, TextStyleComponent.APPLIED);
            components = builder.build();
            this.name = name;
            this.code = code;
        }

        @Override
        public boolean isComposite() {
            // By definition, base TextStyles are not composites
            return false;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        @Deprecated
        public char getCode() {
            return code;
        }

    }

    /**
     * TextStyleComponent represents the state of a base TextStyle in a composite one.
     *
     * <p>Composite TextStyles are implemented as a map from base TextStyles
     * (what they're composed of) to a TextStyleComponent, which represents if the
     * base TextStyle in question is being applied.</p>
     *
     * <p>Any given TextStyleComponent behaves like a standard integer, meaning
     * that it can be negated or added. This is the basis for the behavior
     * of TextStyle itself.</p>
     */
    public static enum TextStyleComponent {

        /**
         * Represents a base TextStyle that is applied.
         */
        APPLIED(1, Optional.of(true)),

        /**
         * Represents a base TextStyle that is not applied.
         */
        UNAPPLIED(0, Optional.<Boolean>absent()),

        /**
         * Represents a base TextStyle that is negated.
         */
        NEGATED(-1, Optional.of(false));

        /**
         * A map to retrieve text style components from their integer values.
         */
        private static Map<Integer, TextStyleComponent> fromInteger = new HashMap<Integer, TextStyleComponent>();


        // Add all values to the map
        static {
            fromInteger.put(1, APPLIED);
            fromInteger.put(0, UNAPPLIED);
            fromInteger.put(-1, NEGATED);
        }

        /**
         * The value of a component as an integer.
         */
        private final int intValue;

        /**
         * The value of the component as an optional boolean.
         */
        private final Optional<Boolean> boolValue;

        /**
         * Constructs a component.
         *
         * @param intValue The value of the component as an int
         * @param boolValue The value of the component as a boolean optional
         */
        private TextStyleComponent(int intValue, Optional<Boolean> boolValue) {
            this.intValue = intValue;
            this.boolValue = boolValue;
        }

        /**
         * Adds this TextStyleComponent to the given one.
         *
         * @param that The given component
         * @return A new TextStyleComponent
         */
        public TextStyleComponent add(TextStyleComponent that) {
            return valueOf(intValue + that.intValue);
        }

        /**
         * Negates this TextStyleComponent.
         *
         * @return The negated TextStyleComponent
         */
        public TextStyleComponent negate() {
            return valueOf(-intValue);
        }

        /**
         * Compares two TextStyleComponents for equality.
         *
         * @param that The given TextStyleComponent
         * @return True if the two components are equal, otherwise false
         */
        public boolean equals(TextStyleComponent that) {
            return that.intValue == this.intValue;
        }

        /**
         * Converts this TextStyleComponent to an integer.
         *
         * @return The integer form of this component
         */
        public int toInteger() {
            return intValue;
        }

        /**
         * Converts this TextStyleComponent to an optional boolean. If this
         * component's value is 0 then {@link Optional#absent()} is returned.
         *
         * @return This component as a boolean or {@link Optional#absent()}
         */
        public Optional<Boolean> toBoolean() {
            return boolValue;
        }

        /**
         * Gets a TextStyleComponent from an integer intValue, cutting off anything
         * not in the domain [-1, 1].
         *
         * @param value The intValue of the component as a string
         * @return The TextStyleComponent as a intValue
         */
        public static TextStyleComponent valueOf(int value) {
            if (value > 1) {
                return fromInteger.get(1);
            } else if (value < -1) {
                return fromInteger.get(-1);
            } else {
                return fromInteger.get(value);
            }
        }

    }

}

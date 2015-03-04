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
package org.spongepowered.api.util;

import javax.annotation.Nullable;

/**
 * Base interface for immutable properties.
 *
 * @param <K> The key of the property
 * @param <V> The type of the value of the property
 * @param <C> The implementing type
 */
public interface Property<K, V, C extends Property<?, ?, C>> extends Comparable<C> {

    /**
     * Operator used to indicate to a query what operation to use when comparing
     * this property with properties present on an item stack.
     */
    public static enum Operator {

        /**
         * No operator, use the operator from the <em>other</em> property when
         * comparing. If both properties have their operator set as DELEGATE,
         * then comparison will always return false.
         */
        DELEGATE {
            @Override
            protected boolean apply(Property<?, ?, ?> operand1, Property<?, ?, ?> operand2) {
                return operand2.getOperator() != Operator.DELEGATE && operand2.getOperator().compare(operand1, operand2);
            }
        },

        /**
         * Use the <code>.equals()</code> method
         */
        EQUAL {
            @Override
            protected boolean apply(Property<?, ?, ?> operand1, Property<?, ?, ?> operand2) {
                return operand2.equals(operand1);
            }
        },

        /**
         * Use the <code>.equals()</code> method but match if the result is
         * false
         */
        NOTEQUAL {
            @Override
            protected boolean apply(Property<?, ?, ?> operand1, Property<?, ?, ?> operand2) {
                return !operand2.equals(operand1);
            }
        },

        /**
         * Use <code>.compareTo()</code> amd match if target is greater than
         * supplied operand
         */
        GREATER {
            @Override
            protected boolean apply(Property<?, ?, ?> operand1, Property<?, ?, ?> operand2) {
                @SuppressWarnings({"unchecked", "rawtypes"})
                int result = ((Comparable) operand2).compareTo(operand1);
                return result > 0;
            }
        },

        /**
         * Use <code>.compareTo()</code> amd match if target is greater than
         * or equal to supplied operand
         */
        GEQUAL {
            @Override
            protected boolean apply(Property<?, ?, ?> operand1, Property<?, ?, ?> operand2) {
                @SuppressWarnings({"unchecked", "rawtypes"})
                int result = ((Comparable) operand2).compareTo(operand1);
                return result >= 0;
            }
        },

        /**
         * Use <code>.compareTo()</code> amd match if target is less than the
         * supplied operand
         */
        LESS {
            @Override
            protected boolean apply(Property<?, ?, ?> operand1, Property<?, ?, ?> operand2) {
                @SuppressWarnings({"unchecked", "rawtypes"})
                int result = ((Comparable) operand2).compareTo(operand1);
                return result < 0;
            }
        },

        /**
         * Use <code>.compareTo()</code> amd match if target is less than or
         * equal to the supplied operand
         */
        LEQUAL {
            @Override
            protected boolean apply(Property<?, ?, ?> operand1, Property<?, ?, ?> operand2) {
                @SuppressWarnings({"unchecked", "rawtypes"})
                int result = ((Comparable) operand2).compareTo(operand1);
                return result <= 0;
            }
        };

        /**
         * <p>Compare the two operands by applying this operator <em>infix</em>
         * with respect to them. For example, if this object is
         * {@link Operator#GREATER} then calling this method with
         * <code>object1</code> and <code>object2</code> would effectively
         * return:</p>
         *
         * <blockquote> <code>returnValue = object1 &gt; object2;</code>
         * </blockquote>
         *
         * @param operand1 First operand
         * @param operand2 Second operand
         * @return First operand's comparison to second
         */
        public final boolean compare(@Nullable Property<?, ?, ?> operand1, @Nullable Property<?, ?, ?> operand2) {
            if (this == Operator.EQUAL && operand1 == operand2) {
                // also catches both operands being null, which is okay, since
                // null.equals(null) -> true as far as we're concerned
                return true;
            }

            if (operand1 == null || operand2 == null) {
                return false;
            }

            return this.apply(operand1, operand2);
        }

        /**
         * Stub for subclasses to implement their logic. Used so we can get the
         * null comparison logic out of the way first and then only proceed with
         * comparison if both arguments are non-null.
         *
         * @param operand1 First operand
         * @param operand2 Second operand
         * @return First operand's comparison to second
         */
        protected abstract boolean apply(Property<?, ?, ?> operand1, Property<?, ?, ?> operand2);

        /**
         * Get the default operator to use if none is specified.
         *
         * @return the default operator
         */
        public static Operator defaultOperator() {
            return Operator.DELEGATE;
        }

    }

    /**
     * Get the key for this property. Key is only used if an item stack can have
     * more than one property of a particular type. If the property has no
     * specific key, the property class name is returned so that properties of
     * the same type are implicitly comparable.
     *
     * @return the key for this property
     */
    K getKey();

    /**
     * Get the "value" of this property. "Value" may have different meanings
     * depending on the exact type of this property.
     *
     * @return the value of this property
     */
    @Nullable V getValue();

    /**
     * Get the operator to use when comparing another property with this
     * property.
     *
     * @return the operator to use when comparing another property with this
     *      property
     */
    Operator getOperator();

    /**
     * <p>Compares this property to <code>other</code> using this property's
     * operator. This is equivalent to the code:</p>
     *
     * <blockquote>
     *     <pre>thisObject.getOperator().compare(thisObject, other);</pre>
     * </blockquote>
     *
     * <p>The order of the operands is important, since {@link Operator} treats
     * its type as infix between the two operands, and thus (for example) if
     * this property's operator is set to GREATER, then when calling this method
     * we want to know whether <b>this</b> is <em>GREATER</em> than <b>other</b>
     * and must pass in the operands in the corresponding order.</p>
     *
     * @param other Property to compare to
     * @return true if the other property matches this one according to the
     *      rules defined by this property's {@link #getOperator()}
     */
    boolean matches(@Nullable C other);

}

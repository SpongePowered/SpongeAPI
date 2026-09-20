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
package org.spongepowered.api.data.value;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Key;

import java.util.Collection;
import java.util.function.Function;

public interface CompositeValue<K, E> extends ValueLike<E> {

    @Override
    Key<? extends CompositeValue<K, E>> key();

    static <K, E> CompositeValue.Parent.Mutable<K, E> mutableOf(Key<? extends CompositeValue<K, E>> key, ElementMergeFunction.Defaulted<E> mergeFunction, Collection<Child<K, E>> children) {
        return Sponge.game().factoryProvider().provide(CompositeValue.Factory.class).mutableOf(key, mergeFunction, children);
    }

    static <K, E> CompositeValue.Parent.Immutable<K, E> immutableOf(Key<? extends CompositeValue<K, E>> key, ElementMergeFunction.Defaulted<E> mergeFunction, Collection<Child<K, E>> children) {
        return Sponge.game().factoryProvider().provide(CompositeValue.Factory.class).immutableOf(key, mergeFunction, children);
    }

    static <K, E> Child.Mutable<K, E> mutableChildOf(Key<? extends CompositeValue<K, E>> key, K valueKey, E value) {
        return Sponge.game().factoryProvider().provide(CompositeValue.Factory.class).mutableChildOf(key, valueKey, value);
    }

    static <K, E> Child.Immutable<K, E> immutableChildOf(Key<? extends CompositeValue<K, E>> key, K valueKey, E value) {
        return Sponge.game().factoryProvider().provide(CompositeValue.Factory.class).immutableChildOf(key, valueKey, value);
    }

    @Override
    CompositeValue.Mutable<K ,E> asMutable();

    @Override
    CompositeValue.Mutable<K ,E> asMutableCopy();

    @Override
    CompositeValue.Immutable<K ,E> asImmutable();

    interface Parent<K, E> extends CompositeValue<K, E> {

        Collection<? extends Child<K, E>> children();

        @Override
        Parent.Mutable<K ,E> asMutable();

        @Override
        Parent.Mutable<K ,E> asMutableCopy();

        @Override
        Parent.Immutable<K ,E> asImmutable();

        interface Mutable<K, E> extends Parent<K, E>, CompositeValue.Mutable<K, E> {

            @Override
            Collection<Child.Mutable<K, E>> children();

            Parent.Mutable<K, E> set(K key, E value);

            @Override
            Parent.Immutable<K, E> asImmutable();

            @Override
            default Parent.Mutable<K, E> asMutable() {
                return this;
            }

            @Override
            default Parent.Mutable<K, E> asMutableCopy() {
                return this.copy();
            }

            @Override
            Parent.Mutable<K, E> copy();
        }

        interface Immutable<K, E> extends Parent<K, E>, CompositeValue.Immutable<K, E> {

            @Override
            Collection<Child.Immutable<K, E>> children();

            Parent.Immutable<K, E> with(K key, E value);

            @Override
            Parent.Mutable<K, E> asMutable();

            @Override
            default Parent.Mutable<K, E> asMutableCopy() {
                return this.asMutable();
            }

            @Override
            default Parent.Immutable<K, E> asImmutable() {
                return this;
            }
        }
    }

    interface Child<K, E> extends CompositeValue<K, E> {

        K valueKey();

        @Override
        Child.Mutable<K ,E> asMutable();

        @Override
        Child.Mutable<K ,E> asMutableCopy();

        @Override
        Child.Immutable<K ,E> asImmutable();

        interface Mutable<K, E> extends Child<K, E>, CompositeValue.Mutable<K, E> {

            Child.Mutable<K, E> set(E value);

            Child.Mutable<K, E> transform(Function<E, E> function);

            @Override
            Child.Immutable<K, E> asImmutable();

            @Override
            default Child.Mutable<K, E> asMutable() {
                return this;
            }

            @Override
            default Child.Mutable<K, E> asMutableCopy() {
                return this.copy();
            }

            @Override
            Child.Mutable<K, E> copy();
        }

        interface Immutable<K, E> extends Child<K, E>, CompositeValue.Immutable<K, E> {

            Child.Immutable<K, E> with(E value);

            Child.Immutable<K, E> transform(Function<E, E> function);

            @Override
            Child.Mutable<K, E> asMutable();

            @Override
            default Child.Mutable<K, E> asMutableCopy() {
                return this.asMutable();
            }

            @Override
            default Child.Immutable<K, E> asImmutable() {
                return this;
            }
        }
    }

    interface Mutable<K, E> extends CompositeValue<K, E>, ValueLike.Mutable<E> {

        @Override
        CompositeValue.Mutable<K ,E> asMutable();

        @Override
        CompositeValue.Mutable<K ,E> asMutableCopy();

        @Override
        CompositeValue.Immutable<K ,E> asImmutable();
    }

    interface Immutable<K, E> extends CompositeValue<K, E>, ValueLike.Immutable<E> {

        @Override
        CompositeValue.Mutable<K, E> asMutable();

        @Override
        default CompositeValue.Mutable<K, E> asMutableCopy() {
            return this.asMutable();
        }

        @Override
        default CompositeValue.Immutable<K, E> asImmutable() {
            return this;
        }
    }

    interface Factory {

        <K, E> CompositeValue.Parent.Mutable<K, E> mutableOf(Key<? extends CompositeValue<K, E>> key, ElementMergeFunction.Defaulted<E> mergeFunction, Collection<Child<K, E>> children);

        <K, E> CompositeValue.Parent.Immutable<K, E> immutableOf(Key<? extends CompositeValue<K, E>> key, ElementMergeFunction.Defaulted<E> mergeFunction, Collection<Child<K, E>> children);

        <K, E> CompositeValue.Child.Mutable<K, E> mutableChildOf(Key<? extends CompositeValue<K, E>> key, K valueKey, E value);

        <K, E> CompositeValue.Child.Immutable<K, E> immutableChildOf(Key<? extends CompositeValue<K, E>> key, K valueKey, E value);
    }
}

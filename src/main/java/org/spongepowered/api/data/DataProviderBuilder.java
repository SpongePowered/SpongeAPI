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
package org.spongepowered.api.data;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public interface DataProviderBuilder<H extends DataHolder, V extends Value<E>, E>
        extends ResettableBuilder<DataProvider<V, E>, DataProviderBuilder.BaseBuilder<V, E>> {

    static BaseBuilder<?, ?> builder() {
        return Sponge.getRegistry().createBuilder(BaseBuilder.class);
    }

    <NV extends Value<NE>, NE> DataProviderBuilder<H, NV, NE> key(Key<NV> key);

    DataProviderBuilder<H, V, E> allowAsyncAccess();

    DataProviderBuilder<H, V, E> allowAsyncAccess(Predicate<H> function);

    DataProviderBuilder<H, V, E> isSupported(Predicate<H> function);

    DataProviderBuilder<H, V, E> get(Function<H, @Nullable E> function);

    DataProviderBuilder<H, V, E> getValue(Function<H, @Nullable V> function);

    DataProvider<V, E> build();

    interface BaseBuilder<V extends Value<E>, E> extends DataProviderBuilder<DataHolder, V, E> {

        @Override
        <NV extends Value<NE>, NE> BaseBuilder<NV, NE> key(Key<NV> key);

        @Override
        BaseBuilder<V, E> allowAsyncAccess();

        @Override
        BaseBuilder<V, E> allowAsyncAccess(Predicate<DataHolder> function);

        @Override
        BaseBuilder<V, E> isSupported(Predicate<DataHolder> function);

        @Override
        BaseBuilder<V, E> get(Function<DataHolder, @Nullable E> function);

        @Override
        BaseBuilder<V, E> getValue(Function<DataHolder, V> function);

        default DataProviderBuilder<DataHolder, V, E> forHolders(Class<? extends DataHolder> first,
                Class<? extends DataHolder> second, Class<? extends DataHolder>... more) {
            return this.forHolders(ImmutableList.<TypeToken<? extends DataHolder>>builder()
                    .add(TypeToken.of(first))
                    .add(TypeToken.of(second))
                    .addAll(Arrays.stream(more).map(TypeToken::of).collect(Collectors.toList()))
                    .build());
        }

        default DataProviderBuilder<DataHolder, V, E> forHolders(TypeToken<? extends DataHolder> first,
                TypeToken<? extends DataHolder> second, TypeToken<? extends DataHolder>... more) {
            return this.forHolders(ImmutableList.<TypeToken<? extends DataHolder>>builder()
                    .add(first)
                    .add(second)
                    .add(more)
                    .build());
        }

        DataProviderBuilder<DataHolder, V, E> forHolders(Iterable<TypeToken<? extends DataHolder>> holderTypes);

        default <H extends DataHolder> DataProviderBuilder<H, V, E> forHolder(Class<H> holderType) {
            return this.forHolder(TypeToken.of(holderType));
        }

        <H extends DataHolder> DataProviderBuilder<H, V, E> forHolder(TypeToken<H> holderType);

        default DirectionRelative<DirectionRelativeDataHolder, V, E> forDirectionRelativeHolders(
                Class<? extends DirectionRelativeDataHolder> first,
                Class<? extends DirectionRelativeDataHolder> second,
                Class<? extends DirectionRelativeDataHolder>... more) {
            return this.forDirectionRelativeHolders(ImmutableList.<TypeToken<? extends DirectionRelativeDataHolder>>builder()
                    .add(TypeToken.of(first))
                    .add(TypeToken.of(second))
                    .addAll(Arrays.stream(more).map(TypeToken::of).collect(Collectors.toList()))
                    .build());
        }

        default DirectionRelative<DirectionRelativeDataHolder, V, E> forDirectionRelativeHolders(
                TypeToken<? extends DirectionRelativeDataHolder> first,
                TypeToken<? extends DirectionRelativeDataHolder> second,
                TypeToken<? extends DirectionRelativeDataHolder>... more) {
            return this.forDirectionRelativeHolders(ImmutableList.<TypeToken<? extends DirectionRelativeDataHolder>>builder()
                    .add(first)
                    .add(second)
                    .add(more)
                    .build());
        }

        DirectionRelative<DirectionRelativeDataHolder, V, E> forDirectionRelativeHolders(
                Iterable<TypeToken<? extends DirectionRelativeDataHolder>> holderTypes);

        default <H extends DirectionRelativeDataHolder> DirectionRelative<H, V, E> forDirectionRelativeHolder(Class<H> holderType) {
            return this.forDirectionRelativeHolder(TypeToken.of(holderType));
        }

        DirectionRelative<DirectionRelativeDataHolder, V, E> forDirectionRelativeHolders();

        <H extends DirectionRelativeDataHolder> DirectionRelative<H, V, E> forDirectionRelativeHolder(TypeToken<H> holderType);

        default DirectionRelative.Mutable<DirectionRelativeDataHolder.Mutable, V, E> forMutableDirectionRelativeHolders(
                Class<? extends DirectionRelativeDataHolder.Mutable> first,
                Class<? extends DirectionRelativeDataHolder.Mutable> second,
                Class<? extends DirectionRelativeDataHolder.Mutable>... more) {
            return this.forMutableDirectionRelativeHolders(ImmutableList.<TypeToken<? extends DirectionRelativeDataHolder.Mutable>>builder()
                    .add(TypeToken.of(first))
                    .add(TypeToken.of(second))
                    .addAll(Arrays.stream(more).map(TypeToken::of).collect(Collectors.toList()))
                    .build());
        }

        default DirectionRelative.Mutable<DirectionRelativeDataHolder.Mutable, V, E> forMutableDirectionRelativeHolders(
                TypeToken<? extends DirectionRelativeDataHolder.Mutable> first,
                TypeToken<? extends DirectionRelativeDataHolder.Mutable> second,
                TypeToken<? extends DirectionRelativeDataHolder.Mutable>... more) {
            return this.forMutableDirectionRelativeHolders(ImmutableList.<TypeToken<? extends DirectionRelativeDataHolder.Mutable>>builder()
                    .add(first)
                    .add(second)
                    .add(more)
                    .build());
        }

        DirectionRelative.Mutable<DirectionRelativeDataHolder.Mutable, V, E> forMutableDirectionRelativeHolders(
                Iterable<TypeToken<? extends DirectionRelativeDataHolder.Mutable>> holderTypes);

        default <H extends DirectionRelativeDataHolder.Mutable> DirectionRelative.Mutable<H, V, E> forMutableDirectionRelativeHolder(
                Class<H> holderType) {
            return this.forMutableDirectionRelativeHolder(TypeToken.of(holderType));
        }

        DirectionRelative<DirectionRelativeDataHolder.Mutable, V, E> forMutableDirectionRelativeHolders();

        <H extends DirectionRelativeDataHolder.Mutable> DirectionRelative.Mutable<H, V, E> forMutableDirectionRelativeHolder(
                TypeToken<H> holderType);

        default <H extends DirectionRelativeDataHolder.Immutable<H>> DirectionRelative.Immutable<H, V, E> forImmutableDirectionRelativeHolders(
                Class<? extends DirectionRelativeDataHolder.Immutable<?>> first,
                Class<? extends DirectionRelativeDataHolder.Immutable<?>> second,
                Class<? extends DirectionRelativeDataHolder.Immutable<?>>... more) {
            return this.forImmutableDirectionRelativeHolders(ImmutableList.<TypeToken<? extends DirectionRelativeDataHolder.Immutable<?>>>builder()
                    .add(TypeToken.of(first))
                    .add(TypeToken.of(second))
                    .addAll(Arrays.stream(more).map(TypeToken::of).collect(Collectors.toList()))
                    .build());
        }

        default <H extends DirectionRelativeDataHolder.Immutable<H>> DirectionRelative.Immutable<H, V, E> forImmutableDirectionRelativeHolders(
                TypeToken<? extends DirectionRelativeDataHolder.Immutable<?>> first,
                TypeToken<? extends DirectionRelativeDataHolder.Immutable<?>> second,
                TypeToken<? extends DirectionRelativeDataHolder.Immutable<?>>... more) {
            return this.forImmutableDirectionRelativeHolders(ImmutableList.<TypeToken<? extends DirectionRelativeDataHolder.Immutable<?>>>builder()
                    .add(first)
                    .add(second)
                    .add(more)
                    .build());
        }

        <H extends DirectionRelativeDataHolder.Immutable<H>> DirectionRelative.Immutable<H, V, E> forImmutableDirectionRelativeHolders(
                Iterable<TypeToken<? extends DirectionRelativeDataHolder.Immutable<?>>> holderTypes);

        default <H extends DirectionRelativeDataHolder.Immutable<H>> DirectionRelative.Immutable<H, V, E> forImmutableDirectionRelativeHolder(
                Class<H> holderType) {
            return this.forImmutableDirectionRelativeHolder(TypeToken.of(holderType));
        }

        <H extends DirectionRelativeDataHolder.Immutable<H>> DirectionRelative.Immutable<H, V, E> forImmutableDirectionRelativeHolders();

        <H extends DirectionRelativeDataHolder.Immutable<H>> DirectionRelative.Immutable<H, V, E> forImmutableDirectionRelativeHolder(
                TypeToken<H> holderType);

        default Mutable<DataHolder.Mutable, V, E> forMutableHolders(Class<? extends DataHolder.Mutable> first,
                Class<? extends DataHolder.Mutable> second, Class<? extends DataHolder.Mutable>... more) {
            return this.forMutableHolders(ImmutableList.<TypeToken<? extends DataHolder.Mutable>>builder()
                    .add(TypeToken.of(first))
                    .add(TypeToken.of(second))
                    .addAll(Arrays.stream(more).map(TypeToken::of).collect(Collectors.toList()))
                    .build());
        }

        default Mutable<DataHolder.Mutable, V, E> forMutableHolders(TypeToken<? extends DataHolder.Mutable> first,
                TypeToken<? extends DataHolder.Mutable> second, TypeToken<? extends DataHolder.Mutable>... more) {
            return this.forMutableHolders(ImmutableList.<TypeToken<? extends DataHolder.Mutable>>builder()
                    .add(first)
                    .add(second)
                    .add(more)
                    .build());
        }

        Mutable<DataHolder.Mutable, V, E> forMutableHolders(Iterable<TypeToken<? extends DataHolder.Mutable>> holderTypes);

        Mutable<DataHolder.Mutable, V, E> forMutableHolders();

        default <H extends DataHolder.Mutable> Mutable<H, V, E> forMutableHolder(Class<H> holderType) {
            return this.forMutableHolder(TypeToken.of(holderType));
        }

        <H extends DataHolder.Mutable> Mutable<H, V, E> forMutableHolder(TypeToken<H> holderType);

        default <H extends DataHolder.Immutable<H>> Immutable<H, V, E> forImmutableHolders(
                Class<? extends DataHolder.Immutable<?>> first,
                Class<? extends DataHolder.Immutable<?>> second,
                Class<? extends DataHolder.Immutable<?>>... more) {
            return this.forImmutableHolders(ImmutableList.<TypeToken<? extends DataHolder.Immutable<?>>>builder()
                    .add(TypeToken.of(first))
                    .add(TypeToken.of(second))
                    .addAll(Arrays.stream(more).map(TypeToken::of).collect(Collectors.toList()))
                    .build());
        }

        default <H extends DataHolder.Immutable<H>> Immutable<H, V, E> forImmutableHolders(
                TypeToken<? extends DataHolder.Immutable<?>> first,
                TypeToken<? extends DataHolder.Immutable<?>> second,
                TypeToken<? extends DataHolder.Immutable<?>>... more) {
            return this.forImmutableHolders(ImmutableList.<TypeToken<? extends DataHolder.Immutable<?>>>builder()
                    .add(first)
                    .add(second)
                    .add(more)
                    .build());
        }

        <H extends DataHolder.Immutable<H>> Immutable<H, V, E> forImmutableHolders(
                Iterable<TypeToken<? extends DataHolder.Immutable<?>>> holderTypes);

        <H extends DataHolder.Immutable<H>> Immutable<H, V, E> forImmutableHolders();

        default <H extends DataHolder.Immutable<H>> Immutable<H, V, E> forImmutableHolders(
                Class<H> holderType) {
            return this.forImmutableHolders(TypeToken.of(holderType));
        }

        <H extends DataHolder.Immutable<H>> Immutable<H, V, E> forImmutableHolders(TypeToken<H> holderType);
    }

    interface DirectionRelative<H extends DirectionRelativeDataHolder, V extends Value<E>, E> extends DataProviderBuilder<H, V, E> {

        @Override
        <NV extends Value<NE>, NE> DirectionRelative<H, NV, NE> key(Key<NV> key);

        @Override
        DirectionRelative<H, V, E> allowAsyncAccess();

        @Override
        DirectionRelative<H, V, E> allowAsyncAccess(Predicate<H> function);

        @Override
        DirectionRelative<H, V, E> isSupported(Predicate<H> function);

        @Override
        DirectionRelative<H, V, E> get(Function<H, @Nullable E> function);

        @Override
        DirectionRelative<H, V, E> getValue(Function<H, @Nullable V> function);

        DirectionRelative<H, V, E> get(BiFunction<H, Direction, @Nullable E> function);

        DirectionRelative<H, V, E> getValue(BiFunction<H, Direction, @Nullable V> function);

        interface Mutable<H extends DirectionRelativeDataHolder.Mutable, V extends Value<E>, E>
                extends DataProviderBuilder.Mutable<H, V, E>, DirectionRelative<H, V, E> {

            @Override
            <NV extends Value<NE>, NE> DirectionRelative.Mutable<H, NV, NE> key(Key<NV> key);

            @Override
            DirectionRelative.Mutable<H, V, E> allowAsyncAccess();

            @Override
            DirectionRelative.Mutable<H, V, E> allowAsyncAccess(Predicate<H> function);

            @Override
            DirectionRelative.Mutable<H, V, E> isSupported(Predicate<H> function);

            @Override
            DirectionRelative.Mutable<H, V, E> get(Function<H, @Nullable E> function);

            @Override
            DirectionRelative.Mutable<H, V, E> getValue(Function<H, @Nullable V> function);

            @Override
            DirectionRelative.Mutable<H, V, E> get(BiFunction<H, Direction, @Nullable E> function);

            @Override
            DirectionRelative.Mutable<H, V, E> getValue(BiFunction<H, Direction, @Nullable V> function);

            @Override
            DirectionRelative.Mutable<H, V, E> offer(BiFunction<H, E, DataTransactionResult> function);

            @Override
            DirectionRelative.Mutable<H, V, E> offerValue(BiFunction<H, V, DataTransactionResult> function);

            @Override
            DirectionRelative.Mutable<H, V, E> remove(Function<H, DataTransactionResult> function);
        }

        interface Immutable<H extends DirectionRelativeDataHolder.Immutable<H>, V extends Value<E>, E>
                extends DataProviderBuilder.Immutable<H, V, E>, DirectionRelative<H, V, E> {

            @Override
            <NV extends Value<NE>, NE> DirectionRelative.Immutable<H, NV, NE> key(Key<NV> key);

            @Override
            DirectionRelative.Immutable<H, V, E> allowAsyncAccess();

            @Override
            DirectionRelative.Immutable<H, V, E> allowAsyncAccess(Predicate<H> function);

            @Override
            DirectionRelative.Immutable<H, V, E> isSupported(Predicate<H> function);

            @Override
            DirectionRelative.Immutable<H, V, E> get(Function<H, @Nullable E> function);

            @Override
            DirectionRelative.Immutable<H, V, E> getValue(Function<H, @Nullable V> function);

            @Override
            DirectionRelative.Immutable<H, V, E> get(BiFunction<H, Direction, @Nullable E> function);

            @Override
            DirectionRelative.Immutable<H, V, E> getValue(BiFunction<H, Direction, @Nullable V> function);

            @Override
            DirectionRelative.Immutable<H, V, E> with(BiFunction<H, E, @Nullable H> function);

            @Override
            DirectionRelative.Immutable<H, V, E> withValue(BiFunction<H, V, @Nullable H> function);

            @Override
            DirectionRelative.Immutable<H, V, E> without(Function<H, @Nullable H> function);
        }
    }

    interface Mutable<H extends DataHolder.Mutable, V extends Value<E>, E> extends DataProviderBuilder<H, V, E> {

        @Override
        <NV extends Value<NE>, NE> Mutable<H, NV, NE> key(Key<NV> key);

        @Override
        Mutable<H, V, E> allowAsyncAccess();

        @Override
        Mutable<H, V, E> allowAsyncAccess(Predicate<H> function);

        @Override
        Mutable<H, V, E> isSupported(Predicate<H> function);

        @Override
        Mutable<H, V, E> get(Function<H, @Nullable E> function);

        @Override
        Mutable<H, V, E> getValue(Function<H, @Nullable V> function);

        Mutable<H, V, E> offer(BiFunction<H, E, DataTransactionResult> function);

        Mutable<H, V, E> offerValue(BiFunction<H, V, DataTransactionResult> function);

        Mutable<H, V, E> remove(Function<H, DataTransactionResult> function);
    }

    interface Immutable<H extends DataHolder.Immutable<H>, V extends Value<E>, E> extends DataProviderBuilder<H, V, E> {

        @Override
        <NV extends Value<NE>, NE> Immutable<H, NV, NE> key(Key<NV> key);

        @Override
        Immutable<H, V, E> allowAsyncAccess();

        @Override
        Immutable<H, V, E> allowAsyncAccess(Predicate<H> function);

        @Override
        Immutable<H, V, E> isSupported(Predicate<H> function);

        @Override
        Immutable<H, V, E> get(Function<H, E> function);

        @Override
        Immutable<H, V, E> getValue(Function<H, V> function);

        Immutable<H, V, E> with(BiFunction<H, E, @Nullable H> function);

        Immutable<H, V, E> withValue(BiFunction<H, V, @Nullable H> function);

        Immutable<H, V, E> without(Function<H, @Nullable H> function);
    }
}

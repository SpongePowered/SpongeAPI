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
package org.spongepowered.api.event;

import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.annotation.DoNotStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * A cause represents the reason or initiator of an event.
 *
 * <p>For example, if a block of sand is placed where it drops, the block of
 * sand would create a falling sand entity, which then would place another block
 * of sand. The block place event for the final block of sand would have the
 * cause chain of the block of sand -&gt; falling sand entity.</p>
 *
 * <p>It is not possible to accurately describe the chain of causes in all
 * scenarios so a best effort approach is generally acceptable. For example, a
 * player might press a lever, activating a complex Redstone circuit, which
 * would then launch TNT and cause the destruction of some blocks, but tracing
 * this event would be too complicated and thus may not be attempted.</p>
 */
@DoNotStore
@SuppressWarnings("unchecked")
public final class Cause implements Iterable<Object> {

    /**
     * Creates a new {@link Builder} to make a new {@link Cause}.
     *
     * @return The new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Constructs a new cause with the specified event context and cause.
     *
     * @param ctx The event context
     * @param cause The direct object cause
     * @return The constructed cause
     */
    public static Cause of(final EventContext ctx, final Object cause) {
        java.util.Objects.requireNonNull(ctx, "Context");
        java.util.Objects.requireNonNull(cause, "Cause cannot be null!");
        return new Cause(ctx, new Object[] {cause});
    }

    /**
     * Constructs a new cause with the specified event context and causes.
     *
     * @param ctx The event context
     * @param cause The direct object cause
     * @param causes Other associated causes
     * @return The built cause
     */
    public static Cause of(final EventContext ctx, final Object cause, final Object... causes) {
        java.util.Objects.requireNonNull(ctx, "Context");
        final Builder builder = Cause.builder();
        builder.append(cause);
        for (final Object namedCause : causes) {
            builder.append(namedCause);
        }
        return builder.build(ctx);
    }

    /**
     * Constructs a new cause with the specified event context and causes.
     *
     * @param ctx The event context
     * @param iterable The associated causes
     * @return The built cause
     */
    public static Cause of(final EventContext ctx, final Iterable<Object> iterable) {
        java.util.Objects.requireNonNull(ctx, "Context");
        final Builder builder = Cause.builder();
        for (final Object cause : iterable) {
            builder.append(cause);
        }
        return builder.build(ctx);
    }

    final Object[] cause;
    private final EventContext context;

    // lazy load
    @Nullable private ImmutableList<Object> immutableCauses;

    /**
     * Constructs a new cause.
     *
     * @param ctx The event context
     * @param causes The causes
     */
    Cause(final EventContext ctx, final Object[] causes) {
        java.util.Objects.requireNonNull(ctx, "Context");
        final Object[] objects = new Object[causes.length];
        for (int index = 0; index < causes.length; index++) {
            objects[index] = java.util.Objects.requireNonNull(causes[index], "Null cause element!");
        }
        this.cause = objects;
        this.context = ctx;
    }

    /**
     * Constructs a new cause.
     *
     * @param ctx The event context
     * @param causes The causes
     */
    Cause(final EventContext ctx, final Collection<Object> causes) {
        java.util.Objects.requireNonNull(ctx, "Context");
        final Object[] objects = new Object[causes.size()];
        int index = 0;
        for (final Object cause: causes) {
            objects[index++] = java.util.Objects.requireNonNull(cause, "Null cause element!");
        }
        this.cause = objects;
        this.context = ctx;
    }

    /**
     * Gets the event context relating to this cause.
     *
     * @return The event context
     */
    public EventContext getContext() {
        return this.context;
    }

    /**
     * Gets the root {@link Object} of this cause.
     *
     * @return The root object cause for this cause
     */
    public Object root() {
        return this.cause[0];
    }

    /**
     * Gets the first <code>T</code> object of this {@link Cause}, if available.
     *
     * @param target The class of the target type
     * @param <T> The type of object being queried for
     * @return The first element of the type, if available
     */
    public <T> Optional<T> first(final Class<T> target) {
        for (final Object aCause : this.cause) {
            if (target.isInstance(aCause)) {
                return Optional.of((T) aCause);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the last object instance of the {@link Class} of type
     * <code>T</code>.
     *
     * @param target The class of the target type
     * @param <T> The type of object being queried for
     * @return The last element of the type, if available
     */
    public <T> Optional<T> last(final Class<T> target) {
        for (int i = this.cause.length - 1; i >= 0; i--) {
            if (target.isInstance(this.cause[i])) {
                return Optional.of((T) this.cause[i]);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the object immediately before the object that is an instance of the
     * {@link Class} passed in.
     *
     * @param clazz The class of the object
     * @return The object
     */
    public Optional<?> before(final Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("The provided class cannot be null!");
        }
        if (this.cause.length == 1) {
            return Optional.empty();
        }
        for (int i = 0; i < this.cause.length; i++) {
            if (clazz.isInstance(this.cause[i]) && i > 0) {
                return Optional.of(this.cause[i - 1]);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the object immediately after the object that is an instance of the
     * {@link Class} passed in.
     *
     * @param clazz The class to type check
     * @return The object after, if available
     */
    public Optional<?> after(final Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("The provided class cannot be null!");
        }
        if (this.cause.length == 1) {
            return Optional.empty();
        }
        for (int i = 0; i < this.cause.length; i++) {
            if (clazz.isInstance(this.cause[i]) && i + 1 < this.cause.length) {
                return Optional.of(this.cause[i + 1]);
            }
        }
        return Optional.empty();
    }

    /**
     * Returns whether the target class matches any object of this {@link Cause}
     * .
     * 
     * @param target The class of the target type
     * @return True if found, false otherwise
     */
    public boolean containsType(final Class<?> target) {
        java.util.Objects.requireNonNull(target, "The provided class cannot be null!");
        for (final Object aCause : this.cause) {
            if (target.isInstance(aCause)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if this cause contains of any of the provided {@link Object}. This
     * is the equivalent to checking based on {@link #equals(Object)} for each
     * object in this cause.
     *
     * @param object The object to check if it is contained
     * @return True if the object is contained within this cause
     */
    public boolean contains(final Object object) {
        for (final Object aCause : this.cause) {
            if (aCause.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets an {@link ImmutableList} of all objects that are instances of the
     * given {@link Class} type <code>T</code>.
     *
     * @param <T> The type of objects to query for
     * @param target The class of the target type
     * @return An immutable list of the objects queried
     */
    public <T> List<T> allOf(final Class<T> target) {
        final ImmutableList.Builder<T> builder = ImmutableList.builder();
        for (final Object aCause : this.cause) {
            if (target.isInstance(aCause)) {
                builder.add((T) aCause);
            }
        }
        return builder.build();
    }

    /**
     * Gets an immutable {@link List} with all object causes that are not
     * instances of the provided {@link Class}.
     *
     * @param ignoredClass The class of object types to ignore
     * @return The list of objects not an instance of the provided class
     */
    public List<Object> noneOf(final Class<?> ignoredClass) {
        final ImmutableList.Builder<Object> builder = ImmutableList.builder();
        for (final Object cause : this.cause) {
            if (!ignoredClass.isInstance(cause)) {
                builder.add(cause);
            }
        }
        return builder.build();
    }

    /**
     * Gets an {@link List} of all causes within this {@link Cause}.
     *
     * @return An immutable list of all the causes
     */
    public List<Object> all() {
        if (this.immutableCauses == null) {
            this.immutableCauses = ImmutableList.copyOf(this.cause);
        }
        return this.immutableCauses;
    }

    /**
     * Creates a new {@link Cause} where the objects are added at the end of the
     * cause array of objects.
     *
     * @param additional The additional object to add
     * @return The new cause
     */
    public Cause with(final Object additional) {
        java.util.Objects.requireNonNull(additional, "No null arguments allowed!");
        final List<Object> list = new ArrayList<>();
        list.add(additional);
        return this.with(list);
    }

    /**
     * Creates a new {@link Cause} where the objects are added at the end of the
     * cause array of objects.
     *
     * @param additional The additional object to add
     * @param additionals The remaining objects to add
     * @return The new cause
     */
    public Cause with(final Object additional, final Object... additionals) {
        java.util.Objects.requireNonNull(additional, "No null arguments allowed!");
        final List<Object> list = new ArrayList<>();
        list.add(additional);
        for (final Object object : additionals) {
            java.util.Objects.requireNonNull(object, "Cannot add null objects!");
            list.add(object);
        }
        return this.with(list);
    }

    /**
     * Creates a new {@link Cause} where the objects are added at the end of the
     * cause array of objects.
     *
     * @param iterable The additional objects
     * @return The new cause
     */
    public Cause with(final Iterable<Object> iterable) {
        final Cause.Builder builder = new Builder().from(this);
        for (final Object o : iterable) {
            java.util.Objects.requireNonNull(o, "Cannot add null causes");
            builder.append(o);
        }
        return builder.build(this.context);
    }

    /**
     * Merges this cause with the other cause.
     *
     * @param cause The cause to merge with this
     * @return The new merged cause
     */
    public Cause with(final Cause cause) {
        final Cause.Builder builder = Cause.builder().from(this);
        for (int i = 0; i < cause.cause.length; i++) {
            builder.append(cause.cause[i]);
        }
        return builder.build(this.context);
    }

    @Override
    public Iterator<Object> iterator() {
        return new Itr();
    }

    @Override
    public boolean equals(@Nullable final Object object) {
        if (object instanceof Cause) {
            final Cause cause = ((Cause) object);
            return Arrays.equals(this.cause, cause.cause);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.cause);
    }

    @Override
    public String toString() {
        final String causeString = "Cause[Context=" + this.context.toString() + ", Stack={";
        final StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < this.cause.length; i++) {
            joiner.add(this.cause[i].toString());
        }
        return causeString + joiner.toString() + "}]";
    }

    private class Itr implements Iterator<Object> {

        private int index = 0;

        Itr() { }

        @Override
        public Object next() {
            if (this.index >= Cause.this.cause.length) {
                throw new NoSuchElementException();
            }
            return Cause.this.cause[this.index++];
        }

        @Override
        public boolean hasNext() {
            return this.index != Cause.this.cause.length;
        }

    }

    public static final class Builder implements CopyableBuilder<Cause, Builder> {

        final List<Object> causes = new ArrayList<>();

        Builder() {

        }

        /**
         * Appends the specified object to the cause.
         *
         * @param cause The object to append to the cause.
         * @return The modified builder, for chaining
         */
        public Builder append(final Object cause) {
            java.util.Objects.requireNonNull(cause, "Cause cannot be null!");
            if (!this.causes.isEmpty() && this.causes.get(this.causes.size() - 1) == cause) {
                return this;
            }
            this.causes.add(cause);
            return this;
        }

        /**
         * Inserts the specified object into the cause.
         *
         * @param position The position to insert into
         * @param cause The object to insert into the cause
         * @return The modified builder, for chaining
         */
        public Builder insert(final int position, final Object cause) {
            java.util.Objects.requireNonNull(cause, "Cause cannot be null!");
            this.causes.add(position, cause);
            return this;
        }

        /**
         * Appends all specified objects onto the cause.
         *
         * @param causes The objects to add onto the cause
         * @return The modified builder, for chaining
         */
        public Builder appendAll(final Collection<Object> causes) {
            java.util.Objects.requireNonNull(causes, "Causes cannot be null!");
            causes.forEach(this::append);
            return this;
        }

        /**
         * Constructs a new {@link Cause} with information added to the builder.
         *
         * @param ctx The context to build the cause with
         * @return The built cause
         */
        public Cause build(final EventContext ctx) {
            if (this.causes.isEmpty()) {
                throw new IllegalStateException("Cannot create an empty Cause!");
            }
            return new Cause(ctx, this.causes);
        }

        @Override
        public Builder from(final Cause value) {
            for (int i = 0; i < value.cause.length; i++) {
                this.causes.add(value.cause[i]);
            }
            return this;
        }

        @Override
        public Builder reset() {
            this.causes.clear();
            return this;
        }
    }

}

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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.eventgen.annotations.NoFactoryMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Supplier;

/**
 * Provides context for an event outside of the direct chain of causes present
 * in the event's {@link Cause}.
 */
@DoNotStore
@NoFactoryMethod
public final class EventContext {

    private static final EventContext EMPTY_CONTEXT = new EventContext(Map.of());

    /**
     * Gets an empty context.
     *
     * @return The empty context
     */
    public static EventContext empty() {
        return EventContext.EMPTY_CONTEXT;
    }

    /**
     * Creates a new {@link EventContext} from the given map of entries.
     *
     * @param entries The context entries
     * @return The new EventContext
     */
    public static EventContext of(Map<EventContextKey<?>, Object> entries) {
        Objects.requireNonNull(entries, "Context entries cannot be null");
        for (Map.Entry<EventContextKey<?>, Object> entry : entries.entrySet()) {
            Objects.requireNonNull(entry.getValue(), "Entries cannot contain null values");
        }
        return new EventContext(entries);
    }

    /**
     * Creates a new builder for creating an {@link EventContext}.
     *
     * @return The new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    private final Map<EventContextKey<?>, Object> entries;

    EventContext(Map<EventContextKey<?>, Object> values) {
        this.entries = Map.copyOf(values);
    }

    /**
     * Gets the value corresponding to the given key from the context.
     *
     * @param key The key
     * @param <T> The type of the value stored with the key
     * @return The context value, if found
     */
    @SuppressWarnings("unchecked")
    public <T> Optional<T> get(EventContextKey<T> key) {
        Objects.requireNonNull(key, "EventContextKey cannot be null");
        return Optional.ofNullable((T) this.entries.get(key));
    }

    /**
     * Gets the value corresponding to the given key from the context.
     *
     * @param key The key
     * @param <T> The type of the value stored with the key
     * @return The context value, if found
     */
    @SuppressWarnings("unchecked")
    public <T> Optional<T> get(Supplier<EventContextKey<T>> key) {
        Objects.requireNonNull(key, "EventContextKey cannot be null");
        return Optional.ofNullable((T) this.entries.get(key.get()));
    }

    /**
     * Gets the value corresponding to the given key from the context.
     *
     * <p>If the key is not available, {@link NoSuchElementException} will be
     * thrown.</p>
     *
     * @param key The key
     * @param <T> The type of the value stored with the key
     * @return The context value, if found
     */
    public <T> T require(EventContextKey<T> key) {
        final Optional<T> optional = this.get(key);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException(String.format("Could not retrieve value for key '%s'", key.toString()));
    }

    /**
     * Gets the value corresponding to the given key from the context.
     *
     * <p>If the key is not available, {@link NoSuchElementException} will be
     * thrown.</p>
     *
     * @param key The key
     * @param <T> The type of the value stored with the key
     * @return The context value, if found
     */
    public <T> T require(Supplier<EventContextKey<T>> key) {
        final Optional<T> optional = this.get(key);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException(String.format("Could not retrieve value for key '%s'", key.get().toString()));
    }

    /**
     * Gets whether the provided {@link EventContextKey} is included in this
     * context.
     *
     * @param key The context key to check
     * @return True if the key is used and there is an entry for it
     */
    public boolean containsKey(EventContextKey<?> key) {
        return this.entries.containsKey(key);
    }

    /**
     * Gets whether the provided {@link EventContextKey} is included in this
     * context.
     *
     * @param key The context key to check
     * @return True if the key is used and there is an entry for it
     */
    public boolean containsKey(Supplier<? extends EventContextKey<?>> key) {
        return this.entries.containsKey(key.get());
    }

    /**
     * Gets all {@link EventContextKey}s present in this context.
     *
     * @return All present keys
     */
    public Set<EventContextKey<?>> keySet() {
        return this.entries.keySet();
    }

    /**
     * Gets this event context as a {@link Map} of EventContextKeys to Objects.
     *
     * @return A map view of this context
     */
    public Map<EventContextKey<?>, Object> asMap() {
        return this.entries;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof EventContext)) {
            return false;
        }
        final EventContext ctx = (EventContext) object;
        for (Map.Entry<EventContextKey<?>, Object> entry : this.entries.entrySet()) {
            final Object other = ctx.entries.get(entry.getKey());
            if (other == null) {
                return false;
            }
            if (!entry.getValue().equals(other)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.entries.hashCode();
    }

    @Override
    public String toString() {
        final StringJoiner joiner = new StringJoiner(", ");
        for (Map.Entry<EventContextKey<?>, Object> entry : this.entries.entrySet()) {
            joiner.add("\"" + entry.getKey().toString() + "\"=" + entry.getValue().toString());
        }
        return "Context[" + joiner.toString() + "]";
    }

    public static final class Builder implements org.spongepowered.api.util.Builder<EventContext, Builder>, CopyableBuilder<EventContext,
        Builder> {

        private final Map<EventContextKey<?>, Object> entries = new HashMap<>();

        Builder() {

        }

        /**
         * Adds the given context key value pair to the context.
         *
         * @param key The key
         * @param <T> The type of the value stored with the key
         * @param value The value
         * @return This builder, for chaining
         */
        public <T> Builder add(EventContextKey<T> key, T value) {
            Objects.requireNonNull(value, "Context object cannot be null");
            if (this.entries.containsKey(key)) {
                throw new IllegalArgumentException("Duplicate context keys: " + key.toString());
            }
            this.entries.put(key, value);
            return this;
        }


        /**
         * Adds the given context key value pair to the context.
         *
         * @param key The key
         * @param <T> The type of the value stored with the key
         * @param value The value
         * @return This builder, for chaining
         */
        public <T> Builder add(Supplier<EventContextKey<T>> key, T value) {
            Objects.requireNonNull(value, "Context object cannot be null");
            final EventContextKey<T> suppliedKey = key.get();
            Objects.requireNonNull(suppliedKey, "Supplied key cannot be null!");
            if (this.entries.containsKey(suppliedKey)) {
                throw new IllegalArgumentException("Duplicate context keys!");
            }
            this.entries.put(suppliedKey, value);
            return this;
        }

        @Override
        public Builder from(EventContext value) {
            this.entries.putAll(value.entries);
            return this;
        }

        @Override
        public Builder reset() {
            this.entries.clear();
            return this;
        }

        /**
         * Creates a new {@link EventContext}.
         *
         * @return The EventContext
         */
        @Override
        public EventContext build() {
            return new EventContext(this.entries);
        }

    }

}

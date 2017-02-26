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
package org.spongepowered.api.event.cause;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;

import javax.annotation.Nullable;

/**
 * Provides context for an event outside of the direct chain of causes present
 * in the event's {@link Cause}.
 */
public final class EventContext {

    private static final EventContext EMPTY_CONTEXT = new EventContext(ImmutableMap.of());

    /**
     * Gets an empty context.
     * 
     * @return The empty context
     */
    public static EventContext empty() {
        return EMPTY_CONTEXT;
    }

    /**
     * Creates a new {@link EventContext} from the given map of entries.
     * 
     * @param entries The context entries
     * @return The new EventContext
     */
    public static EventContext of(Map<EventContextKey<?>, Object> entries) {
        checkNotNull(entries, "Context entries cannot be null");
        for (Map.Entry<EventContextKey<?>, Object> entry : entries.entrySet()) {
            checkNotNull(entry.getValue(), "Entries cannot contain null values");
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
        this.entries = ImmutableMap.copyOf(values);
    }

    /**
     * Gets the value corresponding to the given key from the context.
     * 
     * @param key The key
     * @return The context value, if found
     */
    @SuppressWarnings("unchecked")
    public <T> Optional<T> get(EventContextKey<T> key) {
        checkNotNull(key, "EventContextKey cannot be null");
        return Optional.ofNullable((T) this.entries.get(key));
    }

    /**
     * Gets all {@link EventContextKey}s present in this context.
     * 
     * @return All present keys
     */
    public Set<EventContextKey<?>> keys() {
        return this.entries.keySet();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof EventContext)) {
            return false;
        }
        EventContext ctx = (EventContext) object;
        for (Map.Entry<EventContextKey<?>, Object> entry : this.entries.entrySet()) {
            Object other = ctx.entries.get(entry.getKey());
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
        StringJoiner joiner = new StringJoiner(", ");
        for (Map.Entry<EventContextKey<?>, Object> entry : this.entries.entrySet()) {
            joiner.add("\"" + entry.getKey().getId() + "\"=" + entry.getValue().toString());
        }
        return "Context[" + joiner.toString() + "]";
    }

    public static final class Builder implements ResettableBuilder<EventContext, Builder> {

        private final Map<EventContextKey<?>, Object> entries = Maps.newHashMap();

        Builder() {

        } 

        /**
         * Adds the given context key value pair to the context.
         * 
         * @param key The key
         * @param value The value
         * @return This builder, for chaining
         */
        public <T> Builder add(EventContextKey<T> key, T value) {
            checkNotNull(value, "Context object cannot be null");
            checkArgument(!this.entries.containsKey(key), "Duplicate context keys");
            this.entries.put(key, value);
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
        public EventContext build() {
            return new EventContext(this.entries);
        }

    }

}

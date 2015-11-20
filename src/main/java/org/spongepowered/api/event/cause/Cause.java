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
import static org.apache.commons.lang3.Validate.noNullElements;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.cause.entity.spawn.SpawnCause;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.SpawnEntityEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A cause represents the reason or initiator of an event.
 *
 * <p>For example, if a block of sand is placed where it drops, the block
 * of sand would create a falling sand entity, which then would place another
 * block of sand. The block place event for the final block of sand would have
 * the cause chain of the block of sand -&gt; falling sand entity.</p>
 *
 * <p>It is not possible to accurately the describe the chain of causes in
 * all scenarios so a best effort approach is generally acceptable. For
 * example, a player might press a lever, activating a complex Redstone
 * circuit, which would then launch TNT and cause the destruction of
 * some blocks, but tracing this event would be too complicated and thus
 * may not be attempted.</p>
 */
@SuppressWarnings("unchecked")
public abstract class Cause {

    private static final Cause EMPTY = new EmptyCause();

    /**
     * Gets the "empty" {@link Cause}. If a {@link Cause} is required, but
     * there is no {@link Object} that can be stated as the direct "cause" of
     * an {@link Event}, an "empty" {@link Cause} can be used.
     *
     * @return The empty cause instance
     */
    public static Cause empty() {
        return EMPTY;
    }

    /**
     * Creates a new {@link Cause} of the provided {@link Object}s. Note that
     * none of the provided {@link Object}s can be <code>null</code>. The order
     * of the objects should represent the "priority" that the object aided in
     * the "cause" of an {@link Event}. The first {@link Object} should be the
     * direct "cause" of the {@link Event}.
     *
     * <p>Usually, in most cases, some {@link Event}s will have "helper"
     * objects to interface with their direct causes, such as
     * {@link DamageSource} for an {@link DamageEntityEvent}, or a
     * {@link SpawnCause} for an {@link SpawnEntityEvent}.</p>
     *
     * @param objects The objects being the cause
     * @return The new cause
     */
    public static Cause of(Object... objects) {
        checkNotNull(objects, "The objects cannot be null!");
        if (objects.length == 0) {
            return EMPTY;
        }
        noNullElements(objects, "No elements in a cause can be null!");
        return new PresentCause(objects);
    }

    public static Cause ofNullable(@Nullable Object... objects) {
        if (objects == null || objects.length == 0) {
            return EMPTY;
        } else {
            List<Object> list = new ArrayList<>();
            for (Object object : objects) {
                if (object != null) {
                    list.add(object);
                }
            }
            return new PresentCause(list.toArray());
        }
    }

    Cause() {}

    /**
     * Gets whether this {@link Cause} is empty of any causes or not. An empty
     * cause may mean the {@link Cause} is not originating from any vanilla
     * interactions, or it may mean the cause is simply not known.
     *
     * @return True if this cause is empty, false otherwise
     */
    public abstract boolean isEmpty();

    /**
     * Gets the root {@link Object} of this cause. The root can be anything,
     * including but not limited to: {@link DamageSource}, {@link Entity},
     * {@link SpawnCause}, etc.
     *
     * @return The root object cause for this cause
     */
    public abstract Optional<?> root();

    /**
     * Gets the first <code>T</code> object of this {@link Cause}, if
     * available.
     *
     * @param target The class of the target type
     * @param <T> The type of object being queried for
     * @return The first element of the type, if available
     */
    public abstract <T> Optional<T> first(Class<T> target);

    /**
     * Gets the last object instance of the {@link Class} of type
     * <code>T</code>.
     *
     * @param target The class of the target type
     * @param <T> The type of object being queried for
     * @return The last element of the type, if available
     */
    public abstract <T> Optional<T> last(Class<T> target);

    /**
     * Gets the object associated with the provided name. Note that
     * all objects in a cause are uniquely named.
     *
     * @param named The name associated with the object cause
     * @param <T> The type of the object expected
     * @return The object, if the type is correct and the name was associated
     */
    public abstract <T> Optional<T> get(String named);

    /**
     * Gets the object immediately before the object that is an instance of
     * the {@link Class} passed in.
     *
     * @param clazz The class of the object
     * @return The object
     */
    public abstract Optional<?> before(Class<?> clazz);

    /**
     * Gets the object immediate before the named object cause. The
     * type of object is unknown.
     *
     * @param named The name associated with the cause object
     * @return The object, if available
     */
    public abstract Optional<?> before(String named);

    /**
     * Gets the object immediately after the object that is an instance of
     * the {@link Class} passed in.
     *
     * @param clazz The class to type check
     * @return The object after, if available
     */
    public abstract Optional<?> after(Class<?> clazz);

    /**
     * Gets the object immediately after the named object cause.
     *
     * @param named The name associated with the cause object
     * @return The object after, if available
     */
    public abstract Optional<?> after(String named);

    /**
     * Returns whether the target class matches any object of this {@link Cause}.
     * @param target The class of the target type
     * @return True if found, false otherwise
     */
    public abstract boolean any(Class<?> target);

    /**
     * Checks if this cause contains of any of the provided {@link Object}. This
     * is the equivalent to checking based on {@link #equals(Object)} for each
     * object in this cause.
     *
     * @param object The object to check if it is contained
     * @return True if the object is contained within this cause
     */
    public abstract boolean contains(Object object);

    /**
     * Returns whether there are any objects associated with the provided name.
     *
     * @param named The name associated with a cause object
     * @return True if found, false otherwise
     */
    public abstract boolean any(String named);

    /**
     * Gets an {@link ImmutableList} of all objects that are instances of the
     * given {@link Class} type <code>T</code>.
     *
     * @param <T> The type of objects to query for
     * @param target The class of the target type
     * @return An immutable list of the objects queried
     */
    public abstract <T> List<T> allOf(Class<T> target);

    /**
     * Gets an immutable {@link List} with all object causes that are not
     * instances of the provided {@link Class}.
     *
     * @param ignoredClass The class of object types to ignore
     * @return The list of objects not an instance of the provided class
     */
    public abstract List<Object> noneOf(Class<?> ignoredClass);

    /**
     * Gets an {@link List} of all causes within this {@link Cause}.
     *
     * @return An immutable list of all the causes
     */
    public abstract List<Object> all();

    /**
     * Creates a new {@link Cause} where the objects are added at the end of
     * the cause array of objects.
     *
     * @param additional The additional objects to add
     * @return The new cause
     */
    public abstract Cause with(Object... additional);

    /**
     * Creates a new {@link Cause} where the objects are added at the end of
     * the cause array of objects.
     *
     * @param iterable The additional objects
     * @return The new cause
     */
    public abstract Cause with(Iterable<?> iterable);

    /**
     * Gets an immutable {@link Map} of the named object causes that can be
     * used for analysis. Note that the map should retain proper order of
     * entries such that the order of entries should coincide with the order
     * of objects in {@link #all()}.
     *
     * @return An immutable map of the names of cause objects to the objects
     */
    public abstract Map<String, Object> getNamedCauses();

    /**
     * Returns {@code true} if {@code object} is a {@code Cause} instance, and
     * either the contained references are {@linkplain Object#equals equal} to
     * each other or both are absent.
     */
    @Override
    public abstract boolean equals(@Nullable Object object);

    /**
     * Returns a hash code for this instance.
     */
    @Override
    public abstract int hashCode();

    private static final class PresentCause extends Cause {
        private final Object[] cause;
        private final String[] names;

        // lazy load
        @Nullable private Map<String, Object> namedObjectMap;

        PresentCause(Object... causes) {
            final List<Object> list = new ArrayList<>(causes.length);
            final List<String> names = new ArrayList<>(causes.length);
            for (Object aCause : causes) {
                checkNotNull(aCause, "Null cause element!");
                if (aCause instanceof NamedCause) {
                    checkArgument(!(((NamedCause) aCause).getCauseObject() instanceof NamedCause), "A named cause cannot wrap around a named cause!");
                    list.add(((NamedCause) aCause).getCauseObject());
                    checkArgument(!names.contains(((NamedCause) aCause).getName()), "Names need to be unique! There is already a named cause of: "
                    + ((NamedCause) aCause).getName());
                    names.add(((NamedCause) aCause).getName());
                } else {
                    list.add(aCause);
                    names.add("unknown" + list.size() + aCause.getClass().getName());
                }
            }

            this.cause = list.toArray();
            this.names = names.toArray(new String[names.size()]);
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public Optional<?> root() {
            return Optional.of(this.cause[0]);
        }

        @Override
        public <T> Optional<T> first(Class<T> target) {
            for (Object aCause : this.cause) {
                if (target.isInstance(aCause)) {
                    return Optional.of((T) aCause);
                }
            }
            return Optional.empty();
        }

        @Override
        public <T> Optional<T> get(String named) {
            checkArgument(named != null, "The name cannot be null!");
            for (int i = 0; i < this.names.length; i++) {
                if (this.names[i].equalsIgnoreCase(named)) {
                    return getCauseAtIndex(i);
                }
            }
            return Optional.empty();
        }

        @Override
        public <T> List<T> allOf(Class<T> target) {
            ImmutableList.Builder<T> builder = ImmutableList.builder();
            for (Object aCause : this.cause) {
                if (target.isInstance(aCause)) {
                    builder.add((T) aCause);
                }
            }
            return builder.build();
        }

        @Override
        public List<Object> noneOf(Class<?> ignoredClass) {
            ImmutableList.Builder<Object> builder = ImmutableList.builder();
            for (Object cause : this.cause) {
                if (!ignoredClass.isInstance(cause)) {
                    builder.add(cause);
                }
            }
            return builder.build();
        }

        @Override
        public <T> Optional<T> last(Class<T> target) {
            for (int i = this.cause.length - 1; i >= 0; i--) {
                if (target.isInstance(this.cause[i])) {
                    return Optional.of((T) this.cause[i]);
                }
            }
            return Optional.empty();
        }

        private <T> Optional<T> getCauseAtIndex(int index) {
            try {
                final Object object = this.cause[index];
                return Optional.of((T) object);
            } catch (Exception e) {
                return Optional.empty();
            }
        }

        @Override
        public Optional<?> before(Class<?> clazz) {
            checkArgument(clazz != null, "The provided class cannot be null!");
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

        @Override
        public Optional<?> before(String named) {
            checkArgument(named != null, "The name cannot be null!");
            if (this.cause.length == 1) {
                return Optional.empty();
            }
            for (int i = 0; i < this.names.length; i++) {
                if (this.names[i].equalsIgnoreCase(named)) {
                    try {
                        final Object object = this.cause[i - 1];
                        return Optional.of(object);
                    } catch (Exception e) {
                        return Optional.empty();
                    }
                }
            }
            return Optional.empty();
        }

        @Override
        public Optional<?> after(Class<?> clazz) {
            checkArgument(clazz != null, "The provided class cannot be null!");
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

        @Override
        public Optional<?> after(String named) {
            checkArgument(named != null, "The name cannot be null!");
            if (this.cause.length == 1) {
                return Optional.empty();
            }
            for (int i = 0; i < this.names.length; i++) {
                if (this.names[i].equalsIgnoreCase(named) && i + 1 < this.cause.length) {
                    try {
                        final Object object = this.cause[i + 1];
                        return Optional.of(object);
                    } catch (Exception e) {
                        return Optional.empty();
                    }
                }
            }
            return Optional.empty();
        }

        @Override
        public boolean any(Class<?> target) {
            checkArgument(target != null, "The provided class cannot be null!");
            for (Object aCause : this.cause) {
                if (target.isInstance(aCause)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean contains(Object object) {
            for (Object aCause : this.cause) {
                if (aCause.equals(object)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean any(String named) {
            checkArgument(named != null, "The name cannot be null!");
            for (String name : this.names) {
                if (name.equalsIgnoreCase(named)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public List<Object> all() {
            return ImmutableList.copyOf(this.cause);
        }

        @Override
        public Cause with(Object... additional) {
            checkArgument(additional != null, "Cannot add a null argument!");
            Object[] objects = new Object[this.cause.length + additional.length];
            for (int i = 0; i < this.cause.length; i++) {
                objects[i] = NamedCause.of(this.names[i], this.cause[i]);
            }
            for (int i = 0; i < additional.length; i++) {
                final Object object = additional[i];
                checkArgument(object != null, "Cannot add a null argument!");
                if (object instanceof NamedCause) {
                    objects[this.cause.length + i] = object;
                } else {
                    objects[this.cause.length + i] = NamedCause.of("unknown" + (this.cause.length + i) + object.getClass().getName(), object);
                }
            }
            return of(objects);
        }

        @Override
        public Cause with(Iterable<?> iterable) {
            List<Object> list = new ArrayList<>();
            for (int i = 0; i < this.cause.length; i++) {
                list.add(NamedCause.of(this.names[i], this.cause[i]));
            }
            for (Object o : iterable) {
                checkArgument(o != null, "Cannot add null causes");
                if (o instanceof NamedCause) {
                    list.add(o);
                } else {
                    list.add(NamedCause.of("unknown" + list.size() + o.getClass().getName(), o));
                }
            }
            return of(list.toArray());
        }

        @Override
        public Map<String, Object> getNamedCauses() {
            if (this.namedObjectMap == null) {
                final ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
                for (int i = 0; i < this.names.length; i++) {
                    builder.put(this.names[i], this.cause[i]);
                }
                this.namedObjectMap = builder.build();
            }
            return this.namedObjectMap;
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof PresentCause) {
                PresentCause cause = ((PresentCause) object);
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
            return "Cause{" + Arrays.deepToString(this.cause) + "}";
        }
    }

    private static final class EmptyCause extends Cause {

        EmptyCause() {}

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public Optional<?> root() {
            return Optional.empty();
        }

        @Override
        public <T> Optional<T> first(Class<T> target) {
            return Optional.empty();
        }

        @Override
        public <T> Optional<T> get(String named) {
            return Optional.empty();
        }

        @Override
        public <T> Optional<T> last(Class<T> target) {
            return Optional.empty();
        }

        @Override
        public Optional<?> before(Class<?> clazz) {
            return Optional.empty();
        }

        @Override
        public Optional<?> before(String named) {
            return Optional.empty();
        }

        @Override
        public Optional<?> after(Class<?> clazz) {
            return Optional.empty();
        }

        @Override
        public Optional<?> after(String named) {
            return Optional.empty();
        }

        @Override
        public boolean any(Class<?> target) {
            return false;
        }

        @Override
        public boolean contains(Object object) {
            return false;
        }

        @Override
        public boolean any(String named) {
            return false;
        }

        @Override
        public <T> List<T> allOf(Class<T> target) {
            return ImmutableList.of();
        }

        @Override
        public List<Object> noneOf(Class<?> ignoredClass) {
            return ImmutableList.of();
        }

        @Override
        public List<Object> all() {
            return ImmutableList.of();
        }

        @Override
        public Cause with(Object... additional) {
            return of(additional);
        }

        @Override
        public Cause with(Iterable<?> iterable) {
            List<Object> list = new ArrayList<>();
            for (Object o : iterable) {
                list.add(o);
            }
            return of(list.toArray());
        }

        @Override
        public Map<String, Object> getNamedCauses() {
            return ImmutableMap.of();
        }

        @Override
        public boolean equals(@Nullable Object object) {
            return object == this;
        }

        @Override
        public int hashCode() {
            return 0x39e8a5b;
        }

        @Override
        public String toString() {
            return "Cause{}";
        }
    }

}

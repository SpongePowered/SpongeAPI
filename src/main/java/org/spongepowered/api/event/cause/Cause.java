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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;

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
public final class Cause {

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
    public static Cause of(Object object, Object... objects) {
        checkArgument(object != null, "The source object cannot be null!");
        checkNotNull(objects, "The objects cannot be null!");
        List<Object> list = new ArrayList<>();
        list.add(object);
        Collections.addAll(list, objects);
        checkArgument(!list.isEmpty(), "Cause cannot be empty!");
        return of(list);
    }

    /**
     * Creates a new {@link Cause} of the provided {@link Iterable}s. The order
     * of the objects should represent the "priority" that the object aided in
     * the "cause" of an {@link Event}. The first {@link Object} should be the
     * direct "cause" of the {@link Event}.
     *
     * <p>Usually, in most cases, some {@link Event}s will have "helper"
     * objects to interface with their direct causes, such as
     * {@link DamageSource} for an {@link DamageEntityEvent}, or a
     * {@link SpawnCause} for an {@link SpawnEntityEvent}.</p>
     *
     * @param iterable The objects being the cause
     * @return The new cause
     */
    public static Cause of(Iterable<?> iterable) {
        checkArgument(iterable != null, "The source object cannot be null!");
        List<NamedCause> list = new ArrayList<>();
        for (Object listObj : iterable) {
            if (listObj instanceof NamedCause) {
                list.add((NamedCause) listObj);
            } else {
                checkArgument(listObj != null, "Cause object cannot be null!");
                list.add(NamedCause.of("unknown" + (list.size() + 1) + listObj.getClass().getSimpleName(), listObj));
            }
        }
        checkArgument(!list.isEmpty(), "Cause cannot be empty!");
        return fromList(list);
    }

    /**
     * Creates a new {@link Cause} of the provided {@link Object} array. The
     * order of the objects should represent the "priority" that the object
     * aided in the "cause" of an {@link Event}. The first {@link Object}
     * should be the direct "cause" of the {@link Event}.
     *
     * <p>Usually, in most cases, some {@link Event}s will have "helper"
     * objects to interface with their direct causes, such as
     * {@link DamageSource} for an {@link DamageEntityEvent}, or a
     * {@link SpawnCause} for an {@link SpawnEntityEvent}.</p>
     *
     * @param objects The objects being the cause
     * @return The new cause
     */
    public static Cause of(Object[] objects) {
        checkArgument(objects != null, "The source object cannot be null!");
        List<Object> list = new ArrayList<>();
        Collections.addAll(list, objects);
        return of(list);
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
    public static Cause ofNullable(@Nullable Object object, @Nullable Object... objects) {
        checkArgument(object != null || (objects != null && objects.length != 0), "There must be at least one object in a cause!");
        List<NamedCause> list = new ArrayList<>();
        if (object instanceof Object[]) {
            for (Object arrayObj : ((Object[]) object)) {
                if (arrayObj instanceof NamedCause) {
                    list.add((NamedCause) arrayObj);
                } else if (arrayObj != null) {
                    list.add(NamedCause.of("unknown" + (list.size() + 1) + arrayObj.getClass().getName(), arrayObj));
                }
            }
        } else if (object instanceof Iterable) {
            for (Object listObj : ((Iterable<Object>) object)) {
                if (listObj instanceof NamedCause) {
                    list.add((NamedCause) listObj);
                } else if (listObj != null) {
                    list.add(NamedCause.of("unknown" + (list.size() + 1) + listObj.getClass().getName(), listObj));
                }
            }
        } else if (object != null) {
            if (object instanceof NamedCause) {
                list.add((NamedCause) object);
            } else {
                list.add(NamedCause.of("unknown" + (list.size() + 1) + object.getClass().getName(), object));
            }
        }
        if (objects != null) {
            for (Object cause : objects) {
                if (cause != null) {
                    if (object instanceof NamedCause) {
                        list.add((NamedCause) object);
                    } else {
                        list.add(NamedCause.of("unknown" + (list.size() + 1) + object.getClass().getName(), object));
                    }
                }
            }
        }
        checkArgument(!list.isEmpty(), "There must be at least one object within a cause!");
        return fromList(list);
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
     * @param iterable The objects being the cause
     * @return The new cause
     */
    public static Cause ofNullable(Iterable<?> iterable) {
        checkArgument(iterable != null, "The iterable cannot be null!");
        List<NamedCause> list = new ArrayList<>();
        for (Object arrayObj : iterable) {
            checkNotNull(arrayObj, "Iterable object cannot be null!");
            if (arrayObj instanceof NamedCause) {
                list.add((NamedCause) arrayObj);
            } else {
                list.add(NamedCause.of("unknown" + (list.size() + 1) + arrayObj.getClass().getName(), arrayObj));
            }
        }
        checkArgument(!list.isEmpty(), "Must at least have one object in the cause!");
        return fromList(list);
    }

    /**
     * Creates a new {@link Cause} of the provided {@link Object}s. Note that
     * any of the provided {@link Object}s can be <code>null</code>. The order
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
    public static Cause ofNullable(Object[] objects) {
        checkArgument(objects != null, "The source object cannot be null!");
        List<NamedCause> list = new ArrayList<>();
        for (Object arrayObj : objects) {
            if (arrayObj instanceof NamedCause) {
                list.add((NamedCause) arrayObj);
            } else if (arrayObj != null) {
                list.add(NamedCause.of("unknown" + (list.size() + 1) + arrayObj.getClass().getName(), arrayObj));
            }
        }
        checkArgument(!list.isEmpty(), "Must at least have one object in the cause!");
        return fromList(list);
    }

    private static Cause fromList(List<NamedCause> causes) {
        final List<String> nameList = new ArrayList<>();
        for (NamedCause cause : causes) {
            if (!nameList.contains(cause.getName())) {
                nameList.add(cause.getName());
            } else {
                throw new IllegalArgumentException("A named cause already exists with the name: " + cause.getName());
            }
        }
        return new Cause(causes.toArray(new NamedCause[causes.size()]));
    }

    private final Object[] cause;
    private final String[] names;
    private final ImmutableList<Object> immutableCauses;


    // lazy load
    @Nullable private Map<String, Object> namedObjectMap;

    private Cause(NamedCause[] causes) {
        // basically, no validation, all the validation should take place calling this constructor
        final Object[] objects = new Object[causes.length];
        final String[] names = new String[causes.length];
        for (int index = 0; index < causes.length; index++) {
            NamedCause aCause = causes[index];
            checkNotNull(aCause, "Null cause element!");
            objects[index] = aCause.getCauseObject();
            names[index] = aCause.getName();
        }
        this.cause = objects;
        this.names = names;
        this.immutableCauses = ImmutableList.copyOf(this.cause);
    }

    /**
     * Gets the root {@link Object} of this cause. The root can be anything,
     * including but not limited to: {@link DamageSource}, {@link Entity},
     * {@link SpawnCause}, etc.
     *
     * @return The root object cause for this cause
     */
    public Object root() {
        return this.cause[0];
    }

    /**
     * Gets the first <code>T</code> object of this {@link Cause}, if
     * available.
     *
     * @param target The class of the target type
     * @param <T> The type of object being queried for
     * @return The first element of the type, if available
     */
    public <T> Optional<T> first(Class<T> target) {
        for (Object aCause : this.cause) {
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
    public <T> Optional<T> last(Class<T> target) {
        for (int i = this.cause.length - 1; i >= 0; i--) {
            if (target.isInstance(this.cause[i])) {
                return Optional.of((T) this.cause[i]);
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the object associated with the provided name. Note that
     * all objects in a cause are uniquely named.
     *
     * @param named The name associated with the object cause
     * @param expected The expected class type of the cause object
     * @param <T> The type of the object expected
     * @return The object, if the type is correct and the name was associated
     */
    public <T> Optional<T> get(String named, Class<T> expected) {
        checkArgument(named != null, "The name cannot be null!");
        checkArgument(expected != null, "The expected class cannot be null!");
        for (int i = 0; i < this.names.length; i++) {
            if (this.names[i].equalsIgnoreCase(named)) {
                final Object object = this.cause[i];
                if (expected.isInstance(object)) {
                    return Optional.of((T) object);
                }
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    /**
     * Gets the object immediately before the object that is an instance of
     * the {@link Class} passed in.
     *
     * @param clazz The class of the object
     * @return The object
     */
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

    /**
     * Gets the object immediate before the named object cause. The
     * type of object is unknown.
     *
     * @param named The name associated with the cause object
     * @return The object, if available
     */
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

    /**
     * Gets the object immediately after the object that is an instance of
     * the {@link Class} passed in.
     *
     * @param clazz The class to type check
     * @return The object after, if available
     */
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

    /**
     * Gets the object immediately after the named object cause.
     *
     * @param named The name associated with the cause object
     * @return The object after, if available
     */
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

    /**
     * Returns whether the target class matches any object of this {@link Cause}.
     * @param target The class of the target type
     * @return True if found, false otherwise
     */
    public boolean containsType(Class<?> target) {
        checkArgument(target != null, "The provided class cannot be null!");
        for (Object aCause : this.cause) {
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
    public boolean contains(Object object) {
        for (Object aCause : this.cause) {
            if (aCause.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether there are any objects associated with the provided name.
     *
     * @param named The name associated with a cause object
     * @return True if found, false otherwise
     */
    public boolean containsNamed(String named) {
        checkArgument(named != null, "The name cannot be null!");
        for (String name : this.names) {
            if (name.equalsIgnoreCase(named)) {
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
    public <T> List<T> allOf(Class<T> target) {
        ImmutableList.Builder<T> builder = ImmutableList.builder();
        for (Object aCause : this.cause) {
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
    public List<Object> noneOf(Class<?> ignoredClass) {
        ImmutableList.Builder<Object> builder = ImmutableList.builder();
        for (Object cause : this.cause) {
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
        return this.immutableCauses;
    }

    /**
     * Creates a new {@link Cause} where the objects are added at the end of
     * the cause array of objects.
     *
     * @param additional The additional object to add
     * @param additionals The remaining objects to add
     * @return The new cause
     */
    public Cause with(Object additional, Object... additionals) {
        checkArgument(additional != null, "No null arguments allowed!");
        List<Object> list = new ArrayList<>();
        list.add(additional);
        for (Object object : additionals) {
            checkArgument(object != null, "Cannot add null objects!");
            list.add(object);
        }
        return with(list);
    }

    /**
     * Creates a new {@link Cause} where the objects are added at the end of
     * the cause array of objects.
     *
     * @param iterable The additional objects
     * @return The new cause
     */
    public Cause with(Iterable<?> iterable) {
        List<NamedCause> list = new ArrayList<>();
        for (int i = 0; i < this.cause.length; i++) {
            list.add(NamedCause.of(this.names[i], this.cause[i]));
        }
        for (Object o : iterable) {
            checkArgument(o != null, "Cannot add null causes");
            if (o instanceof NamedCause) {
                list.add((NamedCause) o);
            } else {
                list.add(NamedCause.of("unknown" + (list.size() + 1) + o.getClass().getSimpleName(), o));
            }
        }
        return fromList(list);
    }

    /**
     * Merges this cause with the other cause. This provides some semblance of
     * re-naming the previous "Source" of the other {@link Cause} to be
     * renamed appropriately.
     *
     * @param cause The cause to merge with this
     * @return The new merged cause
     */
    public Cause merge(Cause cause) {
        List<String> names = new ArrayList<>();
        List<NamedCause> causes = new ArrayList<>();
        for (int i = 0; i < this.cause.length; i++) {
            causes.add(NamedCause.of(this.names[i], this.cause[i]));
            names.add(this.names[i]);
        }
        int iteration = 1;
        for (int i = 0; i < cause.cause.length; i++) {
            String name = cause.names[i].equalsIgnoreCase("Source")
                          ? "AdditionalSource" : cause.names[i].equalsIgnoreCase("AdditionalSource")
                                                 ? "PreviousSource" : cause.names[i];
            if (names.contains(name)) {
                name += iteration++;
            }
            if (!names.contains(name)) {
                causes.add(NamedCause.of(name, cause.cause[i]));
            } else {
                throw new IllegalArgumentException("Cannot have duplicate names of objects in a cause! Duplicate found: " + cause.names[i]);
            }
        }
        return fromList(causes);
    }

    /**
     * Gets an immutable {@link Map} of the named object causes that can be
     * used for analysis. Note that the map should retain proper order of
     * entries such that the order of entries should coincide with the order
     * of objects in {@link #all()}.
     *
     * @return An immutable map of the names of cause objects to the objects
     */
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
        if (object instanceof Cause) {
            Cause cause = ((Cause) object);
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
        String causeString = "Cause[";
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < this.cause.length; i++) {
            joiner.add("{Name=" + this.names[i] + ", Object={" + this.cause[i].toString() + "}}");
        }
        return causeString + joiner.toString() + "]";
    }

}

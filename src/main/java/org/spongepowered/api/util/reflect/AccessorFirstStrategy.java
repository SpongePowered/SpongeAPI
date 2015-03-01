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

package org.spongepowered.api.util.reflect;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

/**
 * Finds properties by enumerating accessors and then later finding the
 * closest matching mutator.
 */
public class AccessorFirstStrategy implements PropertySearchStrategy {

    private static final Pattern ACCESSOR = Pattern.compile("^get([A-Z].*)");
    private static final Pattern ACCESSOR_BOOL = Pattern.compile("^is([A-Z].*)");
    private static final Pattern ACCESSOR_KEEPS = Pattern.compile("^(keeps[A-Z].*)");
    private static final Pattern MUTATOR = Pattern.compile("^set([A-Z].*)");

    /**
     * Find the corresponding mutator for an accessor method from a collection
     * of candidates.
     *
     * @param accessor The accessor
     * @param candidates The collection of candidates
     * @return A mutator, if found
     */
    @Nullable
    private static Method findMutator(Method accessor, Collection<Method> candidates) {
        Class<?> expectedType = accessor.getReturnType();

        for (Method method : candidates) {
            // TODO: Handle supertypes
            if (method.getParameterTypes()[0] == expectedType) {
                return method;
            }
        }

        return null;
    }

    /**
     * Detect whether the given method is an accessor and if so, return the
     * property name.
     *
     * @param method The method
     * @return The property name, if the method is an accessor
     */
    @Nullable
    private static String getAccessorName(Method method) {
        Matcher m;

        if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 0) {
            m = ACCESSOR.matcher(method.getName());
            if (m.matches() && !method.getReturnType().equals(void.class)) {
                return getPropertyName(m.group(1));
            }

            m = ACCESSOR_BOOL.matcher(method.getName());
            if (m.matches() && method.getReturnType().equals(boolean.class)) {
                return getPropertyName(m.group(1));
            }

            m = ACCESSOR_KEEPS.matcher(method.getName());
            if (m.matches() && method.getReturnType().equals(boolean.class)) {
                return getPropertyName(m.group(1));
            }
        }
        return null;
    }

    /**
     * Detect whether the given method is an mutator and if so, return the
     * property name.
     *
     * @param method The method
     * @return The property name, if the method is an mutator
     */
    @Nullable
    private static String getMutatorName(Method method) {
        Matcher m;

        if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 1 && method.getReturnType() == void.class) {
            m = MUTATOR.matcher(method.getName());
            if (m.matches()) {
                return getPropertyName(m.group(1));
            }
        }

        return null;
    }

    /**
     * Clean up the property name.
     *
     * @param name The name
     * @return The cleaned up name
     */
    private static String getPropertyName(String name) {
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }

    @Override
    public ImmutableSet<? extends Property> findProperties(final Class<?> type) {
        checkNotNull(type, "type");

        final Map<String, Method> accessors = Maps.newHashMap();
        final Multimap<String, Method> mutators = HashMultimap.create();
        final Queue<Class<?>> queue = new NonNullUniqueQueue<Class<?>>();

        queue.add(type); // Start off with our target type

        Class<?> scannedType;
        while ((scannedType = queue.poll()) != null) {
            for (Method method : scannedType.getMethods()) {
                String name;

                if ((name = getAccessorName(method)) != null) {
                    accessors.put(name, method);
                } else if ((name = getMutatorName(method)) != null) {
                    mutators.put(name, method);
                }
            }

            for (Class<?> implInterfaces : scannedType.getInterfaces()) {
                queue.offer(implInterfaces);
            }

            queue.offer(scannedType.getSuperclass());
        }

        final ImmutableSet.Builder<Property> result = ImmutableSet.builder();

        for (Map.Entry<String, Method> entry : accessors.entrySet()) {
            Method accessor = entry.getValue();
            @Nullable Method mutator = findMutator(entry.getValue(), mutators.get(entry.getKey()));
            result.add(new Property(entry.getKey(), accessor.getReturnType(), accessor, mutator));
        }

        return result.build();
    }

}

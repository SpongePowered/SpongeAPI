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
package org.spongepowered.api.service.permission;

import com.google.common.base.Preconditions;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A class defining attributes about how a permissions plugin should interpret a certain subject type.
 */
public final class SubjectTypeDefinition {

    private static final SubjectTypeDefinition DEFAULT = builder().build();

    private final boolean transientHasPriority;
    private final Predicate<String> identifierValidityPredicate;
    private final Function<String, Optional<String>> nameIdentifierMapping;

    public static Builder builder() {
        return new Builder();
    }

    public static SubjectTypeDefinition defaults() {
        return DEFAULT;
    }

    private SubjectTypeDefinition(Builder builder) {
        this.transientHasPriority = builder.transientHasPriority;
        this.identifierValidityPredicate = builder.getIdentifierValidityPredicate();
        this.nameIdentifierMapping = builder.getNameIdentifierMapping();
    }

    /**
     * Return whether transient data has priority over persistent data for this subject type for lookups
     *
     * @return The priority of transient data
     */
    public boolean transientHasPriority() {
        return this.transientHasPriority;
    }

    /**
     * A predicate that determines whether or not a given identifier is valid for this subject type.
     *
     * @return The predicate
     */
    public Predicate<String> getIdentifierValidityPredicate() {
        return this.identifierValidityPredicate;
    }

    /**
     * A function that can map a subject's friendly name to its internal identifier. For example, for player subjects this function would map
     * player names to the UUIDs used internally.
     *
     * @return The mapping from name to identifier
     */
    public Function<String, Optional<String>> getNameIdentifierMapping() {
        return this.nameIdentifierMapping;
    }

    /**
     * Builder for {@link SubjectTypeDefinition} objects.
     */
    public static final class Builder {
        private boolean transientHasPriority = true;
        private Predicate<String> identifierValidityPredicate = name -> true;
        private Function<String, Optional<String>> nameIdentifierMapping = Optional::of;

        private Builder() {
        }

        public boolean transientHasPriority() {
            return this.transientHasPriority;
        }

        public Builder setTransientHasPriority(boolean transientHasPriority) {
            this.transientHasPriority = transientHasPriority;
            return this;
        }

        /**
         * @see SubjectTypeDefinition#getIdentifierValidityPredicate()
         *
         * @return The predicate
         */
        public Predicate<String> getIdentifierValidityPredicate() {
            return this.identifierValidityPredicate;
        }

        public Builder setIdentifierValidityPredicate(Predicate<String> identifierValidityPredicate) {
            this.identifierValidityPredicate = Preconditions.checkNotNull(identifierValidityPredicate, "identifierValidityPredicate");
            return this;
        }

        /**
         * @see SubjectTypeDefinition#getNameIdentifierMapping()
         *
         * @return The mapping function
         */
        public Function<String, Optional<String>> getNameIdentifierMapping() {
            return this.nameIdentifierMapping;
        }

        public Builder setNameIdentifierMapping(Function<String, Optional<String>> nameIdentifierMapping) {
            this.nameIdentifierMapping = Preconditions.checkNotNull(nameIdentifierMapping, "nameIdentifierMapping");
            return this;
        }

        public SubjectTypeDefinition build() {
            return new SubjectTypeDefinition(this);
        }
    }

}

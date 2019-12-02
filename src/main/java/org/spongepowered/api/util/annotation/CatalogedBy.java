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
package org.spongepowered.api.util.annotation;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.CatalogType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates a {@link CatalogType} class to specify a set of special catalog
 * classes which act as the catalog for the annotated type. The annotated class
 * must extend {@link CatalogType}, and the specified catalog classes should be
 * queryable or otherwise serve constant instances of the cataloged type.
 *
 * <p>All Classes mentioned in the CatalogedBy annotation must meet the
 * following requirements:</p>
 * <ul>
 * <li>The values served by catalog classes must remain the same and valid
 * at all times.</li>
 * <li>The variables in catalog classes may link to null if the given value is
 * no longer valid and no appropriate alternative can be found. If no
 * alternative could be found and if there probably won't be a new one in the
 * future then the field should be marked as deprecated and should be removed
 * after a grace period or with the next big release of minecraft, SpongeAPI or
 * the containing artifact.</li>
 * <li>It is possible for two or more different variables to link to the same
 * value. This includes both simple "well known" aliases and features that been
 * merged together or that were originally very similar and one has been
 * removed.</li>
 * <li>It is also possible that one or more values are not listed in the
 * catalog classes (Especially plugin or mod provided ones).</li>
 * </ul>
 *
 */
@NonNull
@Target(ElementType.TYPE)
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CatalogedBy {

    /**
     * Gets the class that is the catalog for this {@link CatalogedBy} type.
     * Since the type class annotated with {@link CatalogedBy} knows what the
     * catalog class is, we can safely rely on the value to get all known
     * instances of the {@link CatalogedBy}.
     *
     * <p>This is similar to knowing at runtime that all available
     * "EntityType"(s) are cataloged in the "EntityTypes" class.</p>
     *
     * @return The registrar class of the catalog
     */
    Class<?>[] value();

}

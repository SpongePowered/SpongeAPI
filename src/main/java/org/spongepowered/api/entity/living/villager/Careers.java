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
package org.spongepowered.api.entity.living.villager;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Optional;

import java.util.List;

/**
 * A utility class for getting all available {@link Career}s.
 */
public final class Careers {

    private Careers() {

    }

    public static final Career FARMER = null;
    public static final Career FISHERMAN = null;
    public static final Career SHEPHERD = null;
    public static final Career FLETCHER = null;
    public static final Career LIBRARIAN = null;
    public static final Career CLERIC = null;
    public static final Career ARMORER = null;
    public static final Career WEAPON_SMITH = null;
    public static final Career TOOL_SMITH = null;
    public static final Career BUTCHER = null;
    public static final Career LEATHERWORKER = null;

    /**
     * Gets all available {@link Profession}s.
     *
     * @return A list of all professions
     */
    public static List<Career> getValues() {
        return null;
    }

    /**
     * Gets the {@link Profession} with the specified name.
     *
     * @param name The name of the profession to return
     * @return The profession with the given name, if available
     */
    public static Optional<Career> getCareerByName(final String name) {
        checkArgument(name != null, "Cannot have a null profession name!");
        return Optional.fromNullable(null);
    }

    public static List<Career> getCareersForProfession(final Profession profession) {
        checkArgument(profession != null, "Cannot get careers for a null profession!");
        return null;
    }
}

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

import java.util.List;

import com.google.common.base.Optional;

/**
 * A utility class for easy access to all available {@link Career}s.
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
     * Gets all available {@link Career}s.
     *
     * @return An immutable list of all careers
     */
    public static List<Career> getValues() {
        return NullVillagerFactory.factory.getCareers();
    }

    /**
     * Gets all {@link Career}s belonging to the specified {@link Profession}.
     * Returns a non empty list of {@link Profession}s or null if the given
     * {@link Profession} is null.
     *
     * @param profession The profession which careers should be returned.
     * @return An immutable list of careers belonging to the given profession or
     *         null if profession is null
     * @see Career#getProfession()
     */
    public static List<Career> getValuesForProfession(final Profession profession) {
        return NullVillagerFactory.factory.getCareersFromProfession(profession);
    }

    /**
     * Gets the {@link Career} with the specified name or null if there is no
     * such career.
     *
     * @param name The name of the career to return
     * @return The career with the given name or null
     */
    public static Optional<Career> valueOf(final String name) {
        return Optional.fromNullable(NullVillagerFactory.factory.getCareerFromName(name));
    }

}

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
 * A utility class for easy access to all available {@link Profession}s.
 */
public final class Professions {

    private Professions() {
    }

    public static final Profession FARMER = null;
    public static final Profession LIBRARIAN = null;
    public static final Profession PRIEST = null;
    public static final Profession BLACKSMITH = null;
    public static final Profession BUTCHER = null;

    /**
     * Gets all available {@link Profession}s.
     * 
     * @return An immutable list of all professions
     */
    public static List<Profession> getValues() {
        return NullVillagerFactory.factory.getProfessions();
    }

    /**
     * Gets the {@link Profession} with the specified name or null if there is
     * no such profession.
     * 
     * @param name The name of the profession to return
     * @return The profession with the given name or null
     */
    public static Optional<Profession> valueOf(final String name) {
        return Optional.fromNullable(NullVillagerFactory.factory.getProfessionFromName(name));
    }

}

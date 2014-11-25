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

public interface VillagerFactory {

    /**
     * Gets all available {@link Profession}s.
     * 
     * @return An immutable list of all professions
     */
    List<Profession> getProfessions();

    /**
     * Gets the {@link Profession} with the specified name or null if there is
     * no such profession.
     * 
     * @param name The name of the profession to return
     * @return The profession with the given name or null
     */
    Profession getProfessionFromName(String name);

    /**
     * Gets all available {@link Career}s.
     * 
     * @return An immutable list of all careers
     */
    List<Career> getCareers();

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
    List<Career> getCareersFromProfession(Profession profession);

    /**
     * Gets the {@link Career} with the specified name or null if there is no
     * such career.
     * 
     * @param name The name of the career to return
     * @return The career with the given name or null
     */
    Career getCareerFromName(String name);

}

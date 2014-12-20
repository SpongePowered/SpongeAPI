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

/**
 * A utility factory to retrieve available {@link Profession}s and
 * {@link Career}s.
 */
interface VillagerFactory {

    /**
     * Gets the career by name, if available.
     *
     * @param name The name of the career
     * @return The career, if available
     */
    Career getCareerFromName(String name);

    /**
     * Gets the profession by name, if available.
     *
     * @param name The name of the profession
     * @return The profession if available
     */
    Profession getProfessionFromName(String name);

    /**
     * Gets the profession the given {@link Career} is associated with.
     * <p>This can be simplified with {@link Career#getProfession()}</p>
     *
     * @param career The career
     * @return The profession
     */
    Profession getProfessionFromCareer(Career career);

    /**
     * Gets the currently available professions.
     *
     * @return A list of all professions
     */
    List<Profession> getProfessions();

    /**
     * Gets the currently available careers.
     *
     * @return A list of all careers
     */
    List<Career> getCareers();

    /**
     * Gets all available careers for the given {@link Profession}.
     *
     * @param profession The profession in question
     * @return A list of careers
     */
    List<Career> getCareersFromProfession(Profession profession);
}

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
package org.spongepowered.api.service.command.sponge;

import com.google.common.base.Optional;

import java.util.Map;

/**
 * Represents the result of a command in Sponge.
 */
public interface CommandResult {

    /**
     * Gets if the command was processed.
     * 
     * @return If the command was processed
     */
    boolean wasProcessed();

    /**
     * Gets the success count of the command, if one exists.
     * 
     * @return The success count of the command
     */
    Optional<Integer> getSuccessCount();

    /**
     * Gets the number of blocks affected by the command, if such a count
     * exists.
     * 
     * @return The number of blocks affected by the command, if such a count
     *         exists
     */
    Optional<Integer> getAffectedBlocks();

    /**
     * Gets the number of entities affected by the command, if such a count
     * exists.
     * 
     * @return The number of entities affected by the command, if such a count
     *         exists
     */
    Optional<Integer> getAffectedEntities();

    /**
     * Gets the number of items affected by the command, if such a count exists.
     * 
     * @return The number of items affected by the command, if such a count
     *         exists
     */
    Optional<Integer> getAffectedItems();

    /**
     * Gets the query result of the command, if one exists.
     * 
     * @return The query result of the command, if one exists
     */
    Optional<Integer> getQueryResult();

    /**
     * Gets a Map used by the command to store information about what it did.
     * 
     * @return A Map used by the command to store information about what it did.
     */
    Map<String, Object> getResultInfo();

}

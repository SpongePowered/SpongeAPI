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
package org.spongepowered.api.command.managed;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Defines the behavior when a child command throws a {@link CommandException}.
 */
@CatalogedBy(ChildExceptionBehaviors.class)
public interface ChildExceptionBehavior extends CatalogType {

    /**
     * Handles an exception from a child command.
     *
     * <p>An implementation can do one of the following:</p>
     * <ul>
     *     <li>Return {@code null} to discard the exception</li>
     *     <li>Return the exception to inform the parent of the exception to
     *     store it</li>
     *     <li>(Re-)throw an exception to immediately terminate execution of
     *     the current command</li>
     * </ul>
     *
     * @param exception The exception to handle
     * @return The {@link CommandException}, should it be stored
     * @throws CommandException thrown if command execution should terminate
     */
    @Nullable
    CommandException onChildCommandError(CommandException exception) throws CommandException;

}

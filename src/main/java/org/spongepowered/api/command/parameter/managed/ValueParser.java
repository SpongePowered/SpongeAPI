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
package org.spongepowered.api.command.parameter.managed;

import org.spongepowered.api.command.CommandExecutor;
import org.spongepowered.api.command.exception.ArgumentParseException;
import org.spongepowered.api.command.parameter.ArgumentReader;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.event.cause.Cause;

import java.util.Optional;

/**
 * Defines how a parameter should be parsed.
 */
@FunctionalInterface
public interface ValueParser<T> {

    /**
     * Gets the value for the parameter. This may return more than one value
     * by adding additional values to the supplied
     * {@link CommandContext.Builder}.
     *
     * <p>This should have no side effects on anything except on the state of
     * the {@link ArgumentReader} and, in rare cases, the
     * {@link CommandContext.Builder}.</p>
     *
     * <p>This element may return nothing in the form of an empty optional.
     * This indicates that a parse succeeded, but no meaningful value was
     * returned, for example, the argument must be passed but it's not
     * necessary for the associated {@link CommandExecutor} to know what
     * the result of the parse was. The {@link CommandContext.Builder}
     * may be updated in this case.</p>
     *
     * <p>While the {@link CommandContext.Builder} is provided, in general,
     * you do not need to add the parsed value to it yourself, instead
     * preferring to return your parsed value. It is permissible, however,
     * to add additional information to the context should it be required.</p>
     *
     * <p>The {@link Cause} of this parse is provided in the
     * {@link CommandContext.Builder}.</p>
     *
     * @param parameterKey The {@link Parameter.Key} of the parameter being parsed
     * @param reader The {@link ArgumentReader} that contains the unparsed arguments
     * @param context The {@link CommandContext} containing the state about this command
     * @return Returns the value(s)
     * @throws ArgumentParseException if a parameter could not be parsed
     */
    Optional<? extends T> getValue(
            Parameter.Key<? super T> parameterKey,
            ArgumentReader.Mutable reader,
            CommandContext.Builder context) throws ArgumentParseException;

}

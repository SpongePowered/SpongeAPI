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

import org.spongepowered.api.command.parameter.ArgumentParseException;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.text.Text;

import java.util.Optional;
import java.util.function.Function;

/**
 * Parses a selector
 */
@FunctionalInterface
public interface SelectorParser {

    /**
     * Attempts to parse a selector, which is defined as a string starting with
     * the character "@".
     *
     * <p>If a value is returned, then the associated {@link ValueParser} will
     * not be executed, and the result will be added to the
     * {@link CommandContext} like normal. If there is an error in parsing a
     * selector, the implementation is strongly advised to throw an
     * {@link ArgumentParseException}, as returning {@link Optional#empty()}
     * will cause the associated {@link ValueParser} to attempt to parse the
     * selector.</p>
     *
     * @param cause The {@link Cause}
     * @param selector The selector, which will include the "@" symbol
     * @param context The {@link CommandContext}
     * @param errorFunction A {@link Function} that produces an
     *      {@link ArgumentParseException} from an error message
     *
     * @return An {@link Optional} returning the result, or
     *      {@link Optional#empty()} if a selector should not be parsed.
     * @throws ArgumentParseException if the selector could not be parsed
     */
    Optional<?> parseSelector(Cause cause, String selector, CommandContext context, Function<Text, ArgumentParseException> errorFunction)
            throws ArgumentParseException;
}

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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.CommandCompletion;
import org.spongepowered.api.command.exception.ArgumentParseException;
import org.spongepowered.api.command.parameter.ArgumentReader;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.registry.DefaultedRegistryValue;

import java.util.List;
import java.util.Optional;

/**
 * Combines the {@link ValueParser}, {@link ValueCompleter} and
 * {@link ValueUsage} into one object.
 *
 * @param <T> The type of object that is returned from the
 *            {@link ValueParser} upon successful parsing.
 *
 * @see org.spongepowered.api.command.parameter.managed.ValueCompleter
 * @see org.spongepowered.api.command.parameter.managed.ValueParser
 * @see org.spongepowered.api.command.parameter.managed.ValueUsage
 */
public interface ValueParameter<T> extends DefaultedRegistryValue, ValueCompleter, ValueParser<T>, ValueUsage {

    @Override
    default String usage(@NonNull final String key) {
        return key;
    }

    /**
     * A {@link ValueParameter} that does not rely on the {@link CommandContext}
     * or {@link Parameter.Key} to parse its results.
     *
     * @param <T> The type of object that is returned from the
     *            {@link ValueParser} upon successful parsing.
     */
    interface Simple<T> extends ValueParameter<T> {

        /**
         * Gets the value for this parameter.
         *
         * <p>This should have no side effects on anything except on the state of
         * the {@link ArgumentReader}.</p>
         *
         * <p>This element may return nothing in the form of an empty optional.
         * This indicates that a parse succeeded, but no meaningful value was
         * returned.</p>
         *
         * @param commandCause The {@link CommandCause cause} of this parse
         * @param reader The {@link ArgumentReader} that contains the unparsed
         *          arguments
         * @return Returns the value(s)
         * @throws ArgumentParseException if a parameter could not be parsed
         */
        Optional<? extends T> parseValue(CommandCause commandCause, ArgumentReader.Mutable reader) throws ArgumentParseException;

        /**
         * This should not be overridden by implementations of this class. If
         * you wish to do so, implement {@link ValueParameter} instead.
         *
         * {@inheritDoc}
         */
        @Override
        default Optional<? extends T> parseValue(
                final Parameter.Key<? super T> parameterKey,
                final ArgumentReader.Mutable reader,
                final CommandContext.Builder context) throws ArgumentParseException {
            return this.parseValue(context.cause(), reader);
        }

        /**
         * Gets valid completions for this element, given the supplied
         * {@link CommandCause} and current input for this element.
         *
         * @param context The {@link CommandCause} that contains the parsed
         *  arguments
         * @param currentInput The current input for this argument
         * @return The list of values
         */
        List<CommandCompletion> complete(CommandCause context, String currentInput);

        /**
         * This should not be overridden by implementations of this class. If
         * you wish to do so, implement {@link ValueParameter} instead.
         *
         * {@inheritDoc}
         */
        @Override
        default List<CommandCompletion> complete(final CommandContext context, final String currentInput) {
            return this.complete(context.cause(), currentInput);
        }

    }

}

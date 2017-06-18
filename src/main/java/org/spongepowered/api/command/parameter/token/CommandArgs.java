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
package org.spongepowered.api.command.parameter.token;

import org.spongepowered.api.command.parameter.ArgumentParseException;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.Optional;

/**
 * Holds the tokenized arguments from a command, ready to be consumed and
 * parsed.
 */
public interface CommandArgs {

    /**
     * Returns whether there is another argument to parse.
     *
     * <p>If this is true, the next call to {@link #next()} will return an
     * argument, else it will throw an exception.</p>
     *
     * @return Whether there is another argument to parse.
     */
    boolean hasNext();

    /**
     * Returns the next argument to parse, and advances the iterator.
     *
     * <p>Calling this method and {@link #previous()} in succession will
     * return the same string.</p>
     *
     * @return The next argument
     * @throws ArgumentParseException thrown if there isn't another argument
     *     to parse.
     */
    String next() throws ArgumentParseException;

    /**
     * Returns the next argument to parse if there is another argument to
     * return, and advances the iterator.
     *
     * @return The next argument, or an empty {@link Optional} if there isn't
     *     another argument.
     */
    Optional<String> nextIfPresent();

    /**
     * Returns the next argument to parse, but does not advance the iterator.
     *
     * <p>Developers should only use this method when trying to obtain
     * completions.</p>
     *
     * @return The next argument, if it exists
     * @throws ArgumentParseException thrown if there isn't another argument
     *     to parse.
     */
    String peek() throws ArgumentParseException;

    /**
     * Returns whether there is an argument prior to the current location of
     * the iterator.
     *
     * <p>This will be the case if {@link #next()} has been called more often
     * than {@link #previous()}</p>
     *
     * <p>If this is true, the next call to {@link #previous()} ()} will return an
     * argument, else it will throw an exception.</p>
     *
     * @return Whether there is another argument to parse.
     */
    boolean hasPrevious();

    /**
     * Gets the previous argument, if the iterator has advanced.
     *
     * <p>Calling this method and {@link #next()} in succession will
     * return the same string.</p>
     *
     * @return The previous argument, if there is one.
     * @throws ArgumentParseException thrown if there isn't another argument
     *     to parse.
     */
    String previous() throws ArgumentParseException;

    /**
     * Gets all the arguments.
     *
     * @return The arguments.
     */
    List<String> getAll();

    /**
     * Gets the current raw position of the iterator. This usually is the
     * position of the start position of the argument that would be obtained
     * via {@link #peek()}. If there are no more arguments to parse, the
     * length of the raw string before.
     *
     * @return The current raw position.
     */
    int getCurrentRawPosition();

    /**
     * Gets the raw string that has been tokenized.
     *
     * @return The string.
     */
    String getRaw();

    /**
     * Creates a snapshot of this context and returns a state object that can
     * be used to restore the argument state to this state.
     *
     * @return The state.
     */
    State getState();

    /**
     * Uses a previous snapshot of the argument and restores it to that state.
     *
     * @param state The state obtained from {@link #getState()}
     */
    void setState(State state);

    /**
     * Creates a {@link ArgumentParseException} based on the current state of
     * this object.
     *
     * @param message The message to display
     * @return The exception
     */
    ArgumentParseException createError(Text message);

    /**
     * Creates a {@link ArgumentParseException} based on the current state of
     * this object.
     *
     * @param message The message to display
     * @param inner The {@link Throwable} that caused the error
     * @return The exception
     */
    ArgumentParseException createError(Text message, Throwable inner);

    /**
     * Gets the raw string containing the arguments yet to be parsed. This will
     * be empty if there is nothing left to parse.
     *
     * @return A string containing the arguments.
     */
    String rawArgsFromCurrentPosition();

    /**
     * An immutable snapshot of a {@link CommandArgs}.
     *
     * <p>No assumptions should be made about the form of this state object,
     * it is not defined in the API and may change at any time.</p>
     */
    interface State {}

}

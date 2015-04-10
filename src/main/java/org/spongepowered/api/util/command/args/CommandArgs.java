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
package org.spongepowered.api.util.command.args;

import static org.spongepowered.api.text.Texts.of;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.command.args.parsing.SingleArg;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Holder for command arguments.
 */
public final class CommandArgs {
    private final String rawInput;
    private List<SingleArg> args;
    private int index = -1;

    /**
     * Create a new CommandArgs instance with the given raw input and arguments.
     *
     * @param rawInput Raw input
     * @param args Arguments extracted from the raw input
     */
    public CommandArgs(String rawInput, List<SingleArg> args) {
        this.rawInput = rawInput;
        this.args = new ArrayList<SingleArg>(args);
    }

    /**
     * Return whether more arguments remain to be read.
     *
     * @return Whether more arguments remain
     */
    public boolean hasNext() {
        return this.index + 1 < this.args.size();
    }

    /**
     * Try to read the next argument without advancing the current index.
     *
     * @return The next argument
     * @throws ArgumentParseException if not enough arguments are present
     */
    public String peek() throws ArgumentParseException {
        if (!hasNext()) {
            throw createError(of("Not enough arguments"));
        }
        return this.args.get(this.index + 1).getValue();
    }

    /**
     * Try to read the next argument, advancing the current index if successful.
     *
     * @return The next argument
     * @throws ArgumentParseException if not enough arguments are present
     */
    public String next() throws ArgumentParseException {
        if (!hasNext()) {
            throw createError(of("Not enough arguments!"));
        }
        return this.args.get(++this.index).getValue();
    }

    /**
     * Try to read the next argument, advancing the current index if successful or returning an absent optional if not.
     *
     * @return The optional next argument.
     */
    public Optional<String> nextIfPresent() {
        return hasNext() ? Optional.of(this.args.get(++this.index).getValue()) : Optional.<String>absent();
    }

    /**
     * Create a parse exception with the provided message which has the position of the last parsed argument attached.
     * The returned exception must be thrown at the target
     *
     * @param message The message for the exception
     * @return the newly created, but unthrown exception
     */
    public ArgumentParseException createError(Text message) {
        return new ArgumentParseException(message, this.rawInput, this.index < 0 ? 0 : this.args.get(this.index).getStartIdx());
    }

    /**
     * Get a list of all arguments as a string. The returned list is immutable.
     *
     * @return all arguments
     */
    public List<String> getAll() {
        return ImmutableList.copyOf(Lists.transform(this.args, new Function<SingleArg, String>() {
            @Nullable
            @Override
            public String apply(SingleArg input) {
                return input.getValue();
            }
        }));
    }

    List<SingleArg> getArgs() {
        return this.args;
    }

    /**
     * Return this arguments object's current state. Can be used to reset with the {@link #setState(Object)} method.
     *
     * @return The current state
     */
    public Object getState() {
        return this.index;
    }

    /**
     * Restore the arguments object's state to a state previously used.
     *
     * @param state the previous state
     */
    public void setState(Object state) {
        if (!(state instanceof Integer)) {
            throw new IllegalArgumentException("Provided state was not of appropriate format returned by getState!");
        }
        this.index = (Integer) state;
    }

    /**
     * Return the raw string used to provide input to this arguments object.
     *
     * @return The raw input
     */
    public String getRaw() {
        return this.rawInput;
    }

    /**
     * Insert an arg as the next arg to be returned by {@link #next()}.
     *
     * @param value The argument to insert
     */
    public void insertArg(String value) {
        int index = this.index < 0 ? 0 : this.args.get(this.index).getEndIdx();
        this.args.add(index, new SingleArg(value, index, index));
    }

    /**
     * Remove the arguments parsed between startState and endState.
     *
     * @param startState The starting state
     * @param endState The ending state
     */
    public void removeArgs(Object startState, Object endState) {
        if (!(startState instanceof Integer) || !(endState instanceof Integer)) {
            throw new IllegalArgumentException("One of the states provided was not of the correct type!");
        }
        int startIdx = (Integer) startState;
        int endIdx = (Integer) endState;
        if (this.index >= startIdx) {
            if (this.index < endIdx) {
                this.index = startIdx - 1;
            } else {
                this.index -= (endIdx - startIdx) + 1;
            }
        }
        for (int i = startIdx; i <= endIdx; ++i) {
            this.args.remove(startIdx);
        }
    }

    /**
     * Go back to the previous argument.
     */
    void previous() {
        if (this.index > -1) {
            --this.index;
        }
    }

    /**
     * Get the current position in raw input.
     *
     * @return the raw position
     */
    public int getRawPosition() {
        return this.index < 0 ? 0 : this.args.get(this.index).getStartIdx();
    }

}

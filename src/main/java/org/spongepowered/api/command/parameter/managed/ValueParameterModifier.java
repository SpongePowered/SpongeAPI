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

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.parameter.ArgumentParseException;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.managed.standard.CatalogedValueParameterModifiers;
import org.spongepowered.api.command.parameter.token.CommandArgs;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.text.Text;

import java.util.List;

/**
 * A {@link ValueParameterModifier}, as the name suggests, is intended to allow
 * for the outcome of {@link ValueParameter}s to be modified.
 */
@FunctionalInterface
public interface ValueParameterModifier {

    /**
     * Called when an element is parsed, allowing for the outcome to be
     * modified in some way.
     *
     * <p>When an argument is being parsed, this method on modifiers are called,
     * in the defined order. Upon being called, the parameter's
     * {@link ValueParameter} is yet to be called, that is, the value has not
     * been extracted and it is generally expected that the iterator in
     * {@link CommandArgs} has not been advanced.</p>
     *
     * <p>During the call, modifiers should do one of three things:</p>
     *
     * <ul>
     *     <li>Call {@link ParsingContext#next()} on the parsingContext</li>
     *     <li>{@code return}</li>
     *     <li>{@code throw args.createError(...)}</li>
     * </ul>
     *
     * <p>Calling {@link ParsingContext#next()} calls the next modifier in the
     * chain, or, if there are no modifiers, the {@link ValueParameter}. Upon
     * return, if no other modifier blocked the call, the parsed value should
     * be available in the {@link CommandContext} under the provided
     * {@link Text} key. Modifiers can then process this result, should it be
     * required.</p>
     *
     * <p>Simply {@code return}ing from the method does not inherently raise an
     * error, and allows the command to continue executing.</p>
     *
     * <p>Throwing a {@link ArgumentParseException} indicates that command
     * processing should not continue, though earlier modifiers can swallow
     * the exception, which is what
     * {@link CatalogedValueParameterModifiers#OPTIONAL_WEAK} does.</p>
     *
     * @param key The parameter key where the parsed value will be stored
     * @param cause The {@link Cause} of the command
     * @param args The arguments that need to be parsed
     * @param context The current context of the command, where parsed arguments
     *                will be stored
     * @param parsingContext The current context of the parameter, which allows
     *                       this modifier to pass control to the next modifier
     *                       or the value parser
     * @throws ArgumentParseException thrown if there is an error parsing the
     *                                 argument
     */
    void onParse(Text key, Cause cause, CommandArgs args, CommandContext context, ParsingContext parsingContext)
            throws ArgumentParseException;

    /**
     * Modifies the tab complete list. Defaults to no modification.
     *
     * <p>Modifiers will be called after the {@link ValueParameter} has
     * provided completions. Modifiers will be called in their specified
     * order.</p>
     *
     * @param cause The {@link Cause} of the command
     * @param args The arguments that need to be parsed
     * @param context The current context of the command, where parsed arguments
     *                will be stored
     * @param currentCompletions The current tab completion list
     * @return The new tab completion list
     * @throws ArgumentParseException thrown if there is an error parsing the
     *                                 argument
     */
    default List<String> complete(Cause cause, CommandArgs args, CommandContext context, List<String> currentCompletions)
            throws ArgumentParseException {
        return currentCompletions;
    }

    /**
     * Modifies the usage string displayed to the calling
     * {@link CommandSource}.
     *
     * <p>Modifiers will be called after the {@link ValueParameter} has
     * provided completions. Modifiers will be called in their specified
     * order.</p>
     *
     * <p>Return {@link Text#EMPTY} to suppress the display.</p>
     *
     * @param key The parameter key where the parsed value will be stored
     * @param cause The {@link Cause} of the command
     * @param currentUsage The usage, as provided by the {@link ValueParameter}
     *                     and earlier modifiers.
     * @return The usage {@link Text}.
     */
    default Text getUsage(Text key, Cause cause, Text currentUsage) {
        return currentUsage;
    }

}

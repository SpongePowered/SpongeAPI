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

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.command.CommandCompletion;
import org.spongepowered.api.command.CommandExecutor;
import org.spongepowered.api.command.exception.ArgumentParseException;
import org.spongepowered.api.command.parameter.ArgumentReader;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;

import java.util.List;
import java.util.Optional;

/**
 * A value parameter modifier is an alternative to attempting to create an
 * element that extends/wraps around a {@link ValueParameter}, particularly
 * those that are provided by Sponge on behalf of Minecraft or other
 * underlying implementation.
 *
 * <p>The primary intention of a modifier is to enable custom filtering logic
 * on in-built parameters so that plugins can refine the user experience when
 * using their commands while retaining most of the properties of the underlying
 * parameter. In general, plugins <strong>should not</strong> use modifiers on
 * their own {@link ValueParameter value parameters} or associated classes.
 * Further, modifiers are <strong>not</strong> designed to perform any
 * post-processing on any parsed elements, they should generally only be used to
 * validate or filter results and completions - post-processing should be
 * performed in the {@link CommandExecutor command's exectuor} instead, as by
 * this point you know that your command has been selected.</p>
 *
 * <p>These modifier methods are provided the same information as the original
 * parameter, along with the result of the original parameter - that is, these
 * modifiers run <strong>after</strong> the associated parameter has run. The
 * main takeaway here is that modifiers <strong>cannot</strong> add new entries
 * to the parameter, only modify what they return and filter out entries that
 * are not supported by your operation.</p>
 *
 * <p><strong>Modifiers are not designed to transform the returned type</strong>
 * - this is to maintain the integrity of the key typing and to discourage
 * additional logic in parameter parsing that should actually exist in the
 * {@link CommandExecutor} of the command instead.</p>
 *
 * <p>Users of modifiers should consider the following when modifying the
 * result:</p>
 *
 * <ul>
 *     <li>Any supplied parameters may have been modified by the associated
 *     parameter that this is modifying, and are not snapshots from before.</li>
 *     <li>The {@link ArgumentReader} is <strong>immutable</strong>. This is to
 *     prevent accidental continued parsing. If you want to use a modifier to
 *     further parse the input string based on the result of chained parameter,
 *     create a custom {@link ValueParameter} that follows on from the node in
 *     question instead - the result of this parse will be available in the
 *     {@link CommandContext.Builder} in later nodes.</li>
 *     <li>Modifiers may choose to <strong>not</strong> return a value and
 *     instead add to the {@link CommandContext.Builder} directly. While this is
 *     permissible, do not be tempted to use modifiers as a way to perform logic
 *     this is not directly related to parsing a string to avoid unnecessary
 *     processing that may not be used if a later node fails to parse and this
 *     node's result is discarded.</li>
 *     <li>Modifiers cannot prevent the chained parameter from throwing an
 *     exception, in the case that they do so this modifier will not be called.
 *     Instead, add a second {@link ValueParser} to the parameter, and account
 *     for this in your modifier.</li>
 *     <li>The use of a modifier will require that any completion requests are
 *     sent to the server, regardless of whether completions are actually
 *     modified. If completions are not being modified, consider whether it
 *     would be better to process the parsed result in the body of your executor
 *     instead.</li>
 * </ul>
 *
 * <p>With all this in mind, modifiers should be used sparingly, preferring the
 * use of other constructs when at all possible.</p>
 */
public interface ValueParameterModifier<T> {

    /**
     * Modifies the result of {@link ValueParser#parseValue(Parameter.Key,
     * ArgumentReader.Mutable, CommandContext.Builder) the chained parameter's
     * parse result}.
     *
     * @param parameterKey The target {@link Parameter.Key} to fill in the
     *                     context
     * @param reader The {@link ArgumentReader.Immutable} that may have been
     *               advanced by the parser
     * @param context The {@link CommandContext.Builder} that may have been
     *                modified by the parser
     * @param value The value returned by the parser, if any
     * @return The value to associate with the {@code parameterKey}
     * @throws ArgumentParseException if the modifier wishes to halt processing
     *      of this element
     */
    Optional<? extends T> modifyResult(
            Parameter.Key<? super T> parameterKey,
            ArgumentReader.Immutable reader,
            CommandContext.Builder context,
            @Nullable T value) throws ArgumentParseException;

    /**
     * Modifies the result of {@link ValueCompleter#complete(CommandContext,
     * String) the chained parameter's completions}.
     *
     * @param context The {@link CommandContext}
     * @param currentInput The input that suggestions are built from
     * @param completions The completions suggested by the chained parameter
     * @return The modified completions
     */
    default List<CommandCompletion> modifyCompletion(
            final CommandContext context, final String currentInput, final  List<CommandCompletion> completions) {
        return completions;
    }

    /**
     * Modifies the message provided in a {@link ArgumentParseException} if the
     * modified {@link ValueParser} throws this exception.
     *
     * @param exceptionMessage The message provided by the {@link ValueParser}
     * @return The modified message, or the parameter if it is not to be modified.
     */
    default @Nullable Component modifyExceptionMessage(final @Nullable Component exceptionMessage) {
        return exceptionMessage;
    }

}

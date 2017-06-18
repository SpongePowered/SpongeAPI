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
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.text.Text;

import java.util.Optional;
import java.util.function.Function;

public interface ValueParameter extends ValueCompleter, ValueParser, ValueUsage, SelectorParser {

    @Override
    default Text getUsage(Text key, Cause cause) {
        return key;
    }

    @Override
    default Optional<?> parseSelector(Cause cause, String selector, CommandContext context, Function<Text, ArgumentParseException> errorFunction)
            throws ArgumentParseException {
        return Optional.empty();
    }

    /**
     * Gets this {@link ValueParameter} as a {@link Parameter}.
     *
     * @param key The key for the parameter.
     * @param modifiers The {@link ValueParameterModifier}s to link with this parameter
     * @return The {@link Parameter}
     */
    default Parameter asParameter(String key, ValueParameterModifier... modifiers) {
        return Parameter.builder().setKey(key).setParser(this).modifiers(modifiers).build();
    }

    /**
     * Gets this {@link ValueParameter} as a {@link Parameter}.
     *
     * @param key The key for the parameter.
     * @param modifiers The {@link ValueParameterModifier}s to link with this parameter
     * @return The {@link Parameter}
     */
    default Parameter asParameter(Text key, ValueParameterModifier... modifiers) {
        return Parameter.builder().setKey(key).setParser(this).modifiers(modifiers).build();
    }

}

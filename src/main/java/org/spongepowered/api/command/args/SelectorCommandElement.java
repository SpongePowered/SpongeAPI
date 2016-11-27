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
package org.spongepowered.api.command.args;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.selector.Selector;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * Abstract command element that matches values based on a {@link Selector}.
 */
public abstract class SelectorCommandElement<T extends Entity> extends PatternMatchingCommandElement<T> {
    private final Class<T> type;

    protected SelectorCommandElement(Text key, Class<T> type) {
        super(key);
        this.type = type;
    }

    @Override
    protected Collection<? extends T> parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        String arg = args.peek();
        if (arg.startsWith("@")) { // Posibly a selector
            try {
                return (Set) Selector.parse(args.next()).resolve(source);
            } catch (IllegalArgumentException ex) {
                throw args.createError(Text.of(ex.getMessage()));
            }
        } else {
            return super.parseValue(source, args);
        }
    }

    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        Object state = args.getState();
        final Optional<String> nextArg = args.nextIfPresent();
        args.setState(state);
        List<String> choices = nextArg.isPresent() ? Selector.complete(nextArg.get()) : ImmutableList.of();

        if (choices.isEmpty()) {
            choices = super.complete(src, args, context);
        }
        return choices;
    }
}

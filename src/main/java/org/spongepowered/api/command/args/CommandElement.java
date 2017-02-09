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

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TranslatableText;

import java.util.List;

import javax.annotation.Nullable;

/**
 * Represents a command argument element.
 */
public abstract class CommandElement {
    @Nullable
    private final Text key;

    protected CommandElement(@Nullable Text key) {
        this.key = key;
    }

    /**
     * Return the key to be used for this object.
     *
     * @return the user-facing representation of the key
     */
    @Nullable
    public Text getKey() {
        return this.key;
    }

    /**
     * Return the plain key, to be used when looking up this command element in
     * a {@link CommandContext}. If the key is a {@link TranslatableText}, this
     * is the translation's id. Otherwise, this is the result of
     * {@link Text#toPlain()}.
     *
     * @return the raw key
     */
    @Nullable
    public String getUntranslatedKey() {
        return ArgUtils.textToArgKey(this.key);
    }

    /**
     * Attempt to extract a value for this element from the given arguments and
     * put it in the given context. This method normally delegates to
     * {@link #parseValue(CommandSource, CommandArgs)} for getting the values.
     * This method is expected to have no side-effects for the source, meaning
     * that executing it will not change the state of the {@link CommandSource}
     * in any way.
     *
     * @param source The source to parse for
     * @param args The args to extract from
     * @param context The context to supply to
     * @throws ArgumentParseException if unable to extract a value
     */
    public void parse(CommandSource source, CommandArgs args, CommandContext context) throws ArgumentParseException {
        Object val = parseValue(source, args);
        String key = getUntranslatedKey();
        if (key != null && val != null) {
            if (val instanceof Iterable<?>) {
                for (Object ent : ((Iterable<?>) val)) {
                    context.putArg(key, ent);
                }
            } else {
                context.putArg(key, val);
            }
        }
    }

    /**
     * Attempt to extract a value for this element from the given arguments.
     * This method is expected to have no side-effects for the source, meaning
     * that executing it will not change the state of the {@link CommandSource}
     * in any way.
     *
     * @param source The source to parse for
     * @param args the arguments
     * @return The extracted value
     * @throws ArgumentParseException if unable to extract a value
     */
    @Nullable
    protected abstract Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException;

    /**
     * Fetch completions for command arguments.
     *
     * @param src The source requesting tab completions
     * @param args The arguments currently provided
     * @param context The context to store state in
     * @return Any relevant completions
     */
    public abstract List<String> complete(CommandSource src, CommandArgs args, CommandContext context);

    /**
     * Return a usage message for this specific argument.
     *
     * @param src The source requesting usage
     * @return The formatted usage
     */
    public Text getUsage(CommandSource src) {
        return getKey() == null ? Text.of() : Text.of("<", getKey(), ">");
    }
}

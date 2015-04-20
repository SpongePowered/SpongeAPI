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

import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.command.CommandSource;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

/**
 * Abstract command element that matches values based on pattern.
 */
public abstract class PatternMatchingCommandElement extends CommandElement {

    protected PatternMatchingCommandElement(@Nullable Text key) {
        super(key);
    }

    @Nullable
    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        final String unformattedPattern = args.next();
        Pattern pattern = getFormattedPattern(unformattedPattern);
        Iterable<Object> ret = Iterables.transform(Iterables.filter(getChoices(source), Predicates.contains(pattern)),
                new Function<String, Object>() {
                    @Nullable
                    @Override
                    public Object apply(@Nullable String input) {
                        return input == null ? null : getValue(input);
                    }
                });
        if (!ret.iterator().hasNext()) {
            throw args.createError(t("No values matching pattern '%s' present for %s!", unformattedPattern, getKey()));
        }
        return ret;
    }

    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        Iterable<String> choices = getChoices(src);
        final Optional<String> nextArg = args.nextIfPresent();
        if (nextArg.isPresent()) {
            choices = Iterables.filter(choices, Predicates.contains(getFormattedPattern(nextArg.get())));
        }
        return ImmutableList.copyOf(choices);
    }

    private Pattern getFormattedPattern(String input) {
        if (!input.startsWith("^")) { // Anchor matches to the beginning -- this lets us use find()
            input = "^" + input;
        }
        return Pattern.compile(input, Pattern.CASE_INSENSITIVE);

    }

    /**
     * Get the available choices for this command source.
     *
     * @param source The source requesting choices
     * @return the possible choices
     */
    protected abstract Iterable<String> getChoices(CommandSource source);

    /**
     * Get the value for a given choice. For any result in {@link #getChoices(CommandSource)}, this must return a non-null value. Otherwise, an
     * {@link IllegalArgumentException} may be throw.
     *
     * @param choice The specified choice
     * @return the choice's value
     * @throws IllegalArgumentException if the input string is not any return value of {@link #getChoices(CommandSource)}
     */
    protected abstract Object getValue(String choice) throws IllegalArgumentException;
}

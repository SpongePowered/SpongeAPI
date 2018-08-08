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
package org.spongepowered.api.command.args.parsing;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.command.args.ArgumentParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class SpaceSplitInputTokenizer implements InputTokenizer {
    public static final SpaceSplitInputTokenizer INSTANCE = new SpaceSplitInputTokenizer();
    private static final Pattern SPACE_REGEX = Pattern.compile("^[ ]*$");

    private SpaceSplitInputTokenizer() {}

    @Override
    public List<SingleArg> tokenize(String arguments, boolean lenient) throws ArgumentParseException {
        if (SPACE_REGEX.matcher(arguments).matches()) {
            return ImmutableList.of();
        }

        List<SingleArg> ret = new ArrayList<>();
        int lastIndex = 0;
        int spaceIndex;
        while ((spaceIndex = arguments.indexOf(" ")) != -1) {
            if (spaceIndex != 0) {
                ret.add(new SingleArg(arguments.substring(0, spaceIndex), lastIndex, lastIndex + spaceIndex));
                arguments = arguments.substring(spaceIndex);
            } else {
                arguments = arguments.substring(1);
            }
            lastIndex += spaceIndex + 1;
        }

        ret.add(new SingleArg(arguments, lastIndex, lastIndex + arguments.length()));
        return ret;
    }
}

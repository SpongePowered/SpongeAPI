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
import com.google.common.collect.Lists;

import java.util.List;

class SpaceSplitInputTokenizer implements InputTokenizer {
    public static final SpaceSplitInputTokenizer INSTANCE = new SpaceSplitInputTokenizer();

    private SpaceSplitInputTokenizer() {}

    @Override
    public List<SingleArg> tokenize(String arguments, boolean lenient) {
        if (arguments.isEmpty()) {
            return ImmutableList.of();
        }
        List<SingleArg> args = Lists.newArrayList();
        int index = 0;
        for (String arg : arguments.split(" ", -1)) {
            if (!arg.isEmpty() || index == arguments.length()) {
                args.add(new SingleArg(arg, index, index + arg.length()));
            }
            index += arg.length() + 1;
        }
        return args;
    }
}

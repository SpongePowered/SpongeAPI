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
package org.spongepowered.api.util.command.args.parsing;

import org.spongepowered.api.util.command.args.ArgumentParseException;

import java.util.ArrayList;
import java.util.List;

class SpaceSplitInputTokenizer implements InputTokenizer {
    public static final SpaceSplitInputTokenizer INSTANCE = new SpaceSplitInputTokenizer();

    private SpaceSplitInputTokenizer() {}

    @Override
    public List<SingleArg> tokenize(String arguments, boolean lenient) throws ArgumentParseException {
        List<SingleArg> ret = new ArrayList<SingleArg>();
        int lastIndex = 0;
        int spaceIndex;
        while ((spaceIndex = arguments.indexOf(" ")) != -1) {
            ret.add(new SingleArg((arguments = arguments.substring(0, spaceIndex)), lastIndex, lastIndex + spaceIndex));
            lastIndex += spaceIndex + 1;
        }
        return ret;
    }
}

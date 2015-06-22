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
package org.spongepowered.api.util.test;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextFactory;
import org.spongepowered.api.text.TextRepresentation;

import java.util.List;
import java.util.Locale;

/**
 * A {@link TextFactory} providing the most limited implementation necessary for performing unit tests.
 */
public class TestTextFactory implements TextFactory {

    @Override
    public String toPlain(Text text) {
        return toPlain(text, Locale.ROOT);
    }

    @Override
    public String toPlain(Text text, Locale locale) {
        final StringBuilder ret = new StringBuilder();
        for (Text child : text.withChildren()) {
            if (child instanceof Text.Literal) {
                ret.append(((Text.Literal) child).getContent());
            } else if (child instanceof Text.Translatable) {
                ret.append(((Text.Translatable) child).getTranslation().get(locale, convertArgs(((Text.Translatable) child).getArguments(), locale)));
            } else if (child instanceof  Text.Score) {
                ret.append(((Text.Score) child).getScore().getScore());
            } else if (child instanceof Text.Selector) {
                ret.append(((Text.Selector) child).getSelector().toPlain());
            }
        }
        return ret.toString();
    }

    private Object[] convertArgs(List<Object> args, Locale locale) {
        Object[] ret = new Object[args.size()];
        for (int i = 0; i < ret.length; ++i) {
            Object current = args.get(i);
            if (current instanceof Text) {
                current = toPlain(((Text) current), locale);
            }
            ret[i] = current;
        }
        return ret;
    }

    @Override
    public TextRepresentation json() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TextRepresentation xml() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public char getLegacyChar() {
        return '§';
    }

    @Override
    public TextRepresentation legacy(char legacyChar) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String stripLegacyCodes(String text, char code) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String replaceLegacyCodes(String text, char from, char to) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

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
package org.spongepowered.api.text;

import org.spongepowered.api.text.serializer.SafeTextSerializer;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.text.translation.locale.Locales;
import org.spongepowered.api.util.test.TestHooks;

import java.util.List;

public class TestPlainTextSerializer implements SafeTextSerializer {

    public static void inject() throws ReflectiveOperationException {
        TestHooks.setCatalogElement(TextSerializers.class, "PLAIN", new TestPlainTextSerializer());
    }

    @Override
    public String getId() {
        return "sponge:plain";
    }

    @Override
    public String getName() {
        return "Plain Text";
    }

    @Override
    public Text deserialize(String input) {
        return Text.of(input);
    }

    @Override
    public String serialize(Text text) {
        final StringBuilder ret = new StringBuilder();
        for (Text child : text.withChildren()) {
            if (child instanceof LiteralText) {
                ret.append(((LiteralText) child).getContent());
            } else if (child instanceof TranslatableText) {
                ret.append(((TranslatableText) child).getTranslation().get(Locales.DEFAULT, convertArgs(((TranslatableText) child).getArguments())));
            } else if (child instanceof ScoreText) {
                ret.append(((ScoreText) child).getScore().getScore());
            } else if (child instanceof SelectorText) {
                ret.append(((SelectorText) child).getSelector().toPlain());
            }
        }
        return ret.toString();
    }

    private Object[] convertArgs(List<Object> args) {
        Object[] ret = new Object[args.size()];
        for (int i = 0; i < ret.length; ++i) {
            Object current = args.get(i);
            if (current instanceof Text) {
                current = serialize((Text) current);
            }
            ret[i] = current;
        }
        return ret;
    }

}

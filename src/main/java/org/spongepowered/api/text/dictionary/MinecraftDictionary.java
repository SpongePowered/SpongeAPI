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
package org.spongepowered.api.text.dictionary;

import org.spongepowered.api.text.Text;

import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents the vanilla Minecraft dictionary.
 *
 * <p>Plugins should not implement this interface.</p>
 */
public interface MinecraftDictionary extends Dictionary {

    Pattern FORMAT_PATTERN = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");

    static Text format(String string, Object... args) {
        Text.Builder builder = Text.builder();

        Matcher matcher = FORMAT_PATTERN.matcher(string);
        int idx = 0;
        int end = 0;

        try {
            while (matcher.find(end)) {
                int start = matcher.start();
                if (start > end) {
                    builder.append(Text.of(string.substring(end, start)));
                }

                end = matcher.end();

                String symbol = matcher.group(2);
                String format = string.substring(start, end);
                if ("%".equals(symbol) && "%%".equals(format)) {
                    builder.append(Text.of("%"));
                } else if ("s".equals(symbol) || "d".equals(symbol)) {
                    String numberValue = matcher.group(1);
                    int index = numberValue != null ? Integer.parseInt(numberValue) - 1 : idx++;
                    if (index >= args.length) {
                        throw new IllegalArgumentException("Invalid index " + index + " requested");
                    }

                    Object object = args[index];
                    if (object instanceof Text) {
                        builder.append((Text) object);
                    } else {
                        builder.append(Text.of(object == null ? "null" : object.toString()));
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported format: " + format);
                }
            }

            if (end < string.length()) {
                builder.append(Text.of(string.substring(end)));
            }
        } catch (IllegalFormatException e) {
            throw new IllegalArgumentException("Error while parsing", e);
        }

        return builder.build();
    }
}

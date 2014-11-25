/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.text.message;

import org.spongepowered.api.text.translation.Translation;

/**
 * Dummy implementation of {@link MessageFactory} - returns null for all
 * methods.
 */
class NullMessageFactory implements MessageFactory {

    @Override
    public <T> MessageBuilder<T> createBuilder(T content) {
        return null;
    }

    @Override
    public MessageBuilder<Translation> createTranslationBuilder(Translation t, Object[] args) {
        return null;
    }

    @Override
    public MessageBuilder<Object> createScoreBuilder(Object score, String override) {
        return null;
    }

    @Override
    public char getColorChar() {
        return 0;
    }

    @Override
    public Message.Text parseLegacyMessage(String message, char color) {
        return null;
    }

    @Override
    public String stripLegacyCodes(String message, char color) {
        return null;
    }

    @Override
    public String replaceLegacyCodes(String message, char from, char to) {
        return null;
    }

}

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
package org.spongepowered.api.text.template;

import org.spongepowered.api.text.Text;

public abstract class TextArg<T> {

    protected final TextElement<T> element;

    public TextArg(TextElement<T> element) {
        this.element = element;
    }

    public TextElement<T> getElement() {
        return this.element;
    }

    public abstract Text lookup(TextArgs args);

    static final class Named<T> extends TextArg<T> {

        private final String name;

        public Named(String name, TextElement<T> element) {
            super(element);
            this.name = name;
        }

        @Override
        public Text lookup(TextArgs args) {
            @SuppressWarnings("unchecked") T arg = (T) args.getNamedArg(name);
            return element.create(arg);
        }

    }

    static final class Pos<T> extends TextArg<T> {

        private final int position;

        public Pos(int position, TextElement<T> element) {
            super(element);
            this.position = position;
        }

        @Override
        public Text lookup(TextArgs args) {
            @SuppressWarnings("unchecked") T arg = (T) args.getPositionedArg(position);
            return element.create(arg);
        }

    }
}

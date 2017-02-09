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
package org.spongepowered.api.text.transform;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.text.TextElement;
import org.spongepowered.api.text.TextTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * A basic implementation of {@link TextTemplateApplier} backed by a {@link HashMap} and
 * an empty {@link TextTemplate} by default.
 */
public class SimpleTextTemplateApplier implements TextTemplateApplier {

    protected final Map<String, TextElement> params = new HashMap<>();
    protected TextTemplate template;

    /**
     * Creates a new {@link SimpleTextTemplateApplier} with the provided
     * {@link TextTemplate}.
     *
     * @param template The template to use
     */
    public SimpleTextTemplateApplier(TextTemplate template) {
        this.template = checkNotNull(template, "template");
    }

    /**
     * Creates a new {@link SimpleTextTemplateApplier} with an empty
     * {@link TextTemplate}.
     */
    public SimpleTextTemplateApplier() {
        this(TextTemplate.EMPTY);
    }

    @Override
    public ImmutableMap<String, TextElement> getParameters() {
        return ImmutableMap.copyOf(this.params);
    }

    @Override
    public void setParameter(String key, TextElement value) {
        checkNotNull(key, "key");
        this.params.put(key, value);
    }

    @Override
    public TextTemplate getTemplate() {
        return this.template;
    }

    @Override
    public void setTemplate(TextTemplate template) {
        this.template = checkNotNull(template, "template");
    }

}

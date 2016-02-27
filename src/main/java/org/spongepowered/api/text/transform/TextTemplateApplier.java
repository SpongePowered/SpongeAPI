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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextElement;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.TextTemplate;

import javax.annotation.Nullable;

/**
 * Wrapper class to hold {@link TextTemplate} parameters and a TextTemplate.
 */
public interface TextTemplateApplier extends TextRepresentable {

    /**
     * Returns an {@link ImmutableList} of this applier's parameters.
     *
     * @return Applier parameters
     */
    ImmutableMap<String, TextElement> getParameters();

    /**
     * Returns the current value of the parameter with the specified key.
     *
     * @param key Parameter key
     * @return Parameter value
     */
    default TextElement getParameter(String key) {
        return getParameters().get(key);
    }

    /**
     * Sets the value of the specified parameter key within this applier.
     *
     * @param key Parameter key
     * @param value Parameter value
     */
    void setParameter(String key, @Nullable TextElement value);

    /**
     * Returns the current {@link TextTemplate} for this applier.
     *
     * @return TextTemplate
     */
    TextTemplate getTemplate();

    /**
     * Sets the {@link TextTemplate} to use for this applier.
     *
     * @param template TextTemplate to use
     */
    void setTemplate(TextTemplate template);

    @Override
    default Text toText() {
        return getTemplate().apply(getParameters()).build();
    }

}

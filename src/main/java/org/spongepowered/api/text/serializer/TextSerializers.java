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
package org.spongepowered.api.text.serializer;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * The list of {@link TextSerializer} available together with SpongeAPI.
 */
public final class TextSerializers {

    private TextSerializers() {
    }

    /**
     * The {@link TextSerializer} for plain text input, without support for
     * formatting or special text types.
     */
    public static final SafeTextSerializer PLAIN = DummyObjectProvider.createFor(SafeTextSerializer.class, "PLAIN");

    /**
     * The {@link FormattingCodeTextSerializer} using the internal formatting
     * char.
     *
     * <p><b>Note:</b> This serializer is ONLY available for compatibility
     * reasons. Using texts with legacy formatting codes as-is, without using
     * this {@link FormattingCodeTextSerializer} is broken in many ways and
     * should not be used anymore unless really necessary. It is recommended to
     * use a different text serializer such as {@link #FORMATTING_CODE}
     * instead.</p>
     *
     * @see FormattingCodeTextSerializer
     * @deprecated Legacy formatting codes are being phased out of Minecraft
     */
    @Deprecated
    public static final FormattingCodeTextSerializer LEGACY_FORMATTING_CODE = DummyObjectProvider
            .createFor(FormattingCodeTextSerializer.class, "LEGACY_FORMATTING_CODE");

    /**
     * A {@link FormattingCodeTextSerializer} for a simple {@link Text}
     * representation similar to {@link #LEGACY_FORMATTING_CODE} but using the
     * formatting character {@code &} instead of the internal one.
     *
     * <p>Example of a string parsed by this {@link TextSerializer}
     * {@code &cHello &eSponge!}, would refer to a red and yellow formatted
     * text.</p>
     *
     * <p><b>Note:</b> Unlike the {@link #LEGACY_FORMATTING_CODE}
     * {@link TextSerializer} this is safe to use as simple {@link Text} format
     * for plugins as long as you keep in mind that it does not support
     * additional {@link Text} features such as {@link ClickAction}s or
     * {@link HoverAction}s.</p>
     *
     * @see FormattingCodeTextSerializer
     */
    public static final FormattingCodeTextSerializer FORMATTING_CODE = DummyObjectProvider
            .createFor(FormattingCodeTextSerializer.class, "FORMATTING_CODE");

    /**
     * The {@link TextSerializer} for Mojang's JSON (<i>Mojangson</i>)
     * representation of a {@link Text} object.
     */
    public static final TextSerializer JSON = DummyObjectProvider.createFor(TextSerializer.class, "JSON");

    /**
     * The {@link TextSerializer} for Sponge's TextXML format.
     *
     * @deprecated Will be moved out of SpongeAPI in revision 7.0. See
     *     <a href="https://github.com/SpongePowered/SpongeAPI/issues/1511">
     *         SpongePowered/SpongeAPI#1511</a>
     */
    @Deprecated
    public static final TextSerializer TEXT_XML = DummyObjectProvider.createFor(TextSerializer.class, "TEXT_XML");

    /**
     * Returns a representation that accepts and outputs formatting codes, using
     * the provided formatting character.
     *
     * @param formattingChar The formatting character to parse and serialize
     *        with
     * @return The appropriate legacy representation handler
     */
    @SuppressWarnings("deprecation")
    public static FormattingCodeTextSerializer formattingCode(char formattingChar) {
        if (formattingChar == LEGACY_FORMATTING_CODE.getCharacter()) {
            return LEGACY_FORMATTING_CODE;
        } else if (formattingChar == FORMATTING_CODE.getCharacter()) {
            return FORMATTING_CODE;
        } else {
            return Sponge.getRegistry().getTextSerializerFactory().getFormattingCodeTextSerializer(formattingChar);
        }
    }

}

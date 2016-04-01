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

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;

/**
 * An implementation of {@link TypeSerializer} to allow serialization of
 * {@link TextFormat}s directly to a configuration file.
 */
public class TextFormatConfigSerializer implements TypeSerializer<TextFormat> {

    private static final String NODE_COLOR = "color";
    private static final String NODE_STYLE = "style";

    @Override
    public TextFormat deserialize(TypeToken<?> type, ConfigurationNode value) throws ObjectMappingException {
        TextColor color = TextColors.NONE;
        GameRegistry registry = Sponge.getRegistry();
        String colorId = value.getNode(NODE_COLOR).getString();
        if (colorId != null) {
            color = registry.getType(TextColor.class, colorId).orElseThrow(() -> new ObjectMappingException("Color not found: " + colorId));
        }

        TextStyle style = TextStyles.NONE;
        ConfigurationNode styleNode = value.getNode(NODE_STYLE);
        for (TextStyle.Base component : registry.getAllOf(TextStyle.Base.class)) {
            if (styleNode.getNode(component.getId().toLowerCase()).getBoolean()) {
                style = style.and(component);
            }
        }

        return TextFormat.NONE.color(color).style(style);
    }

    @Override
    public void serialize(TypeToken<?> type, TextFormat obj, ConfigurationNode value) throws ObjectMappingException {
        value.getNode(NODE_COLOR).setValue(obj.getColor().getId());
        ConfigurationNode styleNode = value.getNode(NODE_STYLE);
        TextStyle composite = obj.getStyle();
        Sponge.getRegistry().getAllOf(TextStyle.Base.class)
                .forEach(style -> styleNode.getNode(style.getId().toLowerCase()).setValue(composite.contains(style)));
    }

}

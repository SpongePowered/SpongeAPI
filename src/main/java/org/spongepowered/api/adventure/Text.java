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
package org.spongepowered.api.adventure;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.LinearComponents;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandCause;

import java.util.function.Consumer;

/**
 * Various helpers for creating {@link Component}s.
 */
public final class Text {

    private Text() {
    }

    /**
     * Creates a text component with content.
     *
     * @param content the plain text content
     * @return a text component
     */
    public static Component of(final String content) {
        return Component.text(content);
    }

    /**
     * Creates a component "linearly".
     *
     * @param components the components
     * @return a component
     */
    public static Component of(final Component... components) {
        return LinearComponents.linear(components);
    }

    /**
     * Creates a colored and decorated component.
     * <p>See {@link net.kyori.adventure.text.format.NamedTextColor} for colors</p>
     *
     * @param content the plain text content
     * @param color the text color
     * @return a component
     */
    public static Component of(final String content, final TextColor color, final TextDecoration... decorations) {
        return Component.text(content, Style.style(color, decorations));
    }

    /**
     * Creates a decorated component.
     *
     * @param content the plain text content
     * @param decorations the text decorations
     * @return a component
     */
    public static Component of(final String content, final TextDecoration... decorations) {
        return Component.text(content, Style.style(decorations));
    }

    /**
     * Creates a styled component.
     *
     * @param content the plain text content
     * @param style the style
     * @return a component
     */
    public static Component of(final String content, final Style style) {
        return Component.text(content, style);
    }

    /**
     * Creates a new builder.
     *
     * @return a Component builder
     */
    public static TextComponent.Builder builder() {
        return Component.text();
    }

    /**
     * Serializes a component using the {@link PlainComponentSerializer}.
     *
     * @param component the component
     * @return the serialized component
     */
    public static String toPlain(final Component component) {
        return PlainComponentSerializer.plain().serialize(component);
    }

    /**
     * Serializes a component using the {@link GsonComponentSerializer}.
     *
     * @param component the component
     * @return the serialized component
     */
    public static String toJson(final Component component) {
        return GsonComponentSerializer.gson().serialize(component);
    }

    /**
     * Deserializes a component using the {@link GsonComponentSerializer}.
     *
     * @param json the json string
     *
     * @return the deserialized component
     */
    public static Component fromJson(final String json) {
        return GsonComponentSerializer.gson().deserialize(json);
    }

    /**
     * Serializes a component using the {@link LegacyComponentSerializer#legacyAmpersand()}.
     * e.g.: <code>"&eFoobar" == Text.of("Foobar", NamedTextColor.YELLOW)</code>
     *
     * @param component the component
     * @return the serialized component
     */
    public static String toLegacy(final Component component) {
        return LegacyComponentSerializer.legacyAmpersand().serialize(component);
    }

    /**
     * Deserializes a component using the {@link LegacyComponentSerializer#legacyAmpersand()}.
     * e.g.: <code>"&eFoobar" == Text.of("Foobar", NamedTextColor.YELLOW)</code>
     *
     * @param legacy the legacy string
     * @return the deserialized component
     */
    public static Component fromLegacy(final String legacy) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(legacy);
    }

    /**
     * Creates a new {@link ClickEvent} that will execute the given runnable on
     * the server when clicked. The callback will expire after some amount of
     * time (not particularly instantly, but not like overnight really either).
     *
     * @param callback The callback to execute
     * @return The created click event instance
     */
    public static ClickEvent executeCallback(final Consumer<CommandCause> callback) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).callbackClickEvent(callback);
    }

    public interface Factory {
        ClickEvent callbackClickEvent(final Consumer<CommandCause> callback);
    }
}

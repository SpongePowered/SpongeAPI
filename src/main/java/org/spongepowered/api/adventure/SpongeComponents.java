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

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.registry.DefaultedRegistryReference;

import java.util.function.Consumer;

/**
 * Additional SpongeAPI-specific methods for working with {@link Component}s and related.
 */
public final class SpongeComponents {
    private SpongeComponents() {
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
        return SpongeComponents.factory().callbackClickEvent(callback);
    }

    /**
     * Render a component for viewer-specific context.
     *
     * <p>The {@code viewer} must refer to a single viewer, not multiple viewers,
     * in order to gather any useful context. If an audience cannot be resolved
     * to a single viewer, this method will behave as if no viewer had
     * been defined.</p>
     *
     * @param component the component to render
     * @param senderContext the context to render in
     * @param viewer the viewer to render for
     * @param resolver the first resolver
     * @param otherResolvers any other resolvers to apply
     * @return the rendered component
     */
    @SafeVarargs
    public static Component resolve(
        final Component component,
        final CommandCause senderContext,
        final Audience viewer,
        final DefaultedRegistryReference<ResolveOperation> resolver,
        final DefaultedRegistryReference<ResolveOperation>... otherResolvers
    ) {
        return SpongeComponents.factory().render(component, senderContext, viewer, resolver, otherResolvers);
    }

    /**
     * Render a component for sender-specific context.
     *
     * <p>Viewer-specific information will not be available</p>
     *
     * @param component the component to render
     * @param senderContext the context to render in
     * @param resolver the first resolver
     * @param otherResolvers any other resolvers to apply
     * @return the rendered component
     */
    @SafeVarargs
    public static Component resolve(
        final Component component,
        final CommandCause senderContext,
        final DefaultedRegistryReference<ResolveOperation> resolver,
        final DefaultedRegistryReference<ResolveOperation>... otherResolvers
    ) {
        return SpongeComponents.factory().render(component, senderContext, resolver, otherResolvers);
    }

    /**
     * Get a serializer for {@link Component}s that will convert to and from the
     * legacy component format used by the Vanilla client.
     *
     * <p>This legacy serializer uses the standard section symbol to mark
     * formatting characters.</p>
     *
     * <p>Implementations may provide a serializer capable of processing any
     * information that requires access to implementation details.</p>
     *
     * @return a section serializer
     */
    public static LegacyComponentSerializer legacySectionSerializer() {
        return SpongeComponents.factory().legacySectionSerializer();
    }

    /**
     * Get a serializer for {@link Component}s that will convert to and from the
     * legacy component format used by the Vanilla client.
     *
     * <p>This legacy serializer uses the alternate ampersand symbol ({@code &})
     * to mark formatting characters.</p>
     *
     * <p>Implementations may provide a serializer capable of processing any
     * information that requires access to implementation details.</p>
     *
     * @return a legacy serializer using ampersands
     */
    public static LegacyComponentSerializer legacyAmpersandSerializer() {
        return SpongeComponents.factory().legacyAmpersandSerializer();
    }

    /**
     * Get a serializer for {@link Component}s that will convert to and from the
     * legacy component format used by the Vanilla client.
     *
     * <p>Implementations may provide a serializer capable of processing any
     * information that requires access to implementation details.</p>
     *
     * @param formatChar the format character to use in place of the standard
     *         section symbol
     * @return a legacy serializer using ampersands
     */
    public static LegacyComponentSerializer legacySerializer(final char formatChar) {
        return SpongeComponents.factory().legacySerializer(formatChar);
    }

    /**
     * Get a serializer for {@link Component}s that will convert to and from the
     * standard JSON serialization format using Gson.
     *
     * <p>Implementations may provide a serializer capable of processing any
     * information that requires implementation details, such as legacy
     * (pre-1.16) hover events.</p>
     *
     * @return a json component serializer
     */
    public static GsonComponentSerializer gsonSerializer() {
        return SpongeComponents.factory().gsonSerializer();
    }

    /**
     * Get a serializer for {@link Component}s that will convert components to
     * a plain-text string.
     *
     * <p>Implementations may provide a serializer capable of processing any
     * information that requires access to implementation details.</p>
     *
     * @return a serializer to plain text
     */
    public static PlainComponentSerializer plainSerializer() {
        return SpongeComponents.factory().plainSerializer();
    }

    private static Factory factory() {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class);
    }

    public interface Factory {
        ClickEvent callbackClickEvent(final Consumer<CommandCause> callback);

        LegacyComponentSerializer legacySectionSerializer();

        LegacyComponentSerializer legacyAmpersandSerializer();

        LegacyComponentSerializer legacySerializer(final char formatChar);

        GsonComponentSerializer gsonSerializer();

        PlainComponentSerializer plainSerializer();

        @SuppressWarnings("unchecked")
        Component render(
            final Component component,
            final CommandCause senderContext,
            final Audience viewer,
            final DefaultedRegistryReference<ResolveOperation> resolver,
            final DefaultedRegistryReference<ResolveOperation>... otherResolvers
        );

        @SuppressWarnings("unchecked")
        Component render(
            final Component component,
            final CommandCause senderContext,
            final DefaultedRegistryReference<ResolveOperation> resolver,
            final DefaultedRegistryReference<ResolveOperation>... otherResolvers
        );

    }
}

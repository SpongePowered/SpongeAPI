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
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * Additional SpongeAPI-specific methods for working with {@link Component}s and related.
 */
public final class SpongeComponents {
    private SpongeComponents() {
    }

    /**
     * Creates a new {@link HoverEvent} that will show information about an
     * item when it is hovered.
     *
     * @param item The item to display
     * @return The created hover event instance
     */
    public static HoverEvent<HoverEvent.ShowItem> showItem(final ItemStackSnapshot item) {
        return SpongeComponents.factory().showItem(item);
    }

    /**
     * Creates a new {@link HoverEvent} that will show information about an
     * entity when it is hovered.
     *
     * @param entity The entity
     * @return The created hover event instance
     */
    public static HoverEvent<HoverEvent.ShowEntity> showEntity(final Entity entity) {
        return SpongeComponents.showEntity(entity, entity.displayName().get());
    }

    /**
     * Creates a new {@link HoverEvent} that will show information about an
     * entity when it is hovered.
     *
     * @param entity The entity
     * @param name The name of the entity
     * @return The created hover event instance
     */
    public static HoverEvent<HoverEvent.ShowEntity> showEntity(final Entity entity, final @Nullable Component name) {
        return SpongeComponents.showEntity(entity.getType(), entity.getUniqueId(), name);
    }

    /**
     * Creates a new {@link HoverEvent} that will show information about an
     * entity when it is hovered.
     *
     * @param type The type of the entity
     * @param uuid The UUID of the entity
     * @return The created hover event instance
     */
    public static HoverEvent<HoverEvent.ShowEntity> showEntity(final EntityType<?> type, final UUID uuid) {
        return SpongeComponents.showEntity(type, uuid, null);
    }

    /**
     * Creates a new {@link HoverEvent} that will show information about an
     * entity when it is hovered.
     *
     * @param type The type of the entity
     * @param uuid The UUID of the entity
     * @param name The name of the entity
     * @return The created hover event instance
     */
    public static HoverEvent<HoverEvent.ShowEntity> showEntity(final EntityType<?> type, final UUID uuid, final @Nullable Component name) {
        return HoverEvent.showEntity(new HoverEvent.ShowEntity(type.getKey(), uuid, name));
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

    private static Factory factory() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class);
    }

    public interface Factory {
        HoverEvent<HoverEvent.ShowItem> showItem(final ItemStackSnapshot item);

        ClickEvent callbackClickEvent(final Consumer<CommandCause> callback);
    }
}

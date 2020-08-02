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
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandCause;

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
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).callbackClickEvent(callback);
    }

    public interface Factory {
        ClickEvent callbackClickEvent(final Consumer<CommandCause> callback);
    }
}

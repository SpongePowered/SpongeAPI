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
package org.spongepowered.api.event.lifecycle;

import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.manager.CommandFailedRegistrationException;
import org.spongepowered.api.command.manager.CommandMapping;
import org.spongepowered.api.command.registrar.CommandRegistrar;
import org.spongepowered.api.event.GenericEvent;
import org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod;
import org.spongepowered.plugin.PluginContainer;

/**
 * Lifecycle event to indicate when commands should be registered.
 *
 * <p>There are two types command that Sponge will always call an event for:</p>
 *
 * <ul>
 *     <li>Where {@link C} is {@link Command.Raw}; and</li>
 *     <li>Where {@link C} is {@link Command.Parameterized}.</li>
 * </ul>
 *
 * <p>Other plugins may provide a {@link CommandRegistrar} that allows for other
 * types to be registered as commands. These types will be provided by these
 * other plugins.</p>
 *
 * <p>This event will be called whenever the game re-initializes commands, and
 * does not guarantee that any specific engine is running.</p>
 *
 * @param <C> The type of command that is being registered.
 */
@NoFactoryMethod
public interface RegisterCommandEvent<C> extends GenericEvent<C>, LifecycleEvent {

    /**
     * Registers a command with the appropriate {@link CommandRegistrar}.
     *
     * @param container The {@link PluginContainer}
     * @param command The command to register
     * @param alias The first alias to register for this command
     * @param aliases Any other aliases to register
     * @return The {@link Result}, which contains the {@link CommandMapping} for
     *      this registration, while also allowing for chaining of other command
     *      registrations.
     * @throws CommandFailedRegistrationException if registration failed
     */
    Result<C> register(PluginContainer container, C command, String alias, String... aliases) throws CommandFailedRegistrationException;

    /**
     * The {@link Result} of a command registration, allowing for the chaining
     * of other command registrations, or the retrival of the
     * {@link CommandMapping} generated from the registration that returned this
     * result.
     */
    interface Result<C> {

        /**
         * Registers a command with the appropriate {@link CommandRegistrar}.
         *
         * @param container The {@link PluginContainer}
         * @param command The command to register
         * @param alias The first alias to register for this command
         * @param aliases Any other aliases to register
         * @return The {@link Result}, which contains the {@link CommandMapping} for
         *      this registration, while also allowing for chaining of other command
         *      registrations.
         * @throws CommandFailedRegistrationException if registration failed
         */
        Result<C> register(PluginContainer container, C command, String alias, String... aliases) throws CommandFailedRegistrationException;

        /**
         * The {@link CommandMapping} generated for the previous registration.
         *
         * @return The {@link CommandMapping}
         */
        CommandMapping mapping();

    }

}

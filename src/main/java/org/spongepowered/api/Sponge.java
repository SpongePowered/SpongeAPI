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
package org.spongepowered.api;

import static com.google.common.base.Preconditions.checkState;

import org.spongepowered.api.data.ImmutableDataRegistry;
import org.spongepowered.api.data.manipulator.DataManipulatorRegistry;
import org.spongepowered.api.network.ChannelRegistrar;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.util.persistence.SerializationManager;
import org.spongepowered.api.scheduler.Scheduler;

public final class Sponge {

    private static final Game game = null;

    public static Game getGame() {
        checkState(game != null, "Sponge has not been initialized!");
        return game;
    }

    public static GameRegistry getRegistry() {
        return getGame().getRegistry();
    }

    public static ServiceManager getServiceManager() {
        return getGame().getServiceManager();
    }

    public static EventManager getEventManager() {
        return getGame().getEventManager();
    }

    public static Scheduler getScheduler() {
        return getGame().getScheduler();
    }

    public static SerializationManager getSerializationService() {
        return getGame().getSerializationManager();
    }

    public static PluginManager getPluginManager() {
        return getGame().getPluginManager();
    }

    public static Platform getPlatform() {
        return getGame().getPlatform();
    }

    public static GameDictionary getDictionary() {
        return getGame().getGameDictionary();
    }

    public static CommandManager getCommandDispatcher() {
        return getGame().getCommandManager();
    }

    public static ChannelRegistrar getChannelRegistrar() {
        return getGame().getChannelRegistrar();
    }

    public static DataManipulatorRegistry getManipulatorRegistry() {
        return getGame().getManipulatorRegistry();
    }

    public static ImmutableDataRegistry getImmutableManipulatorRegistry() {
        return getGame().getImmutableDataRegistry();
    }

}

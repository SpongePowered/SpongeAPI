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
package org.spongepowered.api.event.command;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;

/**
 * Fired when a {@link Player} send a tab complete requests.
 *
 * <p>In Vanilla, this is done by pressing the <code>TAB</code> key while chat is open.</p>
 */
public interface TabCompleteEvent extends GameEvent, Cancellable, CauseTracked {

    /**
     * Gets the message sent to the server for tab completion.
     *
     * <p>The Vanilla client does not send the entire contents of the chat box.
     * Instead, it sends the contents of the chat box up to the cursor position
     * (excluding the character after the cursor).
     *
     * @return the message sent to the server for tab completion.
     */
    String getRawMessage();

    /**
     * Gets the immutable list of the suggestions originally generated.
     *
     * <p>In Vanilla, these suggestions are usually player names, in the case
     * of {@link Chat}.</p>
     *
     * <p>Note: Entries *should not* contain spaces, as they produce strange
     * behavior on the Vanilla client (tabbing between entries causes them
     * to be appended to the text box, instead of replacing the existing
     * entry.</p>
     *
     * @return the immutable list of original suggestions
     */
    List<String> getOriginalTabCompletions();

    /**
     * Gets the location the client was looking at, if available.
     *
     * <p>If the Vanilla client was looking at a block when they initiated the
     * tab-complete, it will be sent along with the message.</p>
     *
     *
     * @return the location block the client was looking at, if available.
     */
    Optional<Location<World>> getTargetLocation();

    /**
     * Get the list of available suggestions. This list is mutable, so any modifications should happen to this list. All suggestions will replace
     * the last word in the arguments on the client.
     *
     * @return The list of suggestion
     */
    List<String> getTabCompletions();

    interface Command extends TabCompleteEvent {

        /**
         * Get the command as a string, without any sort of command prefix.
         *
         * <p>For example, if the message was {@code /example bob 3 -f}, then the command would be {@code example}.</p>
         *
         * @return The commands
         */
        String getCommand();

        /**
         * Get the arguments as a string.
         *
         * <p>For example, if the message was {@code /example bob 3 -f}, then the arguments would be {@code bob 3 -f}.</p>
         *
         * @return The arguments
         */
        String getArguments();
    }

    interface Chat extends TabCompleteEvent {}

}

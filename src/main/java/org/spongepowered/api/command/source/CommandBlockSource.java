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
package org.spongepowered.api.command.source;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.CommandData;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Locatable;

import java.util.Optional;

/**
 * Represents a CommandBlock source, either a placed block or a CommandBlockMinecart.
 */
public interface CommandBlockSource extends Locatable, CommandSource, DataHolder {

    /**
     * Gets the {@link CommandData} for this source.
     *
     * @return The command data
     */
    default CommandData getCommandData() {
        return get(CommandData.class).get();
    }


    /**
     * Gets the currently stored command.
     *
     * @return The command
     */
    default Value<String> storedCommand() {
        return getValue(Keys.COMMAND).get();
    }

    /**
     * Gets the success count of the last executed command.
     *
     * <p>The success count is the number of times the most recently used
     * command of this command block succeeded. Most commands can only succeed
     * once per  execution, but certain commands (such as those which accept
     * players as arguments) can succeed multiple times, and this value will be
     * set accordingly. This success count can also be polled via a redstone
     * comparator.</p>
     *
     * @return The last success count
     */
    default Value<Integer> successCount() {
        return getValue(Keys.SUCCESS_COUNT).get();
    }

    /**
     * Gets whether this command block will keep track of the output from the
     * last command it executed.
     *
     * @return Whether the command output is tracked
     */
    default Value<Boolean> doesTrackOutput() {
        return getValue(Keys.TRACKS_OUTPUT).get();
    }

    /**
     * Gets the last command output.
     *
     * <p>This will only be available if {@link #doesTrackOutput()} is set to
     * true, otherwise {@link Optional#empty()} will be returned.</p>
     *
     * @return The last command output, if available
     */
    default OptionalValue<Text> lastOutput() {
        return getValue(Keys.LAST_COMMAND_OUTPUT).get();
    }

}

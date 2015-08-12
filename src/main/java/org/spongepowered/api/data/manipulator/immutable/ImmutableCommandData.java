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
package org.spongepowered.api.data.manipulator.immutable;

import com.google.common.base.Optional;
import org.spongepowered.api.block.tileentity.CommandBlock;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.CommandData;
import org.spongepowered.api.data.value.immutable.ImmutableOptionalValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.vehicle.minecart.MinecartCommandBlock;
import org.spongepowered.api.text.Text;

/**
 * An {@link ImmutableDataManipulator} handling all related
 * {@link ImmutableValue}s for command related {@link DataHolder}s, such as
 * {@link CommandBlock}s and {@link MinecartCommandBlock}s.
 */
public interface ImmutableCommandData extends ImmutableDataManipulator<ImmutableCommandData, CommandData> {

    /**
     * Gets the currently stored command.
     *
     * @return The command
     */
    ImmutableValue<String> storedCommand();

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
    ImmutableValue<Integer> successCount();

    /**
     * Gets whether this command block will keep track of the output from the
     * last command it executed.
     *
     * @return Whether the command output is tracked
     */
    ImmutableValue<Boolean> doesTrackOutput();

    /**
     * Gets the last command output.
     *
     * <p>This will only be available if {@link #doesTrackOutput()} is set to
     * true, otherwise {@link Optional#absent()} will be returned.</p>
     *
     * @return The last command output, if available
     */
    ImmutableOptionalValue<Text> lastOutput();
}

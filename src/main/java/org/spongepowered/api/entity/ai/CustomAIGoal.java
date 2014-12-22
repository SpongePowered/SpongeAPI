/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.entity.ai;

/**
 * Represents a custom AI goal that can be implemented by plugins.
 */
public interface CustomAIGoal extends AIGoal {

    /**
     * Checks whether this goal should (still) be executed or not.
     * <p>
     * <b>Note:</b> This method should never be called by a plugin directly
     * outside the AI handling process.
     * </p>
     *
     * @param isRunning True, if the goal is currently active and has already
     *            been executed once.
     * @return True, if the task should be executed. False otherwise.
     */
    public boolean shouldExecute(boolean isRunning);

    /**
     * Checks whether this task can be interrupted by a higher priority goal.
     *
     * <p>
     * <b>Note:</b> This method should never be called by a plugin directly
     * outside the AI handling process.
     * </p>
     *
     * @return True, if this task can be interrupted. False otherwise.
     */
    public boolean isInterruptible();

    /**
     * Execute the task required for this goal like moving to a new location or
     * shooting an arrow.
     * <p>
     * <b>Note:</b> This method should never be called by a plugin directly
     * outside the AI handling process.
     * </p>
     *
     * @param isRunning True, if the goal is currently active and has already
     *            been executed once.
     * @see BodyController
     */
    public void execute(boolean isRunning);

    /**
     * Abort or resets the execution of this goal. The execution will be
     * aborted/reseted when the goal should not be executed any longer or a goal
     * with a higher priority interrupted this goal.
     * <p>
     * <b>Note:</b> This method should never be called by a plugin directly
     * outside the AI handling process.
     * </p>
     */
    public void abort();

}

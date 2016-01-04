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
package org.spongepowered.api.entity.ai.task.builtin.doorinteract;

import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.living.Agent;

/**
 * An {@link AITask} which the executor opens the door when the task starts to
 * execute and sometimes closes the door when the task is finished. (MCP name:
 * EntityAIOpenDoor)
 */
public interface OpenDoorAITask extends DoorInteractAITask<OpenDoorAITask, Agent> {

    /**
     * Get whether the executor will close the door when the task is finished.
     *
     * @return Whether should the executor close the door
     */
    boolean shouldCloseDoor();

    /**
     * Set whether the executor will close the door when the task is finished.
     *
     * @param closeDoor Whether should the executor close the door
     * @return The task for chaining
     */
    OpenDoorAITask setCloseDoor(boolean closeDoor);

    /**
     * Get the time delay of between the opening and the closing of the door in
     * ticks. It has no effect when the executor does not close the door.
     * Default to 20 ticks.
     *
     * @return The time delay
     */
    int getDoorClosingDelay();

    /**
     * Set the time delay of between the opening and the closing of the door in
     * ticks. It has no effect when the executor does not close the door.
     * Default to 20 ticks.
     *
     * @param doorClosingDelay The time delay
     * @return The task for chaining
     */
    OpenDoorAITask setDoorClosingDelay(int doorClosingDelay);

    /**
     * Utility builder for {@link OpenDoorAITask}.
     */
    interface Builder extends DoorInteractAITask.Builder<Agent, OpenDoorAITask, Builder> {

        /**
         * Set whether the executor will close the door when the task is
         * finished.
         *
         * @param closeDoor Whether should the executor close the door
         * @return The builder for chaining
         */
        Builder closeDoor(boolean closeDoor);

        /**
         * Set the time delay of between the opening and the closing of the door
         * in ticks. It does not effect when the executor does not close the
         * door. Default to 20 ticks.
         *
         * @param doorClosingDelay The time delay
         * @return The builder for chaining
         */
        Builder delay(int doorClosingDelay);

    }

}

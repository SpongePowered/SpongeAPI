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
package org.spongepowered.api.event;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.ai.Goal;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;

@SuppressWarnings({"rawtypes"})
public class SpongeAITaskEventTest {

    @Test
    public void testValidTargetAgentAndGoalOwner() {
        Agent targetEntity = mock(Agent.class);
        Goal goal = mock(Goal.class);
        Mockito.when(goal.getOwner()).thenReturn(targetEntity);

        SpongeEventFactory.createAITaskEventAdd(Cause.of(EventContext.empty(), mock(Game.class)), 0, 0, goal, targetEntity, mock(AITask.class));
        SpongeEventFactory.createAITaskEventRemove(Cause.of(EventContext.empty(), mock(Game.class)), goal, targetEntity, mock(AITask.class), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAITaskEventAdd_invalidTargetAgentAndGoalOwner() {
        Agent targetEntity = mock(Agent.class);
        Agent secondEntity = mock(Agent.class);
        Goal goal = mock(Goal.class);
        Mockito.when(goal.getOwner()).thenReturn(secondEntity);

        SpongeEventFactory.createAITaskEventAdd(Cause.of(EventContext.empty(), mock(Game.class)), 0, 0, goal, targetEntity, mock(AITask.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAITaskEventRemove_invalidTargetAgentAndGoalOwner() {
        Agent targetEntity = mock(Agent.class);
        Agent secondEntity = mock(Agent.class);
        Goal goal = mock(Goal.class);
        Mockito.when(goal.getOwner()).thenReturn(secondEntity);

        SpongeEventFactory.createAITaskEventRemove(Cause.of(EventContext.empty(), mock(Game.class)), goal, targetEntity, mock(AITask.class), 0);
    }

}

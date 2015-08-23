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

/**
 * All actions that can be "interacted" with that take place on the
 * {@link org.spongepowered.api.Server} are represented as
 * {@link org.spongepowered.api.event.Event}s.
 *
 * <p>Every event named will follow a naming structure of “SourceActionTargetEvent”:
 * <ul>
 *   <li>The roots are structured such that it is either a “SourceEvent”, “ActionTargetEvent”</li>
 *   <li>Almost all “Target” getters and setters will include “target” in the method names:
 *   <ul>
 *       <li>The {@link org.spongepowered.api.event.target.block.PlaceBlockEvent#getReplacementBlocks()}
 *       refers to the {@link org.spongepowered.api.block.BlockState}s being replaced. The "Action" is "Placing",
 *       and the "Target" is either a single "block" or multiple "blocks".</li>
 *       <li>The {@link org.spongepowered.api.event.target.entity.InteractEntityEvent} has a method to retrieve
 *       the {@link org.spongepowered.api.entity.Entity} instance being affected with
 *       {@link org.spongepowered.api.event.target.entity.InteractEntityEvent#getTargetEntity()}.</li>
 *   </ul>
 *   </li>
 *   <li>Contractually, all "Source" events will be prefixed with the "source" in the event name.</li>
 *   <ul>
 *       <li>{@link org.spongepowered.api.event.source.block.BlockEvent} is for when a
 *       {@link org.spongepowered.api.world.Location} is performing an action, but not being affected by
 *       another action.</li>
 *       <li>{@link org.spongepowered.api.event.source.entity.EntityEvent} is for when an
 *       {@link org.spongepowered.api.entity.Entity} is performing an action, but the action is not known.
 *       The "source" in this case is retrieved from the event through
 *       {@link org.spongepowered.api.event.source.entity.EntityEvent#getEntity()}.</li>
 *   </ul>
 * </ul>
 * </p>
 *
 */
@org.spongepowered.api.util.annotation.NonnullByDefault package org.spongepowered.api.event;

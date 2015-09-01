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


/** 
 * Generates Sponge event implementations.
 */
public final class SpongeEventFactory {
    private SpongeEventFactory() {
    }

    /** 
     * Creates an event class from an interface and a map of property names to values.
     * 
     * @param type The event interface to generate a class for
     * @param values The map of property names to values
     * @param <T> The type of event to be created
     * @return The generated event class.
     */
@java.lang.SuppressWarnings(value = "unchecked")
    public static <T>T createEventImpl(java.lang.Class<T> type, java.util.Map<java.lang.String, java.lang.Object> values) {
        return org.spongepowered.api.event.SpongeEventFactoryUtils.createEventImpl(type, values);
    }

    /** 
     * Creates a new {@link GameStateEvent} of the given type.
     * 
     * @param type The type of the state event
     * @param game The game instance for this {@link GameEvent}
     * @param <T> The type of the state event
     * @return A new instance of the event
     */
public static <T extends org.spongepowered.api.event.game.state.GameStateEvent>T createState(java.lang.Class<T> type, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMapWithExpectedSize(1);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(type, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.Event}.
     * 
     * @return A new event
     */
public static org.spongepowered.api.event.Event createEvent() {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.Event.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.GameEvent}.
     * 
     * @param game The game
     * @return A new game event
     */
public static org.spongepowered.api.event.GameEvent createGameEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.GameEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.ChangeExperienceEvent}.
     * 
     * @param experience The experience
     * @param originalExperience The original experience
     * @return A new change experience event
     */
public static org.spongepowered.api.event.action.ChangeExperienceEvent createChangeExperienceEvent(int experience, int originalExperience) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.action.ChangeExperienceEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.ConnectEvent}.
     * 
     * @return A new connect event
     */
public static org.spongepowered.api.event.action.ConnectEvent createConnectEvent() {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.action.ConnectEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.DisconnectEvent}.
     * 
     * @return A new disconnect event
     */
public static org.spongepowered.api.event.action.DisconnectEvent createDisconnectEvent() {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.action.DisconnectEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.InteractEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @return A new interact event
     */
public static org.spongepowered.api.event.action.InteractEvent createInteractEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.action.InteractEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.MessageEvent}.
     * 
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @return A new message event
     */
public static org.spongepowered.api.event.action.MessageEvent createMessageEvent(org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.util.command.CommandSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("message", message);
        values.put("newMessage", newMessage);
        values.put("sink", sink);
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.action.MessageEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent createAttackBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent.SourceEntity createAttackBlockEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent.SourceHuman createAttackBlockEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent.SourceLiving createAttackBlockEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent.SourcePlayer createAttackBlockEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block event
     */
public static org.spongepowered.api.event.block.BlockEvent createBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent createBreakBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourceBlock createBreakBlockEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source entity break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourceEntity createBreakBlockEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source human break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourceHuman createBreakBlockEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source living break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourceLiving createBreakBlockEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source player break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourcePlayer createBreakBlockEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent createChangeBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceBlock createChangeBlockEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source entity change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceEntity createChangeBlockEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source human change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceHuman createChangeBlockEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source living change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceLiving createChangeBlockEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source player change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourcePlayer createChangeBlockEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceWorld createChangeBlockEventSourceWorld(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceWorld.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent createCollideBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent.SourceEntity createCollideBlockEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent.SourceHuman createCollideBlockEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent.SourceLiving createCollideBlockEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent.SourcePlayer createCollideBlockEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.DecayBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new decay block event
     */
public static org.spongepowered.api.event.block.DecayBlockEvent createDecayBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.DecayBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.DecayBlockEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world decay block event
     */
public static org.spongepowered.api.event.block.DecayBlockEvent.SourceWorld createDecayBlockEventSourceWorld(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.DecayBlockEvent.SourceWorld.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.GrowBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new grow block event
     */
public static org.spongepowered.api.event.block.GrowBlockEvent createGrowBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.GrowBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.GrowBlockEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world grow block event
     */
public static org.spongepowered.api.event.block.GrowBlockEvent.SourceWorld createGrowBlockEventSourceWorld(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.GrowBlockEvent.SourceWorld.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent}.
     * 
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent createHarvestBlockEvent(float dropChance, int experience, org.spongepowered.api.Game game, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, float originalDropChance, int originalExperience, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source block harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourceBlock createHarvestBlockEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, float dropChance, int experience, org.spongepowered.api.Game game, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, float originalDropChance, int originalExperience, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source entity harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourceEntity createHarvestBlockEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, float dropChance, int experience, org.spongepowered.api.Game game, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, float originalDropChance, int originalExperience, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source human harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourceHuman createHarvestBlockEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, float dropChance, int experience, org.spongepowered.api.Game game, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, float originalDropChance, int originalExperience, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source living harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourceLiving createHarvestBlockEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, float dropChance, int experience, org.spongepowered.api.Game game, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, float originalDropChance, int originalExperience, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source player harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourcePlayer createHarvestBlockEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, float dropChance, int experience, org.spongepowered.api.Game game, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, float originalDropChance, int originalExperience, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent createInteractBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new attack interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Attack createInteractBlockEventAttack(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Attack.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity attack interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceEntity createInteractBlockEventAttackSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human attack interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceHuman createInteractBlockEventAttackSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living attack interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceLiving createInteractBlockEventAttackSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player attack interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourcePlayer createInteractBlockEventAttackSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source block interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourceBlock createInteractBlockEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourceEntity createInteractBlockEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourceHuman createInteractBlockEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourceLiving createInteractBlockEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourcePlayer createInteractBlockEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use createInteractBlockEventUse(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source block use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceBlock createInteractBlockEventUseSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceEntity createInteractBlockEventUseSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceHuman createInteractBlockEventUseSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceLiving createInteractBlockEventUseSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourcePlayer createInteractBlockEventUseSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.util.Direction targetSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.MoveBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new move block event
     */
public static org.spongepowered.api.event.block.MoveBlockEvent createMoveBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.MoveBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.MoveBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block move block event
     */
public static org.spongepowered.api.event.block.MoveBlockEvent.SourceBlock createMoveBlockEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.MoveBlockEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent createNotifyNeighborBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new burn notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn createNotifyNeighborBlockEventBurn(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block burn notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn.SourceBlock createNotifyNeighborBlockEventBurnSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new ignite notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite createNotifyNeighborBlockEventIgnite(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block ignite notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite.SourceBlock createNotifyNeighborBlockEventIgniteSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new power notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power createNotifyNeighborBlockEventPower(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block power notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power.SourceBlock createNotifyNeighborBlockEventPowerSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.SourceBlock createNotifyNeighborBlockEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param spreadingBlock The spreading block
     * @return A new spread notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread createNotifyNeighborBlockEventSpread(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.block.BlockState spreadingBlock) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("spreadingBlock", spreadingBlock);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param spreadingBlock The spreading block
     * @param transactions The transactions
     * @return A new source block spread notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread.SourceBlock createNotifyNeighborBlockEventSpreadSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.BlockState spreadingBlock, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("spreadingBlock", spreadingBlock);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent createPlaceBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourceBlock createPlaceBlockEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source entity place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourceEntity createPlaceBlockEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source human place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourceHuman createPlaceBlockEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source living place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourceLiving createPlaceBlockEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param transactions The transactions
     * @return A new source player place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourcePlayer createPlaceBlockEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent}.
     * 
     * @param brewedItems The brewed items
     * @param cause The cause
     * @param fuelSource The fuel source
     * @param game The game
     * @param inventory The inventory
     * @param results The results
     * @param sourceBlock The source block
     * @param sourceItems The source items
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new brewing stand brew items event
     */
public static org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent createBrewingStandBrewItemsEvent(java.util.List<org.spongepowered.api.item.inventory.ItemStack> brewedItems, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.item.inventory.ItemStack fuelSource, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, java.util.List<org.spongepowered.api.item.inventory.ItemStack> results, org.spongepowered.api.block.BlockSnapshot sourceBlock, java.util.List<org.spongepowered.api.item.inventory.ItemStack> sourceItems, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.tileentity.carrier.BrewingStand tile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("brewedItems", brewedItems);
        values.put("cause", cause);
        values.put("fuelSource", fuelSource);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("results", results);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceItems", sourceItems);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingStandEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new brewing stand event
     */
public static org.spongepowered.api.event.block.tileentity.BrewingStandEvent createBrewingStandEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.tileentity.carrier.BrewingStand tile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.BrewingStandEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent}.
     * 
     * @param game The game
     * @param originalText The original text
     * @param targetTile The target tile
     * @param text The text
     * @return A new change sign event
     */
public static org.spongepowered.api.event.block.tileentity.ChangeSignEvent createChangeSignEvent(org.spongepowered.api.Game game, org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData originalText, org.spongepowered.api.block.tileentity.Sign targetTile, org.spongepowered.api.data.manipulator.mutable.tileentity.SignData text) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.ChangeSignEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalText The original text
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetTile The target tile
     * @param text The text
     * @return A new source entity change sign event
     */
public static org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceEntity createChangeSignEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData originalText, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.tileentity.Sign targetTile, org.spongepowered.api.data.manipulator.mutable.tileentity.SignData text) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalText The original text
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetTile The target tile
     * @param text The text
     * @return A new source player change sign event
     */
public static org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourcePlayer createChangeSignEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData originalText, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.tileentity.Sign targetTile, org.spongepowered.api.data.manipulator.mutable.tileentity.SignData text) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent}.
     * 
     * @param burnedItem The burned item
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param remainingFuel The remaining fuel
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace consume fuel event
     */
public static org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent createFurnaceConsumeFuelEvent(org.spongepowered.api.item.inventory.ItemStack burnedItem, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStack> remainingFuel, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStack> result, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.tileentity.carrier.Furnace tile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("burnedItem", burnedItem);
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("remainingFuel", remainingFuel);
        values.put("result", result);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace event
     */
public static org.spongepowered.api.event.block.tileentity.FurnaceEvent createFurnaceEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.tileentity.carrier.Furnace tile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.FurnaceEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent}.
     * 
     * @param cause The cause
     * @param cookedItem The cooked item
     * @param game The game
     * @param inventory The inventory
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceItem The source item
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace smelt item event
     */
public static org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent createFurnaceSmeltItemEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.item.inventory.ItemStack cookedItem, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStack> result, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.item.inventory.ItemStack sourceItem, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.tileentity.carrier.Furnace tile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("cookedItem", cookedItem);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("result", result);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceItem", sourceItem);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.TargetTileEntityEvent}.
     * 
     * @param game The game
     * @param targetTile The target tile
     * @return A new target tile entity event
     */
public static org.spongepowered.api.event.block.tileentity.TargetTileEntityEvent createTargetTileEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.block.tileentity.TileEntity targetTile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetTile", targetTile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.TargetTileEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.TileEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new tile entity event
     */
public static org.spongepowered.api.event.block.tileentity.TileEntityEvent createTileEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.block.tileentity.TileEntity tile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.TileEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.CommandSourceEvent}.
     * 
     * @param game The game
     * @param source The source
     * @return A new command source event
     */
public static org.spongepowered.api.event.command.CommandSourceEvent createCommandSourceEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.command.CommandSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.command.CommandSourceEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.SendCommandEvent}.
     * 
     * @param arguments The arguments
     * @param command The command
     * @param game The game
     * @param result The result
     * @param source The source
     * @return A new send command event
     */
public static org.spongepowered.api.event.command.SendCommandEvent createSendCommandEvent(java.lang.String arguments, java.lang.String command, org.spongepowered.api.Game game, org.spongepowered.api.util.command.CommandResult result, org.spongepowered.api.util.command.CommandSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("arguments", arguments);
        values.put("command", command);
        values.put("game", game);
        values.put("result", result);
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.command.SendCommandEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.TabCompleteCommandEvent}.
     * 
     * @param arguments The arguments
     * @param command The command
     * @param game The game
     * @param source The source
     * @param tabCompletions The tab completions
     * @return A new tab complete command event
     */
public static org.spongepowered.api.event.command.TabCompleteCommandEvent createTabCompleteCommandEvent(java.lang.String arguments, java.lang.String command, org.spongepowered.api.Game game, org.spongepowered.api.util.command.CommandSource source, java.util.List<java.lang.String> tabCompletions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("arguments", arguments);
        values.put("command", command);
        values.put("game", game);
        values.put("source", source);
        values.put("tabCompletions", tabCompletions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.command.TabCompleteCommandEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.data.ChangeDataHolderEvent}.
     * 
     * @param game The game
     * @param targetHolder The target holder
     * @return A new change data holder event
     */
public static org.spongepowered.api.event.data.ChangeDataHolderEvent createChangeDataHolderEvent(org.spongepowered.api.Game game, org.spongepowered.api.data.DataHolder targetHolder) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetHolder", targetHolder);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.data.ChangeDataHolderEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange}.
     * 
     * @param endResult The end result
     * @param game The game
     * @param originalChanges The original changes
     * @param targetHolder The target holder
     * @return A new value change change data holder event
     */
public static org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange createChangeDataHolderEventValueChange(org.spongepowered.api.data.DataTransactionResult endResult, org.spongepowered.api.Game game, org.spongepowered.api.data.DataTransactionResult originalChanges, org.spongepowered.api.data.DataHolder targetHolder) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("endResult", endResult);
        values.put("game", game);
        values.put("originalChanges", originalChanges);
        values.put("targetHolder", targetHolder);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AffectEntityEvent}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @return A new affect entity event
     */
public static org.spongepowered.api.event.entity.AffectEntityEvent createAffectEntityEvent(org.spongepowered.api.event.cause.Cause cause, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.AffectEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new breed entity event
     */
public static org.spongepowered.api.event.entity.BreedEntityEvent createBreedEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.BreedEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity breed entity event
     */
public static org.spongepowered.api.event.entity.BreedEntityEvent.SourceEntity createBreedEntityEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.BreedEntityEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param newItemStack The new item stack
     * @param originalItem The original item
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new change entity equipment event
     */
public static org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent createChangeEntityEquipmentEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Slot inventory, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackTransaction> newItemStack, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> originalItem, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("newItemStack", newItemStack);
        values.put("originalItem", originalItem);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHuman}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param newItemStack The new item stack
     * @param originalItem The original item
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target human change entity equipment event
     */
public static org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHuman createChangeEntityEquipmentEventTargetHuman(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Slot inventory, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackTransaction> newItemStack, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> originalItem, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("newItemStack", newItemStack);
        values.put("originalItem", originalItem);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param newItemStack The new item stack
     * @param originalItem The original item
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target living change entity equipment event
     */
public static org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving createChangeEntityEquipmentEventTargetLiving(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Slot inventory, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackTransaction> newItemStack, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> originalItem, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("newItemStack", newItemStack);
        values.put("originalItem", originalItem);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param newItemStack The new item stack
     * @param originalItem The original item
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player change entity equipment event
     */
public static org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer createChangeEntityEquipmentEventTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Slot inventory, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackTransaction> newItemStack, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> originalItem, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("newItemStack", newItemStack);
        values.put("originalItem", originalItem);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param game The game
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new change entity potion effect event
     */
public static org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent createChangeEntityPotionEffectEvent(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.potion.PotionEffect> currentEffects, org.spongepowered.api.Game game, org.spongepowered.api.potion.PotionEffect potionEffect, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("game", game);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param game The game
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new expire change entity potion effect event
     */
public static org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire createChangeEntityPotionEffectEventExpire(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.potion.PotionEffect> currentEffects, org.spongepowered.api.Game game, org.spongepowered.api.potion.PotionEffect potionEffect, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("game", game);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param game The game
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new gain change entity potion effect event
     */
public static org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain createChangeEntityPotionEffectEventGain(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.potion.PotionEffect> currentEffects, org.spongepowered.api.Game game, org.spongepowered.api.potion.PotionEffect potionEffect, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("game", game);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param game The game
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new remove change entity potion effect event
     */
public static org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove createChangeEntityPotionEffectEventRemove(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.potion.PotionEffect> currentEffects, org.spongepowered.api.Game game, org.spongepowered.api.potion.PotionEffect potionEffect, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("game", game);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent createCollideEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent.SourceEntity createCollideEntityEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent.SourceHuman createCollideEntityEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent.SourceLiving createCollideEntityEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent.SourcePlayer createCollideEntityEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CreateEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new create entity event
     */
public static org.spongepowered.api.event.entity.CreateEntityEvent createCreateEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CreateEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CreateEntityEvent.TargetItem}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target item create entity event
     */
public static org.spongepowered.api.event.entity.CreateEntityEvent.TargetItem createCreateEntityEventTargetItem(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Item targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CreateEntityEvent.TargetItem.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent createDamageEntityEvent(double baseDamage, org.spongepowered.api.event.cause.Cause cause, double finalDamage, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, double originalDamage, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceEntity}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent.SourceEntity createDamageEntityEventSourceEntity(double baseDamage, org.spongepowered.api.event.cause.Cause cause, double finalDamage, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, double originalDamage, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceHuman}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent.SourceHuman createDamageEntityEventSourceHuman(double baseDamage, org.spongepowered.api.event.cause.Cause cause, double finalDamage, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, double originalDamage, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceLiving}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent.SourceLiving createDamageEntityEventSourceLiving(double baseDamage, org.spongepowered.api.event.cause.Cause cause, double finalDamage, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, double originalDamage, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourcePlayer}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent.SourcePlayer createDamageEntityEventSourcePlayer(double baseDamage, org.spongepowered.api.event.cause.Cause cause, double finalDamage, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, double originalDamage, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DestructEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param snapshot The snapshot
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new destruct entity event
     */
public static org.spongepowered.api.event.entity.DestructEntityEvent createDestructEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.EntitySnapshot snapshot, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("snapshot", snapshot);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DestructEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent createDismountEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent.SourceEntity createDismountEntityEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent.SourceHuman createDismountEntityEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent.SourceLiving createDismountEntityEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent.SourcePlayer createDismountEntityEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent}.
     * 
     * @param game The game
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent createDisplaceEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move}.
     * 
     * @param game The game
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new move displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Move createDisplaceEntityEventMove(org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetHuman}.
     * 
     * @param game The game
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target human move displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetHuman createDisplaceEntityEventMoveTargetHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetLiving}.
     * 
     * @param game The game
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target living move displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetLiving createDisplaceEntityEventMoveTargetLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetPlayer}.
     * 
     * @param game The game
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player move displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetPlayer createDisplaceEntityEventMoveTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetHuman}.
     * 
     * @param game The game
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target human displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetHuman createDisplaceEntityEventTargetHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetLiving}.
     * 
     * @param game The game
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target living displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetLiving createDisplaceEntityEventTargetLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetPlayer createDisplaceEntityEventTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport}.
     * 
     * @param cause The cause
     * @param game The game
     * @param keepsVelocity The keeps velocity
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param teleporterAgent The teleporter agent
     * @return A new teleport displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport createDisplaceEntityEventTeleport(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, boolean keepsVelocity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.world.TeleporterAgent teleporterAgent) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("keepsVelocity", keepsVelocity);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("teleporterAgent", teleporterAgent);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param keepsVelocity The keeps velocity
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param teleporterAgent The teleporter agent
     * @return A new target human teleport displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetHuman createDisplaceEntityEventTeleportTargetHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, boolean keepsVelocity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.world.TeleporterAgent teleporterAgent) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("keepsVelocity", keepsVelocity);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("teleporterAgent", teleporterAgent);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param keepsVelocity The keeps velocity
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param teleporterAgent The teleporter agent
     * @return A new target living teleport displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetLiving createDisplaceEntityEventTeleportTargetLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, boolean keepsVelocity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.world.TeleporterAgent teleporterAgent) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("keepsVelocity", keepsVelocity);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("teleporterAgent", teleporterAgent);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetPlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param keepsVelocity The keeps velocity
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param teleporterAgent The teleporter agent
     * @return A new target player teleport displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetPlayer createDisplaceEntityEventTeleportTargetPlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, boolean keepsVelocity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.world.TeleporterAgent teleporterAgent) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("keepsVelocity", keepsVelocity);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("teleporterAgent", teleporterAgent);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new entity event
     */
public static org.spongepowered.api.event.entity.EntityEvent createEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.EntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new entity portal event
     */
public static org.spongepowered.api.event.entity.EntityPortalEvent createEntityPortalEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.EntityPortalEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent.Enter}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new enter entity portal event
     */
public static org.spongepowered.api.event.entity.EntityPortalEvent.Enter createEntityPortalEventEnter(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.EntityPortalEvent.Enter.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent.Exit}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new exit entity portal event
     */
public static org.spongepowered.api.event.entity.EntityPortalEvent.Exit createEntityPortalEventExit(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.EntityPortalEvent.Exit.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ExpireEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new expire entity event
     */
public static org.spongepowered.api.event.entity.ExpireEntityEvent createExpireEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ExpireEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ExpireEntityEvent.TargetItem}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target item expire entity event
     */
public static org.spongepowered.api.event.entity.ExpireEntityEvent.TargetItem createExpireEntityEventTargetItem(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Item targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ExpireEntityEvent.TargetItem.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent}.
     * 
     * @param fishHook The fish hook
     * @param game The game
     * @return A new fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent createFishingEvent(org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("fishHook", fishHook);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast}.
     * 
     * @param fishHook The fish hook
     * @param game The game
     * @return A new cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast createFishingEventCast(org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("fishHook", fishHook);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceEntity}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast.SourceEntity createFishingEventCastSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceHuman}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast.SourceHuman createFishingEventCastSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceLiving}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast.SourceLiving createFishingEventCastSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourcePlayer}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast.SourcePlayer createFishingEventCastSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook}.
     * 
     * @param fishHook The fish hook
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook createFishingEventHook(org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceEntity}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook.SourceEntity createFishingEventHookSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceHuman}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook.SourceHuman createFishingEventHookSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceLiving}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook.SourceLiving createFishingEventHookSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourcePlayer}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook.SourcePlayer createFishingEventHookSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract}.
     * 
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param fishHook The fish hook
     * @param game The game
     * @return A new retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract createFishingEventRetract(com.google.common.base.Optional<org.spongepowered.api.entity.Entity> caughtEntity, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> caughtItem, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("fishHook", fishHook);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceEntity}.
     * 
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract.SourceEntity createFishingEventRetractSourceEntity(com.google.common.base.Optional<org.spongepowered.api.entity.Entity> caughtEntity, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> caughtItem, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceHuman}.
     * 
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract.SourceHuman createFishingEventRetractSourceHuman(com.google.common.base.Optional<org.spongepowered.api.entity.Entity> caughtEntity, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> caughtItem, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceLiving}.
     * 
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract.SourceLiving createFishingEventRetractSourceLiving(com.google.common.base.Optional<org.spongepowered.api.entity.Entity> caughtEntity, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> caughtItem, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourcePlayer}.
     * 
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract.SourcePlayer createFishingEventRetractSourcePlayer(com.google.common.base.Optional<org.spongepowered.api.entity.Entity> caughtEntity, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStackSnapshot> caughtItem, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.SourceEntity createFishingEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.SourceHuman createFishingEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.SourceLiving createFishingEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.SourcePlayer createFishingEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent}.
     * 
     * @param cause The cause
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new harvest entity event
     */
public static org.spongepowered.api.event.entity.HarvestEntityEvent createHarvestEntityEvent(org.spongepowered.api.event.cause.Cause cause, int experience, org.spongepowered.api.Game game, int originalExperience, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HarvestEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHuman}.
     * 
     * @param cause The cause
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target human harvest entity event
     */
public static org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHuman createHarvestEntityEventTargetHuman(org.spongepowered.api.event.cause.Cause cause, int experience, org.spongepowered.api.Game game, int originalExperience, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving}.
     * 
     * @param cause The cause
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target living harvest entity event
     */
public static org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving createHarvestEntityEventTargetLiving(org.spongepowered.api.event.cause.Cause cause, int experience, org.spongepowered.api.Game game, int originalExperience, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param experience The experience
     * @param game The game
     * @param keepsInventory The keeps inventory
     * @param keepsLevel The keeps level
     * @param newLevel The new level
     * @param originalExperience The original experience
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player harvest entity event
     */
public static org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer createHarvestEntityEventTargetPlayer(org.spongepowered.api.event.cause.Cause cause, int experience, org.spongepowered.api.Game game, boolean keepsInventory, boolean keepsLevel, int newLevel, int originalExperience, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("experience", experience);
        values.put("game", game);
        values.put("keepsInventory", keepsInventory);
        values.put("keepsLevel", keepsLevel);
        values.put("newLevel", newLevel);
        values.put("originalExperience", originalExperience);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HealEntityEvent}.
     * 
     * @param baseHealAmount The base heal amount
     * @param cause The cause
     * @param finalHealAmount The final heal amount
     * @param game The game
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalHealAmount The original heal amount
     * @param originalHealingAmounts The original healing amounts
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new heal entity event
     */
public static org.spongepowered.api.event.entity.HealEntityEvent createHealEntityEvent(double baseHealAmount, org.spongepowered.api.event.cause.Cause cause, double finalHealAmount, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.health.HealthModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.health.HealthModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, double originalHealAmount, java.util.Map<org.spongepowered.api.event.cause.entity.health.HealthModifier, java.lang.Double> originalHealingAmounts, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("baseHealAmount", baseHealAmount);
        values.put("cause", cause);
        values.put("finalHealAmount", finalHealAmount);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalHealAmount", originalHealAmount);
        values.put("originalHealingAmounts", originalHealingAmounts);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HealEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.IgniteEntityEvent}.
     * 
     * @param fireTicks The fire ticks
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new ignite entity event
     */
public static org.spongepowered.api.event.entity.IgniteEntityEvent createIgniteEntityEvent(int fireTicks, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("fireTicks", fireTicks);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.IgniteEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent createInteractEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new attack interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Attack createInteractEntityEventAttack(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, double originalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Attack.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity attack interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceEntity createInteractEntityEventAttackSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, double originalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human attack interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceHuman createInteractEntityEventAttackSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, double originalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLightning}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source lightning attack interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLightning createInteractEntityEventAttackSourceLightning(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, double originalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.weather.Lightning sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLightning.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living attack interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLiving createInteractEntityEventAttackSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, double originalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player attack interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourcePlayer createInteractEntityEventAttackSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, double originalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source block interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourceBlock createInteractEntityEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourceEntity createInteractEntityEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourceHuman createInteractEntityEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourceLiving createInteractEntityEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourcePlayer createInteractEntityEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use createInteractEntityEventUse(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Use.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceEntity createInteractEntityEventUseSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceHuman createInteractEntityEventUseSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceLiving createInteractEntityEventUseSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourcePlayer createInteractEntityEventUseSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<com.flowpowered.math.vector.Vector3d> interactionPoint, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new leash entity event
     */
public static org.spongepowered.api.event.entity.LeashEntityEvent createLeashEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.LeashEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MountEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param vehicle The vehicle
     * @return A new mount entity event
     */
public static org.spongepowered.api.event.entity.MountEntityEvent createMountEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity vehicle) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("vehicle", vehicle);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.MountEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.PreCreateEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param location The location
     * @param targetType The target type
     * @return A new pre create entity event
     */
public static org.spongepowered.api.event.entity.PreCreateEntityEvent createPreCreateEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> location, org.spongepowered.api.entity.EntityType targetType) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("location", location);
        values.put("targetType", targetType);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.PreCreateEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent createSpawnEntityEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.SpawnEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source block spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent.SourceBlock createSpawnEntityEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.SpawnEntityEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source world spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent.SourceWorld createSpawnEntityEventSourceWorld(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.SpawnEntityEvent.SourceWorld.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target living spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving createSpawnEntityEventTargetLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent createTameEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.TameEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent.SourceEntity createTameEntityEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.TameEntityEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent.SourceHuman createTameEntityEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.TameEntityEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent.SourceLiving createTameEntityEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.TameEntityEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent.SourcePlayer createTameEntityEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.TameEntityEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TargetEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target entity event
     */
public static org.spongepowered.api.event.entity.TargetEntityEvent createTargetEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.TargetEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent}.
     * 
     * @param game The game
     * @param leashHolder The leash holder
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new unleash entity event
     */
public static org.spongepowered.api.event.entity.UnleashEntityEvent createUnleashEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity leashHolder, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("leashHolder", leashHolder);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.UnleashEntityEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.item.ItemMergeItemEvent}.
     * 
     * @param game The game
     * @param itemToMerge The item to merge
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new item merge item event
     */
public static org.spongepowered.api.event.entity.item.ItemMergeItemEvent createItemMergeItemEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Item itemToMerge, org.spongepowered.api.entity.Item targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("itemToMerge", itemToMerge);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.item.ItemMergeItemEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.item.TargetItemEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target item event
     */
public static org.spongepowered.api.event.entity.item.TargetItemEvent createTargetItemEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Item targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.item.TargetItemEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.LivingEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new living event
     */
public static org.spongepowered.api.event.entity.living.LivingEvent createLivingEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.LivingEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.TargetLivingEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target living event
     */
public static org.spongepowered.api.event.entity.living.TargetLivingEvent createTargetLivingEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.TargetLivingEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent}.
     * 
     * @param cause The cause
     * @param currentExperience The current experience
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new change human experience event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent createChangeHumanExperienceEvent(org.spongepowered.api.event.cause.Cause cause, int currentExperience, int experience, org.spongepowered.api.Game game, int originalExperience, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentExperience", currentExperience);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param currentExperience The current experience
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player change human experience event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.TargetPlayer createChangeHumanExperienceEventTargetPlayer(org.spongepowered.api.event.cause.Cause cause, int currentExperience, int experience, org.spongepowered.api.Game game, int originalExperience, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentExperience", currentExperience);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param newGameMode The new game mode
     * @param oldGameMode The old game mode
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new change human game mode event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent createChangeHumanGameModeEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.gamemode.GameMode newGameMode, org.spongepowered.api.entity.living.player.gamemode.GameMode oldGameMode, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("newGameMode", newGameMode);
        values.put("oldGameMode", oldGameMode);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param newGameMode The new game mode
     * @param oldGameMode The old game mode
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player change human game mode event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.TargetPlayer createChangeHumanGameModeEventTargetPlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.gamemode.GameMode newGameMode, org.spongepowered.api.entity.living.player.gamemode.GameMode oldGameMode, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("newGameMode", newGameMode);
        values.put("oldGameMode", oldGameMode);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent}.
     * 
     * @param game The game
     * @param level The level
     * @param newLevel The new level
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new change human level event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent createChangeHumanLevelEvent(org.spongepowered.api.Game game, int level, int newLevel, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("level", level);
        values.put("newLevel", newLevel);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param level The level
     * @param newLevel The new level
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player change human level event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.TargetPlayer createChangeHumanLevelEventTargetPlayer(org.spongepowered.api.Game game, int level, int newLevel, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("level", level);
        values.put("newLevel", newLevel);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new human event
     */
public static org.spongepowered.api.event.entity.living.human.HumanEvent createHumanEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent createHumanSleepEvent(org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.Enter}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new enter human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.Enter createHumanSleepEventEnter(org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.Enter.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer createHumanSleepEventSourcePlayer(org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.Enter}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new enter source player human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.Enter createHumanSleepEventSourcePlayerEnter(org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.Enter.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StartSleeping}.
     * 
     * @param awokenPlayers The awoken players
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param ignoredPlayers The ignored players
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new start sleeping source player human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StartSleeping createHumanSleepEventSourcePlayerStartSleeping(java.util.List<org.spongepowered.api.entity.living.player.Player> awokenPlayers, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.entity.living.player.Player> ignoredPlayers, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("awokenPlayers", awokenPlayers);
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("ignoredPlayers", ignoredPlayers);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StartSleeping.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StopSleeping}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param spawnTransform The spawn transform
     * @return A new stop sleeping source player human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StopSleeping createHumanSleepEventSourcePlayerStopSleeping(org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.google.common.base.Optional<org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World>> spawnTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("spawnTransform", spawnTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StopSleeping.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StartSleeping}.
     * 
     * @param awokenPlayers The awoken players
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param ignoredPlayers The ignored players
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new start sleeping human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StartSleeping createHumanSleepEventStartSleeping(java.util.List<org.spongepowered.api.entity.living.player.Player> awokenPlayers, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.entity.living.player.Player> ignoredPlayers, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("awokenPlayers", awokenPlayers);
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("ignoredPlayers", ignoredPlayers);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StartSleeping.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StopSleeping}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param spawnTransform The spawn transform
     * @return A new stop sleeping human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StopSleeping createHumanSleepEventStopSleeping(org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.google.common.base.Optional<org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World>> spawnTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("spawnTransform", spawnTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StopSleeping.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.TargetHumanEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target human event
     */
public static org.spongepowered.api.event.entity.living.human.TargetHumanEvent createTargetHumanEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.TargetHumanEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerChangeStatisticEvent}.
     * 
     * @param cause The cause
     * @param changedStatistic The changed statistic
     * @param game The game
     * @param newValue The new value
     * @param oldValue The old value
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player change statistic event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerChangeStatisticEvent createPlayerChangeStatisticEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.statistic.Statistic changedStatistic, org.spongepowered.api.Game game, long newValue, long oldValue, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("changedStatistic", changedStatistic);
        values.put("game", game);
        values.put("newValue", newValue);
        values.put("oldValue", oldValue);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerChangeStatisticEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerChatEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param unformattedMessage The unformatted message
     * @return A new player chat event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerChatEvent createPlayerChatEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.entity.living.player.Player source, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.text.Text unformattedMessage) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("newMessage", newMessage);
        values.put("sink", sink);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("unformattedMessage", unformattedMessage);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerChatEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerConnectionEvent}.
     * 
     * @param connection The connection
     * @param game The game
     * @return A new player connection event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerConnectionEvent createPlayerConnectionEvent(org.spongepowered.api.network.PlayerConnection connection, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("connection", connection);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerConnectionEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerConnectionRegisterChannelEvent}.
     * 
     * @param channelRegistered The channel registered
     * @param connection The connection
     * @param game The game
     * @return A new player connection register channel event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerConnectionRegisterChannelEvent createPlayerConnectionRegisterChannelEvent(java.lang.String channelRegistered, org.spongepowered.api.network.PlayerConnection connection, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("channelRegistered", channelRegistered);
        values.put("connection", connection);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerConnectionRegisterChannelEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerConnectionUnregisterChannelEvent}.
     * 
     * @param channelUnregistered The channel unregistered
     * @param connection The connection
     * @param game The game
     * @return A new player connection unregister channel event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerConnectionUnregisterChannelEvent createPlayerConnectionUnregisterChannelEvent(java.lang.String channelUnregistered, org.spongepowered.api.network.PlayerConnection connection, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("channelUnregistered", channelUnregistered);
        values.put("connection", connection);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerConnectionUnregisterChannelEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerEvent createPlayerEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerGainAchievementEvent}.
     * 
     * @param achievement The achievement
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player gain achievement event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerGainAchievementEvent createPlayerGainAchievementEvent(org.spongepowered.api.statistic.achievement.Achievement achievement, org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("achievement", achievement);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerGainAchievementEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerJoinEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player join event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerJoinEvent createPlayerJoinEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.entity.living.player.Player source, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("newMessage", newMessage);
        values.put("sink", sink);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerJoinEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerKickEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player kick event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerKickEvent createPlayerKickEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.entity.living.player.Player source, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("newMessage", newMessage);
        values.put("sink", sink);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerKickEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerMessageEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player message event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerMessageEvent createPlayerMessageEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.entity.living.player.Player source, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("newMessage", newMessage);
        values.put("sink", sink);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerMessageEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerQuitEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player quit event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerQuitEvent createPlayerQuitEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.entity.living.player.Player source, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("newMessage", newMessage);
        values.put("sink", sink);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerQuitEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param pack The pack
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param status The status
     * @return A new player resource pack status event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent createPlayerResourcePackStatusEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.resourcepack.ResourcePack pack, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent.ResourcePackStatus status) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("pack", pack);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("status", status);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.RespawnPlayerEvent}.
     * 
     * @param bedSpawn The bed spawn
     * @param game The game
     * @param originTransform The origin transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new respawn player event
     */
public static org.spongepowered.api.event.entity.living.player.RespawnPlayerEvent createRespawnPlayerEvent(boolean bedSpawn, org.spongepowered.api.Game game, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> originTransform, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("bedSpawn", bedSpawn);
        values.put("game", game);
        values.put("originTransform", originTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.RespawnPlayerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.TargetPlayerEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player event
     */
public static org.spongepowered.api.event.entity.living.player.TargetPlayerEvent createTargetPlayerEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.TargetPlayerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent createLaunchProjectileEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<org.spongepowered.api.entity.projectile.source.ProjectileSource> source, org.spongepowered.api.entity.projectile.Projectile targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("source", source);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceEntity createLaunchProjectileEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<org.spongepowered.api.entity.projectile.source.ProjectileSource> source, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.projectile.Projectile targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceHuman createLaunchProjectileEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<org.spongepowered.api.entity.projectile.source.ProjectileSource> source, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.projectile.Projectile targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceLiving createLaunchProjectileEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<org.spongepowered.api.entity.projectile.source.ProjectileSource> source, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.projectile.Projectile targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourcePlayer createLaunchProjectileEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, com.google.common.base.Optional<org.spongepowered.api.entity.projectile.source.ProjectileSource> source, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.projectile.Projectile targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.TargetProjectileEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target projectile event
     */
public static org.spongepowered.api.event.entity.projectile.TargetProjectileEvent createTargetProjectileEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.Projectile targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.TargetProjectileEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameAboutToStartServerEvent}.
     * 
     * @param game The game
     * @return A new game about to start server event
     */
public static org.spongepowered.api.event.game.state.GameAboutToStartServerEvent createGameAboutToStartServerEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameAboutToStartServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameConstructionEvent}.
     * 
     * @param game The game
     * @return A new game construction event
     */
public static org.spongepowered.api.event.game.state.GameConstructionEvent createGameConstructionEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameConstructionEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameInitializationEvent}.
     * 
     * @param game The game
     * @return A new game initialization event
     */
public static org.spongepowered.api.event.game.state.GameInitializationEvent createGameInitializationEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameInitializationEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameLoadCompleteEvent}.
     * 
     * @param game The game
     * @return A new game load complete event
     */
public static org.spongepowered.api.event.game.state.GameLoadCompleteEvent createGameLoadCompleteEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameLoadCompleteEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GamePostInitializationEvent}.
     * 
     * @param game The game
     * @return A new game post initialization event
     */
public static org.spongepowered.api.event.game.state.GamePostInitializationEvent createGamePostInitializationEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GamePostInitializationEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GamePreInitializationEvent}.
     * 
     * @param game The game
     * @return A new game pre initialization event
     */
public static org.spongepowered.api.event.game.state.GamePreInitializationEvent createGamePreInitializationEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GamePreInitializationEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStartedServerEvent}.
     * 
     * @param game The game
     * @return A new game started server event
     */
public static org.spongepowered.api.event.game.state.GameStartedServerEvent createGameStartedServerEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameStartedServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStartingServerEvent}.
     * 
     * @param game The game
     * @return A new game starting server event
     */
public static org.spongepowered.api.event.game.state.GameStartingServerEvent createGameStartingServerEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameStartingServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStateEvent}.
     * 
     * @param game The game
     * @return A new game state event
     */
public static org.spongepowered.api.event.game.state.GameStateEvent createGameStateEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameStateEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppedServerEvent}.
     * 
     * @param game The game
     * @return A new game stopped server event
     */
public static org.spongepowered.api.event.game.state.GameStoppedServerEvent createGameStoppedServerEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameStoppedServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppingServerEvent}.
     * 
     * @param game The game
     * @return A new game stopping server event
     */
public static org.spongepowered.api.event.game.state.GameStoppingServerEvent createGameStoppingServerEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.state.GameStoppingServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.BlockBrewEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block brew event
     */
public static org.spongepowered.api.event.inventory.BlockBrewEvent createBlockBrewEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStack> result, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("result", result);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.BlockBrewEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.BlockInventoryEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block inventory event
     */
public static org.spongepowered.api.event.inventory.BlockInventoryEvent createBlockInventoryEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.BlockInventoryEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.BulkItemResultEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param results The results
     * @return A new bulk item result event
     */
public static org.spongepowered.api.event.inventory.BulkItemResultEvent createBulkItemResultEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, java.util.List<org.spongepowered.api.item.inventory.ItemStack> results) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("results", results);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.BulkItemResultEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.ContainerEvent}.
     * 
     * @param container The container
     * @param game The game
     * @return A new container event
     */
public static org.spongepowered.api.event.inventory.ContainerEvent createContainerEvent(org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.ContainerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @return A new drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent createDropItemStackEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @return A new post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post createDropItemStackEventPost(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.entity.Item> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceBlock}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceBlock createDropItemStackEventPostSourceBlock(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.entity.Item> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceEntity}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceEntity createDropItemStackEventPostSourceEntity(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.entity.Item> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceHuman}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceHuman createDropItemStackEventPostSourceHuman(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.entity.Item> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceLiving}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceLiving createDropItemStackEventPostSourceLiving(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.entity.Item> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourcePlayer}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourcePlayer createDropItemStackEventPostSourcePlayer(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.entity.Item> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @return A new pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre createDropItemStackEventPre(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceBlock}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceBlock createDropItemStackEventPreSourceBlock(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceEntity}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceEntity createDropItemStackEventPreSourceEntity(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceHuman}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceHuman createDropItemStackEventPreSourceHuman(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceLiving}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceLiving createDropItemStackEventPreSourceLiving(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourcePlayer}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourcePlayer createDropItemStackEventPreSourcePlayer(org.spongepowered.api.event.cause.Cause cause, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourceBlock createDropItemStackEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourceEntity createDropItemStackEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourceHuman createDropItemStackEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourceLiving createDropItemStackEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourcePlayer createDropItemStackEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryClickEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param viewer The viewer
     * @return A new inventory click event
     */
public static org.spongepowered.api.event.inventory.InventoryClickEvent createInventoryClickEvent(org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        values.put("viewer", viewer);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.InventoryClickEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryCloseEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param viewer The viewer
     * @return A new inventory close event
     */
public static org.spongepowered.api.event.inventory.InventoryCloseEvent createInventoryCloseEvent(org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        values.put("viewer", viewer);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.InventoryCloseEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @return A new inventory event
     */
public static org.spongepowered.api.event.inventory.InventoryEvent createInventoryEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.InventoryEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.ItemResultEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param result The result
     * @return A new item result event
     */
public static org.spongepowered.api.event.inventory.ItemResultEvent createItemResultEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, com.google.common.base.Optional<org.spongepowered.api.item.inventory.ItemStack> result) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("result", result);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.ItemResultEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @return A new pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent createPickUpItemEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("items", items);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourceBlock createPickUpItemEventSourceBlock(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.google.common.base.Optional<org.spongepowered.api.util.Direction> sourceSide) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourceBlock.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourceEntity createPickUpItemEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourceHuman createPickUpItemEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourceLiving createPickUpItemEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourcePlayer createPickUpItemEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent createUseItemStackEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new finish use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.Finish createUseItemStackEventFinish(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.Finish.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity createUseItemStackEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new finish source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Finish createUseItemStackEventSourceEntityFinish(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Finish.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new start source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Start createUseItemStackEventSourceEntityStart(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Start.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new stop source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Stop createUseItemStackEventSourceEntityStop(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Stop.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new tick source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Tick createUseItemStackEventSourceEntityTick(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Tick.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman createUseItemStackEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new finish source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Finish createUseItemStackEventSourceHumanFinish(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Finish.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new start source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Start createUseItemStackEventSourceHumanStart(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Start.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new stop source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Stop createUseItemStackEventSourceHumanStop(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Stop.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new tick source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Tick createUseItemStackEventSourceHumanTick(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Tick.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving createUseItemStackEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new finish source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Finish createUseItemStackEventSourceLivingFinish(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Finish.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new start source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Start createUseItemStackEventSourceLivingStart(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Start.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new stop source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Stop createUseItemStackEventSourceLivingStop(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Stop.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new tick source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Tick createUseItemStackEventSourceLivingTick(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Tick.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer createUseItemStackEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new finish source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Finish createUseItemStackEventSourcePlayerFinish(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Finish.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new start source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Start createUseItemStackEventSourcePlayerStart(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Start.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new stop source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Stop createUseItemStackEventSourcePlayerStop(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Stop.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new tick source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Tick createUseItemStackEventSourcePlayerTick(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Tick.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new start use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.Start createUseItemStackEventStart(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.Start.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new stop use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.Stop createUseItemStackEventStop(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.Stop.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new tick use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.Tick createUseItemStackEventTick(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.Tick.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param inventory The inventory
     * @param recipe The recipe
     * @param resultTypes The result types
     * @param results The results
     * @param viewer The viewer
     * @return A new viewer craft item event
     */
public static org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent createViewerCraftItemEvent(org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.crafting.CraftingInventory inventory, org.spongepowered.api.item.recipe.Recipe recipe, java.util.List<org.spongepowered.api.item.ItemType> resultTypes, java.util.List<org.spongepowered.api.item.inventory.ItemStack> results, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("recipe", recipe);
        values.put("resultTypes", resultTypes);
        values.put("results", results);
        values.put("viewer", viewer);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param viewer The viewer
     * @return A new viewer event
     */
public static org.spongepowered.api.event.inventory.viewer.ViewerEvent createViewerEvent(org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        values.put("viewer", viewer);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.viewer.ViewerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerOpenContainerEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param viewer The viewer
     * @return A new viewer open container event
     */
public static org.spongepowered.api.event.inventory.viewer.ViewerOpenContainerEvent createViewerOpenContainerEvent(org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        values.put("viewer", viewer);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.viewer.ViewerOpenContainerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.BanIpEvent}.
     * 
     * @param ban The ban
     * @return A new ban ip event
     */
public static org.spongepowered.api.event.network.BanIpEvent createBanIpEvent(org.spongepowered.api.util.ban.Ban.Ip ban) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("ban", ban);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.network.BanIpEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.GameClientConnectionEvent}.
     * 
     * @param connection The connection
     * @param disconnectCause The disconnect cause
     * @param disconnectMessage The disconnect message
     * @param game The game
     * @param profile The profile
     * @return A new game client connection event
     */
public static org.spongepowered.api.event.network.GameClientConnectionEvent createGameClientConnectionEvent(org.spongepowered.api.network.RemoteConnection connection, com.google.common.base.Optional<org.spongepowered.api.event.cause.Cause> disconnectCause, com.google.common.base.Optional<org.spongepowered.api.text.Text> disconnectMessage, org.spongepowered.api.Game game, org.spongepowered.api.GameProfile profile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("connection", connection);
        values.put("disconnectCause", disconnectCause);
        values.put("disconnectMessage", disconnectMessage);
        values.put("game", game);
        values.put("profile", profile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.network.GameClientConnectionEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.GameClientConnectionEvent.Authenticate}.
     * 
     * @param connection The connection
     * @param disconnectCause The disconnect cause
     * @param disconnectMessage The disconnect message
     * @param game The game
     * @param profile The profile
     * @return A new authenticate game client connection event
     */
public static org.spongepowered.api.event.network.GameClientConnectionEvent.Authenticate createGameClientConnectionEventAuthenticate(org.spongepowered.api.network.RemoteConnection connection, com.google.common.base.Optional<org.spongepowered.api.event.cause.Cause> disconnectCause, com.google.common.base.Optional<org.spongepowered.api.text.Text> disconnectMessage, org.spongepowered.api.Game game, org.spongepowered.api.GameProfile profile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("connection", connection);
        values.put("disconnectCause", disconnectCause);
        values.put("disconnectMessage", disconnectMessage);
        values.put("game", game);
        values.put("profile", profile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.network.GameClientConnectionEvent.Authenticate.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.GameClientConnectionEvent.Login}.
     * 
     * @param connection The connection
     * @param disconnectCause The disconnect cause
     * @param disconnectMessage The disconnect message
     * @param game The game
     * @param profile The profile
     * @return A new login game client connection event
     */
public static org.spongepowered.api.event.network.GameClientConnectionEvent.Login createGameClientConnectionEventLogin(org.spongepowered.api.network.RemoteConnection connection, com.google.common.base.Optional<org.spongepowered.api.event.cause.Cause> disconnectCause, com.google.common.base.Optional<org.spongepowered.api.text.Text> disconnectMessage, org.spongepowered.api.Game game, org.spongepowered.api.GameProfile profile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("connection", connection);
        values.put("disconnectCause", disconnectCause);
        values.put("disconnectMessage", disconnectMessage);
        values.put("game", game);
        values.put("profile", profile);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.network.GameClientConnectionEvent.Login.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.PardonIpEvent}.
     * 
     * @param ban The ban
     * @return A new pardon ip event
     */
public static org.spongepowered.api.event.network.PardonIpEvent createPardonIpEvent(org.spongepowered.api.util.ban.Ban.Ip ban) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("ban", ban);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.network.PardonIpEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.plugin.PluginEvent}.
     * 
     * @param game The game
     * @param plugin The plugin
     * @return A new plugin event
     */
public static org.spongepowered.api.event.plugin.PluginEvent createPluginEvent(org.spongepowered.api.Game game, org.spongepowered.api.plugin.PluginContainer plugin) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("plugin", plugin);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.plugin.PluginEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.plugin.PluginForceChunkEvent}.
     * 
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param game The game
     * @param plugin The plugin
     * @param ticket The ticket
     * @return A new plugin force chunk event
     */
public static org.spongepowered.api.event.plugin.PluginForceChunkEvent createPluginForceChunkEvent(org.spongepowered.api.event.cause.Cause cause, com.flowpowered.math.vector.Vector3i chunkCoords, org.spongepowered.api.Game game, org.spongepowered.api.plugin.PluginContainer plugin, org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket ticket) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("chunkCoords", chunkCoords);
        values.put("game", game);
        values.put("plugin", plugin);
        values.put("ticket", ticket);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.plugin.PluginForceChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.plugin.PluginUnforceChunkEvent}.
     * 
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param game The game
     * @param sourceWorld The source world
     * @param ticket The ticket
     * @return A new plugin unforce chunk event
     */
public static org.spongepowered.api.event.plugin.PluginUnforceChunkEvent createPluginUnforceChunkEvent(org.spongepowered.api.event.cause.Cause cause, com.flowpowered.math.vector.Vector3i chunkCoords, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket ticket) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("chunkCoords", chunkCoords);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("ticket", ticket);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.plugin.PluginUnforceChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.rcon.RconEvent}.
     * 
     * @param source The source
     * @return A new rcon event
     */
public static org.spongepowered.api.event.rcon.RconEvent createRconEvent(org.spongepowered.api.util.command.source.RconSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.rcon.RconEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.rcon.RconLoginEvent}.
     * 
     * @param source The source
     * @return A new rcon login event
     */
public static org.spongepowered.api.event.rcon.RconLoginEvent createRconLoginEvent(org.spongepowered.api.util.command.source.RconSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.rcon.RconLoginEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.rcon.RconQuitEvent}.
     * 
     * @param source The source
     * @return A new rcon quit event
     */
public static org.spongepowered.api.event.rcon.RconQuitEvent createRconQuitEvent(org.spongepowered.api.util.command.source.RconSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.rcon.RconQuitEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.PingServerEvent}.
     * 
     * @param client The client
     * @param game The game
     * @param response The response
     * @param server The server
     * @return A new ping server event
     */
public static org.spongepowered.api.event.server.PingServerEvent createPingServerEvent(org.spongepowered.api.status.StatusClient client, org.spongepowered.api.Game game, org.spongepowered.api.event.server.PingServerEvent.Response response, org.spongepowered.api.Server server) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("client", client);
        values.put("game", game);
        values.put("response", response);
        values.put("server", server);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.PingServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.PingServerEvent.Response}.
     * 
     * @param description The description
     * @param favicon The favicon
     * @param players The players
     * @param version The version
     * @return A new response ping server event
     */
public static org.spongepowered.api.event.server.PingServerEvent.Response createPingServerEventResponse(org.spongepowered.api.text.Text description, com.google.common.base.Optional<org.spongepowered.api.status.Favicon> favicon, com.google.common.base.Optional<org.spongepowered.api.event.server.PingServerEvent.Response.Players> players, org.spongepowered.api.MinecraftVersion version) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("description", description);
        values.put("favicon", favicon);
        values.put("players", players);
        values.put("version", version);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.PingServerEvent.Response.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.PingServerEvent.Response.Players}.
     * 
     * @param max The max
     * @param online The online
     * @param profiles The profiles
     * @return A new players response ping server event
     */
public static org.spongepowered.api.event.server.PingServerEvent.Response.Players createPingServerEventResponsePlayers(int max, int online, java.util.List<org.spongepowered.api.GameProfile> profiles) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("max", max);
        values.put("online", online);
        values.put("profiles", profiles);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.PingServerEvent.Response.Players.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ServerCreateWorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param server The server
     * @param worldCreationSettings The world creation settings
     * @param worldProperties The world properties
     * @return A new server create world event
     */
public static org.spongepowered.api.event.server.ServerCreateWorldEvent createServerCreateWorldEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.Server server, org.spongepowered.api.world.WorldCreationSettings worldCreationSettings, org.spongepowered.api.world.storage.WorldProperties worldProperties) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("server", server);
        values.put("worldCreationSettings", worldCreationSettings);
        values.put("worldProperties", worldProperties);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.ServerCreateWorldEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ServerEvent}.
     * 
     * @param game The game
     * @param server The server
     * @return A new server event
     */
public static org.spongepowered.api.event.server.ServerEvent createServerEvent(org.spongepowered.api.Game game, org.spongepowered.api.Server server) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("server", server);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.ServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.BasicQueryServerEvent}.
     * 
     * @param address The address
     * @param gameType The game type
     * @param map The map
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param motd The motd
     * @param playerCount The player count
     * @param size The size
     * @return A new basic query server event
     */
public static org.spongepowered.api.event.server.query.BasicQueryServerEvent createBasicQueryServerEvent(java.net.InetSocketAddress address, java.lang.String gameType, java.lang.String map, int maxPlayerCount, int maxSize, java.lang.String motd, int playerCount, int size) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("address", address);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("motd", motd);
        values.put("playerCount", playerCount);
        values.put("size", size);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.query.BasicQueryServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.FullQueryServerEvent}.
     * 
     * @param address The address
     * @param customValuesMap The custom values map
     * @param gameId The game id
     * @param gameType The game type
     * @param map The map
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param motd The motd
     * @param playerCount The player count
     * @param players The players
     * @param plugins The plugins
     * @param size The size
     * @param version The version
     * @return A new full query server event
     */
public static org.spongepowered.api.event.server.query.FullQueryServerEvent createFullQueryServerEvent(java.net.InetSocketAddress address, java.util.Map<java.lang.String, java.lang.String> customValuesMap, java.lang.String gameId, java.lang.String gameType, java.lang.String map, int maxPlayerCount, int maxSize, java.lang.String motd, int playerCount, java.util.List<java.lang.String> players, java.lang.String plugins, int size, java.lang.String version) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("address", address);
        values.put("customValuesMap", customValuesMap);
        values.put("gameId", gameId);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("motd", motd);
        values.put("playerCount", playerCount);
        values.put("players", players);
        values.put("plugins", plugins);
        values.put("size", size);
        values.put("version", version);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.query.FullQueryServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.QueryServerEvent}.
     * 
     * @param address The address
     * @param gameType The game type
     * @param map The map
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param motd The motd
     * @param playerCount The player count
     * @param size The size
     * @return A new query server event
     */
public static org.spongepowered.api.event.server.query.QueryServerEvent createQueryServerEvent(java.net.InetSocketAddress address, java.lang.String gameType, java.lang.String map, int maxPlayerCount, int maxSize, java.lang.String motd, int playerCount, int size) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("address", address);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("motd", motd);
        values.put("playerCount", playerCount);
        values.put("size", size);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.query.QueryServerEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.BanUserEvent}.
     * 
     * @param ban The ban
     * @param targetUser The target user
     * @return A new ban user event
     */
public static org.spongepowered.api.event.user.BanUserEvent createBanUserEvent(org.spongepowered.api.util.ban.Ban.User ban, org.spongepowered.api.entity.living.player.User targetUser) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("ban", ban);
        values.put("targetUser", targetUser);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.user.BanUserEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.BanUserEvent.TargetPlayer}.
     * 
     * @param ban The ban
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param targetUser The target user
     * @return A new target player ban user event
     */
public static org.spongepowered.api.event.user.BanUserEvent.TargetPlayer createBanUserEventTargetPlayer(org.spongepowered.api.util.ban.Ban.User ban, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.living.player.User targetUser) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("ban", ban);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("targetUser", targetUser);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.user.BanUserEvent.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.PardonUserEvent}.
     * 
     * @param ban The ban
     * @param targetUser The target user
     * @return A new pardon user event
     */
public static org.spongepowered.api.event.user.PardonUserEvent createPardonUserEvent(org.spongepowered.api.util.ban.Ban.User ban, org.spongepowered.api.entity.living.player.User targetUser) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("ban", ban);
        values.put("targetUser", targetUser);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.user.PardonUserEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.PardonUserEvent.TargetPlayer}.
     * 
     * @param ban The ban
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param targetUser The target user
     * @return A new target player pardon user event
     */
public static org.spongepowered.api.event.user.PardonUserEvent.TargetPlayer createPardonUserEventTargetPlayer(org.spongepowered.api.util.ban.Ban.User ban, org.spongepowered.api.Game game, org.spongepowered.api.entity.living.player.Player targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.living.player.Player targetUser) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("ban", ban);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("targetUser", targetUser);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.user.PardonUserEvent.TargetPlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.TargetUserEvent}.
     * 
     * @param targetUser The target user
     * @return A new target user event
     */
public static org.spongepowered.api.event.user.TargetUserEvent createTargetUserEvent(org.spongepowered.api.entity.living.player.User targetUser) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("targetUser", targetUser);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.user.TargetUserEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ChangeWorldGameRuleEvent}.
     * 
     * @param game The game
     * @param name The name
     * @param newValue The new value
     * @param oldValue The old value
     * @param targetWorld The target world
     * @return A new change world game rule event
     */
public static org.spongepowered.api.event.world.ChangeWorldGameRuleEvent createChangeWorldGameRuleEvent(org.spongepowered.api.Game game, java.lang.String name, java.lang.String newValue, java.lang.String oldValue, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("name", name);
        values.put("newValue", newValue);
        values.put("oldValue", oldValue);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.ChangeWorldGameRuleEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ChangeWorldWeatherEvent}.
     * 
     * @param cause The cause
     * @param duration The duration
     * @param game The game
     * @param initialWeather The initial weather
     * @param resultingWeather The resulting weather
     * @param world The world
     * @return A new change world weather event
     */
public static org.spongepowered.api.event.world.ChangeWorldWeatherEvent createChangeWorldWeatherEvent(org.spongepowered.api.event.cause.Cause cause, int duration, org.spongepowered.api.Game game, org.spongepowered.api.world.weather.Weather initialWeather, org.spongepowered.api.world.weather.Weather resultingWeather, org.spongepowered.api.world.World world) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("duration", duration);
        values.put("game", game);
        values.put("initialWeather", initialWeather);
        values.put("resultingWeather", resultingWeather);
        values.put("world", world);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.ChangeWorldWeatherEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @return A new create portal event
     */
public static org.spongepowered.api.event.world.CreatePortalEvent createCreatePortalEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> portalLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.CreatePortalEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity create portal event
     */
public static org.spongepowered.api.event.world.CreatePortalEvent.SourceEntity createCreatePortalEventSourceEntity(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> portalLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.CreatePortalEvent.SourceEntity.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human create portal event
     */
public static org.spongepowered.api.event.world.CreatePortalEvent.SourceHuman createCreatePortalEventSourceHuman(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> portalLocation, org.spongepowered.api.entity.living.Human sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.CreatePortalEvent.SourceHuman.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living create portal event
     */
public static org.spongepowered.api.event.world.CreatePortalEvent.SourceLiving createCreatePortalEventSourceLiving(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> portalLocation, org.spongepowered.api.entity.living.Living sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.CreatePortalEvent.SourceLiving.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player create portal event
     */
public static org.spongepowered.api.event.world.CreatePortalEvent.SourcePlayer createCreatePortalEventSourcePlayer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> portalLocation, org.spongepowered.api.entity.living.player.Player sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.CreatePortalEvent.SourcePlayer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreateWorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param worldCreationSettings The world creation settings
     * @param worldProperties The world properties
     * @return A new create world event
     */
public static org.spongepowered.api.event.world.CreateWorldEvent createCreateWorldEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.WorldCreationSettings worldCreationSettings, org.spongepowered.api.world.storage.WorldProperties worldProperties) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("worldCreationSettings", worldCreationSettings);
        values.put("worldProperties", worldProperties);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.CreateWorldEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.LoadWorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetWorld The target world
     * @return A new load world event
     */
public static org.spongepowered.api.event.world.LoadWorldEvent createLoadWorldEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.LoadWorldEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.LoadWorldEvent.SourcePlugin}.
     * 
     * @param cause The cause
     * @param game The game
     * @param plugin The plugin
     * @param targetWorld The target world
     * @return A new source plugin load world event
     */
public static org.spongepowered.api.event.world.LoadWorldEvent.SourcePlugin createLoadWorldEventSourcePlugin(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.plugin.PluginContainer plugin, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("plugin", plugin);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.LoadWorldEvent.SourcePlugin.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.LoadWorldEvent.SourceServer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param server The server
     * @param targetWorld The target world
     * @return A new source server load world event
     */
public static org.spongepowered.api.event.world.LoadWorldEvent.SourceServer createLoadWorldEventSourceServer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.Server server, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("server", server);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.LoadWorldEvent.SourceServer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.UnloadWorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetWorld The target world
     * @return A new unload world event
     */
public static org.spongepowered.api.event.world.UnloadWorldEvent createUnloadWorldEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.UnloadWorldEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.UnloadWorldEvent.SourcePlugin}.
     * 
     * @param cause The cause
     * @param game The game
     * @param plugin The plugin
     * @param targetWorld The target world
     * @return A new source plugin unload world event
     */
public static org.spongepowered.api.event.world.UnloadWorldEvent.SourcePlugin createUnloadWorldEventSourcePlugin(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.plugin.PluginContainer plugin, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("plugin", plugin);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.UnloadWorldEvent.SourcePlugin.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.UnloadWorldEvent.SourceServer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param server The server
     * @param targetWorld The target world
     * @return A new source server unload world event
     */
public static org.spongepowered.api.event.world.UnloadWorldEvent.SourceServer createUnloadWorldEventSourceServer(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.Server server, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("server", server);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.UnloadWorldEvent.SourceServer.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @return A new world event
     */
public static org.spongepowered.api.event.world.WorldEvent createWorldEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent}.
     * 
     * @param cause The cause
     * @param explosion The explosion
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new world explosion event
     */
public static org.spongepowered.api.event.world.WorldExplosionEvent createWorldExplosionEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.world.explosion.Explosion explosion, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldExplosionEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent.Detonate}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param explosion The explosion
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new detonate world explosion event
     */
public static org.spongepowered.api.event.world.WorldExplosionEvent.Detonate createWorldExplosionEventDetonate(org.spongepowered.api.event.cause.Cause cause, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.world.explosion.Explosion explosion, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("explosion", explosion);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldExplosionEvent.Detonate.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent.Pre}.
     * 
     * @param cause The cause
     * @param explosion The explosion
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new pre world explosion event
     */
public static org.spongepowered.api.event.world.WorldExplosionEvent.Pre createWorldExplosionEventPre(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.world.explosion.Explosion explosion, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldExplosionEvent.Pre.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new world generate chunk event
     */
public static org.spongepowered.api.event.world.WorldGenerateChunkEvent createWorldGenerateChunkEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldGenerateChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent.Post}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new post world generate chunk event
     */
public static org.spongepowered.api.event.world.WorldGenerateChunkEvent.Post createWorldGenerateChunkEventPost(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldGenerateChunkEvent.Post.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent.Pre}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new pre world generate chunk event
     */
public static org.spongepowered.api.event.world.WorldGenerateChunkEvent.Pre createWorldGenerateChunkEventPre(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldGenerateChunkEvent.Pre.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldTickBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new world tick block event
     */
public static org.spongepowered.api.event.world.WorldTickBlockEvent createWorldTickBlockEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldTickBlockEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ChangeChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new change chunk event
     */
public static org.spongepowered.api.event.world.chunk.ChangeChunkEvent createChangeChunkEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.ChangeChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ChangeChunkEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world change chunk event
     */
public static org.spongepowered.api.event.world.chunk.ChangeChunkEvent.SourceWorld createChangeChunkEventSourceWorld(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.ChangeChunkEvent.SourceWorld.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ForcedChunkEvent}.
     * 
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param game The game
     * @param targetChunk The target chunk
     * @param ticket The ticket
     * @return A new forced chunk event
     */
public static org.spongepowered.api.event.world.chunk.ForcedChunkEvent createForcedChunkEvent(org.spongepowered.api.event.cause.Cause cause, com.flowpowered.math.vector.Vector3i chunkCoords, org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk, org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket ticket) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("chunkCoords", chunkCoords);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        values.put("ticket", ticket);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.ForcedChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.LoadChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new load chunk event
     */
public static org.spongepowered.api.event.world.chunk.LoadChunkEvent createLoadChunkEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.LoadChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.LoadChunkEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world load chunk event
     */
public static org.spongepowered.api.event.world.chunk.LoadChunkEvent.SourceWorld createLoadChunkEventSourceWorld(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.LoadChunkEvent.SourceWorld.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new populate chunk event
     */
public static org.spongepowered.api.event.world.chunk.PopulateChunkEvent createPopulateChunkEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.PopulateChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Populate}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new populate populate chunk event
     */
public static org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Populate createPopulateChunkEventPopulate(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Populate.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Post}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new post populate chunk event
     */
public static org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Post createPopulateChunkEventPost(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Post.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Pre}.
     * 
     * @param cause The cause
     * @param game The game
     * @param pendingPopulators The pending populators
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new pre populate chunk event
     */
public static org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Pre createPopulateChunkEventPre(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.world.gen.Populator> pendingPopulators, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("pendingPopulators", pendingPopulators);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Pre.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnforcedChunkEvent}.
     * 
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param game The game
     * @param ticket The ticket
     * @return A new unforced chunk event
     */
public static org.spongepowered.api.event.world.chunk.UnforcedChunkEvent createUnforcedChunkEvent(org.spongepowered.api.event.cause.Cause cause, com.flowpowered.math.vector.Vector3i chunkCoords, org.spongepowered.api.Game game, org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket ticket) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("chunkCoords", chunkCoords);
        values.put("game", game);
        values.put("ticket", ticket);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.UnforcedChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnloadChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new unload chunk event
     */
public static org.spongepowered.api.event.world.chunk.UnloadChunkEvent createUnloadChunkEvent(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.UnloadChunkEvent.class, values);
    }

    /** 
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnloadChunkEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world unload chunk event
     */
public static org.spongepowered.api.event.world.chunk.UnloadChunkEvent.SourceWorld createUnloadChunkEventSourceWorld(org.spongepowered.api.event.cause.Cause cause, org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.UnloadChunkEvent.SourceWorld.class, values);
    }
}


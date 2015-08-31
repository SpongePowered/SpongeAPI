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
    private static final org.spongepowered.api.util.event.factory.ClassGeneratorProvider factoryProvider;

    private static final com.google.common.cache.LoadingCache<java.lang.Class<?>, org.spongepowered.api.util.event.factory.EventFactory<?>> factories;

    private static final java.util.List<org.spongepowered.api.util.event.factory.EventFactoryPlugin> plugins = new java.util.ArrayList<org.spongepowered.api.util.event.factory.EventFactoryPlugin>();

    static {
        factoryProvider = new org.spongepowered.api.util.event.factory.ClassGeneratorProvider("org.spongepowered.api.event.impl");
        factoryProvider.setNullPolicy(org.spongepowered.api.util.event.factory.NullPolicy.NON_NULL_BY_DEFAULT);
        plugins.add(0, new org.spongepowered.api.util.event.factory.plugin.AnnotationEventFactoryPlugin());
        plugins.add(0, new org.spongepowered.api.util.event.factory.plugin.AccessorModifierEventFactoryPlugin("org.spongepowered.api.event.impl.base"));
        factories = com.google.common.cache.CacheBuilder.newBuilder().build(new com.google.common.cache.CacheLoader<java.lang.Class<?>, org.spongepowered.api.util.event.factory.EventFactory<?>>() {
            @java.lang.Override
            public org.spongepowered.api.util.event.factory.EventFactory<?> load(java.lang.Class<?> type) {
                return org.spongepowered.api.event.SpongeEventFactory.factoryProvider.create(type, org.spongepowered.api.event.SpongeEventFactory.getBaseClass(type));
            }
        });
    }

    private SpongeEventFactory() {
    }

    private static java.lang.Class<?> getBaseClass(java.lang.Class<?> event) {
        java.lang.Class<?> superClass = null;
        for (org.spongepowered.api.util.event.factory.EventFactoryPlugin plugin : plugins) {
            superClass = plugin.resolveSuperClassFor(event, superClass, factoryProvider.getClassLoader());
        }
        return superClass;
    }

    /**
     * Adds an {@link EventFactoryPlugin} to the chain of plugins.
     *
     * <p>The plugin chain is in LIFO order.</p>
     *
     * @param plugin The {@link EventFactoryPlugin} to add to the chain
     */
public static void addEventFactoryPlugin(org.spongepowered.api.util.event.factory.EventFactoryPlugin plugin) {
        plugins.add(0, plugin);
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
        return ((T)(factories.getUnchecked(type).apply(values)));
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
     * @param game The game
     * @param interactionPoint The interaction point
     * @return A new interact event
     */
public static org.spongepowered.api.event.action.InteractEvent createInteractEvent(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @return A new attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent createAttackBlockEvent(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceEntity}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent.SourceEntity createAttackBlockEventSourceEntity(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceHuman}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent.SourceHuman createAttackBlockEventSourceHuman(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceLiving}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent.SourceLiving createAttackBlockEventSourceLiving(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourcePlayer}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player attack block event
     */
public static org.spongepowered.api.event.block.AttackBlockEvent.SourcePlayer createAttackBlockEventSourcePlayer(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.AttackBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BlockEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @return A new block event
     */
public static org.spongepowered.api.event.block.BlockEvent createBlockEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BlockMoveBlockEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param targetBlock The target block
     * @param newTargetLocation The new target location
     * @param originalTargetLocation The original target location
     * @return A new block move block event
     */
public static org.spongepowered.api.event.block.BlockMoveBlockEvent createBlockMoveBlockEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> newTargetLocation, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> originalTargetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("targetBlock", targetBlock);
        values.put("newTargetLocation", newTargetLocation);
        values.put("originalTargetLocation", originalTargetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BlockMoveBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent}.
     *
     * @param game The game
     * @param transactions The transactions
     * @return A new break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent createBreakBlockEvent(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceBlock}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @return A new source block break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourceBlock createBreakBlockEventSourceBlock(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceEntity}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourceEntity createBreakBlockEventSourceEntity(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceHuman}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourceHuman createBreakBlockEventSourceHuman(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceLiving}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourceLiving createBreakBlockEventSourceLiving(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourcePlayer}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player break block event
     */
public static org.spongepowered.api.event.block.BreakBlockEvent.SourcePlayer createBreakBlockEventSourcePlayer(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.BreakBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent}.
     *
     * @param game The game
     * @param transactions The transactions
     * @return A new change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent createChangeBlockEvent(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceBlock}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param transactions The transactions
     * @return A new source block change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceBlock createChangeBlockEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceEntity}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceEntity createChangeBlockEventSourceEntity(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceHuman}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceHuman createChangeBlockEventSourceHuman(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceLiving}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceLiving createChangeBlockEventSourceLiving(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourcePlayer}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourcePlayer createChangeBlockEventSourcePlayer(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceWorld}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceWorld The source world
     * @return A new source world change block event
     */
public static org.spongepowered.api.event.block.ChangeBlockEvent.SourceWorld createChangeBlockEventSourceWorld(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.world.World sourceWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceWorld", sourceWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.ChangeBlockEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent}.
     *
     * @param game The game
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @return A new collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent createCollideBlockEvent(org.spongepowered.api.Game game, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceEntity}.
     *
     * @param game The game
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent.SourceEntity createCollideBlockEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceHuman}.
     *
     * @param game The game
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent.SourceHuman createCollideBlockEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceLiving}.
     *
     * @param game The game
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent.SourceLiving createCollideBlockEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourcePlayer}.
     *
     * @param game The game
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player collide block event
     */
public static org.spongepowered.api.event.block.CollideBlockEvent.SourcePlayer createCollideBlockEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.CollideBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent}.
     *
     * @param game The game
     * @param experience The experience
     * @param originalExperience The original experience
     * @param dropChance The drop chance
     * @param originalDropChance The original drop chance
     * @param itemStacks The item stacks
     * @param originalItemStacks The original item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param items The items
     * @return A new harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent createHarvestBlockEvent(org.spongepowered.api.Game game, int experience, int originalExperience, float dropChance, float originalDropChance, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> items) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("dropChance", dropChance);
        values.put("originalDropChance", originalDropChance);
        values.put("itemStacks", itemStacks);
        values.put("originalItemStacks", originalItemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("items", items);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceBlock}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param experience The experience
     * @param originalExperience The original experience
     * @param dropChance The drop chance
     * @param originalDropChance The original drop chance
     * @param itemStacks The item stacks
     * @param originalItemStacks The original item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param items The items
     * @return A new source block harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourceBlock createHarvestBlockEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, int experience, int originalExperience, float dropChance, float originalDropChance, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> items) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("dropChance", dropChance);
        values.put("originalDropChance", originalDropChance);
        values.put("itemStacks", itemStacks);
        values.put("originalItemStacks", originalItemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("items", items);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceEntity}.
     *
     * @param game The game
     * @param experience The experience
     * @param originalExperience The original experience
     * @param dropChance The drop chance
     * @param originalDropChance The original drop chance
     * @param itemStacks The item stacks
     * @param originalItemStacks The original item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param items The items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourceEntity createHarvestBlockEventSourceEntity(org.spongepowered.api.Game game, int experience, int originalExperience, float dropChance, float originalDropChance, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> items, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("dropChance", dropChance);
        values.put("originalDropChance", originalDropChance);
        values.put("itemStacks", itemStacks);
        values.put("originalItemStacks", originalItemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceHuman}.
     *
     * @param game The game
     * @param experience The experience
     * @param originalExperience The original experience
     * @param dropChance The drop chance
     * @param originalDropChance The original drop chance
     * @param itemStacks The item stacks
     * @param originalItemStacks The original item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param items The items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourceHuman createHarvestBlockEventSourceHuman(org.spongepowered.api.Game game, int experience, int originalExperience, float dropChance, float originalDropChance, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> items, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("dropChance", dropChance);
        values.put("originalDropChance", originalDropChance);
        values.put("itemStacks", itemStacks);
        values.put("originalItemStacks", originalItemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceLiving}.
     *
     * @param game The game
     * @param experience The experience
     * @param originalExperience The original experience
     * @param dropChance The drop chance
     * @param originalDropChance The original drop chance
     * @param itemStacks The item stacks
     * @param originalItemStacks The original item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param items The items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourceLiving createHarvestBlockEventSourceLiving(org.spongepowered.api.Game game, int experience, int originalExperience, float dropChance, float originalDropChance, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> items, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("dropChance", dropChance);
        values.put("originalDropChance", originalDropChance);
        values.put("itemStacks", itemStacks);
        values.put("originalItemStacks", originalItemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourcePlayer}.
     *
     * @param game The game
     * @param experience The experience
     * @param originalExperience The original experience
     * @param dropChance The drop chance
     * @param originalDropChance The original drop chance
     * @param itemStacks The item stacks
     * @param originalItemStacks The original item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param items The items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player harvest block event
     */
public static org.spongepowered.api.event.block.HarvestBlockEvent.SourcePlayer createHarvestBlockEventSourcePlayer(org.spongepowered.api.Game game, int experience, int originalExperience, float dropChance, float originalDropChance, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> itemStacks, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> originalItemStacks, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, java.util.Collection<org.spongepowered.api.item.inventory.ItemStack> items, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("dropChance", dropChance);
        values.put("originalDropChance", originalDropChance);
        values.put("itemStacks", itemStacks);
        values.put("originalItemStacks", originalItemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.HarvestBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @return A new interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent createInteractBlockEvent(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceBlock}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @return A new source block interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourceBlock createInteractBlockEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceEntity}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourceEntity createInteractBlockEventSourceEntity(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceHuman}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourceHuman createInteractBlockEventSourceHuman(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceLiving}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourceLiving createInteractBlockEventSourceLiving(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourcePlayer}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.SourcePlayer createInteractBlockEventSourcePlayer(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @return A new use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use createInteractBlockEventUse(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceBlock}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @return A new source block use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceBlock createInteractBlockEventUseSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceEntity}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceEntity createInteractBlockEventUseSourceEntity(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceHuman}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceHuman createInteractBlockEventUseSourceHuman(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceLiving}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceLiving createInteractBlockEventUseSourceLiving(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourcePlayer}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @param targetLocation The target location
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player use interact block event
     */
public static org.spongepowered.api.event.block.InteractBlockEvent.Use.SourcePlayer createInteractBlockEventUseSourcePlayer(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.block.BlockSnapshot targetBlock, org.spongepowered.api.util.Direction targetSide, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        values.put("targetLocation", targetLocation);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.InteractBlockEvent.Use.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent}.
     *
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent createNotifyNeighborBlockEvent(org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new burn notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn createNotifyNeighborBlockEventBurn(org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param transactions The transactions
     * @return A new source block burn notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn.SourceBlock createNotifyNeighborBlockEventBurnSourceBlock(org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite}.
     *
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new ignite notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite createNotifyNeighborBlockEventIgnite(org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param transactions The transactions
     * @return A new source block ignite notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite.SourceBlock createNotifyNeighborBlockEventIgniteSourceBlock(org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power}.
     *
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new power notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power createNotifyNeighborBlockEventPower(org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param transactions The transactions
     * @return A new source block power notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power.SourceBlock createNotifyNeighborBlockEventPowerSourceBlock(org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.SourceBlock}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param transactions The transactions
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new source block notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.SourceBlock createNotifyNeighborBlockEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("transactions", transactions);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread}.
     *
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param spreadingBlock The spreading block
     * @return A new spread notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread createNotifyNeighborBlockEventSpread(org.spongepowered.api.Game game, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.block.BlockState spreadingBlock) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param transactions The transactions
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param spreadingBlock The spreading block
     * @return A new source block spread notify neighbor block event
     */
public static org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread.SourceBlock createNotifyNeighborBlockEventSpreadSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> originalRelatives, java.util.Map<org.spongepowered.api.util.Direction, org.spongepowered.api.block.BlockState> relatives, org.spongepowered.api.block.BlockState spreadingBlock) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("transactions", transactions);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("spreadingBlock", spreadingBlock);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent}.
     *
     * @param game The game
     * @param transactions The transactions
     * @return A new place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent createPlaceBlockEvent(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceBlock}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param transactions The transactions
     * @return A new source block place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourceBlock createPlaceBlockEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("transactions", transactions);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceEntity}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourceEntity createPlaceBlockEventSourceEntity(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceHuman}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourceHuman createPlaceBlockEventSourceHuman(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceLiving}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourceLiving createPlaceBlockEventSourceLiving(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourcePlayer}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player place block event
     */
public static org.spongepowered.api.event.block.PlaceBlockEvent.SourcePlayer createPlaceBlockEventSourcePlayer(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.PlaceBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param tile The tile
     * @param inventory The inventory
     * @param results The results
     * @param brewedItems The brewed items
     * @param sourceItems The source items
     * @param fuelSource The fuel source
     * @return A new brewing stand brew items event
     */
public static org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent createBrewingStandBrewItemsEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.block.tileentity.TileEntity tile, org.spongepowered.api.item.inventory.Inventory inventory, java.util.List<org.spongepowered.api.item.inventory.ItemStack> results, java.util.List<org.spongepowered.api.item.inventory.ItemStack> brewedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStack> sourceItems, org.spongepowered.api.item.inventory.ItemStack fuelSource) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("tile", tile);
        values.put("inventory", inventory);
        values.put("results", results);
        values.put("brewedItems", brewedItems);
        values.put("sourceItems", sourceItems);
        values.put("fuelSource", fuelSource);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingStandEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param tile The tile
     * @param inventory The inventory
     * @return A new brewing stand event
     */
public static org.spongepowered.api.event.block.tileentity.BrewingStandEvent createBrewingStandEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.block.tileentity.TileEntity tile, org.spongepowered.api.item.inventory.Inventory inventory) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("tile", tile);
        values.put("inventory", inventory);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.BrewingStandEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param tile The tile
     * @param inventory The inventory
     * @param result The result
     * @param remainingFuel The remaining fuel
     * @param burnedItem The burned item
     * @return A new furnace consume fuel event
     */
public static org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent createFurnaceConsumeFuelEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.block.tileentity.TileEntity tile, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.item.inventory.ItemStack result, org.spongepowered.api.item.inventory.ItemStack remainingFuel, org.spongepowered.api.item.inventory.ItemStack burnedItem) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("tile", tile);
        values.put("inventory", inventory);
        values.put("result", result);
        values.put("remainingFuel", remainingFuel);
        values.put("burnedItem", burnedItem);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param tile The tile
     * @param inventory The inventory
     * @return A new furnace event
     */
public static org.spongepowered.api.event.block.tileentity.FurnaceEvent createFurnaceEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.block.tileentity.TileEntity tile, org.spongepowered.api.item.inventory.Inventory inventory) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("tile", tile);
        values.put("inventory", inventory);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.FurnaceEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param tile The tile
     * @param inventory The inventory
     * @param result The result
     * @param cookedItem The cooked item
     * @param sourceItem The source item
     * @return A new furnace smelt item event
     */
public static org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent createFurnaceSmeltItemEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.block.tileentity.TileEntity tile, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.item.inventory.ItemStack result, org.spongepowered.api.item.inventory.ItemStack cookedItem, org.spongepowered.api.item.inventory.ItemStack sourceItem) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("tile", tile);
        values.put("inventory", inventory);
        values.put("result", result);
        values.put("cookedItem", cookedItem);
        values.put("sourceItem", sourceItem);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.TileEntityEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param tile The tile
     * @return A new tile entity event
     */
public static org.spongepowered.api.event.block.tileentity.TileEntityEvent createTileEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.block.tileentity.TileEntity tile) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
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
     * @param game The game
     * @param source The source
     * @param arguments The arguments
     * @param command The command
     * @param result The result
     * @return A new send command event
     */
public static org.spongepowered.api.event.command.SendCommandEvent createSendCommandEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.command.CommandSource source, java.lang.String arguments, java.lang.String command, org.spongepowered.api.util.command.CommandResult result) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        values.put("arguments", arguments);
        values.put("command", command);
        values.put("result", result);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.command.SendCommandEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.TabCompleteCommandEvent}.
     *
     * @param game The game
     * @param source The source
     * @param arguments The arguments
     * @param command The command
     * @param tabCompletions The tab completions
     * @return A new tab complete command event
     */
public static org.spongepowered.api.event.command.TabCompleteCommandEvent createTabCompleteCommandEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.command.CommandSource source, java.lang.String arguments, java.lang.String command, java.util.List<java.lang.String> tabCompletions) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        values.put("arguments", arguments);
        values.put("command", command);
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
     * @param game The game
     * @param targetHolder The target holder
     * @param endResult The end result
     * @param originalChanges The original changes
     * @return A new value change change data holder event
     */
public static org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange createChangeDataHolderEventValueChange(org.spongepowered.api.Game game, org.spongepowered.api.data.DataHolder targetHolder, org.spongepowered.api.data.DataTransactionResult endResult, org.spongepowered.api.data.DataTransactionResult originalChanges) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetHolder", targetHolder);
        values.put("endResult", endResult);
        values.put("originalChanges", originalChanges);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AffectEntityEvent}.
     *
     * @param game The game
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @return A new affect entity event
     */
public static org.spongepowered.api.event.entity.AffectEntityEvent createAffectEntityEvent(org.spongepowered.api.Game game, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.AffectEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AttackEntityEvent}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @return A new attack entity event
     */
public static org.spongepowered.api.event.entity.AttackEntityEvent createAttackEntityEvent(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.AttackEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AttackEntityEvent.SourceEntity}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity attack entity event
     */
public static org.spongepowered.api.event.entity.AttackEntityEvent.SourceEntity createAttackEntityEventSourceEntity(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.AttackEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AttackEntityEvent.SourceHuman}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human attack entity event
     */
public static org.spongepowered.api.event.entity.AttackEntityEvent.SourceHuman createAttackEntityEventSourceHuman(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.AttackEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AttackEntityEvent.SourceLightning}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source lightning attack entity event
     */
public static org.spongepowered.api.event.entity.AttackEntityEvent.SourceLightning createAttackEntityEventSourceLightning(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.AttackEntityEvent.SourceLightning.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AttackEntityEvent.SourceLiving}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living attack entity event
     */
public static org.spongepowered.api.event.entity.AttackEntityEvent.SourceLiving createAttackEntityEventSourceLiving(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.AttackEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AttackEntityEvent.SourcePlayer}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player attack entity event
     */
public static org.spongepowered.api.event.entity.AttackEntityEvent.SourcePlayer createAttackEntityEventSourcePlayer(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.AttackEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new breed entity event
     */
public static org.spongepowered.api.event.entity.BreedEntityEvent createBreedEntityEvent(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity breed entity event
     */
public static org.spongepowered.api.event.entity.BreedEntityEvent.SourceEntity createBreedEntityEventSourceEntity(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.BreedEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param inventory The inventory
     * @param newItemStack The new item stack
     * @param originalItem The original item
     * @return A new change entity equipment event
     */
public static org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent createChangeEntityEquipmentEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.item.inventory.ItemStackTransaction newItemStack, org.spongepowered.api.item.inventory.ItemStackSnapshot originalItem) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("inventory", inventory);
        values.put("newItemStack", newItemStack);
        values.put("originalItem", originalItem);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHuman}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param inventory The inventory
     * @param newItemStack The new item stack
     * @param originalItem The original item
     * @return A new target human change entity equipment event
     */
public static org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHuman createChangeEntityEquipmentEventTargetHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.item.inventory.ItemStackTransaction newItemStack, org.spongepowered.api.item.inventory.ItemStackSnapshot originalItem) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("inventory", inventory);
        values.put("newItemStack", newItemStack);
        values.put("originalItem", originalItem);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param inventory The inventory
     * @param newItemStack The new item stack
     * @param originalItem The original item
     * @return A new target living change entity equipment event
     */
public static org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving createChangeEntityEquipmentEventTargetLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.item.inventory.ItemStackTransaction newItemStack, org.spongepowered.api.item.inventory.ItemStackSnapshot originalItem) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("inventory", inventory);
        values.put("newItemStack", newItemStack);
        values.put("originalItem", originalItem);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param inventory The inventory
     * @param newItemStack The new item stack
     * @param originalItem The original item
     * @return A new target player change entity equipment event
     */
public static org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer createChangeEntityEquipmentEventTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.item.inventory.ItemStackTransaction newItemStack, org.spongepowered.api.item.inventory.ItemStackSnapshot originalItem) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("inventory", inventory);
        values.put("newItemStack", newItemStack);
        values.put("originalItem", originalItem);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @return A new change entity potion effect event
     */
public static org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent createChangeEntityPotionEffectEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, java.util.List<org.spongepowered.api.potion.PotionEffect> currentEffects, org.spongepowered.api.potion.PotionEffect potionEffect) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("currentEffects", currentEffects);
        values.put("potionEffect", potionEffect);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @return A new expire change entity potion effect event
     */
public static org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire createChangeEntityPotionEffectEventExpire(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, java.util.List<org.spongepowered.api.potion.PotionEffect> currentEffects, org.spongepowered.api.potion.PotionEffect potionEffect) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("currentEffects", currentEffects);
        values.put("potionEffect", potionEffect);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @return A new gain change entity potion effect event
     */
public static org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain createChangeEntityPotionEffectEventGain(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, java.util.List<org.spongepowered.api.potion.PotionEffect> currentEffects, org.spongepowered.api.potion.PotionEffect potionEffect) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("currentEffects", currentEffects);
        values.put("potionEffect", potionEffect);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @return A new remove change entity potion effect event
     */
public static org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove createChangeEntityPotionEffectEventRemove(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, java.util.List<org.spongepowered.api.potion.PotionEffect> currentEffects, org.spongepowered.api.potion.PotionEffect potionEffect) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("currentEffects", currentEffects);
        values.put("potionEffect", potionEffect);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent createCollideEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent.SourceEntity createCollideEntityEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceHuman}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent.SourceHuman createCollideEntityEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceLiving}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent.SourceLiving createCollideEntityEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourcePlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player collide entity event
     */
public static org.spongepowered.api.event.entity.CollideEntityEvent.SourcePlayer createCollideEntityEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.CollideEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CreateEntityEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new create entity event
     */
public static org.spongepowered.api.event.entity.CreateEntityEvent createCreateEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target item create entity event
     */
public static org.spongepowered.api.event.entity.CreateEntityEvent.TargetItem createCreateEntityEventTargetItem(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @return A new damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent createDamageEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceEntity}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent.SourceEntity createDamageEntityEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceHuman}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent.SourceHuman createDamageEntityEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceLiving}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent.SourceLiving createDamageEntityEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourcePlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseDamage The base damage
     * @param finalDamage The final damage
     * @param originalDamage The original damage
     * @param originalFinalDamage The original final damage
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalDamages The original damages
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player damage entity event
     */
public static org.spongepowered.api.event.entity.DamageEntityEvent.SourcePlayer createDamageEntityEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseDamage, double finalDamage, double originalDamage, double originalFinalDamage, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> modifiers, java.util.List<org.spongepowered.api.util.Tuple<org.spongepowered.api.event.cause.entity.damage.DamageModifier, com.google.common.base.Function<? super java.lang.Double, java.lang.Double>>> originalFunctions, java.util.Map<org.spongepowered.api.event.cause.entity.damage.DamageModifier, java.lang.Double> originalDamages, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseDamage", baseDamage);
        values.put("finalDamage", finalDamage);
        values.put("originalDamage", originalDamage);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalDamages", originalDamages);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DamageEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DestructEntityEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param snapshot The snapshot
     * @return A new destruct entity event
     */
public static org.spongepowered.api.event.entity.DestructEntityEvent createDestructEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.EntitySnapshot snapshot) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("snapshot", snapshot);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DestructEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent createDismountEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent.SourceEntity createDismountEntityEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceHuman}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent.SourceHuman createDismountEntityEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceLiving}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent.SourceLiving createDismountEntityEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourcePlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player dismount entity event
     */
public static org.spongepowered.api.event.entity.DismountEntityEvent.SourcePlayer createDismountEntityEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DismountEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @return A new displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent createDisplaceEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @return A new move displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Move createDisplaceEntityEventMove(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetHuman}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @return A new target human move displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetHuman createDisplaceEntityEventMoveTargetHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetLiving}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @return A new target living move displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetLiving createDisplaceEntityEventMoveTargetLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetPlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @return A new target player move displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetPlayer createDisplaceEntityEventMoveTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetHuman}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @return A new target human displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetHuman createDisplaceEntityEventTargetHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetLiving}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @return A new target living displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetLiving createDisplaceEntityEventTargetLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetPlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @return A new target player displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetPlayer createDisplaceEntityEventTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param keepsVelocity The keeps velocity
     * @param teleporterAgent The teleporter agent
     * @return A new teleport displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport createDisplaceEntityEventTeleport(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, boolean keepsVelocity, org.spongepowered.api.world.TeleporterAgent teleporterAgent) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("keepsVelocity", keepsVelocity);
        values.put("teleporterAgent", teleporterAgent);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetHuman}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param keepsVelocity The keeps velocity
     * @param teleporterAgent The teleporter agent
     * @return A new target human teleport displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetHuman createDisplaceEntityEventTeleportTargetHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, boolean keepsVelocity, org.spongepowered.api.world.TeleporterAgent teleporterAgent) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("keepsVelocity", keepsVelocity);
        values.put("teleporterAgent", teleporterAgent);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetLiving}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param keepsVelocity The keeps velocity
     * @param teleporterAgent The teleporter agent
     * @return A new target living teleport displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetLiving createDisplaceEntityEventTeleportTargetLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, boolean keepsVelocity, org.spongepowered.api.world.TeleporterAgent teleporterAgent) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("keepsVelocity", keepsVelocity);
        values.put("teleporterAgent", teleporterAgent);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetPlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newTransform The new transform
     * @param oldTransform The old transform
     * @param keepsVelocity The keeps velocity
     * @param teleporterAgent The teleporter agent
     * @return A new target player teleport displace entity event
     */
public static org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetPlayer createDisplaceEntityEventTeleportTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> newTransform, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> oldTransform, boolean keepsVelocity, org.spongepowered.api.world.TeleporterAgent teleporterAgent) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newTransform", newTransform);
        values.put("oldTransform", oldTransform);
        values.put("keepsVelocity", keepsVelocity);
        values.put("teleporterAgent", teleporterAgent);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityEvent}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new entity event
     */
public static org.spongepowered.api.event.entity.EntityEvent createEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new entity portal event
     */
public static org.spongepowered.api.event.entity.EntityPortalEvent createEntityPortalEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new enter entity portal event
     */
public static org.spongepowered.api.event.entity.EntityPortalEvent.Enter createEntityPortalEventEnter(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new exit entity portal event
     */
public static org.spongepowered.api.event.entity.EntityPortalEvent.Exit createEntityPortalEventExit(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new expire entity event
     */
public static org.spongepowered.api.event.entity.ExpireEntityEvent createExpireEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target item expire entity event
     */
public static org.spongepowered.api.event.entity.ExpireEntityEvent.TargetItem createExpireEntityEventTargetItem(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param fishHook The fish hook
     * @return A new fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent createFishingEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @return A new cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast createFishingEventCast(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceEntity}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast.SourceEntity createFishingEventCastSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceHuman}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast.SourceHuman createFishingEventCastSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceLiving}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast.SourceLiving createFishingEventCastSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourcePlayer}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player cast fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Cast.SourcePlayer createFishingEventCastSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Cast.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook createFishingEventHook(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceEntity}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook.SourceEntity createFishingEventHookSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceHuman}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook.SourceHuman createFishingEventHookSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceLiving}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook.SourceLiving createFishingEventHookSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourcePlayer}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player hook fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Hook.SourcePlayer createFishingEventHookSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Hook.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @return A new retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract createFishingEventRetract(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity caughtEntity, org.spongepowered.api.item.inventory.ItemStackSnapshot caughtItem) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceEntity}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract.SourceEntity createFishingEventRetractSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity caughtEntity, org.spongepowered.api.item.inventory.ItemStackSnapshot caughtItem, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceHuman}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract.SourceHuman createFishingEventRetractSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity caughtEntity, org.spongepowered.api.item.inventory.ItemStackSnapshot caughtItem, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceLiving}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract.SourceLiving createFishingEventRetractSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity caughtEntity, org.spongepowered.api.item.inventory.ItemStackSnapshot caughtItem, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourcePlayer}.
     *
     * @param game The game
     * @param fishHook The fish hook
     * @param caughtEntity The caught entity
     * @param caughtItem The caught item
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player retract fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.Retract.SourcePlayer createFishingEventRetractSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.projectile.FishHook fishHook, org.spongepowered.api.entity.Entity caughtEntity, org.spongepowered.api.item.inventory.ItemStackSnapshot caughtItem, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", caughtEntity);
        values.put("caughtItem", caughtItem);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.Retract.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.SourceEntity}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param fishHook The fish hook
     * @return A new source entity fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.SourceEntity createFishingEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.projectile.FishHook fishHook) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("fishHook", fishHook);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.SourceHuman}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param fishHook The fish hook
     * @return A new source human fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.SourceHuman createFishingEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.projectile.FishHook fishHook) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("fishHook", fishHook);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.SourceLiving}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param fishHook The fish hook
     * @return A new source living fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.SourceLiving createFishingEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.projectile.FishHook fishHook) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("fishHook", fishHook);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.SourcePlayer}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param fishHook The fish hook
     * @return A new source player fishing event
     */
public static org.spongepowered.api.event.entity.FishingEvent.SourcePlayer createFishingEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.projectile.FishHook fishHook) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("fishHook", fishHook);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.FishingEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent}.
     *
     * @param experience The experience
     * @param originalExperience The original experience
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new harvest entity event
     */
public static org.spongepowered.api.event.entity.HarvestEntityEvent createHarvestEntityEvent(int experience, int originalExperience, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HarvestEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHuman}.
     *
     * @param experience The experience
     * @param originalExperience The original experience
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target human harvest entity event
     */
public static org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHuman createHarvestEntityEventTargetHuman(int experience, int originalExperience, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving}.
     *
     * @param experience The experience
     * @param originalExperience The original experience
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target living harvest entity event
     */
public static org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving createHarvestEntityEventTargetLiving(int experience, int originalExperience, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer}.
     *
     * @param experience The experience
     * @param originalExperience The original experience
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param keepsInventory The keeps inventory
     * @param keepsLevel The keeps level
     * @param newLevel The new level
     * @return A new target player harvest entity event
     */
public static org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer createHarvestEntityEventTargetPlayer(int experience, int originalExperience, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, boolean keepsInventory, boolean keepsLevel, int newLevel) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("keepsInventory", keepsInventory);
        values.put("keepsLevel", keepsLevel);
        values.put("newLevel", newLevel);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HealEntityEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param baseHealAmount The base heal amount
     * @param finalHealAmount The final heal amount
     * @param originalHealAmount The original heal amount
     * @param healAmount The heal amount
     * @return A new heal entity event
     */
public static org.spongepowered.api.event.entity.HealEntityEvent createHealEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, double baseHealAmount, double finalHealAmount, double originalHealAmount, double healAmount) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("baseHealAmount", baseHealAmount);
        values.put("finalHealAmount", finalHealAmount);
        values.put("originalHealAmount", originalHealAmount);
        values.put("healAmount", healAmount);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.HealEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.IgniteEntityEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param fireTicks The fire ticks
     * @return A new ignite entity event
     */
public static org.spongepowered.api.event.entity.IgniteEntityEvent createIgniteEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, int fireTicks) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("fireTicks", fireTicks);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.IgniteEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent createInteractEntityEvent(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceBlock}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source block interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourceBlock createInteractEntityEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceEntity}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourceEntity createInteractEntityEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceHuman}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourceHuman createInteractEntityEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceLiving}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourceLiving createInteractEntityEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourcePlayer}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.SourcePlayer createInteractEntityEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use}.
     *
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use createInteractEntityEventUse(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceEntity createInteractEntityEventUseSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceHuman}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceHuman createInteractEntityEventUseSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceLiving}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceLiving createInteractEntityEventUseSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourcePlayer}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player use interact entity event
     */
public static org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourcePlayer createInteractEntityEventUseSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, com.flowpowered.math.vector.Vector3d interactionPoint, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("interactionPoint", interactionPoint);
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
     * @param game The game
     * @param targetType The target type
     * @param location The location
     * @return A new pre create entity event
     */
public static org.spongepowered.api.event.entity.PreCreateEntityEvent createPreCreateEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.EntityType targetType, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> location) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetType", targetType);
        values.put("location", location);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.PreCreateEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent createSpawnEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source block spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent.SourceBlock createSpawnEntityEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.SpawnEntityEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.SourceWorld}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param sourceWorld The source world
     * @return A new source world spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent.SourceWorld createSpawnEntityEventSourceWorld(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.world.World sourceWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("sourceWorld", sourceWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.SpawnEntityEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target living spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving createSpawnEntityEventTargetLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving.CheckSpawn}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new check spawn target living spawn entity event
     */
public static org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving.CheckSpawn createSpawnEntityEventTargetLivingCheckSpawn(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving.CheckSpawn.class, values);
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source entity tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent.SourceEntity createTameEntityEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source human tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent.SourceHuman createTameEntityEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source living tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent.SourceLiving createTameEntityEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new source player tame entity event
     */
public static org.spongepowered.api.event.entity.TameEntityEvent.SourcePlayer createTameEntityEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param leashHolder The leash holder
     * @return A new unleash entity event
     */
public static org.spongepowered.api.event.entity.UnleashEntityEvent createUnleashEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Entity leashHolder) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("leashHolder", leashHolder);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.UnleashEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.item.ItemMergeItemEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param itemToMerge The item to merge
     * @return A new item merge item event
     */
public static org.spongepowered.api.event.entity.item.ItemMergeItemEvent createItemMergeItemEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.Item itemToMerge) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("itemToMerge", itemToMerge);
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
public static org.spongepowered.api.event.entity.item.TargetItemEvent createTargetItemEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new living event
     */
public static org.spongepowered.api.event.entity.living.LivingEvent createLivingEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
public static org.spongepowered.api.event.entity.living.TargetLivingEvent createTargetLivingEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
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
     * @param experience The experience
     * @param originalExperience The original experience
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param currentExperience The current experience
     * @return A new change human experience event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent createChangeHumanExperienceEvent(int experience, int originalExperience, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, int currentExperience) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("currentExperience", currentExperience);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.TargetPlayer}.
     *
     * @param experience The experience
     * @param originalExperience The original experience
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param currentExperience The current experience
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new target player change human experience event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.TargetPlayer createChangeHumanExperienceEventTargetPlayer(int experience, int originalExperience, org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, int currentExperience, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("currentExperience", currentExperience);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newGameMode The new game mode
     * @param oldGameMode The old game mode
     * @return A new change human game mode event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent createChangeHumanGameModeEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.living.player.gamemode.GameMode newGameMode, org.spongepowered.api.entity.living.player.gamemode.GameMode oldGameMode) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newGameMode", newGameMode);
        values.put("oldGameMode", oldGameMode);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.TargetPlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param newGameMode The new game mode
     * @param oldGameMode The old game mode
     * @return A new target player change human game mode event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.TargetPlayer createChangeHumanGameModeEventTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.living.player.gamemode.GameMode newGameMode, org.spongepowered.api.entity.living.player.gamemode.GameMode oldGameMode) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("newGameMode", newGameMode);
        values.put("oldGameMode", oldGameMode);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param level The level
     * @param newLevel The new level
     * @return A new change human level event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent createChangeHumanLevelEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, int level, int newLevel) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("level", level);
        values.put("newLevel", newLevel);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.TargetPlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param level The level
     * @param newLevel The new level
     * @return A new target player change human level event
     */
public static org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.TargetPlayer createChangeHumanLevelEventTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, int level, int newLevel) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("level", level);
        values.put("newLevel", newLevel);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanEvent}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new human event
     */
public static org.spongepowered.api.event.entity.living.human.HumanEvent createHumanEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param bed The bed
     * @return A new human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent createHumanSleepEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("bed", bed);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.Enter}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param bed The bed
     * @return A new enter human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.Enter createHumanSleepEventEnter(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("bed", bed);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.Enter.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param bed The bed
     * @return A new source player human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer createHumanSleepEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("bed", bed);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.Enter}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param bed The bed
     * @return A new enter source player human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.Enter createHumanSleepEventSourcePlayerEnter(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("bed", bed);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.Enter.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StartSleeping}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param bed The bed
     * @param awokenPlayers The awoken players
     * @param ignoredPlayers The ignored players
     * @return A new start sleeping source player human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StartSleeping createHumanSleepEventSourcePlayerStartSleeping(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, java.util.List<org.spongepowered.api.entity.living.player.Player> awokenPlayers, java.util.List<org.spongepowered.api.entity.living.player.Player> ignoredPlayers) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("bed", bed);
        values.put("awokenPlayers", awokenPlayers);
        values.put("ignoredPlayers", ignoredPlayers);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StartSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StopSleeping}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param bed The bed
     * @param wasSpawnSet The was spawn set
     * @param spawnTransform The spawn transform
     * @return A new stop sleeping source player human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StopSleeping createHumanSleepEventSourcePlayerStopSleeping(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, boolean wasSpawnSet, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> spawnTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("bed", bed);
        values.put("wasSpawnSet", wasSpawnSet);
        values.put("spawnTransform", spawnTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StopSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StartSleeping}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param bed The bed
     * @param awokenPlayers The awoken players
     * @param ignoredPlayers The ignored players
     * @return A new start sleeping human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StartSleeping createHumanSleepEventStartSleeping(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, java.util.List<org.spongepowered.api.entity.living.player.Player> awokenPlayers, java.util.List<org.spongepowered.api.entity.living.player.Player> ignoredPlayers) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("bed", bed);
        values.put("awokenPlayers", awokenPlayers);
        values.put("ignoredPlayers", ignoredPlayers);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StartSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StopSleeping}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param bed The bed
     * @param wasSpawnSet The was spawn set
     * @param spawnTransform The spawn transform
     * @return A new stop sleeping human sleep event
     */
public static org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StopSleeping createHumanSleepEventStopSleeping(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> bed, boolean wasSpawnSet, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> spawnTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("bed", bed);
        values.put("wasSpawnSet", wasSpawnSet);
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
public static org.spongepowered.api.event.entity.living.human.TargetHumanEvent createTargetHumanEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.human.TargetHumanEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerChangeSignEvent}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param target The target
     * @param originalText The original text
     * @param text The text
     * @return A new player change sign event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerChangeSignEvent createPlayerChangeSignEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.block.tileentity.Sign target, org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData originalText, org.spongepowered.api.data.manipulator.mutable.tileentity.SignData text) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("target", target);
        values.put("originalText", originalText);
        values.put("text", text);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerChangeSignEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerChangeStatisticEvent}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param newValue The new value
     * @param oldValue The old value
     * @param changedStatistic The changed statistic
     * @return A new player change statistic event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerChangeStatisticEvent createPlayerChangeStatisticEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, long newValue, long oldValue, org.spongepowered.api.statistic.Statistic changedStatistic) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("newValue", newValue);
        values.put("oldValue", oldValue);
        values.put("changedStatistic", changedStatistic);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerChangeStatisticEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerChatEvent}.
     *
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
public static org.spongepowered.api.event.entity.living.player.PlayerChatEvent createPlayerChatEvent(org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.util.command.CommandSource source, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.text.Text unformattedMessage) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param connection The connection
     * @return A new player connection event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerConnectionEvent createPlayerConnectionEvent(org.spongepowered.api.Game game, org.spongepowered.api.network.PlayerConnection connection) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("connection", connection);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerConnectionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerConnectionRegisterChannelEvent}.
     *
     * @param game The game
     * @param connection The connection
     * @param channelRegistered The channel registered
     * @return A new player connection register channel event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerConnectionRegisterChannelEvent createPlayerConnectionRegisterChannelEvent(org.spongepowered.api.Game game, org.spongepowered.api.network.PlayerConnection connection, java.lang.String channelRegistered) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("connection", connection);
        values.put("channelRegistered", channelRegistered);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerConnectionRegisterChannelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerConnectionUnregisterChannelEvent}.
     *
     * @param game The game
     * @param connection The connection
     * @param channelUnregistered The channel unregistered
     * @return A new player connection unregister channel event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerConnectionUnregisterChannelEvent createPlayerConnectionUnregisterChannelEvent(org.spongepowered.api.Game game, org.spongepowered.api.network.PlayerConnection connection, java.lang.String channelUnregistered) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("connection", connection);
        values.put("channelUnregistered", channelUnregistered);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerConnectionUnregisterChannelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerEvent}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerEvent createPlayerEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param achievement The achievement
     * @return A new player gain achievement event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerGainAchievementEvent createPlayerGainAchievementEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.statistic.achievement.Achievement achievement) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("achievement", achievement);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerGainAchievementEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerJoinEvent}.
     *
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player join event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerJoinEvent createPlayerJoinEvent(org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.util.command.CommandSource source, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player kick event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerKickEvent createPlayerKickEvent(org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.util.command.CommandSource source, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player message event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerMessageEvent createPlayerMessageEvent(org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.util.command.CommandSource source, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param message The message
     * @param newMessage The new message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new player quit event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerQuitEvent createPlayerQuitEvent(org.spongepowered.api.Game game, org.spongepowered.api.text.Text message, org.spongepowered.api.text.Text newMessage, org.spongepowered.api.text.sink.MessageSink sink, org.spongepowered.api.util.command.CommandSource source, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param status The status
     * @param pack The pack
     * @return A new player resource pack status event
     */
public static org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent createPlayerResourcePackStatusEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent.ResourcePackStatus status, org.spongepowered.api.resourcepack.ResourcePack pack) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("status", status);
        values.put("pack", pack);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.RespawnPlayerEvent}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param isBedSpawn The is bed spawn
     * @param originTransform The origin transform
     * @return A new respawn player event
     */
public static org.spongepowered.api.event.entity.living.player.RespawnPlayerEvent createRespawnPlayerEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, boolean isBedSpawn, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> originTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("isBedSpawn", isBedSpawn);
        values.put("originTransform", originTransform);
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
public static org.spongepowered.api.event.entity.living.player.TargetPlayerEvent createTargetPlayerEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
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
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param source The source
     * @return A new launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent createLaunchProjectileEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.projectile.source.ProjectileSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceEntity}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param source The source
     * @return A new source entity launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceEntity createLaunchProjectileEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.projectile.source.ProjectileSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceHuman}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param source The source
     * @return A new source human launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceHuman createLaunchProjectileEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.projectile.source.ProjectileSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceLiving}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param source The source
     * @return A new source living launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceLiving createLaunchProjectileEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.projectile.source.ProjectileSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("source", source);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourcePlayer}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param source The source
     * @return A new source player launch projectile event
     */
public static org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourcePlayer createLaunchProjectileEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.projectile.source.ProjectileSource source) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("source", source);
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
public static org.spongepowered.api.event.entity.projectile.TargetProjectileEvent createTargetProjectileEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.entity.projectile.TargetProjectileEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.GamePreConstructEntityEvent}.
     *
     * @param game The game
     * @param entityType The entity type
     * @param transform The transform
     * @return A new game pre construct entity event
     */
public static org.spongepowered.api.event.game.GamePreConstructEntityEvent createGamePreConstructEntityEvent(org.spongepowered.api.Game game, org.spongepowered.api.entity.EntityType entityType, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> transform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("entityType", entityType);
        values.put("transform", transform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.game.GamePreConstructEntityEvent.class, values);
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
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param inventory The inventory
     * @param result The result
     * @return A new block brew event
     */
public static org.spongepowered.api.event.inventory.BlockBrewEvent createBlockBrewEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.item.inventory.ItemStack result) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("inventory", inventory);
        values.put("result", result);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.BlockBrewEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.BlockInventoryEvent}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param inventory The inventory
     * @return A new block inventory event
     */
public static org.spongepowered.api.event.inventory.BlockInventoryEvent createBlockInventoryEvent(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.item.inventory.Inventory inventory) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("inventory", inventory);
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
     * @param game The game
     * @param container The container
     * @return A new container event
     */
public static org.spongepowered.api.event.inventory.ContainerEvent createContainerEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Container container) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.ContainerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent}.
     *
     * @param game The game
     * @return A new drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent createDropItemStackEvent(org.spongepowered.api.Game game) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post}.
     *
     * @param game The game
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @return A new post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post createDropItemStackEventPost(org.spongepowered.api.Game game, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceBlock}.
     *
     * @param game The game
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @return A new source block post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceBlock createDropItemStackEventPostSourceBlock(org.spongepowered.api.Game game, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceEntity}.
     *
     * @param game The game
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceEntity createDropItemStackEventPostSourceEntity(org.spongepowered.api.Game game, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceHuman}.
     *
     * @param game The game
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceHuman createDropItemStackEventPostSourceHuman(org.spongepowered.api.Game game, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceLiving}.
     *
     * @param game The game
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceLiving createDropItemStackEventPostSourceLiving(org.spongepowered.api.Game game, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourcePlayer}.
     *
     * @param game The game
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player post drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourcePlayer createDropItemStackEventPostSourcePlayer(org.spongepowered.api.Game game, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre}.
     *
     * @param game The game
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @return A new pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre createDropItemStackEventPre(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceBlock}.
     *
     * @param game The game
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @return A new source block pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceBlock createDropItemStackEventPreSourceBlock(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceEntity}.
     *
     * @param game The game
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceEntity createDropItemStackEventPreSourceEntity(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceHuman}.
     *
     * @param game The game
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceHuman createDropItemStackEventPreSourceHuman(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceLiving}.
     *
     * @param game The game
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceLiving createDropItemStackEventPreSourceLiving(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourcePlayer}.
     *
     * @param game The game
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player pre drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourcePlayer createDropItemStackEventPreSourcePlayer(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.item.inventory.ItemStackSnapshot> defaultDroppedItems, java.util.List<org.spongepowered.api.item.inventory.ItemStackTransaction> droppedItems, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceBlock}.
     *
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @return A new source block drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourceBlock createDropItemStackEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.DropItemStackEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceEntity}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source entity drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourceEntity createDropItemStackEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source human drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourceHuman createDropItemStackEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source living drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourceLiving createDropItemStackEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new source player drop item stack event
     */
public static org.spongepowered.api.event.inventory.DropItemStackEvent.SourcePlayer createDropItemStackEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @return A new inventory click event
     */
public static org.spongepowered.api.event.inventory.InventoryClickEvent createInventoryClickEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        values.put("viewer", viewer);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.InventoryClickEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryCloseEvent}.
     *
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @return A new inventory close event
     */
public static org.spongepowered.api.event.inventory.InventoryCloseEvent createInventoryCloseEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
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
public static org.spongepowered.api.event.inventory.ItemResultEvent createItemResultEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Inventory inventory, org.spongepowered.api.item.inventory.ItemStack result) {
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
     * @param game The game
     * @param sourceSide The source side
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param inventory The inventory
     * @param items The items
     * @return A new source block pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourceBlock createPickUpItemEventSourceBlock(org.spongepowered.api.Game game, org.spongepowered.api.util.Direction sourceSide, org.spongepowered.api.block.BlockSnapshot sourceBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> sourceLocation, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceSide", sourceSide);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("inventory", inventory);
        values.put("items", items);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceEntity}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param inventory The inventory
     * @param items The items
     * @return A new source entity pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourceEntity createPickUpItemEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("inventory", inventory);
        values.put("items", items);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceHuman}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param inventory The inventory
     * @param items The items
     * @return A new source human pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourceHuman createPickUpItemEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("inventory", inventory);
        values.put("items", items);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceLiving}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param inventory The inventory
     * @param items The items
     * @return A new source living pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourceLiving createPickUpItemEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("inventory", inventory);
        values.put("items", items);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourcePlayer}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param inventory The inventory
     * @param items The items
     * @return A new source player pick up item event
     */
public static org.spongepowered.api.event.inventory.PickUpItemEvent.SourcePlayer createPickUpItemEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.Inventory inventory, java.util.Collection<org.spongepowered.api.entity.Item> items) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("inventory", inventory);
        values.put("items", items);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.PickUpItemEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent}.
     *
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent createUseItemStackEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish}.
     *
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new finish use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.Finish createUseItemStackEventFinish(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity createUseItemStackEventSourceEntity(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Finish}.
     *
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new finish source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Finish createUseItemStackEventSourceEntityFinish(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new start source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Start createUseItemStackEventSourceEntityStart(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Stop}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new stop source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Stop createUseItemStackEventSourceEntityStop(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Tick}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new tick source entity use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Tick createUseItemStackEventSourceEntityTick(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman createUseItemStackEventSourceHuman(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Finish}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new finish source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Finish createUseItemStackEventSourceHumanFinish(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Start}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new start source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Start createUseItemStackEventSourceHumanStart(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Stop}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new stop source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Stop createUseItemStackEventSourceHumanStop(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Tick}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new tick source human use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Tick createUseItemStackEventSourceHumanTick(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving createUseItemStackEventSourceLiving(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Finish}.
     *
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @return A new finish source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Finish createUseItemStackEventSourceLivingFinish(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new start source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Start createUseItemStackEventSourceLivingStart(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Stop}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new stop source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Stop createUseItemStackEventSourceLivingStop(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Tick}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new tick source living use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Tick createUseItemStackEventSourceLivingTick(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer createUseItemStackEventSourcePlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Finish}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new finish source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Finish createUseItemStackEventSourcePlayerFinish(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Start}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new start source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Start createUseItemStackEventSourcePlayerStart(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Stop}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new stop source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Stop createUseItemStackEventSourcePlayerStop(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Tick}.
     *
     * @param game The game
     * @param sourceEntity The source entity
     * @param sourceTransform The source transform
     * @param itemStackInUse The item stack in use
     * @return A new tick source player use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Tick createUseItemStackEventSourcePlayerTick(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity sourceEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> sourceTransform, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("sourceTransform", sourceTransform);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start}.
     *
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new start use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.Start createUseItemStackEventStart(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop}.
     *
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new stop use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.Stop createUseItemStackEventStop(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick}.
     *
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new tick use item stack event
     */
public static org.spongepowered.api.event.inventory.UseItemStackEvent.Tick createUseItemStackEventTick(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.ItemStackTransaction itemStackInUse) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.UseItemStackEvent.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent}.
     *
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @param resultTypes The result types
     * @param results The results
     * @param inventory The inventory
     * @param recipe The recipe
     * @return A new viewer craft item event
     */
public static org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent createViewerCraftItemEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.entity.living.Human viewer, java.util.List<org.spongepowered.api.item.ItemType> resultTypes, java.util.List<org.spongepowered.api.item.inventory.ItemStack> results, org.spongepowered.api.item.inventory.crafting.CraftingInventory inventory, org.spongepowered.api.item.recipe.Recipe recipe) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        values.put("viewer", viewer);
        values.put("resultTypes", resultTypes);
        values.put("results", results);
        values.put("inventory", inventory);
        values.put("recipe", recipe);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerEvent}.
     *
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @return A new viewer event
     */
public static org.spongepowered.api.event.inventory.viewer.ViewerEvent createViewerEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        values.put("viewer", viewer);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.inventory.viewer.ViewerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerOpenContainerEvent}.
     *
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @return A new viewer open container event
     */
public static org.spongepowered.api.event.inventory.viewer.ViewerOpenContainerEvent createViewerOpenContainerEvent(org.spongepowered.api.Game game, org.spongepowered.api.item.inventory.Container container, org.spongepowered.api.entity.living.Human viewer) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
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
     * {@link org.spongepowered.api.event.network.GameClientAuthEvent}.
     *
     * @param game The game
     * @param disconnectCause The disconnect cause
     * @param disconnectMessage The disconnect message
     * @param profile The profile
     * @param connection The connection
     * @return A new game client auth event
     */
public static org.spongepowered.api.event.network.GameClientAuthEvent createGameClientAuthEvent(org.spongepowered.api.Game game, org.spongepowered.api.event.cause.Cause disconnectCause, org.spongepowered.api.text.Text disconnectMessage, org.spongepowered.api.GameProfile profile, org.spongepowered.api.network.RemoteConnection connection) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("disconnectCause", disconnectCause);
        values.put("disconnectMessage", disconnectMessage);
        values.put("profile", profile);
        values.put("connection", connection);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.network.GameClientAuthEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.GameClientConnectEvent}.
     *
     * @param game The game
     * @param disconnectCause The disconnect cause
     * @param disconnectMessage The disconnect message
     * @param profile The profile
     * @param connection The connection
     * @return A new game client connect event
     */
public static org.spongepowered.api.event.network.GameClientConnectEvent createGameClientConnectEvent(org.spongepowered.api.Game game, org.spongepowered.api.event.cause.Cause disconnectCause, org.spongepowered.api.text.Text disconnectMessage, org.spongepowered.api.GameProfile profile, org.spongepowered.api.network.RemoteConnection connection) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("disconnectCause", disconnectCause);
        values.put("disconnectMessage", disconnectMessage);
        values.put("profile", profile);
        values.put("connection", connection);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.network.GameClientConnectEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.GameClientLoginEvent}.
     *
     * @param game The game
     * @param disconnectCause The disconnect cause
     * @param disconnectMessage The disconnect message
     * @param profile The profile
     * @param connection The connection
     * @return A new game client login event
     */
public static org.spongepowered.api.event.network.GameClientLoginEvent createGameClientLoginEvent(org.spongepowered.api.Game game, org.spongepowered.api.event.cause.Cause disconnectCause, org.spongepowered.api.text.Text disconnectMessage, org.spongepowered.api.GameProfile profile, org.spongepowered.api.network.RemoteConnection connection) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("disconnectCause", disconnectCause);
        values.put("disconnectMessage", disconnectMessage);
        values.put("profile", profile);
        values.put("connection", connection);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.network.GameClientLoginEvent.class, values);
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
     * @param game The game
     * @param plugin The plugin
     * @param chunkCoords The chunk coords
     * @param ticket The ticket
     * @return A new plugin force chunk event
     */
public static org.spongepowered.api.event.plugin.PluginForceChunkEvent createPluginForceChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.plugin.PluginContainer plugin, com.flowpowered.math.vector.Vector3i chunkCoords, org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket ticket) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("plugin", plugin);
        values.put("chunkCoords", chunkCoords);
        values.put("ticket", ticket);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.plugin.PluginForceChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.plugin.PluginLoadWorldEvent}.
     *
     * @param game The game
     * @param plugin The plugin
     * @param targetWorld The target world
     * @return A new plugin load world event
     */
public static org.spongepowered.api.event.plugin.PluginLoadWorldEvent createPluginLoadWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.plugin.PluginContainer plugin, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("plugin", plugin);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.plugin.PluginLoadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.plugin.PluginUnforceChunkEvent}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @param chunkCoords The chunk coords
     * @param ticket The ticket
     * @return A new plugin unforce chunk event
     */
public static org.spongepowered.api.event.plugin.PluginUnforceChunkEvent createPluginUnforceChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, com.flowpowered.math.vector.Vector3i chunkCoords, org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket ticket) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("chunkCoords", chunkCoords);
        values.put("ticket", ticket);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.plugin.PluginUnforceChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.plugin.PluginUnloadWorldEvent}.
     *
     * @param game The game
     * @param targetWorld The target world
     * @return A new plugin unload world event
     */
public static org.spongepowered.api.event.plugin.PluginUnloadWorldEvent createPluginUnloadWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.plugin.PluginUnloadWorldEvent.class, values);
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
     * @param game The game
     * @param server The server
     * @param response The response
     * @param client The client
     * @return A new ping server event
     */
public static org.spongepowered.api.event.server.PingServerEvent createPingServerEvent(org.spongepowered.api.Game game, org.spongepowered.api.Server server, org.spongepowered.api.event.server.PingServerEvent.Response response, org.spongepowered.api.status.StatusClient client) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("server", server);
        values.put("response", response);
        values.put("client", client);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.PingServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.PingServerEvent.Response}.
     *
     * @param players The players
     * @param description The description
     * @param favicon The favicon
     * @param hidePlayers The hide players
     * @return A new response ping server event
     */
public static org.spongepowered.api.event.server.PingServerEvent.Response createPingServerEventResponse(org.spongepowered.api.event.server.PingServerEvent.Response.Players players, org.spongepowered.api.text.Text description, org.spongepowered.api.status.Favicon favicon, boolean hidePlayers) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("players", players);
        values.put("description", description);
        values.put("favicon", favicon);
        values.put("hidePlayers", hidePlayers);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.PingServerEvent.Response.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.PingServerEvent.Response.Players}.
     *
     * @param profiles The profiles
     * @param max The max
     * @param online The online
     * @return A new players response ping server event
     */
public static org.spongepowered.api.event.server.PingServerEvent.Response.Players createPingServerEventResponsePlayers(java.util.List<org.spongepowered.api.GameProfile> profiles, int max, int online) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("profiles", profiles);
        values.put("max", max);
        values.put("online", online);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.PingServerEvent.Response.Players.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ServerCreateWorldEvent}.
     *
     * @param game The game
     * @param server The server
     * @param worldCreationSettings The world creation settings
     * @param worldProperties The world properties
     * @return A new server create world event
     */
public static org.spongepowered.api.event.server.ServerCreateWorldEvent createServerCreateWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.Server server, org.spongepowered.api.world.WorldCreationSettings worldCreationSettings, org.spongepowered.api.world.storage.WorldProperties worldProperties) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * {@link org.spongepowered.api.event.server.ServerLoadWorldEvent}.
     *
     * @param game The game
     * @param server The server
     * @param targetWorld The target world
     * @return A new server load world event
     */
public static org.spongepowered.api.event.server.ServerLoadWorldEvent createServerLoadWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.Server server, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("server", server);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.ServerLoadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ServerUnloadWorldEvent}.
     *
     * @param game The game
     * @param targetWorld The target world
     * @return A new server unload world event
     */
public static org.spongepowered.api.event.server.ServerUnloadWorldEvent createServerUnloadWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.ServerUnloadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.BasicQueryServerEvent}.
     *
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param playerCount The player count
     * @param size The size
     * @param gameType The game type
     * @param map The map
     * @param motd The motd
     * @param address The address
     * @return A new basic query server event
     */
public static org.spongepowered.api.event.server.query.BasicQueryServerEvent createBasicQueryServerEvent(int maxPlayerCount, int maxSize, int playerCount, int size, java.lang.String gameType, java.lang.String map, java.lang.String motd, java.net.InetSocketAddress address) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("playerCount", playerCount);
        values.put("size", size);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("motd", motd);
        values.put("address", address);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.query.BasicQueryServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.FullQueryServerEvent}.
     *
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param playerCount The player count
     * @param size The size
     * @param gameType The game type
     * @param map The map
     * @param motd The motd
     * @param address The address
     * @param gameId The game id
     * @param plugins The plugins
     * @param version The version
     * @param players The players
     * @param customValuesMap The custom values map
     * @return A new full query server event
     */
public static org.spongepowered.api.event.server.query.FullQueryServerEvent createFullQueryServerEvent(int maxPlayerCount, int maxSize, int playerCount, int size, java.lang.String gameType, java.lang.String map, java.lang.String motd, java.net.InetSocketAddress address, java.lang.String gameId, java.lang.String plugins, java.lang.String version, java.util.List<java.lang.String> players, java.util.Map<java.lang.String, java.lang.String> customValuesMap) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("playerCount", playerCount);
        values.put("size", size);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("motd", motd);
        values.put("address", address);
        values.put("gameId", gameId);
        values.put("plugins", plugins);
        values.put("version", version);
        values.put("players", players);
        values.put("customValuesMap", customValuesMap);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.query.FullQueryServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.QueryServerEvent}.
     *
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param playerCount The player count
     * @param size The size
     * @param gameType The game type
     * @param map The map
     * @param motd The motd
     * @param address The address
     * @return A new query server event
     */
public static org.spongepowered.api.event.server.query.QueryServerEvent createQueryServerEvent(int maxPlayerCount, int maxSize, int playerCount, int size, java.lang.String gameType, java.lang.String map, java.lang.String motd, java.net.InetSocketAddress address) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("playerCount", playerCount);
        values.put("size", size);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("motd", motd);
        values.put("address", address);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.server.query.QueryServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.BanUserEvent}.
     *
     * @param targetUser The target user
     * @param ban The ban
     * @return A new ban user event
     */
public static org.spongepowered.api.event.user.BanUserEvent createBanUserEvent(org.spongepowered.api.entity.living.player.User targetUser, org.spongepowered.api.util.ban.Ban.User ban) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("targetUser", targetUser);
        values.put("ban", ban);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.user.BanUserEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.BanUserEvent.TargetPlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param targetUser The target user
     * @param ban The ban
     * @return A new target player ban user event
     */
public static org.spongepowered.api.event.user.BanUserEvent.TargetPlayer createBanUserEventTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.living.player.User targetUser, org.spongepowered.api.util.ban.Ban.User ban) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("targetUser", targetUser);
        values.put("ban", ban);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.user.BanUserEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.PardonUserEvent}.
     *
     * @param targetUser The target user
     * @param ban The ban
     * @return A new pardon user event
     */
public static org.spongepowered.api.event.user.PardonUserEvent createPardonUserEvent(org.spongepowered.api.entity.living.player.User targetUser, org.spongepowered.api.util.ban.Ban.User ban) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("targetUser", targetUser);
        values.put("ban", ban);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.user.PardonUserEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.PardonUserEvent.TargetPlayer}.
     *
     * @param game The game
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param targetUser The target user
     * @param ban The ban
     * @return A new target player pardon user event
     */
public static org.spongepowered.api.event.user.PardonUserEvent.TargetPlayer createPardonUserEventTargetPlayer(org.spongepowered.api.Game game, org.spongepowered.api.entity.Entity targetEntity, org.spongepowered.api.entity.Transform<org.spongepowered.api.world.World> targetTransform, org.spongepowered.api.entity.living.player.User targetUser, org.spongepowered.api.util.ban.Ban.User ban) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("targetUser", targetUser);
        values.put("ban", ban);
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
     * @param game The game
     * @param duration The duration
     * @param world The world
     * @param initialWeather The initial weather
     * @param resultingWeather The resulting weather
     * @return A new change world weather event
     */
public static org.spongepowered.api.event.world.ChangeWorldWeatherEvent createChangeWorldWeatherEvent(org.spongepowered.api.Game game, int duration, org.spongepowered.api.world.World world, org.spongepowered.api.world.weather.Weather initialWeather, org.spongepowered.api.world.weather.Weather resultingWeather) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("duration", duration);
        values.put("world", world);
        values.put("initialWeather", initialWeather);
        values.put("resultingWeather", resultingWeather);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.ChangeWorldWeatherEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreateWorldEvent}.
     *
     * @param game The game
     * @param worldCreationSettings The world creation settings
     * @param worldProperties The world properties
     * @return A new create world event
     */
public static org.spongepowered.api.event.world.CreateWorldEvent createCreateWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.WorldCreationSettings worldCreationSettings, org.spongepowered.api.world.storage.WorldProperties worldProperties) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param targetWorld The target world
     * @return A new load world event
     */
public static org.spongepowered.api.event.world.LoadWorldEvent createLoadWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.LoadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.UnloadWorldEvent}.
     *
     * @param game The game
     * @param targetWorld The target world
     * @return A new unload world event
     */
public static org.spongepowered.api.event.world.UnloadWorldEvent createUnloadWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World targetWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.UnloadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldDecayBlockEvent}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceWorld The source world
     * @return A new world decay block event
     */
public static org.spongepowered.api.event.world.WorldDecayBlockEvent createWorldDecayBlockEvent(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.world.World sourceWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceWorld", sourceWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldDecayBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldEvent}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @return A new world event
     */
public static org.spongepowered.api.event.world.WorldEvent createWorldEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceWorld The source world
     * @param explosion The explosion
     * @return A new world explosion event
     */
public static org.spongepowered.api.event.world.WorldExplosionEvent createWorldExplosionEvent(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.explosion.Explosion explosion) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceWorld", sourceWorld);
        values.put("explosion", explosion);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldExplosionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent.OnExplosion}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceWorld The source world
     * @param explosion The explosion
     * @return A new on explosion world explosion event
     */
public static org.spongepowered.api.event.world.WorldExplosionEvent.OnExplosion createWorldExplosionEventOnExplosion(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, java.util.List<? extends org.spongepowered.api.entity.Entity> entities, java.util.List<org.spongepowered.api.entity.EntitySnapshot> entitySnapshots, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.explosion.Explosion explosion) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceWorld", sourceWorld);
        values.put("explosion", explosion);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldExplosionEvent.OnExplosion.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent.Pre}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceWorld The source world
     * @param explosion The explosion
     * @return A new pre world explosion event
     */
public static org.spongepowered.api.event.world.WorldExplosionEvent.Pre createWorldExplosionEventPre(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.explosion.Explosion explosion) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceWorld", sourceWorld);
        values.put("explosion", explosion);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldExplosionEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent}.
     *
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new world generate chunk event
     */
public static org.spongepowered.api.event.world.WorldGenerateChunkEvent createWorldGenerateChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldGenerateChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent.Post}.
     *
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new post world generate chunk event
     */
public static org.spongepowered.api.event.world.WorldGenerateChunkEvent.Post createWorldGenerateChunkEventPost(org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldGenerateChunkEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent.Pre}.
     *
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new pre world generate chunk event
     */
public static org.spongepowered.api.event.world.WorldGenerateChunkEvent.Pre createWorldGenerateChunkEventPre(org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldGenerateChunkEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGrowBlockEvent}.
     *
     * @param game The game
     * @param transactions The transactions
     * @param sourceWorld The source world
     * @return A new world grow block event
     */
public static org.spongepowered.api.event.world.WorldGrowBlockEvent createWorldGrowBlockEvent(org.spongepowered.api.Game game, java.util.List<org.spongepowered.api.block.BlockTransaction> transactions, org.spongepowered.api.world.World sourceWorld) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("sourceWorld", sourceWorld);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldGrowBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldLoadChunkEvent}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new world load chunk event
     */
public static org.spongepowered.api.event.world.WorldLoadChunkEvent createWorldLoadChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldLoadChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldPopulateChunkEvent}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new world populate chunk event
     */
public static org.spongepowered.api.event.world.WorldPopulateChunkEvent createWorldPopulateChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldPopulateChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldPopulateChunkEvent.Post}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new post world populate chunk event
     */
public static org.spongepowered.api.event.world.WorldPopulateChunkEvent.Post createWorldPopulateChunkEventPost(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldPopulateChunkEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldPopulateChunkEvent.Pre}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @param pendingPopulators The pending populators
     * @return A new pre world populate chunk event
     */
public static org.spongepowered.api.event.world.WorldPopulateChunkEvent.Pre createWorldPopulateChunkEventPre(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk, java.util.List<org.spongepowered.api.world.gen.Populator> pendingPopulators) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        values.put("pendingPopulators", pendingPopulators);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldPopulateChunkEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldTickBlockEvent}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new world tick block event
     */
public static org.spongepowered.api.event.world.WorldTickBlockEvent createWorldTickBlockEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.block.BlockState targetBlock, org.spongepowered.api.world.Location<org.spongepowered.api.world.World> targetLocation) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldTickBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldUnloadChunkEvent}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new world unload chunk event
     */
public static org.spongepowered.api.event.world.WorldUnloadChunkEvent createWorldUnloadChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.WorldUnloadChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ChangeChunkEvent}.
     *
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new change chunk event
     */
public static org.spongepowered.api.event.world.chunk.ChangeChunkEvent createChangeChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.ChangeChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ChangeChunkEvent.SourceWorld}.
     *
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world change chunk event
     */
public static org.spongepowered.api.event.world.chunk.ChangeChunkEvent.SourceWorld createChangeChunkEventSourceWorld(org.spongepowered.api.Game game, org.spongepowered.api.world.World sourceWorld, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
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
     * @param game The game
     * @param targetChunk The target chunk
     * @param chunkCoords The chunk coords
     * @param ticket The ticket
     * @return A new forced chunk event
     */
public static org.spongepowered.api.event.world.chunk.ForcedChunkEvent createForcedChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk, com.flowpowered.math.vector.Vector3i chunkCoords, org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket ticket) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        values.put("chunkCoords", chunkCoords);
        values.put("ticket", ticket);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.ForcedChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.LoadChunkEvent}.
     *
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new load chunk event
     */
public static org.spongepowered.api.event.world.chunk.LoadChunkEvent createLoadChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.LoadChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnforcedChunkEvent}.
     *
     * @param game The game
     * @param chunkCoords The chunk coords
     * @param ticket The ticket
     * @return A new unforced chunk event
     */
public static org.spongepowered.api.event.world.chunk.UnforcedChunkEvent createUnforcedChunkEvent(org.spongepowered.api.Game game, com.flowpowered.math.vector.Vector3i chunkCoords, org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket ticket) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("chunkCoords", chunkCoords);
        values.put("ticket", ticket);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.UnforcedChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnloadChunkEvent}.
     *
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new unload chunk event
     */
public static org.spongepowered.api.event.world.chunk.UnloadChunkEvent createUnloadChunkEvent(org.spongepowered.api.Game game, org.spongepowered.api.world.Chunk targetChunk) {
        java.util.Map<java.lang.String, java.lang.Object> values = com.google.common.collect.Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return org.spongepowered.api.event.SpongeEventFactory.createEventImpl(org.spongepowered.api.event.world.chunk.UnloadChunkEvent.class, values);
    }
}

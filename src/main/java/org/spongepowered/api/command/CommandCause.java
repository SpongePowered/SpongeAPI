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
package org.spongepowered.api.command;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.SystemSubject;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.SubjectCollection;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.plugin.PluginContainer;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * The {@link CommandCause} represents the {@link Cause} of a command, and
 * also contains utility methods to obtain key information about said cause.
 *
 * <p>In line with causes used in events, you may assume that the
 * {@link Cause#root()} (from {@link CommandCause#getCause()}) is the direct
 * invoker of the command, though it should also be noted that the invoker
 * and intended <strong>target</strong> of a command may be different, which
 * will be indicated by entries in the {@link Cause#getContext()}</p>
 *
 * <p>It is <em>very</em> important to note that no object in the {@link Cause}
 * is guaranteed to be a traditional "command source" - a plugin may invoke a
 * command without pushing anything to the cause stack and thus the
 * {@link PluginContainer} of the plugin in question will be the root of the
 * cause.</p>
 *
 * <p>In the case of a command being executed as a "proxy", such as a command
 * block executing a command by virtue of an entity stepping on a pressure
 * plate, the direct cause will be the command block. However, the player
 * in question will also be present in the cause stack, allowing command
 * providers to obtain richer information about the invocation of their command.
 * This is inline with how {@link Cause}s work in Sponge and its events, for
 * more information about how Causes work, see the {@link Cause} and
 * {@link CauseStackManager} javadocs and associated documentation.
 * </p>
 *
 * <p>The {@link EventContext} that is attached to {@link Cause#getContext()}
 * <strong>may</strong> offer other indications as to how the command should
 * be handled, in addition to using the provided cause stack:</p>
 *
 * <ul>
 *     <li>{@link EventContextKeys#MESSAGE_CHANNEL}, which indicates the
 *     where messages that should be sent back to the invoker should be sent
 *     to (typically messages indicating the status of the command execution);
 *     </li>
 *     <li>{@link EventContextKeys#SUBJECT}, which indicates the subject that
 *     should be subjected to any permission checks;</li>
 *     <li>{@link EventContextKeys#LOCATION}, which indicates the location that
 *     the command should be assumed to be executed around;
 *     <li>{@link EventContextKeys#ROTATION}, which indicates the rotation that
 *     the command should assume the target has; and</li>
 *     <li>{@link EventContextKeys#BLOCK_TARGET}, which indicates the block that
 *     the command should take into account when executing.</li>
 * </ul>
 *
 * <p>This object acts as a {@link Subject}, and simply redirects all calls
 * inherited by this interface to the subject returned by {@link #getSubject()}.
 * </p>
 *
 * <p>There are utility methods on this interface that provide hints as to what
 * the implementation will select for different tasks, for example, the
 * implementation will use the result of {@link #getSubject()} for permission
 * checks. Third party command consumers are under no obligation to use these
 * utility methods as all methods obtain their information from the
 * {@link Cause}.</p>
 *
 * <p>No method on this interface, apart from {@link #getCause()}, should
 * be taken a guarantee of what may be present, however, they indicate what
 * typically would be of interest to command API consumers.</p>
 */
public interface CommandCause extends Subject {

    /**
     * Creates a {@link CommandCause} from the provided {@link Cause}
     *
     * @param cause The {@link Cause}
     * @return The {@link CommandCause}
     */
    static CommandCause of(final Cause cause) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).create(cause);
    }

    /**
     * Gets the {@link Cause} of the command invocation.
     *
     * @return The cause of the invocation.
     */
    Cause getCause();

    /**
     * Get the {@link Subject} that will be selected for permission checks
     * during command execution (by default).
     *
     * <p>The {@link Subject} will be selected in the following way from the
     * {@link Cause} in {@link #getCause()}:</p>
     *
     * <ul>
     *    <li>The {@link EventContextKeys#SUBJECT}, if any</li>
     *    <li>The <strong>first</strong> {@link Subject} in the {@link Cause}
     *    </li>
     *    <li>The {@link SystemSubject} if no subject exists within the cause
     *    </li>
     * </ul>
     *
     * <p><strong>Note:</strong> while it might be tempting to use this as the
     * invoker of the command, the {@link Cause#root()} and this might be
     * different. Command executors should generally use the root of the
     * {@link Cause} as the target of their command.</p>
     *
     * @return The {@link Subject} responsible, if any.
     */
    default Subject getSubject() {
        return getCause().getContext()
            .get(EventContextKeys.SUBJECT)
            .orElseGet(() -> getCause().first(Subject.class).orElseGet(Sponge::getSystemSubject));
    }

    /**
     * Gets the {@link MessageChannel} that should be the target for any
     * messages sent by the command (by default).
     *
     * <p>The {@link MessageChannel} will be selected in the following way
     * from the {@link Cause} in {@link #getCause()}:</p>
     *
     * <ul>
     *    <li>The {@link EventContextKeys#MESSAGE_CHANNEL}, if any</li>
     *    <li>A message channel containing the <strong>first</strong>
     *    {@link MessageReceiver} in the {@link Cause}</li>
     *    <li>The SystemSubject {@link MessageReceiver}</li>
     * </ul>
     *
     * <p>Note that this returns a {@link MessageReceiver} and it may not what
     * may be thought of as a traditional entity executing the command.
     * For the object that invoked the command, check the
     * {@link Cause#root()} of the {@link #getCause()}.</p>
     *
     * @return The {@link MessageReceiver} to send any messages to.
     */
    default MessageChannel getMessageChannel() {
        return this.getCause().getContext()
            .get(EventContextKeys.MESSAGE_CHANNEL)
            .orElseGet(() -> MessageChannel.to(this.getCause().first(MessageReceiver.class).orElseGet(Sponge::getSystemSubject)));
    }

    /**
     * Gets the {@link ServerLocation} that this command is associated with.
     *
     * <p>The following are checked in order:
     *
     * <ul>
     *     <li>The {@link EventContextKeys#LOCATION}, if any</li>
     *     <li>{@link #getTargetBlock()}</li>
     *     <li>the location of the first locatable in the {@link Cause}</li>
     * </ul>
     *
     * @return The {@link ServerLocation}, if it exists
     */
    default Optional<ServerLocation> getLocation() {
        final Cause cause = this.getCause();
        final EventContext eventContext = cause.getContext();
        if (eventContext.containsKey(EventContextKeys.LOCATION)) {
            return eventContext.get(EventContextKeys.LOCATION);
        }

        final Optional<ServerLocation> optionalLocation = this.getTargetBlock().flatMap(BlockSnapshot::getLocation);
        if (optionalLocation.isPresent()) {
            return optionalLocation;
        }

        return cause.first(Locatable.class).map(Locatable::getServerLocation);
    }

    /**
     * Gets the {@link Vector3d} rotation that this command is associated with.
     *
     * <p>The following are checked in order:
     *
     * <ul>
     *     <li>The {@link EventContextKeys#ROTATION}, if any</li>
     *     <li>the rotation of the first {@link Entity} in the {@link Cause}</li>
     * </ul>
     *
     * @return The {@link Vector3d} rotation, if it exists
     */
    default Optional<Vector3d> getRotation() {
        final Cause cause = this.getCause();
        final EventContext eventContext = cause.getContext();
        if (eventContext.containsKey(EventContextKeys.ROTATION)) {
            return eventContext.get(EventContextKeys.ROTATION);
        }

        return cause.first(Entity.class).map(Entity::getRotation);
    }

    /**
     * Returns the target block {@link ServerLocation}, if applicable.
     *
     * <p>The following are checked in order:
     *
     * <ul>
     *     <li>The {@link EventContextKeys#BLOCK_TARGET}, if any</li>
     *     <li>The first {@link BlockSnapshot} in the {@link Cause}</li>
     * </ul>
     *
     * @return The {@link BlockSnapshot} if applicable, or an empty optional.
     */
    default Optional<BlockSnapshot> getTargetBlock() {
        return Optional.ofNullable(this.getCause().getContext().get(EventContextKeys.BLOCK_TARGET)
            .orElseGet(() -> this.getCause().first(BlockSnapshot.class).orElse(null)));
    }

    @Override
    default SubjectCollection getContainingCollection() {
        return getSubject().getContainingCollection();
    }

    @Override
    default SubjectReference asSubjectReference() {
        return getSubject().asSubjectReference();
    }

    @Override
    default boolean isSubjectDataPersisted() {
        return getSubject().isSubjectDataPersisted();
    }

    @Override
    default SubjectData getSubjectData() {
        return getSubject().getSubjectData();
    }

    @Override
    default SubjectData getTransientSubjectData() {
        return getSubject().getTransientSubjectData();
    }

    @Override
    default Tristate getPermissionValue(Set<Context> contexts, String permission) {
        return getSubject().getPermissionValue(contexts, permission);
    }

    @Override
    default boolean isChildOf(Set<Context> contexts, SubjectReference parent) {
        return getSubject().isChildOf(contexts, parent);
    }

    @Override
    default List<SubjectReference> getParents(Set<Context> contexts) {
        return getSubject().getParents();
    }

    @Override
    default Optional<String> getOption(Set<Context> contexts, String key) {
        return getSubject().getOption(contexts, key);
    }

    @Override
    default String getIdentifier() {
        return getSubject().getIdentifier();
    }

    @Override
    default Set<Context> getActiveContexts() {
        return getSubject().getActiveContexts();
    }

    /**
     * Sends a message to the {@link MessageChannel} as given by
     * {@link #getMessageChannel()}.
     *
     * @param message The message to send.
     */
    default void sendMessage(Text message) {
        getMessageChannel().send(message);
    }

    /**
     * Creates instances of the {@link CommandCause}.
     */
    interface Factory {

        /**
         * Creates the {@link CommandCause} from the {@link Cause}
         *
         * @param cause The {@link Cause}
         * @return The {@link CommandCause}
         */
        CommandCause create(Cause cause);
    }

}

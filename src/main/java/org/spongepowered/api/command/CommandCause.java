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

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.identity.Identified;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.SystemSubject;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.EventContext;
import org.spongepowered.api.event.EventContextKeys;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.SubjectProxy;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.plugin.PluginContainer;

import java.util.List;
import java.util.Optional;

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
 *     <li>{@link EventContextKeys#AUDIENCE}, which indicates the
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
@DoNotStore
public interface CommandCause extends SubjectProxy {

    /**
     * Creates a {@link CommandCause} from the current {@link Cause}.
     *
     * @return The {@link CommandCause}
     */
    static CommandCause create() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).create();
    }

    /**
     * Gets the {@link Cause} of the command invocation.
     *
     * @return The cause of the invocation.
     */
    Cause getCause();

    /**
     * @see Cause#getContext()
     */
    default EventContext getContext() {
        return this.getCause().getContext();
    }

    /**
     * @see Cause#root()
     */
    default Object root() {
        return this.getCause().root();
    }

    /**
     * @see Cause#first(Class)
     */
    default <T> Optional<T> first(final Class<T> target) {
        return this.getCause().first(target);
    }

    /**
     * @see Cause#last(Class)
     */
    default <T> Optional<T> last(final Class<T> target) {
        return this.getCause().last(target);
    }

    /**
     * @see Cause#before(Class)
     */
    default Optional<?> before(final Class<?> clazz) {
        return this.getCause().before(clazz);
    }

    /**
     * @see Cause#after(Class)
     */
    default Optional<?> after(final Class<?> clazz) {
        return this.getCause().after(clazz);
    }

    /**
     * @see Cause#contains(Object)
     */
    default boolean containsType(final Class<?> target) {
        return this.getCause().containsType(target);
    }

    /**
     * @see Cause#contains(Object)
     */
    default boolean contains(final Object object) {
        return this.getCause().contains(object);
    }

    /**
     * @see Cause#allOf(Class)
     */
    default <T> List<T> allOf(final Class<T> target) {
        return this.getCause().allOf(target);
    }

    /**
     * @see Cause#noneOf(Class)
     */
    default List<Object> noneOf(final Class<?> ignoredClass) {
        return this.getCause().noneOf(ignoredClass);
    }

    /**
     * @see Cause#all()
     */
    default List<Object> all() {
        return this.getCause().all();
    }

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
    Subject getSubject();

    /**
     * Gets the {@link Audience} that should be the target for any
     * messages sent by the command (by default).
     *
     * <p>The {@link Audience} will be selected in the following way
     * from the {@link Cause} in {@link #getCause()}:</p>
     *
     * <ul>
     *    <li>The {@link EventContextKeys#AUDIENCE}, if any</li>
     *    <li>An audience containing the <strong>first</strong>
     *    {@link Audience} in the {@link Cause}</li>
     *    <li>The SystemSubject {@link Audience}</li>
     * </ul>
     *
     * <p>Note that this returns a {@link Audience} and it may not what
     * may be thought of as a traditional entity executing the command.
     * For the object that invoked the command, check the
     * {@link Cause#root()} of the {@link #getCause()}.</p>
     *
     * @return The {@link Audience} to send any messages to.
     */
    Audience getAudience();

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
    Optional<ServerLocation> getLocation();

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
    Optional<Vector3d> getRotation();

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
    Optional<BlockSnapshot> getTargetBlock();

    /**
     * Sends a message to the {@link Audience} as given by
     * {@link #getAudience()}.
     *
     * @see Audience#sendMessage(Identified, Component)
     *
     * @param source The {@link Identified} to send a message from.
     * @param message The message to send.
     */
    void sendMessage(final Identified source, final Component message);

    /**
     * Sends a message to the {@link Audience} as given by
     * {@link #getAudience()}.
     *
     * @see Audience#sendMessage(Identity, Component)
     *
     * @param message The message to send.
     */
    void sendMessage(final Identity source, final Component message);

    /**
     * Creates instances of the {@link CommandCause}.
     */
    interface Factory {

        /**
         * Creates the {@link CommandCause} from the current {@link Cause}
         *
         * @return The {@link CommandCause}
         */
        CommandCause create();
    }

}

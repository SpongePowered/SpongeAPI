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
package org.spongepowered.api.command.registrar.tree;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.registrar.CommandRegistrar;

import java.util.function.Predicate;

/**
 * Builds a tree of command parameters for sending to clients. For use with
 * custom {@link CommandRegistrar}s and {@link Command.Raw}.
 */
public interface CommandTreeNode<T extends CommandTreeNode<T>> {

    /**
     * Creates a root node for the tree.
     *
     * @return The root node.
     */
    static CommandTreeNode<Root> root() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(NodeFactory.class).createRoot();
    }

    /**
     * Creates a node that uses its key as a literal.
     *
     * @return The literal.
     */
    static CommandTreeNode<Basic> literal() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(NodeFactory.class).createLiteral();
    }

    /**
     * Creates a child of this node with the given key that accepts a
     * non-literal argument.
     *
     * <p>The builder returned by this method is the same builder as that
     * invoked on. The child builder is provided in the {@code childNode}
     * node.</p>
     *
     * @param key The name of the child node
     * @param childNode The child node
     * @return This, for chaining.
     */
    T child(final String key, final CommandTreeNode.Argument<?> childNode);

    /**
     * Declares that this element will redirect processing to the given node
     * in this tree <strong>after</strong> this node has been processed.
     *
     * <p>The node that is provided here will not be executed and will not
     * be checked to see if its requirements are met. This node will act as
     * if its has the target node's children.</p>
     *
     * @param redirectTarget The node to redirect to
     * @return This, for chaining
     */
    T redirect(CommandTreeNode<?> redirectTarget);

    /**
     * Declares that this element can only be parsed by those with the given
     * requirement.
     *
     * @param requirement The requirement
     * @return This, for chaining
     */
    T requires(Predicate<CommandCause> requirement);

    /**
     * Declares that the node this {@link CommandTreeNode} represents is
     * executable, meaning that a command string that stops here is considered
     * complete.
     *
     * @return This, for chaining
     */
    T executable();

    /**
     * Declares that this node uses custom suggestions and, as such, tab
     * completions should query the server.
     *
     * @return This, for chaining.
     */
    T customSuggestions();

    /**
     * A {@link CommandTreeNode} that acts as the root of a command.
     */
    interface Root extends CommandTreeNode<Root> { }

    /**
     * A {@link CommandTreeNode} that can be used as a child.
     *
     * @param <T> The type of {@link CommandTreeNode}.
     */
    interface Argument<T extends CommandTreeNode<T>> extends CommandTreeNode<T> { }

    /**
     * A {@link CommandTreeNode} with no known properties to set.
     */
    interface Basic extends CommandTreeNode.Argument<Basic> { }

    /**
     * A {@link CommandTreeNode} that allows for a min-max range to be set.
     */
    interface Range<S extends Number> extends CommandTreeNode.Argument<Range<S>> {

        /**
         * Sets the minimum {@link S} acceptable for this parameter.
         *
         * @param min The minimum, or {@code null} if there is no minimum
         * @return This, for chaining
         */
        Range<S> min(@Nullable S min);

        /**
         * Sets the maximum {@link S} acceptable for this parameter.
         *
         * @param max The maximum, or {@code null} if there is no maximum
         * @return This, for chaining
         */
        Range<S> max(@Nullable S max);

    }

    /**
     * A {@link CommandTreeNode} that controls whether multiple entries
     * can be parsed.
     */
    interface Amount extends CommandTreeNode.Argument<Amount> {

        /**
         * Indicates that only one object can be selected by this parameter.
         * If this is not called, this element will default to allowing the
         * selection of multiple objects.
         *
         * @return This, for chaining.
         */
        Amount single();

    }

    /**
     * A {@link CommandTreeNode} that augments entity based parameters.
     */
    interface EntitySelection extends CommandTreeNode.Argument<EntitySelection> {

        /**
         * Indicates that only players can be selected. If not called, all
         * entities may selected by this element.
         *
         * @return This, for chaining.
         */
        EntitySelection playersOnly();

        /**
         * Indicates that only one entity can be selected by this parameter.
         * If this is not called, this element will default to allowing the
         * selection of multiple entities.
         *
         * @return This, for chaining.
         */
        EntitySelection single();

    }

    /**
     * A {@link CommandTreeNode} that allows for the setting of how a string
     * based parser will behave. By default, this parser will parse the next
     * word, or, if quoted, the quoted string.
     */
    interface StringParser extends CommandTreeNode.Argument<StringParser> {

        /**
         * Causes this string parser to only parse the next word.
         *
         * @return This, for chaining.
         */
        StringParser word();

        /**
         * Causes this string parser to parse the rest of the supplied string.
         *
         * @return This, for chaining.
         */
        StringParser greedy();

    }

    /**
     * Factory to create a root node.
     */
    interface NodeFactory {

        /**
         * Creates a root {@link CommandTreeNode}.
         *
         * @return The node
         */
        CommandTreeNode<Root> createRoot();

        /**
         * Creates a literal {@link CommandTreeNode}
         *
         * @return The node
         */
        CommandTreeNode<Basic> createLiteral();
    }

}

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

import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.command.Command;
import org.spongepowered.api.command.registrar.CommandRegistrarType;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents the client-side behavior of a {@link CommandTreeNode}, for use
 * with {@link CommandRegistrarType command registrars} that require such nodes
 * to specify client side behaviour (for example,
 * {@link Command.Raw raw commands}).
 *
 * <p>These types affect the following behaviours of client-side command
 * handling:</p>
 *
 * <ul>
 *     <li>The allowed form of an argument - i.e. how the client decides an
 *     argument will be accepted or not.</li>
 *     <li>The available tab-completions for a given argument (which may either
 *     be wholly client-side, or require a request to the server).</li>
 * </ul>
 *
 * <p>Some of these types may have an alternative
 * {@link CommandCompletionProviders completion provider} that may be used in
 * conjunction with this node type that provides alternative completions.</p>
 *
 * <p>Note that these types do not contain any parsing logic themselves, they
 * are purely used to inform the client of the behavior it should exhibit when
 * displaying and completing command strings.</p>
 */
@CatalogedBy(CommandTreeNodeTypes.class)
public interface CommandTreeNodeType<T extends CommandTreeNode<T>> extends DefaultedRegistryValue, ResourceKeyed {

    /**
     * Creates a {@link CommandTreeNode} that represents this
     * {@link CommandTreeNodeType}
     *
     * @return The new {@link CommandTreeNode}
     */
    T createNode();

}

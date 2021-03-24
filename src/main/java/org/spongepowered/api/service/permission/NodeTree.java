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
package org.spongepowered.api.service.permission;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.Tristate;

import java.util.Map;


/**
 * An immutable tree structure for determining node data. Any changes will
 * create new copies of the necessary tree objects.
 *
 * <p>This class is simply provided as a utility for plugins implementing
 * {@link PermissionService}. It is not a requirement that this class is used,
 * however the behaviour defined in {@link Subject} regarding implicit node
 * inheritance should be maintained.</p>
 *
 * <ul>
 *     <li>Keys are case-insensitive.</li>
 *     <li>Segments of nodes are split by the '.' character</li>
 * </ul>
 */
public interface NodeTree {

    /**
     * Create a new node tree with the given values, and a default value of
     * {@link Tristate#UNDEFINED}.
     *
     * @param values The values to set
     * @return The new node tree
     */
    static NodeTree of(final Map<String, Boolean> values) {
        return NodeTree.of(values, Tristate.UNDEFINED);
    }

    /**
     * Create a new node tree with the given values, and the specified root
     * fallback value.
     *
     * @param values The values to be contained in this node tree
     * @param defaultValue The fallback value for any completely undefined nodes
     * @return The newly created node tree
     */
    static NodeTree of(final Map<String, Boolean> values, final Tristate defaultValue) {
        return Sponge.game().factoryProvider().provide(Factory.class).ofBooleans(values, defaultValue);
    }

    /**
     * Create a new node tree with the given values, and a default value of
     * {@link Tristate#UNDEFINED}.
     *
     * @param values The values to set
     * @return The new node tree
     */
    static NodeTree ofTristates(final Map<String, Tristate> values) {
        return NodeTree.ofTristates(values, Tristate.UNDEFINED);
    }

    /**
     * Create a new node tree with the given values, and the specified root
     * fallback value.
     *
     * @param values The values to be contained in this node tree
     * @param defaultValue The fallback value for any completely undefined nodes
     * @return The newly created node tree
     */
    static NodeTree ofTristates(final Map<String, Tristate> values, final Tristate defaultValue) {
        return Sponge.game().factoryProvider().provide(Factory.class).ofTristates(values, defaultValue);
    }

    /**
     * Returns the value assigned to a specific node, or the nearest parent
     * value in the tree if the node itself is undefined.
     *
     * @param node The path to get the node value at
     * @return The tristate value for the given node
     */
    Tristate get(String node);

    /**
     * Get the value of the root node in this tree.
     *
     * @return the root node value
     */
    Tristate rootValue();

    /**
     * Return a modified tree with the provided root node value.
     *
     * @param state the new state for the root node
     * @return a tree reflecting the changed state, leaving the
     *      receiver unmodified
     */
    NodeTree withRootValue(Tristate state);

    /**
     * Convert this node tree into a map of the defined nodes in this tree.
     *
     * @return An immutable map representation of the nodes defined in this tree
     */
    Map<String, Boolean> asMap();

    /**
     * Return a new NodeTree instance with a single changed value.
     *
     * @param node The node path to change the value of
     * @param value The value to change, or UNDEFINED to remove
     * @return The new, modified node tree
     */
    NodeTree withValue(String node, Tristate value);

    /**
     * Return a modified new node tree with the specified values set.
     *
     * @param values The values to set
     * @return The new node tree
     */
    NodeTree withAll(Map<String, Boolean> values);

    /**
     * Return a modified new node tree with the specified values set.
     *
     * @param values The values to set
     * @return The new node tree
     */
    NodeTree withAllTristates(Map<String, Tristate> values);

    interface Factory {

        NodeTree ofBooleans(final Map<String, Boolean> values, final Tristate defaultValue);

        NodeTree ofTristates(final Map<String, Tristate> values, final Tristate defaultValue);

    }
}

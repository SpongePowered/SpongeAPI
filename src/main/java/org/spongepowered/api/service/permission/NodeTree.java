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

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.util.Tristate;

import java.util.HashMap;
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
public class NodeTree {

    private static final Splitter NODE_SPLITTER = Splitter.on('.');
    private final Node rootNode;

    private NodeTree(Tristate value) {
        this.rootNode = new Node(new HashMap<>());
        this.rootNode.value = value;
    }

    private NodeTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * Create a new node tree with the given values, and a default value of
     * {@link Tristate#UNDEFINED}.
     *
     * @param values The values to set
     * @return The new node tree
     */
    public static NodeTree of(Map<String, Boolean> values) {
        return of(values, Tristate.UNDEFINED);
    }

    /**
     * Create a new node tree with the given values, and the specified root
     * fallback value.
     *
     * @param values The values to be contained in this node tree
     * @param defaultValue The fallback value for any completely undefined nodes
     * @return The newly created node tree
     */
    public static NodeTree of(Map<String, Boolean> values, Tristate defaultValue) {
        NodeTree newTree = new NodeTree(defaultValue);
        for (Map.Entry<String, Boolean> value : values.entrySet()) {
            Iterable<String> parts = NODE_SPLITTER.split(value.getKey().toLowerCase());
            Node currentNode = newTree.rootNode;
            for (String part : parts) {
                if (currentNode.children.containsKey(part)) {
                    currentNode = currentNode.children.get(part);
                } else {
                    Node newNode = new Node(new HashMap<>());
                    currentNode.children.put(part, newNode);
                    currentNode = newNode;
                }
            }
            currentNode.value = Tristate.fromBoolean(value.getValue());
        }
        return newTree;
    }

    /**
     * Returns the value assigned to a specific node, or the nearest parent
     * value in the tree if the node itself is undefined.
     *
     * @param node The path to get the node value at
     * @return The tristate value for the given node
     */
    public Tristate get(String node) {
        Iterable<String> parts = NODE_SPLITTER.split(node.toLowerCase());
        Node currentNode = this.rootNode;
        Tristate lastUndefinedVal = Tristate.UNDEFINED;
        for (String str : parts) {
            if (!currentNode.children.containsKey(str)) {
                break;
            }
            currentNode = currentNode.children.get(str);
            if (currentNode.value != Tristate.UNDEFINED) {
                lastUndefinedVal = currentNode.value;
            }
        }
        return lastUndefinedVal;

    }

    /**
     * Convert this node tree into a map of the defined nodes in this tree.
     *
     * @return An immutable map representation of the nodes defined in this tree
     */
    public Map<String, Boolean> asMap() {
        ImmutableMap.Builder<String, Boolean> ret = ImmutableMap.builder();
        for (Map.Entry<String, Node> ent : this.rootNode.children.entrySet()) {
            populateMap(ret, ent.getKey(), ent.getValue());
        }
        return ret.build();
    }

    private void populateMap(ImmutableMap.Builder<String, Boolean> values, String prefix, Node currentNode) {
        if (currentNode.value != Tristate.UNDEFINED) {
            values.put(prefix, currentNode.value.asBoolean());
        }
        for (Map.Entry<String, Node> ent : currentNode.children.entrySet()) {
            populateMap(values, prefix + '.' + ent.getKey(), ent.getValue());
        }
    }

    /**
     * Return a new NodeTree instance with a single changed value.
     *
     * @param node The node path to change the value of
     * @param value The value to change, or UNDEFINED to remove
     * @return The new, modified node tree
     */
    public NodeTree withValue(String node, Tristate value) {
        Iterable<String> parts = NODE_SPLITTER.split(node.toLowerCase());
        Node newRoot = new Node(new HashMap<>(this.rootNode.children));
        Node newPtr = newRoot;
        Node currentPtr = this.rootNode;

        newPtr.value = currentPtr == null ? Tristate.UNDEFINED : currentPtr.value;
        for (String part : parts) {
            Node oldChild = currentPtr == null ? null : currentPtr.children.get(part);
            Node newChild = new Node(oldChild != null ? new HashMap<>(oldChild.children) : new HashMap<>());
            newPtr.children.put(part, newChild);
            currentPtr = oldChild;
            newPtr = newChild;
        }
        newPtr.value = value;
        return new NodeTree(newRoot);
    }

    /**
     * Return a modified new node tree with the specified values set.
     *
     * @param values The values to set
     * @return The new node tree
     */
    public NodeTree withAll(Map<String, Tristate> values) {
        NodeTree ret = this;
        for (Map.Entry<String, Tristate> ent : values.entrySet()) {
            ret = ret.withValue(ent.getKey(), ent.getValue());
        }
        return ret;
    }

    private static class Node {

        final Map<String, Node> children;
        Tristate value = Tristate.UNDEFINED;

        Node(Map<String, Node> children) {
            this.children = children;
        }
    }
}

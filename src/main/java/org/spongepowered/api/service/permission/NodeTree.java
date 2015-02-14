/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.util.Tristate;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * An immutable tree structure for determining node data. Any changes will create new copies of the necessary tree objects.
 * Keys are case-insensitive.
 * Segments of nodes are split by the '.' character
 */
public class NodeTree {

    private static final Pattern SPLIT_REGEX = Pattern.compile("\\.");
    private final Node rootNode;


    private NodeTree(Tristate value) {
        this.rootNode = new Node(new HashMap<String, Node>());
        this.rootNode.value = value;
    }

    private NodeTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * Create a new node tree with the given values, and a default value of UNDEFINED.
     *
     * @param values The values to set
     * @return The new node tree
     */
    public static NodeTree of(Map<String, Boolean> values) {
        return of(values, Tristate.UNDEFINED);
    }

    /**
     * Create a new node tree with the given values, and the specified root fallback value.
     *
     * @param values The values to be contained in this node tree
     * @param defaultValue The fallback value for any completely undefined nodes
     * @return The newly created node tree
     */
    public static NodeTree of(Map<String, Boolean> values, Tristate defaultValue) {
        NodeTree newTree = new NodeTree(defaultValue);
        for (Map.Entry<String, Boolean> value : values.entrySet()) {
            String[] parts = SPLIT_REGEX.split(value.getKey().toLowerCase());
            Node currentNode = newTree.rootNode;
            for (String part : parts) {
                if (currentNode.children.containsKey(part)) {
                    currentNode = currentNode.children.get(part);
                } else {
                    Node newNode = new Node(new HashMap<String, Node>());
                    currentNode.children.put(part, newNode);
                    currentNode = newNode;
                }
            }
            currentNode.value = Tristate.fromBoolean(value.getValue());
        }
        return newTree;
    }

    /**
     * Returns the value assigned to a specific node, or the nearest parent value in the tree if the node itself is undefined.
     *
     * @param node The path to get the node value at
     * @return The tristate value for the given node
     */
    public Tristate get(String node) {
        String[] parts = SPLIT_REGEX.split(node.toLowerCase());
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
        String[] parts = SPLIT_REGEX.split(node.toLowerCase());
        Node newRoot = new Node(new HashMap<String, Node>(this.rootNode.children));
        Node newPtr = newRoot;
        Node currentPtr = this.rootNode;

        newPtr.value = currentPtr == null ? Tristate.UNDEFINED : currentPtr.value;
        for (String part : parts) {
            Node oldChild = currentPtr == null ? null : currentPtr.children.get(part);
            Node newChild = new Node(oldChild != null ? new HashMap<String, Node>(oldChild.children) : new HashMap<String, Node>());
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

        private final Map<String, Node> children;
        private Tristate value = Tristate.UNDEFINED;

        private Node(Map<String, Node> children) {
            this.children = children;
        }
    }
}

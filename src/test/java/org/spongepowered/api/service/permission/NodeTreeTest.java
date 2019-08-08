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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NodeTreeTest {

    @Test
    public void testAsMap() {
        final Map<String, Integer> testPermissions = new HashMap<>();
        testPermissions.put("generate.rainbow", 1);
        testPermissions.put("generate.sunset", -1);
        testPermissions.put("generate", 1);
        testPermissions.put("generate.thunderstorm.explosive", -1);

        WeightedNodeTree oldTree = WeightedNodeTree.of(testPermissions);

        assertEquals(testPermissions, oldTree.asMap());
    }

    @Test
    public void testWithValue() {
        final Map<String, Integer> testPermissions = new HashMap<>();
        testPermissions.put("generate.rainbow", 1);
        testPermissions.put("generate.sunset", -1);
        testPermissions.put("generate", 1);
        testPermissions.put("generate.thunderstorm.explosive", -1);

        WeightedNodeTree oldTree = WeightedNodeTree.of(testPermissions);
        assertEquals(-1, oldTree.get("generate.thunderstorm.explosive"));
        WeightedNodeTree newTree = oldTree.withValue("generate.thunderstorm.explosive", 1);
        assertEquals(-1, oldTree.get("generate.thunderstorm.explosive"));
        assertEquals(1, newTree.get("generate.thunderstorm.explosive"));
    }

    @Test
    public void testWithAll() {
        final Map<String, Integer> testPermissions = new HashMap<>();
        testPermissions.put("generate.rainbow", 1);
        testPermissions.put("generate.sunset", -1);
        testPermissions.put("generate", 1);
        testPermissions.put("generate.thunderstorm.explosive", -1);

        WeightedNodeTree oldTree = WeightedNodeTree.of(testPermissions);

        final Map<String, Integer> newPermissions = new HashMap<>();
        newPermissions.put("generate.sunset.red", 1);
        newPermissions.put("generate.thunderstorm.explosive", 0);
        newPermissions.put("something.new", -1);

        WeightedNodeTree newTree = oldTree.withAll(newPermissions);

        assertEquals(-1, oldTree.get("generate.sunset.red"));
        assertEquals(1, newTree.get("generate.sunset.red"));

        assertEquals(-1, oldTree.get("generate.thunderstorm.explosive"));
        assertEquals(0, newTree.get("generate.thunderstorm.explosive"));

        assertEquals(0, oldTree.get("something.new"));
        assertEquals(-1, newTree.get("something.new"));
    }

    @Test
    public void testCreateFromValues() {
        final Map<String, Integer> testPermissions = new HashMap<>();
        testPermissions.put("generate.rainbow", 1);
        testPermissions.put("generate.sunset", -1);
        testPermissions.put("generate", 1);
        testPermissions.put("generate.thunderstorm.explosive", -1);

        WeightedNodeTree nodes = WeightedNodeTree.of(testPermissions, 0);

        assertEquals(1, nodes.get("generate.rainbow"));
        assertEquals(1, nodes.get("generate.rainbow.double"));
        assertEquals(-1, nodes.get("generate.sunset"));
        assertEquals(-1, nodes.get("generate.sunset.east"));
        assertEquals(1, nodes.get("generate.thunderstorm"));
        assertEquals(-1, nodes.get("generate.thunderstorm.explosive"));
        assertEquals(0, nodes.get("random.perm"));
    }
}

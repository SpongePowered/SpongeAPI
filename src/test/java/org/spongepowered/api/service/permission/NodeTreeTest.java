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

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.spongepowered.api.util.Tristate;

import java.util.HashMap;
import java.util.Map;

public class NodeTreeTest {

    @Test
    public void testAsMap() {
        final Map<String, Boolean> testPermissions = new HashMap<String, Boolean>();
        testPermissions.put("generate.rainbow", true);
        testPermissions.put("generate.sunset", false);
        testPermissions.put("generate", true);
        testPermissions.put("generate.thunderstorm.explosive", false);

        NodeTree oldTree = NodeTree.of(testPermissions);

        assertEquals(testPermissions, oldTree.asMap());
    }

    @Test
    public void testWithValue() throws Exception {
        final Map<String, Boolean> testPermissions = new HashMap<String, Boolean>();
        testPermissions.put("generate.rainbow", true);
        testPermissions.put("generate.sunset", false);
        testPermissions.put("generate", true);
        testPermissions.put("generate.thunderstorm.explosive", false);

        NodeTree oldTree = NodeTree.of(testPermissions);
        assertEquals(Tristate.FALSE, oldTree.get("generate.thunderstorm.explosive"));
        NodeTree newTree = oldTree.withValue("generate.thunderstorm.explosive", Tristate.TRUE);
        assertEquals(Tristate.FALSE, oldTree.get("generate.thunderstorm.explosive"));
        assertEquals(Tristate.TRUE, newTree.get("generate.thunderstorm.explosive"));
    }

    @Test
    public void testWithAll() throws Exception {
        final Map<String, Boolean> testPermissions = new HashMap<String, Boolean>();
        testPermissions.put("generate.rainbow", true);
        testPermissions.put("generate.sunset", false);
        testPermissions.put("generate", true);
        testPermissions.put("generate.thunderstorm.explosive", false);

        NodeTree oldTree = NodeTree.of(testPermissions);

        final Map<String, Tristate> newPermissions = new HashMap<String, Tristate>();
        newPermissions.put("generate.sunset.red", Tristate.TRUE);
        newPermissions.put("generate.thunderstorm.explosive", Tristate.UNDEFINED);
        newPermissions.put("something.new", Tristate.FALSE);

        NodeTree newTree = oldTree.withAll(newPermissions);

        assertEquals(Tristate.FALSE, oldTree.get("generate.sunset.red"));
        assertEquals(Tristate.TRUE, newTree.get("generate.sunset.red"));

        assertEquals(Tristate.FALSE, oldTree.get("generate.thunderstorm.explosive"));
        assertEquals(Tristate.UNDEFINED, newTree.get("generate.thunderstorm.explosive"));

        assertEquals(Tristate.UNDEFINED, oldTree.get("something.new"));
        assertEquals(Tristate.FALSE, newTree.get("something.new"));
    }

    @Test
    public void testCreateFromValues() throws Exception {
        final Map<String, Boolean> testPermissions = new HashMap<String, Boolean>();
        testPermissions.put("generate.rainbow", true);
        testPermissions.put("generate.sunset", false);
        testPermissions.put("generate", true);
        testPermissions.put("generate.thunderstorm.explosive", false);

        NodeTree nodes = NodeTree.of(testPermissions, Tristate.UNDEFINED);

        assertEquals(Tristate.TRUE, nodes.get("generate.rainbow"));
        assertEquals(Tristate.TRUE, nodes.get("generate.rainbow.double"));
        assertEquals(Tristate.FALSE, nodes.get("generate.sunset"));
        assertEquals(Tristate.FALSE, nodes.get("generate.sunset.east"));
        assertEquals(Tristate.TRUE, nodes.get("generate.thunderstorm"));
        assertEquals(Tristate.FALSE, nodes.get("generate.thunderstorm.explosive"));
        assertEquals(Tristate.UNDEFINED, nodes.get("random.perm"));
    }
}

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


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.spongepowered.api.util.Tristate;

import java.util.HashMap;
import java.util.Map;

class NodeTreeTest {

    @Test
    void testAsMap() {
        final Map<String, Boolean> testPermissions = new HashMap<>();
        testPermissions.put("generate.rainbow", true);
        testPermissions.put("generate.sunset", false);
        testPermissions.put("generate", true);
        testPermissions.put("generate.thunderstorm.explosive", false);

        final NodeTree oldTree = NodeTree.of(testPermissions);

        Assertions.assertEquals(testPermissions, oldTree.asMap());
    }

    @Test
    void testWithValue() throws Exception {
        final Map<String, Boolean> testPermissions = new HashMap<>();
        testPermissions.put("generate.rainbow", true);
        testPermissions.put("generate.sunset", false);
        testPermissions.put("generate", true);
        testPermissions.put("generate.thunderstorm.explosive", false);

        final NodeTree oldTree = NodeTree.of(testPermissions);
        Assertions.assertEquals(Tristate.FALSE, oldTree.get("generate.thunderstorm.explosive"));
        final NodeTree newTree = oldTree.withValue("generate.thunderstorm.explosive", Tristate.TRUE);
        Assertions.assertEquals(Tristate.FALSE, oldTree.get("generate.thunderstorm.explosive"));
        Assertions.assertEquals(Tristate.TRUE, newTree.get("generate.thunderstorm.explosive"));
    }

    @Test
    void testWithAll() throws Exception {
        final Map<String, Boolean> testPermissions = new HashMap<>();
        testPermissions.put("generate.rainbow", true);
        testPermissions.put("generate.sunset", false);
        testPermissions.put("generate", true);
        testPermissions.put("generate.thunderstorm.explosive", false);

        final NodeTree oldTree = NodeTree.of(testPermissions);

        final Map<String, Tristate> newPermissions = new HashMap<>();
        newPermissions.put("generate.sunset.red", Tristate.TRUE);
        newPermissions.put("generate.thunderstorm.explosive", Tristate.UNDEFINED);
        newPermissions.put("something.new", Tristate.FALSE);

        final NodeTree newTree = oldTree.withAllTristates(newPermissions);

        Assertions.assertEquals(Tristate.FALSE, oldTree.get("generate.sunset.red"));
        Assertions.assertEquals(Tristate.TRUE, newTree.get("generate.sunset.red"));

        Assertions.assertEquals(Tristate.FALSE, oldTree.get("generate.thunderstorm.explosive"));
        Assertions.assertEquals(Tristate.UNDEFINED, newTree.get("generate.thunderstorm.explosive"));

        Assertions.assertEquals(Tristate.UNDEFINED, oldTree.get("something.new"));
        Assertions.assertEquals(Tristate.FALSE, newTree.get("something.new"));
    }

    @Test
    void testCreateFromValues() throws Exception {
        final Map<String, Boolean> testPermissions = new HashMap<>();
        testPermissions.put("generate.rainbow", true);
        testPermissions.put("generate.sunset", false);
        testPermissions.put("generate", true);
        testPermissions.put("generate.thunderstorm.explosive", false);

        final NodeTree nodes = NodeTree.of(testPermissions, Tristate.UNDEFINED);

        Assertions.assertEquals(Tristate.TRUE, nodes.get("generate.rainbow"));
        Assertions.assertEquals(Tristate.TRUE, nodes.get("generate.rainbow.double"));
        Assertions.assertEquals(Tristate.FALSE, nodes.get("generate.sunset"));
        Assertions.assertEquals(Tristate.FALSE, nodes.get("generate.sunset.east"));
        Assertions.assertEquals(Tristate.TRUE, nodes.get("generate.thunderstorm"));
        Assertions.assertEquals(Tristate.FALSE, nodes.get("generate.thunderstorm.explosive"));
        Assertions.assertEquals(Tristate.UNDEFINED, nodes.get("random.perm"));
    }
}

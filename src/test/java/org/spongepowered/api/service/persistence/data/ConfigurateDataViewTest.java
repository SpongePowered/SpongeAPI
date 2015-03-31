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

package org.spongepowered.api.service.persistence.data;

import static org.junit.Assert.assertTrue;

import com.google.common.collect.Lists;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.SimpleConfigurationNode;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ConfigurateDataViewTest {

    @Test
    public void testNodeToData() {
        ConfigurationNode node = SimpleConfigurationNode.root();
        node.getNode("foo","int").setValue(1);
        node.getNode("foo", "double").setValue(10.0D);
        node.getNode("foo", "long").setValue(Long.MAX_VALUE);
        List<String> stringList = Lists.newArrayList();
        for (int i = 0; i < 100; i ++) {
            stringList.add("String" + i);
        }
        node.getNode("foo", "stringList").setValue(stringList);
        List<SimpleData> dataList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            dataList.add(new SimpleData(i, 10.0 + i, "String" + i, Collections.<String>emptyList()));
        }
        node.getNode("foo", "nested", "Data").setValue(dataList);

        DataContainer manual = new MemoryDataContainer();
        manual.set(DataQuery.of("foo", "int"), 1);
        manual.set(DataQuery.of("foo", "double"), 10.0D);
        manual.set(DataQuery.of("foo", "long"), Long.MAX_VALUE);
        manual.set(DataQuery.of("foo", "stringList"), stringList);
        manual.set(DataQuery.of("foo", "nested", "Data"), dataList);

        DataView container = ConfigurateTranslator.instance().translateFrom(node);
        assertTrue(manual.equals(container));
        ConfigurationNode translated = ConfigurateTranslator.instance().translateData(container);
        // assertTrue(node.equals(translated)); // TODO Pending Configurate equals implementation
    }

}

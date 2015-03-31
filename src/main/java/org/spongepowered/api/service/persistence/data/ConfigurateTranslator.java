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

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.service.persistence.data.DataQuery.of;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.SimpleConfigurationNode;

import java.util.Map;

/**
 * A translator for translating {@link DataView}s into {@link
 * ConfigurationNode}s.
 */
public final class ConfigurateTranslator implements DataTranslator<ConfigurationNode> {

    private static final ConfigurateTranslator instance = new ConfigurateTranslator();

    private ConfigurateTranslator() {
    }

    /**
     * Get the instance of this translator.
     *
     * @return The instance of this translator
     */
    public static ConfigurateTranslator instance() {
        return instance;
    }

    private static void populateNode(ConfigurationNode node, DataView container) {
        checkNotNull(node);
        checkNotNull(container);
        Map<DataQuery, Object> values = container.getValues(false);
        for (Map.Entry<DataQuery, Object> entry : values.entrySet()) {
            node.getNode(entry.getKey().getParts()).setValue(entry.getValue());
        }
    }

    private static DataView translateFromNode(ConfigurationNode node) {
        checkNotNull(node);
        DataContainer dataContainer = new MemoryDataContainer();
        if (node.getValue() != null) {
            if (node.getKey() == null) {
                translateMapOrList(node, dataContainer);
            } else {
                dataContainer.set(of('.', node.getKey().toString()), node.getValue());
            }
        }
        return dataContainer;
    }

    @SuppressWarnings("unchecked")
    private static void translateMapOrList(ConfigurationNode node, DataView container) {
        Object value = node.getValue();
        if (value instanceof Map) {
            for (Map.Entry<Object, Object> entry : ((Map<Object, Object>) value).entrySet()) {
                container.set(of('.', entry.getKey().toString()), entry.getValue());
            }
        } else if (value != null) {
            container.set(of(node.getKey().toString()), value);
        }

    }

    @Override
    public ConfigurationNode translateData(DataView container) {
        ConfigurationNode node = SimpleConfigurationNode.root();
        translateContainerToData(node, container);
        return node;
    }

    @Override
    public void translateContainerToData(ConfigurationNode node, DataView container) {
        ConfigurateTranslator.populateNode(node, container);
    }

    @Override
    public DataView translateFrom(ConfigurationNode node) {
        return ConfigurateTranslator.translateFromNode(node);
    }

}

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
package org.spongepowered.api.locale.config;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.locale.RemoteDictionary;
import org.spongepowered.api.locale.bundle.ResourceBundleDictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Represents a {@link RemoteDictionary} that is loaded by Configurate.
 */
public interface ConfigDictionary extends RemoteDictionary, ResourceBundleDictionary<ConfigDictionary.ConfigResourceBundle> {

    /**
     * Returns the {@link ConfigurationLoader} for this Dictionary for the
     * specified {@link Locale}.
     *
     * @return Config loader
     */
    default ConfigurationLoader getLoader(Locale locale) {
        checkNotNull(locale, "locale");
        return HoconConfigurationLoader.builder().setSource(() -> new BufferedReader(new InputStreamReader(getSource(locale)))).build();
    }

    /**
     * Returns the {@link ConfigurationLoader} for the default {@link Locale}.
     *
     * @return Config loader
     */
    default ConfigurationLoader getLoader() {
        return getLoader(getDefaultLocale());
    }

    /**
     * Loads the specified {@link Locale}.
     *
     * @param locale Locale to load
     * @return Loaded ConfigurationNode
     * @throws IOException
     */
    default ConfigurationNode load(Locale locale) throws IOException {
        return getLoader(locale).load();
    }

    /**
     * Loads the default {@link Locale}.
     *
     * @return Loaded ConfigurationNode
     * @throws IOException
     */
    default ConfigurationNode load() throws IOException {
        return load(getDefaultLocale());
    }

    /**
     * Returns the ConfigurationNode for the specified {@link Locale}.
     *
     * @param locale Locale to get node for
     * @return Result node
     */
    ConfigurationNode getNode(Locale locale);

    /**
     * Returns the ConfigurationNode for the default {@link Locale}.
     *
     * @return Result node
     */
    default ConfigurationNode getNode() {
        return getNode(getDefaultLocale());
    }

    /**
     * Represents a {@link ResourceBundle} wrapper for a {@link ConfigurationNode}.
     */
    final class ConfigResourceBundle extends ResourceBundle {

        final ConfigurationNode node;

        ConfigResourceBundle(ConfigurationNode node) {
            this.node = checkNotNull(node, "node");
        }

        /**
         * Returns the wrapped node.
         *
         * @return Wrapped node
         */
        public ConfigurationNode getNode() {
            return this.node;
        }

        @Override
        protected Object handleGetObject(String key) {
            checkNotNull(key, "key");
            return this.node.getNode(key).getString();
        }

        @Override
        public Enumeration<String> getKeys() {
            return Collections.enumeration(this.node.getChildrenList().stream()
                    .map(node -> node.getKey().toString()).collect(Collectors.toList()));
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("node", this.node)
                    .toString();
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.node);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof ConfigResourceBundle && ((ConfigResourceBundle) obj).node.equals(this.node);
        }

    }

}

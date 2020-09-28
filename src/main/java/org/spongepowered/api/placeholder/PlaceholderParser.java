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
package org.spongepowered.api.placeholder;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.plugin.PluginContainer;

import java.util.function.Function;

/**
 * Provides the logic of how to parse a placeholder token.
 */
@CatalogedBy(PlaceholderParsers.class)
public interface PlaceholderParser extends CatalogType {

    /**
     * Returns a {@link Builder} that allows for the creation of simple
     * {@link PlaceholderParser}s.
     *
     * @return The {@link Builder}
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Creates a {@link Component} based on the provided {@link PlaceholderContext}.
     *
     * <p>This method should not throw an error, instead returning
     * {@link Component#empty()} if the supplied {@link PlaceholderContext} is not
     * valid.</p>
     *
     * @param placeholderContext The {@link PlaceholderContext}
     * @return The {@link Component}
     */
    Component parse(PlaceholderContext placeholderContext);

    /**
     * A builder that creates {@link PlaceholderParser}
     */
    interface Builder extends ResettableBuilder<PlaceholderParser, Builder> {

        /**
         * The {@link ResourceKey} that represents this parser.
         *
         * @param resourceKey The {@link ResourceKey}
         * @return This builder, for chaining
         */
        PlaceholderParser.Builder key(ResourceKey resourceKey);

        /**
         * The function that converts a {@link PlaceholderContext} to {@link Component}
         *
         * @param parser The function
         * @return This builder, for chaining
         */
        PlaceholderParser.Builder parser(Function<PlaceholderContext, Component> parser);

        /**
         * Builds a {@link PlaceholderParser}
         *
         * @return The parser
         * @throws IllegalStateException if the plugin, ID or parser has not
         *      been has not been specified.
         */
        PlaceholderParser build() throws IllegalStateException;

    }

}

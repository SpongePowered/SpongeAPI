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
package org.spongepowered.api.command.registrar.tree;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * The {@link CommandCompletionProvider completion providers} available to raw
 * command providers.
 */
public final class CommandCompletionProviders {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Instructs the node represented by a {@link CommandTreeNode} to display
     * all known {@link Recipe recipes}.
     *
     * <p>This provider is intended for use with a {@link ResourceKey} parser.
     * </p>
     */
    public static final DefaultedRegistryReference<CommandCompletionProvider> ALL_RECIPES = CommandCompletionProviders.key(ResourceKey.minecraft("all_recipes"));

    /**
     * Instructs the node represented by a {@link CommandTreeNode} to display
     * all known {@link SoundType sounds}.
     *
     * <p>This provider is intended for use with a {@link ResourceKey} parser.
     * </p>
     */
    public static final DefaultedRegistryReference<CommandCompletionProvider> AVAILABLE_SOUNDS = CommandCompletionProviders.key(ResourceKey.minecraft("available_sounds"));

    /**
     * Instructs the node represented by a {@link CommandTreeNode} to display
     * all known {@link Entity entities} that may be summoned using the
     * vanilla {@code /summon} command.
     *
     * <p>This provider is intended for use with
     * {@link CommandTreeNodeTypes#RESOURCE_LOCATION}</p> <!-- TODO: review command node types -->
     */
    public static final DefaultedRegistryReference<CommandCompletionProvider> SUMMONABLE_ENTITIES = CommandCompletionProviders.key(ResourceKey.minecraft("summonable_entities"));

    // SORTFIELDS:OFF

    // @formatter:on

    private CommandCompletionProviders() {
    }

    public static Registry<CommandCompletionProvider> registry() {
        return Sponge.game().registry(RegistryTypes.COMMAND_COMPLETION_PROVIDER);
    }

    private static DefaultedRegistryReference<CommandCompletionProvider> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.COMMAND_COMPLETION_PROVIDER, location).asDefaultedReference(Sponge::game);
    }

}

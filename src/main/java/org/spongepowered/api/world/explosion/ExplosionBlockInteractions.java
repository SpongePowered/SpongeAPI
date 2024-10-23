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
package org.spongepowered.api.world.explosion;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryTypes;

public final class ExplosionBlockInteractions {

    public static final DefaultedRegistryReference<ExplosionBlockInteraction> DESTROY = ExplosionBlockInteractions.key(ResourceKey.sponge("destroy"));

    public static final DefaultedRegistryReference<ExplosionBlockInteraction> DESTROY_WITH_DECAY = ExplosionBlockInteractions.key(ResourceKey.sponge("destroy_with_decay"));

    public static final DefaultedRegistryReference<ExplosionBlockInteraction> KEEP = ExplosionBlockInteractions.key(ResourceKey.sponge("keep"));

    public static final DefaultedRegistryReference<ExplosionBlockInteraction> TRIGGER_BLOCK = ExplosionBlockInteractions.key(ResourceKey.sponge("trigger_block"));

    private ExplosionBlockInteractions() {
    }

    public static Registry<ExplosionBlockInteraction> registry() {
        return Sponge.game().registry(RegistryTypes.EXPLOSION_BLOCK_INTERACTION);
    }

    private static DefaultedRegistryReference<ExplosionBlockInteraction> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.EXPLOSION_BLOCK_INTERACTION, location).asDefaultedReference(Sponge::game);
    }
}

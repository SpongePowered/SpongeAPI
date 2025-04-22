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
package org.spongepowered.api.world;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.world.volume.game.SignalAwareVolume;

@RegistryScopes(scopes = RegistryScope.GAME)
public final class SignalTypes {

    /**
     * Powers neighbours.
     */
    public static final DefaultedRegistryReference<SignalType> WEAK = SignalTypes.key(ResourceKey.sponge("weak"));

    /**
     * Goes through neighbours powering their neighbours.
     */
    public static final DefaultedRegistryReference<SignalType> STRONG = SignalTypes.key(ResourceKey.sponge("strong"));

    /**
     * The combination of {@link #WEAK} and {@link #STRONG} signals.<br>
     * Usually depends on block properties to choose between these two signals
     * (e.g. if the block {@link SignalAwareVolume#canConductSignal(int, int, int)}).
     */
    public static final DefaultedRegistryReference<SignalType> COMPOSITE = SignalTypes.key(ResourceKey.sponge("composite"));

    /**
     * Doesn't directly power anything but can be extracted
     * by some blocks (e.g. {@link BlockTypes#COMPARATOR}).
     */
    public static final DefaultedRegistryReference<SignalType> ANALOG = SignalTypes.key(ResourceKey.sponge("analog"));

    private SignalTypes() {
    }

    public static Registry<SignalType> registry() {
        return Sponge.game().registry(RegistryTypes.SIGNAL_TYPE);
    }

    private static DefaultedRegistryReference<SignalType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.SIGNAL_TYPE, location).asDefaultedReference(Sponge::game);
    }
}

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
package org.spongepowered.api.data.type;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class JigsawBlockOrientations {

    // @formatter:off

    public static final DefaultedRegistryReference<JigsawBlockOrientation> DOWN_EAST = JigsawBlockOrientations.key(ResourceKey.sponge("down_east"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> DOWN_NORTH = JigsawBlockOrientations.key(ResourceKey.sponge("down_north"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> DOWN_SOUTH = JigsawBlockOrientations.key(ResourceKey.sponge("down_south"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> DOWN_WEST = JigsawBlockOrientations.key(ResourceKey.sponge("down_west"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> UP_EAST = JigsawBlockOrientations.key(ResourceKey.sponge("up_east"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> UP_NORTH = JigsawBlockOrientations.key(ResourceKey.sponge("up_north"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> UP_SOUTH = JigsawBlockOrientations.key(ResourceKey.sponge("up_south"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> UP_WEST = JigsawBlockOrientations.key(ResourceKey.sponge("up_west"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> WEST_UP = JigsawBlockOrientations.key(ResourceKey.sponge("west_up"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> EAST_UP = JigsawBlockOrientations.key(ResourceKey.sponge("east_up"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> NORTH_UP = JigsawBlockOrientations.key(ResourceKey.sponge("north_up"));
    public static final DefaultedRegistryReference<JigsawBlockOrientation> SOUTH_UP = JigsawBlockOrientations.key(ResourceKey.sponge("south_up"));

    // @formatter:on

    private JigsawBlockOrientations() {
    }

    public static Registry<JigsawBlockOrientation> registry() {
        return Sponge.game().registry(RegistryTypes.JIGSAW_BLOCK_ORIENTATION);
    }

    private static DefaultedRegistryReference<JigsawBlockOrientation> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.JIGSAW_BLOCK_ORIENTATION, location).asDefaultedReference(Sponge::game);
    }
}

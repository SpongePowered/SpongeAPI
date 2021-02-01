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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPackSerializable;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.util.ResourceKeyedBuilder;
import org.spongepowered.api.world.biome.BiomeSampler;

import java.util.Optional;

public interface WorldTypeTemplate extends DataPackSerializable {

    static WorldTypeTemplate overworld() {
        return Sponge.game().getFactoryProvider().provide(Factory.class).overworld();
    }

    static WorldTypeTemplate overworldCaves() {
        return Sponge.game().getFactoryProvider().provide(Factory.class).overworldCaves();
    }

    static WorldTypeTemplate theNether() {
        return Sponge.game().getFactoryProvider().provide(Factory.class).theNether();
    }

    static WorldTypeTemplate theEnd() {
        return Sponge.game().getFactoryProvider().provide(Factory.class).theEnd();
    }

    static Builder builder() {
        return Sponge.game().getBuilderProvider().provide(Builder.class).reset();
    }

    WorldTypeEffect effect();

    BiomeSampler biomeSampler();

    boolean scorching();

    boolean natural();

    double coordinateMultiplier();

    boolean hasSkylight();

    boolean hasCeiling();

    float ambientLighting();

    Optional<MinecraftDayTime> fixedTime();

    boolean piglinSafe();

    boolean bedsUsable();

    boolean respawnAnchorsUsable();

    boolean hasRaids();

    int logicalHeight();

    boolean createDragonFight();

    interface Builder extends ResourceKeyedBuilder<WorldTypeTemplate, Builder>, CopyableBuilder<WorldTypeTemplate, Builder> {

        Builder effect(WorldTypeEffect effect);

        Builder biomeSampler(BiomeSampler biomeSampler);

        Builder scorching(boolean scorching);

        Builder natural(boolean natural);

        Builder coordinateMultiplier(double coordinateMultiplier);

        Builder hasSkylight(boolean skylight);

        Builder hasCeiling(boolean ceiling);

        Builder ambientLighting(float ambientLighting);

        Builder fixedTime(@Nullable MinecraftDayTime dayTime);

        Builder piglinSafe(boolean piglinSafe);

        Builder bedsUsable(boolean bedsUsable);

        Builder respawnAnchorsUsable(boolean respawnAnchorsUsable);

        Builder hasRaids(boolean raids);

        Builder logicalHeight(int logicalHeight);

        Builder createDragonFight(boolean createDragonFight);
    }

    interface Factory {

        WorldTypeTemplate overworld();

        WorldTypeTemplate overworldCaves();

        WorldTypeTemplate theNether();

        WorldTypeTemplate theEnd();
    }
}

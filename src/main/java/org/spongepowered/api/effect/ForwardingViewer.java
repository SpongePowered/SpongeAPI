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
package org.spongepowered.api.effect;

import net.kyori.adventure.audience.ForwardingAudience;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.World;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * ForwardingViewer represents some group of {@link Viewer}s
 */
public interface ForwardingViewer extends Viewer, ForwardingAudience {

    @Override
    Iterable<? extends Viewer> audiences();

    /**
     * Creates {@link ForwardingViewer} from provided viewers supplier.
     *
     * @param viewersSupplier The viewers supplier
     * @return The forwarding viewer
     */
    static ForwardingViewer of(final Supplier<? extends Iterable<? extends Viewer>> viewersSupplier) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(viewersSupplier);
    }

    /**
     * Creates {@link ForwardingViewer} from provided viewers.
     *
     * @param viewers The viewers
     * @return The forwarding viewer
     */
    static ForwardingViewer of(final Collection<? extends Viewer> viewers) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(viewers);
    }

    /**
     * Creates {@link ForwardingViewer} from provided viewers.
     *
     * @param viewers The viewers
     * @return The forwarding viewer
     */
    static ForwardingViewer of(final Viewer... viewers) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(viewers);
    }

    /**
     * Creates {@link ForwardingViewer} that will only affect viewers
     * in the given area of the given world.
     *
     * @param world The world
     * @param center The center of the area
     * @param radius The radius of the area
     * @return The forwarding viewer
     */
    static ForwardingViewer allAround(final World<?, ?> world, final Vector3i center, final int radius) {
        return Sponge.game().factoryProvider().provide(Factory.class).allAround(world, center, radius);
    }

    /**
     * Creates {@link ForwardingViewer} that will only affect viewers
     * in the given radius from the given entity.
     *
     * @param entity The entity
     * @param radius The radius
     * @return The forwarding viewer
     */
    static ForwardingViewer allAround(final Entity entity, final int radius) {
        return Sponge.game().factoryProvider().provide(Factory.class).allAround(entity, radius);
    }


    interface Factory {

        ForwardingViewer of(Supplier<? extends Iterable<? extends Viewer>> viewersSupplier);

        ForwardingViewer of(Collection<? extends Viewer> viewers);

        ForwardingViewer of(Viewer... viewers);

        ForwardingViewer allAround(World<?, ?> world, Vector3i center, int radius);

        ForwardingViewer allAround(Entity entity, int radius);
    }
}

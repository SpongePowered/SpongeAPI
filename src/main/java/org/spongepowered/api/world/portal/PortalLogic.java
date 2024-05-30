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
package org.spongepowered.api.world.portal;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;

/**
 * A type of portal, used to move {@link Entity entities} one place to another.
 */
public interface PortalLogic {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    static Factory factory() {
        return Sponge.game().factoryProvider().provide(Factory.class);
    }

    Optional<PortalExitCalculator> exitCalculator();

    Optional<PortalFinder> finder();

    Optional<PortalGenerator> generator();

    /**
     * Teleports an {@link Entity} through this {@link PortalLogic portal}.
     *
     * <p>The location is meant to be a hint and no expectation should be made that the portal
     * will be exactly at the location.</p>
     *
     * <p>No assumption should be made that the generation of the destination portal will match
     * the original portal, this is left up to the plugin dev to decide.</p>
     *
     * @param entity                    The entity
     * @param destination               The destination
     * @param generateDestinationPortal True if the portal should generate a destination one
     * @return True if teleport successful, false if not
     */
    boolean teleport(Entity entity, ServerLocation destination, boolean generateDestinationPortal);


    interface Factory {

        /**
         * The default vanilla {@link org.spongepowered.api.block.BlockTypes#END_PORTAL}.
         *
         * @return the portal type
         */
        PortalLogic endPortal();

        /**
         * The default vanilla {@link org.spongepowered.api.block.BlockTypes#END_GATEWAY}.
         *
         * @return the portal type
         */
        PortalLogic endGateway();

        /**
         * The default vanilla {@link org.spongepowered.api.block.BlockTypes#NETHER_PORTAL}.
         *
         * @return the portal type
         */
        PortalLogic netherPortal();

        /**
         * Creates a nether portal exit calculator using the default scaling between the given worlds.
         *
         * @param origin the origin world
         * @param target the target world
         *
         * @return The portal exit calculator
         */
        PortalExitCalculator netherPortalExitCalculator(ResourceKey origin, ResourceKey target);

        /**
         * Creates a nether portal exit calculator using the given scaling between the worlds.
         *
         * @param origin the origin world
         * @param target the target world
         * @param scale  the scale
         *
         * @return The portal exit calculator
         */
        PortalExitCalculator netherPortalExitCalculator(ResourceKey origin, ResourceKey target, double scale);

        /**
         * Creates a nether portal finder
         *
         * @return the portal finder
         */
        PortalFinder netherPortalFinder();

        /**
         * Creates a nether portal generator
         *
         * @return the portal generator
         */
        PortalGenerator netherPortalGenerator();

        /**
         * Creates an end platform generator
         *
         * @return the end platform generator
         */
        PortalGenerator endPlatformGenerator();

        /**
         * Creates a portal exit calculator using the given fixed target position
         *
         * @param origin the origin world
         * @param target the target world
         * @param targetPos the target position
         *
         * @return the portal exit calculator
         */
        PortalExitCalculator targetCalculator(ResourceKey origin, ResourceKey target, Vector3d targetPos);

        /**
         * Creates a portal exit calculator using the default world spawn
         *
         * @param origin the origin world
         * @param target the target world
         *
         * @return the portal exit calculator
         */
        PortalExitCalculator spawnCalculator(ResourceKey origin, ResourceKey target);

        /**
         * Finds the given input location
         *
         * @return the no op portal finder
         */
        PortalFinder noOpFinder();

        /**
         * Creates a portal with the given properties
         *
         * @param logic the portal logic
         * @param position the portal position
         *
         * @return the portal
         */
        Portal portalOf(PortalLogic logic, ServerLocation position);

        /**
         * Creates a portal with the given properties
         *
         * @param logic the portal logic
         * @param position the portal position
         * @param aabb the portals bounding box
         *
         * @return the portal
         */
        Portal portalOf(PortalLogic logic, ServerLocation position, AABB aabb);

    }


    interface Builder extends ResettableBuilder<PortalLogic, Builder> {

        default Builder addSimplePortal(PortalExitCalculator calulator) {
            return this.addPortalWithFinder(calulator, PortalLogic.factory().noOpFinder());
        }

        default Builder addPortalWithFinder(PortalExitCalculator calulator, PortalFinder finder) {
            return this.addPortal(calulator, finder, (at, axis) -> Optional.empty());
        }

        default Builder addPortalWithGenerator(PortalExitCalculator calulator, PortalGenerator generator) {
            return this.addPortal(calulator, (at, r) -> Optional.empty(), generator);
        }

        /**
         * Adds a portal to the builder.
         * <p>For a portal to work it needs to calculate a valid exit
         * location then find an existing or generate a new portal</p>
         *
         * @param calulator the portal exit calculator
         * @param finder the portal finder
         * @param generator the portal generator
         *
         * @return this builder for chaining
         */
        Builder addPortal(PortalExitCalculator calulator, PortalFinder finder, PortalGenerator generator);

        <T extends PortalExitCalculator & PortalFinder & PortalGenerator> Builder addPortal(T logic);


        PortalLogic build();
    }

    @FunctionalInterface
    interface PortalExitCalculator {

        /**
         * Calculates a desired portal exit location
         * to find an existing portal using {@link PortalFinder}
         * or generate a new one using {@link PortalGenerator}
         * in {@link PortalLogic}
         *
         * @param from    the original world
         * @param fromPos the original position
         * @param entity  the entity
         *
         * @return the exit location if available
         */
        Optional<ServerLocation> calculatePortalExit(ServerWorld from, Vector3i fromPos, Entity entity);
    }



    @FunctionalInterface
    interface PortalFinder {

        /**
         * Searches for an existing portal at the {@link ServerLocation location}.
         *
         * <p>If an existing portal is not found
         * a new one may be generated using {@link PortalGenerator}
         * in {@link PortalLogic}</p>
         *
         * <p>It is left up to the discretion of the implementer how this is done.
         * Portals come in all shapes and sizes or none at all.</p>
         *
         * <p>The location and search range is meant to be a hint and no expectation
         * should be made that the a portal will be exactly at the location.</p>
         *
         * @param location          the location to search around
         * @param searchRange the range to search around
         *
         * @return the position of an existing portal if found
         */
        Optional<Portal> findPortal(ServerLocation location, int searchRange);
    }


    @FunctionalInterface
    interface PortalGenerator {

        /**
         * Attempts to generate the portal at the {@link ServerLocation location}.
         *
         * <p>It is left up to the discretion of the implementer how this is done.
         * Portals come in all shapes and sizes or none at all.</p>
         *
         * <p>The location and axis are meant to be hints and should not be considered to be the exact
         * final location/orientation of the resulting portal.</p>
         *
         * @param location The location
         * @param axis     The axis
         *
         * @return the adjusted teleport location if generated
         */
        Optional<Portal> generatePortal(ServerLocation location, Axis axis);

    }

}

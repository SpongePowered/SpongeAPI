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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.ServerLocation;

import java.util.Optional;

/**
 * A type of portal, used to move {@link Entity entities} one place to another.
 */
@CatalogedBy(PortalTypes.class)
public interface PortalType extends CatalogType {

    /**
     * Generates the portal at the {@link ServerLocation location}.
     *
     * <p>It is left up to the discretion of the plugin developer on how this is implemented.
     * Portals come in all shapes and sizes or none at all.</p>
     *
     * <p>The location is meant to be a hint and should not be considered to be the exact
     * final location of the resulting portal.</p>
     *
     * @param location The location
     */
    void generatePortal(ServerLocation location);

    /**
     * Finds a {@link Portal} from a {@link ServerLocation location}.
     *
     * <p>It is left up to the discretion of the plugin developer on how this is implemented.
     * In vanilla minecraft, portals are calculated on-demand and therefore this may never
     * return an actual value.</p>
     *
     * <p>The location is meant to be a hint and no expectation should be made that the {@link Portal}
     * will be exactly at the location.</p>
     *
     * @param location The location
     * @return The portal or {@link Optional#empty()} if not found
     */
    Optional<Portal> findPortal(ServerLocation location);

    /**
     * Teleports an {@link Entity} through this {@link PortalType portal}.
     *
     * <p>The location is meant to be a hint and no expectation should be made that the portal
     * will be exactly at the location.</p>
     *
     * <p>No assumption should be made that the generation of the destination portal will match
     * the original portal, this is left up to the plugin dev to decide.</p>
     *
     * @param entity The entity
     * @param destination The destination
     * @param generateDestinationPortal True if the portal should generate a destination one
     * @return True if teleport successful, false if not
     */
    boolean teleport(Entity entity, ServerLocation destination, boolean generateDestinationPortal);
}

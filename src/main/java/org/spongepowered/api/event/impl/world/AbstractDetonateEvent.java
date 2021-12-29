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
package org.spongepowered.api.event.impl.world;

import org.spongepowered.api.event.impl.entity.AbstractAffectEntityEvent;
import org.spongepowered.api.event.world.ExplosionEvent;
import org.spongepowered.api.util.annotation.eventgen.UseField;
import org.spongepowered.api.world.server.ServerLocation;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractDetonateEvent extends AbstractAffectEntityEvent implements ExplosionEvent.Detonate {

    @UseField
    protected List<ServerLocation> affectedLocations;

    @Override
    public List<ServerLocation> affectedLocations() {
        return Collections.unmodifiableList(this.affectedLocations);
    }

    @Override
    public void filterAffectedLocations(Predicate<ServerLocation> predicate) {
        this.affectedLocations.removeIf(location -> !predicate.test(location));
    }
}

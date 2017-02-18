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
package org.spongepowered.api.event.impl;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.entity.AffectEntityEvent;
import org.spongepowered.api.util.annotation.eventgen.UseField;

import java.util.List;

public abstract class AbstractAffectEntityEvent extends AbstractEvent implements AffectEntityEvent {

    @UseField
    protected List<Entity> entities;
    @UseField(overrideToString = true) protected List<EntitySnapshot> entitySnapshots;

    @Override
    public List<EntitySnapshot> getEntitySnapshots() {
        if (this.entitySnapshots == null) {
            if (this.currentOrder == Order.PRE) {
                ImmutableList.Builder<EntitySnapshot> builder = ImmutableList.builder();
                for (Entity entity: this.entities) {
                    builder.add(entity.createSnapshot());
                }
                this.entitySnapshots = builder.build();
            } else {
                throw new IllegalStateException("Can't initialize entity snapshots after PRE!");
            }
        }
        return this.entitySnapshots;
    }
}

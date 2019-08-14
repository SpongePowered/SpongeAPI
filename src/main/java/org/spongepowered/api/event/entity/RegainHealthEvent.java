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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.event.impl.AbstractRegainHealthEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

/**
 * An event thrown for {@link Entity entities} being healed in
 * a manner that their {@link Keys#HEALTH health} is being increased
 * by a game mechanic, but not by {@link PluginContainer plugins}.
 * An expected context will contain {@link EventContextKeys#HEALING_TYPE}
 * for some further specificity.
 */
@ImplementedBy(AbstractRegainHealthEvent.class)
public interface RegainHealthEvent extends TargetEntityEvent, Cancellable {

    @PropertySettings(requiredParameter = false, generateMethods = false)
    double getOriginalAmount();

    double getAmountToRegain();

    void setAmountToRegain(double amount);

    double getOriginalHealth();

    @PropertySettings(requiredParameter = false, generateMethods = false)
    default double getOriginalNewHealth() {
        return getOriginalHealth() + getOriginalAmount();
    }


}

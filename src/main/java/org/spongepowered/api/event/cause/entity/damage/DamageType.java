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
package org.spongepowered.api.event.cause.entity.damage;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.tag.Tag;
import org.spongepowered.api.util.Nameable;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * A {@link DamageType} is a type of "grouping" for {@link DamageSource}s since a {@link DamageSource} instance can be inherently different from
 * another {@link DamageSource} by virtue of the {@link Object} backing the source. Furthermore, it is impossible to refer to {@link DamageSource}s
 * statically due to the nature of constructing them. It is possible however, that the parent {@link Object} being referred to as the "damage source"
 * can damage an {@link Entity} with varying {@link DamageType}s depending on the circumstances.
 */
@CatalogedBy(DamageTypes.class)
public interface DamageType extends DefaultedRegistryValue, Nameable {

    /**
     * Creates a new {@link Builder builder} to build a {@link DamageType}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Gets the amount of exhaustion this {@link DamageType} will add to the entity, generally only to players.
     * <p>
     * TODO check this facts:
     * <p>In vanilla gameplay this is set to 0.1 by default and
     * overridden to 0 if the type is set to be absolute or
     * as overriding armor.</p>
     *
     * @return The increase in exhaustion
     */
    double exhaustion();

    /**
     * Checks whether this damage types matches a damage type tag.
     *
     * @param tag The tag to check.
     * @return true if this damage type matches the damage type tag.
     */
    boolean is(Tag<DamageType> tag);

    /**
     * Returns the damage scaling.
     *
     * @return the damage scaling
     */
    DamageScaling scaling();

    /**
     * Returns the damage effect.
     *
     * @return the damage effect
     */
    DamageEffect effect();

}

/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.event.cause;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;

/**
 * Represents a builder for creating custom or complex damage causes.
 */
public interface DamageCauseBuilder {

    /**
     * Sets whether this damage cause should affect users in creative mode,
     * defaults to false.
     * 
     * @return This builder
     */
    DamageCauseBuilder affectCreativeMode();

    /**
     * Sets whether this damage cause should scale with difficulty, defaults to
     * false.
     * 
     * @return This builder
     */
    DamageCauseBuilder scaleWithDifficulty();

    /**
     * Sets whether this damage cause bypasses armor protection, defaults to
     * false.
     * 
     * @return This builder
     */
    DamageCauseBuilder bypassArmor();

    /**
     * Sets whether this damage cause is blockable, defaults to false.
     * 
     * @return This builder
     */
    DamageCauseBuilder blockable();
    
    /**
     * Sets the type, or types, of this damage cause, defaults to having no type.
     * 
     * @param types The types of this cause
     * @return This builder
     */
    DamageCauseBuilder type(DamageType... types);

    /**
     * Builds an instance of {@link DamageCause}.
     * 
     * @return A new instance
     * @throws IllegalStateException If the damage cause is not complete
     */
    DamageCause build() throws IllegalStateException;

    /**
     * Represents a builder for creating entity based damage causes.
     */
    interface EntityDamageCauseBuilder extends DamageCauseBuilder {

        /**
         * Sets the source entity for this damage cause
         * 
         * @param source The entity source
         * @return This builder
         */
        EntityDamageCauseBuilder sourcedFrom(Entity source);

        @Override
        EntityDamageCauseBuilder affectCreativeMode();

        @Override
        EntityDamageCauseBuilder scaleWithDifficulty();

        @Override
        EntityDamageCauseBuilder bypassArmor();

        @Override
        EntityDamageCauseBuilder blockable();
        
        @Override
        EntityDamageCauseBuilder type(DamageType... types);

        @Override
        EntityDamageCause build() throws IllegalStateException;

    }

    /**
     * Represents a builder for creating projectile based damage causes.
     */
    interface ProjectileDamageCauseBuilder extends DamageCauseBuilder {

        /**
         * Sets the {@link ProjectileSource} from which this projectile was cast
         * from.
         * 
         * @param source The projectile source
         * @return This builder
         */
        ProjectileDamageCauseBuilder sourcedFrim(ProjectileSource source);

        /**
         * Sets the base projectile of this damage cause
         * 
         * @param projectile The projectile
         * @return This builder
         */
        ProjectileDamageCauseBuilder withProjectile(Projectile projectile);

        @Override
        ProjectileDamageCauseBuilder affectCreativeMode();

        @Override
        ProjectileDamageCauseBuilder scaleWithDifficulty();

        @Override
        ProjectileDamageCauseBuilder bypassArmor();

        @Override
        ProjectileDamageCauseBuilder blockable();
        
        @Override
        ProjectileDamageCauseBuilder type(DamageType... types);

        @Override
        ProjectileDamageCause build() throws IllegalStateException;
    }

}

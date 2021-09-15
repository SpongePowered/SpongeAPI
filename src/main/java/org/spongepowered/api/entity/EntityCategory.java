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
package org.spongepowered.api.entity;

import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.zombie.Zombie;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * A category of entities that conveys a variety of meanings to
 * consider a group of entities that may differ in {@link EntityType}
 * are the "same category" grouping. Examples can be for monsters
 * to include {@link Zombie}, {@link Creeper}, while a creature
 * may include {@link Chicken}.
 */
@CatalogedBy(EntityCategories.class)
public interface EntityCategory extends DefaultedRegistryValue {

    /**
     * Whether this category of entities is considered "friendly".
     *
     * @return True if this category of entities is friendly
     */
    boolean friendly();

    /**
     * Gets the distance in blocks in which an entity of this category
     * may be considered to be despawned/removed from a World if too
     * far from a Player.
     * <p>Obvious exceptions include when the Entity logic considers
     * itself not to be despawnable or owned/permanent by a player,
     * function, or plugin thereof.
     *
     * @return The distance at which entities of this category may be
     * considered to be removed if too far from a player
     */
    int despawnDistance();


}

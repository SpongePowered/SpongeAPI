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
package org.spongepowered.api.datapack;

import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.advancement.Advancement;
import org.spongepowered.api.event.lifecycle.RegisterDataPackValueEvent;
import org.spongepowered.api.item.recipe.RecipeRegistration;
import org.spongepowered.api.tag.TagTemplate;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.WorldTypeTemplate;
import org.spongepowered.api.world.server.WorldTemplate;
import org.spongepowered.plugin.PluginContainer;

@CatalogedBy(DataPackTypes.class)
public interface DataPackType<T> {

    TypeToken<T> type();

    /**
     * Gets if resources created by this type will persist even if the {@link PluginContainer plugin}
     * is no longer present (or no longer performs a registration in {@link RegisterDataPackValueEvent}
     *
     * <p>Consult your implementation vendor for more details on exactly what resources are kept.</p>
     * 
     * @return True if persistent, false if not
     */
    boolean persistent();

    interface Factory {

        DataPackType<Advancement> advancement();

        DataPackType<RecipeRegistration> recipe();

        DataPackType<WorldTypeTemplate> worldType();

        DataPackType<WorldTemplate> world();

        DataPackType<TagTemplate> tag();
    }
}

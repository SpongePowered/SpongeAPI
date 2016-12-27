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
package org.spongepowered.api.event.map;

import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.map.MapSettings;
import org.spongepowered.api.map.MapView;

import java.util.Optional;

/**
 * Represents an event that is triggered when a {@link ItemTypes#MAP}
 * is initialized and replaced with a {@link ItemTypes#FILLED_MAP}.
 */
public interface InitializeMapEvent extends Event {

    /**
     * Called before {@link Replace}, by setting {@link #setUsingDefaultBehavior}
     * in this event, plugins can override the creation of a new map on the disk
     * and provide customized maps at initialization time. Plugins should use {@link Replace}
     * to set their own {@link MapView} if overriding vanilla map creation logic.
     *
     * <p>Cancelling this event will prevent any {@link MapView} from being created
     * and will stop {@link Replace} from being fired. This allows for maps
     * to be disabled or have their initialization overridden by cancelling {@link Create}.</p>
     */
    interface Create extends InitializeMapEvent, Cancellable {

        /**
         * Gets if the map will be created with default Minecraft initialization logic
         * which will create a new map data file stored on the disk with the world.
         *
         * @return If a new map will be created on the disk
         */
        boolean isUsingDefaultBehavior();

        /**
         * Sets if the map will be created with default Minecraft initialization logic
         * which will create a new map data file stored on the disk with the world.
         *
         * <p>If a plugin wishes to provide a different map view, the plugin should
         * provide false to this method, then modify the map view in the {@link Replace}
         * event.</p>
         *
         * @param createMapView True to let default map creation logic run
         */
        void setUsingDefaultBehavior(boolean createMapView);

    }

    /**
     * This is called after the view is set, but before modifications to the
     * player's inventory take place.
     *
     * <p>Plugins can use this event to grab a handle (map id) into the newly
     * created {@link MapView}, or simply override vanilla behavior by
     * cancelling this event and using the new map id elsewhere</p>
     */
    interface Replace extends InitializeMapEvent {

        /**
         * Gets the default id of the map being attached. This method returns
         * {@link Optional#empty()} when the {@link Create} event is canceled.
         *
         * @return The id of map being attached, if it exists
         */
        Optional<String> getOriginalMap();

        /**
         * Sets the attached map id to the id provided. If this doesn't exist
         * the behavior is undefined.
         *
         * <p>Note: This is where you could attach a custom {@link MapView} through data
         * after disabling the default creation logic to avoid creating the MapView.
         * If a plugin does not attach a new map id after cancelling the default logic
         * the player will end up with a {@link ItemTypes#FILLED_MAP} in an undefined
         * state, as no data was ever initialized or attached.</p>
         *
         * @param mapId The id of the map to attach
         */
        void setAttachedMap(String mapId);

        /**
         * Gets the {@link Transaction} involved in replacing the original
         * {@link ItemTypes#MAP} with a new {@link ItemTypes#FILLED_MAP}.
         * This allows plugins to change the result to another item after
         * canceling standard map behavior.
         *
         * @return The itemstack transaction
         */
        Transaction<ItemStackSnapshot> getItemStackTransaction();

    }

}

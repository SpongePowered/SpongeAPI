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
package org.spongepowered.api.entity.living.player.tab;

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Optional;

/**
 * Represents the information attached to an entry in a {@link TabList}.
 */
public interface TabListEntry {

    /**
     * Creates a new {@link Builder} to create {@link TabListEntry}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link TabList} that owns this entry.
     *
     * @return The tab list that owns this entry
     */
    TabList getList();

    /**
     * Gets the {@link GameProfile} associated with this entry.
     *
     * @return The profile associated with this entry
     */
    GameProfile getProfile();

    /**
     * Gets this entry's display name.
     *
     * @return This entry's display name
     */
    Optional<Component> getDisplayName();

    /**
     * Sets this entry's display name.
     *
     * @param displayName The new display name
     * @return This entry, for chaining
     */
    TabListEntry setDisplayName(@Nullable Component displayName);

    /**
     * Gets the latency for this entry.
     *
     * @return The latency for this entry
     */
    int getLatency();

    /**
     * Sets the latency for this entry.
     *
     * <p>The client displays connection bars based on this number.</p>
     *
     * <table summary="">
     *     <thead>
     *         <tr>
     *             <th>Bars</th>
     *             <th>Time</th>
     *         </tr>
     *     </thead>
     *     <tbody>
     *         <tr>
     *             <td>0</td>
     *             <td>Less than 0</td>
     *         </tr>
     *         <tr>
     *             <td>1</td>
     *             <td>1000+</td>
     *         </tr>
     *         <tr>
     *             <td>2</td>
     *             <td>600 - 999</td>
     *         </tr>
     *         <tr>
     *             <td>3</td>
     *             <td>300 - 599</td>
     *         </tr>
     *         <tr>
     *             <td>4</td>
     *             <td>150 - 299</td>
     *         </tr>
     *         <tr>
     *             <td>5</td>
     *             <td>0 - 149</td>
     *         </tr>
     *     </tbody>
     * </table>
     *
     * @param latency The new latency, in milliseconds
     * @return This entry, for chaining
     */
    TabListEntry setLatency(int latency);

    /**
     * Gets the {@link GameMode} this entry is in.
     *
     * @return The gamemode this entry is in
     */
    GameMode getGameMode();

    /**
     * Sets this entry's gamemode.
     *
     * <p>When using {@link GameModes#SPECTATOR} and this entry is of an
     * online {@link Player}, the player will have "spectator effects". Such
     * effects can include invisibility and noclip.</p>
     *
     * @param gameMode The new gamemode
     * @return This entry, for chaining
     */
    TabListEntry setGameMode(GameMode gameMode);

    /**
     * Represents a builder class to create mutable {@link TabListEntry}s.
     *
     * @see TabListEntry
     */
    interface Builder extends CopyableBuilder<TabListEntry, Builder> {

        /**
         * Sets the {@link TabList} this entry is owned by.
         *
         * @param list The tab list
         * @return The builder
         */
        Builder list(TabList list);

        /**
         * Sets the profile for entries created by this builder.
         *
         * <p>A copy of the passed {@link GameProfile} is used,
         * so further changes to the original object will have no effect.</p>
         *
         * @param profile The profile
         * @return The builder
         */
        Builder profile(GameProfile profile);

        /**
         * Sets the display name for entries created by this builder.
         *
         * @param displayName The display name
         * @return The builder
         * @see TabListEntry#setDisplayName(Component)
         */
        Builder displayName(@Nullable Component displayName);

        /**
         * Sets the latency for entries created by this builder.
         *
         * @param latency The latency, in milliseconds
         * @return The builder
         * @see TabListEntry#setLatency(int)
         */
        Builder latency(int latency);

        /**
         * Sets the gamemode for entries created by this builder.
         *
         * @param gameMode The gamemode
         * @return The builder
         * @see TabListEntry#setGameMode(GameMode)
         */
        Builder gameMode(GameMode gameMode);

        /**
         * Builds an entry based off the values of this builder.
         *
         * @return The entry
         */
        TabListEntry build();
    }

}

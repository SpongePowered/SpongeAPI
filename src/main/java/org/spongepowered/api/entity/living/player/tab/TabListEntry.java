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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;

/**
 * Represents the information attached to an entry in a {@link TabList}.
 */
public class TabListEntry {

    protected final GameProfile profile;
    protected int latency;
    protected Text displayName;
    private GameMode gameMode;

    public TabListEntry(GameProfile profile) {
        this.profile = checkNotNull(profile, "profile");
    }

    public TabListEntry(GameProfile profile, int latency, Text displayName, GameMode gameMode) {
        this.profile = checkNotNull(profile, "profile");
        this.latency = latency;
        this.displayName = displayName;
        this.gameMode = gameMode;
    }

    /**
     * Gets the {@link GameProfile} associated with this entry.
     *
     * @return The profile associated with this entry
     */
    public GameProfile getProfile() {
        return this.profile;
    }

    /**
     * Gets this entry's display name.
     *
     * @return This entry's display name
     */
    public Text getDisplayName() {
        return this.displayName;
    }

    /**
     * Sets this entry's display name.
     *
     * @param displayName The new display name
     */
    public void setDisplayName(Text displayName) {
        this.displayName = checkNotNull(displayName, "display name");
    }

    /**
     * Gets the latency for this entry.
     *
     * @return The latency for this entry
     */
    public int getLatency() {
        return this.latency;
    }

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
     */
    public void setLatency(int latency) {
        this.latency = latency;
    }

    /**
     * Gets the {@link GameMode} this entry is in.
     *
     * @return The gamemode this entry is in
     */
    public GameMode getGameMode() {
        return this.gameMode;
    }

    /**
     * Sets this entry's gamemode. Note that setting this to spectator is what
     * enables spectator (noclip, invisibility), this isn't just a visual change.
     *
     * @param gameMode The new gamemode
     */
    public void setGameMode(GameMode gameMode) {
        this.gameMode = checkNotNull(gameMode, "game mode");
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        TabListEntry that = (TabListEntry) other;
        return Objects.equal(this.profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.profile);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("profile", this.profile)
                .add("latency", this.latency)
                .add("displayName", this.displayName)
                .add("gameMode", this.gameMode)
                .toString();
    }

}

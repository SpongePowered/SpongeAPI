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
package org.spongepowered.api.entity.living.player.server;

import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Server;
import org.spongepowered.api.advancement.Advancement;
import org.spongepowered.api.advancement.AdvancementProgress;
import org.spongepowered.api.advancement.AdvancementTree;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.data.value.SetValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.CooldownTracker;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.PlayerChatRouter;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.tab.TabList;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.message.PlayerChatEvent;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.network.ServerPlayerConnection;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.entity.living.player.chat.ChatVisibility;
import org.spongepowered.api.world.WorldBorder;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.plugin.PluginContainer;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

public interface ServerPlayer extends Player, Subject {

    @Override
    ServerWorld world();

    User user();

    /**
     * Returns whether this player is online or not.
     *
     * <p>If this returns false, this player should be considered stale and
     * all references to it should be discarded immediately.</p>
     * @return True if online, false if not
     */
    boolean isOnline();

    /**
     * Returns whether this player has an open inventory at the moment
     * or not.
     *
     * @return Whether this player is viewing an inventory or not
     */
    default boolean isViewingInventory() {
        return this.openInventory().isPresent();
    }

    /**
     * Gets the currently viewed inventory of this player, if it is
     * currently viewing one.
     *
     * @return An inventory if this player is viewing one, otherwise
     * {@link Optional#empty()}
     */
    Optional<Container> openInventory();

    /**
     * Opens the given Inventory for the player to view.
     *
     * @param inventory The inventory to view
     * @return The opened Container if the inventory was opened, otherwise
     *      {@link Optional#empty()}
     * @throws IllegalArgumentException if a {@link PluginContainer} is not the
     *      root of the cause
     */
    Optional<Container> openInventory(Inventory inventory) throws IllegalArgumentException;

    /**
     * Opens a given Inventory for the player to view with a custom displayName.
     *
     * <p>Note that not all inventories support a custom display name.</p>
     *
     * @param inventory The inventory to view
     * @param displayName The display name to set
     * @return The opened Container if the inventory was opened, otherwise {@link Optional#empty()}
     */
    Optional<Container> openInventory(Inventory inventory, Component displayName);

    /**
     * Closes the currently viewed entity of this player, if it is currently
     * viewing one.
     *
     * @return whether or not closing the inventory succeeded
     * @throws IllegalArgumentException if a {@link PluginContainer} is not the
     *         root of the cause
     */
    boolean closeInventory() throws IllegalArgumentException;

    /**
     * {@link Keys#VIEW_DISTANCE}
     * @return The player's view distance
     */
    default Value.Mutable<Integer> viewDistance() {
        return this.requireValue(Keys.VIEW_DISTANCE).asMutable();
    }

    /**
     * {@link Keys#CHAT_VISIBILITY}
     * @return Chat visibility setting
     */
    default Value.Mutable<ChatVisibility> chatVisibility() {
        return this.requireValue(Keys.CHAT_VISIBILITY).asMutable();
    }

    /**
     * {@link Keys#CHAT_COLORS_ENABLED}
     * @return Whether colors are enabled in chat
     */
    default Value.Mutable<Boolean> chatColorsEnabled() {
        return this.requireValue(Keys.CHAT_COLORS_ENABLED).asMutable();
    }

    /**
     * Simulates a chat message from a player.
     *
     * <p>This method sends a message as if it came from this player.
     * To send a message to this player instead, see
     * {@link #sendMessage(Identity, Component)}.</p>
     *
     * <p>If text formatting is not supported in the implementation
     * it will be displayed as plain text.</p>
     *
     * @param message The message to send
     * @param cause The cause for the message
     * @return The event that was thrown from sending the message
     */
    PlayerChatEvent simulateChat(Component message, Cause cause);

    /**
     * {@link Keys#SKIN_PARTS}
     * @return A set of skin parts displayed
     */
    default SetValue.Mutable<SkinPart> displayedSkinParts() {
        return this.requireValue(Keys.SKIN_PARTS).asMutable();
    }

    /**
     * Gets the appropriate {@link ServerPlayerConnection} linking this player to a
     * client.
     *
     * @return The connection
     */
    ServerPlayerConnection connection();

    /**
     * Sends a given {@link ResourcePack} to this player.
     *
     * @param pack The ResourcePack to send
     */
    void sendResourcePack(ResourcePack pack);

    /**
     * Gets this player's {@link TabList}.
     *
     * @return This player's TabList
     */
    TabList tabList();

    /**
     * Kicks the player, showing the default kick reason (the translation key
     * {@code disconnect.disconnected}).
     */
    boolean kick();

    /**
     * Kicks the player given a reason.
     *
     * @param reason The reason for the kick
     */
    boolean kick(Component reason);

    /**
     * Gets the {@link Scoreboard} displayed to the player.
     *
     * @return The scoreboard displayed to the player
     */
    Scoreboard scoreboard();

    /**
     * Sets the {@link Scoreboard} displayed to the player.
     *
     * @param scoreboard The scoreboard to display
     */
    void setScoreboard(Scoreboard scoreboard);

    /**
     * Manually respawns the player.
     *
     * <p>If the player is not dead, this method will return {@code false}</p>
     *
     * @return Whether the respawn was successful
     */
    boolean respawn();

    /**
     * Gets the {@link WorldBorder} for this player, if present. If no border is
     * set, {@link Optional#empty()} is returned.
     *
     * @return The {@code WorldBorder} of this player as an {@code Optional}, if
     *     present
     */
    Optional<WorldBorder> worldBorder();

    /**
     * Sets the {@link WorldBorder} instance for this player to the given world
     * border. If {@code null} is passed, the world border is unset.
     *
     * @param border The world border to be used, may be {@code null}
     */
    void setWorldBorder(@Nullable WorldBorder border);

    /**
     * Gets the {@link CooldownTracker} for this player, allowing control
     * over the player's item cooldowns.
     *
     * @return This player's cooldown tracker
     */
    CooldownTracker cooldownTracker();

    /**
     * Gets the {@link AdvancementProgress} for the
     * specified {@link Advancement}.
     *
     * @param advancement The advancement
     * @return The advancement progress
     */
    AdvancementProgress progress(Advancement advancement);

    /**
     * Gets all the {@link AdvancementTree}s that this
     * {@link Player} already unlocked.
     *
     * @return The advancement trees
     */
    Collection<AdvancementTree> unlockedAdvancementTrees();

    /**
     * {@link Keys#FIRST_DATE_JOINED}
     * @return The timestamp value when this player first joined
     */
    default Value.Mutable<Instant> firstJoined() {
        return this.requireValue(Keys.FIRST_DATE_JOINED).asMutable();
    }

    /**
     * {@link Keys#LAST_DATE_JOINED}
     * @return The last timestamp value when this player has joined
     */
    default Value.Mutable<Instant> lastJoined() {
        return this.requireValue(Keys.LAST_DATE_JOINED).asMutable();
    }

    /**
     * {@link Keys#LAST_DATE_PLAYED}
     * @return The last timestamp value when this player has played
     */
    default Value.Mutable<Instant> lastPlayed() {
        return this.requireValue(Keys.LAST_DATE_PLAYED).asMutable();
    }

    /**
     * {@link Keys#HAS_VIEWED_CREDITS}
     * @return True if this player has viewed the credits
     */
    default Value.Mutable<Boolean> hasViewedCredits() {
        return this.requireValue(Keys.HAS_VIEWED_CREDITS).asMutable();
    }

    /**
     * Gets if the {@link Player} has played on the {@link Server} before. Added
     * as a utility.
     *
     * @return True if played before, false otherwise
     */
    default boolean hasPlayedBefore() {
        return !this.firstJoined().equals(this.lastPlayed());
    }

    /**
     * {@link Keys#IS_SLEEPING_IGNORED}
     * @return Whether this player is going to be ignored for sleeping to "reset" the day
     */
    default Value.Mutable<Boolean> sleepingIgnored() {
        return this.requireValue(Keys.IS_SLEEPING_IGNORED).asMutable();
    }

    /**
     * {@link Keys#SPECTATOR_TARGET}
     * @return The entity this player is "spectating"
     */
    default Optional<Value.Mutable<Entity>> spectatorTarget() {
        return this.getValue(Keys.SPECTATOR_TARGET).map(Value::asMutable);
    }

    /**
     * Gets the chat router.
     *
     * @return The chat router
     */
    PlayerChatRouter chatRouter();

    /**
     * Sets the chat router.
     *
     * @param router the chat router
     */
    void setChatRouter(final PlayerChatRouter router);
}

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
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.SetValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.CooldownTracker;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.PlayerChatFormatter;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.chat.ChatVisibility;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.tab.TabList;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.message.PlayerChatEvent;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.network.ServerPlayerConnection;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.world.border.WorldBorder;
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
     *
     * @return The player's view distance
     */
    default Value.Mutable<Integer> viewDistance() {
        return this.requireValue(Keys.VIEW_DISTANCE).asMutable();
    }

    /**
     * {@link Keys#CHAT_VISIBILITY}
     *
     * @return Chat visibility setting
     */
    default Value.Mutable<ChatVisibility> chatVisibility() {
        return this.requireValue(Keys.CHAT_VISIBILITY).asMutable();
    }

    /**
     * {@link Keys#CHAT_COLORS_ENABLED}
     *
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
     *
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
     *
     * @return whether or not kicking the player succeeded
     */
    boolean kick();

    /**
     * Kicks the player given a reason.
     *
     * @param reason The reason for the kick
     * @return whether or not kicking the player succeeded
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
     * set, an empty {@code Optional} is returned.
     *
     * @return The {@code WorldBorder} of this player as an {@code Optional}, if
     *     present
     */
    Optional<WorldBorder> worldBorder();

    /**
     * Sets the {@link WorldBorder} that this player sees. If {@code null}, the
     * border is unset, reverting to the border of the world the player is
     * currently in.
     *
     * <p>The values that are set may be altered by events, so users should
     * check the returned value if they need to know if an event altered the
     * values in some way. If no alterations were made, the supplied object
     * and the returned object (within the optional) will be the same.</p>
     *
     * @param border The world border to be used, may be {@code null}
     * @return the values that were actually set, which may be different
     *         from those requested. If the result is an empty optional,
     *         then the player does not have a personal border, and uses
     *         that of the world they are in instead.
     */
    Optional<WorldBorder> setWorldBorder(@Nullable WorldBorder border);

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
     * {@link Keys#HAS_VIEWED_CREDITS}
     *
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
     * {@link Keys#SPECTATOR_TARGET}
     *
     * @return The entity this player is "spectating"
     */
    default Value.Mutable<Entity> spectatorTarget() {
        return this.requireValue(Keys.SPECTATOR_TARGET).asMutable();
    }

    /**
     * Gets the chat router.
     *
     * @return The chat router
     */
    PlayerChatFormatter chatFormatter();

    /**
     * Sets the chat router.
     *
     * @param router the chat router
     */
    void setChatFormatter(final PlayerChatFormatter router);

    /**
     * {@link Keys#GAME_MODE}
     *
     * @return The game mode the player has
     */
    default Value.Mutable<GameMode> gameMode() {
        return this.requireValue(Keys.GAME_MODE).asMutable();
    }

    /**
     * {@link Keys#STATISTICS}
     *
     * @return The statistics of the player
     */
    default MapValue.Mutable<Statistic, Long> statistics() {
        return this.requireValue(Keys.STATISTICS).asMutable();
    }

    /**
     * {@link Keys#HEALTH_SCALE}
     *
     * @return The value the player max-health (excluding absorption) in the GUI will scale to
     */
    default Optional<Value.Mutable<Double>> healthScale() {
        return this.getValue(Keys.HEALTH_SCALE).map(Value::asMutable);
    }

    /**
     * {@link Keys#FIRST_DATE_JOINED}
     *
     * @return The timestamp value when this player first joined
     */
    default Optional<Value.Mutable<Instant>> firstJoined() {
        return this.getValue(Keys.FIRST_DATE_JOINED).map(Value::asMutable);
    }

    /**
     * {@link Keys#LAST_DATE_JOINED}
     *
     * @return The last timestamp value when this player has joined
     */
    default Optional<Value.Mutable<Instant>> lastJoined() {
        return this.getValue(Keys.LAST_DATE_JOINED).map(Value::asMutable);
    }

    /**
     * {@link Keys#LAST_DATE_PLAYED}
     *
     * @return The last timestamp value when this player has played
     */
    default Optional<Value.Mutable<Instant>> lastPlayed() {
        return this.getValue(Keys.LAST_DATE_PLAYED).map(Value::asMutable);
    }
}

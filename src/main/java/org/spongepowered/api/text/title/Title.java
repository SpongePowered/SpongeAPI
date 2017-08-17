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
package org.spongepowered.api.text.title;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents an immutable configuration for an in-game title which can
 * generally be sent to {@link Player}s.
 *
 * <p>All properties of a title are optional. If they are not set it will use
 * the current default values from the client.</p>
 */
public interface Title {

    /**
     * Creates a new title configuration builder that will reset the
     * currently displayed title on the client before displaying
     * the newly configured one.
     *
     * @return A new title builder that will reset the current title
     * @see #update()
     */
    static Builder builder() {
        return update().reset();
    }

    /**
     * Creates a new empty title configuration builder that will not reset
     * the current title on the client before displaying the new one.
     *
     * <p>This has less use cases but should be used if you just want to update
     * the previously sent title.</p>
     *
     * @return A new title builder that will not reset the current title
     * @see #builder()
     */
    static Builder update() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets a title that will clear the currently displayed {@link Title} from
     * the player's screen.
     *
     * @return A title configuration that will clear the current title
     */
    static Title clear() {
        return Title.builder().clear(true).build();
    }

    /**
     * Gets a title that will reset the current title back to the defaults
     * on the client.
     *
     * @return A title configuration that will reset the current title
     */
    static Title reset() {
        return Title.builder().reset(true).build();
    }

    /**
     * Returns a {@link Title} that will simply do nothing when it is sent to
     * the client.
     *
     * @return An empty title instance
     */
    static Title of() {
        return Title.update().build();
    }

    /**
     * A convenience method to create a title that will display the specified
     * main title on the player's screen.
     *
     * @param title The main title to display
     * @return The created title configuration
     */
    static Title of(Text title) {
        return Title.builder().title(title).build();
    }

    /**
     * A convenience method to create a title that will display the specified
     * main title and subtitle on the player's screen.
     *
     * @param title The main title to display
     * @param subtitle The subtitle to display
     * @return The created title configuration
     */
    static Title of(Text title, Text subtitle) {
        return Title.builder().title(title).subtitle(subtitle).build();
    }

    /**
     * Gets the title that will be displayed with this title configuration.
     *
     * @return The title text of this title, if it was set
     */
    Optional<Text> getTitle();

    /**
     * Gets the subtitle that will be displayed with this title configuration.
     *
     * @return The subtitle text of this title, if it was set
     */
    Optional<Text> getSubtitle();

    /**
     * Gets the action bar that will be displayed with this title configuration.
     *
     * @return The action bar text of this title, if it was set
     */
    Optional<Text> getActionBar();

    /**
     * Gets the specified time this title will take to fade in on the client.
     *
     * <p>Once this period of time is over, the title text will stay
     * for the duration from {@link #getStay()}.</p>
     *
     * <p>The default value in vanilla Minecraft is 20 ticks or 1 second.</p>
     *
     * @return The amount of ticks (1/20th of a second) this title will take
     *     to fade in
     */
    Optional<Integer> getFadeIn();

    /**
     * Gets the specified amount of time this title will stay on the client.
     *
     * <p>Once this period of time is over, the the title will fade out
     * for the duration from {@link #getFadeOut()}.</p>
     *
     * <p>The default value in vanilla Minecraft is 60 ticks or 3 seconds.</p>
     *
     * @return The amount of ticks (1/20th of a second) this title will stay
     *     on the client
     */
    Optional<Integer> getStay();

    /**
     * Gets the specified time this title should take to fade out on the client.
     *
     * <p>The default value in vanilla Minecraft is 20 ticks or 1 second.</p>
     *
     * @return The amount of ticks (1/20th of a second) this title will take
     *     to fade out
     */
    Optional<Integer> getFadeOut();

    /**
     * Gets whether or not this title configuration will clear the current title
     * from the client's screen.
     *
     * @return Whether or not the current title will be removed from the
     *     client's screen
     */
    boolean isClear();

    /**
     * Gets whether or not this title configuration will reset the current
     * title configuration for the client, clearing the titles and resetting the
     * other values to their defaults.
     *
     * @return Whether or not the the client's title configuration will be
     *     reset to the defaults
     */
    boolean isReset();

    /**
     * Creates a new {@link Builder} using the configuration from this title.
     *
     * @return A new builder using this title's configuration
     */
    Builder toBuilder();

    /**
     * Used to create a {@link Title}.
     */
    interface Builder extends ResettableBuilder<Title, Builder> {

        /**
         * Sets the title to send to the player.
         *
         * @param title The text to use as the main title, or {@code null}
         *     to reset it
         * @return The modified builder
         */
        Builder title(@Nullable Text title);

        /**
         * Sets the subtitle to send to the player.
         *
         * @param subtitle The text to use as the subtitle, or {@code null}
         *     to reset it
         * @return The modified builder
         */
        Builder subtitle(@Nullable Text subtitle);

        /**
         * Sets the action bar text to send to the player.
         *
         * @param actionBar The text to use for the action bar, or {@code null}
         *     to reset it
         * @return The modified builder
         */
        Builder actionBar(@Nullable Text actionBar);

        /**
         * Sets the duration in ticks that the fade in effect of this title
         * should last for.
         *
         * <p>Once this period of time is over, the title text will stay
         * for the duration from {@link #getStay()}.</p>
         *
         * <p>The default value in vanilla Minecraft is
         * 20 ticks or 1 second.</p>
         *
         * @param fadeIn The amount of ticks (1/20th of a second) this title
         *     should take to fade in, or {@code null} to reset
         * @return The modified builder
         */
        Builder fadeIn(@Nullable Integer fadeIn);

        /**
         * Sets the duration in ticks that the title should stay on the
         *
         * @param stay The amount of ticks (1/20th of a second) this title
         *     should stay in view for, or {@code null} to reset
         * @return The modified builder
         */
        Builder stay(@Nullable Integer stay);

        /**
         * Sets the duration in ticks that the fade out effect of this title
         * should last for.
         *
         * @param fadeOut The amount of ticks (1/20th of a second) this title
         *     should take to fade out, or {@code null} to reset
         * @return The modified builder
         */
        Builder fadeOut(@Nullable Integer fadeOut);

        /**
         * Sets this title configuration to clear the current title from the
         * client's screen.
         *
         * @return The modified builder
         */
        default Builder clear() {
            return clear(true);
        }

        /**
         * Sets whether or not this title configuration will clear the current
         * title from the client's screen.
         *
         * @param clear Whether or not the current title should be removed from
         *     the client's screen
         * @return The modified builder
         */
        Builder clear(boolean clear);

        /**
         * Sets this title configuration to reset the current title
         * configuration for the client, clearing the titles and resetting
         * the other values to their defaults.
         *
         * @return The modified builder
         */
        default Builder reset() {
            return reset(true);
        }

        /**
         * Sets whether or not this title configuration will reset the current
         * title configuration for the client, clearing the titles and resetting
         * the other values to their defaults.
         *
         * @param reset Whether or not the the client's title configuration
         *     should be reset to the defaults
         * @return The modified builder
         */
        Builder reset(boolean reset);

        /**
         * Builds an immutable title using the current specified
         * configuration.
         *
         * @return An immutable {@link Title} with the currently configured
         *     settings
         */
        Title build();

    }

}

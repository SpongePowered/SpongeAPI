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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Optional;

/**
 * Represents an immutable configuration for an in-game title. Instances of this
 * interface can be created through the {@link Builder} by calling
 * {@link #builder()}.
 *
 * <p>All properties of a title are optional - if they are not set it will use
 * the current default values from the client.</p>
 */
public interface Title {

    /**
     * Returns a {@link Title} that will simply do nothing when it is sent to
     * the client.
     *
     * @return An empty title instance
     */
    static Title of() {
        return builder().build();
    }

    /**
     * Returns a {@link Title} that will display the given main title on the
     * player's screen.
     *
     * @param title The title to display
     * @return The created title
     */
    static Title of(Text title) {
        return builder().title(title).build();
    }

    /**
     * Returns a {@link Title} that will display the given main and subtitle on
     * the player's screen.
     *
     * @param title The title to display
     * @param subtitle The subtitle to display
     * @return The created title
     */
    static Title of(Text title, Text subtitle) {
        return builder().title(title).subtitle(subtitle).build();
    }

    /**
     * Returns a {@link Title} that will clear the currently displayed
     * {@link Title} from the player's screen.
     *
     * @return A title configuration that will clear
     */
    static Title clear() {
        return builder().clear(true).build();
    }

    /**
     * Returns a {@link Title} that will reset the current title back to default
     * values on the client.
     *
     * @return A title configuration that will reset
     */
    static Title reset() {
        return builder().doReset(true).build();
    }

    /**
     * Creates a new {@link Title} configuration builder that will reset the
     * currently displayed Title on the client before displaying the new
     * configured one.
     *
     * @return A new {@link Builder}
     * @see #update
     */
    static Builder builder() {
        return update().reset();
    }

    /**
     * Creates a new empty {@link Title} configuration builder. Unlike
     * {@link #builder} this won't reset the current Title on the client before
     * displaying the current one. This has less use cases but should be used if
     * just the previously sent Title should be updated.
     *
     * @return A new {@link Builder}
     * @see #builder
     */
    static Builder update() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Returns the title of this title configuration.
     *
     * @return The {@link Text} of the title, if it was configured
     */
    Optional<Text> getTitle();

    /**
     * Returns the subtitle of this title configuration.
     *
     * @return The {@link Text} of the subtitle, if it was configured
     */
    Optional<Text> getSubtitle();

    /**
     * Returns the action bar text of this title configuration.
     *
     * @return The {@link Text} of the action bar, if it was configured
     */
    Optional<Text> getActionBar();

    /**
     * Returns the specified time to fade in the title on the client. Once this
     * period of time is over, the title will stay for the amount of time from
     * {@link #getStay}.
     *
     * <p>The default value for Vanilla is 20 (1 second).</p>
     *
     * @return The amount of ticks (1/20 second) for the fade in effect
     */
    Optional<Integer> getFadeIn();

    /**
     * Returns the specified time how long the title should stay on the client.
     * Once this period of time is over, the title will fade out using the
     * duration specified from {@link #getFadeOut}.
     *
     * <p>The default value for Vanilla is 60 (3 second).</p>
     *
     * @return The amount of ticks (1/20 second) for the stay effect
     */
    Optional<Integer> getStay();

    /**
     * Returns the specified time to fade out the title on the client.
     *
     * <p>The default value for Vanilla is 20 (1 second).</p>
     *
     * @return The amount of ticks (1/20 second) for the fade out effect
     */
    Optional<Integer> getFadeOut();

    /**
     * Returns whether this configuration is clearing the current title from the
     * screen.
     *
     * @return True if the current title will be removed from the client's
     *         screen
     */
    boolean isClear();

    /**
     * Returns whether this configuration is clearing the current title from the
     * screen and resetting the current configuration to the default values.
     *
     * <p>This is recommended when you want to make sure to display a single
     * title.</p>
     *
     * @return True if the current settings will be reset to the defaults
     */
    boolean isReset();

    /**
     * Creates a new {@link Builder} using the configuration of this instance.
     *
     * @return A new builder to modify this Title configuration
     */
    Builder toBuilder();

    /**
     * Represents a builder class to create immutable {@link Title}
     * configurations.
     *
     * @see Title
     */
    interface Builder extends CopyableBuilder<Title, Builder> {

        /**
         * Returns the current title of this builder.
         *
         * @return The current main title, or {@link Optional#empty()} if none
         * @see Title#getTitle()
         */
        Optional<Text> getTitle();

        /**
         * Sets the title to send to the player.
         *
         * @param title The text to use as the title, or {@code null} to reset
         * @return This title builder
         * @see Title#getTitle()
         */
        Builder title(@Nullable Text title);

        /**
         * Returns the current subtitle of this builder.
         *
         * @return The current subtitle, or {@link Optional#empty()} if none
         * @see Title#getSubtitle()
         */
        Optional<Text> getSubtitle();

        /**
         * Sets the subtitle to send to the player.
         *
         * @param subtitle The text to use as the subtitle, or {@code null} to
         *        reset
         * @return This title builder
         * @see Title#getSubtitle()
         */
        Builder subtitle(@Nullable Text subtitle);

        /**
         * Returns the current action bar text of this builder.
         *
         * @return The current action bar text, or {@link Optional#empty()} if none
         * @see Title#getActionBar()
         */
        Optional<Text> getActionBar();

        /**
         * Sets the action bar text to send to the player.
         *
         * @param actionBar The text to use for the action bar, or {@code null}
         *     to reset
         * @return This title builder
         * @see Title#getActionBar()
         */
        Builder actionBar(@Nullable Text actionBar);

        /**
         * Returns the current fade in effect time of the title.
         *
         * @return The current fade in time, or {@link Optional#empty()} if none
         * @see Title#getFadeIn()
         */
        Optional<Integer> getFadeIn();

        /**
         * Sets the duration in ticks of the fade in effect of the title. Once
         * this period of time is over the title will stay for the amount of
         * time specified in {@link #stay(Integer)}.
         *
         * <p>The default value for Vanilla is 20 (1 second).</p>
         *
         * @param fadeIn The amount of ticks (1/20 second) for the fade in
         *        effect, or {@code null} to reset
         * @return This title builder
         * @see Title#getFadeIn()
         */
        Builder fadeIn(@Nullable Integer fadeIn);

        /**
         * Returns the current stay effect time of the title.
         *
         * @return The current stay time, or {@link Optional#empty()} if none
         * @see Title#getStay()
         */
        Optional<Integer> getStay();

        /**
         * Sets the duration in ticks how long the title should stay on the
         * screen. Once this period of time is over the title will fade out
         * using the duration specified in {@link #fadeOut(Integer)}.
         *
         * <p>The default value for Vanilla is 60 (3 seconds).</p>
         *
         * @param stay The amount of ticks (1/20 second) to stay, or
         *        {@code null} to reset
         * @return This title builder
         * @see Title#getStay()
         */
        Builder stay(@Nullable Integer stay);

        /**
         * Returns the current fade out effect time of the title.
         *
         * @return The current fade out time, or {@link Optional#empty()} if
         *         none
         * @see Title#getFadeOut()
         */
        Optional<Integer> getFadeOut();

        /**
         * Sets the duration in ticks of the fade out effect of the title.
         *
         * <p>The default value for Vanilla is 20 (1 second).</p>
         *
         * @param fadeOut The amount of ticks (1/20 second) for the fade out
         *        effect, or {@code null} to reset
         * @return This title builder
         * @see Title#getFadeOut()
         */
        Builder fadeOut(@Nullable Integer fadeOut);

        /**
         * Returns whether this builder is currently configured to clear.
         *
         * @return {@code true} if the title will clear
         * @see Title#isClear()
         */
        boolean isClear();

        /**
         * Removes the currently displayed title from the player's screen. This
         * will keep the currently used display times and will only remove the
         * title.
         *
         * @return This title builder
         * @see Title#isClear()
         */
        Builder clear();

        /**
         * Sets whether the the currently displayed title should be removed from
         * the player's screen and will keep the currently used display times.
         *
         * @param clear Whether this title should clear
         * @return This title builder
         * @see Title#isClear()
         */
        Builder clear(boolean clear);

        /**
         * Returns whether this builder is currently configured to reset.
         *
         * @return {@code true} if the title will reset
         * @see Title#isReset()
         */
        boolean isReset();

        /**
         * Removes the currently displayed title from the player's screen and
         * set the configuration back to the default values.
         *
         * @return This title builder
         * @see Title#isReset()
         */
        Builder doReset();

        /**
         * Sets whether the currently displayed title should be removed from the
         * player's screen and the configuration set back to the default values.
         *
         * @param reset Whether this title should reset
         * @return This title builder
         * @see Title#isReset()
         */
        Builder doReset(boolean reset);

        /**
         * Builds an immutable instance of the current configuration.
         *
         * @return An immutable {@link Title} with the currently configured
         *         settings
         */
        Title build();
    }
}

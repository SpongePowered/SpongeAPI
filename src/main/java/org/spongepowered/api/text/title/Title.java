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

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.spongepowered.api.text.Text;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents an immutable configuration for an in-game title. Instances of this
 * interface can be created through the {@link Builder} by calling
 * {@link #builder()}.
 *
 * <p>All properties of a title are optional - if they are not set it will use
 * the current default values from the client.</p>
 */
public final class Title {

    public static final Title EMPTY = new Title();
    public static final Title CLEAR = new Title(null, null, null, null, null, null, true, false);
    public static final Title RESET = new Title(null, null, null, null, null, null, false, true);

    final Optional<Text> title;
    final Optional<Text> subtitle;
    final Optional<Text> actionBar;
    final Optional<Integer> fadeIn;
    final Optional<Integer> stay;
    final Optional<Integer> fadeOut;
    final boolean clear;
    final boolean reset;

    private Title() {
        this(null, null, null, null, null, null, false, false);
    }

    /**
     * Constructs a new immutable {@link Title} with the specified properties.
     *
     * @param title The main title of the title, or {@code null} for default
     * @param subtitle The subtitle of the title, or {@code null} for default
     * @param actionBar The action bar text of the title, or {@code null} for
     *     default
     * @param fadeIn The fade in time of the title, or {@code null} for default
     * @param stay The stay time of the title, or {@code null} for default
     * @param fadeOut The fade out time of the title, or {@code null} for
     *        default
     * @param clear {@code true} if this title clears the currently displayed
     *        one first
     * @param reset {@code true} if this title resets all settings to default
     *        first
     */
    Title(@Nullable Text title, @Nullable Text subtitle, @Nullable Text actionBar, @Nullable Integer fadeIn, @Nullable Integer stay,
            @Nullable Integer fadeOut, boolean clear, boolean reset) {
        this.title = Optional.ofNullable(title);
        this.subtitle = Optional.ofNullable(subtitle);
        this.actionBar = Optional.ofNullable(actionBar);
        this.fadeIn = Optional.ofNullable(fadeIn);
        this.stay = Optional.ofNullable(stay);
        this.fadeOut = Optional.ofNullable(fadeOut);
        this.clear = clear;
        this.reset = reset;
    }

    /**
     * Returns the title of this title configuration.
     *
     * @return The {@link Text} of the title, if it was configured
     */
    public Optional<Text> getTitle() {
        return this.title;
    }

    /**
     * Returns the subtitle of this title configuration.
     *
     * @return The {@link Text} of the subtitle, if it was configured
     */
    public Optional<Text> getSubtitle() {
        return this.subtitle;
    }

    /**
     * Returns the action bar text of this title configuration.
     *
     * @return The {@link Text} of the action bar, if it was configured
     */
    public Optional<Text> getActionBar() {
        return this.actionBar;
    }

    /**
     * Returns the specified time to fade in the title on the client. Once this
     * period of time is over, the title will stay for the amount of time from
     * {@link #getStay}.
     *
     * <p>The default value for Vanilla is 20 (1 second).</p>
     *
     * @return The amount of ticks (1/20 second) for the fade in effect
     */
    public Optional<Integer> getFadeIn() {
        return this.fadeIn;
    }

    /**
     * Returns the specified time how long the title should stay on the client.
     * Once this period of time is over, the title will fade out using the
     * duration specified from {@link #getFadeOut}.
     *
     * <p>The default value for Vanilla is 60 (3 second).</p>
     *
     * @return The amount of ticks (1/20 second) for the stay effect
     */
    public Optional<Integer> getStay() {
        return this.stay;
    }

    /**
     * Returns the specified time to fade out the title on the client.
     *
     * <p>The default value for Vanilla is 20 (1 second).</p>
     *
     * @return The amount of ticks (1/20 second) for the fade out effect
     */
    public Optional<Integer> getFadeOut() {
        return this.fadeOut;
    }

    /**
     * Returns whether this configuration is clearing the current title from the
     * screen.
     *
     * @return True if the current title will be removed from the client's
     *         screen
     */
    public boolean isClear() {
        return this.clear;
    }

    /**
     * Returns whether this configuration is clearing the current title from the
     * screen and resetting the current configuration to the default values.
     *
     * <p>This is recommended when you want to make sure to display a single
     * title.</p>
     *
     * @return True if the current settings will be reset to the defaults
     */
    public boolean isReset() {
        return this.reset;
    }

    /**
     * Creates a new {@link Builder} using the configuration of this instance.
     *
     * @return A new builder to modify this Title configuration
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Title)) {
            return false;
        }

        Title that = (Title) o;
        return this.title.equals(that.title)
                && this.subtitle.equals(that.subtitle)
                && this.actionBar.equals(that.actionBar)
                && this.fadeIn.equals(that.fadeIn)
                && this.stay.equals(that.stay)
                && this.fadeOut.equals(that.fadeOut)
                && this.clear == that.clear
                && this.reset == that.reset;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.title, this.subtitle, this.actionBar, this.fadeIn, this.stay, this.fadeOut, this.clear, this.reset);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("title", this.title.orElse(null))
                .add("subtitle", this.subtitle.orElse(null))
                .add("actionBar", this.actionBar.orElse(null))
                .add("fadeIn", this.fadeIn.orElse(null))
                .add("stay", this.stay.orElse(null))
                .add("fadeOut", this.fadeOut.orElse(null))
                .add("clear", this.clear)
                .add("reset", this.reset)
                .toString();
    }

    /**
     * Represents a builder class to create immutable {@link Title}
     * configurations.
     *
     * @see Title
     */
    public static final class Builder {

        @Nullable private Text title;
        @Nullable private Text subtitle;
        @Nullable private Text actionBar;
        @Nullable private Integer fadeIn;
        @Nullable private Integer stay;
        @Nullable private Integer fadeOut;
        private boolean clear;
        private boolean reset;

        /**
         * Constructs a new empty {@link Builder}.
         */
        Builder() {
        }

        /**
         * Constructs a new {@link Builder} with the properties of the given
         * {@link Title} as initial values.
         *
         * @param title The title to copy the values from
         */
        Builder(Title title) {
            this.title = title.title.orElse(null);
            this.subtitle = title.subtitle.orElse(null);
            this.actionBar = title.actionBar.orElse(null);
            this.fadeIn = title.fadeIn.orElse(null);
            this.stay = title.stay.orElse(null);
            this.fadeOut = title.fadeOut.orElse(null);
            this.clear = title.clear;
            this.reset = title.reset;
        }

        /**
         * Returns the current title of this builder.
         *
         * @return The current main title, or {@link Optional#empty()} if none
         * @see Title#getTitle()
         */
        public Optional<Text> getTitle() {
            return Optional.ofNullable(this.title);
        }

        /**
         * Sets the title to send to the player.
         *
         * @param title The text to use as the title, or {@code null} to reset
         * @return This title builder
         * @see Title#getTitle()
         */
        public Builder title(@Nullable Text title) {
            this.title = title;
            return this;
        }

        /**
         * Returns the current subtitle of this builder.
         *
         * @return The current subtitle, or {@link Optional#empty()} if none
         * @see Title#getSubtitle()
         */
        public Optional<Text> getSubtitle() {
            return Optional.ofNullable(this.subtitle);
        }

        /**
         * Sets the subtitle to send to the player.
         *
         * @param subtitle The text to use as the subtitle, or {@code null} to
         *        reset
         * @return This title builder
         * @see Title#getSubtitle()
         */
        public Builder subtitle(@Nullable Text subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        /**
         * Returns the current action bar text of this builder.
         *
         * @return The current action bar text, or {@link Optional#empty()} if none
         * @see Title#getActionBar()
         */
        public Optional<Text> getActionBar() {
            return Optional.ofNullable(this.actionBar);
        }

        /**
         * Sets the action bar text to send to the player.
         *
         * @param actionBar The text to use for the action bar, or {@code null}
         *     to reset
         * @return This title builder
         * @see Title#getActionBar()
         */
        public Builder actionBar(@Nullable Text actionBar) {
            this.actionBar = actionBar;
            return this;
        }

        /**
         * Returns the current fade in effect time of the title.
         *
         * @return The current fade in time, or {@link Optional#empty()} if none
         * @see Title#getFadeIn()
         */
        public Optional<Integer> getFadeIn() {
            return Optional.ofNullable(this.fadeIn);
        }

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
        public Builder fadeIn(@Nullable Integer fadeIn) {
            this.fadeIn = fadeIn;
            return this;
        }

        /**
         * Returns the current stay effect time of the title.
         *
         * @return The current stay time, or {@link Optional#empty()} if none
         * @see Title#getStay()
         */
        public Optional<Integer> getStay() {
            return Optional.ofNullable(this.stay);
        }

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
        public Builder stay(@Nullable Integer stay) {
            this.stay = stay;
            return this;
        }

        /**
         * Returns the current fade out effect time of the title.
         *
         * @return The current fade out time, or {@link Optional#empty()} if
         *         none
         * @see Title#getFadeOut()
         */
        public Optional<Integer> getFadeOut() {
            return Optional.ofNullable(this.fadeOut);
        }

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
        public Builder fadeOut(@Nullable Integer fadeOut) {
            this.fadeOut = fadeOut;
            return this;
        }

        /**
         * Returns whether this builder is currently configured to clear.
         *
         * @return {@code true} if the title will clear
         * @see Title#isClear()
         */
        public boolean isClear() {
            return this.clear;
        }

        /**
         * Removes the currently displayed title from the player's screen. This
         * will keep the currently used display times and will only remove the
         * title.
         *
         * @return This title builder
         * @see Title#isClear()
         */
        public Builder clear() {
            return clear(true);
        }

        /**
         * Sets whether the the currently displayed title should be removed from
         * the player's screen and will keep the currently used display times.
         *
         * @param clear Whether this title should clear
         * @return This title builder
         * @see Title#isClear()
         */
        public Builder clear(boolean clear) {
            if (this.clear = clear) {
                this.title = null; // No need to send title if we clear it after
                // that again
            }
            return this;
        }

        /**
         * Returns whether this builder is currently configured to reset.
         *
         * @return {@code true} if the title will reset
         * @see Title#isReset()
         */
        public boolean isReset() {
            return this.reset;
        }

        /**
         * Removes the currently displayed title from the player's screen and
         * set the configuration back to the default values.
         *
         * @return This title builder
         * @see Title#isReset()
         */
        public Builder reset() {
            return reset(true);
        }

        /**
         * Sets whether the currently displayed title should be removed from the
         * player's screen and the configuration set back to the default values.
         *
         * @param reset Whether this title should reset
         * @return This title builder
         * @see Title#isReset()
         */
        public Builder reset(boolean reset) {
            if (this.reset = reset) {
                // No need for these if we reset it again after that
                this.title = null;
                this.subtitle = null;
                this.fadeIn = null;
                this.stay = null;
                this.fadeOut = null;
            }
            return this;
        }

        /**
         * Builds an immutable instance of the current configuration.
         *
         * @return An immutable {@link Title} with the currently configured
         *         settings
         */
        public Title build() {
            // If the title has no other properties and is either empty, just clears
            // or just resets we can return a special instance
            if (this.title == null
                && this.subtitle == null
                && this.actionBar == null
                && this.fadeIn == null
                && this.stay == null
                && this.fadeOut == null) {
                if (this.clear) {
                    if (!this.reset) {
                        return CLEAR;
                    }
                } else if (this.reset) {
                    return RESET;
                } else {
                    return EMPTY;
                }
            }

            return new Title(
                    this.title, this.subtitle, this.actionBar,
                    this.fadeIn, this.stay, this.fadeOut,
                    this.clear, this.reset);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Builder)) {
                return false;
            }

            Builder that = (Builder) o;
            return Objects.equal(this.title, that.title)
                    && Objects.equal(this.subtitle, that.subtitle)
                    && Objects.equal(this.actionBar, that.actionBar)
                    && Objects.equal(this.fadeIn, that.fadeIn)
                    && Objects.equal(this.stay, that.stay)
                    && Objects.equal(this.fadeOut, that.fadeOut)
                    && this.clear == that.clear
                    && this.reset == that.reset;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.title, this.subtitle, this.actionBar, this.fadeIn, this.stay, this.fadeOut, this.clear, this.reset);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .omitNullValues()
                    .add("title", this.title)
                    .add("subtitle", this.subtitle)
                    .add("actionBar", this.actionBar)
                    .add("fadeIn", this.fadeIn)
                    .add("stay", this.stay)
                    .add("fadeOut", this.fadeOut)
                    .add("clear", this.clear)
                    .add("reset", this.reset)
                    .toString();
        }

    }

    /**
     * Returns a {@link Title} that will simply do nothing when it is sent to
     * the client.
     *
     * @return An empty title instance
     */
    public static Title of() {
        return EMPTY;
    }

    /**
     * Returns a {@link Title} that will display the given main title on the
     * player's screen.
     *
     * @param title The title to display
     * @return The created title
     */
    public static Title of(Text title) {
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
    public static Title of(Text title, Text subtitle) {
        return builder().title(title).subtitle(subtitle).build();
    }

    /**
     * Returns a {@link Title} that will clear the currently displayed
     * {@link Title} from the player's screen.
     *
     * @return A title configuration that will clear
     */
    public static Title clear() {
        return CLEAR;
    }

    /**
     * Returns a {@link Title} that will reset the current title back to default
     * values on the client.
     *
     * @return A title configuration that will reset
     */
    public static Title reset() {
        return RESET;
    }

    /**
     * Creates a new {@link Title} configuration builder that will reset the
     * currently displayed Title on the client before displaying the new
     * configured one.
     *
     * @return A new {@link Builder}
     * @see #update
     */
    public static Builder builder() {
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
    public static Builder update() {
        return new Builder();
    }

}

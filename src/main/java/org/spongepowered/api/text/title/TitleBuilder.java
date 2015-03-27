/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;

/**
 * Represents a builder class to create immutable {@link Title} configurations.
 *
 * @see Title
 */
public class TitleBuilder {

    @Nullable protected Text title;
    @Nullable protected Text subtitle;
    @Nullable protected Integer fadeIn;
    @Nullable protected Integer stay;
    @Nullable protected Integer fadeOut;
    protected boolean clear;
    protected boolean reset;

    /**
     * Constructs a new empty {@link TitleBuilder}.
     */
    public TitleBuilder() {
    }

    /**
     * Constructs a new {@link TitleBuilder} with the properties of the given
     * {@link Title} as initial values.
     *
     * @param title The title to copy the values from
     */
    public TitleBuilder(Title title) {
        this.title = title.title.orNull();
        this.subtitle = title.subtitle.orNull();
        this.fadeIn = title.fadeIn.orNull();
        this.stay = title.stay.orNull();
        this.fadeOut = title.fadeOut.orNull();
        this.clear = title.clear;
        this.reset = title.reset;
    }

    /**
     * Returns the current title of this builder.
     *
     * @return The current main title, or {@link Optional#absent()} if none
     * @see Title#getTitle()
     */
    public final Optional<Text> getTitle() {
        return Optional.fromNullable(this.title);
    }

    /**
     * Sets the title to send to the player.
     *
     * @param title The text to use as the title, or {@code null} to reset
     * @return This title builder
     * @see Title#getTitle()
     */
    public TitleBuilder title(@Nullable Text title) {
        this.title = title;
        return this;
    }

    /**
     * Returns the current subtitle of this builder.
     *
     * @return The current subtitle, or {@link Optional#absent()} if none
     * @see Title#getSubtitle()
     */
    public final Optional<Text> getSubtitle() {
        return Optional.fromNullable(this.subtitle);
    }

    /**
     * Sets the subtitle to send to the player.
     *
     * @param subtitle The text to use as the subtitle, or {@code null} to reset
     * @return This title builder
     * @see Title#getSubtitle()
     */
    public TitleBuilder subtitle(@Nullable Text subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    /**
     * Returns the current fade in effect time of the title.
     *
     * @return The current fade in time, or {@link Optional#absent()} if none
     * @see Title#getFadeIn()
     */
    public final Optional<Integer> getFadeIn() {
        return Optional.fromNullable(this.fadeIn);
    }

    /**
     * Sets the duration in ticks of the fade in effect of the title. Once this
     * period of time is over the title will stay for the amount of time
     * specified in {@link #stay(Integer)}.
     *
     * <p>The default value for Vanilla is 20 (1 second).</p>
     *
     * @param fadeIn The amount of ticks (1/20 second) for the fade in effect,
     *        or {@code null} to reset
     * @return This title builder
     * @see Title#getFadeIn()
     */
    public TitleBuilder fadeIn(@Nullable Integer fadeIn) {
        this.fadeIn = fadeIn;
        return this;
    }

    /**
     * Returns the current stay effect time of the title.
     *
     * @return The current stay time, or {@link Optional#absent()} if none
     * @see Title#getStay()
     */
    public final Optional<Integer> getStay() {
        return Optional.fromNullable(this.stay);
    }

    /**
     * Sets the duration in ticks how long the title should stay on the screen.
     * Once this period of time is over the title will fade out using the
     * duration specified in {@link #fadeOut(Integer)}.
     *
     * <p>The default value for Vanilla is 60 (3 seconds).</p>
     *
     * @param stay The amount of ticks (1/20 second) to stay, or {@code null} to
     *        reset
     * @return This title builder
     * @see Title#getStay()
     */
    public TitleBuilder stay(@Nullable Integer stay) {
        this.stay = stay;
        return this;
    }

    /**
     * Returns the current fade out effect time of the title.
     *
     * @return The current fade out time, or {@link Optional#absent()} if none
     * @see Title#getFadeOut()
     */
    public final Optional<Integer> getFadeOut() {
        return Optional.fromNullable(this.fadeOut);
    }

    /**
     * Sets the duration in ticks of the fade out effect of the title.
     *
     * <p>The default value for Vanilla is 20 (1 second).</p>
     *
     * @param fadeOut The amount of ticks (1/20 second) for the fade out effect,
     *        or {@code null} to reset
     * @return This title builder
     * @see Title#getFadeOut()
     */
    public TitleBuilder fadeOut(@Nullable Integer fadeOut) {
        this.fadeOut = fadeOut;
        return this;
    }

    /**
     * Returns whether this builder is currently configured to clear.
     *
     * @return {@code true} if the title will clear
     * @see Title#isClear()
     */
    public final boolean isClear() {
        return this.clear;
    }

    /**
     * Removes the currently displayed title from the player's screen. This will
     * keep the currently used display times and will only remove the title.
     *
     * @return This title builder
     * @see Title#isClear()
     */
    public TitleBuilder clear() {
        return clear(true);
    }

    /**
     * Sets whether the the currently displayed title should be removed from the
     * player's screen and will keep the currently used display times.
     *
     * @param clear Whether this title should clear
     * @return This title builder
     * @see Title#isClear()
     */
    public TitleBuilder clear(boolean clear) {
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
    public final boolean isReset() {
        return this.reset;
    }

    /**
     * Removes the currently displayed title from the player's screen and set
     * the configuration back to the default values.
     *
     * @return This title builder
     * @see Title#isReset()
     */
    public TitleBuilder reset() {
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
    public TitleBuilder reset(boolean reset) {
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
     * @return An immutable {@link Title} with the currently configured settings
     */
    public Title build() {
        // If the title has no other properties and is either empty, just clears
        // or just resets we can return a special instance
        if (this.title == null && this.subtitle == null && this.fadeIn == null && this.stay == null && this.fadeOut == null) {
            if (this.clear) {
                if (!this.reset) {
                    return Titles.clear();
                }
            } else if (this.reset) {
                return Titles.reset();
            } else {
                return Titles.of();
            }
        }

        return new Title(
                this.title, this.subtitle,
                this.fadeIn, this.stay, this.fadeOut,
                this.clear, this.reset);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TitleBuilder)) {
            return false;
        }

        TitleBuilder that = (TitleBuilder) o;
        return Objects.equal(this.title, that.title)
                && Objects.equal(this.subtitle, that.subtitle)
                && Objects.equal(this.fadeIn, that.fadeIn)
                && Objects.equal(this.stay, that.stay)
                && Objects.equal(this.fadeOut, that.fadeOut)
                && this.clear == that.clear
                && this.reset == that.reset;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.title, this.subtitle, this.fadeIn, this.stay, this.fadeOut, this.clear, this.reset);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("title", this.title)
                .add("subtitle", this.subtitle)
                .add("fadeIn", this.fadeIn)
                .add("stay", this.stay)
                .add("fadeOut", this.fadeOut)
                .add("clear", this.clear)
                .add("reset", this.reset)
                .toString();
    }

}

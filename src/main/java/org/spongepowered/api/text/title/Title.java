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
 * Represents an immutable configuration for an in-game title. Instances of this
 * interface can be created through the {@link TitleBuilder} by calling
 * {@link Titles#builder()}.
 *
 * <p>All properties of a title are optional - if they are not set it will use
 * the current default values from the client.</p>
 */
public class Title {

    protected final Optional<Text> title;
    protected final Optional<Text> subtitle;
    protected final Optional<Integer> fadeIn;
    protected final Optional<Integer> stay;
    protected final Optional<Integer> fadeOut;
    protected final boolean clear;
    protected final boolean reset;

    Title() {
        this(null, null, null, null, null, false, false);
    }

    /**
     * Constructs a new immutable {@link Title} with the specified properties.
     *
     * @param title The main title of the title, or {@code null} for default
     * @param subtitle The subtitle of the title, or {@code null} for default
     * @param fadeIn The fade in time of the title, or {@code null} for default
     * @param stay The stay time of the title, or {@code null} for default
     * @param fadeOut The fade out time of the title, or {@code null} for
     *        default
     * @param clear {@code true} if this title clears the currently displayed
     *        one first
     * @param reset {@code true} if this title resets all settings to default
     *        first
     */
    public Title(@Nullable Text title, @Nullable Text subtitle, @Nullable Integer fadeIn, @Nullable Integer stay, @Nullable Integer fadeOut,
            boolean clear, boolean reset) {
        this.title = Optional.fromNullable(title);
        this.subtitle = Optional.fromNullable(subtitle);
        this.fadeIn = Optional.fromNullable(fadeIn);
        this.stay = Optional.fromNullable(stay);
        this.fadeOut = Optional.fromNullable(fadeOut);
        this.clear = clear;
        this.reset = reset;
    }

    /**
     * Returns the title of this title configuration.
     *
     * @return The {@link Text} of the title, if it was configured
     */
    public final Optional<Text> getTitle() {
        return this.title;
    }

    /**
     * Returns the subtitle of this title configuration.
     *
     * @return The {@link Text} of the subtitle, if it was configured
     */
    public final Optional<Text> getSubtitle() {
        return this.subtitle;
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
    public final Optional<Integer> getFadeIn() {
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
    public final Optional<Integer> getStay() {
        return this.stay;
    }

    /**
     * Returns the specified time to fade out the title on the client.
     *
     * <p>The default value for Vanilla is 20 (1 second).</p>
     *
     * @return The amount of ticks (1/20 second) for the fade out effect
     */
    public final Optional<Integer> getFadeOut() {
        return this.fadeOut;
    }

    /**
     * Returns whether this configuration is clearing the current title from the
     * screen.
     *
     * @return True if the current title will be removed from the client's
     *         screen
     */
    public final boolean isClear() {
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
    public final boolean isReset() {
        return this.reset;
    }

    /**
     * Creates a new {@link TitleBuilder} using the configuration of this
     * instance.
     *
     * @return A new builder to modify this Title configuration
     */
    public TitleBuilder builder() {
        return new TitleBuilder(this);
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
                && this.fadeIn.equals(that.fadeIn)
                && this.stay.equals(that.stay)
                && this.fadeOut.equals(that.fadeOut)
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

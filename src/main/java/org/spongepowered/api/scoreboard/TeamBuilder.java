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
package org.spongepowered.api.scoreboard;

import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;

import java.util.Set;

/**
 * Represents a builder tp create {@link Team} instances.
 */
public interface TeamBuilder {

    /**
     * Sets the name of the {@link Team}.
     *
     * @param name The name to set
     * @return This builder
     */
    TeamBuilder name(String name);

    /**
     * Sets the color of the {@link Team}.
     *
     * <p>The team's color is a distinct concept from its prefix or suffix.
     * It is only used for colored sidebar display slots, and certain statistic
     * criteria.</p>
     *
     * @param color The color to set
     * @throws IllegalArgumentException If color is {@link org.spongepowered.api.text.format.TextColors#RESET}
     * @return This builder
     */
    TeamBuilder color(TextColor color) throws IllegalArgumentException;

    /**
     * Sets the name displayed to users for the {@link Team}.
     *
     * <p>Display names may be truncated in order to meet an implementation-defined length limit.
     * In Vanilla, this is sixteen characters.</p>
     *
     * @param displayName The {@link Text} to set
     * @return This builder
     */
    TeamBuilder displayName(Text displayName) throws IllegalArgumentException;

    /**
     * Sets the prefix prepended to the display name of users on the {@link Team}.
     *
     * <p>Display names may be truncated in order to meet an implementation-defined length limit.
     * In Vanilla, this is sixteen characters.</p>
     *
     * @param prefix The new prefix for the {@link Team}
     * @return This builder
     */
    TeamBuilder prefix(Text prefix);

    /**
     * Sets the suffix appended to the display name of users on the {@link Team}.
     *
     * <p>Display names may be truncated in order to meet an implementation-defined length limit.
     * In Vanilla, this is sixteen characters.</p>
     *
     * @param suffix The new suffix for the {@link Team}.
     * @return This builder
     */
    TeamBuilder suffix(Text suffix);

    /**
     * Sets whether friendly fire is enabled for the {@link Team}.
     *
     * @param enabled Whether friendly fire is enabled
     * @return This builder
     */
    TeamBuilder allowFriendlyFire(boolean enabled);

    /**
     * Sets whether invisible team members are shown for the {@link Team}.
     *
     * @param enabled Whether to show invisible teammates
     * @return This builder
     */
    TeamBuilder canSeeFriendlyInvisibles(boolean enabled);

    /**
     * Sets the {@link Visibility} which controls to who nametags
     * of players on the {@link Team} are visible to.
     *
     * @param visibility The {@link Visibility} for the {@link Team}'s nametags
     * @return This builder
     */
    TeamBuilder nameTagVisibility(Visibility visibility);

    /**
     * Sets the {@link Visibility} which controls who death Texts
     * of players on the {@link Team} are visible to.
     *
     * @param visibility The {@link Visibility} for the {@link Team}'s death Texts
     * @return This builder
     */
    TeamBuilder deathTextVisibility(Visibility visibility);

    /**
     * Sets the set of {@link User}s on the {@link Team}.
     *
     * <p>By default, this is the empty set.</p>
     *
     * @param users The set of {@link User}s on the {@link Team}
     * @return This builder
     */
    TeamBuilder users(Set<User> users);

    /**
     * Resets all information regarding the {@link Team} to be created.
     *
     * @return This builder
     */
    TeamBuilder reset();

    /**
     * Builds an instance of a {@link Team}.
     *
     * @return A new instance of a {@link Team}
     * @throws IllegalStateException if the {@link Team} is not complete
     */
    Team build() throws IllegalStateException;

    /**
     * Checks if this is a flowerpot.
     *
     * @return Whether this is a flowerpot
     */
    boolean isFlowerPot();
}

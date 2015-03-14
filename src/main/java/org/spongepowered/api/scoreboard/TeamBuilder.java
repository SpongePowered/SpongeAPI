package org.spongepowered.api.scoreboard;

import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.message.Message;

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
     * @param displayName The {@link Message} to set
     * @return This builder
     */
    TeamBuilder displayName(Message displayName) throws IllegalArgumentException;

    /**
     * Sets the prefix prepended to the display name of users on the {@link Team}.
     *
     * <p>Display names may be truncated in order to meet an implementation-defined length limit.
     * In Vanilla, this is sixteen characters.</p>
     *
     * @param prefix The new prefix for the {@link Team}
     * @return This builder
     */
    TeamBuilder prefix(Message prefix);

    /**
     * Sets the suffix appended to the display name of users on the {@link Team}.
     *
     * <p>Display names may be truncated in order to meet an implementation-defined length limit.
     * In Vanilla, this is sixteen characters.</p>
     *
     * @param suffix The new suffix for the {@link Team}.
     * @return This builder
     */
    TeamBuilder suffix(Message suffix);

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
     * Sets the {@link Visibility} which controls who death messages
     * of players on the {@link Team} are visible to.
     *
     * @param visibility The {@link Visibility} for the {@link Team}'s death messages
     * @return This builder
     */
    TeamBuilder deathMessageVisibility(Visibility visibility);

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

}

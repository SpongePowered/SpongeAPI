package org.spongepowered.api.util.provider;

import com.google.common.base.Optional;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.text.format.TextColor;

public interface DisplaySlotProvider extends Provider {

    /**
     * Gets a {@link DisplaySlot} which displays only for teams
     * with the provided color.
     *
     * @param color The color for the display slot
     * @return The {@link DisplaySlot} with the provided color, or Optional.absent() if not found
     */
    Optional<DisplaySlot> getDisplaySlotForColor(TextColor color);
}

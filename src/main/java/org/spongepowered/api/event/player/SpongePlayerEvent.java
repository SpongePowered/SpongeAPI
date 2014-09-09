package org.spongepowered.api.event.player;

import com.google.common.base.Preconditions;
import com.sun.istack.internal.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.SpongeEvent;

public class SpongePlayerEvent extends SpongeEvent{
    private EntityPlayer player;
    public SpongePlayerEvent(Game game, EntityPlayer player) {
        super(game);
    }


    /**
     * Returns the player who triggered this event.
     * @return The Player
     */
    @Nullable
    public EntityPlayer getPlayer() {
        return Preconditions.checkNotNull(player);
    }
    @Nullable
    public void setPlayer(EntityPlayer player) {
        this.player = Preconditions.checkNotNull(player);
    }
}

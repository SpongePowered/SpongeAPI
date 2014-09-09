package org.spongepowered.api.event.player;

import com.google.common.base.Preconditions;
import com.sun.istack.internal.Nullable;
import net.minecraft.entity.player.EntityPlayerMP;
import org.apache.logging.log4j.Level;
import org.spongepowered.api.Game;

public class SpongePlayerChatEvent extends SpongePlayerEvent {
    private String message = "";
    private EntityPlayerMP sender;

    public SpongePlayerChatEvent(Game game, EntityPlayerMP sender, String message) {
        super(game, sender);
        this.message = message;
        game.getLogger().log(Level.DEBUG, message);
    }
    /**
     * Returns the message sent in this event.
     * @return The message to which this event pertains.
     */
    @Nullable
    public String getMessage() {
        return Preconditions.checkNotNull(message);
    }

    /**
     * Modify the message that was sent in this event.
     * @param message
     */
    @Nullable
    public void setMessage(String message) {
        this.message = Preconditions.checkNotNull(message);
    }

}

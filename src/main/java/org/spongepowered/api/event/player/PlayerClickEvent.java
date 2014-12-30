package org.spongepowered.api.event.player;

import com.flowpowered.math.vector.Vector3f;

public interface PlayerClickEvent extends PlayerEvent {
    /**
     * Gets the position the player clicked on the block in 3d space. This is a @{link Vector3f} with the X, Y and Z
     * being the relative position to the block that was clicked.
     *
     * <p>This can be used to pick out which pixel of the texture the player clicked, allowing for some neat features.</p>
     *
     * <p>This may not be completely accurate, for some event types the client may not send enough information. If the
     * client doesn't send enough information, the value will be approximated.</p>
     *
     * @return A @{Vector3f} of the position the player clicked on the block
     */
    Vector3f getHitPosition();
}

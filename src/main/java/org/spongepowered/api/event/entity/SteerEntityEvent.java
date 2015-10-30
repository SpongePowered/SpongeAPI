package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.CauseTracked;

/**
 * Raised when an {@link Entity} is being steered by a mounted {@link Player}.
 * 
 * <p>This event does not raise for when an entity mounted by another entity
 * moves; it is only thrown when a player attempts to steer a mounted
 * entity.</p>
 */
public interface SteerEntityEvent extends TargetEntityEvent, CauseTracked {

    /**
     * Returns the forward speed, a float value between -1 and 1, at which the
     * mounted {@link Player} is attempting to move at.
     * 
     * <p>Positive values represent movement in the direction the mounted player
     * is looking at (holding Move Forward), negative values represent movement
     * in the opposite direction. A value of 0 represents no steering movement
     * forwards or backwards.</p>
     * 
     * <p>A notchian client will, in most cases usually send a value of 0.98
     * going forwards or backwards; 0.3 (rounded up from 0.29400003) while
     * sneaking.</p>
     */
    public float getForwardSpeed();

    /**
     * Returns the strafing speed, a value between -1 and 1, at which the
     * mounted {@link Player} is attempting to move at.
     * 
     * <p>Positive values represent strafing to the left of the mounted player,
     * negative values represent strafing to the right. A value of 0 represents
     * no steering movement sideways.</p>
     * 
     * <p>A notchian client will, in most cases usually send a value of 0.98
     * going sideways; 0.3 (rounded up from 0.29400003) while sneaking.</p>
     */
    public float getStrafeSpeed();

    /**
     * Returns whether or not the mounted player was sneaking while steering.
     */
    public boolean isSneaking();

    /**
     * Returns whether or not the mounted player jumped while steering.
     */
    public boolean isJumping();
}

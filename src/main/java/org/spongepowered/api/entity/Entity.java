package org.spongepowered.api.entity;

import java.util.UUID;

public interface Entity {

    /**
     * Get id of the entity
     *
     * @return Id of entity
     */
    public int getEntityId();

    /**
     * Get unique id of entity
     *
     * @return Unique entity id
     */
    public UUID getUniqueId();

    //TODO: Get entity location

    //TODO: Get entity velocity

    //TODO: Set entity velocity

    /**
     * Check if the entity is on the ground.
     *
     * @return Entity on ground?
     */
    public boolean isOnGround();

    /**
     * Check if the entity is alive.
     *
     * @return Entity alive?
     */
    public boolean isAlive();

    /**
     * Check if the entity is dead.
     *
     * @return Entity dead?
     */
    public boolean isDead();

    /**
     * Get height of the entity.
     *
     * @return Height of entity
     */
    public double getHeight();

    /**
     * Get width of the entity
     *
     * @return Width of entity
     */
    public double getWidth();

    /**
     * Get length of the entity
     *
     * @return Length of entity
     */
    public double getLength();

    /**
     * Get the current distance the entity has been falling for.
     *
     * @return Entity falling distance
     */
    public float getFallDistance();

    /**
     * Set entity falling distance.
     *
     * @param fallDistance Entity falling distance
     */
    public void setFallDistance(float fallDistance);

    /**
     * Get the amount of ticks the entity has lived for.
     *
     * @return Entity alive ticks
     */
    public int getTicksLived();

    /**
     * Set the amount of ticks the entity has lived for.
     *
     * @param ticksLived Entity alive ticks
     */
    public void setTicksLived(int ticksLived);

    /**
     * Get the max fire ticks of the entity.
     *
     * @return Entity max fire ticks.
     */
    public int getMaxFireTicks();

    /**
     * Get the amount of ticks the entity will be on fire for.
     *
     * @return Entity fire ticks
     */
    public int getFireTicks();

    /**
     * Set the amount of ticks the entity will be on fire for.
     *
     * @param fireTicks Entity fire ticks
     */
    public void setFireTicks(int fireTicks);

    /**
     * Check if the entity is in water.
     *
     * @return Entity in water?
     */
    public boolean isInWater();

    /**
     * Get the amount of ticks the entity will not be damaged for.
     *
     * @return Entity no-damage ticks
     */
    public int getNoDamageTicks();

    /**
     * Set the amount of ticks the entity will not be damaged for.
     *
     * @param noDamageTicks Entity no-damage ticks
     */
    public void setNoDamageTicks(int noDamageTicks);

    /**
     * Check if the entity is invulnerable to fire.
     *
     * @return Entity invulnerable to fire?
     */
    public boolean isFireProof();

    /**
     * Set if the entity should be invulnerable to fire.
     *
     * @param fireProof Entity invulnerable to fire
     */
    public void setFireProof(boolean fireProof);

    //TODO: Some kind of getEntityProperties

    /**
     * Get the amount of ticks the entity is ignored by portal blocks
     *
     * @return Portal cooldown in ticks
     */
    public int getPortalCooldown();

    /**
     * Set the amount of ticks the entity is ignored by portal blocks
     *
     * @param portalCooldown Portal cooldown in ticks
     */
    public void setPortalCooldown(int portalCooldown);

    /**
     * Check if the entity is invulnerable
     *
     * @return Enity invulnerable?
     */
    public boolean isInvulnerable();

    /**
     * Set if the entity is invulnerable.
     *
     * @param invulnerable Entity invulnerable
     */
    public void setInvulnerable(boolean invulnerable);

    //TODO: Remaining methods, teleport, getWorld, getPosition etc.
}

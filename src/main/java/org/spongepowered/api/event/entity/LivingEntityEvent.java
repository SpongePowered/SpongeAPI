package org.spongepowered.api.event.entity;

import org.spongepowered.api.Game;
import org.spongepowered.api.entity.LivingEntity;

/**
 * Event for all living entitys
 */
public abstract class LivingEntityEvent extends EntityEvent{

    private LivingEntity livingEntity;

    public LivingEntityEvent(Game game, LivingEntity entity){
        super(game, entity);
        this.livingEntity=entity;
    }

    public LivingEntity getLivingEntity(){
        return this.livingEntity;
    }
}

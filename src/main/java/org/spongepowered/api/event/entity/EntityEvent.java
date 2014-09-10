package org.spongepowered.api.event.entity;

import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.SpongeEvent;

/**
 * Basic Event for an entity
 */
public abstract class EntityEvent extends SpongeEvent {

    private Entity entity;

    public EntityEvent(Game game, Entity entity){
        super(game);
        this.entity=entity;
    }

    public Entity getEntity(){
        return this.entity;
    }
}

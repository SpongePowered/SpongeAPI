package org.spongepowered.api.event.target.entity;

public interface BreedEntityEvent extends InteractEntityEvent {

    interface SourceEntity extends BreedEntityEvent, InteractEntityEvent.SourceEntity { }

}

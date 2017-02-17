

package org.spongepowered.api.event.action;


public interface FishingEvent extends org.spongepowered.api.event.Event {
    org.spongepowered.api.entity.EntitySnapshot getOriginalFishHook();

    org.spongepowered.api.entity.projectile.FishHook getFishHook();

    interface Start extends org.spongepowered.api.event.Cancellable , org.spongepowered.api.event.action.FishingEvent {    }

    interface HookEntity extends org.spongepowered.api.event.Cancellable , org.spongepowered.api.event.action.FishingEvent , org.spongepowered.api.event.entity.TargetEntityEvent {    }

    interface Stop extends org.spongepowered.api.event.Cancellable , org.spongepowered.api.event.action.FishingEvent , org.spongepowered.api.event.entity.ChangeEntityExperienceEvent {
        java.util.List<org.spongepowered.api.data.Transaction<org.spongepowered.api.item.inventory.ItemStackSnapshot>> getItemStackTransaction();
    }
}


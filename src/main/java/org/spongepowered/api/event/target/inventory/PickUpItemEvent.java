package org.spongepowered.api.event.target.inventory;

import org.spongepowered.api.entity.Item;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.inventory.InventoryEvent;
import org.spongepowered.api.event.source.block.BlockEvent;
import org.spongepowered.api.event.source.entity.EntityEvent;
import org.spongepowered.api.event.source.entity.living.LivingEvent;
import org.spongepowered.api.event.source.entity.living.human.HumanEvent;
import org.spongepowered.api.event.source.entity.living.human.player.PlayerEvent;

import java.util.Collection;

public interface PickUpItemEvent extends InventoryEvent, Cancellable {

    /**
     * Gets the items as an {@link Item} entity that are being picked up.
     *
     * @return The items as entities
     */
    Collection<Item> getItems();

    interface SourceBlock extends PickUpItemEvent, BlockEvent { }

    interface SourceEntity extends PickUpItemEvent, EntityEvent { }

    interface SourceLiving extends SourceEntity, LivingEvent { }

    interface SourceHuman extends SourceLiving, HumanEvent { }

    interface SourcePlayer extends SourceHuman, PlayerEvent { }


}

package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableFallDistanceData;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * A {@link DataManipulator} that represents the distance an entity has fallen
 * in the world. Usually the higher this value, the more damage that inflicted
 * when the entity reaches the ground.
 */
public interface FallDistanceData extends DataManipulator<FallDistanceData, ImmutableFallDistanceData> {

    /**
     * Gets the {@link Value} for the current fall distance.
     * @return The value for the fall distance
     */
    MutableBoundedValue<Float> fallDistance();

}

package org.spongepowered.api.data.manipulator.immutable.entity;

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.FallDistanceData;
import org.spongepowered.api.data.value.immutable.ImmutableBoundedValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

/**
 * A {@link ImmutableDataManipulator} that represents the distance an entity has fallen
 * in the world. Usually the higher this value, the more damage that inflicted
 * when the entity reaches the ground.
 */
public interface ImmutableFallDistanceData extends ImmutableDataManipulator<ImmutableFallDistanceData, FallDistanceData> {

    /**
     * Gets the {@link ImmutableValue} for the current fall distance.
     * @return The value for the fall distance
     */
    ImmutableBoundedValue<Float> fallDistance();

}

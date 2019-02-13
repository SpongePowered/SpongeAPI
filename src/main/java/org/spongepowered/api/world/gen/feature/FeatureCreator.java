package org.spongepowered.api.world.gen.feature;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.ProtoWorld;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.GenerationRegion;

import java.util.Random;

public interface FeatureCreator<C> {

    /**
     * Places what would be considered the "feature" centered at the origin
     * position in the provided {@link ProtoWorld}. The world is not guaranteed
     * to be an active {@link World}, as it can be a {@link GenerationRegion}
     * for chunk generation. The configuration object is used to determine
     * various feature options, potentially exposed by the feature itself.
     *
     * @param world The world region where the feature is to be placed
     * @param random The random number provider
     * @param origin The origin point of the feature
     * @param config The config object for configuring the feature to be placed
     * @return True
     */
    boolean place(ProtoWorld<?> world, Random random, Vector3i origin, C config);

}

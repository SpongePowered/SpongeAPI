package org.spongepowered.api.world.gen.feature;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.ProtoWorld;

import java.util.Random;

public interface FeaturePlacer<P extends PlacementConfig> {

    <C> boolean generate(ProtoWorld<?> worldIn, Random random, Vector3i pos, P placementConfig, FeatureCreator<C> feature, C featureConfig);

}

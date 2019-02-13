package org.spongepowered.api.world.gen.feature;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.ProtoWorld;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.gen.FeatureConfig;

import java.util.Random;

/**
 * A pre-composed {@link FeatureCreator} that has a designated and configured
 * {@link FeaturePlacer} and {@link FeatureCreator}. The uses for this is to
 * pre-compose features that would otherwise be found in {@link BiomeType}s.
 *
 * @param <F>
 * @param <P>
 */
public interface CompositeFeature<F extends FeatureConfig, P extends PlacementConfig> extends FeatureCreator<F> {

    F getFeatureConfig();

    FeatureCreator<F> getCreator();

    P getPlacementConfig();

    FeaturePlacer<P> getPlacer();

    @Override
    default boolean place(ProtoWorld<?> world, Random random, Vector3i origin, F config) {
        return getPlacer().generate(world, random, origin, getPlacementConfig(), getCreator(), getFeatureConfig());
    }

}

package org.spongepowered.api.world.gen;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.world.ProtoWorld;
import org.spongepowered.api.world.volume.composite.ReadableCompositeVolume;

import java.util.Random;

public interface WorldCarver<C extends FeatureConfig> {

    boolean canCarve(ReadableCompositeVolume volume, Random random, Vector2i chunkPosition, C configuration);

    boolean carve(ProtoWorld<?> world, Random random, Vector2i chunkPosition, Vector2i targetPosition, C configuration);

}

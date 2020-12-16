package org.spongepowered.api.world.gen;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;

public interface MutableWorldGeneratorSettings extends WorldGeneratorSettings{

    static Builder of() {
        return Sponge.getGame().getBuilderProvider().provide(Builder.class);
    }

    /**
     * Sets the seed
     *
     * @param seed The seed
     */
    void setSeed(long seed);

    /**
     * Sets whether features will generate
     *
     * @param featuresGenerate Whether features will generate
     */
    void setFeaturesGenerate(boolean featuresGenerate);

    /**
     * Sets if the bonus chest will generate.
     *
     * @param generateBonusChest Whether features will generate
     */
    void setGenerateBonusChest(boolean generateBonusChest);

    interface Builder extends ResettableBuilder<WorldGeneratorSettings, Builder> {

        Builder seed(long seed);

        Builder generateFeatures(boolean generateFeatures);

        Builder generateBonusChest(boolean generateBonusChest);

        WorldGeneratorSettings build();
    }
}

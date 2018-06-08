package org.spongepowered.api.data.value.meta;

import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.ListValue;

public interface PatternListValue extends ListValue<PatternLayer> {

    default boolean contains(BannerPatternShape shape) {
        return getAll()
            .stream()
            .anyMatch(patternLayer -> patternLayer.getShape().equals(shape));
    }

    default boolean contains(DyeColor color) {
        return getAll()
            .stream()
            .anyMatch(patternLayer -> patternLayer.getColor().equals(color));
    }

}

package org.spongepowered.api.data;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.data.value.Value;

public interface DataPerspectiveResolver<V extends Value<E>, E> {

    /**
     * Gets the {@link Key} this resolver supports.
     *
     * @return The key
     */
    Key<V> key();

    /**
     * When multiple plugins provide the same key this is used to
     * merge and pick the best.
     *
     * @return The merged value
     */
    E merge(Iterable<E> values);

    /**
     * When data holders value changes when looking at perspective of.
     *
     * @param dataHolder The data holder which value was overridden.
     * @param perspective The perspective it is perceived from.
     * @param value The value.
     */
    void apply(DataHolder dataHolder, DataPerspective perspective, @Nullable E value);
}

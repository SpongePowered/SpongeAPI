package org.spongepowered.api.data.manipulator;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.persistence.DataContentUpdater;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Set;

public interface SimpleCustomData<T> {

    Key<Value<T>> getKey();

    String getName();

    String getID();

    int getContentVersion();

    Set<DataContentUpdater> getContentUpdaters();

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    interface Builder extends ResettableBuilder<SimpleCustomData, Builder> {

        Builder contentVersion(int version);

        Builder contentUpdaters(Iterable<DataContentUpdater> updaters);

        Builder name(String name);

        Builder id(String id);

        <T> SimpleCustomData<T> build();

    }

}

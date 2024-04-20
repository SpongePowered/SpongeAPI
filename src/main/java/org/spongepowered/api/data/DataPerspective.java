package org.spongepowered.api.data;

import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.plugin.PluginContainer;

public interface DataPerspective {

    Iterable<DataPerspective> perceives();

    ValueContainer getDataPerception(DataPerspective perspective);

    DataHolder.Mutable createDataPerception(PluginContainer plugin, DataPerspective perspective);
}

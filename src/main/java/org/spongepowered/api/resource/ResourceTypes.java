package org.spongepowered.api.resource;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

// TODO I don't like this
public class ResourceTypes {

    // SORTFIELDS:ON

    public static final ResourceType ASSETS = DummyObjectProvider.createFor(ResourceType.class, "ASSETS");

    public static final ResourceType DATA = DummyObjectProvider.createFor(ResourceType.class, "DATA");

    // SORTFIELDS:OFF
}

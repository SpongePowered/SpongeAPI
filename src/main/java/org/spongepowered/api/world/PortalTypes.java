package org.spongepowered.api.world;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public class PortalTypes {

    // SORTFIELDS:ON

    public static final PortalType END = DummyObjectProvider.createFor(PortalType.class, "END");

    public static final PortalType NETHER = DummyObjectProvider.createFor(PortalType.class, "NETHER");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private PortalTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}

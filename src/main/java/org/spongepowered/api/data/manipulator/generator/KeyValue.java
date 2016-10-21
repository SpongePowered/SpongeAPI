package org.spongepowered.api.data.manipulator.generator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface KeyValue {

    String value();

}

package org.spongepowered.api.data.prop;

import org.spongepowered.api.data.DataObject;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Marker interface for props that can only be set.
 *
 * @param <E> The type of value that this property has
 * @param <V> The type of {@link DataObject}s this property is restricted to
 */
@CatalogedBy(Props.class)
public interface SetterProp<E, V> {
}

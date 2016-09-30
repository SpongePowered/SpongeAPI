package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableTagsData;
import org.spongepowered.api.data.value.mutable.SetValue;

public interface TagsData extends DataManipulator<TagsData, ImmutableTagsData>{

	SetValue<String> tags();
	
}

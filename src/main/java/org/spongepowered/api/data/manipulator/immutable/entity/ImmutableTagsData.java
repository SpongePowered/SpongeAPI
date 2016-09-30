package org.spongepowered.api.data.manipulator.immutable.entity;

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.TagsData;
import org.spongepowered.api.data.value.immutable.ImmutableSetValue;

public interface ImmutableTagsData extends ImmutableDataManipulator<ImmutableTagsData, TagsData>  {

	ImmutableSetValue<String> tags();
	
}

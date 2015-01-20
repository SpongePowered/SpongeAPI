package org.spongepowered.api.attributes;

public interface AttributeModifierBuilder {
	
	AttributeModifierBuilder attribute(Attribute attribute);
	
	AttributeModifierBuilder value(double value);
	
	AttributeModifierBuilder operation(Operation operation);
	
	AttributeModifier build();
	
}

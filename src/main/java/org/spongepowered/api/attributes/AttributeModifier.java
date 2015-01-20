package org.spongepowered.api.attributes;


public interface AttributeModifier {

	/**
	 * Gets the operation used to modify a holder.
	 * @return The operation used to modify a holder.
	 */
	public Operation getOperation();
	
	/**
	 * Sets the operation used to modify a holder.
	 * @param operation The new operation used to modify a holder.
	 */
	public void setOperation(Operation operation);
	
	/**
	 * Gets the value used in modification.
	 * @return The value used in modification.
	 */
	public double getValue();
	
	/**
	 * Sets the value used in modification.
	 * @param value The new value to be used in modification.
	 */
	public void setValue(double value);
	
	/**
	 * Gets the attribute to modify.
	 * @return The attribute to modify.
	 */
	public Attribute getAttribute();
	
	/**
	 * Sets the attribute to modify.
	 * @param attribute The new attribute to modify.
	 */
	public void setAttribute(Attribute attribute);
	
}

package org.spongepowered.api.entity.living;

/**
 * Represents a living entity that can change in size as it ages
 * and can spawn children.
 */
public interface Ageable extends LivingEntity {

    /**
     * Gets the age of this entity.
     *
     * @return the current age of this entity
     */
    int getAge();

    /**
     * Sets the age of this entity.
     * <p>Negative ages tend to equate to the entity being a baby and
     * therefor can not breed more of this entity. Setting a positive age
     * tends to equate to the entity being an adult and able to breed children.
     * </p>
     *
     * @param age the age of this entity
     */
    void setAge(int age);

    /**
     * Sets the age of this entity to the minimum required to be considered a
     * baby. Babies tend to be unable to breed.
     */
    void setBaby();

    /**
     * Sets the age of this entity to the minimum required to be considered a
     * full grown adult and able to breed.
     */
    void setAdult();

    /**
     * Returns true if this entity is considered an adult.
     *
     * @return true if this entity is an adult
     */
    boolean isBaby();

    /**
     * Returns true if this entity is able to breed. Some entities have
     * cooldowns between being able to breed new entities.
     *
     * @return true if this entity is able to breed
     */
    boolean canBreed();

    /**
     * Sets whether this entity can breed a new child.
     * @param breeding
     */
    void setBreeding(boolean breeding);

    /**
     * Sets the scaling to be 1 if this entity is an adult and 0.5 if it is
     * a baby.
     */
    void setScaleForAge();
}

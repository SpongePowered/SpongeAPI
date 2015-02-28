package org.spongepowered.api.item.data;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.service.persistence.DataSerializable;
import org.spongepowered.api.text.message.Message;

import com.google.common.base.Optional;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ItemData extends DataSerializable {

    /**
     * Gets if this item is unbreakable.
     * 
     * @return If this item is unbreakable
     */
    boolean isUnbreakable();

    /**
     * Sets if this item is unbreakable.
     * 
     * @param If this item is now unbreakable.
     */
    void setUnbreakable(boolean unbreakable);

    /**
     * Gets a set of the {@link BlockType}s this item can destroy.
     * 
     * @return A set of the BlockTypes this item can destroy
     */
    Optional<Set<BlockType>> getDestroyables();

    /**
     * Gets the levels added to the base cost when modifying this item in an
     * anvil.
     * 
     * @return The levels added to the base cost when modifying this item in an
     *         anvil
     */
    int getRepairModifier();

    /**
     * Sets the levels added to the base cost when modifying this item in an
     * anvil.
     * 
     * @param modifier the new levels added to the base cost when modifying this
     *        item in an anvil
     */
    void setRepairModifier(int modifier);

    /**
     * Get the enchantments applied to this stack with their levels.
     *
     * @return Map of enchantments to current levels
     */
    Map<Enchantment, Integer> getEnchantments();

    /**
     * Test if this stack has enchantments.
     *
     * @return Whether this stack is enchanted
     */
    boolean isEnchanted();

    /**
     * Set an enchantment to the given level, adding it if necessary.
     *
     * @param enchant Enchantment to set the level of
     * @param level Level to set the enchantment at
     */
    void setEnchantment(Enchantment enchant, int level);

    /**
     * Remove an enchantment from this stack.
     *
     * @param enchant Enchantment to remove
     */
    void removeEnchantment(Enchantment enchant);

    /**
     * Get the level of an enchantment on this stack.
     *
     * @param enchant The enchantment to get the level of
     * @return The level of the enchantment, or -1 if the enchantment is not
     *         applied to this stack
     */
    int getEnchantment(Enchantment enchant);

    /**
     * Gets the name of this item.
     * 
     * @return The name of this item
     */
    Message getName();

    /**
     * Sets the name of this item.
     * 
     * @param name The new name of this item
     */
    void setName(Message name);

    /**
     * Gets the list of lore on this item.
     * 
     * @return The list of lore on this item
     */
    List<Message> getLore();

    /**
     * Adds lore to the end of this item's list.
     * 
     * @param lore The lore to add
     */
    void addLore(Message lore);

    /**
     * Gets if certain information is displayed to the client.
     * 
     * @param infoType The type of information
     * @return If the type is hidden
     */
    boolean isHidden(String infoType);

    /**
     * Sets if certain information is displayed to the client.
     * 
     * @param infoType The type of information
     * @param hidden If the type is now hidden
     */
    void setHidden(String infoType, boolean hidden);

}

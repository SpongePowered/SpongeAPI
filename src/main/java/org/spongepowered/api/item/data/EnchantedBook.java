package org.spongepowered.api.item.data;

import org.spongepowered.api.item.Enchantment;

import java.util.Map;

public interface EnchantedBook extends ItemData {

    Map<Enchantment, Integer> getStoredEnchantments();
    
    void setStoredEnchantment(Enchantment enchantment, int level);

    void removeStoredEnchantment(Enchantment enchantment);
    
    int getStoredEnchantmentLevel(Enchantment enchantment);
}

/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.item.inventory;

import org.spongepowered.api.Nameable;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.text.translation.Translatable;

import com.google.common.base.Optional;

/**
 * Base interface for queryable inventories.
 * 
 * TODO Flesh out javadoc from proposal document. For now, see proposal doc
 * here: https://github.com/SpongePowered/SpongeAPI/pull/443
 */
public interface Inventory extends Iterable<Inventory>, Nameable {
    
    /**
     * Get the parent {@link Inventory} of this {@link Inventory} 
     */
    public abstract Inventory parent();

    /**
     * Returns an iterable view of all {@link Slot}s (leaf nodes) in this
     * Inventory
     */
    public abstract <T extends Inventory> Iterable<T> slots();

    /**
     * Return the first child inventory, effectively the same as
     * <code>Inventory::iterator().next()</code> but more convenient when we are
     * expecting a result set with only a single entry. Also use type specifier
     * to allow easy pseudo-duck-typing. If no children, then returns
     * <code>this</code>.
     */
    public abstract <T extends Inventory> T first();

    /**
     * Return the next sibling inventory, allows traversing the inventory
     * hierarchy without using an iterator. If no more children, returns an
     * {@link EmptyInventory}.
     */
    public abstract <T extends Inventory> T next();

    /**
     * Get and remove the first available stack from this Inventory
     */
    public abstract Optional<ItemStack> poll();
    
    /**
     * Get without removing the first available stack from this Inventory
     */
    public abstract Optional<ItemStack> peek();
    
    /**
     * Try to put an ItemStack into this Inventory. Just like {@link
     * java.util.Queue}, this method returns true if the Inventory accepted the
     * stack and false if not, the size of the supplied stack is reduced by the
     * number of items successfully consumed by the Inventory.
     */
    public abstract boolean offer(ItemStack stack);
    
    /**
     * Forcibly put the supplied stack into this inventory. Overwrites existing
     * objects in the inventory as required to accomodate the entire stack. The
     * entire stack is always consumed.
     */
    public abstract void set(ItemStack stack);
    
    /**
     * Clears this inventory if it is clearable. 
     */
    public abstract void clear();
    
    /**
     * The number of stacks currently in the Inventory. Either 1 or 0 for
     * {@link Slot}s and always 0 for {@link EmptyInventory}s.
     */
    public abstract int size();
    
    /**
     * The maximum number of stacks the Inventory can hold. Always 1 for
     * {@link Slot}s and always 0 for {@link EmptyInventory}s.
     */
    public abstract int capacity();
    
    /**
     * Returns true if this Inventory contains no children.
     */
    public abstract boolean isEmpty();

    /**
     * Checks for whether the given stack is contained in this Inventory. This
     * is equivalent to calling <code>!inv.query(stack).isEmpty();</code>
     *
     * @param stack The stack to check for
     * @return True if the stack is present in this list
     */
    public abstract boolean contains(ItemStack stack);

    /**
     * Checks for whether there is a stack in this Inventory with the given
     * ItemType. This is equivalent to calling <code>!inv.query(stack)
     * .isEmpty();</code>
     *
     * @param type The type to search for
     * @return True if at least one stack in this list has the given type
     */
    public abstract boolean contains(ItemType type);

    /**
     * Returns the maximum size of any stack in this Inventory.
     *
     * @return The maximum stack size of this list
     */
    public abstract int getMaxStackSize();

    /**
     * Sets the maximum stack size of any stack in this ItemList.
     *
     * @param size The new maximum stack size
     */
    public abstract void setMaxStackSize(int size);

    /**
     * Get a property defined in <em>this</em> inventory for the specified
     * (immediate) sub-inventory.
     */
    public abstract <T extends InventoryProperty<?, ?>> T getProperty(Inventory child, Class<T> property);
    
    /**
     * Get a property defined directly on this Inventory. For sub-inventories
     * this is effectively the same as <code>inv.getParent().getProperty(inv,
     * property);</code> but for top-level inventories may include properties
     * defined on the inventory directly. 
     */
    public abstract <T extends InventoryProperty<?, ?>> T getProperty(Class<T> property);
    
    /**
     * Query this inventory for inventories matching any of the supplied types.
     * This is effectively an <code>instanceof</code> check against each child
     * inventory. Logical <code>OR</code> is applied between operands.
     */
    public abstract <T extends Inventory> T query(Class<?>... types);
    
    /**
     * Query this inventory for inventories containing any of the supplied item
     * types. This query operates directly on {@link Slot} leaf nodes in the
     * inventory and will always return a collection containing only {@link
     * Slot} instances. Logical <code>OR</code> is applied between operands.
     */
    public abstract <T extends Inventory> T query(ItemTypes... types);
    
    /**
     * Query this inventory for inventories containing any stacks which match
     * the supplied stack operands. This query operates directly on {@link Slot}
     * leaf nodes in the inventory and will always return a collection
     * containing only {@link Slot} instances. Logical <code>OR</code> is
     * applied between operands.
     */
    public abstract <T extends Inventory> T query(ItemStack... types);
    
    /**
     * Query this inventory for inventories which match any of the supplied
     * properties. The <code>equals</code> method of each property is called on
     * each child inventory which has the supplied property. Logical
     * <code>OR</code> is applied between operands. This method is effectively
     * the same as calling {@link #query} with an {@link
     * InventoryProperty.Operator} of {@link InventoryProperty.Operator#EQUAL}.
     */
    public abstract <T extends Inventory> T query(InventoryProperty<?, ?>... props);
    
    /**
     * Query this inventory for inventories which match any of the supplied
     * properties with the specified operator. The relevant method of each
     * property is called on each child inventory which has the supplied
     * property. Logical <code>OR</code> is applied between operands.
     */
    public abstract <T extends Inventory> T query(InventoryProperty.Operator op, InventoryProperty<?, ?>... props);
    
    /**
     * Query this inventory for inventories matching any of the supplied titles.
     * Logical <code>OR</code> is applied between operands.
     */
    public abstract <T extends Inventory> T query(Translatable... names);
    
    /**
     * Query this inventory for inventories matching any of the supplied titles.
     * Logical <code>OR</code> is applied between operands.
     */
    public abstract <T extends Inventory> T query(String... names);
    
    /**
     * <p>Query this inventory by dynamically inspecting each operand. Each
     * operand in turn is checked for a match against the other query methods,
     * and if a matching method is found the query is performed using the
     * operand. This is repeated until all operands are consumed and allows a
     * union of multiple query types to be aggregated into a single view.</p>
     * 
     * <p>For operands with no matching type, the behaviour is determined by the
     * individual inventory. A naive match may be obtained by calling .equals()
     * against the child inventory passing the unknown operand as an argument.
     * </p>
     */
    public abstract <T extends Inventory> T query(Object... args);
}

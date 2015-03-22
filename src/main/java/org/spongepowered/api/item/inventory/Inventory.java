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

import com.google.common.base.Optional;
import org.spongepowered.api.Nameable;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.transaction.InventoryOperationResult;
import org.spongepowered.api.text.translation.Translatable;

import java.util.Collection;

import javax.annotation.Nullable;

/**
 * Base interface for queryable inventories.
 *
 * <p>TODO Flesh out javadoc from proposal document. For now, see proposal doc
 * here: https://github.com/SpongePowered/SpongeAPI/pull/443</p>
 */
public interface Inventory extends Iterable<Inventory>, Nameable {

    /**
     * Get the parent {@link Inventory} of this {@link Inventory}.
     * 
     * @return the parent inventory, returns null if there is no parent (this is
     *      a top-level inventory
     */
    @Nullable Inventory parent();

    /**
     * Returns an iterable view of all {@link Slot}s (leaf nodes) in this
     * Inventory.
     * 
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return an iterable view of all Slots (leaf nodes) in this inventory 
     */
    <T extends Inventory> Iterable<T> slots();

    /**
     * Return the first child inventory, effectively the same as
     * <code>Inventory::iterator().next()</code> but more convenient when we are
     * expecting a result set with only a single entry. Also use type specifier
     * to allow easy pseudo-duck-typing. If no children, then returns
     * <code>this</code>.
     * 
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the first child inventory, if there are no children then simply
     *      returns <code>this</code>
     */
    <T extends Inventory> T first();

    /**
     * Return the next sibling inventory, allows traversing the inventory
     * hierarchy without using an iterator. If no more children, returns an
     * {@link EmptyInventory}.
     * 
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the next sibiling inventory, or an {@link EmptyInventory} if
     *      there are no further siblings
     */
    <T extends Inventory> T next();

    /**
     * Get and remove the first available stack from this Inventory.
     * 
     * <p>'Available' has a different meaning for different inventory types. In 
     * a single-slot inventory this has a fixed implication. However larger and
     * more complex inventories are at liberty to implement whatever logic they
     * wish to back this method. If an inventory cannot provide a meaningful
     * implementation of this method then it should return
     * {@link Optional#absent()} instead.</p>
     * 
     * <p>For consumers, this means that just because an inventory doesn't
     * return anything here, this does not imply that the inventory is empty,
     * just that a more specific query is required to obtain items from it.</p>
     * 
     * @return First available itemstack, or {@link Optional#absent()} if
     *      unavailable or unsupported
     */
    Optional<ItemStack> poll();

    /**
     * <p>Get and remove up to <code>limit</code> items of the type in the first
     * available stack in this Inventory from all stacks in this Inventory. If
     * no stack is available then {@link Optional#absent()} is returned (as per
     * the usual behaviour of {@link #poll()}, otherwise a new {@link ItemStack}
     * is returned containing the removed items, the contents of the stack in
     * the inventory are reduced by the number of items consumed. Note that this
     * method attempts to consume items into the ouput up to <code>limit</code>,
     * which may consume items from an abitrary number of internal slots.</p>
     *
     * <p>For example, assume an inventory containing 4 slots contains stacks as
     * follows:</p>
     *
     * <blockquote>
     *     <pre>[Stone x10] [Dirt x3] [Arrows x9] [Stone x32]</pre>
     * </blockquote>
     *
     * <p>Calling <code>poll(16)</code> on this inventory will consume <em>Stone
     * </em> from the Inventory (because the first stack contains stone), and
     * will then consume the remaining 6 items from the 4th slot.</p>
     *
     * <p>It is intended that this method is used in conjunction with a query
     * which returns a set of slots containing a specific item type:</p>
     *
     * <blockquote>
     *     <pre>Optional&lt;ItemStack&gt; q = inv.query(ItemTypes.DIRT).poll(1);
     *     </pre>
     * </blockquote>
     *
     * @see #poll
     * @param limit Maximum number of items to consume from the inventory
     * @return Matching {@link ItemStack} guaranteed to have items less than or
     *      equal to the specified <em>limit</em>. 
     */
    Optional<ItemStack> poll(int limit);

    /**
     * Get without removing the first available stack from this Inventory. For
     * the definition of 'available', see {@link #poll}.
     * 
     * @return First available itemstack, or {@link Optional#absent()} if
     *      unavailable or unsupported
     */
    Optional<ItemStack> peek();

    /**
     * Uses the same semantics as {@link #poll(int)} but <b>does not remove the
     * items from the inventory</b>. The {@link ItemStack} returned is thus a
     * new ItemStack containing <b>a copy of</b> the items in inventory. Use
     * this method only if you wish to determine whether a call to
     * {@link #poll(int)} is likely to succeed.
     * 
     * <p>Note that items returned from <code>peek</code> are 'live' items, this
     * means that they are a direct view of the ItemStack stored in the
     * inventory and mutating them will affect the items in the inventory
     * directly</p>
     *
     * @see #peek
     * @param limit Maximum number of items to consume from the inventory
     * @return Matching {@link ItemStack} guaranteed to have items less than or
     *      equal to the specified <em>limit</em>. 
     */
    Optional<ItemStack> peek(int limit);

    /**
     * Try to put an ItemStack into this Inventory. Just like
     * {@link java.util.Queue}, this method returns true if the Inventory
     * accepted the stack and false if not, the size of the supplied stack is
     * reduced by the number of items successfully consumed by the Inventory.
     * 
     * <p>Unlike {@link #set}, this method's general contract does not permit
     * items in the Inventory to be replaced. However trying to insert items
     * that an Inventory cannot accept is not an error condition, the size of
     * the supplied stack will simply not be reduced if no items are consumed by
     * the Inventory.</p>
     * 
     * @param stack A stack of items to attempt to insert into the Inventory,
     *      note that upon successful insertion the supplied ItemStack itself
     *      will be mutated and returned with size reduced by the number of
     *      items successfully consumed by the Inventory 
     * @return true if <em>one or more</em> (up to the total number of items in
     *      the supplied stack) items were consumed. False if no items were
     *      consumed by the target inventory. 
     */
    boolean offer(ItemStack stack);

    /**
     * Forcibly put the supplied stack into this inventory. Overwrites existing
     * objects in the inventory as required to accomodate the entire stack. The
     * entire stack is always consumed.
     * 
     * <p>The general contract of this method is to prioritise insertion of the
     * supplied items over items already in the Inventory. However the Inventory
     * may still reject the supplied items if they are of an unsupported type
     * for the target (for example trying to insert non-fuel items into a fuel
     * slot) or if the number of items is larger than the total capacity of the
     * inventory and not all items from the supplied stack can be consumed.</p>
     * 
     * <p>For {@link Slot}s, the supplied stack is generally consumed and the
     * existing contents ejected (at the discretion of the target Inventory).
     * For multi-slot inventories the insertion order is up to the target
     * inventory to decide, and does not have to match the traversal order of
     * the leaf nodes as supplied by {@link #slots}, although this is
     * generally recommended. Inventories should document their specific
     * insertion logic where the insertion order differs from the traversal
     * order.</p>
     * 
     * <p>Consumers should inspect the returned {@link InventoryOperationResult}
     * and act accordingly. Ejected items should generally be "thrown" into the
     * world or deposited into another Inventory (depending on the operation in
     * question. The supplied stack is not adjusted, any rejected items are
     * returned in the operation result struct.</p>
     * 
     * @param stack the stack to insert into the Inventory, will be mutated by
     *      the number of items successfully consumed
     * @return operation result indicating the success state of the operation
     *      and any items rejected or ejected as a result of the operation
     */
    InventoryOperationResult set(ItemStack stack);

    /**
     * Clears this inventory if it is clearable. 
     */
    void clear();

    /**
     * The number of stacks currently in the Inventory. Either 1 or 0 for
     * {@link Slot}s and always 0 for {@link EmptyInventory}s.
     * 
     * @return the number of stacks in the inventory
     */
    int size();

    /**
     * Returns the number total number of individual <em>items</em> in this
     * inventory.
     * 
     * @return the total number of items in the inventory
     */
    int totalItems();

    /**
     * The maximum number of stacks the Inventory can hold. Always 1 for
     * {@link Slot}s and always 0 for {@link EmptyInventory}s.
     * 
     * @return the number of stacks the inventory can hold
     */
    int capacity();

    /**
     * Returns true if this Inventory contains no children. This does not imply
     * that the Inventory accepts no items, and an Inventory is perfectly at
     * liberty to provide {@link #peek}, {@link #poll}, {@link #offer} and
     * {@link #set} semantics even if it has no internal storage of its own.
     * 
     * @return true if and only if this inventory contains no child inventories
     */
    boolean isEmpty();

    /**
     * Checks for whether the given stack is contained in this Inventory. This
     * is equivalent to calling <code>!inv.query(stack).isEmpty();</code>
     *
     * @param stack The stack to check for
     * @return True if the stack is present in this list
     */
    boolean contains(ItemStack stack);

    /**
     * Checks for whether there is a stack in this Inventory with the given
     * ItemType. This is equivalent to calling <code>!inv.query(stack)
     * .isEmpty();</code>
     *
     * @param type The type to search for
     * @return True if at least one stack in this list has the given type
     */
    boolean contains(ItemType type);

    /**
     * Returns the maximum size of any stack in this Inventory.
     *
     * @return The maximum stack size of this list
     */
    int getMaxStackSize();

    /**
     * Sets the maximum stack size of any stack in this ItemList.
     *
     * @param size The new maximum stack size
     */
    void setMaxStackSize(int size);

    /**
     * Returns all properties matching the supplied type defined in
     * <em>this</em> inventory for the specified (immediate) sub-inventory. If
     * no matching properties are defined an empty collection is returned.
     * 
     * @param child the child inventory to inspect
     * @param property the type of property to query for
     * @param <T> expected type of inventory property, generic to enable easy
     *      pseudo-duck-typing
     * @return collection of matching properties, may be an empty collection if
     *      no properties match the supplied criterion 
     */
    <T extends InventoryProperty<?, ?>> Collection<T> getProperties(Inventory child, Class<T> property);

    /**
     * Gets all properties of the specified type defined directly on this
     * Inventory. For sub-inventories this is effectively the same as
     * <code>inv.getParent().getProperty(inv, property);</code> but for
     * top-level inventories may include properties defined on the inventory
     * directly.
     *
     * @param property the type of property to query for
     * @param <T> expected type of inventory property, generic to enable easy
     *      pseudo-duck-typing
     * @return collection of matching properties, may be an empty collection if
     *      no properties match the supplied criterion 
     */
    <T extends InventoryProperty<?, ?>> Collection<T> getProperties(Class<T> property);

    /**
     * Gets the property with the specified key defined in <em>this</em>
     * inventory for the specified (immediate) sub-inventory.
     * 
     * @param child the child inventory to inspect
     * @param property the type of property to query for
     * @param key Property key to search for
     * @param <T> expected type of inventory property, generic to enable easy
     *      pseudo-duck-typing
     * @return matching properties, may be absent if no property matched the
     *      supplied criteria 
     */
    <T extends InventoryProperty<?, ?>> Optional<T> getProperty(Inventory child, Class<T> property, Object key);

    /**
     * Gets a property with the specified key defined directly on this Inventory
     * if one is defined. For sub-inventories this is effectively the same as
     * <code>inv.getParent().getProperty(inv, property, key);</code> but for
     * top-level inventories may include properties defined on the inventory
     * directly.
     * 
     * @param property the type of property to query for
     * @param key Property key to search for
     * @param <T> expected type of inventory property, generic to enable easy
     *      pseudo-duck-typing
     * @return matching properties, may be absent if no property matched the
     *      supplied criteria 
     */
    <T extends InventoryProperty<?, ?>> Optional<T> getProperty(Class<T> property, Object key);

    /**
     * Query this inventory for inventories matching any of the supplied types.
     * This is effectively an <code>instanceof</code> check against each child
     * inventory. Logical <code>OR</code> is applied between operands.
     * 
     * @param types inventory types (interfaces or classes) to query for
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the query result 
     */
    <T extends Inventory> T query(Class<?>... types);

    /**
     * Query this inventory for inventories containing any of the supplied item
     * types. This query operates directly on {@link Slot} leaf nodes in the
     * inventory and will always return a collection containing only
     * {@link Slot} instances. Logical <code>OR</code> is applied between
     * operands.
     * 
     * @param types item types to query for
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the query result 
     */
    <T extends Inventory> T query(ItemType... types);

    /**
     * Query this inventory for inventories containing any stacks which match
     * the supplied stack operands. This query operates directly on {@link Slot}
     * leaf nodes in the inventory and will always return a collection
     * containing only {@link Slot} instances. Logical <code>OR</code> is
     * applied between operands.
     * 
     * @param types items to query for, the size of the stacks is ignored if the
     *      stack size is set to -1, otherwise the stack sizes must match the
     *      supplied stacks exactly
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the query result 
     */
    <T extends Inventory> T query(ItemStack... types);

    /**
     * Query this inventory for inventories which match any of the supplied
     * properties. The <code>equals</code> method of each property is called on
     * each child inventory which has the supplied property. Logical
     * <code>OR</code> is applied between operands. This method is effectively
     * the same as calling {@link #query} with an
     * {@link org.spongepowered.api.util.Property.Operator} of
     * {@link org.spongepowered.api.util.Property.Operator#EQUAL}.
     * 
     * @param props inventory properties to query for
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the query result 
     */
    <T extends Inventory> T query(InventoryProperty<?, ?>... props);

    /**
     * Query this inventory for inventories matching any of the supplied titles.
     * Logical <code>OR</code> is applied between operands.
     * 
     * @param names the names of the inventories to search for
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the query result 
     */
    <T extends Inventory> T query(Translatable... names);

    /**
     * Query this inventory for inventories matching any of the supplied titles.
     * Logical <code>OR</code> is applied between operands.
     * 
     * @param names the names of the inventories to search for
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the query result 
     */
    <T extends Inventory> T query(String... names);

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
     * 
     * @param args search parameters
     * @param <T> expected inventory type, specified as generic to allow easy
     *      pseudo-duck-typing
     * @return the query result 
     */
    <T extends Inventory> T query(Object... args);
    
}

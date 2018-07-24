/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.event.item.inventory.InteractInventoryEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.property.SlotIndex;
import org.spongepowered.api.item.inventory.query.QueryOperation;
import org.spongepowered.api.item.inventory.transaction.InventoryTransactionResult;
import org.spongepowered.api.item.inventory.type.ViewableInventory;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Base interface for queryable inventories.
 */
public interface Inventory extends Nameable, PropertyHolder {

    /**
     * Creates a new {@link Inventory.Builder} to build an {@link Inventory}.
     *
     * @return The builder
     */
    static Inventory.Builder builder() {
        return Sponge.getRegistry().createBuilder(Inventory.Builder.class);
    }

    /**
     * Gets the parent {@link Inventory} of this {@link Inventory}.
     *
     * @return the parent inventory, returns this inventory if there is no
     *      parent (this is a top-level inventory)
     */
    Inventory parent();

    /**
     * Gets the root {@link Inventory} of this {@link Inventory}.
     * This is equivalent to calling {@link #parent()} until it returns itself.
     *
     * @return the root inventory, returns this inventory if there is no
     *       parent (this is a top-level inventory)
     */
    Inventory root();

    /**
     * Returns a list of all {@link Slot}s (leaf nodes) in this Inventory.
     *
     * @return a list of all Slots (leaf nodes) in this inventory
     */
    List<Slot> slots();

    /**
     * Returns a list of all direct child inventories.
     *
     * @return a list of all direct child inventories.
     */
    List<Inventory> children();

    /**
     * Gets and remove the first non empty stack from this Inventory.
     *
     * <p>If this inventory is empty {@link ItemStack#empty()} is returned</p>
     *
     * @return The first available item stack, or {@link ItemStack#empty()} if unavailable
     */
    ItemStack poll();

    /**
     * Get and remove up to <code>limit</code> items of the type in the first
     * non empty stack in this Inventory from all stacks in this Inventory.
     *
     * <p>If this inventory is empty {@link ItemStack#empty()} is returned
     * otherwise otherwise a new {@link ItemStack} is returned containing
     * the removed items.</p>
     *
     * <p>Note that this method attempts to consume items into the output up
     * to <code>limit</code>, which may consume items from an arbitrary number
     * of internal slots.</p>
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
     *     <pre>ItemStack q = inv.query(ItemTypes.DIRT).poll(1);
     *     </pre>
     * </blockquote>
     *
     * @param limit Maximum number of items to consume from the inventory
     * @return Matching {@link ItemStack} guaranteed to have items less than or
     *      equal to the specified <em>limit</em>.
     */
    ItemStack poll(int limit);

    /**
     * Gets without removing the first non empty stack from this Inventory.
     *
     * @return First non empty itemstack, or {@link ItemStack#empty()} if unavailable
     */
    ItemStack peek();

    /**
     * Gets without removing up to <code>limit</code> items of the type in the first
     * non empty stack in this Inventory from all stacks in this Inventory.
     *
     * @see #peek
     * @param limit Maximum number of items to consume from the inventory
     * @return Matching {@link ItemStack} guaranteed to have items less than or
     *      equal to the specified <em>limit</em>.
     */
    ItemStack peek(int limit);

    /**
     * Try to put an ItemStack into this Inventory. The {@link InventoryTransactionResult}
     * will be a success only when the entire itemstack fits the inventory.
     *
     * <p>The size of the supplied stack is reduced by the number of items
     * successfully consumed by the inventory.</p>
     *
     * <p>Any rejected items are also available in the transaction result.</p>
     *
     * <p>Unlike {@link #set}, this method's general contract does not permit
     * items in the Inventory to be replaced.</p>
     *
     * @param stack A stack of items to attempt to insert into the Inventory,
     *      note that upon successful insertion the supplied ItemStack itself
     *      will be reduced by the number of items successfully consumed by the
     *      Inventory
     * @return A SUCCESS transactionresult if the entire stack was consumed and
     *      FAILURE when the stack was not or partially consumed.
     */
    InventoryTransactionResult offer(ItemStack stack);

    /**
     * Forcibly put the supplied stack into this inventory. Overwrites existing
     * objects in the inventory as required to accommodate the entire stack.
     *
     * <p>The general contract of this method is to prioritise insertion of the
     * supplied items over items already in the Inventory. However the Inventory
     * may still reject the supplied items for example if the number of items is
     * larger than the total capacity of the inventory and not all items from the
     * supplied stack can be consumed.</p>
     *
     * <p>The size of the supplied stack is reduced by the number of items
     * successfully consumed by the inventory.</p>
     *
     * <p>Any rejected items are also available in the transaction result.</p>
     *
     * @param stack The stack to insert into the Inventory, will be reduced by
     *      the number of items successfully consumed
     * @return A SUCCESS transactionresult if the entire stack was consumed and
     *      FAILURE when the stack was not or partially consumed.
     */
    InventoryTransactionResult set(ItemStack stack);

    /**
     * Gets and remove the stack at the supplied index in this Inventory.
     *
     * <p>Returns {@link Optional#empty()} when there is not Slot at {@link SlotIndex}</p>
     *
     * @see Inventory#poll()
     * @param index slot index to query
     * @return matching stacks, as per the semantics of {@link Inventory#poll()}
     */
    Optional<ItemStack> poll(SlotIndex index);

    /**
     * Gets and remove the stack at the supplied index in this Inventory.
     *
     * <p>Returns {@link Optional#empty()} when there is not Slot at {@link SlotIndex}</p>
     *
     * @see Inventory#poll()
     * @param index slot index to query
     * @param limit item limit
     * @return matching stacks, as per the semantics of {@link Inventory#poll()}
     */
    Optional<ItemStack> poll(SlotIndex index, int limit);

    /**
     * Gets without removing the stack at the supplied index in this Inventory.
     *
     * <p>Returns {@link Optional#empty()} when there is not Slot at {@link SlotIndex}</p>
     *
     * @see Inventory#peek()
     * @param index slot index to query
     * @return matching stacks, as per the semantics of {@link Inventory#peek()}
     */
    Optional<ItemStack> peek(SlotIndex index);

    /**
     * Gets without removing the stack at the supplied index in this Inventory.
     *
     * <p>Returns {@link Optional#empty()} when there is not Slot at {@link SlotIndex}</p>
     *
     * @see Inventory#peek()
     * @param index slot index to query
     * @param limit item limit
     * @return matching stacks, as per the semantics of {@link Inventory#peek()}
     */
    Optional<ItemStack> peek(SlotIndex index, int limit);

    /**
     * Sets the item in the specified slot.
     *
     * <p>Always returns a {@link InventoryTransactionResult.Type#FAILURE} when
     * there is not Slot at {@link SlotIndex}</p>
     *
     * @see Inventory#set(ItemStack)
     * @param index Slot index to set
     * @param stack Stack to insert
     * @return matching stacks, as per the semantics of {@link Inventory#set}
     */
    InventoryTransactionResult set(SlotIndex index, ItemStack stack);

    /**
     * Gets the {@link Slot} at the specified position.
     *
     * @param index Slot index to retrieve
     * @return slot at the specified position, or {@link Optional#empty()} if
     *      no matching slot
     */
    Optional<Slot> getSlot(SlotIndex index);

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
     * Returns true if this Inventory contains children. If false, this does not
     * imply that the Inventory accepts no items, and an Inventory is perfectly
     * at liberty to provide {@link #peek}, {@link #poll}, {@link #offer} and
     * {@link #set} semantics even if it has no internal storage of its own.
     *
     * @return true if and only if this inventory contains child inventories
     */
    boolean hasChildren();

    /**
     * Checks whether the stacks quantity or more of given stack is
     * contained in this Inventory. This is equivalent to calling
     * <code>!inv.query(stack).hasChildren();</code> To check if an
     * inventory contains any amount use {@link #containsAny(ItemStack)}.
     *
     * @param stack The stack to check for
     * @return True if there are at least the given stack's amount of items
     *      present in this inventory.
     */
    boolean contains(ItemStack stack);

    /**
     * Checks for whether there is a stack in this Inventory with the given
     * ItemType. This is equivalent to calling <code>!inv.query(stack)
     * .hasChildren();</code>
     *
     * @param type The type to search for
     * @return True if at least one stack in this list has the given type
     */
    boolean contains(ItemType type);

    /**
     * Checks whether the given stack is contained in this Inventory.
     * The stack size is ignored. Note this will return true if any amount
     * of the supplied stack is found. To check if an inventory contains at
     * least an amount use {@link #contains(ItemStack)}.
     *
     * @param stack The stack to check for
     * @return True if the stack is present in this inventory
     */
    boolean containsAny(ItemStack stack);

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
     * Gets the property with the default key defined in <em>this</em>
     * inventory for the specified (immediate) sub-inventory.
     *
     * @param child the child inventory to inspect
     * @param property the type of property to query for
     * @param <T> expected type of inventory property, generic to enable easy
     *      pseudo-duck-typing
     * @return matching properties, may be absent if no property matched the
     *      supplied criteria
     */
    <T extends InventoryProperty<?, ?>> Optional<T> getProperty(Inventory child, Class<T> property);

    /**
     * Gets a property with the default key defined directly on this Inventory
     * if one is defined. For sub-inventories this is effectively the same as
     * <code>inv.getParent().getProperty(inv, property);</code> but for
     * top-level inventories may include properties defined on the inventory
     * directly.
     *
     * @param property the type of property to query for
     * @param <T> expected type of inventory property, generic to enable easy
     *      pseudo-duck-typing
     * @return matching properties, may be absent if no property matched the
     *      supplied criteria
     */
    @Override <T extends Property<?, ?>> Optional<T> getProperty(Class<T> property);

    /**
     * Query this inventory for inventories matching any of the supplied
     * queries. Logical <code>OR</code> is applied between operands.
     *
     * @param operations queries to check against
     * @return the query result
     */
    Inventory query(QueryOperation<?>... operations);

    /**
     * Query this inventory for a single inventory matching the supplied inventory type.
     * This query will return {@link Optional#empty()} when the query does not return a
     * single inventory matching the supplied inventory type.
     *
     * @param inventoryType The inventory type to query for
     * @param <T> The Type of inventory
     * @return the query result
     */
    <T extends Inventory> Optional<T> query(Class<T> inventoryType);

    /**
     * Returns the {@link PluginContainer} who built this inventory.
     *
     * @return The container
     */
    PluginContainer getPlugin();

    /**
     * Creates an {@link InventoryArchetype} based on this {@link Inventory}.
     *
     * @return The inventory archetype
     */
    InventoryArchetype getArchetype();

    /**
     * Intersects the slots of both inventories.
     * The resulting inventory will only contain slots
     * that are present in both inventories.
     *
     * @param inventory the other inventory
     * @return an inventory wrapping all slots that are present in
     *     both inventories
     */
    Inventory intersect(Inventory inventory);

    /**
     * Constructs a union of the slots in both inventories.
     *
     * <p>The resulting inventory will contain all slots from
     * both inventories.</p>
     *
     * <p>The slots of this inventory are ordered before the slots of the
     * given inventory.</p>
     *
     * <p>If the same slot is contained in both inventories the duplicate
     * in the second one is removed.</p>
     *
     * @param inventory the other inventory
     * @return an inventory wrapping all slots of both inventories.
     */
    Inventory union(Inventory inventory);

    /**
     * Returns true if the given inventory is a descendant of this one.
     * This method will check for deeply nested inventories but
     * will only return true if the entire inventory structure is contained.
     * This means that e.g. for a query result of multiple slots the
     * inventory will not return true even if all slots are contained.
     * If you want to check if all slots of an inventory are contained in
     * another one use {@link #intersect(Inventory)} instead.
     * <p>
     * You can use this if you want to check if a single Slot is contained
     * in an inventory or an entire row is contained in a Grid.
     * </p>
     *
     * @param inventory the other inventory
     * @return whether the given inventory is contained in this one.
     */
    boolean containsInventory(Inventory inventory);

    /**
     * Transforms this inventory using the given transformation.
     *
     * @param transformation The transformation
     * @return The transformed Inventory
     */
    default Inventory transform(InventoryTransformation transformation) {
        return transformation.transform(this);
    }

    /**
     * Returns this inventory as a viewable inventory if possible.
     *
     * <p>Not all inventories are viewable (e.g. a custom inventory of size 5x5)</p>
     *
     * @return This inventory as an viewable inventory if possible.
     */
    Optional<ViewableInventory> asViewable();

    /**
     * A Builder for Inventories based on {@link InventoryArchetype}s.
     */
    interface Builder extends ResettableBuilder<Inventory, Builder> {

        /**
         * Sets the base {@link InventoryArchetype} for the Inventory.
         *
         * @param archetype The InventoryArchetype
         * @return Fluent pattern
         */
        Builder of(InventoryArchetype archetype);

        /**
         * Sets an {@link InventoryProperty}.
         *
         * @param name The name
         * @param property The property
         * @return Fluent pattern
         */
        // TODO only properties declared in the archetype are allowed? IllegalArgumentException?
        Builder property(String name, InventoryProperty<?, ?> property);

        /**
         * Sets an {@link InventoryProperty} with its default key.
         *
         * @param property The property
         * @return Fluent pattern
         */
        Builder property(InventoryProperty<?, ?> property);

        /**
         * Sets the {@link Carrier} that carries the Inventory.
         *
         * @param carrier The Carrier
         * @return Fluent pattern
         */
        Builder withCarrier(Carrier carrier);

        /**
         * Registers a listener for given Event type
         *
         * @param type The type
         * @param listener The listener
         * @return Fluent pattern
         */
        <E extends InteractInventoryEvent> Builder listener(Class<E> type, Consumer<E> listener);

        /**
         * Sets the InventoryArchetype and Properties according to the
         * {@link Carrier}s Inventory.
         *
         * @param carrier The Carrier
         * @return Fluent pattern
         */
        Builder forCarrier(Carrier carrier);

        /**
         * Sets the InventoryArchetype and Properties for a default Inventory of
         * given {@link Carrier}.
         *
         * @param carrier The Carrier class
         * @return Fluent pattern
         */
        Builder forCarrier(Class<? extends Carrier> carrier);

        /**
         * Builds the {@link Inventory}.
         *
         * @param plugin The plugin building this inventory
         * @return The new Inventory instance
         */
        Inventory build(Object plugin);

    }
}

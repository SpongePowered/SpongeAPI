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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.KeyValueMatcher;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.query.Query;
import org.spongepowered.api.item.inventory.query.QueryType;
import org.spongepowered.api.item.inventory.query.QueryTypes;
import org.spongepowered.api.item.inventory.transaction.InventoryTransactionResult;
import org.spongepowered.api.item.inventory.type.ViewableInventory;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Base interface for queryable inventories.
 */
public interface Inventory extends DataHolder.Mutable {

    /**
     * Creates a new {@link Inventory.Builder} to build a basic {@link Inventory}.
     * <p>Inventories created by this builder cannot be opened.</p>
     * <p>If you want to show the inventory to a {@link Player} use {@link ViewableInventory#builder()}</p>
     *
     * @return The builder
     */
    static Inventory.Builder builder() {
        return Sponge.getRegistry().createBuilder(Inventory.Builder.class);
    }

    /**
     * Gets the parent {@link Inventory} of this {@link Inventory}.
     *
     * @return the parent inventory, returns this inventory if there is no parent (this is a top-level inventory)
     */
    Inventory parent();

    /**
     * Gets the root {@link Inventory} of this {@link Inventory}.
     * This is equivalent to calling {@link #parent()} until it returns itself.
     *
     * @return the root inventory, returns this inventory if there is no parent (this is a top-level inventory)
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
     * Returns true if this Inventory contains children.
     *
     * @return true if this inventory contains child inventories
     */
    boolean hasChildren();

    /**
     * Gets and removes the first non empty stack from this Inventory.
     *
     * @return A SUCCESS transaction-result if an item was removed.
     *           FAILURE when nothing was removed.
     */
    InventoryTransactionResult.Poll poll();

    /**
     * Gets and removes up to {@code limit} items of the type in the first
     * non empty stack in this Inventory from all stacks in this Inventory.
     *
     * <p>Note that this method attempts to consume items up to {@code limit},
     * which may consume items from an arbitrary number of slots.</p>
     *
     * <p>For example, assume an inventory containing 4 slots contains stacks as follows:</p>
     *
     * <blockquote>
     *     <pre>[Stone x10] [Dirt x3] [Arrows x9] [Stone x32]</pre>
     * </blockquote>
     *
     * <p>Calling <code>poll(16)</code> on this inventory will consume <em>Stone</em>
     * from the Inventory (because the first stack contains stone), and
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
     * @param limit Maximum quantity of items to consume from the inventory
     *
     * @return A SUCCESS transaction-result only if all {@code limit} items were removed else FAILURE.
     */
    InventoryTransactionResult.Poll poll(int limit);

    /**
     * Returns a copy of the first non empty stack from this Inventory.
     *
     * @return First non empty ItemStack, or {@link ItemStack#empty()} if unavailable
     */
    ItemStack peek();

    /**
     * Adds one or more ItemStacks to this inventory.
     *
     * @param stacks The stacks to add to this inventory.
     *
     * @return A SUCCESS transaction-result if all stacks were added and
     *           FAILURE when at least one stack was not or only partially added to the inventory.
     */
    InventoryTransactionResult offer(ItemStack... stacks);

    /**
     * Returns true if the entire stack can fit in this inventory.
     *
     * <p>If this returns {@code true} {@link #offer(ItemStack...)} should always succeed.</p>
     *
     * @param stack The stack of items to check if it can fit in this inventory.
     *
     * @return true if the entire stack can fit in this inventory.
     */
    boolean canFit(ItemStack stack);

    /**
     * Gets and removes the stack at the supplied index in this Inventory.
     *
     * @see Inventory#poll()
     *
     * @param index The slot index
     *
     * @return SUCCESS transaction-result if an item was removed.
     *         FAILURE when nothing was removed.
     */
    InventoryTransactionResult.Poll pollFrom(int index);

    /**
     * Gets and removes the stack at the supplied index in this Inventory.
     *
     * @see Inventory#poll()
     *
     * @param index The slot index
     * @param limit The item limit
     *
     * @return A SUCCESS transaction-result only if all {@code limit} items were removed else FAILURE.
     */
    InventoryTransactionResult.Poll pollFrom(int index, int limit);

    /**
     * Returns a copy of the stack at given slot index.
     *
     * <p>Returns {@link Optional#empty()} when there is no Slot at given index</p>
     *
     * @param index The slot index
     *
     * @return a copy of the stack at given slot index. {@link Optional#empty()} if there is no matching slot.
     */
    Optional<ItemStack> peekAt(int index);

    /**
     * Adds an ItemStack to the slot at given index.
     * Returns a {@link InventoryTransactionResult.Type#SUCCESS} only if the entire {@link ItemStack} fits the slot.
     *
     * @param index The slot index
     * @param stack The stack to add to this inventory.
     *
     * @return A SUCCESS transaction-result if the entire stack was added and
     *           FAILURE when the stack was not or only partially added to the inventory.
     */
    InventoryTransactionResult offer(int index, ItemStack stack);

    /**
     * Adds the ItemStack to the slot at given index overwriting the existing item.
     *
     * <p>Always returns a {@link org.spongepowered.api.item.inventory.transaction.InventoryTransactionResult.Type#FAILURE} when
     * there is no Slot at given index</p>
     * <p>Stacks bigger than the max stack size will be partially rejected.</p>
     *
     * @param index The slot index
     * @param stack The stack to add to the slot.
     *
     * @return A SUCCESS transaction-result if the entire stack was added and
     *           FAILURE when the stack was not or only partially added to the inventory.
     */
    InventoryTransactionResult set(int index, ItemStack stack);

    /**
     * Gets the {@link Slot} at the given index.
     *
     * @param index The slot index
     * @return slot at the specified position, or {@link Optional#empty()} if no matching slot
     */
    Optional<Slot> getSlot(int index);

    /**
     * Clears this inventory if it is clearable.
     */
    void clear();

    /**
     * The number of empty slots in this inventory. Either 1 or 0 for {@link Slot}s and always 0 for {@link EmptyInventory}s.
     *
     * @return the number of empty slots in this inventory
     */
    int freeCapacity();

    /**
     * Returns the total quantity of <em>items</em> in this inventory.
     * <p>This equivalent to summing {@link ItemStack#getQuantity()} for all slots.</p>
     *
     * @return the total quantity of items in this inventory
     */
    int totalQuantity();

    /**
     * The number of slots in this inventory. Always 1 for {@link Slot}s and always 0 for {@link EmptyInventory}s.
     *
     * @return the number of slots in this inventory
     */
    int capacity();

    /**
     * Checks whether the stacks quantity or more of given stack is contained in this Inventory.
     * To check if an inventory contains any amount use {@link #containsAny(ItemStack)}.
     *
     * @param stack The stack to check for
     *
     * @return True if there are at least the given stack's amount of items present in this inventory.
     */
    boolean contains(ItemStack stack);

    /**
     * Checks whether the given ItemType is contained in this Inventory
     *
     * @param type The type to search for
     *
     * @return True if at least one stack in this list has the given type
     */
    boolean contains(ItemType type);

    /**
     * Checks whether the given stack is contained in this Inventory.
     * The stack size is ignored.
     *
     * <p>Note this will return true if any amount of the supplied stack is found.
     * To check if an inventory contains at least a given quantity use {@link #contains(ItemStack)}.</p>
     *
     * @param stack The stack to check for
     *
     * @return True if the stack is present in this inventory
     */
    boolean containsAny(ItemStack stack);

    // TODO remove from API? do we need to get a property relative to another parent in API?
    /**
     * Gets the key defined in <em>this</em>
     * inventory for the specified (immediate) sub-inventory.
     *
     * @param child The child inventory to inspect
     * @param key The key to retrieve the value for
     * @param <V> The key value type
     *
     * @return The key value, if available
     */
    <V> Optional<V> get(Inventory child, Key<? extends Value<V>> key);

    /**
     * Gets a key defined directly on this Inventory if one is defined.
     * For sub-inventories this is effectively the same as
     * {@code inv.getParent().getProperty(inv, property);} but for
     * top-level inventories may include properties defined on the inventory
     * directly.
     *
     * @param key The key to retrieve the value for
     * @param <V> The key value type
     *
     * @return The key value, if available
     */
    @Override
    <V> Optional<V> get(Key<? extends Value<V>> key);

    /**
     * Query this inventory with given {@link Query}
     *
     * @param query The query
     *
     * @return The queried inventory
     */
    Inventory query(Query query);

    /**
     * Query this inventory for inventories matching
     * the supplied {@link KeyValueMatcher}.
     *
     * @param matcher The key value matcher
     * @return The query result
     */
    default Inventory query(KeyValueMatcher<?> matcher) {
        return this.query(QueryTypes.KEY_VALUE.of(matcher));
    }

    /**
     * Query this inventory for a single inventory matching the supplied inventory type.
     * This query will return {@link Optional#empty()} when the query does not return a
     * single inventory matching the supplied inventory type.
     *
     * @param inventoryType The inventory type to query for
     * @param <T> The Type of inventory
     *
     * @return the query result
     */
    <T extends Inventory> Optional<T> query(Class<T> inventoryType);

    /**
     * Intersects the slots of both inventories.
     * The resulting inventory will only contain slots
     * that are present in both inventories.
     *
     * @param inventory the other inventory
     *
     * @return an inventory wrapping all slots that are present in both inventories
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
     *
     * @return an inventory wrapping all slots of both inventories.
     */
    Inventory union(Inventory inventory);

    // TODO does this actually work? When lenses are reused they cannot be used for this
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
     *
     * @return whether the given inventory is contained in this one.
     */
    boolean containsInventory(Inventory inventory);

    /**
     * Returns true if the given inventory is a direct child of this one.
     *
     * @param child the child inventory to check for.
     *
     * @return whether the given inventory is a direct child of this one.
     */
    boolean containsChild(Inventory child);

    /**
     * Returns this inventory as a viewable inventory if possible.
     *
     * <p>Not all inventories are viewable (e.g. a custom inventory of size 5x5)</p>
     *
     * @return This inventory as an viewable inventory if possible.
     */
    Optional<ViewableInventory> asViewable();

    /**
     * A builder for free-form Inventories.
     * <p>To build inventories that can be viewed by a player use {@link ViewableInventory.Builder}</p>
     */
    interface Builder extends ResettableBuilder<Inventory, Inventory.Builder> {

        /**
         * Adds one or more slots.
         *
         * @param amount the amount of slots to add
         *
         * @return the building step
         */
        BuildingStep slots(int amount);

        /**
         * Adds a grid of slots.
         *
         * @param sizeX the horizontal size
         * @param sizeY the vertical size
         *
         * @return the building step
         */
        BuildingStep grid(int sizeX, int sizeY);

        /**
         * Adds an existing inventory.
         *
         * @param inventory the inventory to add.
         *
         * @return the building step
         */
        BuildingStep inventory(Inventory inventory);

        /**
         * The building step. The inventory structure can be completed at any time.
         */
        interface BuildingStep extends Builder {

            /**
             * Completes the inventory structure.
             *
             * @return the end step
             */
            EndStep completeStructure();
        }

        /**
         * The end Step. You can set an identifier and/or carrier for the inventory before building it.
         */
        interface EndStep {

            /**
             * Sets a unique identifier. Can be retrieved later using. {@link Inventory#get(Key)} with {@link InventoryKeys#UNIQUE_ID}
             *
             * @param uuid the UUID.
             *
             * @return this step
             */
            EndStep identity(UUID uuid);

            /**
             * Sets a carrier.
             *
             * @param carrier the carrier.
             *
             * @return this step
             */
            EndStep carrier(Carrier carrier);

            /**
             * Builds the inventory.
             *
             * @return the new inventory.
             */
            Inventory build();
        }
    }

}

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
package org.spongepowered.api.data.type;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.tag.Tag;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * A tool rule that applied via {@link org.spongepowered.api.data.Keys#TOOL_RULES} to an {@link org.spongepowered.api.item.inventory.ItemStack}
 * determines what {@link BlockType block types} can be mined at what speed and whether they drop items.
 */
public interface ToolRule {


    static ToolRule minesAndDrops(List<BlockType> blocks, double speed) {
        return ToolRule.factory().minesAndDrops(blocks, speed);
    }

    static ToolRule minesAndDrops(Tag<BlockType> blockTypeTag, double speed) {
        return ToolRule.factory().minesAndDrops(blockTypeTag, speed);
    }

    static ToolRule deniesDrops(List<BlockType> blocks) {
        return ToolRule.factory().deniesDrops(blocks);
    }

    static ToolRule deniesDrops(Tag<BlockType> blockTypeTag) {
        return ToolRule.factory().deniesDrops(blockTypeTag);
    }

    static ToolRule overrideSpeed(List<BlockType> blocks, double speed) {
        return ToolRule.factory().overrideSpeed(blocks, speed);
    }

    static ToolRule overrideSpeed(Tag<BlockType> blockTypeTag, double speed) {
        return ToolRule.factory().overrideSpeed(blockTypeTag, speed);
    }

    static ToolRule forBlocks(List<BlockType> blocks, @Nullable Double speed, @Nullable Boolean drops) {
        return ToolRule.factory().forBlocks(blocks, speed, drops);
    }

    static ToolRule forTag(Tag<BlockType> blockTypeTag, @Nullable Double speed, @Nullable Boolean drops) {
        return ToolRule.factory().forTag(blockTypeTag, speed, drops);
    }

    /**
     * Returns the {@link BlockType block types} this rule applies to.
     *
     * @return the affected blocks
     */
    Set<BlockType> blocks();

    /**
     * Returns the speed override.
     * <p>If present overrides the default {@link org.spongepowered.api.data.Keys#EFFICIENCY mining speed}.</p>
     *
     * @return the speed override
     */
    Optional<Double> speed();

    /**
     * Returns the drops override.
     * <p>If present determines whether a block mined with this rule drops its item</p>
     *
     * @return the drops override
     */
    Optional<Boolean> drops();

    private static Factory factory() {
        return Sponge.game().factoryProvider().provide(Factory.class);
    }

    interface Factory {

        /**
         * Generates a rule for mining and dropping given blocks at given speed.
         *
         * @param blocks the blocks
         * @param speed  the speed
         * @return the generated rule
         */
        ToolRule minesAndDrops(List<BlockType> blocks, double speed);

        /**
         * Generates a rule for mining and dropping given block type tag at given speed.
         *
         * @param blockTypeTag the block type tag
         * @param speed the speed
         *
         * @return the generated rule
         */
        ToolRule minesAndDrops(Tag<BlockType> blockTypeTag, double speed);

        /**
         * Generates a rule for preventing drops for given blocks.
         *
         * @param blocks the blocks
         *
         * @return the generated rule
         */
        ToolRule deniesDrops(List<BlockType> blocks);

        /**
         * Generates a rule for preventing drops for given block type tag.
         *
         * @param blockTypeTag the block type tag
         *
         * @return the generated rule
         */
        ToolRule deniesDrops(Tag<BlockType> blockTypeTag);

        /**
         * Generates a rule overriding mining speed drops for given blocks.
         *
         * @param blocks the blocks
         * @param speed the speed
         *
         * @return the generated rule
         */
        ToolRule overrideSpeed(List<BlockType> blocks, double speed);

        /**
         * Generates a rule overriding mining speed drops for given block type tag.
         *
         * @param blockTypeTag the block type tag
         * @param speed the speed
         *
         * @return the generated rule
         */
        ToolRule overrideSpeed(Tag<BlockType> blockTypeTag, double speed);

        /**
         * Generates a rule for blocks. Optionally overriding speed and/or drops.
         *
         * @param blocks the blocks
         * @param speed the optional override speed
         * @param drops the optional drops override
         *
         * @return the generated rule
         */
        ToolRule forBlocks(List<BlockType> blocks, @Nullable Double speed, @Nullable Boolean drops);

        /**
         * Generates a rule for a block type tag. Optionally overriding speed and/or drops.
         *
         * @param blockTypeTag the block type tag
         * @param speed the optional override speed
         * @param drops the optional drops override
         *
         * @return the generated rule
         */
        ToolRule forTag(Tag<BlockType> blockTypeTag, @Nullable Double speed, @Nullable Boolean drops);
    }
}

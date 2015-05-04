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
package org.spongepowered.api.data;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import javax.annotation.Nullable;
import java.util.Arrays;

/**
 * Represents an integer experience value in the context of an experience scale.
 */
public class Exp {

    /**
     * The scale of experience, or the experience required to level up.
     *
     * <p>This is defined as a function from integers to integers.
     * The input is the level number,
     * and the output is the number of experience points required to get that level.</p>
     *
     * <p>The level scale function should be defined on [1, &#8734;), and should return non-negative integers.
     * However, for most use cases the function should work with an arbitrarily high upper bound,
     * like 1000 levels.
     * The experience required to reach level "zero" is always assumed to be zero.</p>
     */
    private final Function<Integer, Integer> levelScale;

    /**
     * The total experience as an integer, as measured from 0 experience (no XP orbs collected).
     */
    private final int totalExp;

    /**
     * The current experience level.
     *
     * <p>This is computed based on the level scale and total experience.</p>
     */
    private final int level;

    /**
     * The experience gained since the last level.
     *
     * <p>This is computed based on the level scale and total experience.</p>
     */
    private final int expSinceLevel;

    /**
     * The experience needed to get to the next level.
     *
     * <p>This is computed based on the level scale and total experience.</p>
     */
    private final int expToNextLevel;

    public Exp(int totalExp, Function<Integer, Integer> levelScale) {
        this.totalExp = totalExp;
        this.levelScale = levelScale;

        int level = 0;
        int levelReq;

        while (true) {
            levelReq = Preconditions.checkNotNull(levelScale.apply(level + 1));
            if (this.totalExp < levelReq) {
                break;
            }
            level++;
        }

        this.level = level;
        this.expSinceLevel = this.totalExp - levelScale.apply(level);
        this.expToNextLevel = levelReq - this.totalExp;
    }

    public Exp(int totalExp, Iterable<Integer> levelScale) {
        this(totalExp, new IndexingFunction(levelScale));
    }

    public Exp(int totalExp, Integer... levelScale) {
        this(totalExp, new IndexingFunction(levelScale));
    }

    public int getTotalExp() {
        return totalExp;
    }

    public int getLevel() {
        return level;
    }

    public int getExpSinceLevel() {
        return expSinceLevel;
    }

    public int getExpToNextLevel() {
        return expToNextLevel;
    }

    public Exp withExp(int newTotalExp) {
        return new Exp(newTotalExp, this.levelScale);
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        if (!(obj instanceof Exp)) {
            return false;
        }

        Exp that = (Exp) obj;
        return this.totalExp == that.totalExp
                && this.levelScale.equals(that.levelScale);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.totalExp, this.level, this.levelScale);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("totalExp", totalExp)
                .add("curLevel", level)
                .add("levelScale", levelScale)
                .toString();
    }

    /**
     * Represents a level scale function created from indexing a collection.
     *
     * <p>his is essentially a lookup function into a collection, except indices are added by one
     * in order to preserve the {@link Exp#levelScale} guarantees.</p>
     */
    public static class IndexingFunction implements Function<Integer, Integer> {

        /**
         * The collection backing this indexing function.
         */
        private final ImmutableList<Integer> list;

        /**
         * Constructs an indexing function from an iterable.
         *
         * <p>The iterable is copied into an immutable list to ensure that no changes can
         * happen.</p>
         *
         * @param iter The iterable to construct an indexing function from
         */
        public IndexingFunction(Iterable<Integer> iter) {
            this.list = ImmutableList.copyOf(iter);
        }

        /**
         * Constructs an indexing function from an array.
         *
         * <p>The array is copied into an immutable list to ensure that no changes can
         * happen.</p>
         *
         * @param array The array to construct an indexing function from
         */
        public IndexingFunction(Integer... array) {
            this(Arrays.asList(array));
        }

        @Nullable
        @Override
        public Integer apply(@Nullable Integer input) {
            Preconditions.checkNotNull(input, "index cannot be null");
            return list.get(input - 1);
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            if (super.equals(obj)) {
                return true;
            }

            if (!(obj instanceof IndexingFunction)) {
                return false;
            }

            IndexingFunction that = (IndexingFunction) obj;
            return this.list.equals(that.list);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.list);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("list", list)
                    .toString();
        }

    }

}

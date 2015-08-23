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
package org.spongepowered.api.block;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.spongepowered.api.data.DataQuery.of;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;

import javax.annotation.Nullable;

/**
 *
 */
public final class BlockTransaction implements DataSerializable {

    private final BlockSnapshot original;
    private final BlockSnapshot defaultReplacement;
    @Nullable private BlockSnapshot customReplacement;
    private boolean isValid = true;

    public BlockTransaction(BlockSnapshot original, BlockSnapshot defaultReplacement) {
        this(original, defaultReplacement, null);
    }

    public BlockTransaction(BlockSnapshot original, BlockSnapshot defaultReplacement, @Nullable BlockSnapshot customReplacement) {
        this.original = checkNotNull(original, "The original block state cannot be null!");
        this.defaultReplacement = checkNotNull(defaultReplacement, "The original default replacement block state cannot be null!");
        this.customReplacement = customReplacement;
    }

    public BlockSnapshot getOriginal() {
        return this.original;
    }

    public BlockSnapshot getDefaultReplacement() {
        return this.defaultReplacement;
    }

    public Optional<BlockSnapshot> getCustomReplacement() {
        return Optional.fromNullable(this.customReplacement);
    }

    public BlockTransaction setCustomReplacement(@Nullable BlockSnapshot customReplacement) {
        this.customReplacement = customReplacement;
        return this;
    }

    public BlockSnapshot getFinalReplacement() {
        if (this.customReplacement == null) {
            return this.defaultReplacement;
        } else {
            return this.customReplacement;
        }
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public DataContainer toContainer() {
        final DataContainer container = new MemoryDataContainer()
            .set(of("Location"), this.original.getLocation().get())
            .set(of("Original"), this.original)
            .set(of("DefaultReplacement"), this.defaultReplacement)
            .set(of("FinalReplacement"), getFinalReplacement())
            .set(of("Valid"), this.isValid);
        if (this.customReplacement != null) {
            container.set(of("CustomReplacement"), this.customReplacement);
        }
        return container;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.original,
                                this.defaultReplacement,
                                this.customReplacement);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final BlockTransaction other = (BlockTransaction) obj;
        return Objects.equal(this.original, other.original)
               && Objects.equal(this.defaultReplacement, other.defaultReplacement)
               && Objects.equal(this.customReplacement, other.customReplacement)
               && Objects.equal(this.isValid, other.isValid);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("original", this.original)
            .add("defaultReplacement", this.defaultReplacement)
            .add("customReplacement", this.customReplacement)
            .add("isValid", this.isValid)
            .toString();
    }
}

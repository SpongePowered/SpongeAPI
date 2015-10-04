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
import java.util.Optional;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.world.Location;

import javax.annotation.Nullable;

/**
 * Represents a "transaction" of a {@link BlockSnapshot} at a specific
 * {@link Location} being changed to a "replacement" {@link BlockSnapshot}.
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

    /**
     * Gets the original {@link BlockSnapshot} that is being replaced by
     * either the {@link #getDefaultReplacement()} or
     * {@link #getCustomReplacement()}, depending on whether a custom
     * replacement is provided.
     *
     * @return The original block snapshot to be replaced
     */
    public BlockSnapshot getOriginal() {
        return this.original;
    }

    /**
     * Gets the default "suggested" replacement {@link BlockSnapshot} to
     * replace the {@link #getOriginal()} {@linkplain BlockSnapshot}.
     *
     * @return The suggested or default replacement
     */
    public BlockSnapshot getDefaultReplacement() {
        return this.defaultReplacement;
    }

    /**
     * Gets the plugin/mod declared custom replacement {@link BlockSnapshot}.
     * If one is not provided, {@link Optional#empty()} is returned.
     *
     * @return The custom declared replacement, if available
     */
    public Optional<BlockSnapshot> getCustomReplacement() {
        return Optional.ofNullable(this.customReplacement);
    }

    /**
     * Sets the {@link BlockSnapshot} to customarily replace the
     * {@link #getOriginal()} block snapshot. If set to <code>null</code>, the
     * default {@link #getDefaultReplacement()} is used.
     *
     * @param customReplacement The custom replacement, or null
     * @return This block transaction
     */
    public BlockTransaction setCustomReplacement(@Nullable BlockSnapshot customReplacement) {
        this.customReplacement = customReplacement;
        return this;
    }

    /**
     * Gets the final {@link BlockSnapshot} to replace the original snapshot.
     *
     * @return The final snapshot to replace the original
     */
    public BlockSnapshot getFinalReplacement() {
        if (this.customReplacement == null) {
            return this.defaultReplacement;
        } else {
            return this.customReplacement;
        }
    }

    /**
     * Gets whether this transaction is "valid" or not. If <code>false</code>
     * is returned, the replacement will not take place.
     *
     * @return True if this transaction will go through
     */
    public boolean isValid() {
        return this.isValid;
    }

    /**
     * Sets whether this transaction will in fact replace the original
     * {@link BlockSnapshot} with the {@link #getFinalReplacement()}. If
     * set to <code>false</code>, the transaction will be filtered out and
     * no replacement takes place.
     *
     * @param isValid Whether this transaction is to take place or not
     */
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

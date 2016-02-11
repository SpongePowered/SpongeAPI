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

package org.spongepowered.api.text.transformer;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

import java.util.Optional;
import java.util.function.Function;

/**
 * This {@link Transformer} will always return the context value for a fixed
 * key. This class is required for serialization purposes.
 */
public final class ValueForKeyTransformer<T> implements Transformer<T> {

    private final String key;

    ValueForKeyTransformer(String key) {
        checkArgument(!checkNotNull(key, "key").isEmpty(), "key cannot be empty");
        this.key = key;
    }

    /**
     * Gets the key that is used to get a result from the input context. This
     * method is required for serialization purposes.
     *
     * @return The key used to get the data
     */
    public String getKey() {
        return this.key;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<T> transform(Function<String, ?> context) {
        return Optional.ofNullable((T) context.apply(this.key));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ValueForKeyTransformer<?> that = (ValueForKeyTransformer<?>) obj;
        return this.key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("key", this.key)
                .toString();
    }

}

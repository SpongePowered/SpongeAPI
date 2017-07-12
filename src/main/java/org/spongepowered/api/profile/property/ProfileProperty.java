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
package org.spongepowered.api.profile.property;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.profile.GameProfile;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents a property in a {@link GameProfile}'s profile property map.
 *
 * <p>This interface should not be implemented.</p>
 *
 * @see #of(String, String)
 * @see #of(String, String, String)
 */
public interface ProfileProperty {

    /**
     * Creates a new property.
     *
     * @param name The name for the property
     * @param value The value of the property
     * @return The new property
     */
    static ProfileProperty of(String name, String value) {
        return of(name, value, null);
    }

    /**
     * Creates a new signed property.
     *
     * <p>Depending on the property name, if the signature is provided it must
     * originate from Mojang.</p>
     *
     * @param name The name for the property
     * @param value The value of the property
     * @param signature The signature of the property
     * @return The new property
     */
    static ProfileProperty of(String name, String value, @Nullable String signature) {
        return Sponge.getServer().getGameProfileManager().createProfileProperty(name, value, signature);
    }

    /**
     * Gets the name of this property.
     *
     * @return The name
     */
    String getName();

    /**
     * Gets the value of this property.
     *
     * @return The value
     */
    String getValue();

    /**
     * Gets the signature of this property.
     *
     * <p>Depending on the property name, if the signature is provided it must
     * originate from Mojang.</p>
     *
     * @return The signature, or {@link Optional#empty()} if not present
     */
    Optional<String> getSignature();

    /**
     * Tests if this property has a signature.
     *
     * @return Whether this property has a signature
     */
    default boolean hasSignature() {
        return this.getSignature().isPresent();
    }

}

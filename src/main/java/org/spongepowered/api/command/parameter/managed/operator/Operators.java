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
package org.spongepowered.api.command.parameter.managed.operator;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryTypes;

public final class Operators {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Represents the addition operation, +=
     */
    public static final DefaultedRegistryReference<Operator.Simple> ADDITION = Operators.key(ResourceKey.sponge("addition"));

    /**
     * Represents the assignment operation, =
     */
    public static final DefaultedRegistryReference<Operator> ASSIGN = Operators.key(ResourceKey.sponge("assign"));

    /**
     * Represents the division operation, /=
     */
    public static final DefaultedRegistryReference<Operator.Simple> DIVISION = Operators.key(ResourceKey.sponge("division"));

    /**
     * Represents the max operation, &gt;
     */
    public static final DefaultedRegistryReference<Operator.Simple> MAX = Operators.key(ResourceKey.sponge("max"));

    /**
     * Represents the min operation, &lt;
     */
    public static final DefaultedRegistryReference<Operator.Simple> MIN = Operators.key(ResourceKey.sponge("min"));

    /**
     * Represents the modulus operation, %=
     */
    public static final DefaultedRegistryReference<Operator.Simple> MODULUS = Operators.key(ResourceKey.sponge("modulus"));

    /**
     * Represents the multiplication operation, *=
     */
    public static final DefaultedRegistryReference<Operator.Simple> MULTIPLICATION = Operators.key(ResourceKey.sponge("multiplication"));

    /**
     * Represents the subtraction operation, -=
     */
    public static final DefaultedRegistryReference<Operator.Simple> SUBTRACTION = Operators.key(ResourceKey.sponge("subtraction"));

    /**
     * Represents the swap operation, &gt;&lt;
     */
    public static final DefaultedRegistryReference<Operator> SWAP = Operators.key(ResourceKey.sponge("swap"));

    // SORTFIELDS:OFF

    private Operators() {
    }

    public static Registry<Operator> registry() {
        return Sponge.game().registry(RegistryTypes.OPERATOR);
    }

    private static <T extends Operator> DefaultedRegistryReference<T> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.OPERATOR, location).asDefaultedReference(Sponge::game);
    }

    // @formatter:off
}

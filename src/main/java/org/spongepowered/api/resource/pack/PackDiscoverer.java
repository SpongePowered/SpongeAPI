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
package org.spongepowered.api.resource.pack;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * A pack discoverer will populate the {@link PackList} with {@link PackInfo}s
 * and provide it a supplier to create a new {@link Pack}.
 */
public interface PackDiscoverer {

    /**
     * Populates the {@link PackList} with discovered {@link Pack}s.
     *
     * @param packInfos A map containing all the packs
     */
    void populate(Map<String, PackInfo> packInfos, PackInfoFactory factory);

    @FunctionalInterface
    interface PackInfoFactory {
        /**
         * Creates a new {@link PackInfo} from the given arguments. If the pack
         * does not have valid metadata, an empty optional is returned.
         *
         * @param name     The name of the pack.
         * @param forced   Whether the pack should always be loaded
         * @param pack     The supplier for the pack
         * @param priority The priority, first or last
         * @return The new pack info definition
         */
        Optional<PackInfo> createPackInfo(String name, boolean forced, Supplier<Pack> pack, PackInfo.Priority priority);
    }

}

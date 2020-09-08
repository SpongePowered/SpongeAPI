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
package org.spongepowered.api.entity.living;

import java.util.UUID;

public interface Human extends Humanoid, Creature, Ranger {

    /**
     * Sets the appearance "skin" of this human to the appearance used by a real
     * Mojang account holder's current skin based on their {@link UUID unique id}
     * assigned to them at account creation in Mojang's auth services.
     *
     * <p>This can also have additional rendering effects on an official Minecraft
     * client based on the Mojang account holder (if they are considered a special
     * "individual")</p>
     *
     * <p>Providing a unique id that isn't a real account has no defined handling
     * by this API. Consult your implementation vendor to determine what will
     * happen. Additionally the result is also left up to the vendor to define.</p>
     *
     * @param minecraftAccount The unique id to use
     * @return True if successful, false if not
     */
    boolean useSkinFor(UUID minecraftAccount);

    /**
     * Sets the appearance "skin" of this human to the appearance used by a real
     * Mojang account holder's current skin based on their {@link String username}.
     *
     * <p>This will trigger a request to Mojang's authentication servers to determine
     * their account's {@link UUID unique id} should the server not have that
     * already cached.</p>
     *
     * <p>This can also have additional rendering effects on an official Minecraft
     * client based on the Mojang account holder (if they are considered a special
     * "individual")</p>
     *
     * <p>Providing a username that isn't a real account has no defined handling
     * by this API. Consult your implementation vendor to determine what will
     * happen. Additionally the result is also left up to the vendor to define.</p>
     *
     * @param minecraftUsername The username to use
     * @return True if successful, false if not
     */
    boolean useSkinFor(String minecraftUsername);
}

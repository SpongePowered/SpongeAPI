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
package org.spongepowered.api.data.component.entity;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.token.GetterToken;
import org.spongepowered.api.data.token.Tokens;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.world.Location;

/**
 * Represents the "eye" location of an {@link Entity}. The location may
 * change based on the {@link Location} of the holder. Usually applicable to
 * all {@link Living} entities.
 */
public interface EyeLocationComponent extends Component<EyeLocationComponent> {

    GetterToken<Double> EYE_HEIGHT = Tokens.EYE_HEIGHT;
    GetterToken<Vector3d> EYE_LOCATION = Tokens.EYE_LOCATION;

    /**
     * Gets the height of the eye (camera) of this entity.
     *
     * @return The camera height
     */
    double getEyeHeight();

    /**
     * Gets the location of the eye height (camera) of this entity.
     *
     * @return The camera location
     */
    Vector3d getEyeLocation();

}

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
package org.spongepowered.api.entity.display;

import org.spongepowered.api.entity.Entity;

public interface DisplayEntity extends Entity {

    // TODO rotation/transformation?

    // TODO interpolation?

//    default BillboardType billboardType() {
//        return this.require(Keys.BILLBOARD_TYPE);
//    }
//
//    default int skyLight() {
//        // TODO impl
//        return this.require(Keys.SKY_LIGHT);
//    }
//
//    default int blockLight() {
//        // TODO impl
//        return this.require(Keys.BLOCK_LIGHT);
//    }

    // TODO view_range float/double

    // TODO shadow radius float/double 0=noshadow
    // TODO shadow strength float/double 1=default
    // TODO bounding box (maybe BASE_SIZE if this is not smth. else in the entity)
    // TODO glow_color_override -1 = use team color

}

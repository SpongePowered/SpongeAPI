/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.component.attribute;

import org.spongepowered.api.component.Component;

/**
 * Gives the "model" attribute, used in rendering.
 */
public interface Model extends Component {
    /**
     * Returns the identifier of the model.
     * @return The model identifier
     */
    String getModel();

    public static enum VanillaModels implements Model {
        // TODO Someone want to add all the Vanilla models?
        // TODO Eventhough the Enderman is THE best entity, he isn't id 0...give him the right one hm?
        ENDERMAN(0, "minecraft:enderman");

        private final int id;
        private final String model;

        VanillaModels(int id, String model) {
            this.id = id;
            this.model = model;
        }

        public final int getID() {
            return id;
        }

        @Override
        public String getModel() {
            return model;
        }
    }
}

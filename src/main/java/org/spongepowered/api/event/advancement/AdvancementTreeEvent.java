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
package org.spongepowered.api.event.advancement;

import org.spongepowered.api.advancement.AdvancementTree;
import org.spongepowered.api.advancement.TreeLayout;
import org.spongepowered.api.event.Event;

/**
 * A base interface for all the {@link AdvancementTree} events.
 */
public interface AdvancementTreeEvent extends Event {

    /**
     * Gets the {@link AdvancementTree}.
     *
     * @return The advancement tree
     */
    AdvancementTree getTree();

    /**
     * Is called when the layout of a {@link AdvancementTree} gets
     * updated, this is done after the vanilla game generates the
     * layout. You can safely move elements in the {@link TreeLayout}
     * within this event.
     */
    interface GenerateLayout extends AdvancementTreeEvent {

        /**
         * Gets the {@link TreeLayout} that got generated.
         *
         * @return The tree layout
         */
        TreeLayout getLayout();
    }
}

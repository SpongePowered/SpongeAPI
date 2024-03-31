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
package org.spongepowered.api.event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;

import java.util.Objects;

class SpongeAbstractEventTest {

//    @Test
    void testChangeBlockEvent_filter() {

    }

    @Test
    void testValueChangeEvent() {
        final DataTransactionResult original = DataTransactionResult.failNoData();
        final DataTransactionResult modified = DataTransactionResult.successNoData();

        final ChangeDataHolderEvent.ValueChange event = SpongeEventFactory.createChangeDataHolderEventValueChange(
                Cause.of(EventContext.empty(), "none"), original, this.mockParam(DataHolder.Mutable.class));

        Assertions.assertEquals(event.originalChanges(), original);

        event.proposeChanges(modified);
        Assertions.assertEquals(event.endResult(), modified);
    }

    @SuppressWarnings("unchecked")
    private <T> T mockParam(Class<T> clazz) {
        return (T) Objects.requireNonNull(SpongeEventFactoryTest.mockParam(clazz));
    }
}

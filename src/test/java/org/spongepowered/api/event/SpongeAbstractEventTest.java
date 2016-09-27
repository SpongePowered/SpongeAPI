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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.EventContext;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Optional;

public class SpongeAbstractEventTest {

    @SuppressWarnings("unchecked")
    @Test
    public void testChangeBlockEvent_filter() {
        Transaction<BlockSnapshot> transaction = new Transaction<>(mockParam(BlockSnapshot.class), mockParam(BlockSnapshot.class));

        when(transaction.getOriginal().getLocation()).thenReturn(Optional.of(new Location<>(mockParam(World.class), Vector3d.ZERO)));

        ChangeBlockEvent.Break event = SpongeEventFactory.createChangeBlockEventBreak(Cause.of(EventContext.empty(), "none"), Lists.newArrayList(transaction));
        event.filter(location -> false);

        assertThat(transaction.isValid(), is(false));
    }

    @Test
    public void testValueChangeEvent() {
        DataTransactionResult original = DataTransactionResult.failNoData();
        DataTransactionResult modified = DataTransactionResult.successNoData();

        ChangeDataHolderEvent.ValueChange event = SpongeEventFactory.createChangeDataHolderEventValueChange(Cause.of(EventContext.empty(), "none"), original,
            mockParam(DataHolder.class));

        assertThat(event.getOriginalChanges(), is(equalTo(original)));

        event.proposeChanges(modified);
        assertThat(event.getEndResult(), is(equalTo(modified)));
    }

    @SuppressWarnings("unchecked")
    private <T> T mockParam(Class<T> clazz) {
        return (T) SpongeEventFactoryTest.mockParam(clazz);
    }
}

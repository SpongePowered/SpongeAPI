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
package org.spongepowered.api.network.channel.packet;

import org.spongepowered.api.network.EngineConnection;
import org.spongepowered.api.network.EngineConnectionSide;

/**
 * A packet binding that allows the registration of {@link PacketHandler}s.
 *
 * @param <P> The packet type
 */
public interface HandlerPacketBinding<P extends Packet> extends PacketBinding<P> {

    /**
     * Adds a {@link PacketHandler} to handle the packets of type
     * {@link P}. The handler is invoked every time the packet is
     * sent to the given side.
     *
     * @param side The side the handler should be used on
     * @param handler The handler to add
     * @return This binding, for chaining
     */
    <C extends EngineConnection> PacketBinding<P> addHandler(EngineConnectionSide<C> side, PacketHandler<? super P, ? super C> handler);

    /**
     * Adds a {@link PacketHandler} to handle the packets of type
     * {@link P}. The handler is invoked every time the packet is
     * received by the given connection type.
     *
     * @param connectionType The connection type the handler should be used by
     * @param handler The handler to add
     * @return This binding, for chaining
     */
    <C extends EngineConnection> PacketBinding<P> addHandler(Class<C> connectionType, PacketHandler<? super P, ? super C> handler);

    /**
     * Adds a {@link PacketHandler} to handle the packets of type
     * {@link P}. The handler is invoked every time the packet is
     * sent to <strong>either</strong> side.
     *
     * @param handler The handler to add
     * @return This binding, for chaining
     */
    PacketBinding<P> addHandler(PacketHandler<? super P, EngineConnection> handler);

    /**
     * Removes the {@link PacketHandler} for the given side.
     *
     * @param side The side the handler should be removes from
     * @param handler The handler to remove
     * @return This binding, for chaining
     */
    <C extends EngineConnection> PacketBinding<P> removeHandler(EngineConnectionSide<C> side, PacketHandler<? super P, ? super C> handler);

    /**
     * Removes the {@link PacketHandler} for the given connection type.
     *
     * @param connectionType The connection type the handler should be removes from
     * @param handler The handler to remove
     * @return This binding, for chaining
     */
    <C extends EngineConnection> PacketBinding<P> removeHandler(Class<C> connectionType, PacketHandler<? super P, ? super C> handler);

    /**
     * Removes the {@link PacketHandler}.
     *
     * @param handler The handler to remove
     * @return This binding, for chaining
     */
    PacketBinding<P> removeHandler(PacketHandler<? super P, ?> handler);
}

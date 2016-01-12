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
package org.spongepowered.api.text.channel.type;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.channel.Channel;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * A message channel that targets the given recipients.
 */
public abstract class FixedChannel<T, M> implements Channel<T, M> {

    protected final Set<M> recipients;

    @SafeVarargs
    protected FixedChannel(M... recipients) {
        this(Arrays.asList(recipients));
    }

    public FixedChannel(Collection<? extends M> provided) {
        Set<M> recipients = Collections.newSetFromMap(new WeakHashMap<>());
        recipients.addAll(provided);
        this.recipients = recipients;
    }

    @Override
    public Collection<M> getMembers() {
        return ImmutableSet.copyOf(this.recipients);
    }

    public static class Message extends FixedChannel<Text, MessageReceiver> implements MessageChannel {

        public Message(MessageReceiver... recipients) {
            super(recipients);
        }

        public Message(Collection<? extends MessageReceiver> provided) {
            super(provided);
        }
    }

}

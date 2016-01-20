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

import static org.apache.commons.lang3.Validate.noNullElements;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.channel.Channel;
import org.spongepowered.api.channel.TransformableChannel;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.util.GuavaCollectors;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A message channel that targets all subjects contained within the given channels
 * and applies the message transformations of each channel in order (so with n
 * channels,
 * {@code channels[n-1].transformMessage(channels[n-2].transformMessage(channels[...]
 * .transformMessage(channels[0].transformMessage(input))))} would occur)
 */
public abstract class CombinedChannel<T, M, C extends Channel<T, M>> implements Channel<T, M> {

    protected final Collection<C> channels;

    @SafeVarargs
    public CombinedChannel(C... channels) {
        this(Arrays.asList(channels));
    }

    public CombinedChannel(Collection<? extends C> channels) {
        noNullElements(channels, "null message channel: %s");
        this.channels = ImmutableSet.copyOf(channels);
    }

    @Override
    public Collection<M> getMembers() {
        return this.channels.stream()
                .flatMap(channel -> channel.getMembers().stream())
                .collect(GuavaCollectors.toImmutableSet());
    }

    public static abstract class Transformable<T, M> extends CombinedChannel<T, M, TransformableChannel<T, M>> implements TransformableChannel<T, M> {

        @SafeVarargs
        public Transformable(TransformableChannel<T, M>... channels) {
            super(channels);
        }

        public Transformable(Collection<? extends TransformableChannel<T, M>> channels) {
            super(channels);
        }

        @Override
        public Optional<T> transform(@Nullable Object sender, M recipient, T original) {
            T text = original;
            for (TransformableChannel<T, M> channel : this.channels) {
                text = channel.transform(sender, recipient, text).orElse(text);
            }

            return Optional.ofNullable(text);
        }
    }

    public static class Message extends Transformable<Text, MessageReceiver> implements MessageChannel {

        public Message(MessageChannel... channels) {
            super(channels);
        }

        public Message(Collection<MessageChannel> channels) {
            super(channels);
        }
    }

}

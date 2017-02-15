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

import static com.google.common.base.Preconditions.checkNotNull;

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
public class FixedMessageChannel implements MessageChannel {

    protected final Set<MessageReceiver> recipients;

    /**
     * Creates an unmodifiable {@link MessageChannel} with the
     * provided {@link MessageReceiver}s.
     *
     * @param recipients The array of recipients
     */
    public FixedMessageChannel(MessageReceiver... recipients) {
        this(Arrays.asList(checkNotNull(recipients, "recipients")));
    }

    /**
     * Creates an unmodifiable {@link MessageChannel} with the provided
     * {@link Collection} of {@link MessageReceiver}s.
     *
     * @param provided The message receivers
     */
    public FixedMessageChannel(Collection<? extends MessageReceiver> provided) {
        Set<MessageReceiver> recipients = Collections.newSetFromMap(new WeakHashMap<>());
        recipients.addAll(provided);
        this.recipients = Collections.unmodifiableSet(recipients);
    }

    @Override
    public Collection<MessageReceiver> getMembers() {
        return this.recipients;
    }

}

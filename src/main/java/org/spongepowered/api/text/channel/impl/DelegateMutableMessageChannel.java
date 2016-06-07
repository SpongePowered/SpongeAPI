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
package org.spongepowered.api.text.channel.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.AbstractMutableMessageChannel;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.text.chat.ChatType;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A mutable message channel that leaves transforming and
 * members to the delegate channel passed.
 */
public class DelegateMutableMessageChannel extends AbstractMutableMessageChannel {

    protected final MessageChannel delegate;

    /**
     * Constructs a delegate mutable message channel.
     *
     * <p>The members from the provided channel are copied into our
     * own local collection.</p>
     *
     * @param delegate The delegate channel
     */
    public DelegateMutableMessageChannel(final MessageChannel delegate) {
        super();
        this.delegate = checkNotNull(delegate, "delegate");
        this.members.addAll(this.delegate.getMembers());
    }

    @Override
    public Optional<Text> transformMessage(@Nullable Object sender, MessageReceiver recipient, Text original, ChatType type) {
        return this.delegate.transformMessage(sender, recipient, original, type);
    }

}

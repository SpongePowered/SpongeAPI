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
package org.spongepowered.api.text.channel;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * An abstract implementation of {@link MutableMessageChannel}.
 */
public abstract class AbstractMutableMessageChannel implements MutableMessageChannel {

    protected final Collection<MessageReceiver> members;

    /**
     * The default implementation uses a {@link WeakHashMap} implementation of {@link Set}.
     */
    protected AbstractMutableMessageChannel() {
        this(Collections.newSetFromMap(new WeakHashMap<>()));
    }

    /**
     * Creates a new instance of {@link AbstractMutableMessageChannel} with the
     * provided {@link Collection} as the underlying member list.
     *
     * <p>The passed {@link Collection} directly affects the members of this
     * channel.</p>
     *
     * <p>It is recommended to use a weak collection to avoid memory leaks. If
     * you do not use a weak collection, please ensure that members are  cleaned
     * up properly.</p>
     *
     * @param members The collection of members
     */
    protected AbstractMutableMessageChannel(Collection<MessageReceiver> members) {
        this.members = checkNotNull(members, "members");
    }

    @Override
    public boolean addMember(MessageReceiver member) {
        checkNotNull(member, "member");
        return !this.members.contains(member) && this.members.add(member);
    }

    @Override
    public boolean removeMember(MessageReceiver member) {
        checkNotNull(member, "member");
        return this.members.remove(member);
    }

    @Override
    public void clearMembers() {
        this.members.clear();
    }

    @Override
    public Collection<MessageReceiver> getMembers() {
        return this.members;
    }

}

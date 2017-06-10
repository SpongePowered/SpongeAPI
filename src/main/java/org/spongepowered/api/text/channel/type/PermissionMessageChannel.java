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

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.permission.PermissionService;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Collection;
import java.util.Map;

/**
 * A message channel that targets all subjects with the given permission.
 */
public class PermissionMessageChannel implements MessageChannel {

    protected final String permission;

    /**
     * Creates a new {@link MessageChannel} with the provided {@link String permission}
     * required to be considered a "target" {@link MessageReceiver}.
     *
     * @param permission The permission node
     */
    public PermissionMessageChannel(String permission) {
        this.permission = checkNotNull(permission, "permission");
    }

    /**
     * Gets the {@link String} permission required to be included in this
     * {@link MessageChannel}.
     *
     * @return The permission node
     */
    public String getPermission() {
        return this.permission;
    }

    @Override
    public Collection<MessageReceiver> getMembers() {
        PermissionService service = Sponge.getGame().getServiceManager().provideUnchecked(PermissionService.class);

        return service.getKnownSubjects().values().stream()
                .flatMap(input -> input.getAllWithPermission(this.permission).entrySet().stream()
                        .filter(Map.Entry::getValue)
                        .map(entry -> entry.getKey().getCommandSource().orElse(null))
                        .filter(source -> source != null))
                .collect(ImmutableSet.toImmutableSet());
    }

}

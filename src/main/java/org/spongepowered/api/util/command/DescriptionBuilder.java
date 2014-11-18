/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.util.command;

import com.google.common.base.Optional;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Builds static instances of {@link Description}.
 */
public class DescriptionBuilder {

    @Nullable
    private String shortDescription;
    @Nullable
    private String help;
    @Nullable
    private String usage;
    private List<String> permissions = new ArrayList<String>();

    private DescriptionBuilder() {
    }

    /**
     * Set the short description.
     *
     * @param shortDescription A short description, which may be null
     * @return This same object
     */
    public DescriptionBuilder desc(@Nullable String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    /**
     * Set the help text.
     *
     * @param help A help text, which may be null
     * @return This same object
     */
    public DescriptionBuilder help(@Nullable String help) {
        this.help = help;
        return this;
    }

    /**
     * Set the usage string.
     *
     * @param usage A usage string
     * @return This same object
     */
    public DescriptionBuilder usage(String usage) {
        checkNotNull(usage);
        this.usage = usage;
        return this;
    }

    /**
     * Add a permission string to the list of required permissions.
     *
     * @param permission The permission
     * @return This same object
     */
    public DescriptionBuilder require(String permission) {
        checkNotNull(permission);
        permissions.add(permission);
        return this;
    }

    /**
     * Replace the list of required permissions with the given collection.
     *
     * <p>A copy of the collection is made.</p>
     *
     * @param permissions A collection of permissions
     * @return This same object
     */
    public DescriptionBuilder requireOnly(Collection<String> permissions) {
        checkNotNull(permissions);
        this.permissions = new ArrayList<String>(permissions);
        return this;
    }

    /**
     * Build a description.
     *
     * @return A description object
     * @throws IllegalArgumentException Thrown if the usage string is not set
     */
    public Description build() {
        final String shortDescription = this.shortDescription;
        final String help = this.help;
        final String usage = this.usage;
        final List<String> permissions = Collections.unmodifiableList(new ArrayList<String>(this.permissions));

        if (usage == null) {
            throw new IllegalArgumentException("Usage is not set");
        }

        return new Description() {
            @Override
            public Optional<String> getShortDescription() {
                return Optional.fromNullable(shortDescription);
            }

            @Override
            public Optional<String> getHelp() {
                return Optional.fromNullable(help);
            }

            @Override
            public String getUsage() {
                return usage;
            }

            @Override
            public List<String> getPermissions() {
                return permissions;
            }
        };
    }

    /**
     * Create a new description builder.
     *
     * @return A new description builder
     */
    public static DescriptionBuilder create() {
        return new DescriptionBuilder();
    }

}

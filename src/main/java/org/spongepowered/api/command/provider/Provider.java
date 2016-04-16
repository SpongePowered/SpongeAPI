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
package org.spongepowered.api.command.provider;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandArgs;

import java.lang.annotation.Annotation;
import java.util.Collection;

/**
 * An object capable of providing instances of type {@link T}.
 *
 * @param <T> The type of object this provider provides
 */
public interface Provider<T> {

    /**
     * Provides an instance of {@link T}.
     *
     * @param source The command source
     * @param args The command arguments
     * @param modifiers The annotation modifiers
     * @return An instance of {@link T}
     * @throws ProvisionException If an instance could not be provided
     */
    T get(CommandSource source, CommandArgs args, Collection<? extends Annotation> modifiers) throws ProvisionException;

}

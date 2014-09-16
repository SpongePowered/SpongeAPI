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

package org.spongepowered.api.command;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Provides information about a command's usage and help.
 *
 * <p>The level of information provided is determined by the implementation.
 * Some implementations may provide little or no information.</p>
 *
 * <p>This class does not define a way to execute the command. See
 * {@link CommandCallable}, which has a {@code getDescription()} method,
 * for an interface that does define how a command is executed.</p>
 *
 * <p>Implementations are not required to implement a sane
 * {@link #equals(Object)} but may choose to do so.</p>
 */
public interface Description {

    /**
     * Get a short one-line description of this command.
     * 
     * @return A description, or null if no description is available
     */
    @Nullable
    String getShortDescription();

    /**
     * Get a longer help text about this command.
     * 
     * @return A help text, or null if no help is available
     */
    @Nullable
    String getHelp();

    /**
     * Get the usage string of this command.
     * 
     * <p>A usage string may look like 
     * {@code [-w &lt;world&gt;] &lt;var1&gt; &lt;var2&gt;}.</p>
     * 
     * @return A usage string
     */
    String getUsage();
    
    /**
     * Get a list of permissions that the player may have to have permission.
     * 
     * <p>Permission data may or may not be available. This is only useful as a
     * potential hint.</p>
     * 
     * @return The list of permissions
     */
    List<String> getPermissions();

}
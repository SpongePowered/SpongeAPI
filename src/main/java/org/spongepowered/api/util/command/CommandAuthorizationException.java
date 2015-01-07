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

import javax.annotation.Nullable;

/**
 * Thrown when a command is called without authorization or the required
 * permissions.
 */
public class CommandAuthorizationException extends CommandException {

    private static final long serialVersionUID = 6013332030938687625L;
    private static String defaultMessage = "You do not have the permission to use this command!";
    private final CommandCallable command;
    private final String permissionNode;

    /**
     * Construct a new exception with the missing permission with no message.
     * 
     * @param permissionNode The permission node missing
     */
    public CommandAuthorizationException(String permissionNode, CommandCallable command) {
        this(defaultMessage, permissionNode, command);
    }

    /**
     * Construct a new exception with the given message.
     * 
     * @param message The detail message
     * @param permissionNode The permission node missing
     * @param command The command involved
     */
    public CommandAuthorizationException(@Nullable String message, String permissionNode, CommandCallable command) {
        super(message);
        this.command = command;
        this.permissionNode = permissionNode;
    }
    
    /**
     * Gets the command involved in the error
     * 
     * @return The command involved
     */
    public CommandCallable getCommand() {
        return command;
    }

    /**
     * Gets the missing permission node that generated this error
     * 
     * @return The missing permission node
     */
    public String getPermissionNode() {
        return permissionNode;
    }

}

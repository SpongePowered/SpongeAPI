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
package org.spongepowered.api.command;

import org.spongepowered.api.text.Text;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This method should be applied to methods, defining a command.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {

    /**
     * Gets the parent of this command.
     *
     * @return the command's parent.
     */
    String parent() default "";

    /**
     * Gets the name of the command.
     *
     * @return the command's name.
     */
    String name();

    /**
     * Gets all the aliases of this command.
     *
     * @return the command's aliases.
     */
    String[] aliases() default {};

    /**
     * Gets the description of this command.
     * Converted to {@link Text}, using {@link Text#of(String)}.
     *
     * @return the command's description.
     */
    String description() default "";

    /**
     * Gets the usage of this command.
     * Converted to {@link Text}, using {@link Text#of(String)}.
     *
     * @return the command's usage.
     */
    String usage() default "";

    /**
     * Gets all the permissions associated with this command.
     * The {@link CommandSource} will have to have all permissions to be able to use the command.
     * Not having any permission, means that all users can use the command, use with caution!
     *
     * @return the command's permissions.
     */
    String[] permissions() default {};
}

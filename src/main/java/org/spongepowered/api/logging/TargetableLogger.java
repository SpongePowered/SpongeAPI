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
package org.spongepowered.api.logging;

import org.slf4j.Logger;
import org.spongepowered.api.text.Text;

import java.util.Optional;
import java.util.Set;

/**
 * Created by zml on 9/18/15.
 */
public interface TargetableLogger extends Logger {

    /**
     * Set the output target for this logger.
     *
     * @param target The logger output target
     */
    void setTarget(LogTarget target);

    /**
     *
     * @return
     */
    LogTarget getTarget();

    /**
     * Create a new child logger with no additional tags.
     * @see #newChild(Text) for information on what will be inherited
     * @return
     */
    TargetableLogger newChild();

    /**
     * Create a new child logger with the given tag. This tag will be added after any existing tags parents may have.
     * A child logger will log to all of its parent's log targets, adding changes to the parent
     *
     * @param tag The tag to log with in the child logger
     * @return The child logger
     */
    TargetableLogger newChild(Text tag);

    Optional<? extends TargetableLogger> getParent();
}


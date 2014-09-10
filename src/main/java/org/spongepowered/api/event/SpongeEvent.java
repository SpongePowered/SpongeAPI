/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.event;

import org.spongepowered.api.Game;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public abstract class SpongeEvent {
    private static final Map<Class<?>, Map<Class<?>, Boolean>> annotationMap = new ConcurrentHashMap<Class<?>, Map<Class<?>, Boolean>>();
    public final Game game;
    private final boolean isCancellable;
    private boolean isCancelled;
    public Result result = Result.NO_RESULT;

    public SpongeEvent(Game game) {
        this.game = game;
        isCancellable = hasAnnotation(Cancellable.class);
    }

    public final String getName() {
        return getClass().getSimpleName();
    }

    /**
     * Returns if this event can be cancelled.
     *
     * @return True if cancelled is allowed, false if not
     */
    public boolean isCancellable() {
        return isCancellable;
    }

    /**
     * Returns if this event has been cancelled.
     *
     * @return True if cancelled, false if not
     */
    public boolean isCancelled() {
        return isCancelled;
    }

    /**
     * Sets this event as cancelled.
     *
     * @param cancel True to cancel, false to not cancel
     * @throws java.lang.IllegalArgumentException If an attempt is made to cancel but the event is not cancellable
     */
    public void setCancelled(boolean cancel) {
        if (!isCancellable()) {
            throw new IllegalArgumentException("Attempted to cancel an event that is not cancellable!");
        }
        isCancelled = cancel;
    }

    private boolean hasAnnotation(Class<? extends Annotation> annotation) {
        Class<?> me = this.getClass();
        Map<Class<?>, Boolean> list = annotationMap.get(me);
        if (list == null) {
            list = new ConcurrentHashMap<Class<?>, Boolean>();
            annotationMap.put(me, list);
        }

        Boolean cached = list.get(annotation);
        if (cached != null) {
            return cached;
        }

        Class<?> cls = me;
        while (cls != SpongeEvent.class) {
            if (cls.isAnnotationPresent(annotation)) {
                list.put(annotation, true);
                return true;
            }
            cls = cls.getSuperclass();
        }

        list.put(annotation, false);
        return false;
    }

    @Retention(value = RUNTIME)
    @Target(value = TYPE)
    public @interface Cancellable {
    }
}

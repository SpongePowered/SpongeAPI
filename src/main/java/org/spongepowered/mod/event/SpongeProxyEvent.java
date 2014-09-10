/**
 * This file is part of Sponge, licensed under the MIT License (MIT).
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
package org.spongepowered.mod.event;

import cpw.mods.fml.common.eventhandler.Event;
import org.spongepowered.api.event.SpongeEvent;

public class SpongeProxyEvent extends Event {
    private final SpongeEvent event;

    public SpongeProxyEvent(SpongeEvent event) {
        this.event = event;
    }

    @Override
    public boolean isCancelable() {
        return event.isCancellable();
    }

    @Override
    public boolean isCanceled() {
        return event.isCancelled();
    }

    @Override
    public void setCanceled(boolean cancel) {
        event.setCancelled(cancel);
    }

    @Override
    public boolean hasResult() {
        return event.result!= org.spongepowered.api.event.Result.NO_RESULT;
    }

    @Override
    public Result getResult() {
        final org.spongepowered.api.event.Result result = event.result;

        switch (result) {
            case ALLOW:
                return Result.ALLOW;
            case DENY:
                return Result.DENY;
            default:
                return Result.DEFAULT;
        }
    }

    @Override
    public void setResult(Result value) {
        switch (value) {
            case ALLOW:
                event.result = org.spongepowered.api.event.Result.ALLOW;
                break;
            case DENY:
                event.result = org.spongepowered.api.event.Result.DENY;
                break;
            default:
                event.result = org.spongepowered.api.event.Result.DEFAULT;
        }
    }
}

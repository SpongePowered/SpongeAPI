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
package org.spongepowered.api.effect.sound.record;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class RecordTypes {

    // SORTFIELDS:ON

    public static final RecordType BLOCKS = DummyObjectProvider.createFor(RecordType.class, "BLOCKS");

    public static final RecordType CAT = DummyObjectProvider.createFor(RecordType.class, "CAT");

    public static final RecordType CHIRP = DummyObjectProvider.createFor(RecordType.class, "CHIRP");

    public static final RecordType ELEVEN = DummyObjectProvider.createFor(RecordType.class, "ELEVEN");

    public static final RecordType FAR = DummyObjectProvider.createFor(RecordType.class, "FAR");

    public static final RecordType MALL = DummyObjectProvider.createFor(RecordType.class, "MALL");

    public static final RecordType MELLOHI = DummyObjectProvider.createFor(RecordType.class, "MELLOHI");

    public static final RecordType STAL = DummyObjectProvider.createFor(RecordType.class, "STAL");

    public static final RecordType STRAD = DummyObjectProvider.createFor(RecordType.class, "STRAD");

    public static final RecordType THIRTEEN = DummyObjectProvider.createFor(RecordType.class, "THIRTEEN");

    public static final RecordType WAIT = DummyObjectProvider.createFor(RecordType.class, "WAIT");

    public static final RecordType WARD = DummyObjectProvider.createFor(RecordType.class, "WARD");

    // SORTFIELDS:OFF

    private RecordTypes() {
    }

}

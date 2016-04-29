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
package org.spongepowered.api.keyboard;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link KeyBinding}s in vanilla minecraft.
 */
public class KeyBindings {

    /**
     * All the {@link KeyBinding}s listed under the
     * category {@link KeyCategories#GAMEPLAY}.
     */
    public static class Gameplay {

        // SORTFIELDS:ON

        public static final KeyBinding ATTACK = DummyObjectProvider.createFor(KeyBinding.class, "ATTACK");

        public static final KeyBinding PICK_BLOCK = DummyObjectProvider.createFor(KeyBinding.class, "PICK_BLOCK");

        public static final KeyBinding USE_ITEM = DummyObjectProvider.createFor(KeyBinding.class, "USE_ITEM");

        // SORTFIELDS:OFF

        private Gameplay() {}
    }

    /**
     * All the {@link KeyBinding}s listed under the
     * category {@link KeyCategories#INVENTORY}.
     */
    public static class Inventory {

        // SORTFIELDS:ON

        public static final KeyBinding DROP_ITEM = DummyObjectProvider.createFor(KeyBinding.class, "DROP_ITEM");

        public static final KeyBinding HOTBAR_1 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_1");

        public static final KeyBinding HOTBAR_2 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_2");

        public static final KeyBinding HOTBAR_3 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_3");

        public static final KeyBinding HOTBAR_4 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_4");

        public static final KeyBinding HOTBAR_5 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_5");

        public static final KeyBinding HOTBAR_6 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_6");

        public static final KeyBinding HOTBAR_7 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_7");

        public static final KeyBinding HOTBAR_8 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_8");

        public static final KeyBinding HOTBAR_9 = DummyObjectProvider.createFor(KeyBinding.class, "HOTBAR_9");

        public static final KeyBinding INVENTORY = DummyObjectProvider.createFor(KeyBinding.class, "INVENTORY");

        public static final KeyBinding SWAP_HAND_ITEMS = DummyObjectProvider.createFor(KeyBinding.class, "SWAP_HAND_ITEMS");

        // SORTFIELDS:OFF

        private Inventory() {}
    }

    /**
     * All the {@link KeyBinding}s listed under the
     * category {@link KeyCategories#MISC}.
     */
    public static class Misc {

        // SORTFIELDS:ON

        public static final KeyBinding FULLSCREEN = DummyObjectProvider.createFor(KeyBinding.class, "FULLSCREEN");

        public static final KeyBinding SCREENSHOT = DummyObjectProvider.createFor(KeyBinding.class, "SCREENSHOT");

        public static final KeyBinding SMOOTH_CAMERA = DummyObjectProvider.createFor(KeyBinding.class, "SMOOTH_CAMERA");

        public static final KeyBinding SPECTATOR_OUTLINES = DummyObjectProvider.createFor(KeyBinding.class, "SPECTATOR_OUTLINES");

        public static final KeyBinding TOGGLE_PERSPECTIVE = DummyObjectProvider.createFor(KeyBinding.class, "TOGGLE_PERSPECTIVE");

        // SORTFIELDS:OFF

        private Misc() {}
    }

    /**
     * All the {@link KeyBinding}s listed under the
     * category {@link KeyCategories#MOVEMENT}.
     */
    public static class Movement {

        // SORTFIELDS:ON

        public static final KeyBinding BACK = DummyObjectProvider.createFor(KeyBinding.class, "BACK");

        public static final KeyBinding FORWARD = DummyObjectProvider.createFor(KeyBinding.class, "FORWARD");

        public static final KeyBinding JUMP = DummyObjectProvider.createFor(KeyBinding.class, "JUMP");

        public static final KeyBinding LEFT = DummyObjectProvider.createFor(KeyBinding.class, "LEFT");

        public static final KeyBinding RIGHT = DummyObjectProvider.createFor(KeyBinding.class, "RIGHT");

        public static final KeyBinding SNEAK = DummyObjectProvider.createFor(KeyBinding.class, "SNEAK");

        public static final KeyBinding SPRINT = DummyObjectProvider.createFor(KeyBinding.class, "SPRINT");

        // SORTFIELDS:OFF

        private Movement() {}
    }

    /**
     * All the {@link KeyBinding}s listed under the
     * category {@link KeyCategories#MULTIPLAYER}.
     */
    public static class Multiplayer {

        // SORTFIELDS:ON

        public static final KeyBinding CHAT = DummyObjectProvider.createFor(KeyBinding.class, "CHAT");

        public static final KeyBinding COMMAND = DummyObjectProvider.createFor(KeyBinding.class, "COMMAND");

        public static final KeyBinding PLAYER_LIST = DummyObjectProvider.createFor(KeyBinding.class, "PLAYER_LIST");

        // SORTFIELDS:OFF

        private Multiplayer() {}
    }

    private KeyBindings() {}
}

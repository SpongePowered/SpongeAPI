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
package org.spongepowered.api.text;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
// import org.spongepowered.api.item.ItemType;
// import org.spongepowered.api.item.inventory.ItemStack;

public class MessageTest {

    @Test
    public void testClone() {
        final Message message = Message.of("Sponge is awesome!")
            // .append(new ItemStack(ItemType.COOKIE, 42), TextFormatting.RED + "Here your awesome cookie!")
            // .append(Achievement.BAKE_CAKE, TextFormatting.UNDERLINE + "Here your awesome cake!")
            .append(TextClickAction.ofOpenUrl("http://spongepowered.org"), "Click here for more information.");
        assertEquals(message, message.clone());
    }

}

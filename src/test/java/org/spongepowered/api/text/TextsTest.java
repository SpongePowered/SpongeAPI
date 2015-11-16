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
package org.spongepowered.api.text;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TextsTest {

    @Test
    public void testFormatMap() {
        String killer = "PvPMaster";
        String killed = "Innocent";
        String weapon = "Stick of Doom";
        Text noKiller = Texts.placeholder("killer");
        Text noKilled = Texts.placeholder("killed");
        Text noWeapon = Texts.placeholder("weapon", Texts.of("his bare hands"));

        Text template = build(noKiller, noKilled, noWeapon);
        // Need to wrap this in another Text since Text.format does that as well
        Text expected = build(Texts.of((Object) killer), Texts.of((Object) killed), Texts.of((Object) weapon));

        Text notFormated = Texts.format(template, new HashMap<>());
        assertEquals(template, notFormated);

        Map<String, Object> replacements = new HashMap<>();
        replacements.put("killer", killer);
        replacements.put("killed", killed);
        replacements.put("weapon", weapon);
        Text formated = Texts.format(template, replacements);
        assertEquals(expected, formated);
    }

    @Test
    public void testFormatArray() {
        String killer = "PvPMaster";
        String killed = "Innocent";
        String weapon = "Stick of Doom";
        Text noKiller = Texts.placeholder("0");
        Text noKilled = Texts.placeholder("1");
        Text noWeapon = Texts.placeholder("2", Texts.of("his bare hands"));

        Text template = build(noKiller, noKilled, noWeapon);
        // Need to wrap this in another Text since Text.format does that as well
        Text expected = build(Texts.of((Object) killer), Texts.of((Object) killed), Texts.of((Object) weapon));

        Text notFormated = Texts.format(template, new HashMap<>());
        assertEquals(template, notFormated);

        Text formated = Texts.format(template, killer, killed, weapon);
        assertEquals(expected, formated);
    }

    private Text build(Text killer, Text killed, Text weapon) {
        return Texts.builder("Player ")
                .append(killer)
                .append(Texts.of(" has killed "))
                .append(killed)
                .append(Texts.of(" with "))
                .append(weapon)
                .build();
    }

}

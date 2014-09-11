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
package org.spongepowered.api.text;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * All the formatting used in Minecraft.
 * 
 * @see net.minecraft.util.EnumChatFormatting
 */
public final class TextFormatting {
    
    public static final TextFormatting BLACK         = new TextFormatting("black",          '0');
    public static final TextFormatting DARK_BLUE     = new TextFormatting("dark_blue",      '1');
    public static final TextFormatting DARK_GREEN    = new TextFormatting("dark_green",     '2');
    public static final TextFormatting DARK_AQUA     = new TextFormatting("dark_aqua",      '3');
    public static final TextFormatting DARK_RED      = new TextFormatting("dark_red",       '4');
    public static final TextFormatting DARK_PURPLE   = new TextFormatting("dark_purple",    '5');
    public static final TextFormatting GOLD          = new TextFormatting("gold",           '6');
    public static final TextFormatting GRAY          = new TextFormatting("gray",           '7');
    public static final TextFormatting DARK_GRAY     = new TextFormatting("dark_gray",      '8');
    public static final TextFormatting BLUE          = new TextFormatting("blue",           '9');
    public static final TextFormatting GREEN         = new TextFormatting("green",          'a');
    public static final TextFormatting AQUA          = new TextFormatting("aqua",           'b');
    public static final TextFormatting RED           = new TextFormatting("red",            'c');
    public static final TextFormatting LIGHT_PURPLE  = new TextFormatting("light_purple",   'd');
    public static final TextFormatting YELLOW        = new TextFormatting("yellow",         'e');
    public static final TextFormatting WHITE         = new TextFormatting("white",          'f');
    public static final TextFormatting OBFUSCATED    = new TextFormatting("obfuscated",     'k', true);
    public static final TextFormatting BOLD          = new TextFormatting("bold",           'l', true);
    public static final TextFormatting STRIKETHROUGH = new TextFormatting("strikethrough",  'm', true);
    public static final TextFormatting UNDERLINE     = new TextFormatting("underline",      'n', true);
    public static final TextFormatting ITALIC        = new TextFormatting("italic",         'o', true);
    public static final TextFormatting RESET         = new TextFormatting("reset",          'r');
    
    private static final Map<Character, TextFormatting> codeMap = new LinkedHashMap<Character, TextFormatting>();
    private static final Map<String, TextFormatting> nameMap = new LinkedHashMap<String, TextFormatting>();
    private final String name;
    private final char colorCode;
    private final boolean fancy;

    public TextFormatting(String name, char code) {
        this(name, code, false);
    }

    public TextFormatting(String name, char code, boolean fancy) {
        this.name = name;
        this.colorCode = code;
        this.fancy = fancy;
        codeMap.put(Character.toLowerCase(code), this);
        nameMap.put(name.toLowerCase(), this);
    }

    /**
     * Gets the human readable name for this format.
     *
     * @return The name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the color code used by the renderer.
     *
     * @return The code.
     */
    public char getColorCode() {
        return this.colorCode;
    }

    /**
     * Gets whether this format is fancy.<br/>
     * ex. bold, italics, underline.
     *
     * @return
     */
    public boolean isFancy() {
        return this.fancy;
    }

    /**
     * Returns this format as shown in chat.
     */
    @Override
    public String toString() {
        return "\u00a7" + this.colorCode; // section symbol + colorCode
    }

    /**
     * Gets all the formats created.
     *
     * @return
     */
    public static Collection<TextFormatting> values() {
        return codeMap.values();
    }

    /**
     * Gets a format by code.
     *
     * @param code The code used by the font renderer
     * @return The format or null if it doesn't exist.
     */
    public static TextFormatting valueOf(char code) {
        return codeMap.get(Character.toLowerCase(code));
    }

    /**
     * Gets a format by name. Case insensitive.
     * 
     * @param name The name
     * @return The format
     */
    public static TextFormatting valueByName(String name) {
        return nameMap.get(name.toLowerCase());
    }
}

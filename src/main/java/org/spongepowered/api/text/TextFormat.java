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

/**
 * Represents formatted or colored text.
 * Source: http://minecraft.gamepedia.com/Formatting_codes#Color_codes
 *
 */
public final class TextFormat {
    
    /**
     * The fully qualified character that Minecraft uses to handle chat formatting.
     */
    public static final char FORMAT_CODE = '§';
    
    public static final TextFormat GREEN = new TextFormat('a');
    
    public static final TextFormat AQUA = new TextFormat('b');
    
    public static final TextFormat RED = new TextFormat('c');
    
    public static final TextFormat PURPLE = new TextFormat('d');
    
    public static final TextFormat YELLOW = new TextFormat('e');
    
    public static final TextFormat WHITE = new TextFormat('f');
    
    public static final TextFormat BLACK = new TextFormat('0');
    
    public static final TextFormat DARK_BLUE = new TextFormat('1');
    
    public static final TextFormat DARK_GREEN = new TextFormat('2');
    
    public static final TextFormat DARK_AQUA = new TextFormat('3');
    
    public static final TextFormat DARK_RED = new TextFormat('4');
    
    public static final TextFormat DARK_PURPLE = new TextFormat('5');
    
    public static final TextFormat GOLD = new TextFormat('6');
    
    public static final TextFormat GRAY = new TextFormat('7');
    
    public static final TextFormat DARK_GRAY = new TextFormat('8');
    
    public static final TextFormat BLUE = new TextFormat('9');
    
    public static final TextFormat OBFUSCATED = new TextFormat('k', true);
    
    public static final TextFormat BOLD = new TextFormat('l', true);
    
    public static final TextFormat STRIKETHROUGH = new TextFormat('m', true);
    
    public static final TextFormat UNDERLINE = new TextFormat('n',true);
    
    public static final TextFormat ITALIC = new TextFormat('o', true);
    
    public static final TextFormat RESET = new TextFormat('r', true);
    
    /**
     * Whether or not this ChatColor is a format (as opposed to a color);
     * Ex: ChatColor.BOLD would be a format.
     */
    private final boolean format;
    /**
     * The color (or format) code of the ChatColor.
     */
    private final char code;
    
    /**
     * Convenience constructor
     * @see TextFormat#ChatColor(char, boolean)
     */
    private TextFormat(char code) {
        this(code, false);
    }
    
    /**
     * 
     * @param code The color code
     * @param format Whether or not the ChatColor is a format style
     */
    private TextFormat(char code, boolean format) {
        this.code = code;
        this.format = format;
    }
    
    /**
     * Gets the character associated with this color.
     * 
     * @return the color code
     */
    public char getCode() {
        return code;
    }
    
    /**
     * Gets whether or not this is a format.
     * @return {@code True} if it's a format, {@code false} if not (meaning it's a color).
     */
    public boolean isFormat() {
        return format;
    }
    
    /**
     * Parses a string to get a styled version of it, using an alternate code.
     * 
     * @param unformatted The text to be parsed and formatted
     * @param alternateCode The alternate character code
     * @return {@code unformatted} correctly formatted.
     */
    public static String translateAlternateCode(String unformatted, char alternateCode) {
        //TODO: possibly a faster version of this using regex?
        StringBuilder formatted = new StringBuilder();
        for (char c : unformatted.toCharArray()) {
            char toAppend = c;
            if (c == alternateCode) {
                toAppend = TextFormat.FORMAT_CODE;
            }
            formatted.append(toAppend);
        }
        return formatted.toString();
    }
    
    /**
     * Removes <em>all</em> formatting from a {@link String}. 
     *     This includes colors AND formatting.
     * @param formatted the String to be parsed.
     * @return a String with all instances of formatting removed.
     */
    public static String stripFormatting(String formatted) {
        return formatted.replaceAll(TextFormat.FORMAT_CODE + "([0-9a-fk-or])", "");
    }
    
    @Override
    public String toString() {
        return TextFormat.FORMAT_CODE + String.valueOf(code);
    }
}

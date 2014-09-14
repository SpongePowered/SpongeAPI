/**
 * The MIT License (MIT)
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

package org.spongepowered.api;

public enum MinecraftColor {
        /**
         * Black
         */
        BLACK('0', "\u00A70"),
        /**
         * Dark Blue
         */
        DARK_BLUE('1', "\u00A71"),
        /**
         * Dark Green
         */
        DARK_GREEN('2', "\u00A72"),
        /**
         * Dark Aqua
         */
        DARK_AQUA('3', "\u00A73"),
        /**
         * Dark Red
         */
        DARK_RED('4', "\u00A74"),
        /**
         * Dark Purple
         */
        DARK_PURPLE('5', "\u00A75"),
        /**
         * Gold
         */
        GOLD('6', "\u00A76"),
        /**
         * Gray
         */
        GRAY('7', "\u00A77"),
        /**
         * Dark Gray
         */
        DARK_GRAY('8', "\u00A78"),
        /**
         * Blue
         */
        BLUE('9', "\u00A79"),
        /**
         * Green
         */
        GREEN('a', "\u00A7A"),
        /**
         * Aqua
         */
        AQUA('b', "\u00A7B"),
        /**
         * Red
         */
        RED('c', "\u00A7C"),
        /**
         * Light Purple
         */
        LIGHT_PURPLE('d', "\u00A7D"),
        /**
         * Yellow
         */
        YELLOW('e', "\u00A7E"),
        /**
         * White
         */
        WHITE('f', "\u00A7F");
    
    private final char code;
    private final String specialCode;

    private MinecraftColor(char code, String specialCode) {
        this.code = code;
        this.specialCode = specialCode;
    }
    
    public String getChatcode(MinecraftColor color) {
        String chatcode = "§" + color.code;
        return chatcode;
    }

}

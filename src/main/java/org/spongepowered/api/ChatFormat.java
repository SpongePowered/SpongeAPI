The MIT License (MIT)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

package org.spongepowered.api;

public class ChatFormat {
	
	String chatPrefix;
	
	public ChatFormat(MinecraftColor color, Formatting format) {
		String chatPrefix = color.getChatcode(color) + format.getformatting(format);
		this.chatPrefix = chatPrefix;
	}
	
	public ChatFormat(MinecraftColor color, ChatFormat.Formatting[] formats) {
		int i = 0;
		while(formats.length >= i) {
		Formatting format = formats[i];
		String chatPrefix = color.getChatcode(color) + format.getformatting(format);
		this.chatPrefix = chatPrefix;
		i++;
		}
	}
	
	public ChatFormat(MinecraftColor color) {
		String chatPrefix = color.getChatcode(color);
		this.chatPrefix = chatPrefix;
	}
	
	public ChatFormat(Formatting format) {
		this(MinecraftColor.WHITE, format);
	}
	
	/*
	For Future Use!!!
	public ChatFormat(MinecraftColor color, Formatting format, String hovermsg) {
		
	}
	*/
	
	
	public enum Formatting {
	 /**
     * Bold
     */
    Bold('l', "\u00A7l"),
    /**
     * Italic
     */
    Italic('o', "\u00A7o"),
    /**
     * Underline
     */
    Underlined('n', "\u00A7n"),
    /**
     * Cross Out
     */
    Strikethrough('m', "\u00A7m"),
    /**
     * Obfuscated
     */
    Obfuscated('k', "\u00A7k"),
    /**
     * Reset
     */
    Reset('r', "\u00A7r");
	
    	private final char code;
    	private final String specialCode;

    	private Formatting(char code, String specialCode) {
    		this.code = code;
    		this.specialCode = specialCode;
    	}
    	
    	public String getformatting(Formatting format) {
        	String chatCode = "§" + format.code;
        	return chatCode;
    	}
	}
}

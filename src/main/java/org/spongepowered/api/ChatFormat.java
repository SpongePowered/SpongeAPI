package org.spongepowered.api;

public class ChatFormat {
	
	String chatprefix;
	
	public ChatFormat(MinecraftColor color, Formatting format) {
		String chatprefix = color.getChatcode(color) + format.getformatting(format);
		this.chatprefix = chatprefix;
	}
	
	public ChatFormat(MinecraftColor color, ChatFormat.Formatting[] formats) {
		int i = 0;
		while(formats.length >= i) {
		Formatting format = formats[i];
		String chatprefix = color.getChatcode(color) + format.getformatting(format);
		this.chatprefix = chatprefix;
		i++;
		}
	}
	
	public ChatFormat(MinecraftColor color) {
		String chatprefix = color.getChatcode(color);
		this.chatprefix = chatprefix;
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
    	private final String SpecialCode;

    	private Formatting(char code, String SpecialCode) {
    		this.code = code;
    		this.SpecialCode = SpecialCode;
    	}
    	
    	public String getformatting(Formatting format) {
        	String chatcode = "§" + format.code;
        	return chatcode;
    	}
	}
}

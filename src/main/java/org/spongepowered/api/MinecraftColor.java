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
    private final String SpecialCode;

    private MinecraftColor(char code, String SpecialCode) {
        this.code = code;
        this.SpecialCode = SpecialCode;
    }
    
    public String getChatcode(MinecraftColor color) {
    	String chatcode = "§" + color.code;
    	return chatcode;
    }

}


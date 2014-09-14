package org.spongepowered.api;

public class FormattedMessage {
	String formattedmessage;
	
	public FormattedMessage(String message, ChatFormat format) {
		String newmessage = format.chatprefix + message;
		this.formattedmessage = newmessage;
		
	}
}

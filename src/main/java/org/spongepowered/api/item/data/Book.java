package org.spongepowered.api.item.data;

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.item.meta.BookGeneration;
import org.spongepowered.api.text.message.Message;

import java.util.List;


public interface Book {

    boolean hasBeenResolved();

    BookGeneration getGeneration();

    void setGeneration(BookGeneration generation);
    
    GameProfile getAuthor();
    
    void setAuthor(GameProfile profile);
    
    Message getTitle();
    
    void setTitle(Message title);
    
    List<Message> getPages();
    
    Message getPage(int page);
    
    void setPage(int page, Message text);

}

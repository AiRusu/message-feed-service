package maven.project.service;

import maven.project.model.MessageData;
import maven.project.model.MessageItem;

import java.util.List;

public interface MessageItemService {

    void addMessage (MessageItem toAdd);

    MessageItem getMessage (int id);

    List<MessageItem> getNewMessages (int maxAge);

    void updateMessage (MessageItem toUpdate);

    MessageData getData();
}

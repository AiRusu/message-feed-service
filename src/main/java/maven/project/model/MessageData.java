package maven.project.model;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.*;

public class MessageData {

    // == fields ==
    private static int idValue = 1;

    private final List<MessageItem> messageItems = new ArrayList<>();
    private final ListIterator<MessageItem> itemIterator = messageItems.listIterator();

    // == constructors ==
    public MessageData() {

        // add some dummy data, using the addMessage method so it sets the id field
        addMessage(new MessageItem("one message","Aida", "aida.rusu93@gmail.com", LocalDateTime.now(), LocalDateTime.now()));
    }

    // == public methods ==
    public List<MessageItem> getNewMessages(int maxAge) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime xMinutesBehind = now.minusMinutes(maxAge);

         for( int i =0; i<messageItems.size(); i++){
                MessageItem message = messageItems.get(i);

            if((message.getUpdated().equals(xMinutesBehind)) || (message.getUpdated().isAfter(xMinutesBehind)))
                messageItems.add(message);
        }
        return Collections.unmodifiableList(messageItems);
    }

    public void addMessage(@NonNull MessageItem toAdd) {

        toAdd.setId(idValue);
        messageItems.add(toAdd);
        idValue++;
    }

    public MessageItem getMessage(int id) {
        for(MessageItem message : messageItems) {
            if(message.getId() == id) {
                return message;
            }
        }
        return null;
    }

    public void updateMessage(@NonNull MessageItem toUpdate) {

        while(itemIterator.hasNext()) {
            MessageItem message = itemIterator.next();

            if(message.equals(toUpdate)) {
                message.setUpdated(LocalDateTime.now());
                itemIterator.set(toUpdate);
                break;
            }
        }
    }


}


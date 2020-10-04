package maven.project.service;

import lombok.Getter;
import maven.project.model.MessageData;
import maven.project.model.MessageItem;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Component
@Validated
@Service
public class MessageItemServiceImpl implements MessageItemService {

    // == fields ==
    @Getter
    private final MessageData data = new MessageData();

    // == public methods ==

    @Override
    public void addMessage(@Valid MessageItem toAdd) {
        data.addMessage(toAdd);
    }

    @Override
    public MessageItem getMessage(int id) {
        return data.getMessage(id);
    }

    @Override
    public List<MessageItem> getNewMessages(int maxAge) {
        return data.getNewMessages(maxAge);
    }

    @Override
    public void updateMessage(@Valid MessageItem toUpdate) {
        data.updateMessage(toUpdate);
    }
}

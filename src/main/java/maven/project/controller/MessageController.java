package maven.project.controller;

import lombok.extern.slf4j.Slf4j;
import maven.project.model.MessageData;
import maven.project.model.MessageItem;
import maven.project.service.MessageItemService;
import maven.project.util.AttributeNames;
import maven.project.util.Mappings;
import maven.project.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class MessageController {

    // == fields ==
    private final MessageItemService messageItemService;

    // == constructors ==
    @Autowired
    public MessageController (MessageItemService messageItemService) {
        this.messageItemService = messageItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public MessageData messageData() {
        return messageItemService.getData();
    }

    // == handler methods ==
    // http://localhost:9981/message-feed-service/messages
    @GetMapping(Mappings.MESSAGES)
    public String items(@RequestParam(value = "maxAge", required = false) final Integer maxAge) {
        List<MessageItem> messageItems = messageItemService.getNewMessages(maxAge);
        return ViewNames.MESSAGES_LIST;
    }

    @RequestMapping(value = Mappings.ADD_MESSAGE, method = {RequestMethod.POST} )
    public String processItem(@Valid @ModelAttribute(AttributeNames.MESSAGE_ITEM) MessageItem messageItem) {
        log.info("MessageItem from  = {}", messageItem);
        messageItemService.addMessage(messageItem);
        return "redirect:/" + Mappings.MESSAGES;
    }

    @PutMapping(Mappings.MESSAGES)
    public String EditItem(@Valid @RequestParam int id, Model model) {

        log.info("editing id = {}", id);
        MessageItem messageItem = messageItemService.getMessage(id);
        model.addAttribute(AttributeNames.MESSAGE_ITEM, messageItem);
        return ViewNames.ADD_MESSAGE;
    }
}


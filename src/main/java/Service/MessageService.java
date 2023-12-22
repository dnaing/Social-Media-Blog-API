package Service;

import DAO.MessageDAO;

import java.util.List;

import DAO.AccountDAO;
import Model.Message;

public class MessageService {
    
    private MessageDAO messageDAO;
    private AccountDAO accountDAO;

    public MessageService() {
        this.messageDAO = new MessageDAO();
        this.accountDAO = new AccountDAO(); 
    }

    public Message createMessage(Message message) {
        if (
            message.getMessage_text().length() == 0 ||
            message.getMessage_text().length() >= 255 ||
            accountDAO.getAccountByID(message.getPosted_by()) == null
        ) {
            return null;
        }
        return messageDAO.createMessage(message);
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageByID(String id) {
        return messageDAO.getMessageByID(id);
    }

    public Message deleteMessageByID(String id) {
        Message messageToDelete = getMessageByID(id);
        if (messageToDelete == null) {
            return null;
        }
        messageDAO.deleteMessageByID(id);
        return messageToDelete;
    }

    public Message updateMessageByID(String id, String messageText) {
        
        if (
            messageText.length() == 0 ||
            messageText.length() > 255 ||
            getMessageByID(id) == null
        ) {
            return null;
        }
        messageDAO.updateMessageByID(id, messageText);
        return messageDAO.getMessageByID(id);
        // return new Message(0,"Hi",0);
    }

    public List<Message> getAllMessagesForAccount(String accountId) {
        return messageDAO.getAllMessagesForAccount(accountId);
    }

}

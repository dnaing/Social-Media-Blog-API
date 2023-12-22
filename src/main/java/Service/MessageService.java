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

}

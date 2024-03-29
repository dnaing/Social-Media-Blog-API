package Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;
import io.javalin.Javalin;
import io.javalin.http.Context;


public class SocialMediaController {

    private ObjectMapper mapper;
    private AccountService accountService;
    private MessageService messageService;

    public SocialMediaController() {
        this.mapper = new ObjectMapper();
        this.accountService = new AccountService();
        this.messageService = new MessageService();
    }

    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();

        app.post("/register", this::userRegistrationHandler);
        app.post("/login", this::verifyLoginHandler);
        app.post("/messages", this::createMessageHandler);
        app.get("messages", this::getAllMessagesHandler);
        app.get("/messages/{message_id}", this::getMessageByIDHandler);
        app.delete("/messages/{message_id}", this::deleteMessageByIDHandler);
        app.patch("/messages/{message_id}", this::updateMessageByIDHandler);
        app.get("/accounts/{account_id}/messages", this::getAllMessagesForAccount);

        return app;
    }

    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     * @throws JsonProcessingException
     * @throws JsonMappingException
     */
    private void userRegistrationHandler(Context context) throws JsonProcessingException {
        Account account = mapper.readValue(context.body(), Account.class);
        Account registeredAccount = accountService.registerAccount(account);
        if (registeredAccount == null) {
            context.status(400);
        } else {
            context.json(registeredAccount);
            context.status(200);
        }
    }

    private void verifyLoginHandler(Context context) throws JsonProcessingException {
        Account account = mapper.readValue(context.body(), Account.class);
        Account retrievedAccount = accountService.getAccountByUserAndPass(account.getUsername(), account.getPassword());
        if (retrievedAccount == null) {
            context.status(401);
        } else {
            context.json(retrievedAccount);
            context.status(200);
        }
    }

    private void createMessageHandler(Context context) throws JsonProcessingException {
        Message message = mapper.readValue(context.body(), Message.class);
        Message createdMessage = messageService.createMessage(message);
        if (createdMessage == null) {
            context.status(400);
        } else {
            context.json(createdMessage);
            context.status(200);
        }
    }

    private void getAllMessagesHandler(Context context) throws JsonProcessingException {
        context.json(messageService.getAllMessages());
        context.status(200);
    }

    private void getMessageByIDHandler (Context context) throws JsonProcessingException {
        String id = context.pathParam("message_id");
        Message message = messageService.getMessageByID(id);
        if (message != null) {
            context.json(messageService.getMessageByID(id));
        }
        context.status(200);
    }

    private void deleteMessageByIDHandler (Context context) throws JsonProcessingException {
        String id = context.pathParam("message_id");
        Message deletedMessage = messageService.deleteMessageByID(id);
        if (deletedMessage != null) {
            context.json(deletedMessage);
        }
        context.status(200);
    }

    private void updateMessageByIDHandler (Context context) throws JsonProcessingException {
        String id = context.pathParam("message_id");
        Message message = mapper.readValue(context.body(), Message.class);
        String messageText = message.getMessage_text();
        Message updatedMessage = messageService.updateMessageByID(id, messageText);
        if (updatedMessage == null) {
            context.status(400);
        } else {
            context.json(updatedMessage);
            context.status(200);
        }   
    }

    private void getAllMessagesForAccount (Context context) throws JsonProcessingException {
        String accountId = context.pathParam("account_id");
        context.json(messageService.getAllMessagesForAccount(accountId));
        context.status(200);  
    }
}
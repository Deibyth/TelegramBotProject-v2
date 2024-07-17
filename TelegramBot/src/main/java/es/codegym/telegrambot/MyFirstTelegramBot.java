package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "Deiby7hCodeChat_bot";
    public static final String TOKEN = "7344956626:AAGYSD9IY0HgK2mIOAGxN7iE6RheC4wwzlY";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        //Funcionalidad principal del bot aquí

        if(getMessageText().equals("/start")){
            sendTextMessageAsync("*Hola* _developer_!", null);
        }

        
        if(getMessageText().contains("hola")){
            sendTextMessageAsync("Hola!, cual es tu nombre?!", null);
        }

        if(getMessageText().contains("me llamo")){
            sendTextMessageAsync("Encantado de conocerte, soy Gato", null);
        }
        
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}
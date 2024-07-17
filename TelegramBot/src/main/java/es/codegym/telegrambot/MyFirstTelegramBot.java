package es.codegym.telegrambot;


import java.util.Map;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import static es.codegym.telegrambot.TelegramBotContent.STEP_1_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_2_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_3_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_4_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_5_TEXT;

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
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
                Map.of("Hackear la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT, 
            Map.of("Tomar una salchicha! +20 de fama", "step_2_btn",
                    "Tomar un pescado! +20 de fama", "step_2_btn",
                    "Tomar una lata de pepino! +20 de fama", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT, 
            Map.of("Hackear el robot aspiradora!", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT, 
            Map.of("Enviar al robot por comida! +30 de fama", "step_4_btn",
                    "Dar un paseo al robot! +30 de fama", "step_4_btn",
                    "Huye del robot! +30 de fama", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT, Map.of());
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
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
import static es.codegym.telegrambot.TelegramBotContent.STEP_6_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_7_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.STEP_8_TEXT;
import static es.codegym.telegrambot.TelegramBotContent.FINAL_TEXT;



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
            
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                Map.of("Hackear la nevera", "step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            setUserGlory(20);

            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT, 
                Map.of("Tomar una salchicha! +20 de fama", "step_2_btn",
                    "Tomar un pescado! +20 de fama", "step_2_btn",
                    "Tomar una lata de pepino! +20 de fama", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            setUserGlory(20);

            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, 
                Map.of("Hackear el robot aspiradora!", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            setUserGlory(30);

            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT, 
                Map.of("Enviar al robot por comida! +30 de fama", "step_4_btn",
                    "Dar un paseo al robot! +30 de fama", "step_4_btn",
                    "Huye del robot! +30 de fama", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            setUserGlory(30);

            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, 
                Map.of("Encender y ponerse la GoPro", "step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(40);

            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                Map.of("Correo a los tejados y graba con la GoPro! +40 de fama", "step_6_btn",
                    "Ataca a otros gatos desde tu escondite con la GoPro! +40 de fama", "step_6_btn",
                    "Ataca a los perros desde tu escondite con la GoPro! +40 de fama", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(40);

            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                Map.of("Romper la contraseña", "step_7_btn"));
        }
        
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(50);

            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                Map.of("Salir al partio", "step_8_btn"));            
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            setUserGlory(50);
            sendTextMessageAsync(FINAL_TEXT);
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
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class NasaBot extends TelegramLongPollingBot {

    String url = "https://api.nasa.gov/planetary/apod?api_key=qjQhhnL9g0XjBw2T6MjERGafgM6IJ8JVfApe3SbX";
    String botUserName;
    String botToken;

    /**
     * Constructor for NasaBot.
     *
     * @param botUserName the username of the bot
     * @param botToken    the token of the bot
     * @throws TelegramApiException if there is an error with the Telegram API
     */
    public NasaBot(String botUserName, String botToken) throws TelegramApiException {
        this.botUserName = botUserName;
        this.botToken = botToken;
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }




    /**
     * Processes updates from Telegram.
     *
     * @param update the update to be processed
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();
            String[] splitedText = text.split(" ");
            String option = splitedText[0];
            switch (option) {
                case "/start":
                    sendMessage(chatId, "Hello! Please enter /image to get a picture from NASA");
                    break;
                case "/help":
                    sendMessage(chatId, "Please enter /image to get a picture from NASA or /date YYYY-MM-DD to get a picture from NASA for a specific date");
                    break;
                case "/image":
                    String image = Utils.getImage(url);
                    sendMessage(chatId, image);
                    break;
                case "/date":
                    String date = splitedText[1];
                    image = Utils.getImage(url + "&date=" + date);
                    sendMessage(chatId, image);
                    break;
                default:
                    sendMessage(chatId, "Bad command");
            }
        }
    }




    /**
     * Sends a message to the specified chat.
     *
     * @param chatId the identifier of the chat
     * @param text   the text of the message
     */
    void sendMessage(long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    /**
     * Returns the username of the bot.
     *
     * @return the username of the bot
     */
    @Override
    public String getBotUsername() {
        return botUserName;
    }



    @Override
    public String getBotToken() {
        return botToken;
    }

}


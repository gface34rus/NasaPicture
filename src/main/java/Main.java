import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, TelegramApiException {
        NasaBot bot = new NasaBot("MyNasaPictureBot",
                "7563275308:AAE7qP4v-37-hhJtwmPVCgF8QoNFmxYnKJA");
    }
}
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    //this is my own bot's username on telegram
    @Override
    public String getBotUsername() {
        return "salehonline_bot";
    }

    //this is my own telegram token
    @Override
    public String getBotToken() {
        return "1735480375:AAE4MvYGuQLXV365CgFFNrTmevDKI73PBI4";
    }

    //this is my command lines
    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        String name = update.getMessage().getFrom().getFirstName();
        String lastname = update.getMessage().getFrom().getLastName();
        SendMessage message = new SendMessage();

        if (command.equals("/name")){
            System.out.println(name);//output for intellij
            message.setText(name);//answer me on chat for telegram
        }
        else if (command.equals("/lastname")){
            System.out.println(lastname);//output for intellij
            message.setText(lastname);//answer me on chat for telegram
        }
        else if (command.equals("/fullname")){
            System.out.println(name+" "+lastname); //output for intellij
            message.setText(name+" "+lastname); //answer me on chat for telegram
        }
        //this code shows telegram's answer on telegram
        message.setChatId(String.valueOf(update.getMessage().getChatId()));

        //this is answer for me on TELEGRAM CHAT when use above commands
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

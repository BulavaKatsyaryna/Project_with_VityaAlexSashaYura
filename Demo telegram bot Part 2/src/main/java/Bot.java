import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());

        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());       //Чат на который будем отвечать.
        sendMessage.setReplyToMessageId(message.getMessageId());     //Сообщение, на которое будем отвечать.
        sendMessage.setText(text);
        try{
            setButtons(sendMessage);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


//Метод для обновления сообщений, ответов и всякой залупы
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if(message !=null && message.hasText()){
            switch (message.getText()){
                case "Старт":
                    sendMsg(message, "Привет, я проведу тебя по гастрономическому Минску, скажи какое блюдо ты хочешь, и мы его найдем!");
                    break;
                case "Помощь":
                    sendMsg(message, "Напиши название блюда (Стейк, солянка, пельмени?). \n" +
                            "Только пиши правильно, без ошибок, и я постараюсь отыскать именно то, что ты хочешь!");
                            break;
                case "Настройки":
                    sendMsg(message, "Что будем настраивать?");
                    break;
                case "О проекте:":
                    sendMsg(message, "Сделали этот чудесный бот пятеро таких же чудесных людей(Е, В, А, О, Ю). \n" +
                            "Мы не собираемся останавливаться на достигнутом. \n" +
                            "Скоро мы сможем выдавать заведения отталкиваясь от твоего местоположения и отмечать их на карте, вызывать такси, показывать фотографии блюд и многое другое.");
                    break;

                case "Солянка":
                    sendMsg(message, "Кафе Скиф. \n" +
                            "Пр-т Независимости, 34. \n" +
                            "\n" +
                            "Солянка мясная 250/60/40. \n" +
                            "Цена: 7р.");
                    sendMsg(message, "Ресторан У Барысыча. \n" +
                            "Ул. П.Бровки, 12. \n" +
                            "\n" +
                            "Солянка сборная мясная 300/25. \n" +
                            "Цена: 6р.");
                    sendMsg(message, "Кафе Комедия. \n" +
                            "Пр-т Независимости, 117. \n" +
                            "\n" +
                            "Солянка «Домашняя» 250/45/15/2. \n" +
                            "Цена: 8р.");
                    sendMsg(message, "Ресто-бар У холостяка. \n" +
                            "Пр-т Независимости, 78. \n" +
                            "\n" +
                            "Солянка сборная мясная 300/10/2/30. \n" +
                            "Цена: 7р.");
                    break;

                case "Стейк":
                    sendMsg(message, "Амстердам ТЦ Замок. \n" +
                            "Пр-т Победителей, 65. \n" +
                            "\n" +
                            "Стейк из говядины 170/20/10. \n" +
                            "Цена: 24,20 р.");
                    sendMsg(message, "Кафе Берёзка. \n" +
                            "Пр-т Независимости, 40. \n" +
                            "\n" +
                            "Стейк-рибай с перечным соусом 520. \n" +
                            "Цена: 45р.");
                    sendMsg(message, "Кафе ПабЕда. \n" +
                            "Пр-т газеты Правда 40/1. \n" +
                            "\n" +
                            "Стейк из куриного филе с соусом «Дор-блю» и картофелем «По‑деревенски» 150/100/50. \n" +
                            "Цена: 14р. \n" +
                            "\n" +
                            "Стейк «Миньон» с соусом «Деми гласс» и овощным гратеном 200/150/50. \n" +
                            "Цена: 24р.");
                    sendMsg(message, "Ресторан Свои. \n" +
                            "Пр-т Независимости, 22. \n" +
                            "\n" +
                            "Стейк из говядины 200/50/50/1. \n" +
                            "Цена: 25.90р. \n" +
                            "\n" +
                            "Стейк из лосося 120/110/2. \n" +
                            "Цена: 25.90р.");
                    break;

                case "Пельмени":
                    sendMsg(message, "Амстердам ТЦ Замок. \n" +
                            "Пр-т Победителей, 65. \n" +
                            "\n" +
                            "Пельмени в соусе 310. \n" +
                            "Цена: 6.50р.");
                    sendMsg(message, "Кафе Аўстэрыя Уршуля. \n" +
                            "Ул. Энгельса, 7. \n" +
                            "\n" +
                            "Пельмени с говядиной 230/20. \n" +
                            "Цена: 8р. \n" +
                            "\n" +
                            "Пельмени с говядиной и свининой 230/20. \n" +
                            "Цена: 8р.");
                    sendMsg(message, "Кальянная NUAHULE. \n" +
                            "Ул. Красная, 12. \n" +
                            "\n" +
                            "Пельмени домашние жареные 200/50. \n" +
                            "Цена: 12р. \n" +
                            "\n" +
                            "Пельмени домашние отварные 300/45. \n" +
                            "Цена: 12р.");
                    break;

                case "Карпаччо":
                    sendMsg(message, "Кафе-бар Время. \n" +
                            "Ул. Могилевская, 39а. \n" +
                            "\n" +
                            "Карпаччо из говядины  100/20/10/10. \n" +
                            "Цена: 15р. \n" +
                            "\n" +
                            "Карпаччо из лосося 100/20/10/10. \n" +
                            "Цена: 17р.");
                    sendMsg(message, "Кафе У Янки. \n" +
                            "Ул. К. Маркса, 21. \n" +
                            "\n" +
                            "Карпаччо «Браво» 200. \n" +
                            "Цена: 9.50р.");
                    sendMsg(message, "Ресто-бар У холостяка. \n" +
                            "Пр-т Независимости, 78. \n" +
                            "\n" +
                            "Карпаччо из говяжьей вырезки 100/20/30/. \n" +
                            "Цена: 17.90р.");
                    break;

                case "Драники":
                    sendMsg(message, "Кафе-бар Время. \n" +
                            "Ул. Могилевская, 39а. \n" +
                            "\n" +
                            "Драники с курицей 150/130. \n" +
                            "Цена: 11р.");
                    sendMsg(message, "Паб 1067. \n" +
                            "Ул. Володарского, 22. \n" +
                            "\n" +
                            "Дранiкi са смажанымi вушамi i яйкамi 380. \n" +
                            "Цена: 7.30р. \n" +
                            "\n" +
                            "Дранiкi з ялавiчнымi шчокамi i яйкамi 400. \n" +
                            "Цена: 8.50р. \n" +
                            "\n" +
                            "Дранiкi з шампiньёнамi i яйкамi 380. \n" +
                            "Цена: 7.30р.");
                    sendMsg(message, "Ресторан Свои. \n" +
                            "Пр-т Независимости, 22. \n" +
                            "\n" +
                            "Драники с лососем 200/100/30. \n" +
                            "Цена: 12.90р. \n" +
                            "\n" +
                            "Драники с грибами в сметанном соусе 200/140/15/3. \n" +
                            "Цена: 10р.");
                    sendMsg(message, "Мята Lounge. \n" +
                            "Ул. Революционная, 10. \n" +
                            "\n" +
                            "Драники с копчёным лососем и сметаной 180/50/40/2. \n" +
                            "Цена: 15р.");
                    sendMsg(message, "Амстердам ТЦ Замок. \n" +
                            "Пр-т Победителей, 65. \n" +
                            "\n" +
                            "Драник запечённый с птицей и грибами 250/65/5. \n" +
                            "Цена: 8.10р");

                    break;

                default:
            }
        }
    }

//Кнопащки на клаве делаем
    public void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();        //Создаем клавиатуру
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);                  //Параметр, который выводит клаву определенным пользователям или всем, на выбор
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);           //Скрывать клавиатуру или нет(поставили нет)

//Создаем кнопки
        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow keyboardRowFirstRow = new KeyboardRow();                 //Инициализация строки
        keyboardRowFirstRow.add(new KeyboardButton("Старт"));           //Создаем первую строку

        KeyboardRow keyboardRowSecondRow = new KeyboardRow();
        keyboardRowSecondRow.add(new KeyboardButton("Помощь"));
        keyboardRowSecondRow.add(new KeyboardButton("Настройки"));

        KeyboardRow keyboardRowThirdRow = new KeyboardRow();
        keyboardRowThirdRow.add(new KeyboardButton("О проекте:"));

        keyboardRowList.add(keyboardRowFirstRow);        //Добавляем строки клавы в список
        keyboardRowList.add(keyboardRowSecondRow);       //Добавляем строки клавы в список
        keyboardRowList.add(keyboardRowThirdRow);        //Добавляем строки клавы в список
        replyKeyboardMarkup.setKeyboard(keyboardRowList);       //Устанавливаем список на клавиатуру

    }

    @Override
    public String getBotUsername() {
        return "HW_KateBulova_Bot";
    }

    @Override
    public String getBotToken() {
        return "1537025339:AAEkLWge9lc_d87S8aGaVxl-SgzENSiYe6A";
    }
}

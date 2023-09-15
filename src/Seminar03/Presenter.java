package Seminar03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Presenter {

    Contact contact;
    View contactView;
    private final int COUNT_FIELDS = 6;

    private final String SPLIT_SYMBOL = " ";
    String[] exceptionString = {
            "Количество введенных полей равно требуемому",
            "Количество введенных полей меньше требуемого",
            "Количество введенных полей больше требуемого"
    };

    public Presenter(Contact contact, View contactView) {
        this.contact = contact;
        this.contactView = contactView;
    }

    public void run() {
        String inputData = contactView.inputData("Введите данные");
        if (inputData.length() == 0 ) {
            throw new RuntimeException("Данные не введены");
        }
        String[] data = inputData.split(SPLIT_SYMBOL);
        int response = checkCorrectCountDataFields(data);
        if (response != 0) {
            throw new RuntimeException(exceptionString[response]);
        }
        Contact contact1 = parseInputData(data);
    }

    private Contact parseInputData(String[] data) {
        //
        int countFlags = 0;
        int localPhoneNumber = 0;
        Sex localSex;
        String localName = "";
        String localLastName = "";
        String localSurName = "";
        Date localDateBirthDay;
        Contact newContact = new Contact();
        int index = findIndexPhoneNumber(data);
        if ( index == -1) {
            throw new RuntimeException("В веденной строке телефонный номер не найден");
        } else {
            localPhoneNumber = Integer.parseInt(data[index]);
        }
//            if (data[i].equalsIgnoreCase("m") && data[i].equalsIgnoreCase("f")) {
//                localSex = data[i].equalsIgnoreCase("m") ? Sex.m : Sex.f;
//                countFlags++;
//            }
//
        return newContact;
    }

    private int findIndexPhoneNumber(String[] array) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (checkNumber(array[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    private Date findBirthDay(String[] array) {
        Pattern pattern = Pattern.compile("(?:0?[1-9]|[12][0-9]|3[01])([- /.])(?:0?[1-9]|1[012])\\\\1(?:19|20)?\\\\d\\\\d");
        Matcher matcher;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            matcher = pattern.matcher(array[i]);
            if (matcher.find()) {
                index = i;
                break;
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date d = formatter.parse(array[index]);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    private boolean checkNumber(String data) {
        try {
            int number = Integer.parseInt(data);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    private int  checkCorrectCountDataFields(String[] data) {
        Integer returnCode = 0; // Код успешной проверки количества
        String outputString = "Количество введенных полей равно требуемому";
        if (data.length < COUNT_FIELDS) {
            returnCode = 1;
        } else if ( data.length > COUNT_FIELDS) {
            returnCode = 2;
        }
        return returnCode;
    }
}

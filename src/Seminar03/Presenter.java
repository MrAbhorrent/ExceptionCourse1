package Seminar03;

import kotlin.Pair;

public class Presenter {

    Contact contact;
    View contactView;
    private final int COUNT_FIELDS = 6;

    private final String SPLIT_SYMBOL = " ";

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
        Pair<Integer, String> responce = checkCorrectCountDataFields(data);
        if (responce.getFirst() != 0) {
            throw new RuntimeException(responce.getSecond());
        }
        Contact contact1 = parseInputData(data);
    }

    private Contact parseInputData(String[] data) {
        //
        int countFlags = 0;
        int localPhoneNumber = 0;
        Sex localSex;
        Contact newContact = new Contact();
        for (int i = 0; i < data.length; i++) {
            if (checkNumber(data[i])) {
                localPhoneNumber = Integer.parseInt(data[i]);
                countFlags++;
            }
            if (data[i].equalsIgnoreCase("m") && data[i].equalsIgnoreCase("f")) {
                localSex = data[i].equalsIgnoreCase("m") ? Sex.m : Sex.f;
                countFlags++;
            }

        }
        return newContact;
    }

    private boolean checkNumber(String data) {
        try {
            int number = Integer.parseInt(data);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    private Pair<Integer, String> checkCorrectCountDataFields(String[] data) {
        Integer returnCode = 0; // Код успешной проверки количества
        String outputString = "Количество введенных полей равно требуемому";
        if (data.length < COUNT_FIELDS) {
            outputString = "Количество введенных полей меньше требуемого";
        } else if ( data.length > COUNT_FIELDS) {
            outputString = "Количество введенных полей больше требуемого";
        } else {
            returnCode = 1;
        }
        return new Pair<>(returnCode, outputString);
    }
}

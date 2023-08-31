package Seminar02;

import java.util.Scanner;

public class Task04 {

    public static void main(String[] args) {

        System.out.println("Задание 4.");
        String outputString = null;
        try {
            outputString = inputString();
        } catch (CheckStringException checkStringException) {
            checkStringException.getMessage();
        }
        System.out.println("Введенная строка: \n" + outputString);
    }

    private static String inputString() throws CheckStringException {

        String welcomeString = "Введите строку: ";
        String textRED = "\u001B[31m";
        String textRESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);
        System.out.print(welcomeString);
        String resultStr = scanner.nextLine();
        if (resultStr.length() == 0 ) {
            throw new CheckStringException(textRED + "Пустые строки вводить нельзя" + textRESET);
        }
        return resultStr;
    }
}

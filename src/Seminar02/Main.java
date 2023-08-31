package Seminar02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

//    1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
//       Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
//    2. Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//    3. Дан следующий код, исправьте его там, где требуется (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//    4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.



    public static void main(String[] args) {
        String divider = "==================================";
        System.out.println("Part 1.");
        Float getFloat = inputFloat();
        System.out.printf("Введено число %f%n", getFloat);
        System.out.println(divider);
        System.out.println("Part 2.");
        task2();
    }


    private static float inputFloat() {
        String welcomeString = "Введите дробное число: ";
        String textRED = "\u001B[31m";
        String textRESET = "\u001B[0m";
        float result;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(welcomeString);
                String resultStr = scanner.nextLine();
                result = Float.parseFloat(resultStr);
                break;
            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println(textRED + "Ошибка преобразования в число" + textRESET);
            }
        }
        return result;
    }

    private static void task2() {
        try {
            // добавлена инициализация массива целых чисел
            int[] intArray = {1,2,3,4,5,6,7,8,8};
            int d = 0;
            // Добавлено приведение результата операции деления к целомц числу
            double catchedRes1 = (double) intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }


}

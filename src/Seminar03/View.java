package Seminar03;

import java.util.Scanner;

public class View{
    
    Scanner scanner = new Scanner(System.in);

    // Запрашиваем данные
    public String inputData(String message) {
        System.out.printf("%s: ", message);
        return scanner.nextLine();
    }

    // Вывод данных
    public void print(String message, String data) {
        System.out.printf("%s - %s", data);
    }

}

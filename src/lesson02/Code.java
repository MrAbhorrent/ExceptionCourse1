package lesson02;

import java.io.*;

public class Code {

    public static void main(String[] args) {
        ex4();
    }

    private static void ex4() {
        //InputStream inputStream;
        try (InputStream inputStream = new FileInputStream("dfgdg")) {
            String[] strings = {"abc", "agg"};
            String strings1 = strings[2];
            test();
            int a = 1 / 0;
        } catch (ArithmeticException exception) {
            System.out.println("Ошибка в арифметическом выражении");
            exception.printStackTrace();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Выход за границу массива");
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            System.out.println("Я все равно выполнился!");
        }
        System.out.println("Я жив!");
    }

    private static void test() throws IOException {
        File file = new File("file");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        //test();
    }
}
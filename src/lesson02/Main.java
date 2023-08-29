package lesson02;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    static String fileName = "src/lesson02/list.txt";
    static String fileName2 =  "src/lesson02/list_new.txt";
    static HashMap<String, Integer>  hashMap ;

    public static void main(String[] args) {
        hashMap = new LinkedHashMap<>();
        readFile(fileName);
        saveFile(fileName2);
    }

    private static void readFile(String file) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            int countLine = 0;
            while ((line = br.readLine()) != null) {
                countLine++;
                String[] temp = line.split("=");
                checkLength(temp, countLine);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void checkLength(String[] str, int count) {
        try {
            if (str.length == 2) {
                if (str[1].equals("?")) {
                    hashMap.put(str[0], str[0].length());
                } else {
                    hashMap.put(str[0], Integer.parseInt(str[1]));
                }
            } else throw new IllegalArgumentException("Неправильные данные");
        } catch (NumberFormatException ex) {
            System.err.printf("В строке %d с значением %s неверный формат%n", count, str[0]);
        } catch (IllegalArgumentException exception) {
            System.err.printf("В строка %s имеет неверный формат%n", count);
        }
    }

    private static void saveFile(String file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String key : hashMap.keySet()) {
                bufferedWriter.write(String.format("%s=%s%n", key, hashMap.get(key)));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

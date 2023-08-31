package Seminar02;

public class Task03 {

    // Пробрасывать возниющие исключения на вверх излишне
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }
        // Для данного кода обработка исключения NullPointerException излишне, поскольку
        // все используемые переменные инициализированы
        catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
        // Данный catch перенесен последним, поскольку он является более глобальным
        // При использовании Throwable мы перехватываем и Error, и Exception.
        // Это применимо не во всех случаях. Чаще пишут Exception
        catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    // В данном методе никогда не возникнет исключение FileNotFoundException, поскольку в методе нет работы
    // с файламм
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}

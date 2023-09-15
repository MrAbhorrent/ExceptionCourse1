package lesson01;


public class CheckArrayException extends Exception{
    public CheckArrayException(String msg) {
        super(msg);
    }

    public CheckArrayException(int arrayLength1, int arrayLength2) {
        super(String.format("Длина первого массива [%s] не равна длине второго массива [%s]", arrayLength1, arrayLength2));

    }
}
package Sem3.Task3_5;

public class SizeException extends IndexOutOfBoundsException {
    public SizeException() {
        super("Массив должен быть 3х3");
    }
}

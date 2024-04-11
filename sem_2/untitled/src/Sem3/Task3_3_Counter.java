package Sem3;

import java.io.IOException;

/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 * внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 * можно было работать в блоке try-with-resources. Подумайте, что должно происходить
 * при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 * При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */
public class Task3_3_Counter implements AutoCloseable {
    public int coun = 0;
    private boolean closed = false;

    public void add() throws IOException {
        if(closed) throw new IOException("Ресурс закрыт");
        coun++;
    }

    @Override
    public void close() throws Exception {
        closed = true;
    }
}

class Main{
    public static void main(String[] args) {
        Task3_3_Counter counter = new Task3_3_Counter();
        try(counter){
            System.out.println(counter.coun);
            counter.add();
            counter.add();
            counter.add();
            System.out.println(counter.coun);
        }
        catch (Exception e){
            e.getMessage();
        }
//        try {
//            counter.add();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}

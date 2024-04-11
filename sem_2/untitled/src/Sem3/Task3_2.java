package Sem3;

/**
 * Создайте метод doSomething(), который может быть источником одного
 * из типов checked exceptions(тело самого метода прописывать не обязательно).
 * Вызовите этот метод из main и обработайте в нем исключение, которое вызвал
 * метод doSomething().
 */
public class Task3_2 {

    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void doSomething() throws Exception {

    }
}



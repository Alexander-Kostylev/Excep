package Sem3.Task3_4;
/**
 * Задание 3.2
 * Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл.
 * Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */
public class NonExistedFileException extends Exception {
    public NonExistedFileException(String message) {
        super(message);
    }
}

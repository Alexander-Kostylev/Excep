package task_2;

/*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения: метод может работать только с
квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об
ошибке.
 */
public class Main {

    public static void main(String[] args) {
        int[][] matr ={{1, 0}, {0, 0}, {1, 1}};

        checMatrix(matr);
    }

    public static void checMatrix(int[][] matrix) {
        int sum = 0;
        if (matrix == null) throw new RuntimeException("Пустой массив");
        if (matrix.length != matrix[0].length)
            throw new RuntimeException("Количество строк не совпадает количеством столбцов");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1) throw new RuntimeException("Элемент отличен от 0 или 1");
                sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }
}



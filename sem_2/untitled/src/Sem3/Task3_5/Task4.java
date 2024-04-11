package Sem3.Task3_5;

import java.util.HashMap;
import java.util.Map;

/**
 * Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 1. Далее метод должен пройтись по всем элементам массива, преобразовать в число и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 * с детализацией, в какой именно ячейке лежат неверные данные.
 * <p>
 * 2. В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета
 * (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task4 {
    /**
     *
     */
    static String[][] arr = new String[][]{
            {"uti", "1.5", "1.5"},
            {"1", "qwe", "1.5"},
            {"1", "ggf", "1.5"}
    };

    public static void main(String[] args) {
        System.out.println(sum2DV2(arr));
    }

    /**
     * @exception DataException
     * @param arr
     * @return
     */
    public static double sum2d(String[][] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr.length != arr[i].length) throw new SizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Double.parseDouble(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new DataException (i, j);
                }
            }
        }
        return sum;
    }

    public static double sum2DV2(String[][] arr) {
        double sum = 0;
        Map<Point2D, String> map = new HashMap<Point2D, String>();
        for (int i = 0; i < arr.length; i++) {
            if(arr.length != arr[i].length) throw new SizeException();
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Double.parseDouble(arr[i][j]);
                }catch (NumberFormatException e){
                    map.put(new Point2D(i,j), arr[i][j]);
                }
            }
        }
        if(!map.isEmpty()) throw new DataException(map);
        return sum;
    }
}

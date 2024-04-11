package task_1;

/*
1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в
качестве кода ошибки.
2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
3. если вместо массива пришел null, метод вернет -3
4. придумайте свои варианты исключительных ситуаций и верните соответствующие
коды ошибок.
 */

public class Main {
    public static void main(String[] args) {
        int[] array0 = {1, 56, 93, 5, 82, 6};
        printString(returnArray(array0, 10, 6));
        printString(returnArray(null, 10, 6));
        int[] array1 = {45, 82, 34, 97, 17, 3};
        printString(returnArray(array1, 4, 3));
        int[] array2 = {45, 82, 34, 97, 17, 3};
        printString(returnArray(array2, 6, 156));

    }

    public static void printString(int number) {
        if (number == -1)
            System.out.println("Длина массива меньше заданного минимума");
        else if (number == -2)
            System.out.println("Искомый элемент не найден");
        else if (number == -3)
            System.out.println("Массив пустой");
        else
            System.out.println(number);
    }

    public static int returnArray(int[] array, int minLenght, int num) {
        if (array == null) return -3;
        else if (array.length < minLenght) return -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) return i;
        }
        return -2;
    }
}


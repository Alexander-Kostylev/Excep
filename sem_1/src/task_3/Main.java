package task_3;

/*
Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента
целочисленный одномерный массив.
Метод должен пройтись по каждому элементу и проверить что он не равен null.
А теперь реализуйте следующую логику:
1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом
пользователя
2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их
“подсветить”
 */

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {34, 56, null, null};
        checkArray(arr);
        checkArray(null);
        Integer[] arr1 = {0, 1, null};
        checkArray(arr1);
    }

    public static void checkArray(Integer[] arr){
        if (arr == null)
            System.out.println("Массив пустой!");
        else{
            for (int i = 0; i < arr.length; i++){
                if (arr[i] == null){
                    System.out.println("Найдено значение null на индексе " + i);
                }
            }
        }
    }
}

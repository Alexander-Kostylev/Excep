package Sem2;

/**
 * Обработайте возможные исключительные ситуации. "Битые" значения
 * в исходном массиве считайте нулями. Можно внести в код правки,
 * которые считаете необходимыми
 */
public class Task2 {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "1"},
                {"1", "1", "1", "9", "1"},
                {"1", "8", "12"},
                {"3", "3"},
                {"2"}
        };

        System.out.println(sum2d(arr));
    }

    private static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isNotNumber(arr[i][j]))
                    throw new RuntimeException("Невалидные данные");
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

    private static boolean isNotNumber(String str) {
        try {
            Double.parseDouble(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
package Sem2;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Запишите в файл следующие строки:
 *
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Полина=?
 * Константин=?
 * Иван=4
 *
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap,
 * если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
 * если сохранено значение ?, заменить его на соответствующее число.Если на каком-то месте
 * встречается символ, отличный от числа или ?, бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?.
 */
public class Task3 {
    private static final List<String> strings = List.of
            ("Анна=4", "Елена=5", "Марина=6", "Полина=?",
                    "Владимир=?", "Константин=?", "Иван=4");
    //для проверки, заменить какое-то из значений на null

    public static void main(String[] args) {
        String path = "task3.txt";
        System.out.println(write(path, strings));
        rewrite(path);
    }

    private static boolean write(String path, List<String> strings) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (String string : strings) {
                fw.write(string + "\n");
            }
            fw.flush();
        } catch (IOException e) {
            return false;
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return true;
    }

    private static Map<String, Integer> analyze(String path) {
        Map<String, Integer> result = new HashMap<>(7);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("="); // ["Анна", "4"]
                String key = arr[0];
                String temp = arr[1];
                int val;
                if (temp.equals("?")) val = key.length();
                else val = Integer.parseInt(temp);
                result.put(key, val);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return result;
    }

    private static void rewrite(String path) {
        Map<String, Integer> map = analyze(path);
        List<String> data = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            data.add(entry.toString());
        }
        write(path, data);
    }
}
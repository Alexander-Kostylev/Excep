package Sem3.Task3_4;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestTask1 {
    public static void main(String[] args) {
//        System.out.println(devide(4, 0));
            fileNotFinde("test.txt");
    }

    public static double devide(int a, int b) {
//        try {
//            return a / b;
//        } catch (ArithmeticException e) {
//            throw new DivideByZeroException();
//        }
        if(b == 0) throw new DivideByZeroException();
        return a / b;
    }

//    public static void fileNotFinde(String path) throws NonExistedFileException{
//        try {
//            FileReader fr = new FileReader(path);
//        } catch (FileNotFoundException e) {
//            throw new NonExistedFileException("Файл не найден");
//        }
//    }

    public static void fileNotFinde(String path) {
        try {
            FileReader fr = new FileReader(path);
        } catch (FileNotFoundException e) {
            try {
                throw new NonExistedFileException("Файл не найден");
            } catch (NonExistedFileException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

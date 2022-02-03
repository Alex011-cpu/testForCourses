package ru.mirea.task1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    public static int countOfDigits(String str) {

        char[] arr = str.toCharArray(); /*Массив чаров*/

        return IntStream.range(0, arr.length).
                filter(e -> Character.isDigit(arr[e])). /*проверка на цифру*/
                map(e -> Character.getNumericValue(arr[e])).sum(); /*преобразование в массив цифр и их сумма*/
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        System.out.println("Сумма цифр в строке: " + countOfDigits(scanner.nextLine()));
    }
}

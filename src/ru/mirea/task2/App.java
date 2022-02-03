package ru.mirea.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int num = in.nextInt();
            int i = 2;

            while (i <= Math.sqrt(num)) {
                if(num % i ==0){
                    System.out.print(i);
                    num = num / i;
                    if(num>1) System.out.print('*');
                } else i++;

            }
            if(num>1) System.out.print(num);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Вы ввели нецелое число");
        }
    }
}

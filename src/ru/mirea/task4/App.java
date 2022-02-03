package ru.mirea.task4;

import java.util.Scanner;

public class App {

    public static void printDigits(int[] dig) {

        int n = 5; /*Ширина цифры*/
        char[][] arr = new char[5][5 * dig.length + dig.length * 2];
        int shift = 0; /*сдвиг*/
        for (int e=0; e<dig.length; e++) {

            if (e!=0) {
                shift = 5 * e + e;
            }

            for (int i=0; i<n; i++) {
                for (int j=shift; j < n + shift; j++) {
                    switch (dig[e]) {
                        case 0:
                            if (i==0 || i==4 || (j==shift || j == 4 + shift)) arr[i][j]='*';
                            else arr[i][j]=' ';
                            break;
                        case 1:
                            if (j==2 + shift) arr[i][j]='*';
                            else if (i == 1 & (j == i + shift | j == i + shift + 1)) arr[i][j]='*';
                            else if (i == 2 & j == shift) arr[i][j]='*';
                            else if (i==4) arr[i][j]='*';
                            else arr[i][j]=' ';
                            break;
                        case 2:
                            if (i == 0 & j!= shift) arr[i][j] = '*';
                            else if (i == 1 & (j == shift | j == 3 + shift)) arr[i][j] = '*';
                            else if ((i == 2 & j == 2 + shift) | (i == 3 & j == 1 + shift) | i==4) arr[i][j] = '*';
                            else arr[i][j]=' ';
                            break;
                        case 3:
                            if (i==0 | (j==4 + shift & i!=2) | (i==2 & (j==2 +shift | j==3 + shift)) | i==4) arr[i][j] = '*';
                            else arr[i][j]=' ';
                            break;
                        case 4:
                            if (j==shift & i!=3 & i!=4 | i==2 | j==4 + shift) arr[i][j] = '*';
                            else arr[i][j]=' ';
                            break;
                        case 5:
                            if (i==0| i==4 | i==2 | i==1 & j== shift | i==3 & j==4 + shift) arr[i][j] = '*';
                            else arr[i][j]= ' ';
                            break;
                        case 6:
                            if (i==0 | i==2 | i==4 | j==shift | (j==4 + shift & i!=1)) arr[i][j] = '*';
                            else arr[i][j]= ' ';
                            break;
                        case 7:
                            if (i==0 | i+j==4+shift) arr[i][j] = '*';
                            else arr[i][j]= ' ';
                            break;
                        case 8:
                            if (i==0 | i==4 | i==2 & j!=shift & j!=4 + shift | (j==shift | j==4 + shift) & i!=2) arr[i][j] = '*';
                            else arr[i][j]= ' ';
                            break;
                        case 9:
                            if (i==0 | i==2 | i==4 | j==4 +shift | i==1 &j==shift) arr[i][j] = '*';
                            else arr[i][j]= ' ';
                            break;
                    }
                    if (j==n + shift - 1) {
                        arr[i][j+1]=' '; /*отступ после цифры*/
                    }
                }
            }
        }

        for (int i=0; i < 5;i++) {
            for (int j=0; j < 5 * dig.length + dig.length*2; j++) {
                System.out.print(arr[i][j]); /*вывод двумерного массива*/
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long digit = scanner.nextLong();
        int length = Long.toString(digit).length();
        int x;
        int[] digits = new int[length]; /*массив цифр*/
        for (int i=0; i < length; i++) {
            if (i==0) {
                x = (int) (digit/Math.pow(10, length - 1));
            } else if (i==length - 1) {
                x = (int) (digit%10);
            } else {
                x = (int) ((digit/Math.pow(10, length - 1 - i))%10);
            }
            digits[i] = x;
        }
        printDigits(digits);
    }
}
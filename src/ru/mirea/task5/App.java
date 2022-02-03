package ru.mirea.task5;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        int[] sizes = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int count = sizes.length;
        int maxSize = 21;

        int[][] A;
        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[maxSize + 1];
        }

        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= maxSize; s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= sizes[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - sizes[k - 1]] + prices[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(A, sizes, count, maxSize, result);

        System.out.println("Оптимальное содержимое сейфа:");
        for(Integer integer : result) {
            System.out.println("(size: " + sizes[integer - 1] + ", price: " + prices[integer - 1] + ")");
        }
    }

    private static void traceResult(int[][] A, int[] size, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k -1][s] == A[k][s]) {
            traceResult(A, size, k - 1, s, result);
        } else {
            traceResult(A, size, k - 1, s - size[k - 1], result);
            result.add(0, k);
        }
    }
}

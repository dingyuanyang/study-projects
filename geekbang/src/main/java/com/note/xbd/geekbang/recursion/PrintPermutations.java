package com.note.xbd.geekbang.recursion;

/**
 * 打印全排练
 *
 */
public class PrintPermutations {

    public void printPermutations(int[] arr, int n, int k) {
        if (k == 1) {
            for (int i : arr) {
                System.out.print(i + "\t");
            }
            System.out.println("");
        }
        for (int i = 0; i < k; i++) {
            int temp = arr[i];
            arr[i] = arr[k - 1];
            arr[k - 1] = temp;
            printPermutations(arr, n, k - 1);
            temp = arr[i];
            arr[i] = arr[k - 1];
            arr[k - 1] = temp;
        }
    }

    public static void main(String[] args) {
        PrintPermutations printPermutations = new PrintPermutations();
        int[] arr = {1, 2, 3, 4};
        printPermutations.printPermutations(arr, 4, 4);
    }
}

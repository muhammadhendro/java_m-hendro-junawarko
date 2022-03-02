import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        int n;

        int[] arr = { 5, 7, 4, -2, -1, 8 };
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                indexMax = i;
            }
            if (min == arr[i]) {
                indexMin = i;
            }
        }
        System.out.println("Min: " + min + " index: " + indexMin + " Max: " + max + " Index: " + indexMax);
    }

}

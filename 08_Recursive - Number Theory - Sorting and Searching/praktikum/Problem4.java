import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem4 {

    public static void main(String[] args) {
        int money = 50000;

        Integer[] arr = { 25000, 25000, 10000, 14000 };
        Arrays.sort(arr);

        
        int barang = 0;
        
        for (int n : arr) {
            money -= n;
            if (money >= 0) {
                barang++;
            }
            
        }
        System.out.println(barang);

    }

}


import java.util.ArrayList;
import java.util.Collection;

public class Problem3 {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 6 };
        int n = 6;

        Collection<Integer> sum = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    sum.add(i);
                    sum.add(j);
                }
            }
        }
        System.out.println(sum);
    }
}

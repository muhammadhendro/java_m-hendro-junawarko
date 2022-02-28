
import java.util.HashSet;

public class Problem4 {
    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 3, 4 };
        int[] arr2 = { 1, 3, 5, 10, 16 };

        HashSet<Integer> map = new HashSet<Integer>();
        for (int i : arr1) {
            map.add(i);
        }
        for (int i : arr2) {
            if (map.contains(i)) {
                map.remove(i);
            }
        }
        System.out.println(map);
    }
}

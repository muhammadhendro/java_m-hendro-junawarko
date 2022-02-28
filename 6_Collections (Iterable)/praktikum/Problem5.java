
import java.util.Set;
import java.util.HashSet;

public class Problem5 {

    public static void main(String[] args) {

        int[] arr = { 2, 3, 3, 3, 6, 9, 9 };

        Set<Integer> angkaSekali = new HashSet<>();
        for (int n : arr) {
            angkaSekali.add(n);
        }
        System.out.println(angkaSekali.size());
    }
}

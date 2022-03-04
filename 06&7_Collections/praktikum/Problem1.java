
import java.util.LinkedHashSet;
import java.util.Set;

public class Problem1 {
    public static void main(String[] args) {
        String[] arr1 = { "kazuya", "jin", "lee" };
        String[] arr2 = { "kazuya", "feng" };
        Set<String> merge = new LinkedHashSet<>();
        for (var n : arr1) {
            merge.add(n);
        }
        for (var n : arr2) {
            merge.add(n);
        }
        System.out.println(merge);
    }

}

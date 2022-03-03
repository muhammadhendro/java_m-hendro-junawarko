import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Problem2 {
    public static void main(String[] args) {

        NavigableSet<Integer> arr = new TreeSet<>(List.of(1, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000));
        arr = arr.descendingSet();
        List<Integer> list = new ArrayList<>(arr);
        List<Integer> hasil = new ArrayList<>();
        int n = 123;
        for (int i = 0; i < list.size(); i++) {
            while (n >= list.get(i)) {
                n -= list.get(i);
                hasil.add(list.get(i));
            }
        }
        System.out.println(hasil);
    }
}

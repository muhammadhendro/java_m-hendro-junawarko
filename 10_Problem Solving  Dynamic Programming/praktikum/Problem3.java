import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {

        List<Integer> stone = new ArrayList<>(List.of(10, 30, 40, 20));
        Integer minimumTotal = 0;
        for (int i = 0; i < stone.size() - 2; i++) {
            int jarak1 = Math.abs(stone.get(i + 1) - stone.get(i));
            int jarak2 = Math.abs(stone.get(i + 2) - stone.get(i));
            if (jarak1 < jarak2) {
                minimumTotal += jarak1;
            } else if (jarak1 >= jarak2) {
                i += 1;
                minimumTotal += jarak1;
            }
        }
        System.out.println(minimumTotal);

    }

}

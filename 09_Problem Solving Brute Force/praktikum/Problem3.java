import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3 {
    public static void main(String[] args) {

        Set<Integer> D = new HashSet<>(List.of(5, 4));
        Set<Integer> H = new HashSet<>(List.of(7, 8, 4));
        List<Integer> listD = new ArrayList<>(D);
        List<Integer> listH = new ArrayList<>(H);
        List<Integer> hasil = new ArrayList<>();
        for (int i = 0; i < listD.size(); i++) {
            for (int j = 0; j < listH.size(); j++) {

                if (listD.get(i) <= listH.get(j)) {
                    hasil.add(listH.get(j));
                    listH.remove(j);
                    j++;
                    listD.remove(i);
                    i--;
                }
            }
        }
        if (listD.size() >= 1) {
            System.out.println("knight fall");
        } else {
            int minimumTotalHeight = 0;
            for (int n : hasil) {
                minimumTotalHeight += n;
            }
            System.out.println(minimumTotalHeight);
        }

    }
}
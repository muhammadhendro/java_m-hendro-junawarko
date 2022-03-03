import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>(List.of(1, 1, 3, 5, 5, 6, 7));
        // List<Integer> arr = new ArrayList<>(List.of(12, 15, 15, 19, 24, 31, 53, 59,
        // 60));
        int x = 3;
        int hasil = 0;
        int kiri = 0;
        int kanan = arr.size() - 1;
        while (kiri <= kanan && hasil == 0) {
            int tengah = (kiri + kanan) / 2;
            if (x < arr.get(tengah)) {
                kanan = tengah - 1;
            } else if (x > arr.get(tengah)) {
                kiri = tengah + 1;
            } else {
                hasil = tengah;
            }

        }
        if (hasil == 0) {
            System.out.println(hasil - 1);
        } else {
            System.out.println(hasil);
        }
    }
}

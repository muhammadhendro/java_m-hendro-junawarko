import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem4 {
    public static void main(String[] args) {

        Map<Integer, String> romawi = new HashMap<>() {
            {
                put(1, "I");
                put(4, "IV");
                put(5, "V");
                put(9, "IX");
                put(10, "X");
                put(40, "XL");
                put(50, "L");
                put(90, "XC");
                put(100, "C");
                put(400, "CD");
                put(500, "D");
                put(900, "CM");
                put(1000, "M");

            }
        };

        Map<Integer, String> romawiSorted = new TreeMap<>(Collections.reverseOrder());
        romawiSorted.putAll(romawi);
        // System.out.println(romawiSorted);
        int n ;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Angka: ");
        n = input.nextInt();
        input.close();
        List<String> hasil = new ArrayList<>();
        for (int key : romawiSorted.keySet()) {

            while (n >= key) {
                n -= key;
                hasil.add(romawiSorted.get(key));
            }
        }
        String romawiHasil = "";
        for (String var : hasil) {
            romawiHasil += var;
        }
        System.out.println(romawiHasil);

    }
}

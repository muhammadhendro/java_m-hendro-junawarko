
import java.util.ArrayList;
import java.util.Collection;

public class Problem2 {
    public static void main(String[] args) {

        String str = "76523752";
        String[] arr = str.split("");

        Collection<String> angkaSekali = new ArrayList<>();
        Collection<String> angkaDuplikat = new ArrayList<>();
        for (var n : arr) {
            if (angkaSekali.contains(n)) {
                angkaSekali.remove(n);
                angkaDuplikat.add(n);
            } else if (!angkaDuplikat.contains(n)) {
                angkaSekali.add(n);
            }
        }
        System.out.println(angkaSekali);
    }
}

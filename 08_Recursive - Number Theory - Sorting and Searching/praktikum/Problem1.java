import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Angka: ");
        n = input.nextInt();
        input.close();

        List<Integer> angka = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int bil = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    bil++;
                }
            }
            if (bil == 2) {
                angka.add(i);
            }
        }
        int index =0;
        for (int a: angka){
            index++;
            if(index == n){
                System.out.println(a);
            }
        }
    }

}

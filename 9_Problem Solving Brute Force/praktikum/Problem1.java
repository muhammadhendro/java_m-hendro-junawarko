import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Problem1 {
    public static void main(String[] args) {
        int A, B, C;
        Scanner input = new Scanner(System.in);
        System.out.print("angka: ");
        A = input.nextInt();
        B = input.nextInt();
        C = input.nextInt();
        input.close();
        List<String> hasilA = new ArrayList<>();
        List<String> hasilB = new ArrayList<>();
        List<String> hasilC = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= A; j++) {
                for (int k = 1; k <= A; k++) {
                    if (i + j + k == A) {
                        String hasil = (i + " " + j + " " + k);
                        hasilA.add(hasil);
                    }
                }
            }
        }

        for (int i = 1; i <= B; i++) {
            for (int j = 1; j <= B; j++) {
                for (int k = 1; k <= B; k++) {
                    if (i * j * k == B) {
                        String hasil = (i + " " + j + " " + k);
                        hasilB.add(hasil);
                    }
                }
            }
        }

        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= C; j++) {
                for (int k = 1; k <= C; k++) {
                    if (i * i + j * j + k * k == C) {
                        String hasil = (i + " " + j + " " + k);
                        hasilC.add(hasil);
                    }
                }
            }
        }
        boolean z = true;

        for (int i = 0; i < hasilA.size(); i++) {
            for (int j = 0; j < hasilB.size(); j++) {
                for (int k = 0; k < hasilC.size(); k++) {
                    if (hasilA.get(i).equals(hasilB.get(j)) && hasilB.get(j).equals(hasilC.get(k))) {
                        System.out.println(hasilA.get(i));
                        z = false;
                    }
                    break;
                }
            }
        }
        if (z) {
            System.out.println("No solution");
        }

    }
}
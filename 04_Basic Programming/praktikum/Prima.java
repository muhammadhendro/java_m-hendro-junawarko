import java.util.Scanner;

public class Prima {

    public static String prima(int n) {
        int jumlah_faktor = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                jumlah_faktor++;
            }
        }
        if (jumlah_faktor == 2) {
            return("Bilangan Prima");
        } else {
            return("Bukan bilangan Prima");
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Angka: ");
        n = input.nextInt();
        input.close();

        System.out.println(prima(n));
        
    }

}
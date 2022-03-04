import java.util.Scanner;

public class Faktor {
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Angka: ");
        n = input.nextInt();
        input.close();
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
}

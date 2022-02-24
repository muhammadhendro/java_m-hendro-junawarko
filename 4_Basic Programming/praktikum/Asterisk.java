import java.util.Scanner;

public class Asterisk {
    public static void main(String[] args) {
        int s;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan jumlah: ");
        s = input.nextInt();
        input.close();
        
        for (int i = 1; i <= s; i++) {
            for (int j = s; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }

    }
}

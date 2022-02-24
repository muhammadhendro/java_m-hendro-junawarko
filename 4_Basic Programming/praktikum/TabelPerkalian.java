import java.util.Scanner;

public class TabelPerkalian {
    public static void main(String[] args) {
        int s;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Angka: ");
        s = input.nextInt();
        input.close();
        
        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= s; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}

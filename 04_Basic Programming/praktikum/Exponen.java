import java.util.Scanner;

public class Exponen {

    public static int exponen(int x, int y) {
        int hasil = x;
        for (int i = 1; i < y; i++) {
            hasil *= x;
        }
        return hasil;
    }

    public static void main(String[] args) {
        int x, y;
        Scanner input = new Scanner(System.in);
        System.out.print("x= ");
        x = input.nextInt();
        System.out.print("y= ");
        y = input.nextInt();
        input.close();

        int hasil = exponen(x, y);
        System.out.println(hasil);

    }
}

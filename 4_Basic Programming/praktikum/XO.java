import java.util.Scanner;

public class XO {
    public static void main(String[] args) {
        String s;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Kalimat: ");
        s = input.nextLine().toLowerCase();
        input.close();

        int x = 0;
        int o = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'x') {
                x++;
            } else if (c == 'o') {
                o++;
            }
        }
        if (x == o) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}

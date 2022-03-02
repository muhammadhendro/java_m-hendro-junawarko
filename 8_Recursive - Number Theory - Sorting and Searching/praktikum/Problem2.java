import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Fibo ke-: ");
        n = input.nextInt();
        input.close();
        int a, b, c;
        a = 0;
        b = 1;
        List<Integer> fibo = new ArrayList<>();
        fibo.add(a);
        fibo.add(b);
        for (int i = 0; i < 1000; i++) {
            c = a + b;
            a = b;
            b = c;
            fibo.add(c);
        }
        int index = 0;
        for (int x : fibo) {
            index++;
            if (index == n) {
                System.out.println(x);
            }
        }

    }

}

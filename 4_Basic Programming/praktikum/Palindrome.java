import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String s;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Kalimat: ");
        s = input.nextLine().toLowerCase();
        input.close();
        
        String reverseTeks = "";
        for (int i = s.length(); i > 0; i--) {
            char c = s.charAt(i - 1);
            reverseTeks += c;
        }

        if (s.equals(reverseTeks)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Bukan Palindrome");
        }

    }
}

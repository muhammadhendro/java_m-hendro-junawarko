import java.util.Scanner;

public class Vokal {
    public static void main(String[] args) {
        String s;
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan Kalimat: ");
        s = input.nextLine().toLowerCase();
        input.close();
        
        char[] teks = new char[] { 'a', 'i', 'u', 'e', 'o' };
        int hurufVokal = 0;
        int totalHuruf = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 5; j++) {
                if (c == teks[j]) {
                    hurufVokal++;
                }
            }
            if (Character.isLetter(c)) {
                totalHuruf++;
            }
        }
        int hurufKonsonan = totalHuruf - hurufVokal;

        System.out.println("Jumlah Vokal: " + hurufVokal);
        System.out.println("Jumlah Konsonan: " + hurufKonsonan);
        System.out.println("Total Karakter: " + totalHuruf);

    }
}

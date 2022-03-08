package praktikum.Challenge6;

import java.util.*;

import static praktikum.Challenge6.Main.*;

public class Kandang {

    public String type;
    public LinkedHashMap<String, String> map = new LinkedHashMap<>();

    Kandang() {

    }

    public void createKandang(Integer jml) {
        List<String> namaHewan = Arrays.asList("K", "B", "Z");
        for (int i = 1; i <= jml; i++) {
            Random rand = new Random();
            map.put(String.valueOf(i), namaHewan.get(rand.nextInt(namaHewan.size())));


        }
        tampilKandang();
       

    }

    public void getKandang(Integer i) {
        System.out.println("| | |");
        System.out.println("| " + map.get(i) + " |");
        System.out.println("| | |");
        System.out.println();

    }

    public void tampilKandang() {
        for (String m : map.keySet()) {

            System.out.println("| | |");
            System.out.println("| " + m + " |");
            System.out.println("| | |");
            System.out.println();
        }
    }

    int counter = 0;

    public void setKandang(String index, String nama) {
        System.out.println("PERCOBAAN BUKA: ");
        for (String m : map.keySet()) {

            if (index.equals(m)) {
                System.out.println("| | |");
                System.out.println("| " + nama + " |");
                System.out.println("| | |");
                System.out.println();
            } else {
                System.out.println("| | |");
                System.out.println("| " + m + " |");
                System.out.println("| | |");
                System.out.println();
            }
        }

        if (nama.equals(map.get(index))) {
            System.out.println(ANSI_GREEN + "Tebakan benar !" + ANSI_RESET);
            counter++;

            map.remove(index);
            map.put(nama, nama);
            tampilKandang();
            if (counter == map.size()) {
                System.out.println(ANSI_GREEN + "Selamat, anda menebak semua kandang" + ANSI_RESET);
                System.exit(0);
            }
           

        } else {
            System.out.println(ANSI_YELLOW + "Tebakan salah" + ANSI_RESET);
            tampilKandang();

        }


    }


}

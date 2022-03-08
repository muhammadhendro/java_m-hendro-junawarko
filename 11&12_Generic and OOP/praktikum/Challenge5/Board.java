package praktikum.Challenge5;

import java.util.*;

public class Board {
    public static Scanner input = new Scanner(System.in);
    Kandang kambing = new Kandang();

    public void showMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Tebak Kandang");
        System.out.println("----------------------------------------");
        System.out.println("1. Jumlah kandang");
        System.out.println("99. Exit");
        System.out.println("----------------------------------------");


        System.out.print("Pilih menu: ");
        Integer n = input.nextInt();
        if (n == 1) {

            jmlKandang();


        } else if (n == 99) {
            System.exit(0);
        } else {
            System.out.printf("Wrong input...");

        }
    }

    public void jmlKandang() {
        System.out.print("Masukkan jumlah kandang: ");
        Integer jml = input.nextInt();
        //List<String> namaHewan = new ArrayList<>(List.of("kambing", "bebek", "zebra"));
        List<String> namaHewan = Arrays.asList("K", "B", "Z");
        Map<Integer, String> map = new HashMap<>();


        for (int i = 1; i <= jml; i++) {
            Random rand = new Random();

            map.put(i, namaHewan.get(rand.nextInt(namaHewan.size())));
            kambing.createKandang(i, namaHewan.get(rand.nextInt(namaHewan.size())));
            tampilKandang(i);
        }
        System.out.println(map);

        tebakKandang(map);
    }

    public void tebakKandang(Map<Integer, String> map) {
        System.out.print("Pilih kandang yang ingin dibuka: ");
        Integer nomor = input.nextInt();
        System.out.println("---PILIHAN---");
        System.out.println("K: Kambing");
        System.out.println("Z: Zebra");
        System.out.println("B: Bebek");
        System.out.print("Masukkan tebakan: ");
        String pilihan = input.next();
        cekkandang(map, nomor, pilihan);

    }

    public void cekkandang(Map<Integer, String> map, Integer nomor, String pilihan) {

//        for (int i = 1; i <= map.size(); i++) {
//            System.out.println(map.get(i));
//        }
        for (int i : map.keySet()) {
            if (i == nomor) {
                
            } else {

            }


        }


    }

    public void tampilKandang(Integer i) {


        System.out.println("| | |");
        System.out.println("| " + i + " |");
        System.out.println("| | |");
        System.out.println();

    }
}

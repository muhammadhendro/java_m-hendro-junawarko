package praktikum.Challenge6;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Kandang hewan = new Kandang();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        showMenu();

        //hewan.setKandang("1", "K");


    }

    public static void showMenu() {
        System.out.println("----------------------------------------");
        System.out.println(ANSI_BLUE + "              Tebak Kandang" + ANSI_RESET);
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

    public static void jmlKandang() {
        System.out.print("Masukkan jumlah kandang: ");
        Integer jml = input.nextInt();

        hewan.createKandang(jml);
        tebakKandang();
    }

    int counter = 0;

    public static void tebakKandang() {

        System.out.print("Pilih kandang yang ingin dibuka: ");
        String nomor = input.next();
        System.out.println("---PILIHAN---");
        System.out.println(ANSI_BLUE + "K" + ANSI_RESET + ": Kambing");
        System.out.println(ANSI_RED + "Z" + ANSI_RESET + ": Zebra");
        System.out.println(ANSI_YELLOW + "B" + ANSI_RESET + ": Bebek");
        System.out.print("Masukkan tebakan: ");
        String pilihan = input.next().toUpperCase();
        hewan.setKandang(nomor, pilihan);
        tebakKandang();

    }
}

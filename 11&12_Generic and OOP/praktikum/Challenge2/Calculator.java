package praktikum.Challenge2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        header();
        System.out.println("1. Open Calculator");
        System.out.println("99: Exit");
        System.out.print("Masukan pilihan anda: ");
        Integer n = input.nextInt();
        if (n == 1) {


            number();

        } else if (n == 99) {
            System.exit(0);
        } else {
            System.out.printf("Wrong input...");

        }


    }

    public static void header() {
        System.out.println("+++++++++++++++++CALCULATOR+++++++++++++++++");


    }


    public static void number() {
        header();

        System.out.print("Masukan value 1: ");
        Double v1 = input.nextDouble();
        System.out.print("Masukan value 2: ");
        Double v2 = input.nextDouble();


        proses(v1, v2);

    }

    public static void proses(Double v1, Double v2) {
        header();
        System.out.println("Please Enter Calculation Operation: ");
        System.out.println("1. Add Value");
        System.out.println("2. Sub Value");
        System.out.println("3. Multiply Value");
        System.out.println("4. Divide Value");
        header();
        System.out.print("Pilihan anda: ");
        Integer operator = input.nextInt();

        switch (operator) {
            case 1:
                tambah(v1, v2);
                break;
            case 2:
                kurang(v1, v2);
                break;
            case 3:
                kali(v1, v2);
                break;
            case 4:
                bagi(v1, v2);
                break;
            default:
                System.out.println("invalid operator !");
                break;
        }

    }

    public static void printHasil(Double hasil, Integer i) {
        header();
        DecimalFormat format = new DecimalFormat("0.#");
        System.out.println("Pilihan anda: " + i);
        System.out.println("Hasil: " + format.format(hasil));
    }

    public static void tambah(Double v1, Double v2) {
        Double hasil = v1 + v2;
        printHasil(hasil, 1);

    }

    public static void kurang(Double v1, Double v2) {
        Double hasil = v1 - v2;
        printHasil(hasil, 2);

    }

    public static void kali(Double v1, Double v2) {
        Double hasil = v1 * v2;
        printHasil(hasil, 3);

    }

    public static void bagi(Double v1, Double v2) {
        Double hasil = v1 / v2;
        printHasil(hasil, 4);

    }

}

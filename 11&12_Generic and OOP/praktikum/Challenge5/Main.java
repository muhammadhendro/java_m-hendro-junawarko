package praktikum.Challenge5;

import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        Board board = new Board();
        board.showMenu();


    }

    public static void header() {


    }

    public static void kandang(Integer jml) {

        for (int i = 1; i <= jml; i++) {
            System.out.println("| | |");
            System.out.println("| " + i + " |");
            System.out.println("| | |");
            System.out.println();
        }

    }
}

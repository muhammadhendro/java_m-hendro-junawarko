package praktikum.Challenge5;

import java.util.*;

public class Kandang {


    //    public Kandang(Integer i, String j) {
//        this.i = Collections.singletonList(i);
//        this.nama = Collections.singletonList(j);
//    }

    public List<Integer> index = new ArrayList<>();
    public List<String> nama = new ArrayList<>();

    public void createKandang(Integer i, String j) {
        index.add(i);
        nama.add(j);


//        System.out.println("| | |");
//        System.out.println("| " + i + " |");
//        System.out.println("| | |");
//        System.out.println();

    }

    public void bukaKandang(Integer i, String j) {

        System.out.println("| | |");
        System.out.println("| " + j + " |");
        System.out.println("| | |");
        System.out.println();
    }

    public void bukaKandangKambing(String i) {
        System.out.println("| | |");
        System.out.println("| K |");
        System.out.println("| | |");
        System.out.println();
    }

    public void bukaKandangBebek(String i) {
        System.out.println("| | |");
        System.out.println("| B |");
        System.out.println("| | |");
        System.out.println();
    }

    public void bukaKandangZebra(String i) {
        System.out.println("| | |");
        System.out.println("| Z |");
        System.out.println("| | |");
        System.out.println();
    }

    public void generateKandang(Integer jml) {

        for (int i = 1; i <= jml; i++) {
            System.out.println("| | |");
            System.out.println("| " + i + " |");
            System.out.println("| | |");
            System.out.println();
        }
    }


}

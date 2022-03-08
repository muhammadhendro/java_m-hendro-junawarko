package praktikum.Challenge4;

import praktikum.Challenge1.Car;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal("Binatang");

        Herbivor kambing = new Herbivor("Kambing");
        Carnivor singa = new Carnivor("Singa");
        Omnivor ayam = new Omnivor("Ayam");

        animal.identify_myself();
        System.out.println();

        kambing.identify_myself();
        singa.identify_myself();
        System.out.println();

        ayam.identify_myself();
    }
}

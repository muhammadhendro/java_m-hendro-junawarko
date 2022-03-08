package praktikum.Challenge1;

public class Flower {

    String nama;
    String color;
    Integer num_of_petal;

    Flower(String nama, String color, Integer petal) {
        this.nama = nama;
        this.color = color;
        this.num_of_petal = petal;
    }

    public void show_identity() {
        System.out.println(
                "Saya Bunga dengan detail, Jenis: " + this.nama + ", color: " + this.color + ", num of petal: " + this.num_of_petal);
    }

}

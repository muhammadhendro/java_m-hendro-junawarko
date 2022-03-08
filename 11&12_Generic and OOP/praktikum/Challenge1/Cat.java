package praktikum.Challenge1;

public class Cat extends Animals {

    Cat(String color, Integer leg) {
        super(color, leg, null, null);
    }


    public void show_identity() {
        System.out.println(
                "Saya Kucing dengan detail, Warna Bulu: " + this.fur_color + " dengan jumlah kaki: " + this.num_of_leg);
    }
}

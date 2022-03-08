package praktikum.Challenge1;

public class Car {

    String type;
    String color;
    Integer num_of_tire;

    Car(String type, String color, Integer tire) {
        this.type = type;
        this.color = color;
        this.num_of_tire = tire;
    }

    public void show_identity() {
        System.out.println(
                "Saya Mobil dengan detail, Type: " + this.type + ", color: " + this.color + ", num of tire: " + this.num_of_tire);
    }
}

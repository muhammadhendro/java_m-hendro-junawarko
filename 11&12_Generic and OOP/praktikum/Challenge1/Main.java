package praktikum.Challenge1;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Hitam", 4);
        Cat cat2 = new Cat("Putih", 3);
        Cat cat3 = new Cat("Hitam Putih", 4);
        Cat cat4 = new Cat("Poleng poleng", 3);
        Cat cat5 = new Cat("Bintik bintik", 4);


        cat1.show_identity();
        cat2.show_identity();
        cat3.show_identity();
        cat4.show_identity();
        cat5.show_identity();

        Fish fish1 = new Fish("paus", "plankton");
        Fish fish2 = new Fish("cupang", "cacing");
        Fish fish3 = new Fish("arwana", "jangkrik");
        Fish fish4 = new Fish("sapu-sapu", "pelet");

        fish1.show_identity();
        fish2.show_identity();
        fish3.show_identity();
        fish4.show_identity();

        Flower flower1 = new Flower("bangkai", "merah", 12);
        Flower flower2 = new Flower("anggrek", "putih", 8);
        Flower flower3 = new Flower("mawar", "merah", 3);
        Flower flower4 = new Flower("melati", "kuning", 5);

        flower1.show_identity();
        flower2.show_identity();
        flower3.show_identity();
        flower4.show_identity();

        Car car1 = new Car("sedan", "merah", 4);
        Car car2 = new Car("truk", "hijau", 6);
        Car car3 = new Car("tronton", "coklat", 12);
        Car car4 = new Car("angkot", "kuning", 4);

        car1.show_identity();
        car2.show_identity();
        car3.show_identity();
        car4.show_identity();

    }
}
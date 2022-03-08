package praktikum.Challenge4;

public class Animal {

    String name;
    String type;
    String teeth;

    public Animal(String name, String type, String teeth) {
        this.name = name;
        this.type = type;
        this.teeth = teeth;

    }

    public Animal(String name) {
        this.name = name;


    }

    public void identify_myself() {
        System.out.println("Hi I'm Parent of All Animal, My Name is " + this.name);
    }

}

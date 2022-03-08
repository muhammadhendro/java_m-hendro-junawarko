package praktikum.Challenge4;

public class Herbivor extends Animal {


    Herbivor(String name, String type, String teeth) {
        super(name, type, teeth);


    }

    Herbivor(String name) {
        super(name);
        this.type = "'tumbuhan'";
        this.teeth = "tumpul";


    }

    public void identify_myself() {
        System.out.println("Hi I'm Herbivor, My Name is " + this.name + ", My Food is " + this.type + ", I have " + this.teeth + " teeth ");
    }
}

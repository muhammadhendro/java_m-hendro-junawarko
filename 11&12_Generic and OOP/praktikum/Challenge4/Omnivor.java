package praktikum.Challenge4;

public class Omnivor extends Animal {

    Omnivor(String name, String type, String teeth) {
        super(name, type, teeth);


    }

    Omnivor(String name) {
        super(name);
        this.type = "'semua'";
        this.teeth = "tajam dan tumpul";


    }

    public void identify_myself() {
        System.out.println("Hi I'm Omnivor, My Name is " + this.name + ", My Food is " + this.type + ", I have " + this.teeth + " teeth ");
    }
}

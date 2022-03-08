package praktikum.Challenge4;

public class Carnivor extends Animal {

    Carnivor(String name, String type, String teeth) {
        super(name, type, teeth);


    }

    Carnivor(String name) {
        super(name);
        this.type = "'daging'";
        this.teeth = "tajam";


    }

    public void identify_myself() {
        System.out.println("Hi I'm Carnivor, My Name is " + this.name + ", My Food is " + this.type + ", I have " + this.teeth + " teeth ");
    }
}

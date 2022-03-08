package praktikum.Challenge3;

public class Vehicles {

    String name;
    String with_engine;

    public Vehicles(String name, Boolean engine) {
        this.name = name;
        if (engine) {
            this.with_engine = "'with engine'";
        } else {
            this.with_engine = "'no engine'";
        }

    }

    public void identify_myself() {
        System.out.println("Hi I'm Parent of All Vehicles, My Name is " + this.name + ", My Engine Status is " + this.with_engine);
    }

}

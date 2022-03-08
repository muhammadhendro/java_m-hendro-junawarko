package praktikum.Challenge3;

public class Buses extends Vehicles {

    Integer wheel_count;

    String private_bus;

    Buses(String name, Boolean engine, Integer wheel, Boolean private_bus) {
        super(name, engine);
        this.wheel_count = wheel;
        if (private_bus) {
            this.private_bus = "[Private Bus]";
        } else {
            this.private_bus = "[Public Bus]";
        }

    }

    public void identify_myself() {
        System.out.println("Hi I'm Bus " + this.private_bus + ", My Name is " + this.name + ", My Engine Status is " + this.with_engine + ", I have " + this.wheel_count + " Wheel(s)");
    }
}

package praktikum.Challenge3;

public class Bikes extends Vehicles {
    Integer wheel_count;

    Bikes(String name, Boolean engine, Integer wheel) {
        super(name, engine);
        this.wheel_count = wheel;

    }

    public void identify_myself() {
        System.out.println("Hi I'm Bike, My Name is " + this.name + ", My Engine Status is " + this.with_engine + ", I have " + this.wheel_count + " Wheel(s)");
    }
}

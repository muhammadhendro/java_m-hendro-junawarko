package praktikum.Challenge3;

public class Cars extends Vehicles {
    Integer wheel_count;

    String engine_type;

    Cars(String name, Boolean engine, Integer wheel, String type) {
        super(name, engine);
        this.wheel_count = wheel;
        this.engine_type = type;

    }

    public void identify_myself() {
        System.out.println("Hi I'm Car, My Name is " + this.name + ", My Engine Status is " + this.with_engine + ", I have " + this.wheel_count + " Wheel(s), My Engine Type = " + this.engine_type);
    }
}

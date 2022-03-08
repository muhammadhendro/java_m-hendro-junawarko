package praktikum.Challenge3;

public class Main {
    public static void main(String[] args) {
        Vehicles vehicles = new Vehicles("gerobak", false);
        vehicles.identify_myself();
        System.out.println();
        Bikes bikes1 = new Bikes("Pedal Bikes", false, 2);
        Bikes bikes2 = new Bikes("Motor Bikes", true, 2);
        bikes1.identify_myself();
        bikes2.identify_myself();
        System.out.println();
        Cars cars1 = new Cars("Sport Cars", true, 4, "V8");
        Cars cars2 = new Cars("Pickup Cars", true, 4, "Solar");
        cars1.identify_myself();
        cars2.identify_myself();
        System.out.println();
        Buses buses1 = new Buses("Trans Jakarta", true, 4, false);
        Buses buses2 = new Buses("School Bus", true, 4, true);
        buses1.identify_myself();
        buses2.identify_myself();
    }
}

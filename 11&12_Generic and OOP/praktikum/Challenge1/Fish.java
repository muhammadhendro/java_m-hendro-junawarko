package praktikum.Challenge1;

public class Fish extends Animals {

    Fish(String type, String feed) {
        super(null, null, type, feed);
    }
    
    public void show_identity() {
        System.out.println(
                "Saya Ikan dengan detail, Jenis: " + this.type + " makanan: " + this.feed);
    }
}

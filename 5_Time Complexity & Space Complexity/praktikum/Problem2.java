public class Problem2 {

    public static int pow(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * pow(x, n - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(pow(2, 3)); // 8
        System.out.println(pow(5, 3)); // 125
        System.out.println(pow(10, 2)); // 100
        System.out.println(pow(2, 5)); // 32
        System.out.println(pow(7, 3)); // 343
    }
}

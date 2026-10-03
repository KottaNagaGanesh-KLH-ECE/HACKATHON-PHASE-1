import java.util.Scanner;
public class WaterBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter water consumption in litres: ");
        double consumption = sc.nextDouble();
        int bill;
        if (consumption <= 500) {
            bill = 100;
        } else {
            bill = 200;
        }
        System.out.println("Water Bill = Rs." + bill);
        sc.close();
    }
}
      
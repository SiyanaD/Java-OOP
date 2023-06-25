package WorkingWithAbstractionLab.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        Discount discount = Discount.valueOf(input[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay,numberOfDays,season,discount);
        System.out.printf( "%.2f%n", priceCalculator.calculate());

    }
}

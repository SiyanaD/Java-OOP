package WorkingWithAbstractionLab;

import java.util.Scanner;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        for (int startCount = 1; startCount <=size ; startCount++) {
            printRow(size, startCount);
        }
        for (int startCount = size-1; startCount >=1 ; startCount--) {
            printRow(size, startCount);
        }
        }
    private static void printRow(int size, int startCount) {
        for (int i = 0; i < size - startCount; i++) {
            System.out.print(" ");
        }
        for (int col = 1; col < startCount; col++) {
            System.out.print("* ");
        }

        System.out.println("*");
    }
}


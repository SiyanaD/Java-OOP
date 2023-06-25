package WorkingWithAbstractionLab.P02PointInRectangle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int bottomLeftX=numbers.get(0);
        int bottomLeftY = numbers.get(1);
        int topRightX = numbers.get(2);
        int topRightY = numbers.get(3);

        Point bottomLeft = new Point(bottomLeftX,bottomLeftY);
        Point topRight = new Point(topRightX,topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int n = Integer.parseInt(scanner.nextLine());
        for (int line = 0; line <n ; line++) {
            String [] input = scanner.nextLine().split("\\s+");
            int index1 = Integer.parseInt(input[0]);
            int index2 = Integer.parseInt(input[1]);

            Point current = new Point(index1,index2);

            System.out.println(rectangle.contains(current));



        }


    }
}

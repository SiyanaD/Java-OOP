package WorkingWithAbstractionExercise.P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int row = dimensions[0];
        int col = dimensions[1];

        //
        int[][] matrix = new int[row][col];

        int value = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] heroCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            //текущо положение на лошия
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            while (evilRow >= 0 && evilCol >= 0) {
                if (evilRow >= 0 && evilRow < matrix.length && evilCol >= 0 && evilCol < matrix[0].length) {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }


            int xI = heroCoordinates[0];
            int yI = heroCoordinates[1];

            while (xI >= 0 && yI < matrix[1].length) {
                if (xI >= 0 && xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
                    sum += matrix[xI][yI];
                }

                yI++;
                xI--;
            }

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }
}

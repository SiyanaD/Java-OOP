package WorkingWithAbstractionExercise.P3CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandPower = scanner.nextLine();
        String commandSuits = scanner.nextLine();

        CardCalculated cardCalculated = new CardCalculated(RankPowers.valueOf(commandPower),SuitPowers.valueOf(commandSuits));
        System.out.printf("Card name: %s of %s; Card power: %d",commandPower,commandSuits,cardCalculated.calculate());
    }
}

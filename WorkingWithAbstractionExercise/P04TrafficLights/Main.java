package WorkingWithAbstractionExercise.P04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //On the first line, you will be given multiple traffic light signals i
        String[] givenLights = scanner.nextLine().split("\\s+");
        //On the second line, you will receive the n number of times you need to change each traffic light's signal.
        int n = Integer.parseInt(scanner.nextLine());

        //светофар съвкупност от крушки
        List<Lights> trafficLights = new ArrayList<>();//списък с всички крушки


        for (String givenLight : givenLights) {
            //създавам кушка с този цвят
            Lights lights = new Lights(Color.valueOf(givenLight));
            //добавям кушка в светофара
            trafficLights.add(lights);
        }
        for (int i = 0; i <n ; i++) {
            trafficLights.forEach(lights -> {
                //сменям цвета
                lights.changeColor();

                //отпечатвам цвета

                System.out.print(lights.getColor()+ " ");
            });
            System.out.println();
        }

    }
}

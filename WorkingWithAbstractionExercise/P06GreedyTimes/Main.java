
package WorkingWithAbstractionExercise.P06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long entry = Long.parseLong(scanner.nextLine());
        String[] seif = scanner.nextLine().split("\\s+");

        var cake = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long stone = 0;
        long money = 0;

        for (int i = 0; i < seif.length; i += 2) {
            String name = seif[i];
            long numbers = Long.parseLong(seif[i + 1]);

            String names = "";

            if (name.length() == 3) {
                names = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                names = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                names = "Gold";
            }

            if (names.equals("")) {
                continue;
            } else if (entry < cake.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + numbers) {
                continue;
            }

            switch (names) {
                case "Gem":
                    if (!cake.containsKey(names)) {
                        if (cake.containsKey("Gold")) {
                            if (numbers > cake.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (cake.get(names).values().stream().mapToLong(e -> e).sum() + numbers > cake.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!cake.containsKey(names)) {
                        if (cake.containsKey("Gem")) {
                            if (numbers > cake.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (cake.get(names).values().stream().mapToLong(e -> e).sum() + numbers > cake.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!cake.containsKey(names)) {
                cake.put((names), new LinkedHashMap<String, Long>());
            }

            if (!cake.get(names).containsKey(name)) {
                cake.get(names).put(name, 0L);
            }


            cake.get(names).put(name, cake.get(names).get(name) + numbers);
            if (names.equals("Gold")) {
                gold += numbers;
            } else if (names.equals("Gem")) {
                stone += numbers;
            } else if (names.equals("Cash")) {
                money += numbers;
            }
        }

        for (var x : cake.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}
package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("Beast!")){
            //o Dog: "Woof!"
            //o Cat: "Meow meow"
            //o Frog: "Ribbit"
            //o Kittens: "Meow"
            //o Tomcat: "MEOW"
            switch (line){
                case "Dog":
                    String[] tokens = scanner.nextLine().split("\\s+");
                    Dog dog = new Dog(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
                    System.out.println(dog.toString());

                    break;
                case "Cat":
                    tokens = scanner.nextLine().split("\\s+");
                    Cat cat = new Cat(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
                    System.out.println(cat.toString());
                    break;
                case "Frog":
                    tokens = scanner.nextLine().split("\\s+");
                    Frog frog = new Frog(tokens[0],Integer.parseInt(tokens[1]),tokens[2]);
                    System.out.println(frog.toString());

                    break;
                case "Kittens":
                    tokens = scanner.nextLine().split("\\s+");
                    Kitten kitten = new Kitten(tokens[0],Integer.parseInt(tokens[1]));
                    System.out.println(kitten.toString());
                    break;
                case "Tomcat":
                    tokens = scanner.nextLine().split("\\s+");
                    Tomcat tomcat = new Tomcat(tokens[0],Integer.parseInt(tokens[1]));
                    System.out.println(tomcat.toString());
                    break;

            }

            line=scanner.nextLine();
        }

    }
}

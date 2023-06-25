package WorkingWithAbstractionExercise.P01CardSuit;

public class Main {
    public static void main(String[] args) {

        CardSuits [] cardSuits = CardSuits.values();//values()- взимаме масива на изброените елементи

        System.out.println("Card Suits:");

        for (CardSuits cardSuit : cardSuits) {
            //cardSuit.ordinal() -> ordinal() - връща стойността(Ordinal value) на която се намира елемента
        System.out.printf("Ordinal value: %d; Name value: %s%n",cardSuit.ordinal(),cardSuit);}
    }
}

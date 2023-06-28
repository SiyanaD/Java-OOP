package EncapsulationLabJune.P03ValidationData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new
                InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");

            Person person = null;
            try {
                person= new Person(input[0], input[1], Integer.parseInt(input[2]),
                        Double.parseDouble(input[3]));
            }
            catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
            if (person!=null){
                people.add(person);
            }
        }

        double bonus = Double.parseDouble(reader.readLine());


        for (Person name : people) {
            name.increaseSalary(bonus);
            System.out.println(name.toString());
        }


    }
}

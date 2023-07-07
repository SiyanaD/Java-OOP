package P03ShoppingSpree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Person> personMap = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split(";"))
                .forEach(p->{
                    String [] tokens = p.split("=");
                    Person person = new Person(tokens[0],Double.parseDouble(tokens[1]));
                    personMap.putIfAbsent(person.getName(),person);
                });


        Map<String,Product> productMap = new LinkedHashMap<>();
        Arrays.stream(scanner.nextLine().split(";"))
                .forEach(p->{
                    String [] tokens = p.split("=");
                    Product product = new Product(tokens[0],Double.parseDouble(tokens[1]));
                   productMap.putIfAbsent(product.getName(),product);
                });

        String line = scanner.nextLine();

        while (!"END".equals(line)){

            String [] tokens = line.split("\\s+");

            Person person = personMap.get(tokens[0]);
            Product product = productMap.get(tokens[1]);
            person.buyProduct(product);


            line=scanner.nextLine();
        }

       personMap.values().forEach(p->{
            if (p.getProducts().isEmpty()){
                System.out.printf("%s - Nothing bought%n",p.getName());
            }
            else {
                System.out.printf("%s - ",p.getName());

               String productsName = p.getProducts()
                       .stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", "));
                System.out.println(productsName);
            }
        });



        }

    }


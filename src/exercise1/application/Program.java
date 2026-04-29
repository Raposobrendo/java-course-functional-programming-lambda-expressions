package exercise1.application;

import exercise1.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] Args){

        Locale.setDefault(Locale.US);

        String path = "C:\\temp\\in5.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Product> prod = new ArrayList<>();
            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");
                prod.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            // Double avg = prod.stream().map(x -> x.getPrice()).reduce(0, (x, y) -> x + y);
            Double avg = prod.stream().map(Product::getPrice).reduce(0.0, Double::sum)/prod.size();
            System.out.println("Average price: " + String.format("%.2f", avg));

            // Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
            Comparator<String> comp = Comparator.comparing(String::toUpperCase);

            List<String> cheaperAvg = prod.stream()
                    .filter(x -> x.getPrice() < avg)
                    .map(Product::getName)
                    .sorted(comp.reversed())
                    .toList();

            cheaperAvg.forEach(System.out::println);

        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}

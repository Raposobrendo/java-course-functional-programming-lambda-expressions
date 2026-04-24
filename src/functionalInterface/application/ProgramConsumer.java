package functionalInterface.application;

import functionalInterface.model.entities.Product;
import functionalInterface.model.util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ProgramConsumer {
    public static void main(String[] Args){

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));



        // list.forEach(new PriceUpdate());
        // list.forEach(Product::staticPriceUpdate);
        // list.forEach(Product::nonStaticPriceUpdate);
        /* Consumer<Product> cons = p -> p.setPrice(p.getPrice() * 1.1);
        list.forEach(cons); */
        // Everything WORKS!

        list.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        list.forEach(System.out::println);
    }
}

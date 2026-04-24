package functionalInterface.application;

import functionalInterface.model.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProgramPredicate {
    public static void main(String[] Args){

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // list.removeIf(new ProductPredicate()); Works
        // list.removeIf(Product::staticProductPredicate); Works
        // list.removeIf(Product::nonStaticProductPredicate); Works
        /* Predicate<Product> pred = p -> p.getPrice() >= 100.0;
        list.removeIf(pred); Works */
        list.removeIf(p -> p.getPrice() >= 100);

        for (Product p : list){
            System.out.println(p);
        }



    }
}

package functionalInterface.application;

import functionalInterface.model.entities.Product;
import functionalInterface.model.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class NewFunctions {
    public static void main(String[] Args){

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        ProductService ps = new ProductService();

        double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');
        // Here, we can use any predicate to make a test

        System.out.println("Sum: " + String.format("%.2f", sum));
    }
}

package lambda.application;

import lambda.model.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] Args){

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        /*Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }
        };
        This will work, First Comparator */

        /*Comparator<Product> comp = (p1, p2) -> {
            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        };
        This will work. Second Comparator, using arrow function and return. */

        /*Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        This will work. Third Comparator, using arrow function, without return */

        // list.sort(new MyComparator()); This will work.

        // list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase())); This will work

        list.sort(Comparator.comparing(p -> p.getName().toUpperCase()));

        for(Product p : list){
            System.out.println(p);
        }

    }
}

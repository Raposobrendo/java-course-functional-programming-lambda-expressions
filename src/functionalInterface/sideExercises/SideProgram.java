package functionalInterface.sideExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SideProgram {
    public static void main(String[] Args){

        List<SideProduct> prod = new ArrayList<>();

        prod.add(new SideProduct("TV", 2000.0));
        prod.add(new SideProduct("PC", 6000.0));
        prod.add(new SideProduct("Mouse", 45.0));
        prod.add(new SideProduct("Notebook", 4000.0));
        prod.add(new SideProduct("Desk", 500.0));


        List <String> names = prod.stream().filter(p -> p.getPrice() > 50).sorted(Comparator.comparing((SideProduct::getPrice))).map(p -> p.getName().toUpperCase()).toList();

        System.out.println(names);


    }

}

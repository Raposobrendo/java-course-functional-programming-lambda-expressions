package exercise2.application;

import exercise2.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Program {
    public static void main(String[] Args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String path = "C:\\temp\\in6.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Employee> list = new ArrayList<>();
            String line = br.readLine();

            while(line != null){

                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Input the minimum salary: ");
            double minSalary = sc.nextDouble();
            System.out.println("E-mail of people whose salary is bigger than $" + String.format("%.2f", minSalary));

            Comparator<String> comp = Comparator.comparing(String::toUpperCase);
            List<String> emailBiggerSalary = list.stream().filter(x -> x.getSalary() > minSalary).map(Employee::getEmail).sorted(comp).toList();
            emailBiggerSalary.forEach(System.out::println);


            System.out.print("Input the first letter of the wanted Employee: ");
            char initialLetter = sc.next().toUpperCase().charAt(0);
            double totalSalaryInitialLetter = list.stream()
                    .filter(x -> x.getName().charAt(0) == initialLetter)
                    .map(Employee::getSalary)
                    .reduce(0.0, Double::sum);
            System.out.println("Sum of salary of people whose name starts with '" + initialLetter + "': $" + String.format("%.2f", totalSalaryInitialLetter));

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package java8features;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Method reference is a short form of lambda expression.
 * Method reference uses :: symbol.
 */
public class MethodReferenceExmpl {
    static List<Employee> employees;

    public static List<Integer> stringToIntegers(List<String> stringNumbers) {
        return stringNumbers.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public static List<Integer> stringLength(List<String> names) {
        return names.stream().map(String::length).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<String> names = List.of("world", "hello", "hai");

        // using lambda expression
        names.forEach(name -> System.out.println(name));

        // using method reference, here variable name take care by the method reference.
        names.forEach(System.out::println);

        System.out.println();
        List<String> names1 = List.of("world", "hello", "hai", "", "");
        names1.stream().filter(name -> !name.isEmpty()).forEach(System.out::println);

        // using method reference in filter.
        System.out.println();
        names1.stream().filter(String::isEmpty).forEach(System.out::println);
        employees = List.of(new Employee(1, "raju", 100d),
                new Employee(2, "ravi", 15000d),
                new Employee(3, "ramu", 15000d));
        // Note: In java when we print the reference variable then it is
        // automatically call toString() method.
        System.out.println();
        employees.stream().filter(Employee::salarayCheck).forEach(System.out::println);
        System.out.println("Name starts with r");
        employees.stream().filter(Employee::nameCheck).forEach(System.out::println);

        // method reference with map
        System.out.println();
        System.out.println("String to integer using map and method reference");
        List<String> stringNumbers = List.of("1", "2", "3", "4", "5");
        List<Integer> integers = stringToIntegers(stringNumbers);
        integers.forEach(System.out::println);

        System.out.println();
        System.out.println("String length using map and method reference");
        List<Integer> striglengsths = stringLength(names1);
        striglengsths.forEach(System.out::println);

        System.out.println();
        System.out.println("using reduece and without method reference");
        List<Integer> nums = List.of(1,2,3,4,5,6,7);
        Integer result = nums.stream().reduce((num1,num2)-> num1+num2).get();
        System.out.println(result);
        System.out.println("using reduece and method reference");
        nums.stream().reduce(Integer::sum).ifPresent(System.out::println);        
    }
}

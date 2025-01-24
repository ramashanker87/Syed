import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Aqeel ", 28, "PEGASYSTEMS", "E001", 55000));
        employees.add(new Employee("Abhinav", 32, "ORACLE", "E002", 65000));
        employees.add(new Employee("Chandu", 25, "TECH", "E003", 45000));
        employees.add(new Employee("Rishik", 35, "Tech-Mahindra", "E004", 35000));
        employees.add(new Employee("Shivathmik", 27, "Carelon", "E005", 52000));

        System.out.println("\nEmployees with salary > 50000:");
        employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .forEach(System.out::println);


        System.out.println("\nEmployees with age < 30:");
        employees.stream()
                .filter(e -> e.getAge() < 30)
                .forEach(System.out::println);


        Map<String, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getName, e -> e));


        System.out.println("\nEmployees from map with salary < 40000:");
        employeeMap.values().stream()
                .filter(e -> e.getSalary() < 40000)
                .forEach(System.out::println);

        System.out.println("\nEmployees from map with age > 25:");
        employeeMap.values().stream()
                .filter(e -> e.getAge() > 25)
                .forEach(System.out::println);
    }
}
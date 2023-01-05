import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Company magnit = new Company(1000001.0);
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            employeeList.add(new Operator(magnit));
        }
        for (int i = 0; i < 80; i++) {
            employeeList.add(new Manager(magnit));
        }
        for (int i = 0; i < 10; i++) {
            employeeList.add(new TopManager(magnit));
        }
        magnit.hireAll(employeeList);
        System.out.println("Итого: " + magnit.getEmployees().size());
        System.out.println(magnit.getTopSalaryStaff(10));
        System.out.println(magnit.getLowersSalaryStaff(30));

        for (int i = 0; i < employeeList.size() / 2; i++) {
            magnit.fire(employeeList.get(i));
        }
        System.out.println("Осталось: " + magnit.getEmployees().size());
        System.out.println(magnit.getTopSalaryStaff(10));
        System.out.println(magnit.getLowersSalaryStaff(30));
    }
}
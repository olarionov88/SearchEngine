import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    public double income;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Company(double income) {
        this.income = income;
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort(Comparator.comparing(Employee::getMonthSalary).reversed());
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(employees.get(i));
        }
        return result;
    }
    public List<Employee> getLowersSalaryStaff(int count) {
        employees.sort(Comparator.comparing(Employee::getMonthSalary));
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(employees.get(i));
        }
        return result;
    }
    public void hire(Employee employee) {
        if (employee != null) {
            employees.add(employee);
        }
    }
    public void hireAll(List<Employee> employeeList) {
        employees.addAll(employeeList);
    }
    public void fire(Employee employee) {
        if (employee != null) {
            employees.remove(employee);
        }
    }
    public double getIncome() {
        return income;
    }
}
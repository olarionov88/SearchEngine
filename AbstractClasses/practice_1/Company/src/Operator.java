public class Operator
        implements Employee {
    private static final double FIX_SALARY = 18000.0;
    private Company company;
    private double salary;

    public Operator(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public double getMonthSalary() {
        return FIX_SALARY;
    }

    @Override
    public String toString() {
        return getClass().getName() + " ЗП: " + salary + " руб.\n";
    }
}

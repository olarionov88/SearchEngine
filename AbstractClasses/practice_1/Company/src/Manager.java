public class Manager
        implements Employee {
    private static final double FIX_SALARY = 20000.0;
    private double salary;
    private Company company;

    public Manager(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        return FIX_SALARY + Math.round(((Math.random() * 25000) + 115000) * 0.05);
    }

    @Override
    public String toString() {
        return getClass().getName() + " ЗП: " + salary + " руб.\n";
    }
}

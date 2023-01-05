public class TopManager
        implements Employee {
    private static final double FIX_SALARY = 50000.0;
    private double salary;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        if(company.income > 1000000.0) {
            return FIX_SALARY + FIX_SALARY * 1.5;
        }
        return FIX_SALARY;
    }

    @Override
    public String toString() {
        return getClass().getName() + " ЗП: " + salary + " руб.\n";
    }
}
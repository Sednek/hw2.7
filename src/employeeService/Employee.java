package employeeService;

public class Employee {

    private static int employeeID = 1;

    private final int id;

    private final String firstname;
    private final String middlename;
    private final String lastname;
    private int department;
    private double salary;

    public Employee(String firstname, String middlename, String lastname, int department, double salary) {
        this.id = employeeID++;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public String getFullName(){
        return lastname + " " + firstname + " " + middlename;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return String.format("id: %d, Имя: %s, Департамент: %d, Зарплата: %.2f\n", this.id, this.getFullName(), this.department, this.salary);
    }
}
import employeeService.Employee;
import employeeService.EmployeeBook;

public class Main {
    public static void main(String[] args) {
        Employee stas = new Employee("Stas", "Vladislavovich", "Demin", 1, 10000);
        Employee ivan = new Employee( "Ivan", "Sergeevich", "Tagintsev", 2, 15000);

        EmployeeBook eBook = new EmployeeBook();

        eBook.addEmployee(stas);
        eBook.addEmployee(ivan);

        eBook.addEmployee("Никита", "Владиславович", "Демин", 1, 50000);

        eBook.printEmployeesInfo();

        System.out.println(eBook.calculateAllMonthSalaries());

        eBook.printEmployeesNames();

        eBook.changeEmployeeSalary(stas, 20000);
        eBook.printEmployeesInfo();

        eBook.changeEmployeeDepartment(stas, 5);
        eBook.printEmployeesByDepartments();

        System.out.println(eBook.findMinSalaryEmployee());

        System.out.println(eBook.findMaxSalaryEmployee());

        System.out.println(eBook.findMedianSalary());

        eBook.fireEmployee(2);

        eBook.printEmployeesInfo();

    }
}
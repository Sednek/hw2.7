package employeeService;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private final Map<String, Employee> employees;

    private String getKey(Employee employee) {
        return employee.getFullName();
    }

    public EmployeeBook() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
            employees.put(getKey(employee), employee);
        }
    }

    public void addEmployee(String firstname, String middlename, String lastname, int department, double salary) {
        addEmployee(new Employee(firstname, middlename, lastname, department, salary));
    }

    public void fireEmployee(int id) {
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getId() == id) {
                key = entry.getKey();
                break;
            }
        }
        if (key != null) {
            employees.remove(key);
        }
    }

    public void changeEmployeeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        }
    }

    public void changeEmployeeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        Employee emp = employees.get(key);
        if (emp != null){
            emp.setDepartment(newDepartment);
        }
    }

    public void printEmployeesByDepartments() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел №" + i);
            for (Employee employee : employees.values()) {
                if (employee.getDepartment() == i) {
                    System.out.printf("id: %d, Имя: %s, Зарплата: %.2f\n", employee.getId(), employee.getFullName(), employee.getSalary());
                }
            }
        }
    }


    public void printEmployeesInfo() {
        for (Employee employee : employees.values()) {
            System.out.println(employee.toString());
        }
    }

    public double calculateAllMonthSalaries() {
        double sum = 0;

        for (Employee employee : employees.values()) {
            sum = sum + employee.getSalary();
        }
        return sum;
    }

    public Employee findMinSalaryEmployee() {
        double minSalary = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees.values()) {
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
            }
        }
        for (Employee employee : employees.values()) {
            if (minSalary == employee.getSalary()) {
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee findMaxSalaryEmployee() {
        double maxSalary = 0;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees.values()) {
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        for (Employee employee : employees.values()) {
            if (maxSalary == employee.getSalary()) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public double findMedianSalary() {
        double sum = calculateAllMonthSalaries();
        double median;
        int numOfEmployees = 0;
        for (Employee ignored : employees.values()) {
            numOfEmployees++;
        }

        median = sum / (double) numOfEmployees;

        return median;
    }

    public void printEmployeesNames() {
        for (Employee e : employees.values()) {
            System.out.println(e.getFullName());
        }
    }
}

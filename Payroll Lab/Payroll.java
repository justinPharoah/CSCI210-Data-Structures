import java.io.*;
import java.util.*;

/**
 * Payroll Class
 *
 * @author Justin Ferrell
 */
class Payroll {
    private PrintWriter pw;
    private Scanner sc;

    private Employee emp;
    private ObjectList employeeList;

    /**
     * Overloaded One Argument Constructor
     *
     * @param pw PrintWriter object for printing output to text file
     */
    Payroll(PrintWriter pw) {
        this.pw = pw;
        employeeList = new ObjectList();
    }

    /**
     * Read data from file, place in Employee object, place in ObjectList
     *
     * @param fileName file to be read in
     * @throws IOException throws file handling error
     */
    void readInEmployees(String fileName) throws IOException {
        System.out.println("Part A: Reading in " + fileName);
        pw.println("Part A: Reading in " + fileName);
        readInFile(fileName, 1);
        System.out.println("Part A Complete: See Part B for confirmation. \n");
        pw.println("Part A Complete: See Part B for confirmation. \n");
    }

    /**
     * Output contents of each ObjectListNode into a table format
     *
     * @return void
     */
    void outputTable() {
        System.out.println("Part B: Employees on Payroll");
        pw.println("Part B: Employees on Payroll");
        printEmployeeData(1);
        System.out.println();
        pw.println();
    }

    /**
     * Output number of employees on payroll
     *
     * @return void
     */
    void outputNumEmployees() {
        System.out.println("Part C: Number of Employees");
        pw.println("Part C: Number of Employees");
        System.out.println("Number Employed: " + employeeList.size() + " employees");
        pw.println("Number Employed: " + employeeList.size() + " employees");
        System.out.println();
        pw.println();
    }

    /**
     * Output first and last name of women on payroll
     *
     * @return void
     */
    void outputWomenNames() {
        System.out.println("Part D: Women on Payroll");
        pw.println("Part D: Women on Payroll");
        System.out.printf("%s %19s", "First Name", "Last Name" + "\n");
        pw.printf("%s %19s", "First Name", "Last Name" + "\n");
        ObjectListNode p = employeeList.getFirstNode();

        while (p != null) {
            String firstName = ((Employee) p.getInfo()).getFirstName();
            String lastName = ((Employee) p.getInfo()).getLastName();

            if (((Employee) p.getInfo()).getGender() == 0) {
                System.out.println(String.format("%-19s %s", firstName, lastName));
                pw.println(String.format("%-19s %s", firstName, lastName));
            }
            p = p.getNext();
        }
        System.out.println();
        pw.println();
    }

    /**
     * Output first and last names and salary of weekly employees if
     * they make $35k+ per year and have 5 year tenure
     *
     * @return void
     */
    void outputWeekly() {
        System.out.println("Part E: Weekly Employees w/ $35k+ Salary, 5 Year Tenure");
        pw.println("Part E: Weekly Employees w/ $35k+ Salary, 5 Year Tenure");
        System.out.printf("%s %19s %16s", "First Name", "Last Name", "Salary" + "\n");
        pw.printf("%s %19s %16s", "First Name", "Last Name", "Salary" + "\n");
        ObjectListNode p = employeeList.getFirstNode();

        while (p != null) {
            String firstName = ((Employee) p.getInfo()).getFirstName();
            String lastName = ((Employee) p.getInfo()).getLastName();
            double salary = ((Employee) p.getInfo()).getSalary();
            int rate = ((Employee) p.getInfo()).getRate();

            double yearSalary = salary * 52;

            if (rate == 1 && yearSalary > 35000 && ((Employee) p.getInfo()).getTenure() >= 5) {
                System.out.println(String.format("%-20s %-18s %.2f", firstName, lastName, salary));
                pw.println(String.format("%-20s %-18s %.2f", firstName, lastName, salary));
            }
            p = p.getNext();
        }
        System.out.println();
        pw.println();
    }

    /**
     * $.75 raise to certain hourly employees, $50.00 raise to certain weekly employees, prints out data
     *
     * @return void
     */
    void giveRaise() {
        System.out.println("Part F: Employee Raises");
        pw.println("Part F: Employee Raises");
        ObjectListNode p = employeeList.getFirstNode();
        System.out.printf("%s %19s %16s", "First Name", "Last Name", "Salary" + "\n");
        pw.printf("%s %19s %16s", "First Name", "Last Name", "Salary" + "\n");

        String firstName, lastName;
        int rate;
        double salary, newSalary;

        while (p != null) {
            firstName = ((Employee) p.getInfo()).getFirstName();
            lastName = ((Employee) p.getInfo()).getLastName();
            rate = ((Employee) p.getInfo()).getRate();
            salary = ((Employee) p.getInfo()).getSalary();

            if (rate == 0) {
                if (salary < 10.00)
                    ((Employee) p.getInfo()).setSalary(salary + .75);
            } else if (salary < 350.00)
                ((Employee) p.getInfo()).setSalary(salary + 50.00);

            newSalary = ((Employee) p.getInfo()).getSalary();

            if (salary < newSalary) {
                System.out.println(String.format("%-20s %-18s %.2f", firstName, lastName, newSalary));
                pw.println(String.format("%-20s %-18s %.2f", firstName, lastName, newSalary));
            }
            p = p.getNext();
        }
        System.out.println();
        pw.println();
    }

    /**
     * Sorts all employees on payroll into alphabetical order
     *
     * @return void
     */
    void sortEmployees() {
        System.out.println("Part G: Sort Employees by Last Name");
        pw.println("Part G: Sort Employees by Last Name");
        ObjectList sortedList = new ObjectList();
        Object object;
        ObjectListNode p;
        Employee employee;
        System.out.printf("%s %19s %16s", "First Name", "Last Name", "Salary" + "\n");
        pw.printf("%s %19s %16s", "First Name", "Last Name", "Salary" + "\n");
        while (employeeList.getFirstNode() != null) {
            object = employeeList.removeFirst();
            sortedList.insert(object);
        }
        employeeList = sortedList;
        p = employeeList.getFirstNode();
        while (p != null) {
            employee = (Employee) p.getInfo();
            System.out.println(String.format("%-20s %-18s %.2f",
                    employee.getFirstName(), employee.getLastName(), employee.getSalary()));
            pw.println(String.format("%-20s %-18s %.2f",
                    employee.getFirstName(), employee.getLastName(), employee.getSalary()));
            p = p.getNext();
        }
        System.out.println();
        pw.println();
    }

    /**
     * Hires new employees, inserts them into ObjectList, prints updated list of employees
     *
     * @param fileName file to be read in
     * @throws IOException throws file handling error
     */
    void hireEmployees(String fileName) throws IOException {
        System.out.println("Part H: Hiring Employees from " + fileName);
        pw.println("Part H: Hiring Employees from " + fileName);
        readInFile(fileName, 1);
        printEmployeeData(2);
        System.out.println();
        pw.println();
    }

    /**
     * Fires employees, removes them from ObjectList, and prints updated list of employees
     *
     * @param fileName file to be read in
     * @throws IOException throws file handling error
     */
    void fireEmployees(String fileName) throws IOException {
        System.out.println("Part I: Firing Employees from " + fileName);
        pw.println("Part I: Firing Employees from " + fileName);
        readInFile(fileName, 2);
        printEmployeeData(2);
        System.out.println();
        pw.println();
    }

    /**
     * Reads in a given Employee file, creates an Employee object for each Employee, adds it to list
     * Enter choice 1 for Six-Arg ctor, choice 2 for Two-Arg ctor
     *
     * @param fileName file to be read in
     * @param choice   determines Employee ctor to be used
     * @throws IOException throws file handling error
     */
    private void readInFile(String fileName, int choice) throws IOException {
        switch (choice) {
            case 1:
                sc = new Scanner(new File(fileName));

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String delims = "[ ]++";
                    String[] tokens = line.split(delims);

                    String firstName = tokens[0];
                    String lastName = tokens[1];

                    int gender;
                    if (tokens[2].equals("F")) gender = 0;
                    else gender = 1;

                    int tenure = Integer.parseInt(tokens[3]);

                    int rate;
                    if (tokens[4].equals("H")) rate = 0;
                    else rate = 1;

                    double salary = Double.parseDouble(tokens[5]);

                    emp = new Employee(firstName, lastName, gender, tenure, rate, salary);
                    employeeList.insert(emp);
                }
                break;
            case 2:
                sc = new Scanner(new File(fileName));

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String delims = "[ ]++";
                    String[] tokens = line.split(delims);

                    String firstName = tokens[0];
                    String lastName = tokens[1];

                    emp = new Employee(firstName, lastName);
                    employeeList.remove(emp);
                }
                break;
        }
    }

    /**
     * Prints firstname, lastname, gender, tenure, rate, and salary for choice 1
     * Prints firstname, lastname for choice 2
     *
     * @param choice which print method to be used
     * @return void
     */
    private void printEmployeeData(int choice) {
        switch (choice) {
            case 1:
                System.out.printf("%s %19s %16s %16s %14s %16s",
                        "First Name", "Last Name", "Gender", "Tenure", "Rate", "Salary" + "\n");
                pw.printf("%s %19s %16s %16s %14s %16s",
                        "First Name", "Last Name", "Gender", "Tenure", "Rate", "Salary" + "\n");
                ObjectListNode p = employeeList.getFirstNode();
                while (p != null) {
                    String firstName = ((Employee) p.getInfo()).getFirstName();
                    String lastName = ((Employee) p.getInfo()).getLastName();
                    String gender = ((Employee) p.getInfo()).getGender() == 0 ? "F" : "M";
                    int tenure = ((Employee) p.getInfo()).getTenure();
                    String rate = ((Employee) p.getInfo()).getGender() == 0 ? "H" : "W";
                    double salary = ((Employee) p.getInfo()).getSalary();

                    System.out.println(String.format("%-20s %-19s %-16s %-16s %-13s %.2f",
                            firstName, lastName, gender, tenure, rate, salary));
                    pw.println(String.format("%-20s %-19s %-16s %-16s %-13s %.2f",
                            firstName, lastName, gender, tenure, rate, salary));
                    p = p.getNext();
                }
                break;
            case 2:
                System.out.printf("%s %19s", "First Name", "Last Name" + "\n");
                pw.printf("%s %19s", "First Name", "Last Name" + "\n");
                ObjectListNode q = employeeList.getFirstNode();
                while (q != null) {
                    String firstName = ((Employee) q.getInfo()).getFirstName();
                    String lastName = ((Employee) q.getInfo()).getLastName();

                    System.out.println(String.format("%-19s %s", firstName, lastName));
                    pw.println(String.format("%-19s %s", firstName, lastName));
                    q = q.getNext();
                }
        }
    }
}

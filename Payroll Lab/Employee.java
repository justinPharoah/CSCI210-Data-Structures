/**
 * Employee Class
 * @author Justin Ferrell
 */
public class Employee implements Comparable {
    private String firstName, lastName;
    private int gender; //0 for F, 1 for M
    private int tenure;
    private int rate; //0 for Hourly, 1 for Weekly
    private double salary;

    /**
     * Overloaded, Two Arg Constructor
     *
     * @param firstName first name of employee
     * @param lastName last name of employee
     */
    Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Overloaded, Six Arg Constructor
     *
     * @param firstName first name of employee
     * @param lastName last name of employee
     * @param gender gender of employee
     * @param tenure tenure of employee
     * @param rate pay rate of employee
     * @param salary salary of employee
     */
    Employee(String firstName, String lastName, int gender, int tenure, int rate, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.tenure = tenure;
        this.rate = rate;
        this.salary = salary;
    }

    /**
     * Returns the first name of employee
     * @return String firstName
     */
    String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of employee
     * @return String lastName
     */
    String getLastName() {
        return lastName;
    }

    /**
     * Returns gender of employee
     * @return int 0 representing F, 1 representing M
     */
    int getGender() {
        return gender;
    }

    /**
     * Returns tenure of employee
     * @return int tenure
     */
    int getTenure() {
        return tenure;
    }

    /**
     * Returns pay rate of employee
     * @return int 0 representing hourly, 1 representing weekly
     */
    int getRate() {
        return rate;
    }

    /**
     * Returns salary of employee
     * @return double salary
     */
    double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of an employee
     *
     * @param salary new salary to be set
     * @return void
     */
    void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Compares two last names and returns int determining which one comes first
     *
     * @param o Object object to be compared
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        Employee emp = (Employee) o;
        if(!lastName.equals(emp.getLastName())) //Makes sure if last name is the same, gets compared by first name
            return lastName.compareTo(emp.getLastName());
        else
            return firstName.compareTo(emp.getFirstName());
    }
}

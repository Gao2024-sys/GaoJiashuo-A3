// Employee.java
// Employee.java
public class Employee extends Person {
    private String position;
    private double salary;

    // Default constructor
    public Employee() {
        super(); // Calls the default constructor of Person
        this.position = "";
        this.salary = 0.0;
    }

    // Constructor with parameters
    public Employee(String name, int age, String id, String position, double salary) {
        super(name, age, id); // Calls the parameterized constructor of Person
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
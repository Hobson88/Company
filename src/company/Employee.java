package company;

public class Employee {
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, lastName);
    }

    public String getLastName() {
        return lastName;
    }
}

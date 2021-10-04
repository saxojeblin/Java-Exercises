package ex42;

public class Person {
    private String fName;
    private String lName;
    private int salary;

    public Person (String fName1, String lName1, int sal) {
        //Person's first name, last name, and salary
        fName = fName1;
        lName = lName1;
        salary = sal;
    }
    //Method to return first name
    public String getFirstName() {
        return fName;
    }
    //Method to return last name
    public String getLastName() {
        return lName;
    }
    //Method to return salary
    public int getSalary() {
        return salary;
    }
}

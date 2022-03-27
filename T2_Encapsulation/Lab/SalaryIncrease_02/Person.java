package T2_Encapsulation.Lab.SalaryIncrease_02;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    private void setFirstName(String firstName) {
        if (firstName.length() >= 3) {
            this.firstName = firstName;
        }else {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
    }

    private void setLastName(String lastName) {
        if (lastName.length() >= 3) {
            this.lastName = lastName;
        }else {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
    }

    private void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }else {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
    }

    private void setSalary(double salary) {
        if (salary >= 460) {
            this.salary = salary;
        }else {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
    }

    public void increaseSalary(double bonus){
        if (this.age >= 30){
            double increase = this.salary * bonus / 100;
            setSalary(this.salary + increase);
        }else {
            double increase = this.salary * bonus / 200;
            setSalary(this.salary + increase);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",this.firstName,this.lastName,this.salary);
    }
}

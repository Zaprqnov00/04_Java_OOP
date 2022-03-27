package T1_Abstraction.Lab.StudentSystem_03;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void showStudent(String name) {

        if (this.grade >= 5.00) {
            System.out.printf("%s is %d years old. Excellent student.\n",this.name,this.age);
        } else if (this.grade < 5.00 && this.grade >= 3.50) {
            System.out.printf("%s is %d years old. Average student.\n",this.name,this.age);
        } else {
            System.out.printf("%s is %d years old. Very nice person.\n",this.name,this.age);
        }
    }
}

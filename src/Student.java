public class Student extends Person {
int year;
int StudentNumber;
double GPA;
String Department;

    public Student(int year, int StudentNumber, double GPA, String Department, String name, int ID) {
        super(name, ID);
        this.year = year;
        this.StudentNumber = StudentNumber;
        this.GPA = GPA;
        this.Department = Department;
    }

    public int getYear() {
        return year;
    }

    public int getStudentNumber() {
        return StudentNumber;
    }

    public double getGPA() {
        return GPA;
    }

    public String getDepartment() {
        return Department;
    }


    public void setYear(int year) {
        this.year = year;
    }

    public void setStudentNumber(int StudentNumber) {
        this.StudentNumber = StudentNumber;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
 public String toString(){
 return "Student Name :"+name
           +"\n ID :"+ID
           +"\n Year :"+year
           +"\n Student Number :"+StudentNumber
           +"\n GPA :"+GPA
           +"\n Department"+Department;
 }
}


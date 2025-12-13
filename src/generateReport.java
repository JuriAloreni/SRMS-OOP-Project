import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ReportGeneroter {

    public static void generateReport(StudentRecordManager manager, String fileName)  {
        
ArrayList<Student> students = new ArrayList<>(manager.getStudents());

    try (FileWriter writer = new FileWriter(fileName)) {

    String report=("--- Report for studunt by GPA and department---\n\n");
            //print file path
        File f = new File(fileName);
    System.out.println("file save here :" + f.getAbsolutePath());
        
    writer.write(report);//here print in file
    
    System.out.println(report);//print in console
            
       //group by department      
    for (int i = 0; i < students.size(); i++) {

    String dept = students.get(i).getDepartment();

    //check if this department preanted before

    boolean printed = false;
    
    //check if the department already printed

    for (int j = 0; j < i; j++) {
        
    if (students.get(j).getDepartment().equals(dept)) {
        
    printed = true;
    
    break;
}
    }
               
    if (printed) continue;
    //print this in file and console
    String dept1=("Department: " + dept + "\n------------------------\n");
 
    writer.write(dept1);
 
    System.out.println(dept1);
    
    ArrayList<Student> deptStudents = new ArrayList<>();
   
       
    for (Student s : students) {
    if (s.getDepartment().equals(dept)) {
        deptStudents.add(s);}
    }
                
    // sort student by gpa
    deptStudents.sort((a, b) -> Double.compare(b.getGPA(), a.getGPA()) );

    //  print student
    for (Student s : deptStudents) {

    String printdetails = 
    "Student Number: " + s.getStudentNumber() +", Name: " + s.getName() +
    ", GPA: " + s.getGPA() +", Year: " + s.getYear() + "\n";
    
    writer.write(printdetails); 
    
    System.out.println(printdetails);
                }
    }                         
    System.out.println("Report successfully generated :" + fileName);   
    }
    catch (IOException e){
    System.out.println("Report Error: " + e.getMessage());}
}
}

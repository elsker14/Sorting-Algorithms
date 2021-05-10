package backendSrc;

import objectClasses.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //The Work-in-progress Backend
    public static void main(String[] args) {

        List<Student> studentsDB = new ArrayList<>();
        studentsDB = Student.hardcodeStudents();

        Student.sortStudents(studentsDB);
        Student.printStudents(studentsDB);
    }
}

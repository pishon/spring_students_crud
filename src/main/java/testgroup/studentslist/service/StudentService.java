package testgroup.studentslist.service;
import testgroup.studentslist.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> allStudents();
    void add(Student student);
    void delete(Student student);
    void edit(Student student);
    Student getById(int id);
}

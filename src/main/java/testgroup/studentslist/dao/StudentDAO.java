package testgroup.studentslist.dao;
import testgroup.studentslist.model.Student;
import java.util.List;

public interface StudentDAO {
    List<Student> allStudents();
    void add(Student student);
    void delete(Student student);
    void edit(Student student);
    Student getById(int id);
}

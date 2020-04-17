package testgroup.studentslist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.studentslist.dao.StudentDAO;
import testgroup.studentslist.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional  //выполняем в транзакции
    public List<Student> allStudents() {
        return studentDAO.allStudents();
    }

    @Transactional
    public void add(Student student) {
        studentDAO.add(student);
    }

    @Transactional
    public void delete(Student student) {
        studentDAO.delete(student);
    }

    @Transactional
    public void edit(Student student) {
        studentDAO.edit(student);
    }

    @Transactional
    public Student getById(int id) {
        return studentDAO.getById(id);
    }
}

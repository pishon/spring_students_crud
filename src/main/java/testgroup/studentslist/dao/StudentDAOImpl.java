package testgroup.studentslist.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.studentslist.model.Student;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> allStudents() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student").list();  //здесь обращение к сущности. указывается имя класса
    }

    public void add(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    public void delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(student);
    }

    public void edit(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
    }

    public Student getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }
}

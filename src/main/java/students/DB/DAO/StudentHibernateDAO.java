package students.DB.DAO;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import students.DB.entitys.StudentEntitys;

import java.util.List;

@Repository
public class StudentHibernateDAO {

    @Autowired
    private SessionFactory factory;

    public List<StudentEntitys> getAll(){
        Session session = factory.openSession();
        List<StudentEntitys> students = session.createCriteria(StudentEntitys.class).list();
        session.close();
        return students;
    }

    public StudentEntitys getById(int id) {
        Session session = factory.openSession();
        StudentEntitys student = session.get(StudentEntitys.class, id);
        session.close();
        return student;
    }

    public void updateStudent(StudentEntitys student){
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }

    public void addStudent(StudentEntitys student) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

    public void delStudentById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(getById(id));
        session.getTransaction().commit();
        session.close();
    }




}

package students.services;

import org.springframework.stereotype.Service;
import students.DB.entitys.GroupEntity;
import students.DB.entitys.StudentEntitys;
import students.DB.repo.GroupRepo;
import students.DB.repo.StudentRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentRepo studentRepo;
    GroupRepo groupRepo;

    public StudentService(StudentRepo studentRepo, GroupRepo groupRepo) {
        this.studentRepo = studentRepo;
        this.groupRepo = groupRepo;
    }

    public List<StudentEntitys> getAllStudents() {
        Iterable<StudentEntitys> allStudents = studentRepo.findAll();
        List<StudentEntitys> students = new ArrayList<>();
        for (StudentEntitys student : allStudents) {
            students.add(student);
        }
        return students;
    }

    public List<GroupEntity> getAllGroups() {
        Iterable<GroupEntity> allGroups = groupRepo.findAll();
        List<GroupEntity> groups = new ArrayList<>();
        for (GroupEntity group : allGroups) {
            groups.add(group);
        }
        return groups;
    }

    public StudentEntitys getStudentById(int id) {
        return studentRepo.findOne(id);
    }

    public GroupEntity getGroupById(int id) {
        return groupRepo.findOne(id);
    }

    public void updateStudent(StudentEntitys student) {
        studentRepo.save(student);
    }

    public void addStudent(StudentEntitys student) {
        studentRepo.save(student);
    }

    public void delStudentById(int id) {
        studentRepo.delete(id);
    }
}

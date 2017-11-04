package students.DB.entitys;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class StudentEntitys {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Student_id_seq_gen")
    @SequenceGenerator(allocationSize = 1, name = "Student_id_seq_gen", sequenceName = "public.\"Student_id_seq\"")
    private int id;
    private int group_id;
    private String firstname;
    private String secondname;
    private String lastname;
    private LocalDate birthday;

    public StudentEntitys(int id, int group_id, String firstname, String secondname, String lastname, LocalDate birthday) {
        this.id = id;
        this.group_id = group_id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public StudentEntitys(int group_id, String firstname, String secondname, String lastname, LocalDate birthday) {
        this.group_id = group_id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public StudentEntitys() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}

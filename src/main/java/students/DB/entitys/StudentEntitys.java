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
    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;
    private String firstname;
    private String secondname;
    private String lastname;
    private LocalDate birthday;

    public StudentEntitys(GroupEntity group, String firstname, String secondname, String lastname, LocalDate birthday) {
        this.group = group;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public StudentEntitys(int id, GroupEntity group, String firstname, String secondname, String lastname, LocalDate birthday) {
        this.id = id;
        this.group = group;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public StudentEntitys() {
    }

    public GroupEntity getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }


    public String getSecondname() {
        return secondname;
    }


    public String getLastname() {
        return lastname;
    }


    public LocalDate getBirthday() {
        return birthday;
    }
}

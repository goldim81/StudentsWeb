package students.DB.DTO;

public class StudentDTO {
    private int id;
    private int group_id;
    private String firstname;
    private String secondname;
    private String lastname;

    public StudentDTO(int id, int group_id, String firstname, String secondname, String lastname) {
        this.id = id;
        this.group_id = group_id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public int getGroup_id() {
        return group_id;
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
}

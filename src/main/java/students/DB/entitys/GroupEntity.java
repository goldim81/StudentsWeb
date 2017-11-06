package students.DB.entitys;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupIdGen")
    @SequenceGenerator(allocationSize = 1, name = "groupIdGen", sequenceName = "public.\"Group_id_seq\"")
    private int id;
    private String name;

    public GroupEntity() {
    }

    public GroupEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

package students.DB.repo;

import org.springframework.data.repository.CrudRepository;
import students.DB.entitys.GroupEntity;

public interface GroupRepo extends CrudRepository<GroupEntity, Integer> {
}

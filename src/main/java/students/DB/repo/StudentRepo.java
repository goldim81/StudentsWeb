package students.DB.repo;

import org.springframework.data.repository.CrudRepository;
import students.DB.entitys.StudentEntitys;

public interface StudentRepo extends CrudRepository<StudentEntitys, Integer> {

}

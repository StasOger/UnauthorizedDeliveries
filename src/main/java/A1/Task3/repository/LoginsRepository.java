package A1.Task3.repository;

import A1.Task3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginsRepository extends JpaRepository<User, Long> {

}

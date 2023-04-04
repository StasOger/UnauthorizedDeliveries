package A1.Task3.repository;

import A1.Task3.model.Posting;
import A1.Task3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PostingsRepository extends JpaRepository<Posting, Long> {

    @Query("SELECT p FROM Posting p WHERE p.pstngDate >= ?1")
    List<Posting> findPostingsByPeriod(Date postingDate);

    @Query("SELECT p FROM Posting p WHERE p.pstngDate >= ?1 and p.autowiredPost = ?2")
    List<Posting> findPostingsByPeriodAndAutowired(Date postingDate, boolean isAutowiredPost);

}

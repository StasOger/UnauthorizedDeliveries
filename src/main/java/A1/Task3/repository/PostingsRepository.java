package A1.Task3.repository;

import A1.Task3.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostingsRepository extends JpaRepository<Posting, Long> {

    @Query("SELECT p FROM Posting p WHERE p.pstngDate = ?1")
    List<Posting> findPostingsByDay(Date postingDate);

    @Query("SELECT p FROM Posting p WHERE p.pstngDate = ?1 and p.autowiredPost = ?2")
    List<Posting> findPostingsByDayAndAutowired(Date postingDate, boolean isAutowiredPost);

    @Query("SELECT p FROM Posting p WHERE MONTH(p.pstngDate) = ?1")
    List<Posting> findPostingsByMonth(int month);

    @Query("SELECT p FROM Posting p WHERE MONTH(p.pstngDate) = ?1 and p.autowiredPost = ?2")
    List<Posting> findPostingsByMonthAndAutowired(int month, boolean isAutowiredPost);

    @Query("SELECT p FROM Posting p WHERE QUARTER(p.pstngDate) = ?1")
    List<Posting> findPostingsByQuarter(int quarter);

    @Query("SELECT p FROM Posting p WHERE QUARTER(p.pstngDate) = ?1 and p.autowiredPost = ?2")
    List<Posting> findPostingsByQuarterAndAutowired(int quarter, boolean isAutowiredPost);

    @Query("SELECT p FROM Posting p WHERE YEAR(p.pstngDate) = ?1")
    List<Posting> findPostingsByYear(int year);

    @Query("SELECT p FROM Posting p WHERE YEAR(p.pstngDate) = ?1 and p.autowiredPost = ?2")
    List<Posting> findPostingsByYearAndAutowired(int year, boolean isAutowiredPost);
}

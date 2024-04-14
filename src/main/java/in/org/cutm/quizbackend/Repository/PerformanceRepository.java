package in.org.cutm.quizbackend.Repository;

import in.org.cutm.quizbackend.Entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    public Performance getPerformanceByUid(Long uid);
}

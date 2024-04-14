package in.org.cutm.quizbackend.Service;

import in.org.cutm.quizbackend.Entity.Performance;
import in.org.cutm.quizbackend.Repository.PerformanceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {
    private  final PerformanceRepository performanceRepository;

    public PerformanceService(PerformanceRepository performanceRepository){this.performanceRepository=performanceRepository;}

    public Performance createperformance(Performance performance){
        return performanceRepository.save(performance);
    }

    public Performance getperformancebyUId(Long uid){
        return performanceRepository.getPerformanceByUid(uid);
    }

    public Performance updatePerformance(Long uid, Performance updatedperformance){
        Performance performance = getperformancebyUId(uid);
        performance.setCtech(updatedperformance.getCtech());
        performance.setCpptech(updatedperformance.getCpptech());
        performance.setCshtech(updatedperformance.getCshtech());
        performance.setJavatech(updatedperformance.getJavatech());
        performance.setDotnettech(updatedperformance.getDotnettech());
        performance.setPythontech(updatedperformance.getPythontech());
        performance.setJStech(updatedperformance.getJStech());
        performance.setReacttech(updatedperformance.getReacttech());
        performance.setAngulartech(updatedperformance.getAngulartech());
        performance.setRusttech(updatedperformance.getRusttech());
        performance.setKotlintech(updatedperformance.getKotlintech());
        performance.setExJStech(updatedperformance.getExJStech());
        return performanceRepository.save(performance);
    }

    public void deletePerformance(Long uid){
        Performance performance = getperformancebyUId(uid);
        performanceRepository.delete(performance);
    }

    public List<Performance> getallperformences(){

        return performanceRepository.findAll();
    }
}

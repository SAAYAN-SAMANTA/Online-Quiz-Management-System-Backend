package in.org.cutm.quizbackend.Controller;

import in.org.cutm.quizbackend.Entity.Performance;
import in.org.cutm.quizbackend.Service.PerformanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-performance")
@CrossOrigin(origins = "http://localhost:5173")
public class PerformanceController {

    private final PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService){ this.performanceService=performanceService; }

    @PostMapping("/createperformance")
    public Performance addperformance(@RequestBody Performance performance){
        return performanceService.createperformance(performance);
    }

    @GetMapping("/{uid}")
    public Performance getperformancebyuid(@PathVariable Long uid){
        return performanceService.getperformancebyUId(uid);
    }

    @PutMapping("/update-{uid}")
    public Performance updateperformence(@PathVariable Long uid, @RequestBody Performance updatedperformance){
        return performanceService.updatePerformance(uid, updatedperformance);
    }

    @DeleteMapping("/delete-{uid}")
    public void deleteperformance(@PathVariable Long uid){
        performanceService.deletePerformance(uid);
    }

    @GetMapping("/all")
    public List<Performance> getallperformances(){
        return performanceService.getallperformences();
    }
}

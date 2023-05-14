package tutorials.javase;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")


public class TestController
{

    @Autowired
    private TestService testService;

    @GetMapping("/test/{id}")
    public Object getTestById(@PathVariable Long id)
    {
        return testService.getTestById(id);
    }

    @PostMapping("/test/submit")
    public boolean submitTest(@RequestBody TestSubmission submission)
    {
        return testService.submitTest(submission);
    }

}

@Service
class TestService {

    @Autowired
    private TestRepository testRepository;

    public Object getTestById(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    public boolean submitTest(TestSubmission submission) {
        // test cevaplarını kaydetme işlemleri
        return true;
    }

}

@Repository
interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findById(Long id);
}



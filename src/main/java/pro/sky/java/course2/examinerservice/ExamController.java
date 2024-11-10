package pro.sky.java.course2.examinerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.exception.RequestedMoreQuestionsThanExistInServiceException;

import java.util.List;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }



    public List<Question> getQuestions(@RequestParam("amount") int amount) throws RequestedMoreQuestionsThanExistInServiceException {
        return examinerService.getQuestions(amount);
    }
}
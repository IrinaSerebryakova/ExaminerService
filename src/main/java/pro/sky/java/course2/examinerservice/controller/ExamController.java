package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.service.impl.ExaminerServiceImpl;
import pro.sky.java.course2.examinerservice.model.Question;
import pro.sky.java.course2.examinerservice.exception.RequestedMoreQuestionsThanExistInServiceException;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam/get")
public class ExamController {
    private final ExaminerServiceImpl examinerService;
    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    public Collection<Question> getQuestion(@RequestParam("amount") int amount) throws RequestedMoreQuestionsThanExistInServiceException {
        return examinerService.getQuestion(amount);
    }
}
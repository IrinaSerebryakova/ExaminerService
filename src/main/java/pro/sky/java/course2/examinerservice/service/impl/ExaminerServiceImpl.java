package pro.sky.java.course2.examinerservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.model.Question;
import pro.sky.java.course2.examinerservice.exception.RequestedMoreQuestionsThanExistInServiceException;
import pro.sky.java.course2.examinerservice.service.api.ExaminerService;
import pro.sky.java.course2.examinerservice.service.api.QuestionService;


import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Iterator<Question> iterator;
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
@Override
    public Collection<Question> getQuestion(int amount) {
    int countOfQuestions = questionService.getAll().size();
     if (amount > countOfQuestions) {
        throw new RequestedMoreQuestionsThanExistInServiceException("Запрошено больше вопросов, чем существует!");
    }
    Set<Question> questions = new HashSet<>();
        while (amount > questions.size()) {
        questions.add(questionService.getRandomQuestion());
    }
    return questions;
    }
}


package pro.sky.java.course2.examinerservice.service.api;

import pro.sky.java.course2.examinerservice.model.Question;
import pro.sky.java.course2.examinerservice.exception.RequestedMoreQuestionsThanExistInServiceException;

import java.util.Collection;


public interface ExaminerService{
    Collection<Question> getQuestion (int amount);

}
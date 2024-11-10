package pro.sky.java.course2.examinerservice;

import pro.sky.java.course2.examinerservice.exception.RequestedMoreQuestionsThanExistInServiceException;
import java.util.List;

public interface ExaminerService{
    List<Question> getQuestions (int amount) throws RequestedMoreQuestionsThanExistInServiceException;

}

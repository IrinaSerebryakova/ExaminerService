package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class QuestionAndAnswerHaveTheSameMeaningException extends RuntimeException{
    public QuestionAndAnswerHaveTheSameMeaningException(String message){
       super(message);
    }
}

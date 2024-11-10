package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class QuestionAlreadyAddedException extends RuntimeException{
    public QuestionAlreadyAddedException(String message) {
        super(message);
    }
}

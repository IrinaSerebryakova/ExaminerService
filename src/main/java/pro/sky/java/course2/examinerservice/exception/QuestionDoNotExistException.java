package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionDoNotExistException extends RuntimeException{

    public QuestionDoNotExistException(String message){
        super(message);
    }
}

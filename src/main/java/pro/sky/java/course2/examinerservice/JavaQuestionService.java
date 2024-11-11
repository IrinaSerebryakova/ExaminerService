package pro.sky.java.course2.examinerservice;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice.exception.QuestionAndAnswerHaveTheSameMeaningException;
import pro.sky.java.course2.examinerservice.exception.QuestionDoNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class JavaQuestionService implements QuestionService {
    List<Question> javaQuestions = new ArrayList<>();
    @Override
    public Question add(String question, String answer) {
        if (check(question, answer)) {
            Question newJavaQuestion = new Question(question, answer);
            if (!javaQuestions.contains(newJavaQuestion)) {
                javaQuestions.add(newJavaQuestion);
                return newJavaQuestion;
            }
        } throw new QuestionAlreadyAddedException("Такой вопрос уже существует!");
    }

    @Override
    public Question add(Question question) {
        if(!javaQuestions.contains(question)) {
            javaQuestions.add(question);
            return question;
        }
        throw new QuestionAlreadyAddedException("Такой вопрос уже существует!");
    }

    @Override
    public Question remove(Question question) {
        if(javaQuestions.contains(question)) {
            javaQuestions.remove(question);
            return question;
        }
        throw new QuestionDoNotExistException("Такой вопрос не существует!");
    }

    @Override
    public List<Question> getAll() {
        return javaQuestions;
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        return javaQuestions.get(r.nextInt(javaQuestions.size()));
    }

    @Override
    public boolean check(String question, String answer){
        if(!question.equals(answer)){
            return true;
        }
        throw new QuestionAndAnswerHaveTheSameMeaningException("Вопрос и ответ имеют одинаковое значение!");
    }
}


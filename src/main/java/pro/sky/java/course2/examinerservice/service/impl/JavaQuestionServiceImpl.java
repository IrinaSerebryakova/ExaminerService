package pro.sky.java.course2.examinerservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.model.Question;
import pro.sky.java.course2.examinerservice.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice.exception.QuestionDoNotExistException;
import pro.sky.java.course2.examinerservice.service.api.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final Random random = new Random();
    protected final Set<Question> javaQuestions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
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
    public Collection<Question> getAll() {
        return new HashSet<>(javaQuestions);
    }

    @Override
    public Question getRandomQuestion() throws QuestionDoNotExistException {
        return javaQuestions.stream()
                .skip(random.nextInt(javaQuestions.size()))
                .findFirst()
                .orElseThrow();
    }
}


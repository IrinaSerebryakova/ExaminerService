package pro.sky.java.course2.examinerservice;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice.exception.QuestionAndAnswerHaveTheSameMeaningException;
import pro.sky.java.course2.examinerservice.exception.QuestionDoNotExistException;
import pro.sky.java.course2.examinerservice.exception.RequestedMoreQuestionsThanExistInServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService, QuestionService {
    public Random random;
    public QuestionService questionService;
    private final List<Question> questions = new ArrayList<>();
    private final List<Question> randomQuestions = new ArrayList<>();
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<Question> getQuestions(int amount) throws RequestedMoreQuestionsThanExistInServiceException {
        for (int i = 0; i < amount; i++) {
            Question random = getRandomQuestion();
            if (!randomQuestions.contains(random)) {
                randomQuestions.add(random);
          }
        }
            return randomQuestions;
    }

    @Override
    public Question add(String question, String answer) {
        if (check(question, answer)) {
            Question newQuestion = new Question(question, answer);

            if (!questions.contains(newQuestion)) {
                questions.add(newQuestion);
                return newQuestion;
            }
        }
        throw new QuestionAlreadyAddedException("Такой вопрос уже существует!");
    }

    @Override
    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
            return question;
        }
        throw new QuestionAlreadyAddedException("Такой вопрос уже существует!");
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionDoNotExistException("Такой вопрос не существует!");
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random r = new Random();
        return questions.get(r.nextInt(questions.size()));
    }

    @Override
    public boolean check(String question, String answer){
        if(!question.equals(answer)){
            return true;
        }
        throw new QuestionAndAnswerHaveTheSameMeaningException("Вопрос и ответ имеют одинаковое значение!");
    }
}


package pro.sky.java.course2.examinerservice;

import java.util.List;
public interface QuestionService{
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    List<Question> getAll();
    Question getRandomQuestion();
    boolean check(String question, String answer);
}
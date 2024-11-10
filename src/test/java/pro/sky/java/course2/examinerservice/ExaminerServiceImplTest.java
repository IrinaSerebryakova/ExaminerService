package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examinerservice.QuestionTestConstants.ANSWER;
import static pro.sky.java.course2.examinerservice.QuestionTestConstants.QUESTION;
class ExaminerServiceImplTest {
    private final List<Question> examinerQuestions = new ArrayList<>();
    private final QuestionService questionService;
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(questionService);
    @Test
    void getQuestions() {
    }

    @Test
    public void shouldAddQuestionIfDoNotExist() {
        Question actual = examinerServiceTest.add(QUESTION, ANSWER);

        assertEquals(actual.getQuestion(), QUESTION);
        assertEquals(actual.getAnswer(), ANSWER);
    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getRandomQuestion() {
    }

    @Test
    void check() {
    }
}
package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examinerservice.QuestionTestConstants.*;

import pro.sky.java.course2.examinerservice.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice.exception.QuestionDoNotExistException;
import pro.sky.java.course2.examinerservice.model.Question;
import pro.sky.java.course2.examinerservice.service.impl.JavaQuestionServiceImpl;

import java.util.Random;

public class JavaQuestionServiceTest {
    private final JavaQuestionServiceImpl testJavaService = new JavaQuestionServiceImpl();
    @Test
    public void shouldAddQuestionIfDoNotExist() {
        assertTrue(testJavaService.getAll().isEmpty());
        Question actual = testJavaService.add(QUESTION, ANSWER);

        assertEquals(actual.getQuestion(), QUESTION);
        assertEquals(actual.getAnswer(), ANSWER);
        assertTrue(!testJavaService.getAll().isEmpty());
    }

    @Test
    public void shouldRemoveQuestionIfExist() {
        Question actual = testJavaService.add(QUESTION, ANSWER);
        Question remove = testJavaService.remove(actual);

        assertEquals(actual.getQuestion(), remove.getQuestion());
        assertEquals(actual.getAnswer(), remove.getAnswer());
        assertTrue(testJavaService.getAll().isEmpty());
    }

    @Test
    public void tryRemoveNotExistQuestionShouldThrowQuestionDoNotExistException() {
        Question remove = testJavaService.add(QUESTION, ANSWER);
        testJavaService.remove(remove);

        assertThrows(QuestionDoNotExistException.class,
                () -> testJavaService.remove(remove));
    }


    @Test
    public void tryAddAlreadyExistQuestionShouldThrowQuestionAlreadyAddedException() {
        Question actual = testJavaService.add(QUESTION, ANSWER);

        assertThrows(QuestionAlreadyAddedException.class,
                () -> testJavaService.add(actual));
    }

    @Test
    public void tryGetRandomQuestionWithGoodResult() {
        Random r = new Random();
        Question randomQuestion = QUESTION_JAVA_DATA.stream().toList().get(r.nextInt(QUESTION_JAVA_DATA.size()));
        testJavaService.add(randomQuestion);
        assertTrue(QUESTION_JAVA_DATA.contains(randomQuestion));
        assertTrue(!testJavaService.getAll().isEmpty());
    }
        }

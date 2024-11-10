package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examinerservice.QuestionTestConstants.*;

import pro.sky.java.course2.examinerservice.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice.exception.QuestionAndAnswerHaveTheSameMeaningException;
import pro.sky.java.course2.examinerservice.exception.QuestionDoNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class JavaQuestionServiceTest {
    JavaQuestionService testJavaService = new JavaQuestionService();
    @Test
    public void shouldAddQuestionIfDoNotExist() {
        Question actual = testJavaService.add(QUESTION, ANSWER);

        assertEquals(actual.getQuestion(), QUESTION);
        assertEquals(actual.getAnswer(), ANSWER);
    }

    @Test
    public void shouldRemoveQuestionIfExist() {
        Question actual = testJavaService.add(QUESTION, ANSWER);
        Question remove = testJavaService.remove(actual);

        assertEquals(actual.getQuestion(), remove.getQuestion());
        assertEquals(actual.getAnswer(), remove.getAnswer());
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
    public void tryAddWrongQuestionShouldThrowQuestionAndAnswerHaveTheSameMeaningException() {
        assertThrows(QuestionAndAnswerHaveTheSameMeaningException.class,
                () -> testJavaService.add(testJavaService.add(QUESTION, QUESTION)));
    }

    @Test
    public void tryGetRandomQuestionWithGoodResult() {
        Random r = new Random();
        Question randomQuestion = QUESTION_JAVA_DATA.get(r.nextInt(QUESTION_JAVA_DATA.size()));

        assertTrue(QUESTION_JAVA_DATA.contains(randomQuestion));
        }
    }
package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.examinerservice.exception.QuestionAndAnswerHaveTheSameMeaningException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.examinerservice.QuestionTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
  @Mock
  private QuestionService questionServiceMock = mock(QuestionService.class);
  @InjectMocks
  private ExaminerService examinerServiceMock = mock(ExaminerService.class);


    @Test
    void shouldGetFiveQuestions() {
      when(examinerServiceMock.getQuestions(5)).thenReturn(QUESTION_PROGRAMMING_DATA);

      assertEquals(QUESTION_PROGRAMMING_DATA, examinerServiceMock.getQuestions(5));
    }
    @Test
    public void shouldFindAddedQuestion() {
      Question actual = questionServiceMock.add(QUESTION, ANSWER);
      when(questionServiceMock.add(actual)).thenReturn(actual);

    assertEquals(actual, questionServiceMock.add(actual));
    }

    @Test
    public void shouldRemoveQuestion() {
      Question actual = questionServiceMock.add(QUESTION, ANSWER);
      when(questionServiceMock.remove(actual)).thenReturn(actual);
      assertEquals(actual, questionServiceMock.remove(actual));
    }

    @Test
    public void shouldGetAllCollectionOfQuestions() {
      when(questionServiceMock.getAll()).thenReturn(QUESTION_PROGRAMMING_DATA);

      assertEquals(QUESTION_PROGRAMMING_DATA, questionServiceMock.getAll());
    }


    @Test
    public void shouldGetRandomQuestion() {
      Question actual = questionServiceMock.add(QUESTION, ANSWER);
      when(questionServiceMock.getRandomQuestion()).thenReturn(actual);
      assertEquals(actual, questionServiceMock.getRandomQuestion());
    }
}
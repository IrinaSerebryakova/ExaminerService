package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.exception.RequestedMoreQuestionsThanExistInServiceException;
import pro.sky.java.course2.examinerservice.model.Question;
import pro.sky.java.course2.examinerservice.service.api.QuestionService;
import pro.sky.java.course2.examinerservice.service.impl.ExaminerServiceImpl;
import pro.sky.java.course2.examinerservice.service.impl.JavaQuestionServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static pro.sky.java.course2.examinerservice.QuestionTestConstants.QUESTION_PROGRAMMING_DATA;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
  @Mock
  JavaQuestionServiceImpl questionService = mock(JavaQuestionServiceImpl.class);
private final Question QUESTION_TEST_1 = new Question("Что такое алгоритм?","Это конечный набор шагов, которые при следовании им решают какую-то задачу.");
    private final Question QUESTION_TEST_2 =  new Question("Что такое константы?", "Константа – это величина, значение которой невозможно изменить. В отличие" +
            " от переменной, значение, хранящееся в константе, не может быть изменено во время выполнения программы.");
            @InjectMocks
  ExaminerServiceImpl examinerService;

  @Test
  public void getQuestion() {
      Mockito.when(questionService.getAll())
              .thenReturn(QUESTION_PROGRAMMING_DATA);
      Mockito.when(questionService.getRandomQuestion())
           .thenReturn(QUESTION_TEST_1, QUESTION_TEST_2);

    Collection<Question> question = examinerService.getQuestion(2);
    assertTrue(QUESTION_PROGRAMMING_DATA.containsAll(question));

  }

  @Test
  void shouldThrowRequestedMoreQuestionsThanExistInServiceException(){
      assertThrows(RequestedMoreQuestionsThanExistInServiceException.class,
            () -> examinerService.getQuestion(6));
  }
}
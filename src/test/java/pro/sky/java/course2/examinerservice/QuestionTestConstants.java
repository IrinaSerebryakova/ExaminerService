package pro.sky.java.course2.examinerservice;
import java.util.ArrayList;
import java.util.List;

public class QuestionTestConstants {
    public final static String QUESTION = "Назовите концепции объектно-ориентированного программирования JAVA";
    public final static String ANSWER = "Наследование, инкапсуляция, полиморфизм, абстракция";

    public final static List<Question> QUESTION_JAVA_DATA = new ArrayList<>(List.of(
            new Question("Назовите концепции объектно-ориентированного программирования JAVA",
                    "Наследование, инкапсуляция, полиморфизм, абстракция"),
            new Question("Что такое наследование?", "В JAVA один класс может наследовать" +
                    " другой класс. Таким образом можно переиспользовать код класса, от которого наследуются."),
            new Question("Что такое инкапсуляция?","Инкапсуляция — это сокрытие реализации" +
                    " при помощи модификаторов доступа, при помощи геттеров и сеттеров. Это делается для" +
                    " того, чтобы закрыть доступ для внешнего использования в тех местах, где разработчики считают нужным.")
            ));

    public final static List<Question> QUESTION_PROGRAMMING_DATA = new ArrayList<>(List.of(
            new Question("Что такое алгоритм?","Это конечный набор шагов, которые при следовании им решают какую-то задачу."),
            new Question("Что такое переменные?", "Переменные — это именованные ячейки памяти, которые используются для" +
                    " хранения входных данных программы и результатов ее вычислений. Значение переменной может меняться во" +
                    " время выполнения программы."),
            new Question("Что такое цикл?","Цикл — это структура, которая может повторять набор операторов" +
                    " фиксированное количество раз или до тех пор, пока не будет выполнен определенный критерий."),
            new Question("Как работает компилятор?", "Компилятор — это программа, которая может обрабатывать инструкции," +
                    " написанные на определенном языке программирования, и превращать их в машинный язык или «код»."),
            new Question("Что такое константы?", "Константа – это величина, значение которой невозможно изменить. В отличие" +
                    " от переменной, значение, хранящееся в константе, не может быть изменено во время выполнения программы.")
    ));
}

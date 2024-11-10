package pro.sky.java.course2.examinerservice;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {

    public static List<Question> questionJavaData = new ArrayList<>(List.of(
            new Question("Назовите концепции объектно-ориентированного программирования JAVA",
                    "Наследование, инкапсуляция, полиморфизм, абстракция"),
            new Question("Что такое наследование?", "В JAVA один класс может наследовать" +
                    " другой класс. Таким образом можно переиспользовать код класса, от которого наследуются."),
            new Question("Что такое инкапсуляция?","Инкапсуляция — это сокрытие реализации" +
                    " при помощи модификаторов доступа, при помощи геттеров и сеттеров. Это делается для" +
                    " того, чтобы закрыть доступ для внешнего использования в тех местах, где разработчики считают нужным."),
            new Question("Что такое полиморфизм?","Полиморфизм — это способность программы" +
                    " идентично использовать объекты с одинаковым интерфейсом без информации о конкретном" +
                    " типе этого объекта. Один интерфейс — множество реализаций. При помощи полиморфизма" +
                    " можно объединять и использовать разные типы объектов по их общему поведению."),
            new Question("Что такое конструктор в Java?","Когда новый объект создается," +
                    " программа использует для этого соответствующий конструктор. Конструктор похож на метод." +
                    " Его особенность заключается в том, что нет возвращающего элемента (в том числе и void)," +
                    " а его имя совпадает с именем класса. Если не пишется никакого конструктора явно," +
                    " пустой конструктор будет создан автоматически. Если был создан конструктор с параметрами," +
                    " а нужен еще и без параметров, его нужно писать отдельно, так как он не создается автоматически."),
            new Question("Какие два класса не наследуются от Object?",
                    "Нет таких классов: все классы прямо или через предков наследуются от класса Object!"),
            new Question("Что такое модификаторы доступа?","Модификаторы доступа — это инструмент," +
                    " при помощи которого можно настроить доступ к классам, методам и переменным. private —" +
                    " уровень доступа — только класс, внутри которого он объявлен. package-private(default) —" +
                    " доступ только в конкретном пакете (package), в котором объявлен класс, метод, переменная, конструктор." +
                    " protected — такой же доступ, как и package-private для класса и его наследников" +
                    " public — полноценный доступ во всем приложении.")
    ));

    public static List<Question> questionProgrammingData = new ArrayList<>(List.of(
             new Question("Что такое алгоритм?","Это конечный набор шагов, которые при следовании им решают какую-то задачу."),
             new Question("Что такое переменные?", "Переменные — это именованные ячейки памяти, которые используются для" +
                     " хранения входных данных программы и результатов ее вычислений. Значение переменной может меняться во" +
                     " время выполнения программы."),
            new Question("Что такое зарезервированные слова?", "Это ключевые слова в языке программирования, которые уже имеют" +
                    " определенные значения. И не могут использоваться для других целей на этом языке программирования. Это названия" +
                    " модификаторов доступа, циклов, условных операторов, наименование целочисленных, вещественных, булевых переменных в Java и т.д."),
            new Question("Что такое цикл?","Цикл — это структура, которая может повторять набор операторов" +
                    " фиксированное количество раз или до тех пор, пока не будет выполнен определенный критерий."),
            new Question("Как работает компилятор?", "Компилятор — это программа, которая может обрабатывать инструкции," +
                    " написанные на определенном языке программирования, и превращать их в машинный язык или «код»."),
            new Question("Что такое константы?", "Константа – это величина, значение которой невозможно изменить. В отличие" +
                    " от переменной, значение, хранящееся в константе, не может быть изменено во время выполнения программы.")
    ));
}

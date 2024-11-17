package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.service.impl.JavaQuestionServiceImpl;
import pro.sky.java.course2.examinerservice.model.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController{
    private final JavaQuestionServiceImpl javaQuestionService;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionService){
        this.javaQuestionService = javaQuestionService;

    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam ("answer") String answer){
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam ("answer") String answer){
        Question remove = new Question(question, answer);
        return javaQuestionService.remove(remove);
    }

    @GetMapping
    public Collection<Question> getAll(){
        return javaQuestionService.getAll();
    }
}

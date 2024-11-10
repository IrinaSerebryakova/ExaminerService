package pro.sky.java.course2.examinerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController{

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService){
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
    public List<Question> getAll(){
        return javaQuestionService.getAll();
    }
}

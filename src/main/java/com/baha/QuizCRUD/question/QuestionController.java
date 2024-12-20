package com.baha.QuizCRUD.question;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions() {
                return questionService.getAllQuestions();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Question> getQuestionsById(@PathVariable int id) {
        return questionService.getQuestionsById(id);
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/new")
    public String addQuestions(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }

    @PostMapping("/update/{id}")
    public String saveQuestion(@PathVariable int id, @RequestBody Question updatedQuestion) {
        return questionService.saveQuestion(id,updatedQuestion);
    }

}

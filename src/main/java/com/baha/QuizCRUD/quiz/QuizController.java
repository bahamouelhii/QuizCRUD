package com.baha.QuizCRUD.quiz;

import com.baha.QuizCRUD.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<List<Question>> listQuiz(@PathVariable int id) {
        return quizService.listQuiz(id);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("score/{id}")
    public ResponseEntity<Integer> scoreQuiz(@PathVariable int id, @RequestBody List<Response> responses) {
        return quizService.getScore(id,responses);
    }


}
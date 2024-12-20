package com.baha.QuizCRUD.quiz;

import com.baha.QuizCRUD.question.Question;
import com.baha.QuizCRUD.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionByCategory(category,numQ);
        Quiz quiz;
        quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> listQuiz(int id) {
        List<Question> questions = questionRepository.findQuestionByQuiz(id);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(int id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int i = 0 ;
        int score = 0 ;
        for (Response r : responses){
            Question correspondingQuestion = questions.stream().filter(q -> q.getId() == r.getId()).findFirst().orElse(null);

            assert correspondingQuestion != null;

            if (r.getAnswer().equals(correspondingQuestion.getRightAnswer())){
                score ++;
            }
            i++;
        }

        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}


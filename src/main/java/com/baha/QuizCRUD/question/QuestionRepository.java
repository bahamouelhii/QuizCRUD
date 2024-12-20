package com.baha.QuizCRUD.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);


    List<Question> findByDifficulty(String difficulty);


    List<Question> findByCategoryAndDifficulty(String category, String difficulty);

    @Query(value = "SELECT * FROM questions WHERE category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);

    @Query(value = "SELECT A.* FROM questions A, quiz_questions B  WHERE B.quiz_id = :id and A.id = B.questions_id ORDER BY A.id", nativeQuery = true)
    List<Question> findQuestionByQuiz(int id);
}


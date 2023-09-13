package com.example.individual.repository;

import com.example.individual.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("SELECT q FROM Question q WHERE q.quizId IN :quizId")
    List<Question> findQuestionsByChatId(int quizId);
}

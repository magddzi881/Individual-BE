package com.example.individual.repository;

import com.example.individual.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    @Query("SELECT q FROM Quiz q WHERE q.studyMaterialId IN :studyMaterialId")
    Quiz findQuizByStudyMaterial(int studyMaterialId);
}

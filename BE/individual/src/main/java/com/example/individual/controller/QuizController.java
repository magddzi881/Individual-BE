package com.example.individual.controller;

import com.example.individual.model.Quiz;
import com.example.individual.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable int id) {
        return quizRepository.findById(id).orElse(null);
    }

    @GetMapping("/getQuizByStudyMaterialId/{studyMaterialId}")
    public Quiz getQuizByStudyMaterialId(@PathVariable int studyMaterialId) {
        return quizRepository.findQuizByStudyMaterial(studyMaterialId);
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable int id, @RequestBody Quiz updatedQuiz) {
        Quiz existingQuiz = quizRepository.findById(id).orElse(null);
        if (existingQuiz != null) {
            existingQuiz.setTutorUsername(updatedQuiz.getTutorUsername());
            existingQuiz.setPoints(updatedQuiz.getPoints());
            existingQuiz.setQuestionCount(updatedQuiz.getQuestionCount());
            existingQuiz.setstudyMaterialId(updatedQuiz.getstudyMaterialId());
            return quizRepository.save(existingQuiz);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable int id) {
        quizRepository.deleteById(id);
    }
}

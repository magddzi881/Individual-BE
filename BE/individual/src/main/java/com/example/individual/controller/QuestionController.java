package com.example.individual.controller;

import com.example.individual.model.Question;
import com.example.individual.model.StudyMaterial;
import com.example.individual.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable int id) {
        return questionRepository.findById(id).orElse(null);
    }
    @GetMapping("/byQuizId/{quizId}")
    public List<Question> getQuestionsByCHatId(@PathVariable int quizId) {
        return questionRepository.findQuestionsByChatId(quizId);
    }
    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable int id, @RequestBody Question updatedQuestion) {
        Question existingQuestion = questionRepository.findById(id).orElse(null);
        if (existingQuestion != null) {
            existingQuestion.setQuizId(updatedQuestion.getQuizId());
            existingQuestion.setTitle(updatedQuestion.getTitle());
            existingQuestion.setAnswer1(updatedQuestion.getAnswer1());
            existingQuestion.setAnswer2(updatedQuestion.getAnswer2());
            existingQuestion.setAnswer3(updatedQuestion.getAnswer3());
            existingQuestion.setAnswer4(updatedQuestion.getAnswer4());
            existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
            return questionRepository.save(existingQuestion);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable int id) {
        questionRepository.deleteById(id);
    }
}

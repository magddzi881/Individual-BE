package com.example.individual.controller;

import com.example.individual.model.StudyMaterial;
import com.example.individual.repository.StudyMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/study-materials")
public class StudyMaterialController {

    private final StudyMaterialRepository studyMaterialRepository;

    @Autowired
    public StudyMaterialController(StudyMaterialRepository studyMaterialRepository) {
        this.studyMaterialRepository = studyMaterialRepository;
    }
    @PostMapping("/by-ids")
    public List<StudyMaterial> getStudyMaterialsByIds(@RequestBody List<Integer> ids) {
        return studyMaterialRepository.findListByIds(ids);
    }
    @GetMapping("/by-tutor/{tutorUsername}")
    public List<StudyMaterial> getStudyMaterialsByTutor(@PathVariable String tutorUsername) {
        return studyMaterialRepository.findListByTutor(tutorUsername);
    }

    @GetMapping
    public List<StudyMaterial> getAllStudyMaterials() {
        return studyMaterialRepository.findAll();
    }

    @GetMapping("/{id}")
    public StudyMaterial getStudyMaterialById(@PathVariable int id) {
        return studyMaterialRepository.findById(id).orElse(null);
    }

    @PostMapping
    public StudyMaterial createStudyMaterial(@RequestBody StudyMaterial studyMaterial) {
        return studyMaterialRepository.save(studyMaterial);
    }

    @PutMapping("/{id}")
    public StudyMaterial updateStudyMaterial(@PathVariable int id, @RequestBody StudyMaterial updatedStudyMaterial) {
        StudyMaterial existingStudyMaterial = studyMaterialRepository.findById(id).orElse(null);
        if (existingStudyMaterial != null) {
            existingStudyMaterial.setText(updatedStudyMaterial.getText());
            existingStudyMaterial.setTutorUsername(updatedStudyMaterial.getTutorUsername());
            existingStudyMaterial.setCategory(updatedStudyMaterial.getCategory());

            return studyMaterialRepository.save(existingStudyMaterial);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudyMaterial(@PathVariable int id) {
        studyMaterialRepository.deleteById(id);
    }
}

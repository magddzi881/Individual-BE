package com.example.individual.repository;

import com.example.individual.model.StudyMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyMaterialRepository extends JpaRepository<StudyMaterial, Integer> {
    @Query("SELECT sm FROM StudyMaterial sm WHERE sm.id IN :ids")
    List<StudyMaterial> findListByIds(List<Integer> ids);
    @Query("SELECT sm FROM StudyMaterial sm WHERE sm.tutorUsername IN :tutorUsername")
    List<StudyMaterial> findListByTutor(String tutorUsername);
}

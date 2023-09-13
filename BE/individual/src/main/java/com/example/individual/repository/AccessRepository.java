package com.example.individual.repository;

import com.example.individual.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessRepository extends JpaRepository<Access, Integer> {
    @Query("SELECT a.studyMaterialId FROM Access a WHERE a.to = :to")
    List<Integer> findStudyMaterialIdsByToUser(@Param("to") String toUser);
    @Query("SELECT a.studyMaterialId FROM Access a WHERE a.from = :from")
    List<Integer> findStudyMaterialIdsByFromUser(@Param("from") String toUser);

    @Query("SELECT a FROM Access a WHERE  a.studyMaterialId = :studyMaterialId")
    List<Access> findByToUserAndStudyMaterialId(

            @Param("studyMaterialId") int studyMaterialId
    );
}

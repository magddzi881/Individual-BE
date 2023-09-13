package com.example.individual.controller;

import com.example.individual.model.Access;
import com.example.individual.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accesses")
public class AccessController {

    private final AccessRepository accessRepository;

    @Autowired
    public AccessController(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    @GetMapping
    public List<Access> getAllAccess() {
        return accessRepository.findAll();
    }

    @GetMapping("/{id}")
    public Access getAccessById(@PathVariable int id) {
        return accessRepository.findById(id).orElse(null);
    }
    @GetMapping("/studyMaterialIdsByToUser")
    public List<Integer> getStudyMaterialIdsByToUser(@RequestParam String toUser) {
        return accessRepository.findStudyMaterialIdsByToUser(toUser);
    }
    @GetMapping("/studyMaterialIdsByFromUser")
    public List<Integer> getStudyMaterialIdsByFromUser(@RequestParam String fromUser) {
        return accessRepository.findStudyMaterialIdsByFromUser(fromUser);
    }
    @GetMapping("/byMaterial/{studyMaterialId}")
    public List<Access> getAccessesByToUserAndStudyMaterialId(

            @PathVariable int studyMaterialId
    ) {
      return accessRepository.findByToUserAndStudyMaterialId( studyMaterialId);
    }


    @PostMapping
    public Access createAccess(@RequestBody Access access) {
        return accessRepository.save(access);
    }

    @PutMapping("/{id}")
    public Access updateAccess(@PathVariable int id, @RequestBody Access updatedAccess) {
        Access existingAccess = accessRepository.findById(id).orElse(null);
        if (existingAccess != null) {
            existingAccess.setFrom(updatedAccess.getFrom());
            existingAccess.setTo(updatedAccess.getTo());
            existingAccess.setStudyMaterialId(updatedAccess.getStudyMaterialId());
            return accessRepository.save(existingAccess);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccess(@PathVariable int id) {
        accessRepository.deleteById(id);
    }
}

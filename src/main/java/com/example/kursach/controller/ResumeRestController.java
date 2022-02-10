package com.example.kursach.controller;

import com.example.kursach.config.converter.ResumeConverter;
import com.example.kursach.model.Resume;
import com.example.kursach.model.dto.ResumeDto;
import com.example.kursach.service.ResumeService;
import com.example.kursach.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/resume")
@AllArgsConstructor
public class ResumeRestController {

    private ResumeConverter resumeConverter;
    private ResumeService resumeService;
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody ResumeDto resumeDto) {
        Resume resume = resumeConverter.toEntity(resumeDto);
        resumeService.save(resume);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserResume() {
        resumeService.deleteByUserLogin();
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        resumeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/myResume")
    public ResponseEntity<?> get() {
        Resume resume = resumeService.findSummaryForAuthUser();
        if (resume == null) {
            return ResponseEntity.ok("Резюме не найдено");
        }

        return ResponseEntity.ok(resumeConverter.toDto(resume));
    }

    @GetMapping("/allPublishedResume")
    public ResponseEntity<?> findAllPublishedResume() {
        return ResponseEntity.ok(resumeService.findAllPublishedResume().stream().map(resumeConverter::toDto));
    }

    @GetMapping("/allResume")
    public ResponseEntity<?> findAllResume() {
        List<Resume> resumes = resumeService.findAll();

        if (resumes.isEmpty()) {
            return ResponseEntity.ok("Резюме не найдено");
        }
        return ResponseEntity.ok(resumes.stream().map(resumeConverter::toDto));
    }
}

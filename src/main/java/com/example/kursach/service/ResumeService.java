package com.example.kursach.service;

import com.example.kursach.model.Resume;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResumeService {

    void save(Resume resume);

    void delete(Long id);

    Resume findSummaryForAuthUser();

    List<Resume> findAllPublishedResume();

    List<Resume> findAll();

    void deleteByUserLogin();
}

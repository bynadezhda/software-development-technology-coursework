package com.example.kursach.service;

import com.example.kursach.model.Resume;
import com.example.kursach.repository.ResumeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private ResumeRepository resumeRepository;
    private UserService userService;

    @Override
    @Transactional
    public void save(Resume resume) {
        if (resumeRepository.existsByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName())) {
            resume.setId(resumeRepository.findByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
        }
        resume.setUser(userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
        resumeRepository.save(resume);
    }

    @Override
    @Transactional
    public Resume findSummaryForAuthUser() {
        return resumeRepository.findByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Resume resume = resumeRepository.findById(id).orElseThrow();
        resumeRepository.delete(resume);
    }

    @Override
    @Transactional
    public List<Resume> findAllPublishedResume() {
        return resumeRepository.findAllByVisibility(true);
    }

    @Override
    @Transactional
    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteByUserLogin() {
        resumeRepository.deleteByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
